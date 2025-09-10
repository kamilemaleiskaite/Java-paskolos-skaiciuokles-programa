package Loan;

public class Loan {
    private double paskola;
    private final int metai;
    private final int menesiai;
    private final double metProc;
    private final int metaiAtideti;
    private final int menesiaiAtideti;
    private final double atidejimoProc;

    public Loan(double paskola, int metai, int menesiai, double metProc, int metaiAtideti, int menesiaiAtideti, double atidejimoProc) {
        this.paskola = paskola;
        this.metai = metai;
        this.menesiai = menesiai;
        this.metProc = metProc;
        this.metaiAtideti = metaiAtideti;
        this.menesiaiAtideti = menesiaiAtideti;
        this.atidejimoProc = atidejimoProc;
    }
    public double getPaskola() {
        return paskola;
    }
    public int getMetai() {
        return metai;
    }
    public int getMenesiai() {
        return menesiai;
    }
    public double getMetProc() {
        return metProc;
    }
    public int getMetaiAtideti() {
        return metaiAtideti;
    }
    public int getMenesiaiAtideti() {
        return menesiaiAtideti;
    }
    public double getAtidejimoProc() {
        return atidejimoProc;
    }

    public void menesineImokaAn(){
        System.out.println("OVERRIDE PANAUDOJIMAS");
    }
    public void menesineImokaLin(){
        System.out.println("OVERRIDE PANAUDOJIMAS");
    }

}
