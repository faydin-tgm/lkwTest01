package Aydin_C06;

import org.junit.*;

import weiser.GewichtException;
import weiser.LKW;

import static org.junit.Assert.*;

import java.awt.Color;

/**
 * Tests von den Methoden, Konstruktoren und Exceptions der Klasse
 * LKW, die mit der Ladung zu tun haben, mit JUnit
 * Github:
 * git@github.com:faydinTGM/lkwTest01.git
 * 
 * @author Fatih Aydin
 * @version 27.04.2017
 */
public class lkwTest {
	
	/**
	 * Test des Konstruktors, der aufladen Methode und getNutzLast Methode
	 */
	@Test
	public void test1(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.aufladen(3);
		System.out.println(l.getNutzLast());
		Assert.assertEquals(3, l.getNutzLast());
	}
	
	/**
	 * Test der getEigenGewicht Methode
	 */
	@Test
	public void test2(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		System.out.println(l.getEigenGewicht());
		Assert.assertEquals(1200, l.getEigenGewicht());
	}
	
	/**
	 * Test der getHoechstZulaessigesGesamtGewicht Methode
	 */
	@Test
	public void test3(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		System.out.println(l.getHoechstZulaessigesGesamtGewicht());
		Assert.assertEquals(20000, l.getHoechstZulaessigesGesamtGewicht());
	}
	
	/**
	 * Test der entladen Methode
	 */
	@Test
	public void test4(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.aufladen(5);
		l.entladen(4);
		System.out.println(l.getNutzLast());
		Assert.assertEquals(1, l.getNutzLast());
	}
	
	/**
	 * Test der toString Methode
	 */
	@Test
	public void test5(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.aufladen(200);
		Assert.assertEquals("toString", "LKW W1\nhöchstzulässiges Gesamtgewicht: 20000\neigenGewicht: 1200\nMaximale Zahl von Personen im LKW: 5\naktuelle Gesamtgewicht: 1400\nPersonen im LKW: 0" ,l.toString());
	}
	
	/**
	 * Test der IllegalArgumentException für das Attribut hoechstZulaessigesGesamtGewicht
	 */
	@Test (expected=IllegalArgumentException.class)
	public void test6(){
		LKW l = new LKW("W1", 0, 1200, 5);
	}
	
	/**
	 * Test der IllegalArgumentException für das Attribut eigenGewicht
	 */
	@Test (expected=IllegalArgumentException.class)
	public void test7(){
		LKW l = new LKW("W1", 20000, 0, 5);
	}
	
	/**
	 * Test der IllegalArgumentException für das Attribut kennZeichen
	 */
	@Test (expected=IllegalArgumentException.class)
	public void test9(){
		LKW l = new LKW(null, 20000, 1200, 5);
	}
	
	/**
	 * Test der IllegalArgumentException für das Attribut kennZeichen
	 */
	@Test (expected=IllegalArgumentException.class)
	public void test10(){
		LKW l = new LKW("", 20000, 1200, 5);
	}
	
	/**
	 * Test der GewichtException für die Methode aufladen
	 */
	@Test (expected=GewichtException.class)
	public void test11(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.aufladen(2000000);
	}
	
	/**
	 * Test der GewichtException für die Methode entladen
	 */
	@Test (expected=GewichtException.class)
	public void test12(){
		LKW l = new LKW("W1", 20000, 1200, 5);
		l.aufladen(5);
		l.entladen(20001);
	}
}
