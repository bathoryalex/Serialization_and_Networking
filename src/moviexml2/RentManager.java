package moviexml2;

import java.util.Arrays;
import java.util.List;

public class RentManager
{
    public static void main(String[] args)
    {
        Person person1 = new Person("Alex", "Bathory", Gender.MALE, 1000);
        Person person2 = new Person("David", "Levai", Gender.MALE, 999);
        Person person3 = new Person("Orsi", "Biro", Gender.FEMALE, 879);
        Person person4 = new Person("Andras", "Kesik", Gender.MALE, 65498);
        Person person5 = new Person("Sunny", "Diamond", Gender.FEMALE, 999999);

        Movie movie1 = new Movie("The Mummy", Genre.HORROR, 180, 7.2, 10, person1);
        Movie movie2 = new Movie("Aladdin", Genre.COMEDY, 120, 8.9, 12, person2);

        Game game1 = new Game("Call of Duty II", person3, true, 120);
        Game game2 = new Game("Super Mario", person4, false, 70);

        Book book1 = new Book("Harry Potter and the Chamber of Secrets", person5, person1);

        List<Buyable> lista = Arrays.asList(movie1, movie2, game1, game2);

        System.out.println(sumPrices(lista));

    }
    public static long sumPrices(List<Buyable> lista)
    {
        long osszeg = 0;
        for (Buyable i : lista)
        {
            osszeg += i.getPrice();
        }
        return osszeg;
    }
}
