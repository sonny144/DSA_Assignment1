import java.util.ArrayList;
import java.util.List;

public class Star {
    private List<ClientNode> clientNodes;
    private ServerNode serverNode;
    
    public Star() {
        clientNodes = new ArrayList<>();
        serverNode = new ServerNode();
    }
    
    // Method to insert a node to the model
    public void insertNode(ClientNode node) {
        clientNodes.add(node);
    }
    
    // Method to delete a node from the model
    public void deleteNode(ClientNode node) {
        clientNodes.remove(node);
    }
    
    // Method to display all client nodes in the network
    public void displayClientNodes() {
        System.out.println("Client Nodes:");
        for (ClientNode node : clientNodes) {
            System.out.println(node.getID());
        }
    }
}
