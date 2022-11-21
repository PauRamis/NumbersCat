
public class NumbersCat {

    public static String say(long n) {
        if (n == 0)
            return "Zero";
        String resultat = "";

        if (Math.abs(n) < 100 && Math.abs(n) >= 20) {
            resultat += desenes(n);
            n = n % 10;
            if (Math.abs(n) < 20 && Math.abs(n) != 0) {
                if (resultat.equals("vint"))
                    resultat += "-i-";
                else
                resultat += "-";
            }
        }
        if (Math.abs(n) < 20)
            resultat += nums0_19(n);

        if (n < 0)
            resultat = "menys " + resultat;
        return resultat.substring(0, 1).toUpperCase() + resultat.substring(1);
    }

    private static String desenes(long n) {
        String[] desenes = {
                "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"
        };
        //Només volem la desena del nombre en positiu. Ex: -33 -> 3
        n = Math.abs(n / 10) - 2;
        return desenes[(int) n];
    }

    private static String nums0_19(long n) {
        String[] unicNums = {
                "", "un", "dos", "tres", "quatre",
                "cinc", "sis", "set", "vuit", "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
                "disset", "divuit", "dinou"
        };
        return unicNums[Math.abs((int) n)];
    }

    public static long words(String s) {
        return 0;
    }

    public static String oper(String s) {
        return "";
    }

}
