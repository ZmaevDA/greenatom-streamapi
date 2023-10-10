# StreamAPI
## Задание
- Есть следующий код:
 
public class Developer {
	private String name;
	private List<String> languages;
	//плюс геттеры и сеттеры
}
 
Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);
 
Задача - найти разработчиков с уникальными языками программирования, используя Stream API.
Для данного примера ожидаемый результат [Наташа, Элла].

