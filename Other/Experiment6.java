package Other;

import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Experiment6 {
    public static String[][] makeEncryptedMatrix(String[] unencrypted_message, int columnSize, int length,Integer[] key){
        String[][] unencrypted_matrix = new String[length][columnSize];
        String[][] encrypted_matrix = new String[length][columnSize];
        String[][] intermediate_matrix = new String[columnSize][length];
        int counter;
        int position = 0;
        for (int i = 0; i < columnSize; i++) {
            counter = 0;
            while (counter < length) {
                intermediate_matrix[i][counter] = unencrypted_message[position];
                position++;
                counter++;
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < columnSize; j++) {
                unencrypted_matrix[i][j] = intermediate_matrix[j][i];
            }
        }
        for (int i = 1; i < length + 1; i++) {//по ключу
            for (int j = 0; j < columnSize; j++) {//по колонкам
                encrypted_matrix[i - 1][j] = unencrypted_matrix[List.of(key).indexOf(i)][j];//i-1(0) столбик кр-мы на такой столбик начальной матрицы,у которого индекс равен i-ой букве ключа
            }
        }
        return encrypted_matrix;
    }

    public static String encryptWithSecondKey(String[] message, int frequency) {
        String[] encrypted_message = new String[message.length + message.length / (frequency - 1)];
        int messageIterator = 0;
        int symbolsIterator = 0;
        for (int i = 0; i < encrypted_message.length; i++) {
            symbolsIterator++;
            if (symbolsIterator % frequency == 0) {
                encrypted_message[i] = "&";
                symbolsIterator = 0;
                messageIterator++;
            } else {
                encrypted_message[i] = message[i - messageIterator];
            }
        }
        return String.join("", encrypted_message);
    }

    public static String decryptWithSecondKey(String[] halfDecryptedMessage, int frequency) {
        int symbolsIterator = 0;
        String encrypted_message = "";
        for (int i = 0; i < halfDecryptedMessage.length; i++) {
            symbolsIterator++;
            if (symbolsIterator % frequency == 0) {
                symbolsIterator = 0;
            } else {
                encrypted_message += halfDecryptedMessage[i];
            }
        }
        return encrypted_message;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String[][] saver = new String[0][0];
        while (!message.equalsIgnoreCase("Стоп")) {
            if (message.equalsIgnoreCase("Шифруем")) {
                String[] preUnencryptedMessageString = scanner.nextLine().split("");
                Integer[] key = Stream.of(scanner.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

                int repeatFrequency = Integer.parseInt(scanner.nextLine());
                String unencryptedMessageString = encryptWithSecondKey(preUnencryptedMessageString, repeatFrequency);
                int realMessageSize = ((int) Math.ceil((float)unencryptedMessageString.length()/ key.length))* key.length;
                int spaceCount = realMessageSize - unencryptedMessageString.length();
                unencryptedMessageString += StringUtils.repeat(" ",spaceCount);
                String[][] encrypted_matrix = makeEncryptedMatrix(unencryptedMessageString.split(""),realMessageSize/ key.length, key.length,key);
                for (int i = 0; i < encrypted_matrix.length; i++) {
                    for (int j = 0; j < encrypted_matrix[i].length; j++) {
                        if (!encrypted_matrix[i][j].equals("&")){
                            System.out.print(encrypted_matrix[i][j]);
                        }
                    }
                }
                System.out.println();
                saver = encrypted_matrix;
            } else if (message.equalsIgnoreCase("Дешифруем")) {
                System.out.println("Введите ваш уникальный ключ шифрования:");
                Integer[] key = Stream.of(scanner.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                int repeatFrequency = Integer.parseInt(scanner.nextLine());
                String halfDecryptedMessage = "";
                int columnSize = saver[1].length;
                for (int i = 0; i < columnSize; i++) {
                    for (int j = 0; j < key.length; j++) {
                        halfDecryptedMessage += saver[key[j] - 1][i];
                    }
                }
                System.out.println(decryptWithSecondKey(halfDecryptedMessage.split(""), repeatFrequency));
            }
            message = scanner.nextLine();
        }
    }
}
