package pl.edu.amu.wmi.s473615;

public class Reservoir extends Space {
    private Double volume;
    private String waterType;

    public Reservoir(String name, String climate, Double volume, String waterType) {
        super(name, "Outdoor", climate);
        this.volume = volume;
        this.waterType = waterType;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }
}
