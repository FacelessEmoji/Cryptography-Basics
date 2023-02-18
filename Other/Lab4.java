package Other;

import java.util.Locale;
import java.util.Scanner;

public class Lab4 {
    public static final String alphabet ="абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст, ключ и что вы хотите с ним сделать (shifr, deshifr)");
        String text = scanner.nextLine().toLowerCase(Locale.ROOT);
        String key = scanner.nextLine().toLowerCase(Locale.ROOT);
        String chto = scanner.nextLine().toLowerCase(Locale.ROOT);
        Integer j =0;
        switch (chto){
            case ("shifr"):
                for (int i =0; i<text.length(); i++){
                    String bukva = String.valueOf(text.charAt(i));
                    if (alphabet.contains(bukva)){
                        int k1 = alphabet.indexOf(text.charAt(i));
                        int k2 = alphabet.indexOf(key.charAt(i%key.length()));
                        System.out.print(alphabet.charAt(((k1+k2))%alphabet.length()));
                    } else  {
                        System.out.print(bukva);
                    }
                }
                break;
            case ("deshifr"):
                while (j<text.length()){
                    String bukva = String.valueOf(text.charAt(j));
                    if (alphabet.contains(bukva)){
                        int tt = alphabet.indexOf(text.charAt(j));
                        int kk = alphabet.indexOf(key.charAt(j%key.length()));
                        j++;
                        int sum = tt-kk;
                        if (sum <0){
                            System.out.print(alphabet.charAt(33-Math.abs(sum)));
                        } else System.out.print(alphabet.charAt(sum%alphabet.length()));
                    }else {
                        System.out.print(bukva);
                    }
                }
                break;
            default:
                System.out.println("Упс....");
        }

    }
}
