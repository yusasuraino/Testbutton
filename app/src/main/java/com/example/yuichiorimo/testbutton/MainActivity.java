package com.example.yuichiorimo.testbutton;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Toast;
import android.provider.Settings;


import io.repro.android.Repro;

public class MainActivity extends AppCompatActivity{

        private final int REQUEST_PERMISSION = 10;



    public final static String EXTRA_MYID = "com.example.yuichiorimo.testbutton.MYID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start Recording
        Repro.startRecording();

        com.beardedhen.androidbootstrap.BootstrapButton mapViewButton = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.onMapReady);
        mapViewButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MapsActivity.class);

                startActivity(intent);
                Repro.track("MainActivity");

                /*com.beardedhen.androidbootstrap.BootstrapButton mapViewButton = (com.beardedhen.androidbootstrap.BootstrapButton) findViewById(R.id.onWebView);
                mapViewButton.setOnClickListener(new View.OnClickListener() {
                    （WEBページに画面遷移したい）
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(“https://www.yahoo.com/”);
                        Intent i = new Intent(getApplication(),uri);
                        startActivity(i);*/
            }
        });

        Log.d("MainActivity","onCreate()");

        if(Build.VERSION.SDK_INT >=23)

        {
            checkPermission();
        }
        else

        {
            locationActivity();
        }

    }
        // 位置情報許可の確認

    public void checkPermission() {
        // 既に許可している
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationActivity();
        }
        // 拒否していた場合
        else {
            requestLocationPermission();
        }
    }

    // 許可を求める
    private void requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION);

        } else {
            Toast toast = Toast.makeText(this, "許可されないとアプリが実行できません", Toast.LENGTH_SHORT);
            toast.show();

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, REQUEST_PERMISSION);

        }
    }



    // 結果の受け取り
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION) {
            // 使用が許可された
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationActivity();
                return;

            } else {
                // それでも拒否された時の対応
                Toast toast = Toast.makeText(this, "これ以上なにもできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    // Intent でLocation
    private void locationActivity() {
        Intent intent = new Intent(getApplication(), MapsActivity.class);
        startActivity(intent);
    }
}


            /*（userIdを取得してReproに渡したい）
            public void setUserId (View view){
            //EditTextを取得
            com.beardedhen.androidbootstrap.BootstrapEditText myEditText = (com.beardedhen.androidbootstrap.BootstrapEditText) findViewById(R.id.myEditText);
            myEditText.setOnClickListener(new View.OnClickListener() {


                //EditTextの中身を取得
                String myId = myEditText.getText().toString().trim();

                //中身をみて条件分岐
                if(myId.equals("")||myId.length()>191){

                    //error action
                    myEditText.setError("Please enter USER_ID");

                } else{
                    //myIdの値をRepro.setUserID();の引数に指定して渡す
                    Intent intent = new Intent(getApplication(), Result.class);
                    intent.putExtra(EXTRA_MYID, myId);
                    startActivity(intent);
                    }
                });
            }
        }*/







