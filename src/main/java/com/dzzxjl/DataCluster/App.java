package com.dzzxjl.DataCluster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.mysql.jdbc.Util;

/**
 * @author dzzxjl
 *
 */
public class App 
{
	public static int MAX_DISTANCE = 200;
	public static int MAX_TIME = 1;

	public static void main( String[] args )
    {
    	 String filePath = "/Users/dzzxjl/Downloads/test3.plt";
    	 try {
             File file=new File(filePath);
             if(file.isFile() && file.exists()){ //判断文件是否存在
                 InputStreamReader read = new InputStreamReader(new FileInputStream(file));//考虑到编码格式
                 BufferedReader bufferedReader = new BufferedReader(read);
                 String lineTxt = null;
                 String[] lineContent = null;
                 int count = 0;
                 ArrayList<Point> points = new ArrayList<Point>();
                 ArrayList<Point> list = null;
                 ArrayList<StandPoint> standPoints = new ArrayList<StandPoint>();
                 int i = 0;
                 int j = 0;
                 int flag = 0;
                 while((lineTxt = bufferedReader.readLine()) != null){
                     if(count > 5){
	                        lineContent = lineTxt.split(",");
	                        Point point = new Point();
	                        point.setLatitude(Double.parseDouble(lineContent[0]));
	                        point.setLongtitude(Double.parseDouble(lineContent[1]));
	                        point.setTime(Double.parseDouble(lineContent[4]));
	                        points.add(point);
	                        System.out.println(point);
                     }
                     count++;
                 }
                 System.out.println("****" + points.size());
//                 for(i = 0;i < points.size() - 1;i++){
//                 	j = i + 1;
//                 	list = new ArrayList<Point>();
//                 	while(Utils.getDistance(points.get(i),points.get(j)) < MAX_DISTANCE && j < points.size() - 1){
//                 		list.add(points.get(j));
//                 		System.out.println("i:" + i + " j:" + j + "  "
//                 				+ Utils.getDistance(points.get(i),points.get(j)) + "  "
//                 				+ Utils.getTime(points.get(i),points.get(j)) );
//                 		j++;
//                 	}
//                 	if(Utils.getTime(points.get(i),points.get(j)) > MAX_TIME ){
//                 		standPoints.add(Utils.getStandPoint(list));
//                 	}
//                 }
//                 
                 while(i < points.size()){
                	 j = i + 1;
                	 flag = 0;
                	 list = new ArrayList<Point>();
                	 while( j < points.size()){
                		 if(Utils.getDistance(points.get(i),points.get(j)) > MAX_DISTANCE){
                			 if(Utils.getTime(points.get(i),points.get(j)) > MAX_TIME){
                				 standPoints.add(Utils.getStandPoint(list));
                				 i = j;
                				 flag = 1;
                			 }
                		 }
                		 list.add(points.get(j));
                		 j++;
                	 }
                	 if(flag != 1){
                		 i = i + 1;
                	 }
                 }
                 
                 
                 
                 for(StandPoint sp :standPoints ){
                 	System.out.println(sp);
                 	System.out.println("var label = new BMap.Label(\"我是停留点"+ (sp.getLeaveTime()-sp.getComeTime())*24*3600 + "\" ,{offset:new BMap.Size(20,-10)});");
                 	System.out.println("marker.setLabel(label);");
                 	System.out.println("map.addOverlay(marker);");
                 }
                 
                 System.out.println("得到的停留点个数" + standPoints.size());
                 
                 bufferedReader.close();
                 read.close();
     }else{
         System.out.println("找不到指定的文件");
     }
     } catch (Exception e) {
         System.out.println("读取文件内容出错");
         e.printStackTrace();
     }
    }
}
