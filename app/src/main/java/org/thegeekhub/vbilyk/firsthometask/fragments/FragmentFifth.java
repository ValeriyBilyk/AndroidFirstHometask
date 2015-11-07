package org.thegeekhub.vbilyk.firsthometask.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.thegeekhub.vbilyk.firsthometask.R;

public class FragmentFifth extends Fragment implements Animation.AnimationListener, View.OnClickListener {

    TextView txtMessage;
    Button btnStartFadeIn;
    Button btnStartZoomOut;
    Button btnStartZoomIn;
    Button btnStartRotate;

    // Animation
    Animation animFadein;
    Animation animZoomOut;
    Animation animZoomIn;
    Animation animRotate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.anim_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home task 5");

        txtMessage = (TextView) view.findViewById(R.id.text_anim);
        btnStartFadeIn = (Button) view.findViewById(R.id.button_fade_in);
        btnStartZoomOut = (Button) view.findViewById(R.id.button_zoom_out);
        btnStartZoomIn = (Button) view.findViewById(R.id.button_zoom_in);
        btnStartRotate = (Button) view.findViewById(R.id.button_rotate);

        // load the animation
        animFadein = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
        animZoomOut = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_out);
        animZoomIn = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);
        animRotate = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);

        // set animation listener
        animFadein.setAnimationListener(this);
        animZoomOut.setAnimationListener(this);
        animZoomIn.setAnimationListener(this);
        animRotate.setAnimationListener(this);

        btnStartFadeIn.setOnClickListener(this);
        btnStartZoomOut.setOnClickListener(this);
        btnStartZoomIn.setOnClickListener(this);
        btnStartRotate.setOnClickListener(this);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // Take any action after completing the animation

        // check for fade in animation
        if (animation == animFadein) {

        }

    }

    public void onAnimationRepeat(Animation animation) {

    }


    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_fade_in:
                // start the animation
                txtMessage.startAnimation(animFadein);
                break;
            case R.id.button_zoom_out:
                txtMessage.startAnimation(animZoomOut);
                break;
            case R.id.button_zoom_in:
                txtMessage.startAnimation(animZoomIn);
                break;
            case R.id.button_rotate:
                txtMessage.startAnimation(animRotate);
                break;
        }
    }
}

