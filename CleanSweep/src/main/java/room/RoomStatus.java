package room;


//Room status object to tell what is at that location and if it is clean or not.
public class RoomStatus {
	ThingsInRoom typeOfFloor;
	CleanRoom isClean;
	
	
	public RoomStatus(ThingsInRoom a,CleanRoom b){
		typeOfFloor = a;
		isClean = b;
	}
	
	public CleanRoom getIsClean(){
		return this.isClean;
	}
	
	public ThingsInRoom getTypeOfFloor(){
		return this.typeOfFloor;
		
	}
	
	public String toString(){
		return "[type: "+typeOfFloor.toString() + ","+ isClean.toString()+"]";
	}

}
