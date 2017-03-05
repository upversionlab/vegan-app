package com.upversionlab.veganapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.upversionlab.veganapp.R;
import com.upversionlab.veganapp.model.Ping;
import com.upversionlab.veganapp.model.endpoint.PingInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PingActivity extends AppCompatActivity {

    // Borcat's IP
    public static final String VEGAN_SERVER = "http://192.168.0.5:8080/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

        Button button = (Button) findViewById(R.id.activity_ping_ping_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(VEGAN_SERVER)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                PingInterface pingService = retrofit.create(PingInterface.class);
                Call<Ping> call = pingService.getPing();
                call.enqueue(new Callback<Ping>() {
                    @Override
                    public void onResponse(Call<Ping> callPing, Response<Ping> response) {
                        Ping ping = response.body();

                        final String pong = "Pong: " + ping.getTimestamp();
                        Toast.makeText(PingActivity.this, pong, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Ping> callPing, Throwable t) {
                        Toast.makeText(PingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
