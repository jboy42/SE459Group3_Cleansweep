package simulator;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import room.CleanRoom;
import room.Point;
import room.RoomStatus;
import room.ThingsInRoom;

public class RoomSimulator {

	public RoomSimulator(){};
	
	public HashMap<Point,RoomStatus> makeRoom(int[] input){
		HashMap<Point,RoomStatus> room = new HashMap<Point,RoomStatus>(); 
		ThingsInRoom r = ThingsInRoom.BASE ;
		int count = 0;//(input[0]*input[1])/20;
		for(int i=0;i<input[0];i++){
			for (int j =0;j<input[1];j++){
				Point p = new Point(i,j);
				RandomEnum<ThingsInRoom> x = new RandomEnum<ThingsInRoom>(ThingsInRoom.class);
				 r = ThingsInRoom.BASE;
				do{
					r = x.random();
				}while(r.equals(ThingsInRoom.BASE));
				
				if(r.equals(ThingsInRoom.NOTHING)){
					if(count>0){
						count -=1;
					}
					else{
						do{
							r = x.random();
						
						}while((r.equals(ThingsInRoom.NOTHING)) || (r.equals(ThingsInRoom.BASE))); 
					}
					
				}
				if((r==ThingsInRoom.NOTHING)||(r==ThingsInRoom.BASE)||(r==ThingsInRoom.OBSTACLE)){
				RoomStatus rs = new RoomStatus(r,CleanRoom.CLEAN);
				room.put(p, rs);
			}else{
				RoomStatus rs = new RoomStatus(r,CleanRoom.DIRTY);
				room.put(p,rs);
				
			}
				
				
			}		
		}
		return room;
	}
	
	
	
	public int[] getRoomSize(Scanner scn){
		boolean SS = false;
		int[] returnInt = new int[2];
		int x = 0;
		int y = 0;
		do{
		System.out.println("enter an integer pair separated by a space ex: 3 2 or ");
		System.out.println("These integers represent the area size of the room ex: 3X2");
		
		if(scn.hasNextInt()){
			x = scn.nextInt();
			returnInt[0] =x;
				if(scn.hasNextInt()){
					y = scn.nextInt();
					returnInt[1] = y;
					SS=true;
				}else{System.out.println("Please enter 2 integers");SS=false;scn.next();}
		}else{System.out.println("Please enter 2 integers");SS=false;scn.next();}
		
		}while(SS==false);	
		return returnInt;
		
	}
		
		
		
		
		
		
		
		
		
		
	
	
	private static class RandomEnum<E extends Enum> {

	    private static final Random RND = new Random();
	    private final E[] values;

	    public RandomEnum(Class<E> token) {
	        values = token.getEnumConstants();
	    }

	    public E random() {
	        return values[RND.nextInt(values.length)];
	    }
	}
	
}
