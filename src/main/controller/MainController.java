package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.Bilgisayar;
import main.Firkateyn;
import main.Kullanici;
import main.Obus;
import main.SavasAraclari;
import main.Ucak;
import main.Siha;
import main.Sida;
import main.KFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainController {

    private Kullanici oyuncu;
    private Bilgisayar bilgisayar;
    private int toplamHamle = 5;
    private int hamleSayisi = 0;

    @FXML
    public void oyundanCik() {
        System.exit(0);
    }

    @FXML
    public void baslatOyunu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/kart_secim.fxml"));
            Parent root = loader.load();

            KartSecimController kartSecimController = loader.getController();

            Stage stage = new Stage();
            stage.setTitle("Kart Seçimi");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            List<String> oyuncununSecilenKartlari = kartSecimController.getSecilenKartlar();

            oyuncu = new Kullanici(1, "Oyuncu", 0);
            bilgisayar = new Bilgisayar(2, "Bilgisayar", 0);

            oyuncu.setKartListesi(secilenKartlariToSavasAraclari(oyuncununSecilenKartlari));
            bilgisayar.setKartListesi(kartlariDagit(false));

            Alert alert = new Alert(AlertType.INFORMATION, "Oyun başladı! İyi şanslar.");
            alert.showAndWait();

            oyunDongusu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void oyunDongusu() {
        while (!oyunSonuKontrol() && hamleSayisi < toplamHamle) {
            hamleSayisi++;
            System.out.println("Hamle " + hamleSayisi + " başlıyor.");

            List<SavasAraclari> bilgisayarSecimi = bilgisayar.kartSec();
            List<SavasAraclari> oyuncuSecimi = oyuncu.kartSec();

            savas(oyuncuSecimi, bilgisayarSecimi);

            oyuncu.getKartListesi().add(rastgeleKartOlustur(oyuncu.getSkor() >= 20));
            bilgisayar.getKartListesi().add(rastgeleKartOlustur(bilgisayar.getSkor() >= 20));
        }

        oyunSonu();
    }

    private void savas(List<SavasAraclari> oyuncuKartlari, List<SavasAraclari> bilgisayarKartlari) {
        for (int i = 0; i < 3; i++) {
            int oyuncuHasar = SaldiriHesapla(oyuncuKartlari.get(i), bilgisayarKartlari.get(i));
            int bilgisayarHasar = SaldiriHesapla(bilgisayarKartlari.get(i), oyuncuKartlari.get(i));

            bilgisayarKartlari.get(i).DurumGuncelle(oyuncuHasar);
            oyuncuKartlari.get(i).DurumGuncelle(bilgisayarHasar);

            if (bilgisayarKartlari.get(i).getDayaniklilik() <= 0) {
                oyuncu.setSkor(oyuncu.getSkor() + 10);
            }
            if (oyuncuKartlari.get(i).getDayaniklilik() <= 0) {
                bilgisayar.setSkor(bilgisayar.getSkor() + 10);
            }
        }
    }

    private boolean oyunSonuKontrol() {
        return oyuncu.getKartListesi().isEmpty() || bilgisayar.getKartListesi().isEmpty();
    }

    private void oyunSonu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sonuc.fxml"));
            Parent root = loader.load();

            SonucController sonucController = loader.getController();
            sonucController.setSonuc(oyuncu.getSkor(), bilgisayar.getSkor());

            Stage stage = new Stage();
            stage.setTitle("Oyun Sonucu");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<SavasAraclari> kartlariDagit(boolean ekstraKartErisimi) {
        List<SavasAraclari> kartlar = new ArrayList<>();
        kartlar.add(new Ucak(0, 20, 10));
        kartlar.add(new Obus(0, 20, 15));
        kartlar.add(new Firkateyn(0, 25, 12));

        if (ekstraKartErisimi) {
            kartlar.add(new Siha(0, 15, 20));
            kartlar.add(new Sida(0, 15, 18));
            kartlar.add(new KFS(0, 10, 25));
        }
        return kartlar;
    }

    private SavasAraclari rastgeleKartOlustur(boolean ekstraKartErisimi) {
        Random random = new Random();
        int kartTipi = random.nextInt(ekstraKartErisimi ? 6 : 3); // 0-2 temel, 3-5 ekstra
        switch (kartTipi) {
            case 0: return new Ucak(0, 20, 10);
            case 1: return new Obus(0, 20, 15);
            case 2: return new Firkateyn(0, 25, 12);
            case 3: return new Siha(0, 15, 20);
            case 4: return new Sida(0, 15, 18);
            case 5: return new KFS(0, 10, 25);
            default: throw new IllegalStateException("Geçersiz kart tipi");
        }
    }

    private List<SavasAraclari> secilenKartlariToSavasAraclari(List<String> secilenKartlar) {
        List<SavasAraclari> kartlar = new ArrayList<>();
        for (String kart : secilenKartlar) {
            switch (kart) {
                case "Uçak":
                    kartlar.add(new Ucak(0, 20, 10));
                    break;
                case "Obüs":
                    kartlar.add(new Obus(0, 20, 15));
                    break;
                case "Fırkateyn":
                    kartlar.add(new Firkateyn(0, 25, 12));
                    break;
                default:
                    System.err.println("Bilinmeyen kart türü: " + kart);
            }
        }
        return kartlar;
    }

    private int SaldiriHesapla(SavasAraclari saldiran, SavasAraclari hedef) {
        int hasar = saldiran.getVurus();
        if (saldiran instanceof Ucak && hedef instanceof Obus) {
            hasar += 5; // Hava kara avantajı
        } else if (saldiran instanceof Obus && hedef instanceof Firkateyn) {
            hasar += 5; // Kara deniz avantajı
        } else if (saldiran instanceof Firkateyn && hedef instanceof Ucak) {
            hasar += 5; // Deniz hava avantajı
        }
        return hasar;
    }
}
