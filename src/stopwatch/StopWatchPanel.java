package StopWatch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import java.text.DecimalFormat;
import javax.swing.JFrame;


import java.awt.event.*;
import javax.swing.*;

public class StopWatchPanel extends JPanel
{
    private static int Second = 0;
    private static int tenthSecond = 0;
    private static Timer timer;
    private JLabel lbSecond;
    private JLabel lbTenthSecond;
    private JButton btnWatch;
    private JButton btnReset;
    private static final int DELAY = 100;
    private static final int SIZEWIDTH = 300;
    private static final int SIZEHEIGHT = 150;
    private static final int SIZE=50;
    
    
    public StopWatchPanel() {
        setLayout(new BorderLayout());
        JPanel t1 = new JPanel();
        JPanel t3 = new JPanel();
        lbSecond = new JLabel("0" + Second);
        lbSecond.setFont(new Font("TimesRoman" , Font.BOLD , SIZE));
        lbSecond.setHorizontalAlignment(Second);
        TitledBorder titled = new TitledBorder("'");
        TitledBorder titled1 = new TitledBorder("\")");
        lbSecond.setBorder(titled);
        t1.add(lbSecond);
        lbTenthSecond = new JLabel("0" + tenthSecond);
        lbTenthSecond.setFont(new Font ("TimesRoman", Font.BOLD , SIZE));
        lbTenthSecond.setHorizontalAlignment(Second);
        lbTenthSecond.setBorder(titled1);
        t1.add(lbTenthSecond);
        t1.setBackground(Color.GRAY);
        add(t1 , BorderLayout.NORTH);
        t1.setLayout(new GridLayout(1,2));
        btnWatch = new JButton("START");
        t3.add(btnWatch);
        btnWatch.addActionListener((ActionListener) new WatchButtonListener());
        btnReset = new JButton("RESET");
        t3.add(btnReset);
        btnReset.addActionListener(new WatchButtonListener());
        add(t3, BorderLayout.CENTER);
        t3.setLayout(new GridLayout(1,2));
        timer= new Timer(DELAY , new TimerListener());
        setPreferredSize(new Dimension(SIZEWIDTH,SIZEHEIGHT));
        setBackground(Color.white);   
        
    }
    
    private class WatchButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            DecimalFormat fmt= new DecimalFormat("00");
            if (event.getActionCommand().equals("START")){
                btnWatch.setText("STOP");
                btnReset.setEnabled(false);
                timer.start();
            }else if (event.getActionCommand().equals("RESET")){
                Second=0;
                tenthSecond=0;
                lbSecond.setText("" + fmt.format(Second));
                lbTenthSecond.setText(""+fmt.format(tenthSecond));
                btnWatch.setText("START");
            } else if (event.getActionCommand().equals("RESUME")){
                timer.start();
                btnWatch.setText("STOP");
                btnReset.setEnabled(false);
            } else {
                timer.stop();
                btnWatch.setText("RESUME");
                btnReset.setEnabled(true);
            }
        }
    }
                
                
        private static final int SECOND=10;
        
        private class TimerListener implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                DecimalFormat fmt = new DecimalFormat("00");
                tenthSecond++;
                if (tenthSecond == SECOND){
                    Second++;
                    tenthSecond=0;
                    lbSecond.setText ("" + fmt.format(Second));
                }
                lbTenthSecond.setText("" + fmt.format(tenthSecond));
            }
            }
        public static void main(String[] args)
    {
        JFrame frame = new JFrame ("STOP WATCH");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StopWatchPanel());
        frame.pack();
        frame.setVisible(true);
        System.out.println("Question three was called and ran successfully");
        
        
    }
}
 
