package com.example.paskolosskaiciuokle;

import Loan.Loan;

import java.util.ArrayList;
import java.util.List;

public class Linijinis extends Loan {

    private final List<Mokejimas> linijinionioMokLentele;

    public Linijinis(Loan loan ) {
        super(loan.getPaskola(), loan.getMetai(), loan.getMenesiai(), loan.getMetProc(), loan.getMetaiAtideti(), loan.getMenesiaiAtideti(), loan.getAtidejimoProc());
        this.linijinionioMokLentele = new ArrayList<>();
    }

    @Override
    public void menesineImokaLin(){
        double palukanosNorma = getMetProc() / (100 * 12);
        double pradinePaskola = getPaskola();
        int bendrasImokuSk = getMetai() * 12 + getMenesiai();
        int atidetuMenSk = getMetaiAtideti() * 12 + getMenesiaiAtideti();
        double atidejimoProc = getAtidejimoProc() / 100 / 12;

        double likusiPaskola = pradinePaskola;
        double menesinePaskolosDalis = pradinePaskola / bendrasImokuSk;

        int counteris = 1;

        if(atidetuMenSk > 0) {
            for (int i = 1; i <= atidetuMenSk; i++) {
                double menImoka = getPaskola() * atidejimoProc;
                linijinionioMokLentele.add(new Mokejimas(counteris, likusiPaskola, 0, menImoka));
                counteris++;
            }
        }

        for (int i = counteris; i <= bendrasImokuSk; i++) {
            double palukanos = likusiPaskola * palukanosNorma;
            double menesineImoka = menesinePaskolosDalis + palukanos;

            if (likusiPaskola - menesinePaskolosDalis < 0) {
                menesinePaskolosDalis = likusiPaskola;
                menesineImoka = menesinePaskolosDalis + palukanos;
            }
            double sumoketaProc = ((pradinePaskola - likusiPaskola) / pradinePaskola) * 100;
            linijinionioMokLentele.add(new Mokejimas (counteris, likusiPaskola, sumoketaProc, menesineImoka ));
            likusiPaskola -= menesineImoka;
            counteris++;
            if (likusiPaskola <= 0) {break;}
        }
    }
    public List<Mokejimas> getLinijinionioMokLentele() {return linijinionioMokLentele;}
}


