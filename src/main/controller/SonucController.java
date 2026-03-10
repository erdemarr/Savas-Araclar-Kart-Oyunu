package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.Oyun;

public class SonucController {

    @FXML
    private Label sonucLabel;

    @FXML
    private Label oyuncuSkorLabel;

    @FXML
    private Label bilgisayarSkorLabel;

    private int oyuncuSkor;
    private int bilgisayarSkor;

    /**
     * Oyuncu ve bilgisayar skorlarını alır ve sonucu ekrana yansıtır.
     * @param oyuncuSkor Oyuncunun skoru.
     * @param bilgisayarSkor Bilgisayarın skoru.
     */
    @FXML
    public void setSonuc(int oyuncuSkor, int bilgisayarSkor) {
        this.oyuncuSkor = oyuncuSkor;
        this.bilgisayarSkor = bilgisayarSkor;

        oyuncuSkorLabel.setText("Oyuncu Skoru: " + oyuncuSkor);
        bilgisayarSkorLabel.setText("Bilgisayar Skoru: " + bilgisayarSkor);

        if (oyuncuSkor > bilgisayarSkor) {
            sonucLabel.setText("Tebrikler! Oyunu Kazandınız.");
        } else if (oyuncuSkor < bilgisayarSkor) {
            sonucLabel.setText("Bilgisayar Kazandı.");
        } else {
            sonucLabel.setText("Oyun Berabere!");
        }
    }

    /**
     * Oyunu sonlandırır ve pencereyi kapatır.
     * @param event Çıkış butonuna tıklama olayı.
     */
    @FXML
    public void oyundanCik(ActionEvent event) {
        Stage stage = (Stage) sonucLabel.getScene().getWindow();
        stage.close();
    }

    /**
     * Oyunu yeniden başlatır.
     * Mevcut pencereyi kapatarak yeni bir oyun başlatır.
     * @param event Yeniden başla butonuna tıklama olayı.
     */
    @FXML
    public void yenidenBasla(ActionEvent event) {
        Stage stage = (Stage) sonucLabel.getScene().getWindow();
        stage.close();
        try {
            new Oyun().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sonuç ekranını yeniden yükler.
     * Yeni bir sonuç ekranı başlatır, önceki sonuçlar korunur.
     */
    public void yenidenYukle() {
        try {
            Stage stage = new Stage();
            new Oyun().start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
