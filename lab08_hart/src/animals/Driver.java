package animals;

public class Driver {
	public static void main(String[] args) {
		Dog d = new Dog("Wu");
		String msg = d.getName() + " " + d.makeSound() + "s";
		System.out.println(msg);
		
		Bird b = new Bird("Tweety");
		msg = b.getName() + " " + b.makeSound() + "s";
		System.out.println(msg);
		
		Animal a1 = new Dog("Lucky");
		msg = a1.getName() + " " + a1.makeSound() + "s";
		System.out.println(msg);
		
		Animal a2 = new Bird("Kiwi");
		msg = a2.getName() + " " + a2.makeSound() + "s";
		System.out.println(msg);
		
		//Animal a3 = new Animal("Shorty");
		System.out.println("Calling a polymorphic method");
		printAnimal(d);
		printAnimal(b);
		printAnimal(a1);
		
		System.out.println("Casting");
		printAnimal(a1);
		printAnimal(a2);
	}
	
	public static void printAnimal(Animal a) {
		String msg = a.getName() + " " + a.makeSound() + "s";
		System.out.println(msg);
	}
	
	public static void whatIsIt(Animal a) {
		if(a instanceof Dog) {
			Dog dog = (Dog)a;
			System.out.println("I'm a Dog named " + dog.getName());
		}
		else if(a instanceof Bird) {
			Bird bird = (Bird)a;
			System.out.println("I'm a Dog named " + bird.getName());
		}
	}
}