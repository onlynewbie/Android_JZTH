package com.example.large_screen_display_v1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.large_screen_display_v1.R;
import com.example.large_screen_display_v1.entity.MycolorArea;
import com.example.large_screen_display_v1.util.EChartOptionUtil;
import com.example.large_screen_display_v1.view.EChartView;

import java.util.HashMap;
import java.util.List;

public class MonthSaleFragment extends Fragment {

    private static EChartView barChart;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_month_sale,container,false);
        barChart = view.findViewById(R.id.barChart);
        barChart.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                refreshBarChart();
            }
        });
        return view;
    }

    static void refreshBarChart(){
        //定义一个数组x，用来显示星期几
        Object[] x = new Object[]{
                "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"
        };
        //用来显示每天对应的数据
        Object[] y = new Object[]{
                820, 932, 901, 934, 1290, 1330, 1320,120,150,660,990,1000
        };
        //刷新图标
        barChart.refreshEchartsWithOption(EChartOptionUtil.getBarChartOptions(x, y));

    }



}
