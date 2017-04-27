package com.rair.preferenceactivitydemo;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import static android.content.Context.MODE_WORLD_READABLE;

/**
 * Created by Rair on 2017/4/27.
 * Email:rairmmd@gmail.com
 * Author:Rair
 */

public class MyFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesMode(MODE_WORLD_READABLE);
        addPreferencesFromResource(R.xml.pref_my);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Preference one = findPreference("one");
        one.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "one", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        findPreference("two").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "two", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        findPreference("three").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "再点一下试试", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        findPreference("four").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast.makeText(getActivity(), "试试就试试", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
