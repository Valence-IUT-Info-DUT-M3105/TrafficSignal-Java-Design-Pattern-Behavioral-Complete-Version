package fr.iutvalence.info.dut.m3105.pattern.observer;

public class Main
{
	public static void main(String[] args)
	{
		TrafficSignal trafficSignal = new TrafficSignal();
		TrafficSignalObserver display = new TrafficSignalConsoleDisplay();
		TrafficSignalButtonPresser buttonPresser = new TrafficSignalButtonPresser();

		trafficSignal.register(display);
		buttonPresser.register(trafficSignal);

		trafficSignal.start();
		buttonPresser.start();
	}
}
