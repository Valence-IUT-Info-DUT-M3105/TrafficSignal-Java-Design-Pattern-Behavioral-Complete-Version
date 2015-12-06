package fr.iutvalence.info.dut.m3105.pattern.observer.standard;

import java.util.Observable;
import java.util.Random;

public class TrafficSignalButtonPresser extends Observable implements Runnable
{
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
			this.setChanged();
			this.notifyObservers();			
		}
	}
}
