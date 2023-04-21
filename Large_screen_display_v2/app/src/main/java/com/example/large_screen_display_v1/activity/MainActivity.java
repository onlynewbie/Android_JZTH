package com.example.large_screen_display_v1.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.filter.FilterActivity;
import com.example.large_screen_display_v1.filter.FilterBean;
import com.example.large_screen_display_v1.filter.FilterDataUtils;
import com.example.large_screen_display_v1.filter.FilterLayout;
import com.example.large_screen_display_v1.fragment.EquFaultFragment;
import com.example.large_screen_display_v1.fragment.EquInformationFragment;
import com.example.large_screen_display_v1.fragment.FirstFragment;
import com.example.large_screen_display_v1.fragment.SaleFragment;
import com.example.large_screen_display_v1.fragment.SupervisionFragment;
import com.example.large_screen_display_v1.view.BadViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.gyf.barlibrary.ImmersionBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 原来使用activity进行底部导航栏的跳转，现在将其变成fragment+BottomNavigationView进行重构
 */
public class MainActivity extends AppCompatActivity
//        implements View.OnClickListener
{
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNav);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FirstFragment()).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.firstname:
                        fragment=new FirstFragment();
                        break;
                    case R.id.add:
                        fragment=new SaleFragment();
                        break;
                    case R.id.my:
                        fragment=new SupervisionFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                return true;
            }
        });
//        initView();
//        init();
    }
//    private void init(){
//        titles = new ArrayList<>();
//        titles.add("设备信息");
//        titles.add("故障信息");
//        fragments=new ArrayList<>();
//        fragments.add(new EquInformationFragment());
//        fragments.add(new EquFaultFragment());
//        fm = getSupportFragmentManager();
//        myAdapter = new MyAdapter(fm);
//        ft = fm.beginTransaction();
//        ft.commit();
//        viewPager.setAdapter(myAdapter);
//
//        //添加标签
//        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)),true);//默认选中
//        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)),false);
//
//        tabLayout.setupWithViewPager(viewPager);
//        Log.e("fragment size:", String.valueOf(fragments.size()));
//    }
//
//    private void initView()
//    {
//        tabLayout = findViewById(R.id.tab);
//        viewPager = findViewById(R.id.viewpager);
//
//        ll_first=findViewById(R.id.id_first);
//        ll_sale=findViewById(R.id.id_sale);
//        ll_supervisory=findViewById(R.id.id_supervisory);
//
//        ll_supervisory.setOnClickListener(this);
//        ll_first.setOnClickListener(this);
//        ll_sale.setOnClickListener(this);
//
//        iv_first=findViewById(R.id.iv_first);
//        iv_sale=findViewById(R.id.iv_sale);
//        iv_supervisory=findViewById(R.id.iv_supervisory);
//
//        iv_first.setSelected(true);
//        iv_current = iv_first;
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        iv_current.setSelected(false);
//        switch (v.getId()){
//            case R.id.id_first:
//                iv_first.setSelected(true);
//                iv_current = iv_first;
//                break;
//            case R.id.id_sale:
//                iv_sale.setSelected(true);
//                iv_current = iv_sale;
//                Intent intent2 = new Intent(MainActivity.this,SaleAcitivity.class);
//                startActivity(intent2);
//                break;
//            case R.id.id_supervisory:
//                iv_supervisory.setSelected(true);
//                iv_current=iv_supervisory;
//                Intent intent3 = new Intent(MainActivity.this,SupervisoryActivity.class);
//                startActivity(intent3);
//                break;
//        }
//    }
//
//    class MyAdapter extends FragmentPagerAdapter {
//        public MyAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return titles.get(position);
//        }
//    }
}