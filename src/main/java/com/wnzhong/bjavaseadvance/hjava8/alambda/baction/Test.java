package com.wnzhong.bjavaseadvance.hjava8.alambda.baction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wayne
 */
public class Test {

    public static void main(String[] args) {

        JButton show = new JButton("Show");

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("default");
            }
        });

        show.addActionListener(
                (e) -> System.out.println("lambda expression")
        );

    }

}
