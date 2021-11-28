package com.example.maverick_workout_tracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
/*
 readFileFromInternalStorage(getApplicationContext(), FILENAME);
 .../data/user/0/com.example.mycalendar/files/events

 https://exerror.com/installed-build-tools-revision-31-0-0-is-corrupted-remove-and-install-again-using-the-sdk-manager/
 https://developer.android.com/studio/intro/studio-config?utm_source=android-studio#antivirus-impact
 */
public class calanderActivity<EVENT_PROJECTION, uri, selection, selectionArgs, cur> extends AppCompatActivity {
    String FILENAME = "events";
    HashMap<String, String>events = new HashMap<String, String>();
    int lastYear = -1, lastMonth = -1, lastDayOfMonth = -1;
    int dateChosen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);

//        String url = "www.foxnews.com";
//        if (!url.startsWith("http://") && !url.startsWith("https://"))
//            url = "http://" + url;
//
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        startActivity(browserIntent);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            String id = intent.getExtras().getString("id");

            if (id != null && id.length() > 0)
                FILENAME = id;
        }
        readFileFromInternalStorage(this, FILENAME);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendar);
        EditText editText = (EditText) findViewById(R.id.etComments);


        Calendar cal = Calendar.getInstance();
        lastYear = cal.get(Calendar.YEAR);
        lastMonth = cal.get(Calendar.MONTH);
        lastDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        String event = events.get(String.format("%02d%02d%04d", (lastMonth + 1), lastDayOfMonth, lastYear));
        if (event != null)
            editText.setText(event);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast
                // Toast.makeText(getApplicationContext(), (month+1) + "/" + dayOfMonth + "/" + year, Toast.LENGTH_LONG).show();
                Editable editTextString = editText.getText();
                events.put(String.format("%02d%02d%04d", (lastMonth + 1), lastDayOfMonth, lastYear), editTextString.toString());
                String event = events.get(String.format("%02d%02d%04d", (month + 1), dayOfMonth, year));
                if (event != null)
                    editText.setText(event);
                else
                    editText.setText("");
                //displayDialog();
                lastMonth = month;
                lastYear = year;
                lastDayOfMonth = dayOfMonth;
                dateChosen++;
                if ((dateChosen % 4) == 0)
                    open(view);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("OnStop");
        EditText editText = (EditText) findViewById(R.id.etComments);

        Editable editTextString = editText.getText();

        events.put(String.format("%02d%02d%04d", (lastMonth + 1), lastDayOfMonth, lastYear), editTextString.toString());

        writeFileToInternalStorage(this, FILENAME);
    }
    public void readline(FileReader reader, StringBuffer sb) {
        int chr;

        try {
            while ((chr = reader.read()) != -1) {
                if ((char)chr == '\n') {
                    break;
                } else {
                    sb.append((char)chr);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readBytes(FileReader reader, StringBuffer sb, int numberOfBytes) {
        int chr;

        try {
            while ((chr = reader.read()) != -1) {
                sb.append((char)chr);
                if (sb.length() == numberOfBytes)
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readFileFromInternalStorage(Context mcoContext, String sFileName){
        System.out.println("ReadFileFromInternalStorage ...");

        try {
            File dir = new File(mcoContext.getFilesDir(), "events");
            if (dir.exists()) {
//                File [] fileList = dir.listFiles();
//
//                for (int i = 0; i < fileList.length; i++) {
//                    System.out.println(String.format("File [%d]: %s", i + 1, fileList[i].getAbsolutePath()));
//                    if (fileList[i].getAbsolutePath().equals("/data/user/0/com.example.mycalendar/files/events/C:\\tmp\\events.txt") ||
//                        fileList[i].getAbsolutePath().equals("/data/user/0/com.example.mycalendar/files/events/events1")
//                    )
//                        fileList[i].delete();
//                }
                File gpxfile = new File(dir, sFileName);
                if (gpxfile.exists() && gpxfile.canRead()) {
                    FileReader reader = new FileReader(gpxfile);
                    StringBuffer buffer = new StringBuffer();
                    int numberOfRecords = -1;
                    int maxRecordLength = -1;
                    readline(reader, buffer);
                    if (buffer.toString().trim().length() > 0) {
                        String[] parts = buffer.toString().split(",");

                        if (parts.length == 2) {
                            numberOfRecords = Integer.parseInt(parts[0]);
                            maxRecordLength = Integer.parseInt(parts[1]);

                            if (numberOfRecords > 0 && maxRecordLength > 0) {
                                String[] recordData = new String[numberOfRecords];
                                for (int i = 0; i < numberOfRecords; i++) {
                                    buffer = new StringBuffer();
                                    readline(reader, buffer);

                                    recordData[i] = buffer.toString();
                                }
                                events.clear();
                                for (int i = 0; i < numberOfRecords; i++) {
                                    parts = recordData[i].split(",");
                                    int numberOfBytesToRead = Integer.parseInt(parts[1]);
                                    buffer = new StringBuffer();
                                    readBytes(reader, buffer, numberOfBytesToRead);
                                    events.put(parts[0], buffer.toString());
                                }
                            }
                        }
                    }
                    reader.close();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private int getMaxRecLength(Iterator iter) {
        int maxLength = 0;

        while (iter.hasNext()) {
            String key = (String)iter.next();
            String value = events.get(key);

            if (value.trim().length() > maxLength)
                maxLength = value.trim().length();
        }
        return maxLength;
    }
    public void writeFileToInternalStorage(Context mcoContext, String sFileName){
        System.out.println("WriteFileToInternalStorage ...");

        try {
            File dir = new File(mcoContext.getFilesDir(), "events");
            StringBuffer sb = new StringBuffer();

            if(!dir.exists()){
                dir.mkdir();
                System.out.println("Making ..." + dir.getAbsolutePath());
            }
            int maxRecLength = getMaxRecLength(events.keySet().iterator());
            String header = String.format("%d,%d\n",events.size(),maxRecLength+1);
            File gpxfile = new File(dir, sFileName);
            System.out.println("WriteFileToInternalStorage ..." + gpxfile.getAbsolutePath());
            FileWriter writer = new FileWriter(gpxfile);

            writer.append(header);

            for (int i = 0; i < 2; i++) {
                Iterator keys = events.keySet().iterator();

                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if (i == 0)
                        writer.append(String.format("%s,%d\n", key, events.get(key).trim().length() + 1));
                    else
                        writer.append(String.format("%s\n", events.get(key).trim()));
                }
            }
            writer.flush();
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void open(View view){
        /*
        String [][] ads = {
                            {"GNC"},

        };
         */
        String [] ads = getResources().getStringArray(R.array.ads);
        String [] urls = getResources().getStringArray(R.array.ad_urls);

        if (ads.length < urls.length) {
            String [] newads = new String[urls.length];

            for (int i = 0; i < newads.length; i++) {
                newads[i] = urls[i];
            }
            ads = newads;
        }
        Random random = new Random();
        int adNumber = random.nextInt(ads.length);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(ads[adNumber]);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(calanderActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                String url = urls[adNumber];

                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
                dialog.dismiss();
            }
        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.setNeutralButton("Close",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}

