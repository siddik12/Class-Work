package com.rockscoder.employeemad33;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);


    }

    public void login(View view) {
        if(editTextEmail.getText().toString().equals("siddik@gmail.com") && editTextPassword.getText().toString().equals("siddik") ){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            intent.putExtra("isLoggedIn",true);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Incorrect Information", Toast.LENGTH_LONG).show();
        }


    }
}
