package pl.edu.amu.wmi.s473615;

public class Enclosure extends Space {
    private Double area;
    private Double fenceHeight;
    private String fenceType;

    public Enclosure(String name, Double area, String climate, Double fenceHeight, String fenceType) {
        super(name, "Outdoor", climate);
        this.area = area;
        this.fenceHeight = fenceHeight;
        this.fenceType = fenceType;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getFenceHeight() {
        return fenceHeight;
    }

    public void setFenceHeight(Double fenceHeight) {
        this.fenceHeight = fenceHeight;
    }

    public String getFenceType() {
        return fenceType;
    }

    public void setFenceType(String fenceType) {
        this.fenceType = fenceType;
    }
}
