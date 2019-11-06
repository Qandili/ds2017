package com.company.components;

import javax.swing.*;
import java.awt.*;

public class Root extends JFrame {
    Captcha captcha;
    public Root() throws HeadlessException {
        setTitle("Captcha numerique");
        setBounds(0,0,500,500);
        setLocationRelativeTo(null);
        captcha=new Captcha();

        add(captcha);

        setVisible(true);
    }
}
