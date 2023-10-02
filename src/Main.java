import entity.Developer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "TypeScript"));
        Developer dev4 = new Developer("Альберт", Arrays.asList("Java", "JavaScript"));
        Developer dev5 = new Developer("Джонни", Arrays.asList("С#", "Python"));
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3, dev4, dev5);
        List<Developer> uniqueDevs = developerStream
                .flatMap(dev -> dev.getLanguages().stream().map(lang -> new AbstractMap.SimpleEntry<>(lang, dev)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .values().stream()
                .filter(devs -> devs.size() == 1)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        uniqueDevs.forEach(dev -> System.out.println(dev.getName()));
    }
}