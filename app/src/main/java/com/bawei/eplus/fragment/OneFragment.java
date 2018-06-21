package com.bawei.eplus.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.eplus.R;
import com.bawei.eplus.adapter.ChannelAdapter;
import com.bawei.eplus.fragment.channelfragment.ChannelFiveFragment;
import com.bawei.eplus.fragment.channelfragment.ChannelFourFragment;
import com.bawei.eplus.fragment.channelfragment.ChannelOneFragment;
import com.bawei.eplus.fragment.channelfragment.ChannelSixFragment;
import com.bawei.eplus.fragment.channelfragment.ChannelThreeFragment;
import com.bawei.eplus.fragment.channelfragment.ChannelTwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 咨询页面
 * <p>
 * 需求： 频道展示不同的列表
 * 1. 频道选择--》 TabLayout
 * 2. 页面切换--》 ViewPager
 * 3. 列表展示--》 PullToRefresh
 * 4. 加载网络数据--》HttpUrlConnection+AsyncTask+CallBack
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/6/21
 */
public class OneFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        viewPager = view.findViewById(R.id.vp);
        tabLayout = view.findViewById(R.id.tab_layout);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragments = new ArrayList<>();
        fragments.add(new ChannelOneFragment());
        fragments.add(new ChannelTwoFragment());
        fragments.add(new ChannelThreeFragment());
        fragments.add(new ChannelFourFragment());
        fragments.add(new ChannelFiveFragment());
        fragments.add(new ChannelSixFragment());

        viewPager.setAdapter(new ChannelAdapter(getFragmentManager(), fragments));
    }
}
