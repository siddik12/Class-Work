package com.rockscoder.employeemad33;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class EmployeeDetailsActivity extends AppCompatActivity {

    TextView textViewName,textViewCity, textViewAge,textViewGender, textViewPhone,textViewType,textViewStartTime,textViewEndTime, textViewSkills;

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
        textViewCity = findViewById(R.id.textViewCity);
        textViewStartTime = findViewById(R.id.textViewStartTime);
        textViewEndTime = findViewById(R.id.textViewEndTime);

        Intent i = getIntent();
        //String name = i.getStringExtra("name");
        //String age = i.getStringExtra("age");
        //String phone = i.getStringExtra("phone");

        Employee employee = (Employee) i.getSerializableExtra("emp");

        textViewName.setText(employee.getEmpName());
        textViewAge.setText(employee.getEmpAge());
        textViewGender.setText(employee.getEmpGender());
        textViewType.setText(employee.getEmpType());
        textViewStartTime.setText(employee.getEmpPhone());
        textViewPhone.setText(employee.getStartTimeData());
        textViewEndTime.setText(employee.getEndTimeData());

        String skills  = TextUtils.join(", ",employee.getSkills());
        textViewSkills.setText(skills);
        textViewCity.setText(employee.getEmpCity());

    }
}
