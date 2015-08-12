/**package stopwatch;

/// 

//Program to start stop and reset timer

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch extends JPanel
{
	private Timer myTimer1;
	public static final int ONE_SEC = 1000;   //time step in milliseconds
	public static final int TENTH_SEC = 100;

	private Font myClockFont;

	private JButton startBtn, stopBtn, resetBtn;
	private JLabel timeLbl;
	private JPanel topPanel, bottomPanel;

	private int clockTick;  	//number of clock ticks; tick can be 1.0 s or 0.1 s
	private double clockTime;  	//time in seconds
	private String clockTimeString;


	public StopWatch()
	{
		clockTick = 0;  		//initial clock setting in clock ticks
		clockTime = ((double)clockTick)/10.0;

		clockTimeString = new Double(clockTime).toString();
		myClockFont = new Font("Serif", Font.PLAIN, 50);

		timeLbl = new JLabel();
		timeLbl.setFont(myClockFont);
		timeLbl.setText(clockTimeString);

		startBtn = new JButton("Start");
		stopBtn = new JButton("Stop");
		resetBtn = new JButton("Reset");


		myTimer1 = new Timer(TENTH_SEC, new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			clockTick++;
			clockTime = ((double)clockTick)/10.0;
			clockTimeString = new Double(clockTime).toString();
			timeLbl.setText(clockTimeString);
			//System.out.println(clockTime);
		    }
		});


		startBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				myTimer1.start();
			}
		});

		stopBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				myTimer1.stop();
			}
		});

		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				clockTick = 0;
				clockTime = ((double)clockTick)/10.0;
				clockTimeString = new Double(clockTime).toString();
				timeLbl.setText(clockTimeString);
			}
		});

	}//end of StopWatch constructor

	public void launchStopWatch()
	{
		topPanel = new JPanel();
		topPanel.setBackground(Color.orange);
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.yellow);
		topPanel.add(timeLbl);
		bottomPanel.add(startBtn);
		bottomPanel.add(stopBtn);
		bottomPanel.add(resetBtn);

		this.setLayout(new BorderLayout());

		add(topPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(300,200);
		setBackground(Color.orange);

	}//end of launchClock

	public static void main(String[] args)
	{
		MyTestFrame myTestFrame1 = new MyTestFrame();
	}


}//end of public class

//Testing Code

class MyTestFrame extends JFrame
{
	StopWatch StopWatch1;

	public MyTestFrame()
	{
		super("My Stop Watch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container myPane = getContentPane();

		StopWatch1 = new StopWatch();
		StopWatch1.launchStopWatch();
		myPane.add(StopWatch1);
		pack();
		setVisible(true);
	}
}

**/
/**
package StopWatch;
import javax.swing.JFrame;
Public class StopWatchMain {
    /**
     * 
     * @param args 
     
    public static void main(string[] args)
    {
        JFrame frame = new Jframe ("STOP WATCH");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StopWatchPanel());
        frame.pack();
        frame.setVisible(true);
        System.out.println("Question three was called and ran successfully");
        
        
    }
}
*/

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
 
