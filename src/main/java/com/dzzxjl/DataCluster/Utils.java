package com.dzzxjl.DataCluster;

public class Utils {
private static double EARTH_RADIUS = 6378.137;    
    
    private static double rad(double d) {    
        return d * Math.PI / 180.0;    
    }    
    public static double getDistance(Point p1,Point p2) {    
		double radLat1 = rad(p1.getLatitude());    
		double radLat2 = rad(p2.getLatitude());    
		double a = radLat1 - radLat2;    
		double b = rad(p1.getLongtitude()) - rad(p1.getLongtitude());    
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)    
		+ Math.cos(radLat1) * Math.cos(radLat2)    
		* Math.pow(Math.sin(b / 2), 2)));    
		s = s * EARTH_RADIUS;    
		s = Math.round(s * 10000d) / 10000d;    
		s = s*1000;    
		return s;    
    }
    
    public static int getTime(Point p1,Point p2) {    
    	int time;
    	double temp = p2.getTime() - p1.getTime();
    	time = (int) (temp * 24 * 3600);
    	time = Math.round((float)temp * 24 * 3600);
		return time;    
    }
}
