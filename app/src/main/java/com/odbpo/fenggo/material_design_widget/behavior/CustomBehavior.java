package com.odbpo.fenggo.material_design_widget.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CustomBehavior extends CoordinatorLayout.Behavior<View> {
    public CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof TextView || super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        int offset = dependency.getTop() - child.getTop();//计算偏移量
        ViewCompat.offsetTopAndBottom(child,offset);//执行平移动画
        ViewCompat.animate(child).rotation(child.getTop() * 360);//执行旋转动画
        return true;
    }
}
