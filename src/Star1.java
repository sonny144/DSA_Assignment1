public class Star {
    private ServerNode server;

    public Star(ServerNode server) {
        this.server = server;
    }

    public void insertNode(ClientNode client) {
        server.addClient(client);
    }

    public void deleteNode(ClientNode client) {
        server.removeClient(client);
    }
}
