package com.example.paskolosskaiciuokle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;

public class Grafikas {

    @FXML private LineChart<Number, Number> lineChart;

    public void generuotiGrafika(List<Mokejimas> mokLentele) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Mėnesinės įmokos");

        for (Mokejimas mok : mokLentele) {
            int menesis = Integer.parseInt(mok.getMenesis());
            double menesineIm = Double.parseDouble(mok.getMenesineIm());
            series.getData().add(new XYChart.Data<>(menesis, menesineIm));
        }
        lineChart.getData().clear();
        lineChart.getData().add(series);
    }

    public void rodytiGrafika(ObservableList<Mokejimas> rezultatai) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("grafikai.fxml"));
            Parent root = loader.load();

            Grafikas controller = loader.getController();
            controller.generuotiGrafika(rezultatai);

            Stage stage = new Stage();
            stage.setTitle("Paskolos mokėjimo grafikas");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            System.out.println("Klaida su grafiku langu");
        }
    }
}
