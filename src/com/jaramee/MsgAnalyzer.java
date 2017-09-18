package com.jaramee;

/*
 * 2017/09/13
 * ByeongGil Jung
 */

/*
 * < MsgAnalyzer >
 * - msg 의 모든 글자를 나눠 msg_char 라는 char 배열에 담는다
 * - 이후 msg_char 의 모든 값들을 string 으로 변환하여 msg_str 이라는 ArrayList 에 넣는다.
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MsgAnalyzer {

    private String msg = "";
    private ArrayList<String> msg_str = new ArrayList<>();
    private List<String> str_list;
    private char[] msg_char;

    public MsgAnalyzer(String msg_in) {
        this.msg_char = msg_in.toCharArray();
        this.str_list = Arrays.asList(msg_in.split(" ")); // 띄어쓰기로 msg 분할

        for (char char_piece : msg_char) {
            this.msg_str.add(Character.toString(char_piece));
        }

    }

    // 해당 index 에 해당하는 글자를 return
    public String getChar(int idx) {
        return this.msg_str.get(idx);
    }

    // 원하는 범위의 글자를 반환 (index로 범위 설정 - idx1 <= str < idx2)
    public String getLetters(int idx1, int idx2) {
        while (idx1 < idx2) {
            this.msg += msg_str.get(idx1);
            idx1 ++;
        }
        return this.msg;
    }

    // 띄어쓰기로 구분된 글자들을 idx 로 get
    public String getPiece(int idx) {
        return this.str_list.get(idx);
    }

    // msg 의 길이를 return
    public int getLength() {
        return this.msg_char.length;
    }
}
