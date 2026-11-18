
class Example1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Toby", "Golden Retriever");
        dog.eat();
        dog.bark();
        dog.listenToHeart();
    
    }
}

class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal name is: " + name);
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

}

class Heart {
    private final String name;

    public Heart(String name) {
        this.name = name;
    }
    
    public void beat() {
        System.out.println(name + "'s heart is beating.");
    }
}

class Dog extends Animal {
    private final String race;
    private final Heart heart;

    public Dog(String name, String race) {
        super(name);
        this.race = race;
        this.heart = new Heart(name);
        System.out.println("Dog name is: " + name + " and race is: " + race);
    }
    
    public void bark() {
        System.out.println("Woof! Woof!");
    }
    
    public void listenToHeart() {
        this.heart.beat();
    }
}


