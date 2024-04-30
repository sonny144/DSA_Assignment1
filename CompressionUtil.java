public class CompressionUtil {

    // Compresses a string using RLE and prints the size comparison
    public static byte[] compress(String text) {
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int count = 1;
            while (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                count++;
                i++;
            }
            compressed.append(text.charAt(i));
            compressed.append(count);
        }
        byte[] compressedBytes = compressed.toString().getBytes();
        System.out.println("Original size: " + text.length() + " characters");
        System.out.println("Compressed size: " + compressedBytes.length + " bytes");
        return compressedBytes;
    }

    // Decompresses a string using RLE
    public static String decompress(byte[] compressedBytes) {
        String compressedString = new String(compressedBytes);
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < compressedString.length(); i += 2) {
            char character = compressedString.charAt(i);
            int count = Character.getNumericValue(compressedString.charAt(i + 1));
            while (count-- > 0) {
                decompressed.append(character);
            }
        }
        return decompressed.toString();
    }
}
