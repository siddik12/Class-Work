package com.rockscoder.employeemad33;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsActivity extends AppCompatActivity {

    TextView textViewName, textViewAge,textViewGender, textViewPhone,textViewType, textViewSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);
        textViewGender = findViewById(R.id.textViewGender);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewType = findViewById(R.id.textViewType);
        textViewSkills = findViewById(R.id.textViewSkills);

        Intent i = getIntent();
        //String name = i.getStringExtra("name");
        //String age = i.getStringExtra("age");
        //String phone = i.getStringExtra("phone");

        Employee employee = (Employee) i.getSerializableExtra("emp");

        textViewName.setText(employee.getEmpName());
        textViewAge.setText(employee.getEmpAge());
        textViewGender.setText(employee.getEmpGender());
        textViewType.setText(employee.getEmpType());
        textViewPhone.setText(employee.getEmpPhone());

        String skills  = TextUtils.join(", ",employee.getSkills());
        textViewSkills.setText(skills);

    }
}
