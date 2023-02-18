package Other;

import java.util.Scanner;

public class Experiment {
    public static void makeEncryption(String[] alphabet_massive,String[] key_massive,boolean encrypt){
        Scanner scanner = new Scanner(System.in);
        String[] input_message = scanner.nextLine().split("");//считываем некст строку и в массив
        String[] output_message = new String[input_message.length];//массив под выводы
        String firstVar;
        String secondVar;
        for (int i = 0; i < input_message.length; i++) {// по букве в нешифрованном
            for (int j = 0; j < alphabet_massive.length; j++) { //по буквам в дефолтном алфавите
                if (encrypt) {
                    firstVar = key_massive[j];
                    secondVar = alphabet_massive[j];
                } else {
                    firstVar = alphabet_massive[j];
                    secondVar = key_massive[j];
                }
                if (input_message[i].toLowerCase().equals(secondVar)){//простое совпадение
                    if (input_message[i].equals(input_message[i].toUpperCase())){ // большая?
                        output_message[i] = firstVar.toUpperCase();
                    } else {
                        output_message[i] = firstVar;
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
        String[] key = {"б", "л", "ц", "ш", "я", "м", "р", "с", "ж", "а", "з", "ф", "е", "ъ", "о",
                "г", "ё", "и", "п", "н", "э", "й", "к", "ч", "щ", "ы", "у", "ь", "ю", "т", "х", "д","в"};
        while (!message.equalsIgnoreCase("Стоп")){
            if (message.equalsIgnoreCase("Шифруем")){
                makeEncryption(alphabet,key,true);
            }else if (message.equalsIgnoreCase("Дешифруем")){
                makeEncryption(alphabet,key,false);
            }
            message = scanner.nextLine();
        }
    }
}
