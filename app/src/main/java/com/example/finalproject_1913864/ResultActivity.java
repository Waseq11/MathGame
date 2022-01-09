package com.example.finalproject_1913864;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtResults;
    String stringAnswer = "", stringPercentage = "";
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initialize();

        stringAnswer = getIntent().getStringExtra("stringAnswer");

        stringPercentage = getIntent().getStringExtra("stringPercentage");

        stringAnswer += stringPercentage;

        txtResults.setText(stringAnswer);
    }

    private void initialize() {

        txtResults = findViewById(R.id.txtResults);
        txtResults.setText(null);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnBack: {
                finish();
            }
        }
    }
}
