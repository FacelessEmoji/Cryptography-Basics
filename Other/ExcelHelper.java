package Other;

import java.util.Arrays;
import java.util.Scanner;

public class ExcelHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] alphabet = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м",
                "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        String[] s = scanner.nextLine().split("");
        //String s = scanner.nextLine();
/*        for (int i = 1; i < s.length + 1; i++) {
            if (i == s.length-1){
                System.out.print(s[i-1]);
            } else {
                System.out.print(s[i-1] + " ");
            }
            if (i % 30 == 0){
                System.out.println();
            }
        }
        System.out.println();*/
        int martix_num = 0;
        int[] set_num = {2,3,1};
        int set_counter = 0;
        int set_print = 0;
        for (int i = 1; i < s.length + 1; i++) {
            if (Arrays.asList(alphabet).contains(s[i - 1].toLowerCase())) {
                if (martix_num == 9) {
                martix_num = 1;
                } else {
                    martix_num++;
                }
/*                if ((martix_num+2) % 3 == 0){
                    if (set_counter == 2){
                        set_counter = 0;
                        set_print = set_num[set_counter];
                    } else {
                        set_counter++;
                        set_print = set_num[set_counter];
                    }

                }*/
                if (i == s.length - 1) {
                    System.out.println(
                            "[" + Arrays.asList(alphabet).indexOf(s[i - 1].toLowerCase()) + "] -> [" /*+ set_print + "]["*/
                                   + martix_num + "]["
                                    + Arrays.asList(alphabet).indexOf(s[i - 1].toLowerCase()) + "]"
                    );
                } else {
                    System.out.println(
                            "[" + Arrays.asList(alphabet).indexOf(s[i - 1].toLowerCase()) + "] -> [" /*+ set_print + "]["*/
                                    + martix_num + "]["
                                    + Arrays.asList(alphabet).indexOf(s[i - 1].toLowerCase()) + "]"
                    );
                }
            } else {
                System.out.print("- ");
                System.out.println();
            }
            if (i % 15 == 0) {
                System.out.println();
            }
        }

/*        for (int i = 1; i < s.length() + 1; i++) {
                System.out.print(Integer.toBinaryString(s.charAt(i-1)) + " ");
            if (i % 30 == 0){
                System.out.println();
            }
        }*/
    }
}
