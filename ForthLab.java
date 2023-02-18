import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ForthLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
                "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        int keyAlphabetNumber;
        System.out.println("Вас приветствует user-friendly консоль.\n" +
                "Вводите слова \"Шифруем\" или \"Дешифруем\" и следуйте дальнейшим указаниям.\n" +
                "Для остановки программы введите \"Стоп\".");
        String message = scanner.nextLine();
        while (!message.equalsIgnoreCase("Стоп")) {
            if (message.equalsIgnoreCase("Шифруем")) {
                System.out.println("Введите последовательность неповторяющихся букв, чтобы задать уникальный ключ шифрования:");
                String[] key = scanner.nextLine().toLowerCase().replaceAll(" ", "").split("");
                String[][] keyAlphabets = new String[key.length][alphabet.length];
                for (int i = 0; i < key.length; i++) {
                    int start = Arrays.asList(alphabet).indexOf(key[i]);
                    for (int j = 0; j < alphabet.length; j++) {
                        if (start < alphabet.length - 1){
                            keyAlphabets[i][j] = alphabet[start];
                            start++;
                        }else if(start == alphabet.length - 1){
                            keyAlphabets[i][j] = alphabet[start];
                            start = 0;
                        }
                    }
                }
                for (int i = 0; i < keyAlphabets.length; i++) {
                    Arrays.stream(keyAlphabets[i]).forEach(s -> System.out.print(s + " "));
                    System.out.println();
                }
                System.out.println("Введите то, что хотите зашифровать:");
                String[] unencrypted_message = scanner.nextLine().split("");
                String[] encrypted_message = new String[unencrypted_message.length];
                keyAlphabetNumber = 0;
                for (int i = 0; i < unencrypted_message.length; i++) { //проход по слову
                    for (int k = 0; k < keyAlphabets[keyAlphabetNumber].length; k++) { //буква номер k
                        if (unencrypted_message[i].toLowerCase().equals(alphabet[k])) { // простое совпадение буквы с шифром без регистра
                            if (unencrypted_message[i].equals(unencrypted_message[i].toUpperCase())) { //
                                encrypted_message[i] = keyAlphabets[keyAlphabetNumber][k].toUpperCase();
                            } else {
                                encrypted_message[i] = keyAlphabets[keyAlphabetNumber][k];
                            }
                            if (keyAlphabetNumber == keyAlphabets.length - 1) {
                                keyAlphabetNumber = 0;
                            } else {
                                keyAlphabetNumber++;
                            }
                            break;
                        }
                        if (k == alphabet.length - 1) {
                            encrypted_message[i] = unencrypted_message[i];
                        }
                    }
                }
                System.out.println(Arrays.stream(encrypted_message).collect(Collectors.joining()));
            } else if (message.equalsIgnoreCase("Дешифруем")) {
                System.out.println("Введите ваш уникальный ключ шифрования:");
                String[] key = scanner.nextLine().toLowerCase().replaceAll(" ", "").split("");
                String[][] keyAlphabets = new String[key.length][alphabet.length];
                for (int i = 0; i < key.length; i++) {
                    int start = Arrays.asList(alphabet).indexOf(key[i]);
                    for (int j = 0; j < alphabet.length; j++) {
                        if (start < alphabet.length - 1){
                            keyAlphabets[i][j] = alphabet[start];
                            start++;
                        }else if(start == alphabet.length - 1){
                            keyAlphabets[i][j] = alphabet[start];
                            start = 0;
                        }
                    }
                }
                System.out.println("Введите то, что хотите расшифровать:");
                String[] encrypted_message = scanner.nextLine().split("");
                String[] unencrypted_message = new String[encrypted_message.length];
                keyAlphabetNumber = 0;
                // возможно вначале вставить проверку на outofbounds | скорее обнулить надо
                for (int i = 0; i < encrypted_message.length; i++) {
                    for (int k = 0; k < keyAlphabets[keyAlphabetNumber].length; k++) {
                        if (encrypted_message[i].toLowerCase().equals(keyAlphabets[keyAlphabetNumber][k])) {
                            if (encrypted_message[i].equals(encrypted_message[i].toUpperCase())) {
                                unencrypted_message[i] = alphabet[k].toUpperCase();
                            } else {
                                unencrypted_message[i] = alphabet[k];
                            }
                            if (keyAlphabetNumber == keyAlphabets.length - 1) {
                                keyAlphabetNumber = 0;
                            } else {
                                keyAlphabetNumber++;
                            }
                            break;
                        }
                        if (k == alphabet.length - 1) {
                            unencrypted_message[i] = encrypted_message[i];
                        }
                    }
                }
                System.out.println(Arrays.stream(unencrypted_message).collect(Collectors.joining()));
            }
            message = scanner.nextLine();
        }
    }
}
