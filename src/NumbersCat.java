
public class NumbersCat {

    public static String say(long n) {
        /*Pasam el numero a un array d'strings
        String number = String.valueOf(n);
        String[] numberDigits = number.split("(?<=.)");*/

        

        String resultat = "";
        if (n < 20)
            resultat = nums0_19(n);

        if (n < 0)
            resultat = "menys " + resultat;
        return resultat.substring(0, 1).toUpperCase() + resultat.substring(1);
    }

    private static String nums0_19(long n) {
        String[] unicNums = {
                "zero", "un", "dos", "tres", "quatre",
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
