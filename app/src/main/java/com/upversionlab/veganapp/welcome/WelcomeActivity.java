package com.upversionlab.veganapp.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.upversionlab.veganapp.MainActivity;
import com.upversionlab.veganapp.R;

public class WelcomeActivity extends AppCompatActivity {
    int currentStep = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        View next = findViewById(R.id.activity_welcome_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentStep++;
                screensHandler(currentStep);
            }
        });

        View back = findViewById(R.id.activity_welcome_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentStep--;
                screensHandler(currentStep);
            }
        });

        View start = findViewById(R.id.activity_welcome_start_button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void screensHandler(int currentStep) {
        hideTextsAndShowButtons();
        switch (currentStep) {
            case 1:
                findViewById(R.id.activity_welcome_step1).setVisibility(View.VISIBLE);
                findViewById(R.id.activity_welcome_back).setVisibility(View.INVISIBLE);
                break;
            case 2:
                findViewById(R.id.activity_welcome_step2).setVisibility(View.VISIBLE);
                break;
            case 3:
                findViewById(R.id.activity_welcome_step3).setVisibility(View.VISIBLE);
                break;
            case 4:
                findViewById(R.id.activity_welcome_step4).setVisibility(View.VISIBLE);
                break;
            case 5:
                findViewById(R.id.activity_welcome_step5).setVisibility(View.VISIBLE);
                findViewById(R.id.activity_welcome_next).setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void hideTextsAndShowButtons() {
        findViewById(R.id.activity_welcome_step1).setVisibility(View.INVISIBLE);
        findViewById(R.id.activity_welcome_step2).setVisibility(View.INVISIBLE);
        findViewById(R.id.activity_welcome_step3).setVisibility(View.INVISIBLE);
        findViewById(R.id.activity_welcome_step4).setVisibility(View.INVISIBLE);
        findViewById(R.id.activity_welcome_step5).setVisibility(View.INVISIBLE);

        findViewById(R.id.activity_welcome_next).setVisibility(View.VISIBLE);
        findViewById(R.id.activity_welcome_back).setVisibility(View.VISIBLE);
    }
}
