import java.util.*;
public class AnimalShelter {
    public static void main(String[] args){
        Cat cat1 = new Cat("c1");
        Cat cat2 = new Cat("c2");
        Cat cat3 = new Cat("c3");
        Cat cat4 = new Cat("c4");
        Cat cat5 = new Cat("c5");

        Dog dog1 = new Dog("d1");
        Dog dog2 = new Dog("d2");
        Dog dog3 = new Dog("d3");
        Dog dog4 = new Dog("d4");
        Dog dog5 = new Dog("d5");

        AnimalQueue aq = new AnimalQueue();
        aq.enqueue(cat1);
        aq.enqueue(cat2);
        aq.enqueue(dog1);
        aq.enqueue(dog2);
        aq.enqueue(dog3);
        aq.enqueue(cat3);
        aq.enqueue(dog4);
        aq.enqueue(cat4);
        aq.enqueue(cat5);
        aq.enqueue(dog5);

        //should be cat1;
        System.out.println(aq.dequeueCats().name);
        //should be cat2;
        System.out.println(aq.dequeueAny().name);
        //should be dog1
        System.out.println(aq.dequeueDogs().name);
        //should be dog2
        System.out.println(aq.dequeueAny().name);
        //should be dog3
        System.out.println(aq.dequeueAny().name);
        //should be dog4
        System.out.println(aq.dequeueDogs().name);



    }
}

abstract class Animal{
    private int order;
    protected String name;
    public Animal(String n){
        name = n;
    }
    public void setOrder(int ord){
        order = ord;
    }
    public int getOrder(){
        return order;
    }

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order =  0;

    public void enqueue(Animal a){
        a.setOrder(order);
        order++;
        if(a.getClass().equals(Dog.class)) dogs.addLast((Dog) a);
        else if (a.getClass().equals(Cat.class)) cats.addLast((Cat) a);
    }

    public Animal dequeueAny(){
        if(dogs.size() == 0) return dequeueCats();
        else if (cats.size() == 0) return dequeueDogs();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if(dog.isOlderThan(cat)) return dequeueDogs();
        else return dequeueCats();
    }

    public Dog dequeueDogs(){
        return dogs.poll();
    }
    public Cat dequeueCats(){
        return cats.poll();
    }

}

class Dog extends Animal{
    public Dog(String n) {
        super(n);
    }
}
class Cat extends Animal{
    public Cat(String n){
        super(n);
    }
}
