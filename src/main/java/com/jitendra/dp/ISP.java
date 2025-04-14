package com.jitendra.dp;
// ISP - Interface Segregation Principle
// refer class ISPViolation.java that violates ISP

/*
	Refer class ISPVIolation2 uses large interface Person, contains the methods 
	which are forced to be implemented by classe even some methods not needed by them.
	
	This code split the large interface Person into smaller and specific interfaces
	such as ISinger, IDancer, IMusician implemented by Singer, Dancer, Musician classes 
	respectively that defines methods which are actually needed by them.
	So this code follows ISP.
	
	Key benefits with smaller interfaces -
	- Classes implement relevant interfaces
	- Easy to test classes using relevant / focused interfaces 
	- Re-usable - Because class contains specific functionality, so easily reused by
	  different classes in same or different projects
	- Flexible and extensible - code is loosely coupled due to less dependency, 
	  so can change existing code or add new features without breaking other classes
	  Using focused interfaces helps creating less boilerplate code
*/

interface ISinger {
	public void sing();
}

interface IDancer {
	public void dance();
}

interface IMusician {
	public void performMusic();
}

class Singer implements ISinger {
	public void sing() {
		System.out.println("Singer singing ..");
	}
}

class Dancer implements IDancer {
	public void dance() {
		System.out.println("Dancer dancing..");
	}
}

class Musician implements IMusician {
	public void performMusic() {
		System.out.println("Musician playing music..");
	}
}

class SingerCumMusician implements ISinger, IMusician {

	public void sing() {
		System.out.println("Singing..");
	}

	public void performMusic() {
		System.out.println("Palying music..");
	}
}

public class ISP {
	public static void main(String[] args) {
		ISinger singer = new Singer();
		singer.sing();

		IDancer dancer = new Dancer();
		dancer.dance();

		IMusician musician = new Musician();
		musician.performMusic();

		ISinger singerCumMusician = new SingerCumMusician();
		singerCumMusician.sing();
		IMusician musicianCumSinger = new SingerCumMusician();
		musicianCumSinger.performMusic();

	}
}
