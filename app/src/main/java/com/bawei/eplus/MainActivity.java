package com.bawei.eplus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.eplus.fragment.FourFragment;
import com.bawei.eplus.fragment.OneFragment;
import com.bawei.eplus.fragment.ThreeFragment;
import com.bawei.eplus.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/6/21
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgNav;
    private FragmentManager fragmentManager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgNav = findViewById(R.id.rg_nav);

        rgNav.setOnCheckedChangeListener(this);

        fragmentManager = getSupportFragmentManager();

        /* 创建Fragment的集合 */
        fragments = new ArrayList<>();
        fragments.add(new OneFragment());
        fragments.add(new TwoFragment());
        fragments.add(new ThreeFragment());
        fragments.add(new FourFragment());

        //changeFragment(fragments.get(0));
        rgNav.check(R.id.rb_nav_one);
    }

    /**
     * 切换页面
     *
     * @param fragment
     */
    private void changeFragment(Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_nav_one:
                changeFragment(fragments.get(0));
                break;
            case R.id.rb_nav_two:
                changeFragment(fragments.get(1));
                break;
            case R.id.rb_nav_three:
                changeFragment(fragments.get(2));
                break;
            case R.id.rb_nav_four:
                changeFragment(fragments.get(3));
                break;
        }
    }
}
