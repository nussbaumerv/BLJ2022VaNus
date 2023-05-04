package com.example.v_door;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class URLSelection extends AppCompatActivity {

    private EditText mEditTextUrl;
    private Button mButtonLoadUrl;
    private TextView mErrorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlselection);

        mEditTextUrl = findViewById(R.id.editTextURL);
        mButtonLoadUrl = findViewById(R.id.buttonConfirm);
        mErrorMessage = findViewById(R.id.errorMessage);

        mButtonLoadUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mButtonLoadUrl.setEnabled(false);
                mButtonLoadUrl.setText("Loading...");
                String url = mEditTextUrl.getText().toString();
                APIRequest request = new APIRequest();

                Log.i("Input URL ", url);

                //url = "https://home.valentin-nussbaumer.com/beta/";
                try {
                    String response = request.createRequest(url + "/serverInfo.php");

                    if(response.equals("This is a V-DOOR Server")) {
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("url", url);
                        editor.apply();

                        Intent intent = new Intent(URLSelection.this, MainActivity.class);
                        startActivity(intent);

                        mErrorMessage.setText("");
                        mEditTextUrl.setText("");

                    } else{
                        mErrorMessage.setText("Invalid URL of V-DOOR");
                    }

                    mButtonLoadUrl.setEnabled(true);
                    mButtonLoadUrl.setText("SAVE");
                } catch (Exception e){
                    mButtonLoadUrl.setEnabled(true);
                    mErrorMessage.setText("Invalid URL");
                    mButtonLoadUrl.setText("SAVE");
                }

            }
        });
    }
}