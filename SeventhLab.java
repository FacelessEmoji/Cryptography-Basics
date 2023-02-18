import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class SeventhLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует user-friendly консоль.\n" +
                "Вводите слова \"Шифруем\" или \"Дешифруем\" и следуйте дальнейшим указаниям.\n" +
                "Для остановки программы введите \"Стоп\".");
        String message = scanner.nextLine();
        String saver = "";
        while (!message.equalsIgnoreCase("Стоп")) {
            if (message.equalsIgnoreCase("Шифруем")) {
                System.out.println("Введите любую последовательность символов для задания ключа:");
                String key_word = scanner.nextLine();
                System.out.println("Введите то, что хотите зашифровать:");
                String unencrypted_message = scanner.nextLine();
                int iterator = 0;
                String encryptedLetter;
                String encryptedText = "";
                int nestedLoopLength;
                for (int i = 0; i < unencrypted_message.length(); i++) {
                    String longer;
                    String shorter;
                    nestedLoopLength = Math.max(Integer.toBinaryString(unencrypted_message.charAt(i)).length(),
                            Integer.toBinaryString(key_word.charAt(iterator)).length());
                    encryptedLetter = "";
                    String unencryptedLetter = Integer.toBinaryString(unencrypted_message.charAt(i));//правильно,нахождение двоички буквы unencrypted_message
                    String keyLetter = Integer.toBinaryString(key_word.charAt(iterator));
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
                    System.out.print(encryptedLetter + " ");
                    if((i + 1)%30==0){
                        System.out.println();
                    }
                    encryptedText += (char) Integer.parseInt(encryptedLetter, 2);
                }

                saver = encryptedText;
                System.out.println(encryptedText);
            } else if (message.equalsIgnoreCase("Дешифруем")) {
                System.out.println("Введите ваш ключ:");
                String key_word = scanner.nextLine();
                String encrypted_message = saver;
                int iterator = 0;
                String unencryptedLetter;
                String unencryptedText = "";
                int nestedLoopLength;
                for (int i = 0; i < encrypted_message.length(); i++) {
                    String longer;
                    String shorter;
                    nestedLoopLength = Math.max(Integer.toBinaryString(encrypted_message.charAt(i)).length(),
                            Integer.toBinaryString(key_word.charAt(iterator)).length());
                    unencryptedLetter = "";
                    String encryptedLetter = Integer.toBinaryString(encrypted_message.charAt(i));
                    String keyLetter = Integer.toBinaryString(key_word.charAt(iterator));
                    int lengthDifference = Math.abs(encryptedLetter.length() - keyLetter.length());
                    if (encryptedLetter.length() < keyLetter.length()) {
                        shorter = StringUtils.repeat("0", lengthDifference) + encryptedLetter;
                        longer = keyLetter;
                    } else if (encryptedLetter.length() > keyLetter.length()) {
                        shorter = StringUtils.repeat("0", lengthDifference) + keyLetter;
                        longer = encryptedLetter;
                    } else {
                        nestedLoopLength = keyLetter.length();
                        shorter = keyLetter;
                        longer = encryptedLetter;
                    }
                    for (int j = 0; j < nestedLoopLength; j++) {
                        unencryptedLetter += String.valueOf(Integer.parseInt(String.valueOf(longer.charAt(j)))
                                ^ Integer.parseInt(String.valueOf(shorter.charAt(j))));
                    }
                    if (iterator == key_word.length() - 1) {
                        iterator = 0;
                    } else {
                        iterator++;
                    }
                    unencryptedText += (char) Integer.parseInt(unencryptedLetter, 2);
                }
                System.out.println(unencryptedText);
            }
            message = scanner.nextLine();
        }
    }
}
