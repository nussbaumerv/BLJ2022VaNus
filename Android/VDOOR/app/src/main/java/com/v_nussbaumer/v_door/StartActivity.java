package com.v_nussbaumer.v_door;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button startButton = findViewById(R.id.noInternetButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, URLSelection.class);
                startActivity(intent);
                finish();
            }
        });
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String url = sharedPreferences.getString("url", "");

            APIRequest request = new APIRequest();
            try {
                String response = request.createRequest(url + "/serverInfo.php");

                if (response.equals("This is a V-DOOR Server")) {
                    Log.i("URL stored", "true");
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.i("URL stored", "false");
                }
            } catch (Exception e) {
                Log.i("URL stored", "false");
            }
        } else{
            Intent intent = new Intent(StartActivity.this, NoInternet.class);
            startActivity(intent);
            finish();
        }
    }
}