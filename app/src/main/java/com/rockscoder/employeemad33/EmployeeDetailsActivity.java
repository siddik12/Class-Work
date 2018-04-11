package com.rockscoder.employeemad33;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDetailsActivity extends AppCompatActivity {

    TextView textViewName, textViewCity, textViewAge, textViewGender, textViewPhone, textViewType, textViewStartTime, textViewEndTime, textViewSkills;

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

        final Employee employee = (Employee) i.getSerializableExtra("emp");

        textViewName.setText(employee.getEmpName());
        textViewAge.setText(employee.getEmpAge());
        textViewGender.setText(employee.getEmpGender());
        textViewType.setText(employee.getEmpType());
        textViewStartTime.setText(employee.getEmpPhone());
        textViewPhone.setText(employee.getEmpPhone());
        textViewStartTime.setText(employee.getStartTimeData());
        textViewEndTime.setText(employee.getEndTimeData());

        String skills = TextUtils.join(", ", employee.getSkills());
        textViewSkills.setText(skills);
        textViewCity.setText(employee.getEmpCity());

        textViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + employee.getEmpPhone()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    if (ActivityCompat.checkSelfPermission(EmployeeDetailsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.

                        ActivityCompat.requestPermissions(EmployeeDetailsActivity.this,new String[]{Manifest.permission.CALL_PHONE},100);

                        return;
                    }
                    startActivity(intent);
                }else{
                    Toast.makeText(EmployeeDetailsActivity.this,"No component found!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
