package com.jaramee;

/*
 * 2017/09/11
 * ByeongGil Jung
 */

/*
 * < JarameeConn >
 * - 서버와 직접적으로 connect 하는 메소드
 *
 * JSON 형식으로 받는 메시지를 msg_req 라는 parameter 에 담음
 * 이후 JarameeMain 으로 parameter 를 넘겨 내부 로직 실행
 */


public class JarameeConn {
    private String msg = "";

    public JarameeConn(String msg_req) {
        JarameeMain test = new JarameeMain(msg_req);
        this.msg = test.getMsg();
    }

    public String msg_res() {
        return this.msg;
    }
}
