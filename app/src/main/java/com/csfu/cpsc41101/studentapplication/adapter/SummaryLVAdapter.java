package com.csfu.cpsc41101.studentapplication.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csfu.cpsc41101.studentapplication.StudentDetailActivity;
import com.csfu.cpsc41101.studentapplication.R;
import com.csfu.cpsc41101.studentapplication.model.Student;
import com.csfu.cpsc41101.studentapplication.model.StudentDB;

public class SummaryLVAdapter extends BaseAdapter {

    //protected int cnt = 0;

    @Override
    public int getCount() {
        return StudentDB.getInstance().getPeople().size();
    }

    @Override
    public Object getItem(int i) {
        return StudentDB.getInstance().getPeople().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;

        if (view == null) {
            // cnt++;
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.person_row, viewGroup, false);
        } else row_view = view;

        Student p = StudentDB.getInstance().getPeople().get(i);

        TextView firstNameView = (TextView) row_view.findViewById(R.id.first_name);
        firstNameView.setText(p.getFirstName());
        TextView lastNameView = (TextView) row_view.findViewById(R.id.last_name);
        lastNameView.setText(p.getLastName());
        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //
                        Intent intent = new Intent(view.getContext(), StudentDetailActivity.class);
                        intent.putExtra("PersonIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );

        return row_view;
    }
}
