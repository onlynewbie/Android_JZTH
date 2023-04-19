package com.example.large_screen_display_v1.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.entity.fault;
import com.example.large_screen_display_v1.entity.information;
import com.example.large_screen_display_v1.view.BadViewPager;
import com.example.large_screen_display_v1.view.DataGridViewPlus;
import com.lingber.mycontrol.datagridview.DataGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备错误Fragment
 */
public class EquFaultFragment extends Fragment
{
    private List<fault> faults=new ArrayList<>();
    DataGridViewPlus mDataGridView;
    private MaterialRefreshLayout materialRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipment_fault,container,false);
        mDataGridView = view.findViewById(R.id.rv_equ_fault);
//        materialRefreshLayout=view.findViewById(R.id.fault_refresh);
        initdata();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void initdata(){
        fault fault1=new fault("设备一","报警信息一");
        fault fault2=new fault("设备二","报警信息二");
        fault fault3=new fault("设备二","报警信息二");
        fault fault4=new fault("设备二","报警信息二");
        fault fault5=new fault("设备二","报警信息二");
        fault fault6=new fault("设备二","报警信息二");
        fault fault7=new fault("设备二","报警信息二");
        fault fault8=new fault("设备二","报警信息二");
        fault fault9=new fault("设备二","报警信息二");
        fault fault10=new fault("设备二","报警信息二");
        fault fault11=new fault("设备二","报警信息二");
        fault fault12=new fault("设备二","报警信息二");
        fault fault13=new fault("设备二","报警信息二");
        fault fault14=new fault("设备二","报警信息二");
        fault fault15=new fault("设备二","报警信息二");
        fault fault16=new fault("设备二","报警信息二");
        fault fault17=new fault("设备二","报警信息二");
        fault fault18=new fault("设备二","报警信息二");
        fault fault19=new fault("设备二","报警信息二");
        fault fault20=new fault("设备二","报警信息二");
        fault fault21=new fault("设备二","报警信息二");
        fault fault22=new fault("设备二","报警信息二");
        fault fault23=new fault("设备二","报警信息二");
        fault fault24=new fault("设备二","报警信息二");

        fault fault26=new fault("设备二","报警信息二");
        fault fault25=new fault("设备二","报警信息二");
        fault fault27=new fault("设备二","报警信息二");
        fault fault28=new fault("设备二","报警信息二");

        information information1=new information();
        faults.add(fault1);
        faults.add(fault2);
        faults.add(fault3);
        faults.add(fault4);
        faults.add(fault5);
        faults.add(fault6);
        faults.add(fault7);
        faults.add(fault8);
        faults.add(fault9);
        faults.add(fault10);
        faults.add(fault11);
        faults.add(fault12);
        faults.add(fault13);
        faults.add(fault14);
        faults.add(fault15);
        faults.add(fault16);
        faults.add(fault17);
        faults.add(fault18);
        faults.add(fault19);
        faults.add(fault20);
        faults.add(fault21);
        faults.add(fault22);
        faults.add(fault23);
        faults.add(fault24);
        faults.add(fault25);
        faults.add(fault27);
        faults.add(fault26);
        faults.add(fault28);
        Toast.makeText(getActivity(),String.valueOf(123),Toast.LENGTH_SHORT);
        mDataGridView.setColunms(2);
        mDataGridView.setHeaderContentByStringId(new int[]{R.string.equ_name,R.string.fault_information});
        mDataGridView.setFieldNames(new String[]{"equ_name","equ_fault"});
        mDataGridView.setColunmWeight(new float[]{1,1});
        mDataGridView.setCellContentView(new Class[]{TextView.class, TextView.class});
        mDataGridView.setDataSource(faults);
        mDataGridView.setSelectedMode(1);
        mDataGridView.setSlidable(true);
        mDataGridView.setSortIsEnabled(new int[]{0, 2},true);
        mDataGridView.setHeaderHeight(100);  // 设置表头高度
        // 初始化表格
        mDataGridView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Toast.makeText(getActivity(),String.valueOf(scrollY),Toast.LENGTH_SHORT).show();
            }
        });
        mDataGridView.initDataGridView();

//        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
//            //下拉
//            @Override
//            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
//
//                materialRefreshLayout.finishRefresh();
//            }
//            //上拉
//            @Override
//            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
//                super.onRefreshLoadMore(materialRefreshLayout);
//            }
//        });
    }
}
