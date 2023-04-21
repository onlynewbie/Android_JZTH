package com.example.large_screen_display_v1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.com.lingber.mycontrol.datagridview.DataGridView;
import com.example.large_screen_display_v1.entity.information;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备信息Fragment
 */
public class EquInformationFragment extends Fragment {
    private List<information>informationList=new ArrayList<>();
    DataGridView mDataGridView;
    private MaterialRefreshLayout materialRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_equipment_information,container,false);
        mDataGridView = view.findViewById(R.id.rv_equ_information);
        materialRefreshLayout=view.findViewById(R.id.info_refresh);
        initdata();
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    public void initdata(){
        information information1=new information();
        information1.setEqu_name("设备一");
        information1.setEqu_model("型号一");
        information1.setAddress("上海");
        information1.setStatus("正常");
        informationList=new ArrayList<>();
        informationList.add(information1);
        informationList.add(new information("设备二","型号二","北京","正常"));

        mDataGridView.setColunms(4);
        mDataGridView.setHeaderContentByStringId(new int[]{R.string.equ_name,R.string.equ_model,R.string.address,R.string.status});
         mDataGridView.setFieldNames(new String[]{"equ_name","equ_model","address","status"});
        mDataGridView.setColunmWeight(new float[]{1,1,1,1});
        mDataGridView.setCellContentView(new Class[]{TextView.class, TextView.class, TextView.class, TextView.class});
        mDataGridView.setDataSource(informationList);
        mDataGridView.setSelectedMode(1);
        mDataGridView.setSlidable(true);
        mDataGridView.setHeaderHeight(100);  // 设置表头高度

        // 初始化表格

        mDataGridView.initDataGridView();
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            //下拉
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                materialRefreshLayout.finishRefresh();
            }
            //上拉
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
            }
        });
    }
}
