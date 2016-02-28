package moviexml2;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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

        try
        {
            Socket socket = new Socket("127.0.0.1", 1234);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            outputStream.writeObject(Command.PUT);
            outputStream.write(0); /*a szerver while feltetelehez szukseges minden objektum elott egy 0-t atkuldeni.*/
            outputStream.writeObject(movie1);
            outputStream.write(0);
            outputStream.writeObject(person1);

            outputStream.writeObject(Command.GET);
            List<Object> fajlObjektumok = (List) inputStream.readObject();
            for(Object i: fajlObjektumok)
            {
                System.out.println(i);
            }


            outputStream.writeObject(Command.EXIT);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
