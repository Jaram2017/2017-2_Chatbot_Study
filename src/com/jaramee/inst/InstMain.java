package com.jaramee.inst;

/*
 * 2017/09/13
 * ByeongGil Jung
 */

/*
 * < InstMain >
 * - 챗봇의 명령어를 구동하는 메소드
 *
 * "!명렁어" 형식으로 호출
 */


import java.util.Arrays;
import java.util.List;

public class InstMain {

    private String msg = "";

    public InstMain(String context) {
        List<String> msg_list = Arrays.asList(context.split(" "));

        System.out.println(msg_list.toString());

        switch (msg_list.get(0)) {
            case "help" :
                Help h = new Help();
                this.msg = h.getMsg();
                break;
            case "날씨" :
                if (msg_list.size() == 1) {
                    this.msg = "!날씨 A : A 의 날씨를 알려줍니다. (구현 예정)";
                }
                else if (msg_list.size() == 2) {
                    Weather wth1 = new Weather(msg_list.get(1));
                    this.msg = wth1.getMsg();
                }
                else if (msg_list.size() == 3) {
                    Weather wth2 = new Weather(msg_list.get(1), msg_list.get(2));
                    this.msg = wth2.getMsg();
                }
                else if (msg_list.size() == 4) {
                    Weather wth3 = new Weather(msg_list.get(1), msg_list.get(2), msg_list.get(3));
                    this.msg = wth3.getMsg();
                }
                else {
                    this.msg = "날씨 명령어를 정확히 입력해주세요! \n(ex: 경기도 시흥시 매화동)";
                }
                break;
            default :
                this.msg = "해당하는 명령어가 없습니다.";
                break;
        }
    }

    public String getMsg() {
        return this.msg;
    }
}
