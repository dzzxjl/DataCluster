package com.dzzxjl.DataCluster;

public class Point {
	private double latitude;
	private double longtitude;
	private double time;
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

//	@Override
//	public String toString() {
//		return "latitude:" + Double.toString(latitude)
//		       + " longtitude:" + Double.toString(longtitude) + " time:" + 	Double.toString(time);
//	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "var marker = new BMap.Marker(new BMap.Point(" + Double.toString(longtitude) + "," + Double.toString(latitude)
		+ "));" ;
	}
	
}
