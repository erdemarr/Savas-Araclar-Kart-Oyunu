package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Oyuncu sınıfı
public class Oyuncu {
    private int oyuncuID;
    private String oyuncuAdi;
    private int skor;
    private List<SavasAraclari> kartListesi;
    private boolean ekstraKartErisimi; 

    public Oyuncu() {
        this.oyuncuID = 0;
        this.oyuncuAdi = "Bilinmeyen";
        this.skor = 0;
        this.kartListesi = new ArrayList<>();
        this.ekstraKartErisimi = false; 
    }


    public Oyuncu(int oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
        this.kartListesi = new ArrayList<>();
        this.ekstraKartErisimi = false; 
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public List<SavasAraclari> getKartListesi() {
        return kartListesi;
    }

    public void setKartListesi(List<SavasAraclari> kartListesi) {
        this.kartListesi = kartListesi;
    }

    public boolean getEkstraKartErisimi() {
        return ekstraKartErisimi;
    }

    public void setEkstraKartErisimi(boolean ekstraKartErisimi) {
        this.ekstraKartErisimi = ekstraKartErisimi;
    }
    
    public void SkorGoster() {
        System.out.println(oyuncuAdi + " Skor: " + skor);
    }

    public List<SavasAraclari> kartSec() {
        return new ArrayList<>(); 
    }
}
