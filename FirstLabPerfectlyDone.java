import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstLabPerfectlyDone {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м",
                    "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я"};
            String[] key = {"б", "л", "ц", "ш", "я", "м", "р", "с", "ж", "а", "з", "ф", "е", "ъ", "о",
                    "г", "ё", "и", "п", "н", "э", "й", "к", "ч", "щ", "ы", "у", "ь", "ю", "т", "х", "д","в"};
            String message = scanner.nextLine();
            while (!message.equalsIgnoreCase("Стоп")){
                if (message.equalsIgnoreCase("Шифруем")){
                    String[] unencrypted_message = scanner.nextLine().split("");//считываем некст строку и в массив
                    String[] encrypted_message = new String[unencrypted_message.length];//массив под выводы
                    for (int i = 0; i < unencrypted_message.length; i++) {// по букве в нешифрованном
                        for (int j = 0; j < alphabet.length; j++) {//по буквам в дефолтном алфавите
                            if (unencrypted_message[i].toLowerCase().equals(alphabet[j])){//простое совпадение
                                if (unencrypted_message[i].equals(unencrypted_message[i].toUpperCase())){ // большая?
                                    encrypted_message[i] = key[j].toUpperCase();
                                } else {
                                    encrypted_message[i] = key[j];
                                }
                                break;
                            }
                            if (j == alphabet.length - 1){//если до конца последней итерации не произошло замены
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
                            if (encrypted_message[i].toLowerCase().equals(key[j])){
                                if (encrypted_message[i].equals(encrypted_message[i].toUpperCase())){
                                    unencrypted_message[i] = alphabet[j].toUpperCase();
                                } else {
                                    unencrypted_message[i] = alphabet[j];
                                }
                                break;
                            }
                            if (j == alphabet.length - 1){
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
