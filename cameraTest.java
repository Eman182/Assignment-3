package eg.edu.alexu.csd.datastructure.iceHockey.csX22;
import java.awt.Point;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class cameraTest {
	@SuppressWarnings("deprecation")
	@Test
	void test() {
	finder x=new finder();
	Point[] Players;Point[] r;
	String []photo1={
			 "33JUBU33"
			,"3U304433"
			,"033P44NB"
			,"P03NSD33"
			,"VNDSD333"
			,"OINFD33X"};
	Players=x.findPlayers(photo1, 3, 16);
	r=new Point[]{  new Point(4,5),new Point (13,9),new Point (14,2)};
	assertEquals(r,Players);
	
	
	
	
	
	String []photo2= {
			"44444H44S4",
			"K444K4L444",
			"4LJ44T44XH",
			"444O4VIF44",
			"44C4D4U444",
			"4V4Y4KB4M4",
			"G4W4HP4O4W",
			"4444ZDQ4S4",
			"4BR4Y4A444",
			"4G4V4T4444"
			};
	Players=x.findPlayers(photo2, 4, 16);
	r=new Point[]{new Point(3,8), 
			new Point(4,16), new Point(5,4), new Point(16,3),
			new Point(16,17), new Point(17,9) };
		assertEquals(r,Players);
	
	
	
	String []photo3= {
			"11111",
			"1AAA1",
			"1A1A1",
			"1AAA1",
			"11111"
	};
	Players=x.findPlayers(photo3, 1, 3);
	r=new Point[]{new Point(5,5),new Point(5,5)};
		assertEquals(r,Players);
		
		
	String []photo33= {
				"8D88888J8L8E888",
				"88NKMG8N8E8JI88",
				"888NS8EU88HN8EO",
				"LUQ888A8TH8OIH8",
				"888QJ88R8SG88TY",
				"88ZQV88B88OUZ8O",
				"FQ88WF8Q8GG88B8",
				"8S888HGSB8FT8S8",
				"8MX88D88888T8K8",
				"8S8A88MGVDG8XK8",
				"M88S8B8I8M88J8N",
				"8W88X88ZT8KA8I8",
				"88SQGB8I8J88W88",
				"U88H8NI8CZB88B8",
				"8PK8H8T8888TQR8"

	};
	Players=x.findPlayers(photo33, 8, 9);
	r=new Point[]{new Point(1, 17), new Point(3, 3),new Point (3, 10),
			new Point(3, 25),new Point (5, 21),new Point (8, 17),
			new Point(9, 2), new Point(10,9),new Point (12,23)
			, new Point(17,16),new Point (18,3),
			new Point(18,11), new Point(18,28),new Point (22,20),
			new Point(23,26),new Point (24,15),
			new Point(27,2), new Point(28,26), new Point(29,16) };
		assertEquals(r,Players);	
	
	
	String []photo333=new String[] {"354289"		
	};
	Players=x.findPlayers(photo333, 3, 3);
	r=new Point[]{new Point(1,1)};
		assertEquals(r,Players);	
	
		
		
	try {
		String []photo4=new String[]{
				"",""
	};
		Players=x.findPlayers(photo4, 1, 3);//length of element in the photo=0
	}catch(RuntimeException p) {System.out.println(p.getMessage());}

	
	String []photo5=new String[]{
			"12546"
	};
	try {
		Players=x.findPlayers(photo5, 1, 5);//no players are found (4<12(threshold))
	}catch(RuntimeException l) {System.out.println(l.getMessage());}
	
	
	String []photo6= new String[]{
			"1254875",
			"1452364"
	};
	try {
		
		Players=x.findPlayers(photo6, 9, 3);//the element is not found
	}catch(RuntimeException o) {
		System.out.println(o.getMessage());}
	
	
	String []photo7= new String[]{
			"gdpg5"
	};
	try {
		Players=x.findPlayers(photo7, 1, 3);//small letters are invalid
	}catch(RuntimeException e) {
		System.out.println(e.getMessage());}
	
	
	String []photo8= new String[]{
			",.;/*"
	};
	try {
		Players=x.findPlayers(photo8, 1, 3);//these characters are in valid
	}catch(RuntimeException e) {
		System.out.println(e.getMessage());}
	
	
	String []photo9=new String[] {	};
	try {
		Players=x.findPlayers(photo9, 1, 3);//empty photo
	}catch(RuntimeException e) {
		System.out.println(e.getMessage());}
	
	
	
	String []photo10= new String[]{"152FJY5"};
	try {
		Players=x.findPlayers(photo10,15, 3);//team must be from 0 to 9
	}catch(RuntimeException l) {
		System.out.println(l.getMessage());}
	
	String []photo11= new String[]{"1321245LKJHI",
			"1321245LKJHI132124",
			"1321245LKJHI",
			"1321245LKJHI",
			"1321245LKJHI",
			"1321245LKJHI"};
	try {
		Players=x.findPlayers(photo11,1, 3);//all the rows must have equal
		//number of columns
	}catch(RuntimeException l) {
		System.out.println(l.getMessage());}
	
	
	String []photo12= new String[]{
			"1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI",
			"1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI",
			"1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI",
			"1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI",
			"1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI",
			"1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI1321245LKJHI"};
	try {
		Players=x.findPlayers(photo12,1, 3);
		//number of columns <50
	}catch(RuntimeException l) {
		System.out.println(l.getMessage());}
	
	String []photo13= new String[]{
			"13212","13212","13212","13212","13212","13212","13212","13212"
			,"13212","13212","13212","13212","13212","13212","13212","13212",
			"13212","13212","13212","13212","13212","13212","13212","13212"
			,"13212","13212","13212","13212","13212","13212","13212","13212",
			"13212","13212","13212","13212","13212","13212","13212","13212"
			,"13212","13212","13212","13212","13212","13212","13212","13212",
			"13212","13212","13212","13212","13212","13212","13212","13212"
			,"13212","13212","13212","13212","13212","13212","13212","13212"};
	try {//number of photo elements >50
		Players=x.findPlayers(photo13,1, 3);
		//number of columns <50
	}catch(RuntimeException l) {
		System.out.println(l.getMessage());}
}
}
