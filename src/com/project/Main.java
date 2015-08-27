package com.project;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean lookAndFeelSet = false;
        String lookAndFeel = "";
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    lookAndFeel = info.getClassName();
                    lookAndFeelSet = true;
                    break;
                }
            }
            if (!lookAndFeelSet) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
                if (lookAndFeel == "") {
                    lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
                }
            }
            if (lookAndFeel != "") {
                System.out.println("Available look and feel is " + lookAndFeel);
                javax.swing.UIManager.setLookAndFeel(lookAndFeel);
            }


        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            // Log here no theme available
        }

        new LoginForm();
    }
}
