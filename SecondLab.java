import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecondLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
                "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я"};
        String[][] keyAlphabets = {
                {"т", "р", "и", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "й", "к", "л", "м",
                        "н", "о", "п", "с", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я"},
                {"с", "л", "о", "в", "а", "б", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "м",
                        "н", "п", "р", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я"},
                {"и", "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "й", "к", "л", "м", "н", "о",
                        "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "ю", "я"},
                {"с", "о", "ю", "з", "а", "б", "в", "г", "д", "е", "ё", "ж", "и", "й", "к", "л",
                        "м", "н", "п", "р", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ь", "ы", "ъ", "э", "я"}
        };
        int keyAlphabetNumber;
        String message = scanner.nextLine();
        while (!message.equalsIgnoreCase("Стоп")){
            if (message.equalsIgnoreCase("Шифруем")){
                String[] unencrypted_message = scanner.nextLine().split("");
                String[] encrypted_message = new String[unencrypted_message.length];
                keyAlphabetNumber = 0;
                for (int i = 0; i < unencrypted_message.length; i++) { //проход по слову
                    for (int k = 0; k < keyAlphabets[keyAlphabetNumber].length; k++) { //буква номер k
                        if (unencrypted_message[i].toLowerCase().equals(alphabet[k])){ // простое совпадение буквы с шифром без регистра
                            if (unencrypted_message[i].equals(unencrypted_message[i].toUpperCase())){ //
                                encrypted_message[i] = keyAlphabets[keyAlphabetNumber][k].toUpperCase();
                            } else {
                                encrypted_message[i] = keyAlphabets[keyAlphabetNumber][k];
                            }
                            if (keyAlphabetNumber == keyAlphabets.length-1){
                                keyAlphabetNumber = 0;
                            }else {
                                keyAlphabetNumber++;
                            }
                            break;
                        }
                        if (k == alphabet.length - 1){
                            encrypted_message[i] = unencrypted_message[i];
                        }
                    }
                }
                System.out.println(Arrays.stream(encrypted_message).collect(Collectors.joining()));
            }else if (message.equalsIgnoreCase("Дешифруем")){
                String[] encrypted_message = scanner.nextLine().split("");
                String[] unencrypted_message = new String[encrypted_message.length];
                keyAlphabetNumber = 0;
                // возможно вначале вставить проверку на outofbounds | скорее обнулить надо
                for (int i = 0; i < encrypted_message.length; i++) {
                    for (int k = 0; k < keyAlphabets[keyAlphabetNumber].length; k++) {
                        if (encrypted_message[i].toLowerCase().equals(keyAlphabets[keyAlphabetNumber][k])){
                            if (encrypted_message[i].equals(encrypted_message[i].toUpperCase())){
                                unencrypted_message[i] = alphabet[k].toUpperCase();
                            } else {
                                unencrypted_message[i] = alphabet[k];
                            }
                            if (keyAlphabetNumber == keyAlphabets.length-1){
                                keyAlphabetNumber = 0;
                            }else {
                                keyAlphabetNumber++;
                            }
                            break;
                        }
                        if (k == alphabet.length - 1){
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
