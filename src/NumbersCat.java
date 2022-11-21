
public class NumbersCat {

    public static String say(long n) {
        if (n == 0)
            return "Zero";
        String resultat = "";

        if (Math.abs(n) < 10000 && Math.abs(n) >= 1000){
            resultat += milenes(n);
            n = n % 1000;
        }

        if (Math.abs(n) < 1000 && Math.abs(n) >= 100) {
            resultat += centenes(n) + " ";
            n = n % 100;
        }

        if (Math.abs(n) < 100 && Math.abs(n) >= 20) {
            boolean vintena = false;
            resultat += desenes(n);
            if (desenes(n) == "vint" )
                vintena = true;
            n = n % 10;
            if (Math.abs(n) < 20 && Math.abs(n) != 0) {
                if (vintena == true)
                    resultat += "-i-";
                else
                    resultat += "-";
            }
        }
        if (Math.abs(n) < 20)
            resultat += nums0_19(n);

        if (n < 0)
            resultat = "menys " + resultat;

        return resultat.substring(0, 1).toUpperCase() + resultat.substring(1).trim();
    }

    private static String milenes(long n) {
        String milena = "";
        /* //n = 320 001
        //Centenes antes del mil
        if (n/100000 > 0)
        milena += centenes(n/1000);

        //Desenes antes del mil *Malament
        if (n/10000 > 0)
        milena += desenes(n/10000);

        //Unitats antes del mil *Malament
        if (n/1000 > 0)
        milena += nums0_19(n/100000);

        //2000*/
        if (n/1000 > 1)
        milena += nums0_19(n/1000);
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
        //Només volem la desena del nombre en positiu. Ex: -33 -> 3
        n = Math.abs(n / 10) - 2;
        return desenes[(int) n];
    }

    private static String nums0_19(long n) {
        String[] unicNums = {
                "", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit",
                "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
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
