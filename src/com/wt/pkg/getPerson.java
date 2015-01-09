package com.wt.pkg;

public class getPerson {
	String first = null;
	String last = null;
	
	public getPerson(double weight, String unit) {
		switch (unit) {
			case "lbs": 
				if(weight > 250) {
					first = "Wrong";
					last = "Weight";
					
				} else if(weight > 150) {
					first = "Andre";
					last = "Henriques";
					
				} else if (weight > 85) {
					first = "Paola";
					last = "Henriques";
				} else {
					first = "Wrong";
					last = "Weight";
				}
				break;
			case "oz":
				if(weight < 80) {					
					first = "Cheeky";
					last = "Henriques";
				} else {
					first = "Wrong";
					last = "Weight";
				}
				break;
			default:
				break;
		}
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
}
