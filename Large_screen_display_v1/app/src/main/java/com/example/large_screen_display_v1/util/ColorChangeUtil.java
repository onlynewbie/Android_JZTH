package com.example.large_screen_display_v1.util;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.example.large_screen_display_v1.R;
import com.wxy.chinamapview.model.ChinaMapModel;
import com.wxy.chinamapview.model.ProvinceModel;

import java.util.HashMap;

public class ColorChangeUtil {
        private static HashMap<String, String> hashmap;
public static String province_datas[]={"北京_17.58_6.87_427_1435","天津_7.29_11.75_376_1208",
        "河北_-2.84_9.54_414_1090_431_1141" ,
        "山西_26.53_60.18_331_934_370_937" ,
        "内蒙古_-19.44_-16.02_576_1640_266_725" ,
        "山东_-0.06_-0.04_404_1105_420_1149" ,
        "辽宁_-2.82_1.37_275_926_306_1105" ,
        "吉林_-2.8_-1.91_221_664_274_853" ,
        "黑龙江_27.24_23.19_275_832_294_893" ,
        "上海_-14.35_-6.65_288_965_345_1178" ,
        "江苏_-11.3_-6.26_407_1191_444_1293" ,
        "浙江_18.97_-3.33_481_1038_521_1122" ,
        "安徽_-13.9_-9.1_411_1306_418_1332" ,
        "福建_-34.11_-47.99_254_591_254_591" ,
        "江西_25.16_20.76_364_1075_367_1081" ,
        "河南_10.46_13.25_292_887_308_929" ,
        "湖北_2.29_9.56_300_1062_308_1120" ,
        "湖南_-39.49_-31.74_171_694_161_689" ,
        "重庆_-36.36_-24.38_167_735_187_840" ,
        "四川_-9.82_6.23_267_821_0_0" ,
        "广东_-31.2_-33.13_250_705_256_719" ,
        "广西_0_0_0_0_0_0" ,
        "海南_-22.71_-22.3_429_1171_469_1282" ,
        "贵州_18.03_23.46_173_446_0_0" ,
        "云南_-14.46_-0.55_277_684_83_236" ,
        "陕西_5.31_0.35_481_1322_513_1405" ,
        "甘肃_88.44_27.21_224_681_302_923" ,
        "青海_757.91_646.46_322_861_398_1085" ,
        "宁夏_-27.58_-34.42_299_840_313_880" ,
        "新疆_-6.28_-5.69_175_454_301_1017" ,
        "西藏_25.18_31.82_210_643_0_0",
        "香港_0_0_0_0_0_0",
        "澳门_0_0_0_0_0_0",
        "台湾_0_0_0_0_0_0"
};
    public static String colorStrings[] = {"#D50D0D,#DC5754,#E98683,#F8CECF,#D3DFD5,#8DB093,#5E9361,#1C6620",
            "#D50D0D,#DC5754,#E98683,#F8CECF,#D3DFD5,#8DB093,#5E9361,#1C6620",
            "#E9EFF4,#D4E1EA,#BDD1DF,#A8C2D5,#92B3CA,#7DA4C0,#6794B5,#5185AB,#3B76A0",
            "#EAEFF5,#D5E0E9,#BFCFDE,#A6C0D8,#92B2CE,#7CA5C1,#6792B6,#4F85AE,#3E759B,#256796"};
    public static String textStrings[] = {"~-30,-30~-20,-20~-10,-10~0,0~10,10~20,20~30,30~",
            "~-30,-30~-20,-20~-10,-10~0,0~10,10~20,20~30,30~",
            "150~,200~,250~,300~,350~,400~,450~,500~,550~",
            "400~,500~,600~,700~," +
                    "800~,900~,1000~,1100~,1200~,1300~,"};
    public static String nameStrings[] = {"销售分布"};
    public static void changeMapColors(ChinaMapModel mymap, String type){
            if (hashmap==null){
             hashmap=new HashMap();
             for (int i=0;i<province_datas.length;i++){
                     hashmap.put(province_datas[i].split("_")[0],province_datas[i]);
             }
            }
            switch (type){
                    case "销售分布":
                        getMapColors(mymap,150,50,2);
                       break;
            }

    }
    //最小值，之间间隔，type
    public static void getMapColors(@NonNull ChinaMapModel mymap, float min, float average, int type){
        for (ProvinceModel p:mymap.getProvincesList()){
            if (hashmap.containsKey(p.getName())){
                if (hashmap.get(p.getName())!=null) {
                    float a = Float.parseFloat(hashmap.get(p.getName()).split("_")[type + 1]);
                    int b = (int) ((a - min) / average + 1);
                    if (b <= 0) {
                        b = 0;
                    } else if (b >= textStrings[type].split(",").length - 1) {
                        b = textStrings[type].split(",").length - 1;
                    }
                    p.setColor(Color.parseColor(colorStrings[type].split(",")[b]));
                }
            }
            p.setSelectBorderColor(R.color.red);
        }
    }
}