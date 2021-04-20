package streamOrnekler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class Stream06File {

    public static void main(String[] args) throws IOException {

        String path = "src/streamOrnekler/mars.txt";

        Stream<String> satirlar = Files.lines(Path.of("src/streamOrnekler/mars.txt"));

        satirlar.forEach(System.out::println);

        System.out.println("=============================");

        Files.lines(Path.of(path))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("=============================");

        Files.lines(Path.of(path))
                .skip(2)
                .limit(2)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("=============================");

        System.out.println(Files.lines(Path.of(path))
                .map(String::toLowerCase)
                .filter(t -> t.contains("o"))
                .count());

        System.out.println("=============================");

        Files.lines(Path.of(path))
                .map(t -> t.toLowerCase().split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        System.out.println("=============================");

        System.out.println("M harfini iceren kelime sayisi: " + Files.lines(Path.of(path))
                .map(t -> t.toLowerCase().split(""))
                .flatMap(Arrays::stream)
                .filter(t -> t.equalsIgnoreCase("m"))
                .count());

        System.out.println("=============================");

        System.out.println(Files.lines(Path.of(path))
                .map(t -> t.replace("_", "")
                        .replaceAll("\\W", "")
                        .split(""))
                .flatMap(Arrays::stream)
                .count());

    }

}
