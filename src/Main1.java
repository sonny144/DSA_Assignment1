public class Main {
    public static void main(String[] args) {
        ServerNode server = new ServerNode();

        ClientNode client1 = new ClientNode(1);
        ClientNode client2 = new ClientNode(2);
        ClientNode client3 = new ClientNode(3);

        server.addClient(client1);
        server.addClient(client2);
        server.addClient(client3);

        client1.sendMessage(server, "Hello from Client 1!");
        client2.sendMessage(server, "Greetings from Client 2!");
    }
}
