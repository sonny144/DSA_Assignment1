public class Main {

  public static void main(String[] args) {
    ServerNode server = new ServerNode();

    ClientNode client1 = new ClientNode("Client1");
    ClientNode client2 = new ClientNode("Client2");
    ClientNode client3 = new ClientNode("Client3");
    ClientNode client4 = new ClientNode("Client4");

    // No need for Star class, directly manage clients

    client1.send("Hello from Client1", server);
    client2.send("Hi from Client2", server);
    client3.send("Greetings from Client3", server);
    client4.send("Greetings from Client4, how is everyone?", server);

    // Add displayMessages method to ClientNode to show received messages
    client1.displayMessages();
    client2.displayMessages();
    client3.displayMessages();
    client4.displayMessages();

    System.out.println("\nBefore deletion:");
    System.out.println("Client 1: " + client1.getClientName());
    System.out.println("Client 2: " + client2.getClientName());
    System.out.println("Client 3: " + client3.getClientName());
    System.out.println("Client 4: " + client4.getClientName());

    System.out.println("\nAfter deletion:");
    server.unregisterClient(client3); // Use server to unregister client
    System.out.println("Client 1: " + client1.getClientName());
    System.out.println("Client 2: " + client2.getClientName());

    
    // Client3 is unregistered, so it won't be displayed
    System.out.println("Client 4: " + client4.getClientName());
  }
}
