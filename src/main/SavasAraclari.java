
package main;

public abstract class SavasAraclari {
 private int seviyePuani;

 public SavasAraclari() {
     this.seviyePuani = 0; 
 }

 public int getSeviyePuani() {
     return seviyePuani;
 }

 public void setSeviyePuani(int seviyePuani) {
     this.seviyePuani = seviyePuani;
 }

 public abstract int getDayaniklilik();
 public abstract String getSinif();
 public abstract int getVurus();

 public abstract void DurumGuncelle(int vurusDegeri);

 public void KartPuaniGoster() {
     System.out.println("Dayanıklılık: " + getDayaniklilik());
     System.out.println("Seviye Puanı: " + seviyePuani);
 }
}
