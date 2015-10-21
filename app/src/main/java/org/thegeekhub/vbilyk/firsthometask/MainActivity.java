package org.thegeekhub.vbilyk.firsthometask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_first_activity).setOnClickListener(this);
        findViewById(R.id.btn_second_activity).setOnClickListener(this);
        findViewById(R.id.btn_third_activity).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first_activity:
                Intent firstActivity = new Intent(this, FirstActivity.class);
                startActivity(firstActivity);
                break;
            case R.id.btn_second_activity:
                Intent secondActivity = new Intent(this, SecondActivity.class);
                startActivity(secondActivity);
                break;
            case R.id.btn_third_activity:
                Intent thirdActivity = new Intent(this, ThirdActivity.class);
                startActivity(thirdActivity);
        }
    }
}
