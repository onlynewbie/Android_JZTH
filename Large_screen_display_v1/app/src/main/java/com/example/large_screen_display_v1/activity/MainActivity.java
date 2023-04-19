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
import com.zxl.library.DropDownMenu;

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
    DropDownMenu mDropDownMenu;
    private String headers[] = {"设备型号", "安装地区", "状态", "筛选"};
    private int[] types = new int[]{DropDownMenu.TYPE_LIST_CITY, DropDownMenu.TYPE_LIST_CITY, DropDownMenu.TYPE_LIST_CITY,DropDownMenu.TYPE_CUSTOM};
    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String status[] = {"不限","正常","异常"};
    private String variety[] = {"不限", "型号一","型号二","型号三","型号四"};
    FilterLayout mFilterLayout;
    Button button;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDropDownMenu= (DropDownMenu) findViewById( R.id.dropDownMenu);
        initView();
        button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, FilterActivity.class);
                startActivity(intent);
            }
        });
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
    private void initView() {
        View contentView = getLayoutInflater().inflate(R.layout.contentview, null);
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), initViewData(), contentView);
        //该监听回调只监听默认类型，如果是自定义view请自行设置，参照demo
        mDropDownMenu.addMenuSelectListener(new DropDownMenu.OnDefultMenuSelectListener() {
            @Override
            public void onSelectDefaultMenu(int index, int pos, String clickstr) {
                //index:点击的tab索引，pos：单项菜单中点击的位置索引，clickstr：点击位置的字符串
                Toast.makeText(getBaseContext(), clickstr, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 设置类型和数据源：
     * DropDownMenu.KEY对应类型（DropDownMenu中的常量，参考上述核心源码）
     * DropDownMenu.VALUE对应数据源：key不是TYPE_CUSTOM则传递string[],key是TYPE_CUSTOM类型则传递对应view
     */
    private List<HashMap<String, Object>> initViewData() {
        List<HashMap<String, Object>> viewDatas = new ArrayList<>();
        HashMap<String, Object> map = null;
//        for (int i = 0; i < headers.length; i++) {
//            map = new HashMap<String, Object>();
//            map.put(DropDownMenu.KEY, types[i]);
//            switch (types[i]) {
//                case DropDownMenu.TYPE_LIST_CITY:
//                    map.put(DropDownMenu.VALUE, citys);
//                    map.put(DropDownMenu.SELECT_POSITION,2);
//                    break;
//                case DropDownMenu.TYPE_LIST_SIMPLE:
//                    map.put(DropDownMenu.VALUE, ages);
//                    map.put(DropDownMenu.SELECT_POSITION,5);
//                    break;
//                case DropDownMenu.TYPE_GRID:
//                    map.put(DropDownMenu.VALUE, constellations);
//                    break;
//                default:
//                    map.put(DropDownMenu.VALUE, getCustomView());
//                    break;
//            }
//            viewDatas.add(map);
//        }
        map = new HashMap<String, Object>();
        map.put(DropDownMenu.KEY, types[0]);
        map.put(DropDownMenu.VALUE, variety);
        viewDatas.add(map);

        map = new HashMap<String, Object>();
        map.put(DropDownMenu.KEY, types[1]);
        map.put(DropDownMenu.VALUE, citys);
        viewDatas.add(map);

        map = new HashMap<String, Object>();
        map.put(DropDownMenu.KEY, types[2]);
        map.put(DropDownMenu.VALUE, status);
        viewDatas.add(map);

        map = new HashMap<String, Object>();
        map.put(DropDownMenu.KEY, types[3]);
        map.put(DropDownMenu.VALUE, getCustomView());
        viewDatas.add(map);
        return viewDatas;
    }

    private View getCustomView() {
        View v = getLayoutInflater().inflate(R.layout.custom, null);
        TextView btn = (TextView) v.findViewById(R.id.btn);

        TextView mFilterResultTV;
        TextView mFilterResultNum;
        ImmersionBar.with(this).statusBarDarkFont(true).init();

        mFilterLayout = v.findViewById(R.id.filter_list);
        mFilterLayout.setFilterData(FilterDataUtils.getFilterData());
        mFilterLayout.setOnFilterChangeListener(new FilterLayout.OnFilterChangeListener() {
            @Override
            public void result(Map<String, List<FilterBean>> result) {
                if (result != null) {
                    Iterator<Map.Entry<String, List<FilterBean>>> iterator = result.entrySet().iterator();
                    int num = 0;
                    while (iterator.hasNext()) {
                        List<FilterBean> value = iterator.next().getValue();
                        num += value.size();
                        for(FilterBean filterBean:value)
                        {
                            Log.i("mingzi",filterBean.name);
                        }
                    }

                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDropDownMenu.setTabText(3,"自定义");//设置tab标签文字
                mDropDownMenu.closeMenu();//关闭menu
            }
        });
        return v;
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 重置
     *
     * @param view
     */
    public void reset(View view) {
        mFilterLayout.reset();
    }

    /**
     * 确定
     *
     * @param view
     */
    public void ok(View view) {
        List result = mFilterLayout.result();
        Log.e("FilterActivity", "" + result.toString());
    }

    /**
     * 关闭
     *
     * @param view
     */
    public void close(View view) {
        finish();
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