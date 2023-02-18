package Other;

import java.util.Arrays;
import java.util.Scanner;

public class Experiment3 {
    public static void makeEncryption
            (String[] alphabet_massive,String[][] firstKeySet,String[][] secondKeySet, String[][] thirdKeySet,boolean encrypt){
        Scanner scanner = new Scanner(System.in);
        String[][] key_matrix = new String[3][alphabet_massive.length];
        String[] input_message = scanner.nextLine().split("");//считываем некст строку и в массив
        String[] output_message = new String[input_message.length];//массив под выводы;
        String firstVar;
        String secondVar;
        int[] key = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int numberInKey = -1;
        int keyAlphabetNumber = 0;
        int changeKeyAlphabet = 2;
        for (int i = 0; i < input_message.length; i++) {
            if (Arrays.asList(alphabet_massive).contains(input_message[i].toLowerCase())) {
            changeKeyAlphabet++;
        }
            if (changeKeyAlphabet % 3 == 0) {
                numberInKey++;
                key_matrix = new String[3][alphabet_massive.length];
                switch (key[numberInKey]) {
                    case 1 -> key_matrix = firstKeySet;
                    case 2 -> key_matrix = secondKeySet;
                    case 3 -> key_matrix = thirdKeySet;
                }
                if (numberInKey == key.length - 1) {
                    numberInKey = 0;
                }
            }
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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м",
                "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я"};
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
        while (!message.equalsIgnoreCase("Стоп")){
            if (message.equalsIgnoreCase("Шифруем")){
                makeEncryption(alphabet,firstKeySet,secondKeySet,thirdKeySet, true);
            }else if (message.equalsIgnoreCase("Дешифруем")){
                makeEncryption(alphabet,firstKeySet,secondKeySet,thirdKeySet, false);
            }
            message = scanner.nextLine();
        }
    }
}
