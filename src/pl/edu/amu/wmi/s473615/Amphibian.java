package pl.edu.amu.wmi.s473615;

import java.util.Date;

public class Amphibian extends Animal {

    private Boolean tail;

    public Amphibian(String name, Date birthday, Boolean tail) {
        super(name, birthday, "cold-blooded", "egg");
        this.tail = tail;
    }

    public Boolean getTail() {
        return tail;
    }

    public void setTail(Boolean tail) {
        this.tail = tail;
    }
}
