package com.rockscoder.employeemad33;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextPhone;
    private List<String> skills = new ArrayList<>();
    private String gender = "Male";
    private String dob = "";
    private String city = "";
    private String empType = "Base Salaried Employee";
    private RadioGroup genderRG,employeeTypeRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextPhone = findViewById(R.id.editTextPhone);

        genderRG = findViewById(R.id.genderRG);

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                gender = radioButton.getText().toString();
                //showToast(gender);
            }
        });

        employeeTypeRG = findViewById(R.id.employeeTypeRG);
        employeeTypeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                empType = radioButton.getText().toString();
                //showToast(gender);
            }
        });

    }

    public void registerEmployee(View view) {
        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();
        String phone = editTextPhone.getText().toString();


        Employee employee = new Employee(name, age,dob,gender,phone,empType,city,skills);

        List<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee);

        Intent intent = new Intent(this, EmployeeDetailsActivity.class);
        //intent.putExtra("name", name);
        //intent.putExtra("age", age);
        //intent.putExtra("phone", phone);


        intent.putExtra("emp", (Serializable) employee);
        intent.putExtra("empList",(ArrayList<Employee>) employeeArrayList);

        startActivity(intent);

        //showToast(name);
        //showToast(age);
        //showToast(phone);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void selectSkill(View view) {
        CheckBox checkBox = (CheckBox) view;
        boolean status = checkBox.isChecked();

        if(status){
            skills.add(checkBox.getText().toString());
        }else {
            skills.remove(checkBox.getText().toString());
        }
    }

    public void showDOB(View view) {
    }
}
