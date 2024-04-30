public class Main {
    public static void main(String[] args) {
        ServerNode server = new ServerNode(); //creates instance of ServerNode class
        
        ClientNode client1 = new ClientNode("Client1"); //create instance of ClientNode with each client having its own unique ID
        ClientNode client2 = new ClientNode("Client2");
        ClientNode client3 = new ClientNode("Client3");
        ClientNode client4 = new ClientNode("Client4");

        Star starNetwork = new Star(); //creates instance of Star class to represent the star topology
        starNetwork.insertNode(client1); //we use the insertNode method to add clients to the star topology
        starNetwork.insertNode(client2);
        starNetwork.insertNode(client3);
        starNetwork.insertNode(client4);

        // Messages are sent from each client to the servernode using the send method from the ClientNode class
        client1.send("Hello from Client1", server);
        client2.send("Hi from Client2", server);
        client3.send("Greetings from Client3", server);
        client4.send("Greetings from Client4, how is everyone?", server);

        // Messages from the client nodes are displayed using the .displayMessages method
        client1.displayMessages();
        client2.displayMessages();
        client3.displayMessages();
        client4.displayMessages();

        // We use this to display the current nodes that exist before deletion
        System.out.println("\nBefore deletion:");
        starNetwork.displayClientNodes();
        
        // After deleting a specific node we then also print out the current nodes that exist after deletion
        starNetwork.deleteNode(client3);
        System.out.println("\nAfter deletion:");
        starNetwork.displayClientNodes();
    }
}
