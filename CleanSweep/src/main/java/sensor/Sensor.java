package sensor;

import room.Point;
import room.Room;
import room.ThingsInRoom;

public class Sensor {
	Room room;
	
	public Sensor(Room r){
		room = r;
		
	}
	
	public ThingsInRoom sense(Point p) {
		
		try{
		System.out.println(room.getRoom().get(p).getTypeOfFloor()+ " :::" + p.toString());
		}catch(Exception e){
			
			System.out.println("ERROR SENSING THE TYPE OF FLOOR");
		}
		return room.getRoom().get(p).getTypeOfFloor();
		
	};
	}
	
	

