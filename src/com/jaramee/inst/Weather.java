package com.jaramee.inst;

/*
 * 2017/09/16
 * ByeongGil Jung
 */

/*
 * < Inst/Weather >
 * - 날씨를 알려주는 명령어
 */


import javax.json.*;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;


public class Weather {
    private String msg = "";
    private ArrayList<String> wea_arr = new ArrayList<>();

    private String lat;
    private String lon;

    private InputStream current_weather_is;

    public Weather (String str1, String str2, String str3) {
        Map map = new Map(str1, str2, str3);
        this.lat = map.getLatLon()[0];
        this.lon = map.getLatLon()[1];
        this.getJSON("currently");
        this.getCurrentweather(this.current_weather_is);

        /*
        < API index >
        0 : 풍속
        1 : 하늘 상태
        2 : 강우량 / 강설량
        3 : 현재 온도
        4 : 최고 온도
        5 : 최저 온도
         */

        ArrayList<String> msg_arr = new ArrayList<>();
        msg_arr.add("현재 온도 : " + this.wea_arr.get(3) + "\n");
        msg_arr.add("최고 온도 : " + this.wea_arr.get(4) + "\n");
        msg_arr.add("최저 온도 : " + this.wea_arr.get(5) + "\n");
        msg_arr.add("풍속 : " + this.wea_arr.get(0) + "\n");
        msg_arr.add("현재 하늘 상태는 '" + this.wea_arr.get(1) + "' 입니다. \n");
        msg_arr.add("강수량 : " + this.wea_arr.get(2) + "\n");

        for (String s : msg_arr) {
            this.msg += s;
        }
    }

    public Weather (String str1, String str2, String str3, String condition) {
        Map map = new Map(str1, str2, str3);
        this.lat = map.getLatLon()[0];
        this.lon = map.getLatLon()[1];
        this.getJSON(condition);
    }


    private String getUrl_minutely () {
        String s = "http://apis.skplanetx.com/weather/current/minutely?" +
                "version=1" +
                "&lat=" + this.lat +
                "&lon=" + this.lon;
        return s;

    }

    private void getJSON(String condition) {
        try {
            // 상황에 맞게 수정해야 함.
            // 근데 switch 문이나 if 문에 url 구문을 넣을 시 작동하지 않음 !!
            // 왜 그럴까 ???

            URL url = new URL(this.getUrl_minutely());
            switch (condition) {
                case "currenctly" :
                    //URL url = new URL(this.getUrl_minutely());
                    break;
            }

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("appKey", "appkey 채워주세요!");

            switch (condition) {
                case "currently" :
                    this.current_weather_is = conn.getInputStream();
                    break;
            }

        } catch (IOException e) {
            this.msg = "위치를 정확히 입력해주세요! (ex : 경기도 시흥시 매화동)";
            e.printStackTrace();
        }
    }


    private void getCurrentweather(InputStream is) {
        JsonParser parser = Json.createParser(is);
        while (parser.hasNext()) {
            JsonParser.Event e = parser.next();
            if (e == JsonParser.Event.KEY_NAME) {
                switch (parser.getString()) {
                    case "wspd" :
                        parser.next();
                        this.wea_arr.add(parser.getString());
                        break;
                    case "sky" :
                        // 파싱하는 법 좀 더 공부하고 수정할 것.
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        this.wea_arr.add(parser.getString());
                        break;
                    case "rain" :
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        parser.next();
                        this.wea_arr.add(parser.getString());
                        break;
                    case "tc" :
                        parser.next();
                        this.wea_arr.add(parser.getString());
                        break;
                    case "tmax" :
                        parser.next();
                        this.wea_arr.add(parser.getString());
                        break;
                    case "tmin" :
                        parser.next();
                        this.wea_arr.add(parser.getString());
                        break;
                }
            }
        }
    }

    public InputStream getCurrent_weather_is() {
        return this.current_weather_is;
    }

    public String getMsg() {
        return msg;
    }
}
