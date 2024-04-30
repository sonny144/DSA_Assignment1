public class Main {
    public static void main(String[] args) {
        ServerNode server = new ServerNode(); //creates instance of server node class. It represents the server node in the network
        
        ClientNode client1 = new ClientNode("Client1"); //creates instance of client nodes with their own unique identifier
        ClientNode client2 = new ClientNode("Client2");
        ClientNode client3 = new ClientNode("Client3");
        ClientNode client4 = new ClientNode("Client4");
        ClientNode client5 = new ClientNode("Client5");

        Star starNetwork = new Star(); //creates instance of Star class
        starNetwork.insertNode(client1); //calls the insert method to add clients
        starNetwork.insertNode(client2);
        starNetwork.insertNode(client3);
        starNetwork.insertNode(client4);
        starNetwork.insertNode(client5);

        // Sending of messages between clients
        client1.send("Hello from Client1", server,client3); //sends message from client1 to client3
        client2.send("Hi from Client2", server,client1);// sends message from client2 to client1
        client3.send("Greetings from Client3", server,client2); //sends message from client3 to client2
        client4.send("Greetings from Client4, how is everyone?", server,client5); //sends message from client4 to client5


        System.out.println("\nBefore deletion:");  //displays state before deletion occurs
        starNetwork.displayClientNodes();
        
        // Diplays state after any deletion that might occur
        //starNetwork.deleteNode(client1);
        System.out.println("\nAfter deletion:");
        starNetwork.displayClientNodes();
    }
}
