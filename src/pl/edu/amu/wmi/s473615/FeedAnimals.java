package pl.edu.amu.wmi.s473615;

import java.util.Map;

public class FeedAnimals extends Thread {

    ZooManagement zooManagement;

    public FeedAnimals(ZooManagement zooManagement) {
        this.zooManagement = zooManagement;
    }

    @Override
    public void run() {
        for (Map.Entry<Integer, Animal> entry:zooManagement.getAnimals().entrySet()) {
            entry.getValue().Feed();
            System.out.println(entry.getValue().getName() + " feeded.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
