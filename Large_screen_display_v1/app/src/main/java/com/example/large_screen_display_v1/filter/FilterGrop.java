package com.example.large_screen_display_v1.filter;


import com.example.large_screen_display_v1.filter.flow.TagFlowLayout;

import java.util.List;

/**
 * @author zwl
 * @describe 筛选 组
 * @date on 2020/7/17
 */
public class FilterGrop {
    public String gropName;
    public String key;//请求数据的key
    public int filterType = TagFlowLayout.TAG_MODE_SINGLE;
    public List<FilterBean> filters;


    @Override
    public String toString() {
        return "FilterGrop{" +
                "gropName='" + gropName + '\'' +
                ", filters=" + filters +
                '}';
    }
}
