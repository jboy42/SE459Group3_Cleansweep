package vacuum;

import room.Room;
import room.ThingsInRoom;

public class Vacuum {
	int storage = 50;
	int batteryLife = 100;
	String name;
	Room room;
	int[] currentLocation = {0,0};
	
	ThingsInRoom front = ThingsInRoom.NOTHING;
	ThingsInRoom back = ThingsInRoom.NOTHING;
	ThingsInRoom left = ThingsInRoom.NOTHING;
	ThingsInRoom right = ThingsInRoom.NOTHING;
	
	ThingsInRoom center = ThingsInRoom.BASE;
	
	
	
	public Vacuum(String name, Room room){
		this.name = name;
		this.room = room;
	}
	
	public void run(){
		this.move();
	}
	
	
	
	private int checkStorage(){
		return this.storage;
	}

	private void move(){
		do{
			//read left sensor
			//read right sensor
			//read front sensor
			//read back sensor
			//assign left sensor
			//assign right sensor
			//assign front sensor
			//assign back sensor
			
			if(front != ThingsInRoom.OBSTACLE){
				center = front; 
				
				
				
				
				
				
			}
			
		}while((checkStorage() < 50));
		
		returnToBase();
		
		}
		
		
	

	private void returnToBase() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString(){
		return "HELLO FROM " +  this.name;
	}
}
