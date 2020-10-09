package com.example.bookmytable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookmytable.Classes.User;
import com.example.bookmytable.Firebase.Utils;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViewById(R.id.signIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usn,phno,email,pwd,cpwd;
                String usn1,phno1,email1,pwd1,cpwd1;
                cpwd=findViewById(R.id.passwordConfirmSign);
                usn=findViewById(R.id.usernameSign);
                phno=findViewById(R.id.phoneSign);
                email=findViewById(R.id.emailSign);
                pwd=findViewById(R.id.passwordSign);
                usn1=usn.getText().toString();
                phno1=phno.getText().toString();
                email1=email.getText().toString();
                pwd1=pwd.getText().toString();
                cpwd1=cpwd.getText().toString();
                if(pwd1.equals("") || cpwd1.equals("") || usn1.equals("") || email1.equals("") || phno1.equals("")){
                    Toast.makeText(getApplicationContext(),"Please enter all the details",Toast.LENGTH_LONG).show();
                }
                else{
                    if(pwd1.equals(cpwd1)){
                        User newUser= new User(usn1,email1,phno1,pwd1);
                        Utils.putUser(newUser);
                        Utils.userList.add(newUser);
                        startActivity(new Intent(signup.this,MainActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Passwords do not Match",Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }

    public void goToLogin(View view) {
        Intent login = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(login);
    }
}
