package com.example.maverick_workout_tracker;

public class reviewHelper {
    String instructorName, memberName, reviewComments;



    String noOfStars;

    public reviewHelper(String instructorName, String memberName, String reviewComments, String noOfStars) {
        this.instructorName = instructorName;
        this.memberName = memberName;
        this.reviewComments = reviewComments;
        this.noOfStars = noOfStars;
    }

    public reviewHelper(){

    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public String getNoOfStars() {
        return noOfStars;
    }

    public void setNoOfStars(String noOfStars) {
        this.noOfStars = noOfStars;
    }

}

