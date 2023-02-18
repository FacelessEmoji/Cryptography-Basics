package Other;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultiHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        String[] symbols = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
                "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я"};*/
        String[][] symbols = {
                {"я", "г", "д", "е", "ь", "т", "с", "и", "м", "а", "з", "в", "щ", "ч", "ъ", "ы",
                        "л", "ё", "к", "ц", "й", "э", "х", "о", "ж", "р", "б", "ш", "ю", "у", "п", "ф", "н"},
                {"ь", "ы", "ч", "л", "ж", "й", "ц", "г", "д", "ъ", "т", "з", "с", "ё", "и", "ф",
                        "ю", "п", "р", "ш", "я", "у", "в", "щ", "н", "е", "о", "к", "м", "б", "х", "э", "а"},
                {"г", "у", "ю", "д", "х", "з", "я", "ч", "л", "к", "ц", "и", "ё", "р", "о", "ь",
                        "ъ", "ы", "щ", "н", "м", "с", "в", "а", "й", "ш", "б", "е", "ж", "п", "ф", "т", "э"}
              };

        //List<String> result = Arrays.asList(symbols);
        //Collections.shuffle(result);
        //System.out.println(result);

        //String[] s = scanner.nextLine().toLowerCase().split("\", \"");
        System.out.println(String.join("",symbols[2]));
        //String[] s = result.toArray(new String[0]);
/*        for (int i = 0; i < s.length; i++) {
            if (i == 0){
                System.out.print("{\"" + s[i] + "\", ");
            } else if (i == s.length - 1){
                System.out.print("\"" + s[i] + "\"}");
            } else {
                System.out.print("\"" + s[i] + "\", ");
            }
        }*/
/*        if ("a".equalsIgnoreCase("а")){
            System.out.println("Y");
        } else {
            System.out.println("N");
        }*/

    }
}
