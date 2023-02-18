package Other;

import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class Experiment7 {
    public static String makeEncryption(String unencrypted_message){
        Scanner scanner = new Scanner(System.in);
        String key_word = scanner.nextLine();
        int iterator = 0;
        String encryptedText = "";
        for (int i = 0; i < unencrypted_message.length(); i++) {
            String longer;
            String shorter;
            String encryptedLetter = "";
            String unencryptedLetter = Integer.toBinaryString(unencrypted_message.charAt(i));
            String keyLetter = Integer.toBinaryString(key_word.charAt(iterator));
            int nestedLoopLength = Math.max(Integer.toBinaryString(unencrypted_message.charAt(i)).length(),
                    Integer.toBinaryString(key_word.charAt(iterator)).length());
            int lengthDifference = Math.abs(unencryptedLetter.length() - keyLetter.length());

            if (unencryptedLetter.length() < keyLetter.length()) {
                shorter = StringUtils.repeat("0", lengthDifference) + unencryptedLetter;
                longer = keyLetter;
            } else if (unencryptedLetter.length() > keyLetter.length()) {
                shorter = StringUtils.repeat("0", lengthDifference) + keyLetter;
                longer = unencryptedLetter;
            } else {
                nestedLoopLength = keyLetter.length();
                shorter = keyLetter;
                longer = unencryptedLetter;
            }

            for (int j = 0; j < nestedLoopLength; j++) {
                encryptedLetter += String.valueOf(Integer.parseInt(String.valueOf(longer.charAt(j))) ^
                        Integer.parseInt(String.valueOf(shorter.charAt(j))));
            }

            if (iterator == key_word.length() - 1) {
                iterator = 0;
            } else {
                iterator++;
            }

            encryptedText += (char) Integer.parseInt(encryptedLetter, 2);
        }
        return encryptedText;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String encrypted_message = "";
        while (!message.equalsIgnoreCase("Стоп")){
            if (message.equalsIgnoreCase("Шифруем")){
                System.out.println(makeEncryption(scanner.nextLine()));
            }else if (message.equalsIgnoreCase("Дешифруем")){
                System.out.println(makeEncryption(encrypted_message));
                encrypted_message = "";
            }
            message = scanner.nextLine();
        }
    }
}
