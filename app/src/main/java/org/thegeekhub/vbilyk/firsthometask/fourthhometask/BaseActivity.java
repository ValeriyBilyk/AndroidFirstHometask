package org.thegeekhub.vbilyk.firsthometask.fourthhometask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract boolean isAddFragment();

    public abstract void addFragment();

    protected abstract int getContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContainer());
        if (isAddFragment()) {
            addFragment();
        }
    }
}
