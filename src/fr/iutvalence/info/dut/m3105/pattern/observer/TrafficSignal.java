package fr.iutvalence.info.dut.m3105.pattern.observer;

import java.util.HashSet;
import java.util.Set;

public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalButtonObserver
{
	private TrafficSignalState state;
	
	private Set<TrafficSignalObserver> observers;
	
	public TrafficSignal()
	{
		super();
		this.observers = new HashSet<TrafficSignalObserver>();		
	}
	
	public void register(TrafficSignalObserver observer)
	{
		this.observers.add(observer);
	}

	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{		
		this.state = state;
		switch (state.getName())
		{
			case GREEN: 
				this.notify(TrafficSignalEvent.TURNED_GREEN);
				break;
			case ORANGE: 
				this.notify(TrafficSignalEvent.TURNED_ORANGE);
				break;
			case RED: 
				this.notify(TrafficSignalEvent.TURNED_RED);
				break;
		}
	}

	private void notify(TrafficSignalEvent event)
	{
		for (TrafficSignalObserver observer: this.observers)
			observer.notify(event);
	}

	@Override
	public void notifyButtonPressed()
	{
		this.notify(TrafficSignalEvent.BUTTON_PRESSED);
		this.state.buttonPressed();
	}
	
	public void run()
	{
		this.setTrafficSignalState(new TrafficSignalGreenState(this));
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.state.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}
	
}
