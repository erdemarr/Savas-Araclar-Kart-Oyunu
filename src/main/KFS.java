package main;



public class KFS extends KaraAraclari {
 private int dayaniklilik;
 private int vurus;
 private final String sinif = "Kara";
 private final String altSinif = "KFS";
 private final int denizVurusAvantaji = 10;
 private final int havaVurusAvantaji = 20;

 public KFS(int seviyePuani, int dayaniklilik, int vurus) {
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
 public int getDenizVurusAvantaji() {
     return denizVurusAvantaji;
 }

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
     System.out.println("Deniz Vuruş Avantajı: " + denizVurusAvantaji);
     System.out.println("Hava Vuruş Avantajı: " + havaVurusAvantaji);
     System.out.println("Seviye Puanı: " + getSeviyePuani());
 }
}
