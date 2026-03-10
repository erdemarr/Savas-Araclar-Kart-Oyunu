package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bilgisayar extends Oyuncu {
    private Random random;

    public Bilgisayar(int oyuncuID, String oyuncuAdi, int skor) {
        super(oyuncuID, oyuncuAdi, skor);
        this.random = new Random();
    }

@Override
    public List<SavasAraclari> kartSec() {
        List<SavasAraclari> secilenKartlar = new ArrayList<>();
        List<SavasAraclari> kartlar = getKartListesi();

        while (secilenKartlar.size() < 3) {
            int index = random.nextInt(kartlar.size());
            if (!secilenKartlar.contains(kartlar.get(index))) {
                secilenKartlar.add(kartlar.get(index));
            }
        }

        return secilenKartlar;
    }
}
