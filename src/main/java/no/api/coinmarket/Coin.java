package no.api.coinmarket;

public class Coin {
    private String name;
    private double pris;
    private double forjePris;

    public Coin() {
        this(null, 0.0);
    }

    public Coin(String name, double pris) {
        this.name = name;
        this.pris = pris;
    }

    public double getForjePris() {
        return forjePris;
    }

    public void setForjePris(double forjePris) {
        this.forjePris = forjePris;
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
