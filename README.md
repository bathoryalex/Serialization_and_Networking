# Serialization_and_Networking

In this task I had to upgrade my Product and Buyable handler application, using serialization and networking.

I had to create a new class, called ObjectServer, but I had to be able to run this class as a separated application, so it has to have a main method. This class should be able to send and receive objects over TCP, working as a server.

The RentManager and the ObjectServer should communicate with each other using sockets (they should run in separated JVMs).
ObjectServer should be able to save given data to a file and load data from file, depends on its mode property, so it should be declared in this class.
I should modify my Person class and every product class, because they are needed to be able to read/write with ObjectInputStream/ObjectOutputStream.

![alt tag](http://lms.codecool.com/File/DownloadPicture-1931d51785d2e511a08500151788bf01/Medium?downloadName=objectserver.png)
