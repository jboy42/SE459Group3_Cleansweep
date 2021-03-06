package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import room.CleanRoom;
import room.Point;
import room.RoomStatus;
import room.ThingsInRoom;
import util.AnimatorBuilder;
import util.Animator;
import util.SwingAnimator;
import util.SwingAnimatorPainter;

import vacuum.Vacuum;
/**
 * A class for building Animators.
 */
public class SwingAnimatorBuilder implements AnimatorBuilder {
	MyPainter painter;
	public SwingAnimatorBuilder() {
//		skipInit = VP.gap;
//		skipRoad = VP.gap + MP.roadLength;
//		skipCar = VP.gap + VP.elementWidth;
		
		painter = new MyPainter();
	}
	public Animator getAnimator() {
		if (painter == null) { throw new IllegalStateException(); }
		Animator returnValue = new SwingAnimator(painter, "Room Layout",
				VP.displayWidth, VP.displayHeight, VP.displayDelay);
		painter = null;
		return returnValue;
	}
	
	@Override
	public void addLocation(Point p, RoomStatus rs) {
		// TODO Auto-generated method stub
		double x = (double)p.getX()*5.0;
		double y = (double)p.getY()*5.0;
		Translator t = new TranslatorSquare(x,y,5.0,5.0,1.0);
		painter.addSquare(p,t,rs);
		
	}
	@Override
	public void addVacuum(Vacuum v){
		double x = (double)v.getCurrentLocation().getX()*2.0;
		double y = (double)v.getCurrentLocation().getY()*2.0;
		Translator t = new TranslatorSquare(x+10,y+2.5,2.0,2.0,1.0);
		painter.addSquare(v,t);
		
	}
//	private static double skipInit = VP.gap;
//	private static double skipRoad = VP.gap + MP.roadLength;
//	private static double skipCar = VP.gap + VP.elementWidth;
//	private static double skipRoadCar = skipRoad + skipCar;
//	private static double skipLight = MP.intersectionLength + VP.gap;
//	public void addLight(Light d, double i, double j) {
//		double x = skipInit + skipRoad + j*skipRoadCar;
//		double y = skipInit + skipRoad + i*skipRoadCar;
//		Translator t = new TranslatorWE(x, y, MP.carLength, VP.elementWidth, VP.scaleFactor);
//		painter.addLight(d,t);
//	}
	
///NNENNEEENEEEEEEEEEEEEED TO CHANGE BACK TO THE ORIGIONAL EW WE AND NS SN
//	public void addHorizontalRoad(Road l, int i, int j, boolean eastToWest) {
//		double x = skipInit + j*skipRoadCar;
///		double y = skipInit + skipRoad + i*skipRoadCar;
//		Translator t = eastToWest ? new TranslatorWE(x, y, MP.roadLength, VP.elementWidth, VP.scaleFactor)
//				: new TranslatorWE(x, y, MP.roadLength, VP.elementWidth, VP.scaleFactor);
//		painter.addRoad(l,t);
//	}
//	public void addVerticalRoad(Road l, int i, int j, boolean southToNorth) {
//		double x = skipInit + skipRoad + j*skipRoadCar;
//		double y = skipInit + i*skipRoadCar;
//		Translator t = southToNorth ? new TranslatorNS(x, y, MP.roadLength, VP.elementWidth, VP.scaleFactor)
//				: new TranslatorNS(x, y, MP.roadLength, VP.elementWidth, VP.scaleFactor);
//		painter.addRoad(l,t);
//	}


	/** Class for drawing the Model. */
	private static class MyPainter implements SwingAnimatorPainter {
		private List<Element<Point>> Points;
		private List<Thing<Vacuum>> Vacuum;
			
		MyPainter(){
			Points = new ArrayList<Element<Point>>();
			Vacuum = new ArrayList<Thing<Vacuum>>();
		}
		
		private static class Thing<T>{
			T x;
			Translator t;
			Thing(T x, Translator t){
				this.x=x;
				this.t=t;
			}
		}
		
