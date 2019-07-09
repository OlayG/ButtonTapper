package com.noname.buttontapper;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnFragmentInteractionListener {

    // Declare fragments
    DisplayFragment displayFragment; // Static Fragment
    ButtonFragment buttonFragment; // Dynamic Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init the static fragment
        displayFragment = (DisplayFragment) getSupportFragmentManager().findFragmentById(R.id.static_frag);

        // Init Dynamic fragment and load into framelayout
        buttonFragment = new ButtonFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.dynamic_frag, buttonFragment, "ButtonFragment")
                .commit();
    }

    @Override
    public void buttonClicked(String count) {
        displayFragment.displayCount(count);
    }
}
