package pl.edu.amu.wmi.s473615;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public abstract class Space implements Serializable {
    private String name;
    private String type;
    private String climate;

    private Date lastCleaning;

    private Map<Integer, Animal> animals = new HashMap<>();

    public Map<Integer, Animal> getAnimals() {
        return animals;
    }

    public Space(String name, String type, String climate) {
        this.name = name;
        this.type = type;
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Date getLastCleaning() {
        return lastCleaning;
    }

    public void setLastCleaning(Date lastCleaning) {
        this.lastCleaning = lastCleaning;
    }

    public void Clean() {
        lastCleaning = new Date(System.currentTimeMillis());
    }

}
