package com.bawei.eplus.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 频道页面适配器
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/6/21
 */
public class ChannelAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private String[] channel = {"all", "Android", "iOS", "休息视频", "拓展资源", "前端"};

    public ChannelAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return channel[position];
    }
}
