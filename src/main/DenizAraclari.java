//Deniz Araçları abstract sınıfı
package main;

public abstract class DenizAraclari extends SavasAraclari {

 public DenizAraclari(int seviyePuani) {
     super(); 
     setSeviyePuani(seviyePuani); 
 }

 public abstract String getAltSinif();

 public abstract int getHavaVurusAvantaji();

 @Override
 public void KartPuaniGoster() {
     System.out.println("Deniz Aracı Kartı:");
     System.out.println("Alt Sınıf: " + getAltSinif());
     System.out.println("Dayanıklılık: " + getDayaniklilik());
     System.out.println("Seviye Puanı: " + getSeviyePuani());
     System.out.println("Hava Vuruş Avantajı: " + getHavaVurusAvantaji());
 }

 @Override
 public abstract void DurumGuncelle(int vurusDegeri);
}
