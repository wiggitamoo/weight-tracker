package com.wt.pkg;

import java.util.ArrayList;
import java.util.List;

public class AverageChart {
	List<Long> dates;
	List<Double> maxWeights;
	List<Double> minWeights;
	
	public AverageChart() {
		if(dates == null) {
			dates = new ArrayList<Long>();
		}
		if(maxWeights == null) {
			maxWeights = new ArrayList<Double>();
		}
		if(minWeights == null) {
			minWeights = new ArrayList<Double>();
		}
	}
	
	public List<Long> getDates() {
		return dates;
	}
	public void setDates(List<Long> dates) {
		this.dates = dates;
	}
	public List<Double> getMaxWeights() {
		return maxWeights;
	}
	public void setMaxWeights(List<Double> maxWeights) {
		this.maxWeights = maxWeights;
	}
	public List<Double> getMinWeights() {
		return minWeights;
	}
	public void setMinWeights(List<Double> minWeights) {
		this.minWeights = minWeights;
	}
	public void addTime(Long l) {
		dates.add(l);
	}
	public void addMaxWeight(double maxWeight) {
		maxWeights.add(maxWeight);
	}
	public void addMinWeight(double minWeight) {
		minWeights.add(minWeight);
	}

}
