package edu.ucdavis.test;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BlankFragment mComposeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentManager fm = getFragmentManager();
        mComposeFragment = (BlankFragment) fm.findFragmentByTag(BlankFragment.TAG);
        if (mComposeFragment == null) {
            mComposeFragment = new BlankFragment();
        }

        //fm.beginTransaction()
                //.replace(R.id.content_frame, mComposeFragment, BlankFragment.TAG)
                //.commit();
    }
}
