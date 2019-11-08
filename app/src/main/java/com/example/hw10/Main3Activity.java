package com.example.hw10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private TextView AnsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        AnsText = (TextView)findViewById(R.id.AnsText);

        Intent intent=getIntent();
        final int Months = intent.getIntExtra("Months",0);
        final String NO1 = intent.getStringExtra("NO1");
        final String NO2 = intent.getStringExtra("NO2");
        final String NO3 = intent.getStringExtra("NO3");
        final String NO4 = intent.getStringExtra("NO4");
        final String NO5 = intent.getStringExtra("NO5");
        final String Enter = intent.getStringExtra("Enter");

        for(int i=0;i<6;i++){
            if (Enter.matches(NO1)){
                AnsText.setText("恭喜獲獎1000萬元整");
            }
            else if(Enter.matches(NO2)){
                AnsText.setText("恭喜獲獎200萬元整");
            }
            else if(Enter.substring(i,7).matches(NO3.substring(i,7))
                    ||Enter.substring(i,7).matches(NO4.substring(i,7))
                    ||Enter.substring(i,7).matches(NO5.substring(i,7))){
                switch (i){
                    case 0:
                        AnsText.setText("恭喜獲獎20萬元整");
                        break;
                    case 1:
                        AnsText.setText("恭喜獲獎4萬元整");
                        break;
                    case 2:
                        AnsText.setText("恭喜獲獎1萬元整");
                        break;
                    case 3:
                        AnsText.setText("恭喜獲獎4千元整");
                        break;
                    case 4:
                        AnsText.setText("恭喜獲獎1千元整");
                        break;
                    case 5:
                        AnsText.setText("恭喜獲獎2百元整");
                        break;
                }
                break;
            }
            else {
                AnsText.setText("QAQ 沒有中獎 ");
            }
        }

        final Button button = (Button) findViewById(R.id.Back_Month_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final Button button1 = (Button) findViewById(R.id.Back_Number_button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                intent.putExtra("Months",Months);
                startActivity(intent);
            }
        });

    }
}
