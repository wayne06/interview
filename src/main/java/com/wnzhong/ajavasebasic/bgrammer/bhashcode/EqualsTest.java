package com.wnzhong.ajavasebasic.bgrammer.bhashcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wayne
 */
public class EqualsTest {

    public static void main(String[] args) {

        //********************************* test equals ***************************************

        UserA userA1 = new UserA(1, "Allen", 14);
        UserA userA2 = new UserA(2, "Allen", 14);
        System.out.println(userA1.equals(userA2));

        UserB userB1 = new UserB(1, "Allen", 14);
        UserB userB2 = new UserB(2, "Allen", 14);
        System.out.println(userB1.equals(userB2));

        UserC userC1 = new UserC(1, "Allen", 14);
        UserC userC2 = new UserC(2, "Allen", 14);
        System.out.println(userC1.equals(userC2));

        //********************************* test hashcode ***************************************

        Set<UserA> userASet = new HashSet<>();
        userASet.add(userA1);
        userASet.add(userA2);
        System.out.println(userA1.hashCode() == userA2.hashCode());
        System.out.println(userASet);

        Set<UserB> userBSet = new HashSet<>();
        userBSet.add(userB1);
        userBSet.add(userB2);
        System.out.println(userB1.hashCode() == userB2.hashCode());
        System.out.println(userBSet);

        Set<UserC> userCSet = new HashSet<>();
        userCSet.add(userC1);
        userCSet.add(userC2);
        System.out.println(userC1.hashCode() == userC2.hashCode());
        System.out.println(userCSet);

    }

}
