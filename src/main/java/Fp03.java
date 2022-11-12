package lamda_functional_programming01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {
    public static void main(String[] args) {
        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);

        buyukHarfleYazdir(liste);
        System.out.println();
    //    buyukHarfleYazdir02(liste);
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugaGoreTersYazdir(liste);
        System.out.println();
        sonKaraktereGoreTekrarsizSirala(liste);
        System.out.println();

        uzunlukVeIlkHarfeGoreSiralaYazdir(liste);

        System.out.println();
        uzunlukVeIlkHarfeGoreSiralaYazdir2(liste);
        System.out.println();
      //  uzunluguBestenBuyukleriSil(liste);

       // baslangiciAYadaSonuNOlaniSil(liste);
        //baslangiciAYadaSonuNOlaniSil02(liste);

        uzunlugu8ile10arasiveOileBiteniSil(liste);
    }

//1. Yol
    //1) Tüm elemanları büyük harf ile yazdıran bir method oluşturun.
    public static void buyukHarfleYazdir(List<String>list){

        list.stream().map(String::toUpperCase).forEach(Utils::ayniSatirdaBosluklaYazdir);

    }
  //  public  static void buyukHarfleYazdir02(List<String>list){
  //      list.replaceAll(String::toUpperCase);
   //     System.out.println(list);
   // }


    //2) Elemanları uzunluklarına göre sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugaGoreYazdir(List<String>list){
        list.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);//Comparator.comparing() : siralam kosulunu belirtmek icin kullanilir
    }
//3) Elemanları uzunluklarına göre ters sıralayıp yazdıran bir method oluşturun.

    public static void uzunlugaGoreTersYazdir(List<String>list){
        list.
                stream().
                sorted(Comparator.comparing(String::length).reversed()).
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
//4) Elemanları son karakterlerine göre sıralayıp tekrarsız yazdıran bir method oluşturun

    public static void sonKaraktereGoreTekrarsizSirala(List<String >list){
       list.stream().distinct().sorted(Comparator.comparing(Utils::sonKarakteriAl)).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    //5) Elemanları önce uzunluklarına göre ve sonra ilk karakterine göre
    // sıralayıp yazdıran bir method oluşturun

    public static void uzunlukVeIlkHarfeGoreSiralaYazdir(List<String>list){
        list.stream().
                sorted(Comparator.comparing(String::length).
                        thenComparing(t->t.charAt(0))).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    public static void uzunlukVeIlkHarfeGoreSiralaYazdir2(List<String>list){
        list.stream().
                sorted(Comparator.comparing(String::length).
                        thenComparing(Utils::ilkKarakteriAl)).//thenComparing() :==>siralam icin bir kosul daha belirtir
                forEach(Utils::ayniSatirdaBosluklaYazdir);
    }
    //6) Uzunluğu 5'ten büyük olan elemanları silen bir method oluşturun.

  //  public static void uzunluguBestenBuyukleriSil(List<String>list){

    //    list.removeIf(t->t.length()>5);   //list mutable oldugu icin degisecek(elemanlari silinecek)
     //   System.out.println(list);         //bundan dolayi yoruma aldik
 //   }

    //7) ‘A’, ‘a’ ile başlayan yada ‘N’, ‘n’ ile biten elemanları silen bir method oluşturun.

   /* public static void baslangiciAYadaSonuNOlaniSil(List<String>list){
        list.removeIf(t->t.charAt(0)=='A'||t.charAt(0)=='a'||t.charAt(t.length()-1)=='N'||t.charAt(t.length()-1)=='n');

        System.out.println(list);
    }*/

 /*   public static void baslangiciAYadaSonuNOlaniSil02(List<String>list) {

        list.removeIf(t -> t.startsWith("A") || t.startsWith("a") || t.endsWith("N") || t.endsWith("n"));

        System.out.println(list);
    }

  */

//8) Uzunluğu 8 ile 10 arası olan yada '0' ile biten elemanları silen bir method oluşturun.

    public static void uzunlugu8ile10arasiveOileBiteniSil(List<String >list){

        list.removeIf(t->(t.length()>7 && t.length()<11)|| t.endsWith("O")||t.endsWith("o"));
        System.out.println(list);
    }
}
