package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Stream04String {

    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("alihano");
        liste.add("Mariano");
        liste.add("alberto");
        liste.add("Alonzo");
        liste.add("Tucker");
        liste.add("Alfonso");
        liste.add("Christ");

        aIleBaslayanlar(liste);
        System.out.println("===========");
        buyukHarfeCevir(liste);
        System.out.println("===========");
        uzunlugaGoreKucultSirala(liste, 3);
        System.out.println("TÜM ELEMANLAR BELİRTİLEN DEĞERDEN KÜÇÜK: " + uzunlukKucukMu(liste, 7));
        System.out.println("BAŞLAYAN YOK MU: " + baslamayanHarfVarMi(liste, "M"));
        System.out.println("HERHANGİ BİTEN HARF VAR MI: " + herhangiBitenVarMi(liste, "c"));
        System.out.println("===========");
        aileOYazdir(liste, "A", "O");
        System.out.println("\n===========");
        listeleYazdir(liste);
        System.out.println("\n===========");
    }

    //********************************************************************************************
    // ORNEK16: Listedeki baş harfi A ile başlayan isimleri yazdıran metodu tanımlayalım..
    //********************************************************************************************
    public static void aIleBaslayanlar(List<String> liste) {
        liste.stream()
                .filter(h -> h.startsWith("A"))
                .forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK17: Listedeki tüm isimleri büyük harfe çeviren metodu tanımlayalım..
    //********************************************************************************************
    public static void buyukHarfeCevir(List<String> liste) {
        liste.stream()
                .map(h -> h.toUpperCase())
                .forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK18: Listedeki tüm elemanlari uzunluklarina gore siralayan ve kucuk harfe ceviren method:
    //********************************************************************************************

    public static void uzunlugaGoreKucultSirala(List<String> liste, int uzunluk) {
        liste.stream()
                .filter(t -> t.length() > uzunluk)
                .forEach(Methodlar::StrYazdir);
    }

    //********************************************************************************************
    // ORNEK20: Listedeki tüm elemanlari uzunluklari belirtilen uzunluktan Kucuk mu
    // diye kontrol eden method'u yazin
    //********************************************************************************************

    // allMarch() belirtilen sartlari tum elemanlar sagliyorsa true, saglamiyorsa false
    public static boolean uzunlukKucukMu(List<String> liste, int uzunluk) {
        return liste.stream()
                .allMatch(t -> t.length() < uzunluk);
    }

    //********************************************************************************************
    // ORNEK21: Listedeki tüm elemanlarin belirtilen harf ile baslamadigini kontrol eden methud:
    //********************************************************************************************

    // allMarch() belirtilen sartlari tum elemanlar saglamiyorsa true, sagliyorsa false
    public static boolean baslamayanHarfVarMi(List<String> liste, String harf) {
        return liste.stream()
                .noneMatch(t -> t.startsWith(harf));
    }

    //********************************************************************************************
    // ORNEK22: Listedeki herhangi bir eleman belirtilen bir harf ile bitiyor mu diye kontrol eden methud:
    //********************************************************************************************

    public static boolean herhangiBitenVarMi(List<String> liste, String harf) {
        return liste.stream()
                .anyMatch(t -> t.endsWith(harf));
    }

    //********************************************************************************************
    // ORNEK23: A ile baslayip O ile biten elemanlari yazdiran methud:
    //********************************************************************************************

    public static void aileOYazdir(List<String> liste, String harf1, String harf2) {
        liste.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith(harf1.toLowerCase()) && x.endsWith(harf2.toLowerCase()))
                .forEach(Methodlar::StrYazdir);
    }

    //********************************************************************************************
    // ORNEK24: Asagidaki formata gore listedeki her bir elemanin uzunlugunu yazdiran method:
    //********************************************************************************************

    public static void listeleYazdir(List<String> liste) {
        liste.stream()
                .sorted(Comparator.comparing(String::length))
                .map(t -> t + " : " + t.length() + "\t")
                .forEach(Methodlar::StrYazdir);
    }


}
