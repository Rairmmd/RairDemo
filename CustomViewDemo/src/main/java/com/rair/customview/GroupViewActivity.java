package com.rair.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rair.customview.view.GroupView;

public class GroupViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_view);

        GroupView groupView = (GroupView) findViewById(R.id.m_groupview);
        groupView.setOnFinishListener(new GroupView.OnFinishListener() {
            @Override
            public void onFinish() {
                finish();
            }
        });
    }
}
