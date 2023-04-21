package com.example.large_screen_display_v1.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.view.BadViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment  extends Fragment{
    private TabLayout tabLayout;
    private BadViewPager viewPager;
    private List<String> titles;
    private List<Fragment> fragments;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MyAdapter myAdapter;
    private View  view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        init();
        return view;
    }


    private void init(){
        titles = new ArrayList<>();
        titles.add("设备信息");
        titles.add("故障信息");
        fragments=new ArrayList<>();
        fragments.add(new EquInformationFragment());
        fragments.add(new EquFaultFragment());
        fm = getActivity().getSupportFragmentManager();
        myAdapter = new MyAdapter(fm);
        ft = fm.beginTransaction();
        ft.commit();
        viewPager.setAdapter(myAdapter);

        //添加标签
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)),true);//默认选中
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)),false);

        tabLayout.setupWithViewPager(viewPager);
        Log.e("fragment size:", String.valueOf(fragments.size()));
    }

    private void initView()
    {
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewpager);
    }

    class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
