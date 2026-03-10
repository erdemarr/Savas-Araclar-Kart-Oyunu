package main.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class KartSecimController {

    @FXML
    private ListView<String> kartListesi;

    private List<String> oyuncuKartlari;
    private List<String> secilenKartlar;

    @FXML
    public void initialize() {
        oyuncuKartlari = new ArrayList<>();
        oyuncuKartlari.add("Uçak");
        oyuncuKartlari.add("Obüs");
        oyuncuKartlari.add("Fırkateyn");
        oyuncuKartlari.add("Uçak");
        oyuncuKartlari.add("Obüs");
        oyuncuKartlari.add("Fırkateyn");

        kartListesi.setItems(FXCollections.observableArrayList(oyuncuKartlari));
        kartListesi.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
    }

    @FXML
    public void secimTamamla() {
        secilenKartlar = new ArrayList<>(kartListesi.getSelectionModel().getSelectedItems());
        if (secilenKartlar.size() != 3) {
            Alert alert = new Alert(AlertType.ERROR, "Lütfen tam olarak 3 kart seçin!");
            alert.showAndWait();
        } else {
            oyuncuKartlari.removeAll(secilenKartlar);
            
            kartListesi.setItems(FXCollections.observableArrayList(oyuncuKartlari));
            
            Stage stage = (Stage) kartListesi.getScene().getWindow();
            stage.close();
        }
    }

    public List<String> getSecilenKartlar() {
        return secilenKartlar;
    }

    public List<String> getOyuncuKartlari() {
        return oyuncuKartlari;
    }
}
