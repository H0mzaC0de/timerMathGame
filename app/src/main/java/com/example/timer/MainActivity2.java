package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button ready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ready=findViewById(R.id.ready);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}