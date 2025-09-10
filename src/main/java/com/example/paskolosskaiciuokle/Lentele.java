package com.example.paskolosskaiciuokle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Lentele {
    @FXML private TableView<Mokejimas> loanTable;
    @FXML private TableColumn<Mokejimas, String> menesis;
    @FXML private TableColumn<Mokejimas, String> likutis;
    @FXML private TableColumn<Mokejimas, String> palukanos;
    @FXML private TableColumn<Mokejimas, String> menesineIm;

    private ObservableList<Mokejimas> data = FXCollections.observableArrayList();;

    @FXML
    public void initialize() {
        menesis.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMenesis()));
        likutis.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLikutis()));
        palukanos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPalukanos()));
        menesineIm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMenesineIm()));

        loanTable.setItems(data);
    }
    public void setLoanData(List<Mokejimas> mokLentele) {
        data.setAll(mokLentele);
    }
    @FXML
    public void showGraph() {
        new Grafikas().rodytiGrafika(data);
    }

    @FXML
    public void failoSukurimas() {
        String fileName = "atasakaitosfile.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            int widthMenesis = 10;
            int widthLikutis = 20;
            int widthPalukanos = 15;
            int widthMenesineIm = 20;

            String header = String.format(
                    "%-" + widthMenesis + "s%-" + widthLikutis + "s%-" + widthPalukanos + "s%-" + widthMenesineIm + "s\n",
                    "Mėnesis", "Likutis (€)", "Procentai (%)", "Mėnesinė įmoka (€)");
            writer.append(header);
            writer.append("-".repeat(widthMenesis + widthLikutis + widthPalukanos + widthMenesineIm)).append("\n");


            for (Mokejimas m : data) {
                String row = String.format(
                        "%-" + widthMenesis + "s%-" + widthLikutis + "s%-" + widthPalukanos + "s%-" + widthMenesineIm + "s\n",
                        m.getMenesis(), m.getLikutis(), m.getPalukanos(), m.getMenesineIm());
                writer.append(row);
            }
        } catch (IOException e) {
            System.out.println("Negerai su failu");
        }
    }


}
