package Other;

import java.util.Scanner;

public class FlArtem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] Alphabet = {" ", "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С",
                "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь","Э","Ю","Я", "а", "б", "в", "г", "д",
                "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х",
                "ц", "ч", "ш", "щ", "ъ", "ы","ь","э","ю","я",".",",",":",";","?","/","[","]","{","}","|","<",">","`","'","%","@", "#","^","&"};

        String[] myAlphabet = {" ","Й" , "Ц", "У", "К", "Е", "Н", "Г", "Ш", "Щ", "З", "Х", "Ъ", "Ё", "Ф", "Ы", "В", "А", "П", "Р",
                "О", "Л", "Д", "Ж", "Э", "Я", "Ч", "С", "М", "И", "Т","Ь","Б","Ю", "й", "ц", "у", "к", "е",
                "н", "г", "ш", "щ", "з", "х", "ъ", "ё", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж",
                "э", "я", "ч", "с", "м","и","т","ь","б","ю",".",",",":",";","?","/","[","]","{","}","|","<",">","`","'","%","@", "#","^","&"};

        String text = in.nextLine();
        while (!text.equalsIgnoreCase("Конец"))
        {
            if (text.equalsIgnoreCase("Портим"))
            {
                String[] Soobshenie = in.nextLine().split("");
                String[] NovoeSoobsheni = new String[Soobshenie.length];
                for (int i = 0; i < Soobshenie.length; i++)
                {
                    for (int j = 0; j < Alphabet.length; j++) {
                        if (Soobshenie[i].equals(Alphabet[j]))
                        {
                            NovoeSoobsheni[i] = myAlphabet[j];
                        }
                    }
                }
                System.out.println(String.join("", NovoeSoobsheni));
            }
            else if (text.equalsIgnoreCase("Правим"))
            {
                String[] NovoeSoobsheni = in.nextLine().split("");
                String[]  Soobshenie = new String[NovoeSoobsheni.length];
                for (int i = 0; i < NovoeSoobsheni.length; i++)
                {
                    for (int j = 0; j < myAlphabet.length; j++)
                    {
                        if (NovoeSoobsheni[i].equals(myAlphabet[j]))
                        {
                            Soobshenie[i] = Alphabet[j];
                        }
                    }
                }
                System.out.println(String.join("", Soobshenie));
            }
            text = in.nextLine();
        }

    }
}
