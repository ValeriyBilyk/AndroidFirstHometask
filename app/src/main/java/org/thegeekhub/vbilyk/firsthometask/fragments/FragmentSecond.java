package org.thegeekhub.vbilyk.firsthometask.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import org.thegeekhub.vbilyk.firsthometask.R;

public class FragmentSecond extends Fragment implements View.OnClickListener {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home task 2");

        view.findViewById(R.id.btn_factorial).setOnClickListener(this);
        view.findViewById(R.id.btn_fibonacci).setOnClickListener(this);
        editValue = (EditText) view.findViewById(R.id.edit_enter_value);
        editResult = (EditText) view.findViewById(R.id.edit_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_factorial:
                try {
                    int fact = Integer.parseInt(editValue.getText().toString());
                    editResult.setText(String.valueOf(factorial(fact)));
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Enter correct value", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_fibonacci:
                try {
                    int fib = Integer.parseInt(editValue.getText().toString());
                    editResult.setText(String.valueOf(fibonacci(fib)));
                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(),"Enter correct value", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
