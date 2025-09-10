package com.example.paskolosskaiciuokle;

import Loan.Loan;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class Anuitetinis extends Loan {

    public double paskola;
    private final List<Mokejimas> anuitetinioMokLentele;

    public Anuitetinis(Loan loan) {
        super(loan.getPaskola(), loan.getMetai(), loan.getMenesiai(), loan.getMetProc(), loan.getMetaiAtideti(), loan.getMenesiaiAtideti(), loan.getAtidejimoProc());
        this.anuitetinioMokLentele = new ArrayList<>();
        this.paskola = loan.getPaskola();
    }

    @Override
    public void menesineImokaAn(){
        double menesineImoka;
        double priedasPriePaskolos;
        double palukanos = getMetProc() / 100 / 12;
        double bendraPaskola = this.paskola;
        double pradinePaskola = this.paskola;
        int bendrasImokuSk = getMetai() * 12 + getMenesiai();
        int atidetuMenSk = getMetaiAtideti() * 12 + getMenesiaiAtideti();
        double atidejimoProc = getAtidejimoProc() / 100 / 12;

        int counteris = 1;

        if(atidetuMenSk > 0) {
            for (int i = 1; i <= atidetuMenSk; i++) {
                priedasPriePaskolos = bendraPaskola * atidejimoProc;
                anuitetinioMokLentele.add(new Mokejimas (counteris, bendraPaskola, 0, priedasPriePaskolos));
                counteris++;
            }
        }
        menesineImoka = bendraPaskola * (palukanos * (pow(1 + palukanos, bendrasImokuSk - atidetuMenSk)) / (pow(1 + palukanos, bendrasImokuSk - atidetuMenSk) - 1));
        for (int i = counteris; i <= bendrasImokuSk; i++) {
            priedasPriePaskolos = bendraPaskola * palukanos;
            double paskolosPagSum = menesineImoka - priedasPriePaskolos;
            if (bendraPaskola - paskolosPagSum < 0) {
                paskolosPagSum = bendraPaskola;
                menesineImoka = paskolosPagSum + priedasPriePaskolos;
            }
            bendraPaskola -= paskolosPagSum;
            double sumoketaProc = ((pradinePaskola - bendraPaskola) / pradinePaskola) * 100;
            anuitetinioMokLentele.add(new Mokejimas (counteris, bendraPaskola, sumoketaProc, menesineImoka));
            counteris++;
            if (bendraPaskola <= 0) break;
        }
    }
    public List<Mokejimas> getAnuitetinioMokLentele() {return anuitetinioMokLentele;}
}
