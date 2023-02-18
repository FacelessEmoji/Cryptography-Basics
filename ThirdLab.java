import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThirdLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
                "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};

        String[][] firstKeySet = {
                {"ю", "я", "х", "с", "е", "д", "а", "э", "й", "п", "т", "ч", "з", "р", "г", "ъ",
                        "о", "н", "к", "ь", "ё", "ц", "ф", "б", "щ", "ы", "ш", "у", "ж", "и", "в", "м", "л"},
                {"а", "д", "п", "к", "ъ", "ч", "ш", "м", "р", "о", "б", "ы", "з", "г", "ё", "ф",
                        "т", "ж", "ц", "ь", "х", "е", "ю", "л", "с", "в", "я", "й", "и", "щ", "у", "э", "н"},
                {"н", "з", "в", "с", "щ", "ч", "ь", "у", "ы", "л", "ю", "ф", "ц", "а", "ж", "ъ",
                        "й", "о", "р", "е", "я", "х", "э", "и", "д", "т", "г", "м", "к", "ш", "п", "ё", "б"}
        };
        String[][] secondKeySet = {
                {"в", "э", "ъ", "ю", "с", "р", "я", "е", "м", "й", "к", "п", "ж", "ь", "у", "н",
                        "х", "ч", "л", "з", "и", "ш", "щ", "т", "д", "ф", "г", "ё", "б", "а", "о", "ц", "ы"},
                {"у", "м", "б", "в", "э", "ж", "н", "ь", "с", "к", "о", "й", "е", "ё", "я", "и",
                        "ю", "ф", "ч", "ш", "д", "х", "ц", "ы", "а", "п", "р", "т", "ъ", "г", "щ", "л", "з"},
                {"б", "о", "е", "й", "щ", "з", "п", "ы", "ш", "т", "м", "а", "ё", "с", "ч", "д",
                        "я", "ъ", "к", "ь", "г", "х", "и", "р", "у", "л", "в", "ц", "ю", "ж", "э", "ф", "н"}
        };
        String[][] thirdKeySet = {
                {"я", "г", "д", "е", "ь", "т", "с", "и", "м", "а", "з", "в", "щ", "ч", "ъ", "ы",
                        "л", "ё", "к", "ц", "й", "э", "х", "о", "ж", "р", "б", "ш", "ю", "у", "п", "ф", "н"},
                {"ь", "ы", "ч", "л", "ж", "й", "ц", "г", "д", "ъ", "т", "з", "с", "ё", "и", "ф",
                        "ю", "п", "р", "ш", "я", "у", "в", "щ", "н", "е", "о", "к", "м", "б", "х", "э", "а"},
                {"г", "у", "ю", "д", "х", "з", "я", "ч", "л", "к", "ц", "и", "ё", "р", "о", "ь",
                        "ъ", "ы", "щ", "н", "м", "с", "в", "а", "й", "ш", "б", "е", "ж", "п", "ф", "т", "э"}
        };
        String[][] keyAlphabet = new String[3][alphabet.length];
        String message = scanner.nextLine();
        while (!message.equalsIgnoreCase("Стоп")) {
            if (message.equalsIgnoreCase("Шифруем")) {
                String[] unencrypted_message = scanner.nextLine().split("");
                String[] encrypted_message = new String[unencrypted_message.length];
                System.out.println("Введите последовательность чисел от 1 до 3 без пробелов, чтобы задать уникальный ключ шифрования:");
                int[] key = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                int numberInKey = -1;
                int keyAlphabetNumber = 0;
                int changeKeyAlphabet = 2;
                for (int i = 0; i < unencrypted_message.length; i++) {//проход по слову
                    if (Arrays.asList(alphabet).contains(unencrypted_message[i].toLowerCase())) {
                        changeKeyAlphabet++;
                    }
                    if (changeKeyAlphabet % 3 == 0) {
                        numberInKey++;
                        keyAlphabet = new String[3][alphabet.length];
                        switch (key[numberInKey]) {
                            case 1 -> keyAlphabet = firstKeySet;
                            case 2 -> keyAlphabet = secondKeySet;
                            case 3 -> keyAlphabet = thirdKeySet;
                        }
                        if (numberInKey == key.length - 1) {
                            numberInKey = 0;
                        }
                    }
                    for (int k = 0; k < keyAlphabet[keyAlphabetNumber].length; k++) { //буква номер k
                        if (unencrypted_message[i].toLowerCase().equals(alphabet[k])) { // простое совпадение буквы с шифром без регистра
                            if (unencrypted_message[i].equals(unencrypted_message[i].toUpperCase())) { //
                                encrypted_message[i] = keyAlphabet[keyAlphabetNumber][k].toUpperCase();
                            } else {
                                encrypted_message[i] = keyAlphabet[keyAlphabetNumber][k];
                            }
                            if (keyAlphabetNumber == keyAlphabet.length - 1) {
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
                String[] encrypted_message = scanner.nextLine().split("");
                String[] unencrypted_message = new String[encrypted_message.length];
                System.out.println("Введите ваш уникальный ключ шифрования:");
                int[] key = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                int numberInKey = -1;
                int keyAlphabetNumber = 0;
                int changeKeyAlphabet = 2;
                // возможно вначале вставить проверку на outofbounds | скорее обнулить надо
                for (int i = 0; i < encrypted_message.length; i++) {
                    if (Arrays.asList(alphabet).contains(encrypted_message[i].toLowerCase())) {
                        changeKeyAlphabet++;
                    }
                    if (changeKeyAlphabet % 3 == 0) {
                        numberInKey++;
                        keyAlphabet = new String[3][alphabet.length];
                        switch (key[numberInKey]) {
                            case 1 -> keyAlphabet = firstKeySet;
                            case 2 -> keyAlphabet = secondKeySet;
                            case 3 -> keyAlphabet = thirdKeySet;
                        }
                        if (numberInKey == key.length - 1) {
                            numberInKey = 0;
                        }
                    }
                    for (int k = 0; k < keyAlphabet[keyAlphabetNumber].length; k++) {
                        if (encrypted_message[i].toLowerCase().equals(keyAlphabet[keyAlphabetNumber][k])) {
                            if (encrypted_message[i].equals(encrypted_message[i].toUpperCase())) {
                                unencrypted_message[i] = alphabet[k].toUpperCase();
                            } else {
                                unencrypted_message[i] = alphabet[k];
                            }
                            if (keyAlphabetNumber == keyAlphabet.length - 1) {
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