		/** Pair of a model element <code>x</code> and a translator <code>t</code>. */
		private static class Element<T> {
			T x;
			Translator t;
			RoomStatus rs ;
			Element(T x, Translator t, RoomStatus rs2) {
				this.x = x;
				this.t = t;
				this.rs = rs2;
			}
		}
		void addSquare(Vacuum p, Translator t){
			Vacuum.add(new Thing<Vacuum>(p,t));
		}

		void addSquare(Point x,Translator t, RoomStatus rs){
			Points.add(new Element<Point>(x,t, rs));
		}
		
		public void paint(Graphics g){
			
			for (Element<Point> e : Points ){
			
				if(e.rs.getTypeOfFloor()== ThingsInRoom.OBSTACLE){
					g.setColor(Color.ORANGE);
					XGraphics.fillRect(g,e.t,e.x.getX()*50.0,e.x.getY()*50.0,50,50);
				}
				else if(e.rs.getTypeOfFloor()==ThingsInRoom.NOTHING){
					g.setColor(Color.BLACK);
					XGraphics.fillRect(g,e.t,e.x.getX()*50.0,e.x.getY()*50.0,50,50);
				}
				else if(e.rs.getTypeOfFloor()==ThingsInRoom.BASE){
					g.setColor(Color.RED);
					XGraphics.fillRect(g,e.t,e.x.getX()*50.0,e.x.getY()*50.0,50,50);
				}
				else if(e.rs.getTypeOfFloor()==ThingsInRoom.BAREFLOOR){
					g.setColor(Color.WHITE);
					XGraphics.fillRect(g,e.t,e.x.getX()*50.0,e.x.getY()*50.0,50,50);
				}
				else if(e.rs.getTypeOfFloor()==ThingsInRoom.LOWPILE){
					g.setColor(Color.LIGHT_GRAY);
					XGraphics.fillRect(g,e.t,e.x.getX()*50.0,e.x.getY()*50.0,50,50);
				}
				else if(e.rs.getTypeOfFloor()==ThingsInRoom.HIGHPILE){
					g.setColor(Color.GRAY);
					XGraphics.fillRect(g,e.t,e.x.getX()*50.0,e.x.getY()*50.0,50,50);
				}
			}
			for(Thing<Vacuum> e: Vacuum){
				g.setColor(Color.GREEN);
				XGraphics.fillOval(g,e.t, 50*(e.x.getCurrentLocation().getX()),50*(e.x.getCurrentLocation().getY()), 50.0, 50.0);
			}
			//XGraphics.fillRect(g,e.t,e.x.getX()*25.0,e.x.getY()*25.0,25,25);
			
			
		}
//		private List<Element<Road>> roadElements;
//		private List<Element<Light>> lightElements;
//		MyPainter() {
//			roadElements = new ArrayList<Element<Road>>();
//			lightElements = new ArrayList<Element<Light>>();
//		}
//		void addLight(Light x, Translator t) {
//			lightElements.add(new Element<Light>(x,t));
//		}
//		void addRoad(Road x, Translator t) {
//			roadElements.add(new Element<Road>(x,t));
//		}

//		public void paint(Graphics g) {
			// This method is called by the swing thread, so may be called
			// at any time during execution...

			// First draw the background elements
//			for (Element<Light> e : lightElements) {
//				if (e.x.getState() == 0) {
//					g.setColor(Color.GREEN);
//				}else if (e.x.getState()==1){
//					g.setColor(Color.YELLOW);
//				}else {
//					g.setColor(Color.RED);
//				}
//				XGraphics.fillOval(g, e.t, 0, 0, MP.carLength, VP.elementWidth);
//			}
//			g.setColor(Color.BLACK);
//			for (Element<Road> e : roadElements) {
//				XGraphics.fillRect(g, e.t, 0, 0, MP.roadLength, VP.elementWidth);
//			}

			// Then draw the foreground elements
//			for (Element<Road> e : roadElements) {
//				// iterate through a copy because e.x.getCars() may change during iteration...
//				for (Car d : e.x.getCars().toArray(new Car[0])) {
//					g.setColor(d.getColor());
//					XGraphics.fillOval(g, e.t, d.currentPosition(), 0, d.length, VP.elementWidth);
//				}
//			}
//		}
//	}
}


}

