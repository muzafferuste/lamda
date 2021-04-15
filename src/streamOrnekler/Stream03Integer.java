package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream03Integer {

    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);
        liste.add(500);
        liste.add(-15);
        liste.add(-1);

        System.out.println("En buyuk deger: " + buyukBul(liste));
        System.out.println("En buyuk deger 2: " + buyukBul2(liste));
        System.out.println("En buyuk deger 3: " + buyukBul3(liste));

        System.out.println("En kucuk deger: " + kucukBul(liste));

        System.out.println("Carpim degeri: " + carpimBul(liste));

        System.out.println("Kac tane 9 degeri var: " + dokuzSay(liste));

        System.out.println("Negatif sayilarin listesi: " + negatifSayilar(liste));

        System.out.println("Tek sayilarin sirali ve tekrarsiz listesi: " + tekKareSiraliListele(liste));

    }

    public static int buyukBul(List<Integer> list) {
        return list.stream().reduce(0, (x, y)-> x > y ? x : y);
    }

    public static int buyukBul2(List<Integer> list) {
        return list.stream().reduce(0, Math::max);
    }

    public static int buyukBul3(List<Integer> list) {
        return list.stream().sorted().reduce(0, (x,y) -> y);
    }

    public static int kucukBul(List<Integer> list) {
        return list.stream().reduce(0, (x, y)-> x < y ? x : y);
    }

    public static int carpimBul(List<Integer> list) {
        return list.stream().reduce(1, (x, y) -> x * y);
    }

    // Liste icerisinde kac tane 9 sayisi bulundugunu bulan method:
    public static int dokuzSay(List<Integer> liste) {
        return (int) liste.stream().filter(x -> x == 9).count();
    }

    // Liste icerisinde negatif sayilari farkli bir list olarak tutan method:
    public static List<Integer> negatifSayilar(List<Integer> liste) {
        return liste.stream().filter(x -> x < 0).collect(Collectors.toList());
    }

    // Listedeki tek elemanlarin karelerini sirali olarak ve tekrarsiz
    // bir sekilde yazdiran method:
    public static List<Integer> tekKareSiraliListele(List<Integer> liste) {
        return liste
                .stream()
                .distinct()
                .filter(Methodlar::tekMi)
                .map(x -> (int) Math.pow(x, 2))
                .distinct()
                .sorted()
                //.sorted(Comparator.reverseOrder()) // ters sirali yazdirmak icin
                .collect(Collectors.toList());
    }

}
