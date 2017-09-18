package com.jaramee.inst;

/*
 * 2017/09/13
 * ByeongGil Jung
 */

/*
 * < Inst/Help >
 * - 명령어 목록을 알려주는 함수
 */

import java.util.ArrayList;

public class Help {

    private String msg = "";
    private ArrayList<String> help_list = new ArrayList<>();

    public Help () {
        this.getList();
        for (int i=0; i<help_list.size(); i++) {
            this.msg += (help_list.get(i) + "\n");
        }
    }

    private void getList() {
        help_list.add("< 자람이 명령어 >");
        help_list.add("!날씨 A : A 의 날씨를 알려줍니다. (구현 예정)");
        help_list.add("!길찾기 A B : A 부터 B 까지의 최단 경로를 알려줍니다. (구현 예정)");
        help_list.add("!학식 A : A 의 학식을 알려줍니다. (구현 예정)");
    }

    public String getMsg() {
        return this.msg;
    }
}
