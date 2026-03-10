package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kullanici extends Oyuncu {
    public Kullanici(int oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
    }

@Override
    public List<SavasAraclari> kartSec() {
        Scanner scanner = new Scanner(System.in);
        List<SavasAraclari> secilenKartlar = new ArrayList<>();

        System.out.println("Elinizdeki kartlar:");
        for (int i = 0; i < getKartListesi().size(); i++) {
            System.out.println((i + 1) + ". " + getKartListesi().get(i).getSinif());
        }

        System.out.println("3 kart seçin (1-" + getKartListesi().size() + " arasında):");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + ". Kart numarası: ");
            int secim = scanner.nextInt() - 1;
            if (secim >= 0 && secim < getKartListesi().size()) {
                secilenKartlar.add(getKartListesi().get(secim));
            } else {
                System.out.println("Geçersiz seçim! Tekrar deneyin.");
                i--;
            }
        }

        return secilenKartlar;
    }
}
