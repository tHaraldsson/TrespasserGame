package se.tommy.adventure.inventory;

public class Inventory {

    private boolean hasFryingPan = false;
    private boolean hasPillow = false;

    public boolean isHasPillow() {
        return hasPillow;
    }

    public void setHasPillow(boolean hasPillow) {
        this.hasPillow = hasPillow;
    }

    public boolean isHasFryingPan() {
        return hasFryingPan;
    }

    public void setHasFryingPan(boolean hasFryingPan) {
        this.hasFryingPan = hasFryingPan;
    }

}
