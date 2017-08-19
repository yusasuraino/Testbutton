package com.example.yuichiorimo.testbutton;

/**
 * Created by yuichiorimo on 2017/08/12.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import io.repro.android.Repro;



public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String user_annotation = intent.getStringExtra(MainActivity.EXTRA_MYID);

        Repro.setUserID(user_annotation);

        String userID = Repro.getUserID();

    }
}
