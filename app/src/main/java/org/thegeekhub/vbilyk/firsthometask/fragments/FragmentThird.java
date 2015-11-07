package org.thegeekhub.vbilyk.firsthometask.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.thegeekhub.vbilyk.firsthometask.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FragmentThird extends Fragment {

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Home task 3");

        text1 = (TextView) view.findViewById(R.id.text_1);
        text2 = (TextView) view.findViewById(R.id.text_2);

        createAndShowNumbers();

        view.findViewById(R.id.button_1).setOnClickListener(clickListener);
        view.findViewById(R.id.button_2).setOnClickListener(clickListener);
        view.findViewById(R.id.button_3).setOnClickListener(clickListener);
        view.findViewById(R.id.button_4).setOnClickListener(clickListener);
    }

    private void createAndShowNumbers() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);
        text1.setText(strings);
    }

    private void reverseOrder() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = values.length - 1; i >= 0; i--) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);
        text2.setText(strings);
    }

    private void removeEveryThird() {
        List<String> stringList = new ArrayList<>(Arrays.asList(values));
        int start = stringList.size() - stringList.size() % 3 - 1;
        for (int i = start; i >= 0; i -= 3) {
            stringList.remove(i);
        }

        String strings = TextUtils.join(", ", stringList);
        text2.setText(strings);
    }

    private void removeDuplicates() {
        Set<String> list = new LinkedHashSet<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);
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
        text2.setText(strings);
    }
}
