package com.rair.preferenceactivitydemo;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import java.util.List;

public class PreferenceActivityWithPreferenceFragment extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void onBuildHeaders(List<Header> target) {
        //加载选项列表布局
        loadHeadersFromResource(R.xml.pref_headers, target);
    }

    /**
     * 验证Preference是否有效
     *
     * @param fragmentName
     * @return
     */
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

    /**
     * GeneralPreferenceFragment
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class GeneralPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_general);
        }
    }

}
