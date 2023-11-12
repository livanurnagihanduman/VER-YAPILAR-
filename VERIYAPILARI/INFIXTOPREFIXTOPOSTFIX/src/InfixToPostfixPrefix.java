//Ad = Livanur  Nagihan
//Soyad = Duman
//Numara = 220706003

import java.util.Stack;
public class InfixToPostfixPrefix {

    // İşlem önceliği fonksiyonu
    static int priority(char charactar) {
        switch (charactar) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    static String infixToPrefix(String data) {    // Infix ifadeyi Prefix ifadeye dönüştüren fonksiyon
        String tersData = new StringBuilder(data).reverse().toString();
        for (int a = 0; a < tersData.length(); a++) {
            if (tersData.charAt(a) == '(') {
                tersData = tersData.substring(0, a) + ')' + tersData.substring(a + 1);
            } else if (tersData.charAt(a) == ')') {
                tersData = tersData.substring(0, a) + '(' + tersData.substring(a + 1);
            }
        }
        String postfix = infixToPostfix(tersData);
        return new StringBuilder(postfix).reverse().toString();
    }
    static String infixToPostfix(String data) { //  // Infix ifadeyi Postfix ifadeye dönüştüren fonksiyon
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int b = 0; b < data.length(); b++) {
            char charactar = data.charAt(b);
            System.out.println("Adım: " + charactar);
            if (Character.isLetterOrDigit(charactar)) {
                postfix.append(charactar);
                System.out.println("postfix: " + postfix);
            } else if (charactar == '(') {
                stack.push(charactar);
                System.out.println("Yığına koy " + charactar);
            } else if (charactar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    System.out.println("Yığından al " + stack.peek());
                    postfix.append(stack.pop());
                    System.out.println("postfix: " + postfix);
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Geçersiz İfade";
                } else {
                    System.out.println("Yığından al " + stack.peek());
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && priority(charactar) <= priority(stack.peek())) {
                    System.out.println("Yığından al " + stack.peek());
                    postfix.append(stack.pop());
                    System.out.println("postfix: " + postfix);
                }
                System.out.println("Yığına koy " + charactar);
                stack.push(charactar);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Üzgünüz! Geçersiz Veri";
            }
            System.out.println("Yığına al al " + stack.peek());
            postfix.append(stack.pop());
            System.out.println("postfix: " + postfix);
        }

        return postfix.toString();
    }
    public static void main(String[] args) {
        String infixData = "(300+400)*10/(500-1)";
        String postfixData = infixToPostfix(infixData);
        String prefixData = infixToPrefix(infixData);

        System.out.println("Infix Data =  " + infixData);
        System.out.println("Postfix Data = " + postfixData);
        System.out.println("Prefix Data = " + prefixData);
    }
}

/*
Rapor:
Çoğu derleyici, kaynak kod içerisinde infix notasyonunu kullanmaktadır
ve daha sonra stack veri yapısını kullanarak prefix veya postfix notasyonuna çevirir.

Infix Notasyonu: Alışa geldiğimiz ifadeler infix şeklindedir. Operatörlerin işlenecek operandlar arasına yerleştirildiği gösterim biçimidir.
Bu gösterimde operatör önceliklerinin değiştirilebilmesi için parantez kullanılması şarttır.
Örneğin infix notasyonundaki 2+4*6 ifadesi 2+24=26 ile sonuçlanır.
Aynı ifadede + operatörüne öncelik verilmesi istenirse parantezler kullanılır; (2+4)*6. Böylece ifade 36 ile sonuçlandırılır.

Prefix Notasyonu: Prefix notasyonunda (PN, polish notation) operatörler, operandlarından önce yazılır.
Örneğin 2+4*6 ifadesi infix notasyonundadır ve prefix notasyonunda +2*46 şeklinde gösterilir.
Benzer biçimde (2+4)*6 ifadesi *+246 şeklinde gösterilir.
Görüldüğü gibi prefix notasyonunda işlem önceliklerinin sağlanması için parantezlere ihtiyaç duyulmamaktadır.

Postfix Notasyonu: Postfix notasyonunda (RPN, reverse polish notation) ise önce operandlar ve ardından operatör yerleştirilir.
Aynı örnek üzerinden devam edersek; infix notasyonundaki 2+4*6 ifadesi prefix notasyonunda 2 4 6 * + şeklinde,
benzer biçimde (2+4)*6 ifadesi de 2 4 + 6 * şeklinde gösterilir.
Yine prefixte olduğu gibi bu gösterimde de parantezlere ihtiyaç duyulmamaktadır.

Tüm aritmetik ifadeler bu gösterimlerden birini kullanarak yazılabilir. Ancak, bir yazmaç (register) yığını ile birleştirilmiş postfix gösterimi,
aritmetik ifadelerin hesaplanmasında en verimli yoldur.

İşlem önceliği;
1- Parantez içi
2- Üs alma
3- Çarpma/Bölme
4- Toplama Çıkarma
Aynı önceliğe sahip işlemlerde sıra soldan sağa  doğrudur. Yalnız üs almada sağdan sola doğru işlem yapılır.
*/