package com.odbpo.fenggo.material_design_widget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.odbpo.fenggo.material_design_widget.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this,CustomBehaviorActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this,SyncScrollActivity.class));
                break;
        }
    }
}
