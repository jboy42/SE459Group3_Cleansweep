package room;

import java.util.ArrayList;
import java.util.List;


public class Room implements Area {
	
	
	List<List<ThingsInRoom>> room = new ArrayList<List<ThingsInRoom>>();
	
	public Room (){};
	public Room(List<List<ThingsInRoom>> room){
		this.room = room;
	}
	
	public void updateLocation(ThingsInRoom thisThing, int outer, int inner){
		
		List<ThingsInRoom> holdArray = room.get(outer);
		
		holdArray.set(inner,thisThing);
		room.set(outer, holdArray);
		
		
	}
	public void addLocation(ThingsInRoom thisThing, int inner, int outer){
		
		try{
			List<ThingsInRoom> holdArray = room.get(outer);
			holdArray.set(inner,thisThing);
			room.set(outer, holdArray);				
		}catch( IndexOutOfBoundsException ex){
			room.add(outer , new ArrayList<ThingsInRoom>());
			List<ThingsInRoom> holdArray = room.get(outer);
			
			holdArray.set(inner,thisThing);
			room.set(outer, holdArray);		
			
		}
		
		
	}
	
	public ThingsInRoom newLocation(int outer, int inner){
		return room.get(outer).get(inner);
	}

	
}
