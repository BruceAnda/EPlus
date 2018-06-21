package com.bawei.eplus.fragment.channelfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.eplus.R;
import com.bawei.eplus.net.HttpUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChannelOneFragment extends Fragment {

    public static final String TAG = ChannelOneFragment.class.getSimpleName();
    private String channel;
    private int page = 10;
    private String api = "http://gank.io/api/data/all/20/";

    public String getChannel() {
        return channel;
    }

    public ChannelOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_channel_one, container, false);

        Bundle arguments = getArguments();
        //  channel = arguments.getString("channel");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadData();
    }

    private void loadData() {
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.setCallback(new HttpUtils.NetCallback() {
            @Override
            public void onSuccess(String s) {
                Log.i(TAG, "result:" + s);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
        httpUtils.get(api + page);
    }

    public static Fragment newInstance(String channel) {
        ChannelOneFragment fragment = new ChannelOneFragment();
        Bundle args = new Bundle();
        args.putString("channel", channel);
        fragment.setArguments(args);
        return fragment;
    }
}
