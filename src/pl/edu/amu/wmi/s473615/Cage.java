package pl.edu.amu.wmi.s473615;

public class Cage extends Space {
    private Double area;
    private Double height;

    public Cage(String name, String type, String climate, Double area, Double height) {
        super(name, type, climate);
        this.area = area;
        this.height = height;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
