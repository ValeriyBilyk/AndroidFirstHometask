package org.thegeekhub.vbilyk.firsthometask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOutput = (Button) findViewById(R.id.button_output);
        buttonOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextInput = (EditText) findViewById(R.id.edit_text_input);
                String textInput = editTextInput.getText().toString();

                EditText editTextOutput = (EditText) findViewById(R.id.edit_text_output);
                editTextOutput.setText(textInput);
            }
        });
    }


}
