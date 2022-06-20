package pl.edu.amu.wmi.s473615;

import java.util.Date;

public class Bird extends Animal {

    private Boolean flightless;

    public Bird(String name, Date birthday, Boolean flightless) {
        super(name, birthday, "warm-blooded", "egg");
        this.flightless = flightless;
    }

    public Boolean getFlightless() {
        return flightless;
    }

    public void setFlightless(Boolean flightless) {
        this.flightless = flightless;
    }
}
