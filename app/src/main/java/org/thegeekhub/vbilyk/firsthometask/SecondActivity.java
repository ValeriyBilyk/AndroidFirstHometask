package org.thegeekhub.vbilyk.firsthometask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editValue;
    private EditText editResult;

    public static long factorial(int n) {
        if ((n == 0) || (n == 1))
            return 1;
        return n * factorial(n - 1);
    }

    public static long fibonacci(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViewById(R.id.btn_factorial).setOnClickListener(this);
        findViewById(R.id.btn_fibonacci).setOnClickListener(this);
        editValue = (EditText) findViewById(R.id.edit_enter_value);
        editResult = (EditText) findViewById(R.id.edit_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_factorial:
                int fact = Integer.parseInt(editValue.getText().toString());
                editResult.setText(String.valueOf(factorial(fact)));
                break;
            case R.id.btn_fibonacci:
                int fib = Integer.parseInt(editValue.getText().toString());
                editResult.setText(String.valueOf(fibonacci(fib)));
                break;
        }
    }


}
