package pl.edu.amu.wmi.s473615;

import java.util.Date;

public class Mammal extends Animal {

    private Boolean preadator;

    public Mammal(String name, Date birthday, String embryoDevelopment, Boolean preadator) {
        super(name, birthday, "warm-blooded", embryoDevelopment);
        this.preadator = preadator;
    }

    public Boolean getPreadator() {
        return preadator;
    }

    public void setPreadator(Boolean preadator) {
        this.preadator = preadator;
    }
}
