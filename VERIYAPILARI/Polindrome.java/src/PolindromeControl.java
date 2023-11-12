//Ad = Livanur Nagihan
//Soyad = Duman
//Numara = 220706003
import java.util.Stack;//Stack yapısını import ile içe aktardım
public class PolindromeControl {//PolindromControl Sınıfını oluşturdum
    public static boolean isPolindrome(String vocable) {
        if (vocable.isEmpty()) {
            return true;
        }
        //Boş bir kelimenin otomotik olarak Polindrom olduğunu belirttim

        Stack<Character> stack = new Stack<>();//Stack sınıfıyla dataların LİFO yapısıyla üst üste depolandığını gösterdim

        int length = vocable.length();
        for (int v = 0; v < length / 2; v++) {
            stack.push(vocable.charAt(v));
        }
        //Stack sınıfına kelimenin yarısını  ekledim

        int go = (length % 2 == 0) ? length / 2 : length / 2 + 1;
        for (int c = go; c < length; c++) {
            if (vocable.charAt(c) != stack.pop()) {
                return false;
            }//Ortasından başlayarak keimenin geri kalanını kıyasladım
        }
        return true;
    }
    public static void main(String[] args) {
        String vocable = "MOM"; // Polindrom kelime
        // String vocable = "liva"; //Kelime polindrom değil

        if (isPolindrome(vocable)) {
            System.out.println(vocable + " Tebrikler!! Bu kelime polindromdur.");
        }else {
            System.out.println(vocable + " Üzgünüz!! Bu keilme polindrom değildir.");
        }
    }
}