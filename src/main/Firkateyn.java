//Fırkateyn sınıfı, DenizAraclari sınıfından türetilmiştir
package main;



public class Firkateyn extends DenizAraclari {
 private int dayaniklilik;
 private int vurus;
 private final String sinif = "Deniz";
 private final String altSinif = "Fırkateyn";
 private final int havaVurusAvantaji = 5;

 public Firkateyn(int seviyePuani, int dayaniklilik, int vurus) {
     super(seviyePuani);
     this.dayaniklilik = dayaniklilik;
     this.vurus = vurus;
 }

 @Override
 public int getDayaniklilik() {
     return dayaniklilik;
 }

 @Override
 public String getSinif() {
 	return sinif;
 }
 
 @Override
 public String getAltSinif() {
     return altSinif;
 }

 @Override
 public int getVurus() {
     return vurus;
 }

 @Override
 public int getHavaVurusAvantaji() {
     return havaVurusAvantaji;
 }

 @Override
 public void DurumGuncelle(int vurusDegeri) {
     this.dayaniklilik -= vurusDegeri;
     if (dayaniklilik < 0) {
         dayaniklilik = 0;
     }
 }

 @Override
 public void KartPuaniGoster() {
     System.out.println("Kart Tipi: " + sinif);
     System.out.println("Alt Sınıf: " + altSinif);
     System.out.println("Dayanıklılık: " + dayaniklilik);
     System.out.println("Vuruş Gücü: " + vurus);
     System.out.println("Hava Vuruş Avantajı: " + havaVurusAvantaji);
     System.out.println("Seviye Puanı: " + getSeviyePuani());
 }
}
