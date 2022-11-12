package Fonksiyonlar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    /*
    Lamda (Functional Programming) Java 8 ile kullanilmaya baslanmistir


   1)  Functional Programming "Ne yapılacak" (What to do) üzerine yogunlasir

   2)  Structure Programming "Nasıl Yapılacak" (How to do) uzerine yogunlasir

   3) Functional Programming, Arrays ve Collections ile kullanilir

   4) "enrtySet() methodu ile Map, Set'e donusturulerek Functional Programming'de kullanilir.
     */
    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);
        listElemanlariniYazdirStructured(liste);
        System.out.println();

        listElemanlariniYazdirFunctional(liste);
        System.out.println();

        ciftelmanlariYazdirStructured(liste);
        System.out.println();
        ciftelmanlariYazdirFunctional(liste);
        System.out.println();
        tekElemanlarinkareleriniYazdir(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();

        List<String> urunler= new ArrayList<>();
        urunler.add("Nutella");
        urunler.add("Ikram");
        urunler.add("Cekirdek");
        urunler.add("Cay");
        urunler.add("Cay");
        String str="Nutella";
        String[] arr=str.split("");

        System.out.println();
        Arrays.stream(arr).distinct().forEach(t-> System.out.print(t+" "));

        System.out.println();

       urunler.stream().distinct().forEach(t-> System.out.print(t+" "));
        System.out.println();

        tekrarsizCiftElemanlarinKareToplami(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKupununCarpimi(liste);
        System.out.println();
        getMaxEleman(liste);
        System.out.println();
        getMaxEleman2(liste);
        System.out.println();
        getYedidenBuyukCiftMin(liste);
        System.out.println();
        getYedidenBuyukCiftMin2(liste);
        System.out.println();
        getYedidenBuyukCiftMin3(liste);
        System.out.println();
        getTersSiralamaTekrarsizElemanlarinYarisi(liste);



    }
    //1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Structured)

    public static void listElemanlariniYazdirStructured(List<Integer> list) {
        for (Integer w : list) {

            System.out.print(w + " ");

        }

    }


    //1)Ardışık list elementlerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {
        System.out.print("Functional: ");
        list.stream().forEach(t -> System.out.print(t + " "));// t(bizbelirttik y de olabilir baska birseyde) listen alinan eleman
// stream() methodu collection elementleri akışa dahil etmek vemethodlara ulasmak icin kulanilir
    }


    //2)Çift list elementlerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Structured)

    public static void ciftelmanlariYazdirStructured(List<Integer> list) {

        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }


    }

    //2)Çift list elemanlarini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)

    public static void ciftelmanlariYazdirFunctional(List<Integer>list){
        System.out.print("Functional: ");
        list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
    }
    //3) Ardışık tek list elementlerinin karelerini aynı satırda aralarında
    // boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekElemanlarinkareleriniYazdir(List<Integer> list){
        System.out.print("Functional: ");
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));
                //elemanlarin degerleri degisecekse map() methodu kullanilir

    }

//4) Ardışık tek list elementlerinin küplerini tekrarsız olarak aynı
// satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer>list){
        System.out.print("Functional: ");
        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    }

    //5) Tekrarsız çift elementlerin karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list){
        Integer toplam=list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(1,(t,y)->t*y);
        System.out.println(toplam);

    }
    public  static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer>list){
        Integer carpim=list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);

        System.out.println(carpim); }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.

    public static  void getMaxEleman(List<Integer>list){
       Integer max= list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u ? t:u);// t baslangic value onu belirtmemmi lazım
       //Integer max= list.stream().distinct().reduce(list.get(0),(t,u)->t>u ? t:u);
        System.out.println(max);
    }
    public static  void getMaxEleman2(List<Integer>list){
       Integer max2= list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println(max2);
    }
    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.

    public static void getYedidenBuyukCiftMin(List<Integer> list){
        Integer min=list.
                stream().
                distinct().
                filter(t->t%2==0).filter(t->t>7).
                reduce(Integer.MAX_VALUE,(t,u)->t<u ?t:u);
        System.out.println(min);
    }
    //2. Yol:

    public static void getYedidenBuyukCiftMin2(List<Integer>list){
       Integer min2= list.
               stream().
               distinct().
               filter(t->t%2==0).
               filter(t->t>7).
               sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t,u)->u);

        System.out.println(min2);
    }

    public static  void getYedidenBuyukCiftMin3(List<Integer>list){
      Integer min3=  list.stream().filter(t->t%2==0).filter(t->t>7).sorted().findFirst().get();
        System.out.println(min3);

    }
    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların yarı
    // değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.


    public static  void getTersSiralamaTekrarsizElemanlarinYarisi(List<Integer>list){
     List<Double> list1=  list.stream().distinct().filter(t->t>5).map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(list1);
    }
}
