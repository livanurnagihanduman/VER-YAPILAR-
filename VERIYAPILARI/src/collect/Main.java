package collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

//VERİ YAPILARI(DATA SCRUTURES)
public class Main {
    public static void main(String[] args) {

        System.out.println("Aufwiederschen java!");
        HashSet<Integer> hSet = new HashSet<>();
        hSet.add(10);
        hSet.add(50);
        hSet.add(30);
        hSet.add(10);
        hSet.add(null);

        for (Integer sayi : hSet) {
            System.out.println(sayi);
        }
        //ITERATOR
        Iterator<Integer> itr = hSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //İTERATOR VE FOR DÖNGÜSÜ AYNI İŞLEVDEDİR!

        System.out.println("LinkedHashSet");
        LinkedHashSet<Integer> lSet = new LinkedHashSet<>();
        lSet.add(10);
        lSet.add(10);
        lSet.add(20);
        lSet.add(30);

        Iterator<Integer> Itr = lSet.iterator();
        while (Itr.hasNext()) {
            System.out.println(Itr.next());
        }

        //TREESET METHOD

        TreeSet<Student> student = new TreeSet<>(new collect.OrderNameComparator().reversed());
        student.add(new Student("Liva", 20));
        student.add(new Student("Esat", 100));
        student.add(new Student("Efe", 40));
        student.add(new Student("Orhan", 80));
        student.add(new Student("Zeynep", 10));

        for (Student stu : student) {
            System.out.println(stu.getName());
        }

        //ARRAYLİST METHOD

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(1, null);
        list.add(0, null);


        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("Oluşan listenin boyutu = " + list.size());//Oluşan listenin boyutunu veriyor.(SİZE methodu)
        System.out.println("7. sıradaki değer = " + list.get(6));//GET methodu istenilen sıradaki sayıyı getirir.(İndexler 0'dan başlar)
        System.out.println("Listedeki " + list.get(0) + " elemanının yeri = " + list.indexOf(10) + ". index");
        //İNDEXOF METHODU listedeki elemanın yerini bulmaya yardımcı olur.
        System.out.println(list.contains(null));
        //CONTAİNS METHODU listedeki elemanın var mı yok mu olduğunu kontrol edip True yada False değerini döndürür.
        System.out.println(list.remove(5));
        //REMOVE METHODU listedeki elemanı silme görevi görür.


        //QUEUE LİNKEDLİST

        //Poliformizm = Çok Biçimcilik
        Queue<String> queue = new LinkedList<>();
        queue.add("Livanur");
        queue.add("Nagihan");
        queue.add("Duman");
        queue.peek();
        queue.poll();


        Iterator<String> itrtr = queue.iterator();
        while (itrtr.hasNext()) {
            System.out.println(itrtr.next());
        }

        // replaceAll()
        List<String> isimler = new ArrayList<>();
        isimler.add("Ali");
        isimler.add("Ahmet");
        isimler.add("Mehmet");

        String ilkIsim = isimler.get(0);
        System.out.println(ilkIsim);

        isimler.replaceAll(isim -> isim.toUpperCase());

        System.out.println(isimler); // [ALI, AHMET, MEHMET]

        // isimler listesi için bir ListIterator oluşturun.
        ListIterator<String> isimlerListIterator = isimler.listIterator();

        // Listeyi ileri yönde yineleyin.
        while (isimlerListIterator.hasNext()) {
            String isim = isimlerListIterator.next();
            System.out.println(isim);
        }

        // Listeyi ters yönde yineleyin.
        while (isimlerListIterator.hasPrevious()) {
            String isim = isimlerListIterator.previous();
            System.out.println(isim);
        }

        // isimler listesi için bir iterator oluşturun.
        Iterator<String> isimlerIterator = isimler.iterator();

        while (isimlerIterator.hasNext()) {
            String isim = isimlerIterator.next();
            System.out.println(isim);
        }

        // sort()
        List<Integer> sayilar = new ArrayList<>();
        sayilar.add(5);
        sayilar.add(3);
        sayilar.add(1);

        sayilar.sort((sayi1, sayi2) -> Integer.compare(sayi1, sayi2));

        System.out.println(sayilar); // [1, 3, 5]

        // spliterator()
        List<String> kelimeler = new ArrayList<>();
        kelimeler.add("Java");
        kelimeler.add("Python");
        kelimeler.add("C++");

        Spliterator<String> kelimeSpliterator = kelimeler.spliterator();

        while (kelimeSpliterator.tryAdvance(kelime -> System.out.println(kelime))) {
            // do something with the word
        }

    }
}



