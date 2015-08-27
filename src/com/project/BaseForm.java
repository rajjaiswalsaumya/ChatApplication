package com.project;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

/**
 * Created by grohit on 8/27/15.
 */
public abstract class BaseForm extends JFrame {

    public BaseForm() {
        init();
        initComponents();
        this.setVisible(true);
    }

    protected void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        setTitleBarBackground(Color.BLACK);
        setTitleBarForeGround(Color.WHITE);
        setToEffectiveScreenSize();
        expandToFullScreen();
    }

    protected abstract void initComponents();

    protected void centerToScreen() {
        setLocationRelativeTo(null);
    }

    protected void setTitleBarBackground(Color color) {
        UIManager.put("InternalFrame.activeTitleBackground", new ColorUIResource(color));
    }

    protected void setTitleBarForeGround(Color color) {
        UIManager.put("InternalFrame.activeTitleForeground", new ColorUIResource(color));
    }

    public void setToEffectiveScreenSize() {
        double width, height, x, y;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets bounds = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());

        width = screenSize.getWidth() - bounds.left - bounds.right;
        height = screenSize.getHeight() - bounds.top - bounds.bottom;

        y = (screenSize.getHeight() - height) / 2.0;
        x = (screenSize.getWidth() - width) / 2.0;

        setBounds((int) x, (int) y, (int) width, (int) height);
    }

    public void expandToFullScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        int taskBarSize = scnMax.bottom;
        setLocation(screenSize.width - getWidth(), screenSize.height - taskBarSize - getHeight());
    }

}
