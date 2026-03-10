package main;

public abstract class HavaAraclari extends SavasAraclari {

 public HavaAraclari(int seviyePuani) {
     super(); 
     setSeviyePuani(seviyePuani);
 }

 public abstract String getAltSinif();

 public abstract int getKaraVurusAvantaji();

 @Override
 public void KartPuaniGoster() {
     System.out.println("Hava Aracı Kartı:");
     System.out.println("Alt Sınıf: " + getAltSinif());
     System.out.println("Dayanıklılık: " + getDayaniklilik());
     System.out.println("Seviye Puanı: " + getSeviyePuani());
     System.out.println("Kara Vuruş Avantajı: " + getKaraVurusAvantaji());
 }

 @Override
 public abstract void DurumGuncelle(int vurusDegeri);
}
