package com.example.large_screen_display_v1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.activity.MainActivity;
import com.example.large_screen_display_v1.view.EChartView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SaleFragment extends Fragment {
    private EChartView barChart;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> titles;
    private List<Fragment> fragments;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MyAdapter1 myAdapter;
    private SaleDistributionFragment saleDistributionFragment=new SaleDistributionFragment();
    private MonthSaleFragment monthSaleFragment=new MonthSaleFragment();
    boolean[] fragmentsUpdateFlag = { false, false };
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_sale, container, false);
        initview();
        initdata();
        return view;    
    }


    public void initview(){
        tabLayout = view.findViewById(R.id.tabsale);
        viewPager = view.findViewById(R.id.viewpagersale);
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                    if (!constants.city.equals(""))
//                    {
//                        fragments.set(1,new MonthSaleFragment()) ;
//                        fragmentsUpdateFlag[1] = true;
//                        Toast.makeText(SaleAcitivity.this,"你好",Toast.LENGTH_SHORT).show();
//                        myAdapter.notifyDataSetChanged();
//                    }
//                }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
    }


    public void initdata(){
        titles = new ArrayList<>();
        titles.add("销售分布");
        titles.add("月度处理量");
        fragments=new ArrayList<>();
        fragments.add(saleDistributionFragment);
        fragments.add(monthSaleFragment);
        fm = getActivity().getSupportFragmentManager();
        myAdapter = new MyAdapter1(fm,fragments,titles);

        viewPager.setAdapter(myAdapter);

        //添加标签
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)),true);//默认选中
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)),false);

        tabLayout.setupWithViewPager(viewPager);
        Log.e("fragment size:", String.valueOf(fragments.size()));
    }



    public class MyAdapter1<T extends Fragment> extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private List<String> titles;
        private FragmentManager fm;


        public MyAdapter1(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
            super(fm);
            this.fm=fm;
            this.fragments=fragments;
            this.titles=titles;
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

        @Override
        public int getItemPosition(Object object) {//最主要就是加了这个方法。
            return POSITION_NONE;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //得到缓存的fragment
            Fragment fragment= (Fragment) super.instantiateItem(container, position);
            //获取到tag
            String fragmentTag=fragment.getTag();
            if (fragmentsUpdateFlag[position % fragmentsUpdateFlag.length]){//如果这个fragment需要更新
                FragmentTransaction ft = fm.beginTransaction();
                //移除旧的fragment
                ft.remove(fragment);
                //换成新的fragment
                fragment = fragments.get(position % fragments.size());
                //添加新fragment时必须用前面获得的tag，这点很重要
                ft.add(container.getId(), fragment, fragmentTag ==null? fragment.getClass().getName()+position : fragmentTag);
                ft.attach(fragment);
                ft.commit();
                //复位更新标志
                fragmentsUpdateFlag[position % fragmentsUpdateFlag.length] = false;
            }else{
                fragment = fragments.get(position);
            }
            return fragment;
        }

    }
}
