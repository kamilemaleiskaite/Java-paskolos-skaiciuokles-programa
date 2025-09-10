package com.example.paskolosskaiciuokle;

import Loan.Loan;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

@FXML private TextField textField1;
@FXML private TextField textField2;
@FXML private TextField textField3;
@FXML private TextField textField4;
@FXML private TextField textField5;
@FXML private TextField textField6;
@FXML private TextField textField7;
@FXML private RadioButton anuiteto;
@FXML private RadioButton linijinis;

public Loan loan;
public double paskola = 0;
public int metai = 0;
public int menesiai = 0;
public double metProc = 0;
public int metaiAtideti = 0;
public int menesiaiAtideti = 0;
public double atidejimoProc = 0;

    @FXML
    public void paspaudimas() {
        try {
            paskola = textField1.getText().isEmpty() ? 0 : Double.parseDouble(textField1.getText());
            metai = textField2.getText().isEmpty() ? 0 : Integer.parseInt(textField2.getText());
            menesiai = textField3.getText().isEmpty() ? 0 : Integer.parseInt(textField3.getText());
            metProc = textField4.getText().isEmpty() ? 0 : Double.parseDouble(textField4.getText());
            metaiAtideti = textField5.getText().isEmpty() ? 0 : Integer.parseInt(textField5.getText());
            menesiaiAtideti = textField6.getText().isEmpty() ? 0 : Integer.parseInt(textField6.getText());
            atidejimoProc = textField7.getText().isEmpty() ? 0 : Double.parseDouble(textField7.getText());

            loan = new Loan(paskola, metai, menesiai, metProc, metaiAtideti, menesiaiAtideti, atidejimoProc);
            List<Mokejimas> rezultatai = new ArrayList<>();

            if(anuiteto.isSelected()){
                Anuitetinis anuitetinis = new Anuitetinis(loan);
                anuitetinis.paskola = paskola;
                anuitetinis.menesineImokaAn();
                rezultatai = anuitetinis.getAnuitetinioMokLentele();
            } else if (linijinis.isSelected()){
                Linijinis linijinis = new Linijinis(loan);
                linijinis.menesineImokaLin();
                rezultatai = linijinis.getLinijinionioMokLentele();
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lentele.fxml"));
            Parent root = loader.load();

            Lentele controller = loader.getController();
            controller.setLoanData(rezultatai);

            Stage stage = new Stage();
            stage.setTitle("Paskolos mokėjimo lentelė");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println("Nepavyko su pirmu langu");
        }
    }
}
