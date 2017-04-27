package Aydin_C06;

import org.junit.Assert;
import org.junit.Test;

import weiser.LKW;
import weiser.PersonenException;

/**
 * Tests von den Methoden, Konstruktoren und Exceptions der Klasse
 * LKW, die mit den Personen zu tun haben, mit JUnit
 * Github:
 * git@github.com:faydinTGM/lkwTest01.git
 * 
 * @author Fatih Aydin
 * @version 27.04.2017
 */
public class lkwTest2 {
	
	/**
	 * Test der getHoechstZulaessigePersonenZahl Methode
	 */
	@Test
	public void test1(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		System.out.println(l.getHoechstZulaessigePersonenZahl());
		Assert.assertEquals(5, l.getHoechstZulaessigePersonenZahl());
	}
	
	/**
	 * Test der einsteigen Methode
	 */
	@Test
	public void test2(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		System.out.println(l.getPersonenZahl());
		Assert.assertEquals(3, l.getPersonenZahl());
	}
	
	/**
	 * Test der aussteigen Methode
	 */
	@Test
	public void test3(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.aussteigen();
		l.aussteigen();
		System.out.println(l.getPersonenZahl());
		Assert.assertEquals(2, l.getPersonenZahl());
	}
	
	/**
	 * Test der toString Methode
	 */
	@Test
	public void test4(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.aussteigen();
		l.aussteigen();
		Assert.assertEquals("toString", "LKW W1\nhöchstzulässiges Gesamtgewicht: 20000\neigenGewicht: 1200\nMaximale Zahl von Personen im LKW: 5\naktuelle Gesamtgewicht: 1200\nPersonen im LKW: 2" ,l.toString());
	}
	
	/**
	 * Test der IllegalArgumentException für das Attribut maxPersonen
	 */
	@Test (expected=IllegalArgumentException.class)
	public void test5(){
		LKW l = new LKW("W1", 20000, 1200, 0);
	}
	
	/**
	 * Test der PersonenException für die Methode einsteigen
	 */
	@Test (expected=PersonenException.class)
	public void test6(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
	}
	
	/**
	 * Test der PersonenException für die Methode aussteigen
	 */
	@Test (expected=PersonenException.class)
	public void test7(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.einsteigen();
		l.einsteigen();
		l.einsteigen();
		l.aussteigen();
		l.aussteigen();
		l.aussteigen();
		l.aussteigen();
		l.aussteigen();
		l.aussteigen();
	}
	
}
