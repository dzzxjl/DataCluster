package com.dzzxjl.DataCluster;

public class StandPoint {
	private double latitude;
	private double longtitude;
	private double comeTime;
	private double leaveTime;
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
	public double getComeTime() {
		return comeTime;
	}
	public void setComeTime(double comeTime) {
		this.comeTime = comeTime;
	}
	public double getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(double leaveTime) {
		this.leaveTime = leaveTime;
	}
	@Override
	public String toString() {
		return "var marker = new BMap.Marker(new BMap.Point(" + Double.toString(longtitude) + "," + Double.toString(latitude)
		+ "));" ;
//		return latitude + "***" + longtitude;
	}
}
