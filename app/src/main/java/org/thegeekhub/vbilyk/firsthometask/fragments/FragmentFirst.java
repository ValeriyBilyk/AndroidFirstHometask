package org.thegeekhub.vbilyk.firsthometask.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.thegeekhub.vbilyk.firsthometask.R;

public class FragmentFirst extends Fragment {

    private Button buttonOutput;
    private EditText editTextInput;
    private EditText editTextOutput;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Home task 1");

        buttonOutput = (Button) view.findViewById(R.id.button_output);
        buttonOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput = (EditText) view.findViewById(R.id.edit_text_input);
                String textInput = editTextInput.getText().toString();

                editTextOutput = (EditText) view.findViewById(R.id.edit_text_output);
                editTextOutput.setText(textInput);
            }
        });
    }


}
