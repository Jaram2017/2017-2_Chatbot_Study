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

import com.jaramee.inst.InstMain;

public class JarameeMain {
    private String msg = "";

    public JarameeMain(String msg_in) {
        MsgAnalyzer msg_arr = new MsgAnalyzer(msg_in);

        /*-------------------------------------------------------------------------*/
        // 병길 파트 //
        // 만약 첫글자가 '!' 라면 명령어 실행
        String inst = "!";
        if (msg_arr.getChar(0).equals(inst)) {
            int msg_length = msg_arr.getLength();
            String msg_context = msg_arr.getLetters(1, msg_length);
            InstMain inst_msg = new InstMain(msg_context);

            /*
            String msg_context = msg_arr.getLetters(1, msg_length); // 실질적인 내용 == msg_context
            MsgAnalyzer context_arr = new MsgAnalyzer(msg_context);
            int context_legnth = context_arr.getLength();

            String inst_kind = context_arr.getPiece(0);
            String inst_core = context_arr.getLetters(2, msg_length);

            InstMain inst_msg = new InstMain(inst_kind, inst_core);
            */

            /*
            // 만약 '!' 만 칠 경우 명령어 안내 실행
            if (inst_msg.getMsg().equals("")) {
                this.msg = inst_msg.getGuide();
            }
            // 그렇지 않은 경우 핵심 문장(msg_core) 를 분석하여 명령어 실행
            else {
                this.msg = inst_msg.getMsg();
            }
            */
            this.msg = inst_msg.getMsg();
        }

        /*-------------------------------------------------------------------------*/
        // 동철 파트 //
        else {
            this.msg = msg_in;
        }



        /*
        if (msg_in.equals("안뇽")) {
            this.msg = "안뇽안뇽!";
        }
        else {
            this.msg = "무슨 말인지 잘 모르겠네요 ㅠㅠ";
        }
        */
    }

    public String getMsg() {
        return this.msg;
    }
}
