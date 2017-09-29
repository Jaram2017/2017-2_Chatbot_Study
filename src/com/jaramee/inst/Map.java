package com.jaramee.inst;


/*
 * 2017/09/28
 * ByeongGil Jung
 */

/*
 * < Inst/Map >
 * - 지도 및 경위도 호출 method
 */

import com.jaramee.MsgAnalyzer;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Map {
    private String lat; // 세계 경도
    private String lon; // 세계 위도
    private String ko_lat; // 한국 경도로 변환
    private String ko_lon; // 한국 위도로 변환

    private String city;
    private String country;
    private String village;

    public Map (String loc1, String loc2, String loc3) {
        this.city = loc1;
        this.country = loc2;
        this.village = loc3;
    }

    private String getLatLon_url() {
        String url = "https://apis.skplanetx.com/tmap/geo/geocoding?" +
                "version=1" +
                "&city_do=" + this.city +
                "&gu_gun=" + this.country +
                "&dong=" + this.village;
        return url;
    }

    private String get_change_LatLon_url() {
        String url = "https://apis.skplanetx.com/tmap/geo/coordconvert?" +
                "version=1" +
                "&lat=" + this.lat +
                "&lon=" + this.lon;
        return url;
    }

    private void getAPI_LatLon(String url) {
        try {
            URL api_url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) api_url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("appkey", "appkey 채워주세요!");

            InputStream is = conn.getInputStream();
            JsonParser parser = Json.createParser(is);
            while (parser.hasNext()) {
                JsonParser.Event e = parser.next();
                if (e == JsonParser.Event.KEY_NAME) {
                    switch (parser.getString()) {
                        case "lat":
                            parser.next();
                            if (this.ko_lat == null) {
                                if (this.lat == null) {
                                    this.lat = parser.getString();
                                }
                                else {
                                    this.ko_lat = parser.getString();
                                }
                            }
                            break;
                        case "lon":
                            parser.next();
                            if (this.ko_lon == null) {
                                if (this.lon == null) {
                                    this.lon = parser.getString();
                                }
                                else {
                                    this.ko_lon = parser.getString();
                                }
                            }
                            break;
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getLatLon() {
        this.getAPI_LatLon(this.getLatLon_url());
        this.getAPI_LatLon(this.get_change_LatLon_url());
        String[] arr = {this.ko_lat, this.ko_lon};
        return arr;
    }

    /*
    private void locAnalyzer (ArrayList<String> arr) {
        ArrayList<MsgAnalyzer> str_list = new ArrayList<>();
        for (int i=0; i<arr.size(); i++) {
            str_list.add(new MsgAnalyzer(arr.get(i)));
            String temp_last = str_list.get(i).getChar(str_list.get(i).getLength()-1);
            switch (temp_last) {
                case "도" :
                    this.city = str_list.get(i).getLetters(0,2);
                    break;

                case "시" :
                    this.country = str_list.get(i).getEntireMsg();
                    break;
                case "군" :
                    this.country = str_list.get(i).getEntireMsg();
                    break;
                case "구" :
                    this.country = str_list.get(i).getEntireMsg();
                    break;

                case "동" :
                    this.village = str_list.get(i).getEntireMsg();
                    break;
                case "읍" :
                    this.village = str_list.get(i).getEntireMsg();
                    break;
                case "면" :
                    this.village = str_list.get(i).getEntireMsg();
                    break;
            }
        }
    }
    */
}
