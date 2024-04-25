import java.util.ArrayList;
import java.util.List;

public class Star {
    private List<ClientNode> clientNodes;

    public Star() {
        clientNodes = new ArrayList<>();
    }

    // Method to insert a client node into the star network
    public void insertNode(ClientNode node) {
        clientNodes.add(node);
    }

    // Method to delete a client node from the star network
    public void deleteNode(ClientNode node) {
        clientNodes.remove(node);
    }

    // Method to display all client nodes in the star network
    public void displayClientNodes() {
        for (ClientNode node : clientNodes) {
            System.out.println("Client Node ID: " + node.getID());
        }
    }
}
