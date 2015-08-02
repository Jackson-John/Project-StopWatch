package stopwatch;

/// Stop watch Frame

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

