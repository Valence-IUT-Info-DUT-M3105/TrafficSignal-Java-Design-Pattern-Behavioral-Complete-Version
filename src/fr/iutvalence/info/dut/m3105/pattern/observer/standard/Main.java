package fr.iutvalence.info.dut.m3105.pattern.observer.standard;

public class Main
{
	public static void main(String[] args)
	{
		TrafficSignal trafficSignal = new TrafficSignal();
		TrafficSignalConsoleDisplay display = new TrafficSignalConsoleDisplay();
		TrafficSignalButtonPresser buttonPresser = new TrafficSignalButtonPresser();

		trafficSignal.addObserver(display);
		buttonPresser.addObserver(trafficSignal);

		new Thread(trafficSignal).start();
		new Thread(buttonPresser).start();
	}
}
