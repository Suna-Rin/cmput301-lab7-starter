package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {
    public static final String EXTRA_CITY_NAME = "city_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView tv = findViewById(R.id.text_city);
        String name = getIntent().getStringExtra(EXTRA_CITY_NAME);
        tv.setText(name == null ? "" : name);

        Button back = findViewById(R.id.button_back);
        back.setOnClickListener(v -> finish());
    }
}
