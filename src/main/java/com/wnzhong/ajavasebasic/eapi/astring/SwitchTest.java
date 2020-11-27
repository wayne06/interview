package com.wnzhong.ajavasebasic.eapi.astring;

/**
 * @author wayne
 */
public class SwitchTest {

    public static void main(String[] args) {
        byte a = 1;
        switch (a) {
            case 1:
                System.out.println("byte");
                break;
            default:
                System.out.println("default");
        }

        short b = 1;
        switch (b) {
            case 1:
                System.out.println("short");
            default:
                System.out.println("default");
                break;
        }

        char c = 'C';
        switch (c) {
            case 'C':
                System.out.println("char");
                break;
            default:
                System.out.println("default");
        }

        int d = 1;
        switch (d) {
            case 1:
                System.out.println("int");
                break;
            default:
                System.out.println("default");
        }

        String e = "abc";
        switch (e) {
            case "abc":
                System.out.println("String");
                break;
            default:
                System.out.println("default");
        }

        TestEnum testEnum = TestEnum.valueOf("type1".toUpperCase());
        switch (testEnum) {
            case TYPE1:
                System.out.println("enum type1");
                break;
            case TYPE2:
                System.out.println("enum type2");
                break;
            default:
                System.out.println("default");
        }
    }

    enum TestEnum {
        TYPE1,
        TYPE2
    }

}
