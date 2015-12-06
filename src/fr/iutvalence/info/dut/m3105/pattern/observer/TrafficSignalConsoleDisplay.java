package fr.iutvalence.info.dut.m3105.pattern.observer;

public class TrafficSignalConsoleDisplay implements TrafficSignalObserver
{

	@Override
	public void notify(TrafficSignalEvent event)
	{
		switch (event)
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
