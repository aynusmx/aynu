package cn.aynu.dianti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class OurElevator{
final int TOP_FLOOR = 12;
private boolean doorOpen;  
    private int floor;  
    private int weight;  
    final int CAPACITY=1000;
    final int BOTTOM_FLOOR = 1;
 
 
public void OurElevarot(){ 
  doorOpen=false;  
  floor = 1;//当前楼层   
  weight = 0;  
 
}
      
    public void openDoor()  
    {  
        doorOpen = true;  
        
    } 
      
    public void closeDoor() throws InterruptedException  
    {  
        checkWeightSensors();  
        if(weight<=CAPACITY)  
            doorOpen = false;  
        else { 
        System.out.println("电梯超重，请按规定乘坐"); 
        checkWeightSensors();
        while(weight>=CAPACITY) {
        	checkWeightSensors();
        	System.out.println("电梯超重，请按规定乘坐");
        }
        System.out.println("符合标准继续上楼");
        }
        
    }  
      
    private void checkWeightSensors()  
    {  
        weight = (int)(Math.random()*1500);  
        System.out.println("当前重量为:"+weight+"t");  
    }  
    
     
 
public void goUp() throws InterruptedException {
  // TODO Auto-generated method stub
   if(!doorOpen)  
         {  
             if(floor<TOP_FLOOR)  
             {  
                 floor++;  
                 System.out.println("您已到达"+floor+"层"); 
                 for (int j = 0; j < 3; j++) {
                     System.out.println("···");
                     Thread.sleep(500);
                 }
             }  
             else  
             System.out.println("您在顶楼无法继续向上");  
         }  
 
}
public void goDown() throws InterruptedException {
  // TODO Auto-generated method stub
   if(!doorOpen)  
         {  
             if(floor>BOTTOM_FLOOR)  
             {  
                 floor--;  
                 System.out.println("您已到达"+floor+"层"); 
                 for (int j = 0; j < 3; j++) {
                     System.out.println("···");
                     Thread.sleep(500);
                 }
             }  
             else  
                 System.out.println("您已在底楼无法继续向下");  
         }  
}

     public void setFloor(List<Integer> list) throws InterruptedException{
    	
//    	 Iterator<Integer> it = list.iterator();
//    	 Set<Integer> set2 = new HashSet<Integer>();
    	 
    	 List<Integer> list2 = new ArrayList<Integer>();
    	 
    	 
    	 for(int i = 0; i<list.size();i++){
    		 closeDoor();
    		 Integer in = (Integer)list.get(i);
          if(in>=BOTTOM_FLOOR&&in<=TOP_FLOOR){
        	while(in!=floor){
    		 if(floor<in)
    			 goUp();
        	}
        	
    	 }
          System.out.println("请输入您要到达的楼层,如无需输入请按-1:");
          
          Scanner sc = new Scanner(System.in);
//      	  while(sc2.hasNextInt()){
//      		  int a = sc2.nextInt();
//      		  
//      		  
//      		  
//      		  if(a>floor) {
//      			  list.add(a);
//      			  Collections.sort(list);
//      		  }
//      		  else
//      			 list2.add(a); 
//          }
//      	  
          Integer floor1=-1;
      	   
          while(sc.hasNext()){
          	
          	try{
          		String str =sc.next();
          		floor1 = Integer.valueOf(str);
          	}catch(RuntimeException e){
          		System.out.println("请输入数字");
          	}
          	if(floor1==-1)
          		break;
//          	set.add(sc.nextInt());
          	int flag=0;
          	for(int k=0;k<list.size();k++){
      			if(list.get(k)==floor1)
      			{
      				flag=1;
      			}
      		}
          	if(floor1>floor&&floor1<=TOP_FLOOR&&flag==0){
          		
          		
          		list.add(floor1);
          		
          		Collections.sort(list);
          		
          	}
          	int flag1=0;
          	for(int k=0;k<list2.size();k++){
      			if(list2.get(k)==floor1)
      			{
      				flag1=1;
      			}
      		}
          	
            if(floor1<floor&&floor<=TOP_FLOOR&&flag1==0){
          		
          		
          		list2.add(floor1);
          		Collections.sort(list2);
          	}
          	
          	
          }
                          
      	  
//      	  sc2.close();
      	  System.out.println(list2);
     }	
//    	 sortSet.addAll(set2); 
    	   Collections.reverse(list2);
    	 
    	 System.out.println(list2);
//    	 Iterator<Integer> it2 = set2.iterator();
    	 for(int j = 0; j<list2.size();j++){
    		 closeDoor();
    		 Integer in2 = (Integer)list2.get(j);
    		 System.out.println(in2);
          if(in2>=BOTTOM_FLOOR&&in2<=TOP_FLOOR){
        	while(in2!=floor){
    		 if(floor>in2)
    			 goDown();
    		 
        	}
        	
    	 }
      }
    }
 
     }
