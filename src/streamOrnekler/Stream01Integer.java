package streamOrnekler;

import java.util.ArrayList;
import java.util.List;

public class Stream01Integer {

    public static void main(String[] args) {

        List<Integer> rakamlar = new ArrayList<>();
        rakamlar.add(5);
        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-1000);
        rakamlar.add(4);

        System.out.println("Tum sayilar: ");
        rakamlar.stream().forEach(Stream01Integer::yazdir);

        System.out.println("\nTek sayilar: ");
        rakamlar.stream().filter(t -> t % 2 != 0).forEach(t -> System.out.print(t + " "));

        System.out.println("\nCift sayilar: ");
        rakamlar.stream().filter(t -> t % 2 == 0).forEach(Stream01Integer::yazdir);

        System.out.println("\nKendi methodumuz ile filtreleme yapmadan yazdirma: ");
        rakamlar.forEach(Stream01Integer::yazdir);

        System.out.println("\nKendi methodumuz ile tek sayilari filtreleme ve yazdirma: ");
        rakamlar.stream().filter(Stream01Integer::tekMi).forEach(Stream01Integer::yazdir);


        System.out.println("\n ==== CIFT SAYILAR(METHOD) ====");
        ciftleriYazdir(rakamlar);

    }

    public static void ciftleriYazdir(List<Integer> list) {

        // Method referansi kullanmadan rakamlar listesindeki cift sayilari yazdirma:
        // list.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));

        // Method referansi kullanarak rakamlar listesindeki cift sayilari yazdirma:
        list.stream().filter(Stream01Integer::ciftMi).forEach(Stream01Integer::yazdir);

    }

    public static void yazdir(int x) {
        System.out.print(x + " ");
    }

    public static boolean tekMi(int x) {
        return x % 2 != 0;
    }

    public static boolean ciftMi(int x) {
        return x % 2 == 0;
    }

}
