package com.jaramee.inst;

/*
 * 2017/09/16
 * ByeongGil Jung
 */

/*
 * < Inst/Weather >
 * - 날씨를 알려주는 명령어
 */

import com.jaramee.MsgAnalyzer;

import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class Weather {
    private String msg = "";
    private MsgAnalyzer str_arr;
    private ArrayList<String> loc_arr = new ArrayList<>();
    private URL url;

    public Weather (String str1) {
        this.msg = str1;
    }

    public Weather (String str1, String str2) {
        this.msg = str1 + str2;
    }
    public Weather (String str1, String str2, String str3) {
        loc_arr.add(str1);
        loc_arr.add(str2);
        loc_arr.add(str3);
        String str = locAnalyzer(loc_arr);
        this.msg = str;
    }



    private String locAnalyzer (ArrayList<String> arr) {
        ArrayList<MsgAnalyzer> str_list = new ArrayList<>();
        for (int i=0; i<arr.size(); i++) {
            str_list.add(new MsgAnalyzer(arr.get(i)));
        }
        // 이제 각각의 str 들을 분석
        

        return "";
    }
    private String getUrl (){
        String s = "http://apis.skplanetx.com/weather/current/minutely?" +
                "version={version}&" +
                "lat={lat}&" +
                "lon={lon}&" +
                "city={city}&" +
                "county={county}&" +
                "village={village}&" +
                "stnid={stnid}";
        return s;

    }

    public String getMsg() {
        return msg;
    }
}
