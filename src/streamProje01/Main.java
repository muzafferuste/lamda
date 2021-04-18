package streamProje01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<Ogrenci> ogrListesi = new ArrayList();

    public static void main(String[] args) {

        testOgrenciOlustu();
        ismeGoreListele("ahmet");
        System.out.println("==============");
        ismeGoreListele("ayse");
        System.out.println("==============");
        ismeGoreListele("john");

    }

    private static void testOgrenciOlustu() {

        ogrListesi.add(new Ogrenci("Ahmet", "Can", 30, 95.5, "erkek"));
        ogrListesi.add(new Ogrenci("Ahmet", "Baki", 18, 90.1, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Can", 21, 82.3, "kadin"));
        ogrListesi.add(new Ogrenci("Mustafa", "Can", 15, 75.4, "erkek"));
        ogrListesi.add(new Ogrenci("Ayse", "Yilmaz", 40, 45, "kadin"));
        ogrListesi.add(new Ogrenci("Ali", "Veli", 80, 35.5, "erkek"));
        ogrListesi.add(new Ogrenci("Veli", "Ozturk", 20, 95.5, "erkek"));

    }

    private static void ismeGoreListele(String isim) {

        List<Ogrenci> tempList = new ArrayList<>();
        ogrListesi.stream().filter(t -> t.getAd().equalsIgnoreCase(isim)).collect(Collectors.toList()).forEach(x -> tempList.add(x));
        if (tempList.isEmpty()) {
            System.out.println(isim + " ismine ait veri bulunamamistir.");
        } else {
            for (Ogrenci each :
                    tempList) {
                System.out.println(each);
            }
        }
    }

}
