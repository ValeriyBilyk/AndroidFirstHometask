package org.thegeekhub.vbilyk.firsthometask.fourthhometask;

import org.thegeekhub.vbilyk.firsthometask.R;

public class FourthActivity extends BaseActivity {
    @Override
    public boolean isAddFragment() {
        return true;
    }

    @Override
    public void addFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.container_activity_fourth, new FragmentFourth()).commit();
    }

    @Override
    protected int getContainer() {
        return R.layout.fragment_fourth;
    }
}
