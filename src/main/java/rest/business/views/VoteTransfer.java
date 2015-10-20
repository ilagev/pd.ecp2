package rest.business.views;

public class VoteTransfer {

    private String name;
    
    private double note;

    public VoteTransfer(String name, double note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }
    
    public double getNote() {
        return note;
    }

}
