public class ProductCipher {
    public static void main(String[] args) {
        String inputText = "abc";
        int unit = 5;
//        System.out.println("Input Text: " + inputText);
//        String encryptedText = substitutionCipherEncrypt(inputText,unit);
//        System.out.println("Encrypted: " + encryptedText);
//        String decryptedText = substitutionCipherDecrypt(encryptedText,unit);
//        System.out.println("Decrypted: " + decryptedText);
        String ip = transpositionCipherEncrypt(inputText,5);
        System.out.println(ip);
        System.out.println(transpositionCipherDecrypt(ip,5));

    }

    public static String substitutionCipherEncrypt(String message,int unit){
        String encryptedMessage = "";
        for(int i=0;i<message.length();i++){
            int charCode = (int)message.charAt(i);
            encryptedMessage += (char)(charCode+5);
        }
        return encryptedMessage;
    }

    public static String substitutionCipherDecrypt(String message,int unit){
        String decryptedMessage = "";
        for(int i=0;i<message.length();i++){
            int charCode = (int)message.charAt(i);
            decryptedMessage += (char)(charCode-5);
        }
        return decryptedMessage;
    }

    public static String transpositionCipherEncrypt(String message,int unit) {
        int modulus = message.length() % unit;
        if (modulus != 0) {
            modulus = unit - modulus; // Modulus = Number of the blanks / padding (X) to be appended
            for (; modulus != 0; modulus--) {
                message += "/";
            }
        }
        String transpositionOutput = new String();
        System.out.println("Transposition matrix of String: ");
        for (int i = 0; i < unit; i++) {
            for (int j = 0; j < message.length()/unit; j++) {
                char c = message.charAt(i+(j*unit));
//                System.out.println(c);
                transpositionOutput += c;
            }
//            System.out.println();
        }
        return transpositionOutput;
    }
    public static String transpositionCipherDecrypt(String message,int unit) {
        String transpositionOutput = new String();
        System.out.println("Transposition matrix of String: ");
        for (int i = 0; i < unit; i++) {
            for (int j = 0; j < message.length()/unit; j++) {
                char c = message.charAt(i+(j*unit));
//                System.out.println(c);
                transpositionOutput += c;
            }
//            System.out.println();
        }
        return transpositionOutput;
    }


}
