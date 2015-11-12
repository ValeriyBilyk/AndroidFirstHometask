package org.thegeekhub.vbilyk.firsthometask.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.thegeekhub.vbilyk.firsthometask.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThirdActivity extends AppCompatActivity {

    private String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7",
            "Mac OS X", "Linux", "Ubuntu", "Windows7", "Android", "iPhone", "WindowsMobile"};

    private TextView text1;
    private TextView text2;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_1:
                    reverseOrder();
                    break;
                case R.id.button_2:
                    removeEveryThird();
                    break;
                case R.id.button_3:
                    removeDuplicates();
                    break;
                case R.id.button_4:
                    sortValues();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_third);

        createAndShowNumbers();

        findViewById(R.id.button_1).setOnClickListener(clickListener);
        findViewById(R.id.button_2).setOnClickListener(clickListener);
        findViewById(R.id.button_3).setOnClickListener(clickListener);
        findViewById(R.id.button_4).setOnClickListener(clickListener);
    }

    private void createAndShowNumbers() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);
        text1 = (TextView) findViewById(R.id.text_1);
        text1.setText(strings);
    }

    private void reverseOrder() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = values.length - 1; i >= 0; i--) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);
        text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }

    private void removeEveryThird() {
        List<String> stringList = new ArrayList<>(Arrays.asList(values));
        int start = stringList.size() - stringList.size() % 3 - 1;
        for (int i = start; i >= 0; i -= 3) {
            stringList.remove(i);
        }

        String strings = TextUtils.join(", ", stringList);
        text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }

    private void removeDuplicates() {
        Set<String> list = new LinkedHashSet<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);
        text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }

    private void sortValues() {
        TreeSet<String> list = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                return lhs.toLowerCase().compareTo(rhs.toLowerCase());
            }
        });
        list.addAll(Arrays.asList(values));
        String strings = TextUtils.join(", ", list);
        text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }
}
