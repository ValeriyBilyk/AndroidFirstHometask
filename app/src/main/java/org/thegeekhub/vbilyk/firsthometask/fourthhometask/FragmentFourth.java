package org.thegeekhub.vbilyk.firsthometask.fourthhometask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.thegeekhub.vbilyk.firsthometask.R;

public class FragmentFourth extends Fragment implements MyInterface, View.OnClickListener {

    private TextView textFragment;
    private Button btnNext;
    private Button btnPrevious;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home task 4");

        textFragment = (TextView) view.findViewById(R.id.txt_fragment);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);

        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    @Override
    public void showNext() {
        textFragment.setText("Next");
    }

    @Override
    public void showPrevious() {
        textFragment.setText("Previous");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                showNext();
                break;
            case R.id.btn_previous:
                showPrevious();
                break;
        }
    }
}
