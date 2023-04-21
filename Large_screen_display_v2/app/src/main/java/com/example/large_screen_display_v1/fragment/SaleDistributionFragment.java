package com.example.large_screen_display_v1.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.common.constants;
import com.example.large_screen_display_v1.entity.MycolorArea;
import com.example.large_screen_display_v1.entity.User;
import com.example.large_screen_display_v1.util.ColorChangeUtil;
import com.example.large_screen_display_v1.view.AppBarStateChangeListener;
import com.example.large_screen_display_v1.view.ColorView;
import com.example.large_screen_display_v1.view.SmartTable;
import com.google.android.material.appbar.AppBarLayout;
import com.wxy.chinamapview.model.ChinaMapModel;
import com.wxy.chinamapview.model.ProvinceModel;
import com.wxy.chinamapview.view.ChinaMapView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaleDistributionFragment extends Fragment {
    private ChinaMapView map;
    private CheckBox checkBox;
    private AppBarLayout appBarLayout;
    private NestedScrollView nestedScrollView;
    private TextView tvname;
    private SmartTable smartTable;
    private HashMap<String, List<MycolorArea>> colorView_hashmap;
    private int currentColor = 0;
    private List<String> list;
    private ColorView colorView;
    private ChinaMapModel chinaMapModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_distribution,container,false);
        map=view.findViewById(R.id.map);
        checkBox=view.findViewById(R.id.checkBox);
        appBarLayout=view.findViewById(R.id.appbar);
        nestedScrollView=view.findViewById(R.id.nest);
        tvname=view.findViewById(R.id.mapname);
        smartTable=view.findViewById(R.id.smarttable);
        colorView=view.findViewById(R.id.color_view);
        initview();
        setColorView();
        initdata();

//        map.setOnPromiseParentTouchListener(new ChinaMapView.onPromiseParentTouchListener() {
//            @Override
//            public void onPromiseTouch(boolean promise) {
//
//            }
//        });
//        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                map.setEnableTouch(false);
//                //模拟耗时
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        String namestring = ColorChangeUtil.nameStrings[++currentColor %               ColorChangeUtil.nameStrings.length];
//                        btnChange.setText(namestring);
//                        colorView.setList(colorView_hashmap.get(namestring));
//                        //重置map各省份颜色
//                        ColorChangeUtil.changeMapColors(chinaMapModel, namestring);
//                        chinamapView.notifyDataChanged();
//                        swipe.setRefreshing(false);
//                        chinamapView.setEnableTouch(true);
//                    }
//                },2000);
//            }
//        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initview()
    {
        //滑动监听器
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {

                    //展开状态
                    map.setEnableTouch(true);
                    map.setEnableScroll(true);

                }else {
                    //中间状态
                    map.setEnableTouch(false);
                    map.setEnableScroll(false);
                }
            }
        });
        chinaMapModel = map.getChinaMapModel();
//        String nameString = ColorChangeUtil.nameStrings[++currentColor % ColorChangeUtil.nameStrings.length];
        String nameString = ColorChangeUtil.nameStrings[++currentColor % ColorChangeUtil.nameStrings.length];
        ColorChangeUtil.changeMapColors(chinaMapModel, nameString);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked())  chinaMapModel.setShowName(true);
                else chinaMapModel.setShowName(false);
                map.notifyDataChanged();
            }
        });
        map.setScaleMin(1);
        map.setScaleMax(3);
        for (ProvinceModel provinceModel:chinaMapModel.getProvincesList()){
            provinceModel.setNormalBorderColor(R.color.black);
            provinceModel.setSelectBorderColor(R.color.red);

        }
        map.notifyDataChanged();
        map.setOnPromiseParentTouchListener(new ChinaMapView.onPromiseParentTouchListener() {
            @Override
            public void onPromiseTouch(boolean promise) {
                nestedScrollView.setNestedScrollingEnabled(promise);
            }
        });
        map.setOnProvinceClickLisener(new ChinaMapView.onProvinceClickLisener() {
            @Override
            public void onSelectProvince(String provinceName) {
//                Toast.makeText(SupervisoryActivity.this,provinceName,Toast.LENGTH_SHORT).show();
                constants.city=provinceName;
                tvname.setText(provinceName);
                MonthSaleFragment.refreshBarChart();
            }
        });

    }


    /**
     * 暂时使用测试数据
     */
    public void initdata()
    {
        Column<String> city = new Column<>("部门/渠道", "city");
        Column<Integer> name = new Column<>("板块", "name");
        Column<Integer> count = new Column<>("目标值", "count");
        Column<Integer> restaurant = new Column<>("餐饮", "restaurant");
        Column<Integer> ka = new Column<>("KA", "ka");
        Column<Integer> wholesale = new Column<>("流通批发", "wholesale");
        Column<Integer> industry = new Column<>("工业加工", "industry");
        Column<Integer> other = new Column<>("其他", "other");
        //设置该列当字段相同时自动合并
//        city.setAutoMerge(true);
        List<User> list=new ArrayList<>();
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        TableData<User> tableData = new TableData<>("假设数据", list, city, name, count, restaurant, ka, wholesale, industry, other);
        smartTable.setTableData(tableData);
        smartTable.getConfig().setContentStyle(new FontStyle(50, Color.BLUE));

    }



    private void setColorView() {
        colorView_hashmap = new HashMap<>();
            String colors[] = ColorChangeUtil.colorStrings[2].split(",");
            String texts[] = ColorChangeUtil.textStrings[2].split(",");
            List<MycolorArea> list = new ArrayList<>();
            for (int j = 0; j < colors.length; j++) {
                MycolorArea c = new MycolorArea();
                c.setColor(Color.parseColor(colors[j]));
                c.setText(texts[j]);
                list.add(c);
            }
            colorView_hashmap.put(ColorChangeUtil.nameStrings[0], list);
        colorView.setList(colorView_hashmap.get(ColorChangeUtil.nameStrings[0]));
    }

}
