package fr.iutvalence.info.dut.m3105.pattern.state;


public class TrafficSignal extends Thread implements TrafficSignalContext, TrafficSignalUserInterface
{
	private TrafficSignalState state;

	@Override
	public void setTrafficSignalState(TrafficSignalState state)
	{
		System.out.println("Traffic signal state is "+state.getName());
		this.state = state;		
	}

	@Override
	public void pressButton()
	{
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
