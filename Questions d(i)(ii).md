d(i)
We chose to use Run-Length Encoding (RLE) for its efficiency in situations where the data involves repeated sequences as the compression method is  beneficial in network environments where similar 
messages or data patterns are frequently transmitted between nodes. For example a status messages like "OK" or "ALIVE" are repetitively sent, RLE can  reduce the bandwidth consumption by compressing
these repeated sequences efficiently.

The Advantages are:

 RLE is not only easy to use but also operates with little computational overhead. This is an advantage for the server node that might need to handle large volumes of messages at the same time. 
The easiness of RLE ensures that the server can quickly compress and decompress messages without requiring important processing resources, which is crucial for maintaining fast response times
across the network.

 Given that the server node must process messages in real-time, RLE's linear time complexity is another advantage. It ensures that messages are compressed and decompressed swiftly, making  easier
 efficient data handling without introducing hold-ups.

Examples:
For Compression: If a client node sends a diagnostic message like "ERROR ERROR ERROR ERROR", RLE would compress this message to "ERROR4". 
This compressed message is then sent to the server, which brokers it to other nodes if necessary.
For Decompression: Upon receiving a compressed message like "ERROR4", either the server or anotherclient node will decompress it back to
"ERROR ERROR ERROR ERROR" to process or display the message accurately.

d(ii)

The Compression process is when a client node sends a message, it first compresses the message using RLE before it is transfered to the server node.

The Worst-case scenario is that every character in the message is different, so RLE would effectively write each character followed by the number '1'. However, the algorithm still scans each character exactly once.

The Time Complexity for Compression 𝑂(𝑛), where n is the number of characters in the original message.

The Decompression Process, server node, upon receiving a compressed message, may decompress it before relaying it to the intended recipient(s) or for other processing tasks.

The Worst-case scenario would show that The decompressed message size will be determined by the counts specified in the compressed message. If each character in the original
message was different, decompression involves expanding each character according to its count (in this worst-case, the count would simply be '1' for all).

The time Complexity for Decompression  O(m), where 𝑚  is the number of characters in the decompressed message. 

The Calculation of the Overall Time Complexity,since RLE processes each input character exactly once during both compression and decompression, the time complexity of handling
a message in this client-server scenario is linear relative to the size of the messages involved.

Worst-case Scenario Detail:
Compresion part: The compression algorithm traverses the input string once, resulting in a time complexity of 
𝑂(𝑛)

Decompression Part: Similarly, decompression involves reading the compressed format and reconstructing the original message based on counts, also resulting in a time complexity of 𝑂(𝑚)
