package com.wnzhong.bjavaseadvance.areflect.d;

/**
 * @author wayne
 */
public class BetterOffice {

    public static void main(String[] args) {
        try {
            Class c = Class.forName(args[0]);
            OfficeAble officeAble = (OfficeAble) c.newInstance();
            officeAble.start();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
