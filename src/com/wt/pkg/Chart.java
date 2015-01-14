package com.wt.pkg;

public class Chart {
	SeriesChart series = new SeriesChart();
	AverageChart average = new AverageChart();
	String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SeriesChart getSeries() {
		return series;
	}
	public void setSeries(SeriesChart series) {
		this.series = series;
	}
	public AverageChart getAverage() {
		return average;
	}
	public void setAverage(AverageChart average) {
		this.average = average;
	}	
}
