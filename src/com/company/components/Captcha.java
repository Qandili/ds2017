package com.company.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class Captcha extends JPanel implements ActionListener,Runnable {
    JTextField captcha;
    JButton verify;
    JLabel question;
    Quiz quiz;
    JLabel message;
    public Captcha() {
        setLayout(new GridBagLayout());
        initializeElements();
        positionElements();
        addListeners();
        Thread deactivate=new Thread(this);
        deactivate.start();
    }
    public void addListeners(){
        verify.addActionListener(this);
    }
    public void initializeElements(){
        this.captcha = new JTextField(20);
        this.verify = new JButton("Verify");
        quiz=new Quiz();
        question=new JLabel(quiz.randomQuestion());
        message=new JLabel("");

    }

    public void positionElements(){
        GridBagConstraints gbc=new GridBagConstraints();
        Insets insets=new Insets(5,5,5,5);
        gbc.insets=insets;
        //La taille en hauteur et en largeur
        gbc.gridheight = 1;
        gbc.gridwidth = 1;


        gbc.gridx = 0;
        gbc.gridy = 0;
        add(question,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(captcha,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        add(verify,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(message,gbc);

    }

    public boolean verifyResult(){
        if (!captcha.getText().equals("")){
            double result=Double.parseDouble(captcha.getText());
            double realResult=(quiz.calculateValue());
            if (result==realResult){
                return true;
            }
            return false;
        }
        return false;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==verify){
            if (verifyResult()){
                message.setText("good job!");
            }else {
                message.setText("Sorry try again!!");
            }
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                if (captcha.getText().equals("")){
                    Thread.sleep(20000);
                    captcha.setEnabled(false);
                    message.setText("time out");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
