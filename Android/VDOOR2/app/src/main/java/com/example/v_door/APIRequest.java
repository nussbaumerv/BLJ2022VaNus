package com.example.v_door;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIRequest {
    public String createRequest(String urlN) {
        new NetworkTask().execute(urlN);
        try {
            return new NetworkTask().execute(urlN).get();
        } catch (Exception e) {
            return null;
        }
    }

    private class NetworkTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(urls[0])
                        .build();

                Response response = client.newCall(request).execute();

                return response.body().string();
            } catch (Exception e){
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                Log.i("URL is", "valid");
            }
        }
    }
}
