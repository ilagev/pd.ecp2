package rest.business.views;

public class ThemeTransfer {

    private String name;
    
    private double average;

    public ThemeTransfer(String name, double average) {
        this.name = name;
        this.average = average;
    }

    public String getName() {
        return name;
    }
    
    public double getAverage() {
        return average;
    }
    
    @Override
    public String toString() {
        return "ThemeTransfer [themeName=" + name + ", average=" + average + "]"; 
    }

}
