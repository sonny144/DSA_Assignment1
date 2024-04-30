public class Main {
    public static void main(String[] args) {
        ServerNode server = new ServerNode();
        
        ClientNode client1 = new ClientNode("Client1");
        ClientNode client2 = new ClientNode("Client2");
        ClientNode client3 = new ClientNode("Client3");
        ClientNode client4 = new ClientNode("Client4");
        ClientNode client5 = new ClientNode("Client5");

        Star starNetwork = new Star();
        starNetwork.insertNode(client1);
        starNetwork.insertNode(client2);
        starNetwork.insertNode(client3);
        starNetwork.insertNode(client4);
        starNetwork.insertNode(client5);

        // Send messages between client nodes
        client1.send("Hello from Client1", server,client3);
        client2.send("Hi from Client2", server,client1);
        client3.send("Greetings from Client3", server,client2);
        client4.send("Greetings from Client4, how is everyone?", server,client5);


        // Display client nodes before deletion
        System.out.println("\nBefore deletion:");
        starNetwork.displayClientNodes();
        
        // Delete a client node and show the state after deletion
        //starNetwork.deleteNode(client1);
        System.out.println("\nAfter deletion:");
        starNetwork.displayClientNodes();
    }
}
