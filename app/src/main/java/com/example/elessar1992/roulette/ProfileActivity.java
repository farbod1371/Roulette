package com.example.elessar1992.roulette;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by elessar1992 on 8/11/19.
 */

public class ProfileActivity extends AppCompatActivity
{
    FirebaseAuth firebaseAuth;
    //TextView myProfile;

    ActionBar actionBar;
    String myUID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");

        //auth
        firebaseAuth = FirebaseAuth.getInstance();

        BottomNavigationView navigationView = findViewById(R.id.navigationButton);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        actionBar.setTitle("Home");
        GameFragment fragment1 = new GameFragment();
        FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
        f1.replace(R.id.myContent, fragment1, "");
        f1.commit();

        //checkingUsers();
        //token update

    }
    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_game:
                            actionBar.setTitle("Game");
                            GameFragment fragment1 = new GameFragment();
                            FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
                            f1.replace(R.id.myContent,fragment1,"");
                            f1.commit();
                            return true;

                        case R.id.nav_player:
                            actionBar.setTitle("Profile");
                            PlayerFragment fragment2 = new PlayerFragment();
                            FragmentTransaction f2 = getSupportFragmentManager().beginTransaction();
                            f2.replace(R.id.myContent,fragment2,"");
                            f2.commit();
                            return true;
                    }
                    return false;
                }
            };
}
