package com.csfu.cpsc41101.studentapplication.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> mPeople;

    static public StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB() {
        createPersonObjects();
    }

    public ArrayList<Student> getPeople() {
        return mPeople;
    }

    public void setPeople(ArrayList<Student> people) {
        mPeople = people;
    }

    public void addStudent(String first,String last,String cwid,String cid, String grade){
        Student p = new Student(first, last, Integer.parseInt(cwid));
        ArrayList<CourseEnrollment> courseEnrollments = new ArrayList<CourseEnrollment>();
        courseEnrollments.add(new CourseEnrollment(cid,grade));
        p.setCourseEnrollments(courseEnrollments);
        mPeople.add(p);
    }
    protected void createPersonObjects() {
        // Create James Student object
        Student p = new Student("Ral","Mousr",1234 );
        ArrayList<CourseEnrollment> courseEnrollments = new ArrayList<CourseEnrollment>();
        courseEnrollments.add(new CourseEnrollment("CPSC1", "C"));
        p.setCourseEnrollments(courseEnrollments);
        mPeople = new ArrayList<Student>();
        mPeople.add(p);
        // Create Another Student
        p = new Student("Fake", "Car",1233);
        courseEnrollments = new ArrayList<CourseEnrollment>();
        courseEnrollments.add(new CourseEnrollment("CPSC2","C"));
        p.setCourseEnrollments(courseEnrollments);
        mPeople.add(p);
        //
        //StudentDB.getInstance().setPeople(personList);
    }

}
