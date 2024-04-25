import java.util.ArrayList;
import java.util.List;

public class ServerNode {
    private List<ClientNode> clients;

    public ServerNode() {
        this.clients = new ArrayList<>();
    }

    public void registerClient(ClientNode client) {
        this.clients.add(client);
    }

    public void sendMessage(String message, ClientNode sender) {
        for (ClientNode client : clients) {
            if (client != sender) {
                client.receive(message, sender.getClientName());
            }
        }
    }
}
