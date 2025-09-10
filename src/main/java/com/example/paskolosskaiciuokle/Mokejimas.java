package com.example.paskolosskaiciuokle;

public class Mokejimas {
    private final String menesis;
    private final String likutis;
    private final String procentai;
    private final String menesineIm;

    public Mokejimas(int menesis, double likutis, double procentai, double menesineIm) {
        this.menesis = String.valueOf(menesis);
        this.likutis = String.format("%.2f", likutis);
        this.procentai = String.format("%.2f", procentai) + "%";
        this.menesineIm = String.format("%.2f", menesineIm);
    }
    public String getMenesis() { return menesis; }
    public String getLikutis() { return likutis; }
    public String getPalukanos() { return procentai; }
    public String getMenesineIm() { return menesineIm; }
}
