package pl.edu.amu.wmi.s473615;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IncorrectFileNameException {

        ZooManagement zooManagement = new ZooManagement();
        Scanner scanner = new Scanner(System.in);

        Mammal mammal1 = new Mammal("Lion - King", new Date(94, 11, 18), "uterus", true);
        Mammal mammal2 = new Mammal("Platypus - Pepe", new Date(121, 5, 1), "egg", true);
        Amphibian amphibian1 = new Amphibian("Turtle - Leonardo", new Date(28, 12, 87), true);
        Amphibian amphibian2 = new Amphibian("Turtle - Donatello", new Date(28, 12, 87), false);
        Amphibian amphibian3 = new Amphibian("Turtle - Michelangelo", new Date(28, 12, 87), false);
        Amphibian amphibian4 = new Amphibian("Turtle - Raphael", new Date(28, 12, 87), false);
        Bird bird1 = new Bird("Ostrich - Road Runner", new Date(49, 9, 17), true);
        Fish fish1 = new Fish("Clownfish - Nemo", new Date(103, 11, 21), false);
        zooManagement.getAnimals().put(1, mammal1);
        zooManagement.getAnimals().put(2, mammal2);
        zooManagement.getAnimals().put(3, amphibian1);
        zooManagement.getAnimals().put(4, bird1);
        zooManagement.getAnimals().put(5, fish1);

        Enclosure enclosure = new Enclosure("Enclosure n01", 600.0, "Savannah", 4.0, "Lion Enclosure Fence");
        enclosure.getAnimals().put(1, mammal1);
        enclosure.getAnimals().put(3, bird1);

        Reservoir reservoir = new Reservoir("Reservoir n01", "Ocean", 2000.0, "salty");
        reservoir.getAnimals().put(1, mammal2);
        reservoir.getAnimals().put(2, fish1);

        Reservoir reservoir2 = new Reservoir("Reservoir n02", "Lake", 500.0, "sweet");
        reservoir2.getAnimals().put(1, amphibian1);
        reservoir2.getAnimals().put(2, amphibian2);
        reservoir2.getAnimals().put(3, amphibian3);
        reservoir2.getAnimals().put(4, amphibian4);

        zooManagement.getSpaces().put(1, enclosure);
        zooManagement.getSpaces().put(2, reservoir);
        zooManagement.getSpaces().put(3, reservoir2);



        loop: while (true) {
            System.out.println("\n--------------------------------------");
            System.out.println("Welcome in basic Zoo managment system!\nWhat do you want to do? (Choose the number)");
            System.out.println("--------------------------------------");
            System.out.println("1. List spaces.");
            System.out.println("2. Feed Animals.");
            System.out.println("3. Add a new Animal.");
            System.out.println("4. List animals.");
            System.out.println("5. Read a file.");
            System.out.println("6. Save a file.");
            System.out.println("7. Clear lists.");
            System.out.println("0. Exit the program.\n");

            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    if (zooManagement.getSpaces().isEmpty()) {
                        System.out.print("No Spaces to print!");
                        break;
                    }
                    for (Map.Entry<Integer, Space> entry : zooManagement.getSpaces().entrySet()) {
                        zooManagement.printSpaces(entry.getValue().getClass().toString(), entry);
                        System.out.println();
                    }
                    break;
                case 2:
                    FeedAnimals feedAnimals = new FeedAnimals(zooManagement);
                    feedAnimals.start();
                    break;
                case 3:
                    try {
                        zooManagement.addAnimal();
                    } catch (ParseException err) {
                        System.out.println("Parsing exception occured!");
                    }
                    break;
                case 4:
                    if (zooManagement.getAnimals().isEmpty()) {
                        System.out.print("No Animals to print!");
                        break;
                    }
                    for (Map.Entry<Integer, Animal> entry : zooManagement.getAnimals().entrySet()) {
                        zooManagement.printAnimals(entry.getValue().getClass().toString(), entry);
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.print("Filepath: ");
                    String filePath = scanner.next();
                    try {
                        FileIO fileIO = new FileIO();
                        zooManagement = fileIO.readFile(filePath);
                    } catch (IncorrectFileNameException e) {
                        System.err.println(e);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 6:
                    System.out.print("Filepath: ");
                    String writeFilePath = scanner.next();
                    try {
                        FileIO fileIO = new FileIO();
                        fileIO.saveFile(writeFilePath, zooManagement);
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case 7:
                    zooManagement.getAnimals().clear();
                    zooManagement.getSpaces().clear();
                    System.out.println("Lists cleared!");
                    break;
                case 0:
                    break loop;
                default:
                    System.out.println("Invalid number: " + n + " choose the correct one!");
            }
        }
    }
}
