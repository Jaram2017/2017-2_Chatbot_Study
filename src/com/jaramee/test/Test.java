package com.jaramee.test;

import java.util.Scanner;
import com.jaramee.JarameeConn;

public class Test {
    public static void main(String args[]) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();
            if (value.equals("exit")) { break; }

            JarameeConn jc = new JarameeConn(value);
            System.out.println(jc.msg_res());
        }
    }
}
