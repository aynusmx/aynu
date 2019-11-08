package cn.aynu.dianti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class diantimoni{

	public static void main(String args[]) throws InterruptedException {
		 while(true){
		System.out.println("-------电梯开始-------");
        OurElevator e2 = new OurElevator(); 
        List<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        Integer floor=-1;
        System.out.println("请输入您要到达的楼层,如无需输入请按-1:");
       
        	
       
        while(sc.hasNext()){
        	
        	try{
        		String str =sc.next();
        		floor = Integer.valueOf(str);
        	}catch(RuntimeException e){
        		System.out.println("请输入数字");
        	}
        	if(floor==-1)
        		break;
//        	set.add(sc.nextInt());
        	int flag=0;
        	for(int i=0;i<list.size();i++){
    			if(list.get(i)==floor)
    			{
    				flag=1;
    			}
    		}
        	if(floor>12)
        	System.out.println("您输入的目标楼层大于顶层,输入无效");
        	else if(floor>=1&&flag==0){
        		
        		
        		list.add(floor);
        		
        	}
        	
        }
                        
            Collections.sort(list);
            System.out.println(list);
        	e2.setFloor(list);
//        	sc.close();
        }
	}
	
}

