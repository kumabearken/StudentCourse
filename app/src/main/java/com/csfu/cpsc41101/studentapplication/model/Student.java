package com.csfu.cpsc41101.studentapplication.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected int CWID;
    protected ArrayList<CourseEnrollment> mCourseEnrollments;

    public Student(String fName, String lName, int id) {
        mFirstName = fName;
        mLastName = lName;
        CWID = id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getCWID() {
        return CWID;
    }

    public void setCWID(int id) { CWID = id; }

    public ArrayList<CourseEnrollment> getCourseEnrollments() {
        return mCourseEnrollments;
    }

    public void setCourseEnrollments(ArrayList<CourseEnrollment> courseEnrollments) {
        mCourseEnrollments = courseEnrollments;
    }
}
