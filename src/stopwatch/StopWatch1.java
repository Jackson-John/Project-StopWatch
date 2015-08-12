/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch;

/**
 *
 * @author Jackson
 */
//public class StopWatch1 { 
//}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch1 extends JPanel
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


	public StopWatch1()
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

class MyTestFrame1 extends JFrame
{
	StopWatch1 StopWatch2;

	public MyTestFrame1()
	{
		super("My Stop Watch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container myPane = getContentPane();

		StopWatch2 = new StopWatch1();
		StopWatch2.launchStopWatch();
		myPane.add(StopWatch2);
		pack();
		setVisible(true);
	}
}
