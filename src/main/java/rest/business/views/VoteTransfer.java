package rest.business.views;

public class VoteTransfer {
    
    private String themeName;
    
    private double note;
    
    public VoteTransfer(String themeName, double note) {
        this.themeName = themeName;
        this.note = note;
    }
    
    public String getThemeName() {
        return themeName;
    }

    public double getNote() {
        return note;
    }

}
