public class NumbersCat {

    public static String say(long n) {
        //Zero és una excepció que només es dona en aquest cas
        if (n == 0)
            return "Zero";
        String resultat = "";
        boolean negatiu = false;
        if (n < 0) {
            negatiu = true;
            n = -n;
        }

        if (n >= 1_000_000_000_000_000_000L) {
            resultat += trilions(n);
            n = n % 1_000_000_000_000_000_000L;
        }

        if (n >= 1_000_000_000_000L) {
            resultat += bilions(n);
            n = n % 1_000_000_000_000L;
        }

        if (n >= 1_000_000) {
            resultat += milions(n);
            n = n % 1_000_000;
        }
        if (n >= 1000) {
            resultat += milenes(n);
            n = n % 1000;
        }

        resultat += unitatsaCentenes(n);

        if (negatiu)
            resultat = "menys " + resultat;

        //eliminem tots els espais sobrants i posem la primera en majúscules
        resultat = resultat.trim().replaceAll("\\s{2,}", " ");
        return resultat.substring(0, 1).toUpperCase() + resultat.substring(1);
    }

    private static String trilions(long n) {
        String resultat;
        resultat = unitatsaCentenes(n / 1_000_000_000_000_000_000L);

        if (n < 2_000_000_000_000_000_000L)
            return resultat + " trilió ";
        return resultat + " trilions ";
    }

    private static String bilions(long n) {
        String resultat;
        if (n / 1000 < 1_000_000_000_000L)
            resultat = unitatsaCentenes(n / 1_000_000_000_000L);
        else {
            resultat = milenes(n / 1_000_000_000_000L);

            long nRes = (n / 1_000_000_000_000L) % 1000;
            resultat += unitatsaCentenes(nRes);
        }

        if (n < 2_000_000_000_000L)
            return resultat + " bilió ";
        return resultat + " bilions ";
    }

    private static String milions(long n) {
        String resultat;
        if (n / 1000 < 1_000_000)
            resultat = unitatsaCentenes(n / 1_000_000);
        else {
            resultat = milenes(n / 1_000_000);

            long nres = (n / 1_000_000) % 1000;
            resultat += unitatsaCentenes(nres);
        }

        if (n < 2_000_000)
            return resultat + " milió ";
        return resultat + " milions ";
    }

    private static String unitatsaCentenes(long n) {
        String resultat = "";
        if (n < 1000 && n >= 100) {
            resultat += centenes(n) + " ";
            n = n % 100;
        }

        if (n < 100 && n >= 20) {
            boolean vintena = false;
            resultat += desenes(n);
            if (desenes(n).equals("vint"))
                vintena = true;
            n = n % 10;
            if (n != 0) {
                if (vintena)
                    resultat += "-i-";
                else
                    resultat += "-";
            }
        }
        if (n < 20)
            resultat += nums0_19(n);
        return resultat;
    }

    private static String milenes(long n) {
        String milena;
        if (n < 2000)
            return "mil ";
        milena = unitatsaCentenes((n / 1000));
        return milena + " mil ";
    }

    private static String centenes(long n) {
        String[] centenes = {
                "cent", "dos-cents", "tres-cents", "quatre-cents", "cinc-cents",
                "sis-cents", "set-cents", "vuit-cents", "nou-cents"
        };
        return centenes[(int) (n / 100) - 1];
    }

    private static String desenes(long n) {
        String[] desenes = {
                "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"
        };
        n = (n / 10) - 2;
        return desenes[(int) n];
    }

    private static String nums0_19(long n) {
        String[] nums = {
                "", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit",
                "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
                "disset", "divuit", "dinou"
        };
        return nums[(int) n];
    }

    public static long words(String s) {
        boolean negative = false;
        long resultat = 0;

        //Ens llevem el zero de damunt
        if (s.equals("Zero"))
            return resultat;

        //Eliminem els negatius i les mayuscules
        s = s.substring(0, 1).toLowerCase() + s.substring(1);
        if (s.length() > 6 && s.substring(0, 6).equals("menys ")) {
            s = s.substring(6);
            negative = true;
        }

        //Cream un array separant el numero
        String[] numberWords = s.split("[^a-zA-Zó]");
        resultat = WordsToNums(numberWords, s);

        //Si el número era negatiu, hem de posar el resultat en negatiu
        if (negative)
            resultat = -resultat;
        return resultat;
    }

    private static long WordsToNums(String[] numberWords, String s) {
        long resultat = 0;
        long resultatTemp = 0;
        for (int i = 0; i < numberWords.length; i++) {
            if (numberWords[i].equals("cent")) resultatTemp += 100;
            resultatTemp += desenesWords(numberWords[i]);
            resultatTemp += nums0_19Words(numberWords[i]);

            if (numberWords[i].equals("cents"))
                resultatTemp *= 100;
            if (numberWords[i].equals("mil")) {
                if (resultatTemp == 0)
                    resultatTemp = 1000;
                else
                    resultatTemp *= 1000;
                resultat += resultatTemp;
                resultatTemp = 0;
            }
            if (numberWords[i].equals("milió") || numberWords[i].equals("milions")) {
                resultat += resultatTemp;
                resultat *= 1_000_000;
                resultatTemp = 0;
            }
            if (numberWords[i].equals("bilió") || numberWords[i].equals("bilions")) {
                resultat += resultatTemp;
                if (s.contains("milions"))
                    //Si es multiplicarà després per un milió, ara ho multipliquem per menys.
                    resultat *= 1_000_000;
                else
                    resultat *= 1_000_000_000_000L;
                resultatTemp = 0;
            }
            if (numberWords[i].equals("trilió") || numberWords[i].equals("trilions")) {
                resultat += resultatTemp;
                if (s.contains("bilions") && s.contains("milions"))
                    resultat *= 1_000_000;
                else if (s.contains("bilions") || s.contains("milions"))
                    //Si es multiplicarà després per un milió i/o bilió, ara ho multipliquem per menys.
                    resultat *= 1_000_000_000_000L;
                else
                    resultat *= 1_000_000_000_000_000_000L;
                resultatTemp = 0;
            }
        }
        resultat += resultatTemp;
        return resultat;
    }

    private static long desenesWords(String s) {
        String[] desenes = {
                "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"
        };
        for (int i = 0; i < 8; i++) {
            if (s.equals(desenes[i]))
                return (i + 2) * 10;
        }
        return 0;
    }

    private static long nums0_19Words(String s) {
        String[] nums = {
                "", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit",
                "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
                "disset", "divuit", "dinou"
        };
        for (int i = 0; i < 20; i++) {
            if (s.equals(nums[i]))
                return i;
        }
        return 0;
    }

    public static String oper(String s) {
        String[] operArray = s.split("(més)|(menys)");
        long result = words(operArray[0]) + words(operArray[1]);
        return say(result);
    }
}
