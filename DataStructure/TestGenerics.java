import java.util.*;

public class TestGenerics {
	public static void main (String[] args) {
		new TestGenerics().go();
	}
	public void go() {
		Animal[] animals = {new Dog(), new Cat(), new Dog() };
		Dog[] dogs = {new Dog(), new Dog(), new Dog()};
		Dog animal1 = new Dog();
		animal1.gug();
		animal1.run();
		takeAnimals(animals);
		takeAnimals(dogs);
	}

	public void takeAnimals (Animal[] animals) {
		for(Animal a : animals) {
			a.run();
		}
	}
}

class Animal {
	public void run() {
		System.out.println("Animal running");
	}
}

class Dog extends Animal {
	public void run() {
		System.out.println("dogs running");
	}	
	public void gug() {
		System.out.println("gu");
	}

}
class Cat extends Animal {}
