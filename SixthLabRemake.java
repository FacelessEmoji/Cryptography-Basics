import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class SixthLabRemake {
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
            System.out.println(String.join("", encrypted_message));
            return String.join("", encrypted_message);
        }

        public static String decrypt(String[] halfDecryptedMessage, int frequency) {
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
            System.out.println("""
                Вас приветствует user-friendly консоль.
                Вводите слова "Шифруем" или "Дешифруем" и следуйте дальнейшим указаниям.
                Для остановки программы введите "Стоп".""");
            String message = scanner.nextLine();
            String[][] saver = new String[0][0];
            while (!message.equalsIgnoreCase("Стоп")) {
                if (message.equalsIgnoreCase("Шифруем")) {
                    System.out.println("Введите то, что хотите зашифровать:");
                    String[] preUnencryptedMessageString = scanner.nextLine().split("");
                    System.out.println("Введите последовательность неповторяющихся цифр не содержащую ноль в произвольном порядке и слитно" +
                            ", чтобы задать уникальный ключ шифрования:");
                    Integer[] key = Stream.of(scanner.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                    System.out.println("Введите частоту повторения пустого символа:");
                    int repeatFrequency = Integer.parseInt(scanner.nextLine());
                    String unencryptedMessageString = encryptWithSecondKey(preUnencryptedMessageString, repeatFrequency);
                    int realMessageSize = ((int) Math.ceil((float) unencryptedMessageString.length() / key.length)) * key.length;
                    int spaceCount = realMessageSize - unencryptedMessageString.length();
                    int columnSize = realMessageSize / key.length;
                    unencryptedMessageString += StringUtils.repeat(" ", spaceCount);
                    String[] unencrypted_message = unencryptedMessageString.split("");
                    String[][] unencrypted_matrix = new String[key.length][columnSize];
                    String[][] encrypted_matrix = new String[key.length][columnSize];
                    String[][] intermediate_matrix = new String[columnSize][key.length];
                    // делим на колонки
                    int counter = 0;
                    int position = 0;
                    for (int i = 0; i < columnSize; i++) {
                        counter = 0;
                        while (counter < key.length) {
                            intermediate_matrix[i][counter] = unencrypted_message[position];
                            position++;
                            counter++;
                        }
                    }
                    for (int i = 0; i < key.length; i++) {
                        for (int j = 0; j < columnSize; j++) {
                            unencrypted_matrix[i][j] = intermediate_matrix[j][i];
                        }
                    }
                    //
                    for (int i = 1; i < key.length + 1; i++) {//по ключу
                        for (int j = 0; j < columnSize; j++) {//по колонкам
                            encrypted_matrix[i - 1][j] = unencrypted_matrix[List.of(key).indexOf(i)][j];//i-1(0) столбик кр-мы на такой столбик начальной матрицы,у которого индекс равен i-ой букве ключа
                        }
                    }
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
                    String[][] encrypted_matrix = saver;
                    System.out.println("Введите ваш уникальный ключ шифрования:");
                    Integer[] key = Stream.of(scanner.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                    System.out.println("Введите частоту повторения пустых символов:");
                    int repeatFrequency = Integer.parseInt(scanner.nextLine());
                    String halfDecryptedMessage = "";
                    int columnSize = encrypted_matrix[1].length;
                    for (int i = 0; i < columnSize; i++) {
                        for (int j = 0; j < key.length; j++) {
                            halfDecryptedMessage += encrypted_matrix[key[j] - 1][i];
                        }
                    }
                    System.out.println(decrypt(halfDecryptedMessage.split(""), repeatFrequency));
                }
                message = scanner.nextLine();
            }
        }
}
