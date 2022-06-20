package pl.edu.amu.wmi.s473615;

import java.util.Date;

public class Fish extends Animal {

    private Boolean deepSea;

    public Fish(String name, Date birthday, Boolean deepSea) {
        super(name, birthday, "cold-blooded", "egg");
        this.deepSea = deepSea;
    }

    public Boolean getDeepSea() {
        return deepSea;
    }

    public void setDeepSea(Boolean deepSea) {
        this.deepSea = deepSea;
    }
}
