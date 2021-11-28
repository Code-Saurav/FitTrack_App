package com.example.maverick_workout_tracker;

public class helper {

    String hfullName, hemail, hphone, hpassword;
    Boolean hIsMember, hIsPremium, hIsInstructor;

    public helper(String hfullName, String hemail, String hphone, String hpassword, Boolean hIsMember, Boolean hIsPremium, Boolean hIsInstructor) {
        this.hfullName = hfullName;
        this.hemail = hemail;
        this.hphone = hphone;
        this.hpassword = hpassword;
        this.hIsMember = hIsMember;
        this.hIsPremium = hIsPremium;
        this.hIsInstructor = hIsInstructor;
    }

    public helper() {
    }

    public String getHfullName() {
        return hfullName;
    }

    public void setHfullName(String hfullName) {
        this.hfullName = hfullName;
    }

    public String getHemail() {
        return hemail;
    }

    public void setHemail(String hemail) {
        this.hemail = hemail;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getHpassword() {
        return hpassword;
    }

    public void setHpassword(String hpassword) {
        this.hpassword = hpassword;
    }

    public Boolean gethIsMember() {
        return hIsMember;
    }

    public void sethIsMember(Boolean hIsMember) {
        this.hIsMember = hIsMember;
    }

    public Boolean gethIsPremium() {
        return hIsPremium;
    }

    public void sethIsPremium(Boolean hIsPremium) {
        this.hIsPremium = hIsPremium;
    }

    public Boolean gethIsInstructor() {
        return hIsInstructor;
    }

    public void sethIsInstructor(Boolean hIsInstructor) {
        this.hIsInstructor = hIsInstructor;
    }
}
