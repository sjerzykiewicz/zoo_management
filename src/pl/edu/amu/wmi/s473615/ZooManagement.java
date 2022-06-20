package pl.edu.amu.wmi.s473615;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Objects.isNull;

public class ZooManagement implements Serializable {

    private Map<Integer, Animal> animals = new HashMap<>();

    public Map<Integer, Animal> getAnimals() {
        return animals;
    }

    private Map<Integer, Space> spaces = new HashMap<>();

    public Map<Integer, Space> getSpaces() {
        return spaces;
    }

    public void printAnimals(String className, Map.Entry entry) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        switch(className) {
            case "class pl.edu.amu.wmi.s473615.Mammal":
                Mammal mammal = (Mammal) entry.getValue();
                System.out.print(mammal.getName() + ", birthday: " + dateFormat.format(mammal.getBirthday()));
                if(mammal.getPreadator()) {
                    System.out.println(", predator");
                }
                else {
                    System.out.println();
                }
                if (isNull(mammal.getLastFeeding())) {
                    System.out.println("\tNot feeded yet!");
                }
                else {
                    System.out.println("\tLast feeding: " + mammal.getLastFeeding());
                }
                break;
            case "class pl.edu.amu.wmi.s473615.Amphibian":
                Amphibian amphibian = (Amphibian) entry.getValue();
                System.out.print(amphibian.getName() + ", birthday: " + dateFormat.format(amphibian.getBirthday()));
                if(amphibian.getTail()) {
                    System.out.println(", tailed");
                }
                else {
                    System.out.println(", tailless");
                }
                if (isNull(amphibian.getLastFeeding())) {
                    System.out.println("\tNot feeded yet!");
                }
                else {
                    System.out.println("\tLast feeding: " + amphibian.getLastFeeding());
                }
                break;
            case "class pl.edu.amu.wmi.s473615.Bird":
                Bird bird = (Bird) entry.getValue();
                System.out.print(bird.getName() + ", birthday: " + dateFormat.format(bird.getBirthday()));
                if(bird.getFlightless()) {
                    System.out.println(", flightless");
                }
                else {
                    System.out.println();
                }
                if (isNull(bird.getLastFeeding())) {
                    System.out.println("\tNot feeded yet!");
                }
                else {
                    System.out.println("\tLast feeding: " + bird.getLastFeeding());
                }
                break;
            case "class pl.edu.amu.wmi.s473615.Fish":
                Fish fish = (Fish) entry.getValue();
                System.out.print(fish.getName() + ", birthday: " + dateFormat.format(fish.getBirthday()));
                if(fish.getDeepSea()) {
                    System.out.println(", deepsea");
                }
                else {
                    System.out.println();
                }
                if (isNull(fish.getLastFeeding())) {
                    System.out.println("\tNot feeded yet!");
                }
                else {
                    System.out.println("\tLast feeding: " + fish.getLastFeeding());
                }
                break;

        }
    }

    public void addAnimal() throws ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an Animal class: Amphibian (a), Bird (b), Fish (f), Mammal (m)");
        String animalClass = scanner.next();
        Integer newId = this.getAnimals().size() + 1;
        switch (animalClass) {
            case "Amphibian":
            case "a":
                System.out.println("Enter an Amphibian name: (Species - Name)");
                scanner.useDelimiter("\n");
                String Aname = scanner.next();
                System.out.println("Enter " + Aname + " date of birth: (dd-MM-yyyy)");
                String AdateStr = scanner.next();
                Date Abirthdate = format.parse(AdateStr);
                System.out.println("Is a " + Aname + " tailed? (true / false)");
                Boolean tail = scanner.nextBoolean();
                this.getAnimals().put(newId, new Amphibian(Aname, Abirthdate, tail));
                break;
            case "Bird":
            case "b":
                System.out.println("Enter a Bird name: (Species - Name)");
                scanner.useDelimiter("\n");
                String Bname = scanner.next();
                System.out.println("Enter " + Bname + " date of birth: (dd-MM-yyyy)");
                String BdateStr = scanner.next();
                Date Bbirthdate = format.parse(BdateStr);
                System.out.println("Is a " + Bname + " flightless? (true / false)");
                Boolean flightless = scanner.nextBoolean();
                this.getAnimals().put(newId, new Bird(Bname, Bbirthdate, flightless));
                break;
            case "Fish":
            case "f":
                System.out.println("Enter a Fish name: (Species - Name)");
                scanner.useDelimiter("\n");
                String Fname = scanner.next();
                System.out.println("Enter " + Fname + " date of birth: (dd-MM-yyyy)");
                String FdateStr = scanner.next();
                Date Fbirthdate = format.parse(FdateStr);
                System.out.println("Is a " + Fname + " deepsea? (true / false)");
                Boolean deepsea = scanner.nextBoolean();
                this.getAnimals().put(newId, new Fish(Fname, Fbirthdate, deepsea));
                break;
            case "Mammal":
            case "m":
                System.out.println("Enter a Mammal name: (Species - Name)");
                scanner.useDelimiter("\n");
                String Mname = scanner.next();
                System.out.println("Enter " + Mname + " date of birth: (dd-MM-yyyy)");
                String MdateStr = scanner.next();
                Date Mbirthdate = format.parse(MdateStr);
                System.out.println("Is a " + Mname + " predator? (true / false)");
                Boolean predator = scanner.nextBoolean();
                System.out.println("Enter " + Mname + " embryo development (egg / uterus)");
                String embryoDev = scanner.next();
                this.getAnimals().put(newId, new Mammal(Mname, Mbirthdate, embryoDev, predator));
                break;
            default:
                System.out.println("Invalid class: " + animalClass);
                break;
        }
        System.out.println("Animal added!");

    }

    public void printSpaces(String className, Map.Entry entry) {
        switch(className) {
            case "class pl.edu.amu.wmi.s473615.Enclosure":
                Enclosure enclosure = (Enclosure) entry.getValue();
                System.out.println(enclosure.getName() + ", type: " + enclosure.getType() + ", climate: " + enclosure.getClimate());
                System.out.println("Area: " + enclosure.getArea() + ", fence type: " + enclosure.getFenceType() + ", fence height: " + enclosure.getFenceHeight());
                if (isNull(enclosure.getLastCleaning())) {
                    System.out.println("\tNot cleaned yet!");
                }
                else {
                    System.out.println("\tLast cleaning: " + enclosure.getLastCleaning());
                }
                System.out.println("Animals in space " + enclosure.getName() + ":");
                for (Map.Entry<Integer, Animal> entry2:enclosure.getAnimals().entrySet()) {
                    System.out.print("\t");
                    this.printAnimals(entry2.getValue().getClass().toString(), entry2);
                }
                break;
            case "class pl.edu.amu.wmi.s473615.Reservoir":
                Reservoir reservoir = (Reservoir) entry.getValue();
                System.out.println(reservoir.getName() + ", type: " + reservoir.getType() + ", climate: " + reservoir.getClimate());
                System.out.println("Volume: " + reservoir.getVolume() + ", water type: " + reservoir.getWaterType());
                if (isNull(reservoir.getLastCleaning())) {
                    System.out.println("\tNot cleaned yet!");
                }
                else {
                    System.out.println("\tLast cleaning: " + reservoir.getLastCleaning());
                }
                System.out.println("Animals in space " + reservoir.getName() + ":");
                for (Map.Entry<Integer, Animal> entry2:reservoir.getAnimals().entrySet()) {
                    System.out.print("\t");
                    this.printAnimals(entry2.getValue().getClass().toString(), entry2);
                }
                break;

        }

    }

}
