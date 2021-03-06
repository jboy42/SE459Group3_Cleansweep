package room;
import static org.junit.Assert.*;
import org.junit.*;
public class PointTest {

	Point p = new Point(1,2);
	
	@Test
	public void testGetPoints(){
		assertEquals(1, p.getX());
		assertEquals(2,p.getY());
		
	}
	
	@Test
	public void testToString(){
		
		assertEquals("1 2",p.ToString());
	}
	
	@Test(expected=NullPointerException.class)
	public void testNullEquals(){
		p.equals(null);
	}
	
	@Test
	public void testEquals(){
		assertEquals(true,p.equals( new Point(1,2)));
		assertEquals(false, p.equals(new Point(2,3)));
	}
	
}
