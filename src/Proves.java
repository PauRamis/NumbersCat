public class Proves {
    public static void main(String[] args) {
        int n = 123;
        String number = String.valueOf(n);
        String[] nDigits = number.split("(?<=.)");
        for (int i = 0; i < number.length(); i++) {
            System.out.println(nDigits[i]);
        }
    }
}
