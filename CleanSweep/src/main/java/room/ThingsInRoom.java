package room;


//Enum for things in the room
public enum ThingsInRoom {
	OBSTACLE{
		@Override
		public String toString(){
			return "obstacle";
		}
		
	}, 
	
	BAREFLOOR{
		@Override
		public String toString(){
			return "barefloor";
		}
	}, 
	
	LOWPILE
		{
			@Override
			public String toString(){
				return "Lowpile";
			}
	},
		
	HIGHPILE
		{
			@Override
			public String toString(){
				return "obstacle";
			}
		
	}, 
	
	BASE
		{
		@Override
		public String toString(){
			return "base";
		}
	},
		NOTHING
		{
			@Override
			public String toString(){
				return "obstacle";
			}
		} 
}

