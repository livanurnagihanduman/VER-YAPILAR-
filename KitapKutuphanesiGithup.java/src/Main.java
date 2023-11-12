//Ad = Livanur Nagihan
//Soyad = Duman
//Numara = 220706003

import java.util.ArrayList;
import java.util.Scanner;

class Kitap{
    private String Ad;
    private String Yazar;

    public Kitap(String Ad,String Yazar){
        this.Ad = Ad;
        this.Yazar = Yazar;
    }
    public String getAd(){
        return Ad;
    }
    public String getYazar(){
        return Yazar;
    }

    @Override
    public String toString(){
        return ("Kitap Adı = " + Ad + "\nYazar = " + Yazar);
    }
}
class KitapKutuphanesi {
    private static ArrayList<Kitap> kitapListesi = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        System.out.println("***KİTAP KÜTÜPHANESİ PROGRAMINA HOŞGELDİNİZ***");


        while (true) {
            System.out.println("\nLütfen aşağıdaki seçeneklerden birini değerlendiriniz!");
            System.out.println("1) Yeni kitap Ekle ");
            System.out.println("2) Kütüphanedeki Yeni Kitapları Görüntüle ");
            System.out.println("3) Uygulamadan Çıkış ");
            System.out.println("Lütfen bi seçenek girin");


            int secim = scanner.nextInt();
            scanner.nextLine();


            switch (secim) {
                case 1:
                    yeniKitapEkle();
                    break;
                case 2:
                    kutuphanedekiKitaplariGoruntule();
                    break;
                case 3:
                    System.out.println("Kitap Kütüphanesi uygulamasından çıkılıyor. İyi günler!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçenek. Lütfen geçerli bir seçenek girin.");
            }
        }
    }


    private static void yeniKitapEkle() {
        System.out.print("Kitap Adı: ");
        String ad = scanner.nextLine();
        System.out.print("Yazar: ");
        String yazar = scanner.nextLine();

        Kitap yeniKitap = new Kitap(ad, yazar);
        kitapListesi.add(yeniKitap);
        System.out.println("Yeni kitap kütüphaneye eklendi.");
    }

    private static void kutuphanedekiKitaplariGoruntule() {
        if (kitapListesi.isEmpty()) {
            System.out.println("Kütüphanede kitap bulunmuyor.");
            return;
        }

        System.out.println("Kütüphanedeki Kitaplar:");
        for (Kitap kitap : kitapListesi) {
            System.out.println(kitap);
        }
    }
}



