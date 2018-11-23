package com.odbpo.fenggo.material_design_widget.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.odbpo.fenggo.material_design_widget.R;
import com.odbpo.fenggo.material_design_widget.adapter.MyPagerAdapter;
import com.odbpo.fenggo.material_design_widget.fragment.IndexFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_setting)
    TextView tvSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setToolbar();

        setViewPager();

    }

    private void setToolbar() {
        collapsingToolbarLayout.setTitle("导航栏");
        collapsingToolbarLayout.setCollapsedTitleTypeface(Typeface.DEFAULT_BOLD);//设置字体加粗
        collapsingToolbarLayout.setExpandedTitleTypeface(Typeface.DEFAULT_BOLD);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置字体颜色
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
    }

    private void setViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        titleList.add("新闻");
        titleList.add("视频");
        titleList.add("音乐");
        titleList.add("军事");
        titleList.add("体育");

        for (int i = 0; i < titleList.size(); i++) {
            fragmentList.add(new IndexFragment());
        }

        viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragmentList, titleList));
        tab.setupWithViewPager(viewpager);
    }

    @OnClick({R.id.iv_back, R.id.tv_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_setting:
                Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,ToolBarActivity.class));
                break;
        }
    }
}
