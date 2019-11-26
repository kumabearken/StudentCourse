package com.csfu.cpsc41101.studentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csfu.cpsc41101.studentapplication.model.CourseEnrollment;
import com.csfu.cpsc41101.studentapplication.model.Student;
import com.csfu.cpsc41101.studentapplication.model.StudentDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected Menu menus;
    protected LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPersonObjects();
        setContentView(R.layout.person_summary);

        root = findViewById(R.id.person_summary);

        ArrayList<Student> studentList = StudentDB.getInstance().getPeople();
        for (int i = 0; i< studentList.size(); i++) {
            Student p = studentList.get(i);
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.person_row, root, false);
            TextView firstNameView = (TextView) row_view.findViewById(R.id.first_name);
            firstNameView.setText(p.getFirstName());
            TextView lastNameView = (TextView) row_view.findViewById(R.id.last_name);
            lastNameView.setText(p.getLastName());
            //
            root.addView(row_view);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        menus = menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void createPersonObjects() {
        // Create James Student object
        Student p = new Student("Test" ,"Marshmallow", 1234);
        ArrayList<CourseEnrollment> courseEnrollments = new ArrayList<CourseEnrollment>();
        courseEnrollments.add(new CourseEnrollment("CPSC1", "C"));
        p.setCourseEnrollments(courseEnrollments);
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(p);
        // Create Another Student
        p = new Student("John", "Chang",1233);
        courseEnrollments = new ArrayList<CourseEnrollment>();
        courseEnrollments.add(new CourseEnrollment("CPSC2","C"));
        p.setCourseEnrollments(courseEnrollments);
        studentList.add(p);
        //
        StudentDB.getInstance().setPeople(studentList);
    }

}
