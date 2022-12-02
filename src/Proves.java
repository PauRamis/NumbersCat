public class Proves {
    public static void main(String[] args) {
       /* long n = 1_000_000_000;
        long sobrant = n/1_000_000;
        System.out.println(sobrant);*/
        /*
        String s = "Menys seixanta-sis";
        if (s.length() > 6 && s.substring(0, 6).equals("Menys ")){
            s = s.substring(6);
        }
        String[] numberDigits = s.split("[^a-zA-Z]");
        System.out.println(numberDigits[0]);
        */

        String s = "Set menys quatre més dos";
        String[] operArray = s.split("(més)|(menys)");
        System.out.println(operArray[2]);
    }
}
