package com.wt.pkg;

import java.util.ArrayList;
import java.util.List;

public class SeriesChart {
	List<Long> dates;
	List<Double> weights;
	public SeriesChart() {
		if(dates == null) {
			dates = new ArrayList<Long>();
		}
		if(weights == null) {
			weights = new ArrayList<Double>();
		}
	}
	
	public List<Long> getDates() {
		return dates;
	}
	public void setDates(List<Long> dates) {
		this.dates = dates;
	}
	public List<Double> getWeights() {
		return weights;
	}
	public void setWeight(List<Double> weights) {
		this.weights = weights;
	}
	public void addTime(Long ts) {
		dates.add(ts);
	}
	public void addWeight(double weight) {
		weights.add(weight);
	}
}
