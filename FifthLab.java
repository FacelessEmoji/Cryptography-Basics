import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FifthLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует user-friendly консоль.\n" +
                "Вводите слова \"Шифруем\" или \"Дешифруем\" и следуйте дальнейшим указаниям.\n" +
                "Для остановки программы введите \"Стоп\".");
        String message = scanner.nextLine();
        while (!message.equalsIgnoreCase("Стоп")) {
            if (message.equalsIgnoreCase("Шифруем")) {
                System.out.println("Введите то, что хотите зашифровать:");
                String[] unencrypted_message = "Ключ - это конкретное секретное состояние некоторых параметров алгоритма криптографического преобразования данных.".split("");//scanner.nextLine().split("");
                System.out.println("Размер вашего сообщения:" + unencrypted_message.length);
                System.out.println("Введите последовательность неповторяющихся цифр не содержащую ноль в произвольном порядке" +
                        ", чтобы задать уникальный ключ шифрования:");
                Integer[] key = Stream.of(scanner.nextLine().split("")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
                System.out.println("Введите желаемый размер колонки в шифре перестановки:");
                int columnSize = Integer.parseInt(scanner.nextLine());
                String[][] unencrypted_matrix = new String[key.length][columnSize];
                String[][] encrypted_matrix = new String[key.length][columnSize];
                int incrementator;
                for (int i = 0; i < key.length; i++) {
                    incrementator = 0;
                    for (int j = i; j < columnSize * key.length; j+= key.length) {
                        if (j > unencrypted_message.length){
                            unencrypted_matrix[i][(j + incrementator - i) % key.length] = " "; //костыль
                        } else {
                            unencrypted_matrix[i][(j + incrementator - i) % key.length] = unencrypted_message[j];
                        }
                        incrementator++;
                    }
                }
                for (int i = 1; i < key.length + 1; i++) {//по ключу
                    for (int j = 0; j < columnSize; j++) {//по колонкам
                        encrypted_matrix[i-1][j] = unencrypted_matrix[List.of(key).indexOf(i)][j];//первый столбик кр-мы на такой столбик начальной матрицы,у которого индекс равен i-ой букве ключа
                    }
                }
                for (int i = 0; i < encrypted_matrix.length; i++) {
                    for (int j = 0; j < encrypted_matrix[i].length; j++) {
                        System.out.print(encrypted_matrix[i][j]);
                    }
                }
                //System.out.println(Arrays.stream(encrypted_message).collect(Collectors.joining()));
            } else if (message.equalsIgnoreCase("Дешифруем")) {
                System.out.println("Введите ваш уникальный ключ шифрования:");
                int[] key = Stream.of(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                System.out.println("Введите то, что хотите расшифровать:");
                String[] encrypted_message = scanner.nextLine().split("");
                String[] unencrypted_message = new String[encrypted_message.length];



                System.out.println(Arrays.stream(unencrypted_message).collect(Collectors.joining()));
            }
            message = scanner.nextLine();
        }
    }
}
