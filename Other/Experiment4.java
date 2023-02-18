package Other;

import java.util.Arrays;
import java.util.Scanner;

public class Experiment4 {
    public static void makeEncryption(String[] alphabet_massive,String[][] key_matrix,boolean encrypt){
        Scanner scanner = new Scanner(System.in);
        String[] input_message = scanner.nextLine().split("");//считываем некст строку и в массив
        String[] output_message = new String[input_message.length];//массив под выводы;
        String firstVar;
        String secondVar;
        int keyAlphabetNumber = 0;
        for (int i = 0; i < input_message.length; i++) {
            for (int j = 0; j < alphabet_massive.length; j++) {

                if (encrypt) {
                    firstVar = key_matrix[keyAlphabetNumber][j];
                    secondVar = alphabet_massive[j];
                } else {
                    firstVar = alphabet_massive[j];
                    secondVar = key_matrix[keyAlphabetNumber][j];
                }

                if (input_message[i].toLowerCase().equals(secondVar)){
                    if (input_message[i].equals(input_message[i].toUpperCase())){ // большая?
                        output_message[i] = firstVar.toUpperCase();
                    } else {
                        output_message[i] = firstVar;
                    }
                    if (keyAlphabetNumber == key_matrix.length-1){
                        keyAlphabetNumber = 0;
                    }else {
                        keyAlphabetNumber++;
                    }
                    break;
                }
                if (j == alphabet_massive.length - 1){//если до конца последней итерации не произошло замены
                    output_message[i] = input_message[i];
                }
            }
        }
        System.out.println(String.join("", output_message));
    }

    public static String[][] makeVigenerTable(String[] alphabet){
        Scanner scanner = new Scanner(System.in);
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
        return keyAlphabets;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м",
                "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я"};
        while (!message.equalsIgnoreCase("Стоп")){
            if (message.equalsIgnoreCase("Шифруем")){
                makeEncryption(alphabet,makeVigenerTable(alphabet), true);
            }else if (message.equalsIgnoreCase("Дешифруем")){
                makeEncryption(alphabet,makeVigenerTable(alphabet), false);
            }
            message = scanner.nextLine();
        }
    }
}
