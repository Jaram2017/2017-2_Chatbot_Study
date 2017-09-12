package com.jaramee;

/*
 * 2017/09/11
 * ByeongGil Jung
 */

/*
 * < JarameeMain >
 * - 실질적으로 입력받은 msg 를 처리하는 함수
 *
 */

public class JarameeMain {
    private String msg;

    public JarameeMain(String msg_in) {
        if (msg_in.equals("안뇽")) {
            this.msg = "안뇽안뇽!";
        }
        else {
            this.msg = "무슨 말인지 잘 모르겠네요 ㅠㅠ";
        }
    }

    public String getMsg() {
        return msg;
    }
}
