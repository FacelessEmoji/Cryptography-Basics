import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] symbols = {"А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М",
                "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь","Э","Ю","Я",
                "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
                "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я"};
        String[] key = {"й", "Б", "Ю", "ы", "М", "А", "Н", "П", "м", "Ж", "ш", "ю", "з", "Ъ", "Ш",
        "и", "Ь", "р", "н", "д", "Х", "е", "э", "В", "ц", "О", "У", "Д", "Й", "п", "г", "а", "Л",
        "я",  "щ", "т", "о", "Ё", "с", "Ф", "к", "Ч", "Г", "в", "ь", "ф", "Щ", "Е", "С", "л", "З", "Э",
        "ж", "х", "Т", "б", "Р", "ё", "ч", "Ы", "Я", "ъ", "у", "И", "Ц", "К"};
        String message = scanner.nextLine();
        while (!message.equalsIgnoreCase("Стоп")){
            if (message.equalsIgnoreCase("Шифруем")){
                String[] unencrypted_message = scanner.nextLine().split("");
                String[] encrypted_message = new String[unencrypted_message.length];
                for (int i = 0; i < unencrypted_message.length; i++) {
                    for (int j = 0; j < symbols.length; j++) {
                        if (unencrypted_message[i].equals(symbols[j])){
                            encrypted_message[i] = key[j];
                            break;
                        }
                        if (j == symbols.length - 1){
                            encrypted_message[i] = unencrypted_message[i];
                        }
                    }
                }
                System.out.println(Arrays.stream(encrypted_message).collect(Collectors.joining()));
            }else if (message.equalsIgnoreCase("Дешифруем")){
                String[] encrypted_message = scanner.nextLine().split("");
                String[] unencrypted_message = new String[encrypted_message.length];
                for (int i = 0; i < encrypted_message.length; i++) {
                    for (int j = 0; j < key.length; j++) {
                        if (encrypted_message[i].equals(key[j])){
                            unencrypted_message[i] = symbols[j];
                            break;
                        }
                        if (j == symbols.length - 1){
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
