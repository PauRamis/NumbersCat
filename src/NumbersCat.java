
public class NumbersCat {

    public static String say(long n) {
        //Zero es una exepció que només es dona en aquest cas
        if (n == 0)
            return "Zero";
        String resultat = "";
        boolean negatiu = false;
        if (n < 0){
            negatiu = true;
            n = -n;
        }
        if (n < 1_000_000_000_000_000_000L && n >= 1_000_000_000_000L){
            resultat += billons(n);
            n = n % 1_000_000_000_000L;
        }

        if (n < 1_000_000_000_000L && n >= 1_000_000){
            resultat += millons(n);
            n = n % 1_000_000;
        }
        if (n < 1_000_000 && n >= 1000){
            resultat += milenes(n);
            n = n % 1000;
        }

        //Sumam les ultimes unitats al resultat
        resultat += unitatsaCentenes(n);
        //Posam el menys si és negatiu
        if (negatiu)
            resultat = "menys " + resultat;
        //eliminam tots els espais sobrants i posam la primera en mayuscules
        resultat = resultat.trim().replaceAll("\\s{2,}", " ");
        return resultat.substring(0, 1).toUpperCase() + resultat.substring(1);
    }

    private static String billons(long n) {
        String resultat = "";
        if (n/1000 < 1_000_000_000_000L)
            resultat = unitatsaCentenes(n/1_000_000_000_000L);
        else {
            resultat = milenes(n/1_000_000_000_000L);

            long nres = (n/1_000_000_000_000L) % 1000;
            resultat += unitatsaCentenes(nres);
        }

        if (n < 2_000_000_000_000L)
            return resultat + " bilió ";
        return resultat + " bilions ";
    }

    private static String millons(long n) {
        String resultat = "";
        if (n/1000 < 1_000_000)
            resultat = unitatsaCentenes(n/1_000_000);
        else {
            resultat = milenes(n/1_000_000);

            long nres = (n/1_000_000) % 1000;
            resultat += unitatsaCentenes(nres);
        }

        if (n < 2_000_000)
            return resultat + " milió ";
        return resultat + " milions ";
    }

    //Funció del 1 al 999
    private static String unitatsaCentenes(long n) {
        String resultat = "";
        if (n < 1000 && n >= 100) {
            resultat += centenes(n) + " ";
            n = n % 100;
        }

        if (n < 100 && n >= 20) {
            boolean vintena = false;
            resultat += desenes(n);
            if (desenes(n) == "vint" )
                vintena = true;
            n = n % 10;
            if (n < 20 && n != 0) {
                if (vintena == true)
                    resultat += "-i-";
                else
                    resultat += "-";
            }
        }
        if (n < 20)
            resultat += nums0_19(n);

        if (n < 0)
            resultat = "menys " + resultat;
        return resultat;
    }

    private static String milenes(long n) {
        String milena = "";
        if (n < 2000)
            return "mil ";
        milena = unitatsaCentenes((n/1000));
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
        n = (n / 10) - 2;
        return desenes[(int) n];
    }

    private static String nums0_19(long n) {
        String[] unicNums = {
                "", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit",
                "nou", "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
                "disset", "divuit", "dinou"
        };
        return unicNums[(int) n];
    }

    public static long words(String s) {
        return 0;
    }

    public static String oper(String s) {
        return "";
    }
}
