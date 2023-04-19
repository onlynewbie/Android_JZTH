package com.example.large_screen_display_v1.filter;


import com.example.large_screen_display_v1.filter.flow.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwl
 * @describe  测试数据
 */
public class FilterDataUtils {
    /**
     * 这里是测试模拟数据（实际是后台返回）
     *
     * @return
     */
    public static List<FilterGrop> getFilterData() {
        List<FilterGrop> filterGrops = new ArrayList<>();

        //学历要求
        FilterGrop filterGrop = new FilterGrop();
        filterGrop.gropName = "设备名称";
        filterGrop.key="sbmc";
        filterGrop.filters = new ArrayList<>();
        filterGrop.filters.add(new FilterBean(FilterBean.UNLIMITED, "不限"));
        filterGrop.filters.add(new FilterBean("1_1", "设备一"));
        filterGrop.filters.add(new FilterBean("1_2", "设备二"));
        filterGrop.filters.add(new FilterBean("1_3", "设备一"));
        filterGrop.filters.add(new FilterBean("1_4", "设备一"));
        filterGrop.filters.add(new FilterBean("1_5", "设备一"));
        filterGrop.filters.add(new FilterBean("1_6", "设备一"));
        filterGrop.filters.add(new FilterBean("1_7", "设备一"));
        filterGrops.add(filterGrop);


        //薪资待遇
        FilterGrop filterGrop1 = new FilterGrop();
        filterGrop1.gropName = "设备型号";
        filterGrop1.key="sbxh";
        filterGrop1.filterType = TagFlowLayout.TAG_MODE_SINGLE;
        filterGrop1.filters = new ArrayList<>();
        filterGrop1.filters.add(new FilterBean(FilterBean.UNLIMITED, "不限"));
        filterGrop1.filters.add(new FilterBean("2_1", "型号一"));
        filterGrop1.filters.add(new FilterBean("2_2", "型号二"));
        filterGrop1.filters.add(new FilterBean("2_3", "型号一"));
        filterGrop1.filters.add(new FilterBean("2_4", "型号一"));
        filterGrop1.filters.add(new FilterBean("2_5", "型号一"));
        filterGrop1.filters.add(new FilterBean("2_6", "型号一"));
        filterGrops.add(filterGrop1);


        //经验要求
        FilterGrop filterGrop2 = new FilterGrop();
        filterGrop2.gropName = "安装地区";
        filterGrop2.key="azdq";
        filterGrop2.filters = new ArrayList<>();
        filterGrop2.filters.add(new FilterBean(FilterBean.UNLIMITED, "不限"));
        filterGrop2.filters.add(new FilterBean("3_1", "北京"));
        filterGrop2.filters.add(new FilterBean("3_2", "上海"));
        filterGrop2.filters.add(new FilterBean("3_3", "深圳"));
        filterGrop2.filters.add(new FilterBean("3_4", "济南"));
        filterGrop2.filters.add(new FilterBean("3_5", "北京"));
        filterGrop2.filters.add(new FilterBean("3_6", "北京"));
        filterGrop2.filters.add(new FilterBean("3_7", "北京"));
        filterGrops.add(filterGrop2);


        //融资阶段
        FilterGrop filterGrop5 = new FilterGrop();
        filterGrop5.gropName = "工作状态";
        filterGrop5.key="gzzt";
        filterGrop5.filters = new ArrayList<>();
        filterGrop5.filters.add(new FilterBean(FilterBean.UNLIMITED, "不限"));
        filterGrop5.filters.add(new FilterBean("5_1", "正常"));
        filterGrop5.filters.add(new FilterBean("5_2", "异常"));
        filterGrops.add(filterGrop5);

        //行业分类
        FilterGrop filterGrop3 = new FilterGrop();
        filterGrop3.gropName = "123";
        filterGrop3.key="hyfl";
        filterGrop3.filters = new ArrayList<>();
        filterGrop3.filters.add(new FilterBean(FilterBean.UNLIMITED, "不限"));
        filterGrop3.filters.add(new FilterBean("4_1", "电子商务"));
        filterGrop3.filters.add(new FilterBean("4_2", "游戏"));
        filterGrop3.filters.add(new FilterBean("4_3", "媒体"));
        filterGrop3.filters.add(new FilterBean("4_4", "广告营销"));
        filterGrop3.filters.add(new FilterBean("4_5", "数据服务"));
        filterGrop3.filters.add(new FilterBean("4_6", "医疗健康"));
        filterGrop3.filters.add(new FilterBean("4_7", "生活服务"));
        filterGrop3.filters.add(new FilterBean("4_8", "O2O"));
        filterGrop3.filters.add(new FilterBean("4_9", "旅游"));
        filterGrop3.filters.add(new FilterBean("4_10", "分类信息"));
        filterGrop3.filters.add(new FilterBean("4_11", "音乐/视频/阅读"));
        filterGrop3.filters.add(new FilterBean("4_12", "在线教育"));
        filterGrop3.filters.add(new FilterBean("4_13", "社交网络"));
        filterGrop3.filters.add(new FilterBean("4_14", "人力资源服务"));
        filterGrop3.filters.add(new FilterBean("4_15", "企业服务"));
        filterGrop3.filters.add(new FilterBean("4_16", "信息安全"));
        filterGrop3.filters.add(new FilterBean("4_17", "智能硬件"));
        filterGrop3.filters.add(new FilterBean("4_18", "移动互联网"));
        filterGrop3.filters.add(new FilterBean("4_19", "互联网"));
        filterGrop3.filters.add(new FilterBean("4_20", "计算机软件"));
        filterGrop3.filters.add(new FilterBean("4_21", "通信/网络设备"));
        filterGrop3.filters.add(new FilterBean("4_22", "广告/公关/会展"));
        filterGrop3.filters.add(new FilterBean("4_23", "互联网金融"));
        filterGrop3.filters.add(new FilterBean("4_24", "物流/仓储"));
        filterGrop3.filters.add(new FilterBean("4_25", "贸易/进出口"));
        filterGrop3.filters.add(new FilterBean("4_26", "咨询"));
        filterGrop3.filters.add(new FilterBean("4_27", "工程施工"));
        filterGrop3.filters.add(new FilterBean("4_28", "汽车生产"));
        filterGrop3.filters.add(new FilterBean("4_29", "其他行业"));
        filterGrops.add(filterGrop3);




        return filterGrops;

    }
}
