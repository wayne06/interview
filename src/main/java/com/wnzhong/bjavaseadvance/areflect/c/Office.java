package com.wnzhong.bjavaseadvance.areflect.c;

public class Office {

    public static void main(String[] args) {
        if ("Word".equals(args[0])) {
            Word word = new Word();
            word.start();
        }
        if ("Excel".equals(args[0])) {
            Excel excel = new Excel();
            excel.start();
        }
    }

}
