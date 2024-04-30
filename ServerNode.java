import java.util.ArrayList;
import java.util.List;

public class ServerNode {
    private List<ClientNode> clients;

    public ServerNode() {
        clients = new ArrayList<>();
    }

    /**
     * Adds a client to the server.
     *
     * @param client The client node to be added.
     */
    public void addClient(ClientNode client) {
        clients.add(client);
    }

    /**
     * Removes a client from the server.
     *
     * @param client The client node to be removed.
     */
    public void removeClient(ClientNode client) {
        clients.remove(client);
    }

    /**
     * Brokers a message sent by a client, compressing and forwarding to other clients.
     *
     * @param message The message to be sent.
     * @param sender  The client sending the message.
     */
    public void brokerMessage(String message, ClientNode sender) {
        // Handle short messages (less than 3 characters)
        if (message.length() < 3) {
            System.out.println("[" + sender.getID() + "] sent: " + message);
            forwardUncompressed(message, sender); // Forward without compression
            return;
        }

        // Compress the message using a simpler approach (LZ77-like)
        String compressedMessage = compressSimple(message);
        System.out.println("[" + sender.getID() + "] sent: " + compressedMessage);

        // Forward the compressed message to all other clients except the sender
        for (ClientNode client : clients) {
            if (client != sender) {
                decompressRLEStreaming(compressedMessage, sender.getID(), client); // Use streaming decompression
            }
        }
    }

    // Handle forwarding messages without compression
    private void forwardUncompressed(String message, ClientNode sender) {
        for (ClientNode client : clients) {
            if (client != sender) {
                client.send(message); // Forward the original message
            }
        }
    }

    // Implement a simpler compression logic (LZ77-like) with short message handling
    private String compressSimple(String message) {
        StringBuilder compressed = new StringBuilder();
        int matchLength = 3; // Adjust match length based on needs
        int i = 0;
        while (i < message.length()) {
            // Ensure we have enough characters for potential reference (avoid out-of-bounds)
            if (i + matchLength >= message.length()) {
                compressed.append(message.substring(i)); // Add remaining characters uncompressed
                break;
            }
            int matchStart = i - matchLength;
            if (matchStart >= 0 && message.substring(i, i + matchLength).equals(message.substring(matchStart, matchStart + matchLength))) {
                int offset = i - matchStart;
                compressed.append("(").append(offset).append(",").append(matchLength).append(")");
                i += matchLength;
            } else {
                compressed.append(message.charAt(i));
                i++;
            }
        }
        return compressed.toString();
    }

    // Implement streaming decompression with targeted message handling
    private void decompressRLEStreaming(String compressedMessage, String senderID, ClientNode receiver) {
        int offset = 0;
        int matchLength = 0;
        boolean isSenderInfo = true;

        for (int i = 0; i < compressedMessage.length(); i++) {
            if (compressedMessage.charAt(i) == '(') {
                StringBuilder offsetBuilder = new StringBuilder();
                StringBuilder lengthBuilder = new StringBuilder();
                char c = compressedMessage.charAt(++i);
                while (Character.isDigit(c)) {
                    offsetBuilder.append(c);
                    c = compressedMessage.charAt(++i);
                }
                offset = Integer.parseInt(offsetBuilder.toString());
                if (c == ',') {
                    c = compressedMessage.charAt(++i);
                    while (Character.isDigit(c)) {
                        lengthBuilder.append(c);
                        c = compressedMessage.charAt(++i);
                    }
                    matchLength = Integer.parseInt(lengthBuilder.toString());
                }
                i--; // Go back one character to process
            }
        }
    }
}
