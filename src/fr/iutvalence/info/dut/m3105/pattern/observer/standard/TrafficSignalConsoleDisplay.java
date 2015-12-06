package fr.iutvalence.info.dut.m3105.pattern.observer.standard;

import java.util.Observable;
import java.util.Observer;

public class TrafficSignalConsoleDisplay implements Observer
{
	public void update(Observable observed, Object event)
	{
		switch ((TrafficSignalEvent) event)
		{
			case BUTTON_PRESSED: 
				System.out.println("Button pressed!");
				break;
			case TURNED_GREEN: 
				System.out.println("Traffic signal turns GREEN");
				break;
			case TURNED_ORANGE: 
				System.out.println("Traffic signal turns ORANGE");
				break;			
			case TURNED_RED: 
				System.out.println("Traffic signal turns RED");
				break;			
		}
		
	}
}
