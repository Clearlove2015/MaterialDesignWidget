package com.odbpo.fenggo.material_design_widget.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.odbpo.fenggo.material_design_widget.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomBehaviorActivity extends AppCompatActivity {

    @BindView(R.id.tv_a)
    TextView tvA;
    @BindView(R.id.tv_b)
    TextView tvB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_a, R.id.tv_b})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_a:
                ViewCompat.offsetTopAndBottom(view,10);//执行平移动画
                break;
            case R.id.tv_b:
                break;
        }
    }
}
