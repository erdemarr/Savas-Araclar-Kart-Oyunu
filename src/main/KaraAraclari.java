package main;

public abstract class KaraAraclari extends SavasAraclari {

 public KaraAraclari(int seviyePuani) {
     super(); 
     setSeviyePuani(seviyePuani);
 }

 public abstract String getAltSinif();

 public abstract int getDenizVurusAvantaji();

 @Override
 public void KartPuaniGoster() {
     System.out.println("Kara Aracı Kartı:");
     System.out.println("Alt Sınıf: " + getAltSinif());
     System.out.println("Dayanıklılık: " + getDayaniklilik());
     System.out.println("Seviye Puanı: " + getSeviyePuani());
     System.out.println("Deniz Vuruş Avantajı: " + getDenizVurusAvantaji());
 }

 @Override
 public abstract void DurumGuncelle(int vurusDegeri);
}

