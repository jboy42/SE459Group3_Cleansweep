package room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



//This is a wrapper class for the room.  It contains a data structure that is a hashmap.
//The HashMap is of Points and RoomStatus Objects. 
//The HashCode was Over written for this object.
public class Room implements Area {
	
	//THe main data structure for the room
	private HashMap<Point,RoomStatus> room; 
	
	//constructor with no data
	public Room (){
		this.room = new HashMap<Point,RoomStatus>();
	};
	
	//constructor with predetermined map
	public Room(HashMap<Point,RoomStatus> room){
		this.room = room;
	}
	

	
	//updates the map with the location information
	public void updateLocation(Point p, RoomStatus rs){
		room.put(p, rs);
	}

	//returns the room.
	public HashMap<Point,RoomStatus> getRoom(){
		return room;
	}

	
	//checks the point on the map if it is clean or not according to the room.
	public CleanRoom checkPoint(Point p){
		
		return room.get(p).getIsClean();
		
		
	}
	
	//Checks if the point is an obstacle or not.
	public ThingsInRoom checkTypeOfFloor(Point p){
		return room.get(p).getTypeOfFloor();
	}
	
	
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Point s : room.keySet()){
			
			sb.append(s.toString() + "  " + room.get(s).toString() + "\n" );
			
			
		}
		return sb.toString();
	}
	
}
