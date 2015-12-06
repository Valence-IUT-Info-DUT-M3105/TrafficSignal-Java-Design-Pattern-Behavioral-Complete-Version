package fr.iutvalence.info.dut.m3105.pattern.observer;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TrafficSignalButtonPresser extends Thread
{
	private final Set<TrafficSignalButtonObserver> observers;
	
	public TrafficSignalButtonPresser()
	{
		this.observers = new HashSet<TrafficSignalButtonObserver>();
	}
	
	public void register(TrafficSignalButtonObserver observer)
	{
		this.observers.add(observer);
	}
	
	public void run()
	{
		Random rng = new Random();
		
		while (true)
		{
			int delay = rng.nextInt(10);
			try
			{
				Thread.sleep(delay*1000);
			}
			catch (InterruptedException e)
			{
			}
			this.notifyButtonPressed();			
		}
	}

	private void notifyButtonPressed()
	{
		for (TrafficSignalButtonObserver observer: this.observers)
			observer.notifyButtonPressed();
	}
}
