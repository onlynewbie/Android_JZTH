package com.example.large_screen_display_v1.util;

import androidx.annotation.NonNull;

import com.example.large_screen_display_v1.common.constants;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EChartOptionUtil {

    @NonNull
    public static GsonOption getBarChartOptions(Object[] xAxis, Object[] yAxis){
        GsonOption option = new GsonOption();
        String title=constants.city+"月季度处理量统计";
        option.title(title);
        option.legend("月份");
        option.tooltip().trigger(Trigger.axis);

        ValueAxis valueAxis = new ValueAxis();
        option.yAxis(valueAxis);//添加y轴，将y轴设置为值轴
        String[] colors = { "#4962FC", "#768BFF"};
        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.axisLabel().setInterval(0);
        categorxAxis.data(xAxis);//设置x轴的类目属性
        option.xAxis(categorxAxis);//添加x轴

        Bar bar = new Bar();
//        bar.itemStyle().normal().setColor("#fe8104");
        for (int i = 0; i < xAxis.length; i++) {
            int data = (int) yAxis[i];
            String color = colors[i%2];
            // 类目对应的柱状图
            HashMap<String, Object> map = new HashMap<String, Object>(2);
            map.put("value", data);
            map.put("itemStyle",
                    new ItemStyle().normal(new Normal().color(color)));
            bar.data(map);
        }
        //设置饼图的相关属性

        option.series(bar);
        return option;
    }
}
