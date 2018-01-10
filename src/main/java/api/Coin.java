package api;

public class Coin {
    private String name;
    private double pris;

    public Coin() {
        this(null,0.0);
    }

    public Coin(String name, double pris) {
        this.name = name;
        this.pris = pris;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}
