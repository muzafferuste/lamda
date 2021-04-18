package streamProje01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<Ogrenci> ogreciListesi = new ArrayList();
    private static List<Ogrenci> tempList = new ArrayList<>();

    public static void main(String[] args) {

        testOgrenciOlustu();
        System.out.println("=======Isme gore listele=======");
        ismeGoreListele("ahmet");
        System.out.println("=======Isme gore listele gecersiz isim ile deneme=======");
        ismeGoreListele("john");
        System.out.println("=======Soy isme gore listele=======");
        soyIsmeGoreListele("can");
        System.out.println("=======Soy isme gore listele gecersiz soyisim ile deneme=======");
        soyIsmeGoreListele("mehmet");
        System.out.println("=======Cinsiyete gore listele=======");
        cinsiyeteGoreListele("erkek");
        System.out.println("=======Cinsiyete gore listele gecersiz cinsiyet ile deneme=======");
        cinsiyeteGoreListele("belirtmek istemiyorum");
        System.out.println("=======Diploma Notuna gore sirala (artan)=======");
        notaGoreSiralaArtan();
        System.out.println("=======Diploma Notuna gore sirala (azalan)=======");
        notaGoreSiralaAzalan();
        System.out.println("=======Yasa gore sirala (artan)=======");
        yasaGoreSiralaArtan();
        System.out.println("=======Yasa gore sirala (azalan)=======");
        yasaGoreSiralaAzalan();
        System.out.println("=======Sinifin ortalama diploma notu=======");
        sinifinOrtalamaDiplomaNotu();


    }

    private static void testOgrenciOlustu() {

        ogreciListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogreciListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogreciListesi.add(new Ogrenci("Ayse", "Can", 21, 82.3, "kadin"));
        ogreciListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogreciListesi.add(new Ogrenci("Ayse", "Yilmaz", 40, 45, "kadin"));
        ogreciListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogreciListesi.add(new Ogrenci("Veli", "Ozturk", 20, 95.5, "erkek"));

    }

    /* isim, soyisim ve cinsiyet'e gore siralama yaparken ilk basta bir tempList olusturuyorum
    Olusturma sebebim en sonda verdigim argument'e gore veri var mi yok mu diye kontrol etmek icin
    varsa yazdir yoksa "veri bulunamadi" yazdir diyebilmek icin.
     */

    private static void ismeGoreListele(String isim) {

        tempList = ogreciListesi.stream().filter(t -> t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList());

        // buradaki if else'i bir method olarak da olusturabilirdik ama boyle yazmak daha cok hosuma gitti :)
        if (tempList.isEmpty()) {

            System.out.println(isim + " ismine ait veri bulunamamistir.");

        } else {

            for (Ogrenci each :
                    tempList) {
                System.out.println(each);
            }
        }

    }

    private static void soyIsmeGoreListele(String soyIsim) {

        tempList = ogreciListesi.stream().filter(t -> t.getSoyad().equalsIgnoreCase(soyIsim)).collect(Collectors.toList());

        // buradaki if else'i bir method olarak da olusturabilirdik ama boyle yazmak daha cok hosuma gitti :)
        if (tempList.isEmpty()) {

            System.out.println(soyIsim + " soy ismine ait veri bulunamamistir.");

        } else {

            for (Ogrenci each :
                    tempList) {
                System.out.println(each);
            }
        }

    }

    private static void cinsiyeteGoreListele(String cinsiyet) {

        tempList = ogreciListesi.stream().filter(t -> t.getCinsiyet().equalsIgnoreCase(cinsiyet)).collect(Collectors.toList());

        // buradaki if else'i bir method olarak da olusturabilirdik ama boyle yazmak daha cok hosuma gitti :)
        if (tempList.isEmpty()) {

            System.out.println(cinsiyet + " cinsiyetine ait veri bulunamamistir.");

        } else {

            for (Ogrenci each :
                    tempList) {
                System.out.println(each);
            }
        }

    }

    private static void notaGoreSiralaArtan() {

        ogreciListesi.stream() // sorted methodunu kullanarak ve Comparator class'indan yardim alarak siraliyorum
                .sorted(Comparator.comparing(Ogrenci::getDiplomaNotu))
                .forEach(System.out::println);

    }

    private static void notaGoreSiralaAzalan() {

        ogreciListesi.stream() // sorted ile siraliyorum reversed ile tersine ceviriyorum
                .sorted(Comparator.comparing(Ogrenci::getDiplomaNotu).reversed())
                .forEach(System.out::println);

    }

    private static void yasaGoreSiralaArtan() {

        ogreciListesi.stream() // sorted methodunu kullanarak ve Comparator class'indan yardim alarak siraliyorum
                .sorted(Comparator.comparing(Ogrenci::getYas))
                .forEach(System.out::println);

    }

    private static void yasaGoreSiralaAzalan() {

        ogreciListesi.stream() // sorted ile siraliyorum reversed ile tersine ceviriyorum
                .sorted(Comparator.comparing(Ogrenci::getYas).reversed())
                .forEach(System.out::println);

    }

    private static void sinifinOrtalamaDiplomaNotu() {

        // avarage methodu bana bir deger dondurecegi icin ya
        // return etmemiz lazim ya da direkt sout icine yazmamiz lazim
        // return edersek OptionelDouble data turunu kullanmamiz gerekecek.
        // return edersek de main method icerisinde tekrardan sout icine yazmamiz gerekecek
        // bana en mantikli gelen yontem budur.

        // NOT: bu sekilde yazdirinca sonuc "OptionalDouble[74.18571428571428]" seklinde olacaktir

        System.out.println(ogreciListesi.stream()
                .mapToDouble(Ogrenci::getDiplomaNotu)
                .average());
    }

}
