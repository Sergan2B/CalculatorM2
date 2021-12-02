package com.example.myapplication123;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.result);
        findViewById(R.id.button_red).setOnClickListener(view -> finishAffinity());

        String text = getIntent().getStringExtra("key1");
        textView.setText(text);
    }
}


