package pl.edu.amu.wmi.s473615;

import java.io.Serializable;
import java.util.Date;

public abstract class Animal implements Serializable {

    private String name;
    private Date birthday;
    private String bodyTemp;
    private String embryoDevelopment;

    private Date lastFeeding;

    public Animal(String name, Date birthday, String bodyTemp, String embryoDevelopment) {
        this.name = name;
        this.birthday = birthday;
        this.bodyTemp = bodyTemp;
        this.embryoDevelopment = embryoDevelopment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(String bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public String getEmbryoDevelopment() {
        return embryoDevelopment;
    }

    public void setEmbryoDevelopment(String embryoDevelopment) {
        this.embryoDevelopment = embryoDevelopment;
    }

    public Date getLastFeeding() {
        return lastFeeding;
    }

    public void Feed() {
        lastFeeding = new Date(System.currentTimeMillis());
    }
}
