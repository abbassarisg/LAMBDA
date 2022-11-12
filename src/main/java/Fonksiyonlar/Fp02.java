package Fonksiyonlar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {
    /*
    1)  t-> "Logic", (t,u)-> "Logic"
      Bu yapıya "Lamda Expession"

    2) Functional Programming kapsamında  "Lampda Expession" kullanilabilir ama önerilmez.
       "Lampda Expession" yerine "Method Reference" tercih edilir.

    3) "Method Reference" kullanimi "Class Name :: Method Name"
        ayni zamanda kendi classlarimizda kullanabiliriz.

        Ornek: Bir animal class var ve bu class ın eat diye methodu sahip olsun
             "Animal::eat"


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

        listElemanlariniYazdirFunctional(liste);
        System.out.println();

        ciftElmanlariYazdirStructured(liste);
        System.out.println();

        tekElemanlarinKareleriniYazdir(liste);
        System.out.println();

       tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();
      tekrarsizCiftElemanlarinKareToplami(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami02(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami03(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKupleriniCarpimi(liste);
        getMaxEleman(liste);
        getMaxEleman2(liste);
        yedidenBuyukCiftMin(liste);
        terSiralamaylaTekrarsizElemanlarinYarisi(liste);


    }
    //1) Ardışık list elemanlarını aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional ve method reference)

    public static void listElemanlariniYazdirFunctional(List<Integer>list){
        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
//2)Ardışık çift list elementlerini aynı satırda aralarında boşluk
// bırakarak yazdıran bir method oluşturun.(Functional)

    public static void ciftElmanlariYazdirStructured(List<Integer>list){
        list.stream().filter(Utils::ciftElemanlariSec).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    //3) Ardışık tek list elemanlarının karelerini aynı satırda
    // aralarında boşluk bırakarak yazdıran bir method oluşturun.(Functional)

    public static void tekElemanlarinKareleriniYazdir(List<Integer>list){
        list.stream().
                filter(Utils::tekElemanlariSec).
                map(Utils::karesiniAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    //4) Ardışık tek list elemanlarının küplerini tekrarsız olarak aynı
    // satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer>list){
        list.stream().
                distinct().
                filter(Utils::tekElemanlariSec).
                map(Utils::kupunuAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    // tekrarsiz cift elemanlarin karelerini toplamını hesaplayan bir method oluşturun

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer>list){
     Integer toplam= list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::karesiniAl).reduce(0,Math::addExact);

        System.out.println(toplam);
    }
//2. yol
    public static void tekrarsizCiftElemanlarinKareToplami02(List<Integer>list){
        Integer toplam= list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::karesiniAl).reduce(Math::addExact).get();
        System.out.println(toplam);
    }
    public static void tekrarsizCiftElemanlarinKareToplami03(List<Integer>list){
        Integer toplam= list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::karesiniAl).reduce(0,Integer::sum);
        System.out.println(toplam);

    }

    public static void tekrarsizCiftElemanlarinKupleriniCarpimi(List<Integer>list){
        Integer toplam=list.stream().distinct().filter(Utils::ciftElemanlariSec).map(Utils::kupunuAl).reduce(1,Math::multiplyExact);

        System.out.println(toplam); }

    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.

    public static void getMaxEleman(List<Integer>list){
       Integer max= list.stream().distinct().reduce(Integer.MIN_VALUE,Math::max);
        System.out.println(max);

    }
    public static void getMaxEleman2(List<Integer>list){
        Integer max= list.stream().distinct().reduce(Math::max).get();
        System.out.println(max);

    }
    //9) List elemanları arasından 7'den büyük, çift, en küçük değeri bulan bir method oluşturun.

    public static void yedidenBuyukCiftMin(List<Integer>list){
      Integer min= list.stream().distinct().filter(t->t>7).filter(Utils::ciftElemanlariSec).reduce(Math::min).get();

        System.out.println(min); }


    //10) Ters sıralama ile tekrarsız ve 5'ten büyük elemanların
    // yarı değerlerini(elamanın ikiye bölüm sonucunu) bulan bir method oluşturun.

    public static void terSiralamaylaTekrarsizElemanlarinYarisi (List<Integer>list){

        List<Double> sonuc= list.
                stream().//Gerekli metodlari kullanmamizi saglar
                distinct().//tekrarli olanlari almaz
                filter(t->t>5).//kosula gore filtreleme yapar
                map(Utils::yarisiniAl).//herbir elemanin degerini degistirmeye yarar
                sorted(Comparator.reverseOrder()).//siralama yapar
                collect(Collectors.toList());//Elemanlari collection'a cevirir

        System.out.println(sonuc);
        System.out.println("guzel");
    }



}
