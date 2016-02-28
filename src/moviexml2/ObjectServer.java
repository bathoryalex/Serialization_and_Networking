package moviexml2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ObjectServer
{
    static ServerMode szervermod;

    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started!");

        Socket clientSocket = serverSocket.accept();
        System.out.println("New client connected!");

        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());

        while (true)
        {
            Object objektum = inputStream.readObject();
            if (objektum instanceof Command)
            {
                Command parancs = (Command) objektum;
                if (parancs.equals(Command.GET))
                {
                    szervermod = ServerMode.LOAD;
                    List<Object> beolvasottLista = new ArrayList<>();
                    System.out.println("Server changed to load mode!");

                    FileInputStream fileInput = new FileInputStream("D:\\CodeCool\\Serialization_and_Networking\\fileOutputStream.ser");
                    ObjectInputStream fileInputStream = new ObjectInputStream(fileInput);

                    try
                    {
                        while (true)
                        {
                            beolvasottLista.add(fileInputStream.readObject());
                        }
                    }
                    catch (EOFException e)
                    {
                        System.out.println("File reading completed!");
                    }
                    outputStream.writeObject(beolvasottLista);
                }
                if (parancs.equals(Command.PUT))
                {
                    szervermod = ServerMode.SAVE;
                    System.out.println("Server changed to save mode!");

                    FileOutputStream fileOutputStream = new FileOutputStream("D:\\CodeCool\\Serialization_and_Networking\\fileOutputStream.ser");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);


                    while (inputStream.read() == 0)
                    {
                        save(inputStream.readObject(), objectOutputStream);
                    }


                }
                if (parancs.equals(Command.EXIT))
                {
                    System.out.println("Bye!");
                    break;
                }
            }
        }
        clientSocket.close();
//        outputStream.close();
//        inputStream.close();


    }
    public Object load()
    {
        return null;
    }

    public static void save(Object obj, ObjectOutputStream outpStream)
    {
        try
        {
            outpStream.writeObject(obj);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


}
