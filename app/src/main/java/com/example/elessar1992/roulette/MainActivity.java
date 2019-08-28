package com.example.elessar1992.roulette;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

/**
 * Created by elessar1992 on 8/8/19.
 */

public class MainActivity extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutLastname;
    private TextInputLayout textInputLayoutUsername;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;


    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextLastname;


    private EditText textInputEditTextUsername;
    private EditText textInputEditTextEmail;
    private EditText textInputEditTextPassword;
    private TextView textInputEditTextAccount;
    //private EditText textInputEditTextConfirmPassword;

    private Button appCompatButtonRegister;
    //private AppCompatTextView appCompatTextViewLoginLink;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();

        initViews();
        initListener();

    }
    private void initViews()
    {
        textInputEditTextEmail = (EditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (EditText) findViewById(R.id.textInputEditTextPassword);
        //textInputEditTextConfirmPassword = (EditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (Button) findViewById(R.id.appCompatButtonLogin);

        textInputEditTextAccount = (TextView) findViewById(R.id.userAccount);

        //appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        mAuth = FirebaseAuth.getInstance();
    }
    private void initListener()
    {
        appCompatButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String name =  textInputEditTextName.getText().toString().trim();
                //String lastname = textInputEditTextLastname.getText().toString().trim();
                //String username = textInputEditTextUsername.getText().toString().trim();
                String email = textInputEditTextEmail.getText().toString().trim();
                String password = textInputEditTextPassword.getText().toString().trim();
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    textInputEditTextEmail.setError("Invalid Email");
                    textInputEditTextEmail.setFocusable(true);
                }
                else if (password.length() < 6)
                {
                    textInputEditTextPassword.setError("Passwrod Length is less than 6");
                    textInputEditTextPassword.setFocusable(true);
                }
                else
                {
                    //showEditProfileDialog();
                    registerUser(email,password);
                }
            }
        });
        textInputEditTextAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });

    }
    private void registerUser(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            String email = user.getEmail();
                            String userID = user.getUid();

                            HashMap<Object, String> hashMap = new HashMap<>();
                            hashMap.put("email", email);
                            hashMap.put("uid", userID);
                            hashMap.put("username", "");
                            hashMap.put("name", "");
                            hashMap.put("score","");

                            FirebaseDatabase database = FirebaseDatabase.getInstance();

                            DatabaseReference reference = database.getReference("Users");
                            reference.child(userID).setValue(hashMap);



                            Toast.makeText(MainActivity.this, "Registration Completed\n"+user.getEmail(),Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, ""+e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}


