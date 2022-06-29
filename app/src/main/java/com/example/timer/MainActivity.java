package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView timer,streaksCount,x,y,op,result;
    EditText answer;
    Button next,reset;
    int millie=10000;
    int count=0;
    int d=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=findViewById(R.id.timer);
        streaksCount=findViewById(R.id.streaksCount);
        x=findViewById(R.id.x);
        y=findViewById(R.id.y);
        op=findViewById(R.id.op);
        result=findViewById(R.id.result);
        answer=findViewById(R.id.answer);
        next=findViewById(R.id.next);
        reset=findViewById(R.id.reset);
        reset.setOnClickListener(this);
        next.setOnClickListener(this);
        reset.setOnClickListener(this);
        timer(7000);




    }
    public void timer(int f){
        reset.setEnabled(false);
        next.setEnabled(false);
        Random rand= new Random();
        int n=rand.nextInt(9)+1;
        Random rand2=new Random();
        int z=rand2.nextInt(9)+1;
        String [] ops={"+","-","*"};
        Random rand3=new Random();
        int e=rand3.nextInt(3);
        String opSelected;
        opSelected=ops[e];
        op.setText(opSelected);
        y.setText(Integer.toString(z));
        x.setText(Integer.toString(n));
        new CountDownTimer(f, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("Seconds Remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("Time's UP!");
                if(!answer.getText().toString().isEmpty()) {
                    if (op.getText().toString() == "-") {
                        d = Integer.parseInt(String.valueOf(x.getText().toString())) - Integer.parseInt(String.valueOf(y.getText().toString()));
                        if (Integer.parseInt(answer.getText().toString()) == d) {
                            count++;
                            streaksCount.setText(Integer.toString(count));
                            next.setEnabled(true);
                            result.setText("GORETO DAZE");
                            result.setTextColor(Color.GREEN);
                        } else {
                            result.setText("ANO BAKA???");
                            result.setTextColor(Color.RED);
                            reset.setEnabled(true);
                        }
                    } else if (op.getText().toString().equals("+")) {
                        d = Integer.parseInt(String.valueOf(x.getText().toString())) + Integer.parseInt(String.valueOf(y.getText().toString()));
                        if (Integer.parseInt(answer.getText().toString()) == d) {
                            count++;
                            streaksCount.setText(Integer.toString(count));
                            next.setEnabled(true);
                            result.setText("GORETO DAZE");
                            result.setTextColor(Color.GREEN);
                        } else {
                            result.setText("ANO BAKA???");
                            result.setTextColor(Color.RED);
                            reset.setEnabled(true);
                        }
                    } else if (op.getText().toString().equals("*")) {
                        d = Integer.parseInt(String.valueOf(x.getText().toString())) * Integer.parseInt(String.valueOf(y.getText().toString()));
                        if (Integer.parseInt(answer.getText().toString()) == d) {
                            count++;
                            streaksCount.setText(Integer.toString(count));
                            next.setEnabled(true);
                            result.setText("GORETO DAZE");
                            result.setTextColor(Color.GREEN);
                        } else {
                            result.setText("ANO BAKA???");
                            result.setTextColor(Color.RED);
                            reset.setEnabled(true);
                        }
                    }
                }else{
                    result.setText("ANO BAKA???");
                    result.setTextColor(Color.RED);
                    reset.setEnabled(true);
                }
            }
        }.start();

    }


    @Override
    public void onClick(View v) {
    if(v.getId()==reset.getId()){
        reset();
    }
    else if(v.getId()==next.getId()){
        timer(7000);
        answer.setText("");
        result.setText("");

    }
    }
    public void reset(){
        finish();
        startActivity(getIntent());
    }


}