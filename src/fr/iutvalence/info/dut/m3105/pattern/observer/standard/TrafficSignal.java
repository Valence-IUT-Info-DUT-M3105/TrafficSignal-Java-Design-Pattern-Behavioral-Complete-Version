package fr.iutvalence.info.dut.m3105.pattern.observer.standard;

import java.util.Observable;
import java.util.Observer;

public class TrafficSignal extends Observable implements Runnable, TrafficSignalContext, Observer
{
	private TrafficSignalState state;

	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{		
		this.state = state;
		this.setChanged();
		switch (state.getName())
		{
			case GREEN: 
				this.notifyObservers(TrafficSignalEvent.TURNED_GREEN);
				break;
			case ORANGE: 
				this.notifyObservers(TrafficSignalEvent.TURNED_ORANGE);
				break;
			case RED: 
				this.notifyObservers(TrafficSignalEvent.TURNED_RED);
				break;
		}
	}

	@Override
	public void update(Observable o, Object arg)
	{
		this.buttonPressed();		
	}
	
	private void buttonPressed()
	{
		this.setChanged();
		this.notifyObservers(TrafficSignalEvent.BUTTON_PRESSED);
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
