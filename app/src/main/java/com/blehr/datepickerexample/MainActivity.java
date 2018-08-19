package com.blehr.datepickerexample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";

    Button gotoButton;
    Button gotoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoButton = findViewById(R.id.goto_button);
        gotoActivity = findViewById(R.id.backToActivity);

        gotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment fragment = MyFragment.newInstance();
                transaction.replace(R.id.replace_me, fragment);
                transaction.addToBackStack("MyFragment");
                transaction.commit();
            }
        });

        gotoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction().
                        remove(getSupportFragmentManager().findFragmentById(R.id.replace_me)).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
