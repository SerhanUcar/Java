package hash;

class dugum {

    int anahtar, deger;

    dugum(int anahtar, int deger) {
        this.anahtar = anahtar;
        this.deger = deger;
    }
}

class chainDugum { //Chain Hash Node

    int anahtar, deger;
    chainDugum ileri;

    chainDugum(int anahtar, int deger) {
        this.anahtar = anahtar;
        this.deger = deger;
        ileri = null;
    }
}

class chainHash { //Chain Hash İşlemleri

    final int diziUzunlugu = 10;
    chainDugum dizi[] = new chainDugum[diziUzunlugu];

    int Hash(int anahtar) {
        return anahtar % diziUzunlugu;
    }

    void ekle(chainDugum d) { //Ekleme işlemi
        int hash = Hash(d.anahtar);
        if (dizi[hash] == null) {
            dizi[hash] = d;
        } else {
            chainDugum tmp = dizi[hash];
            while (tmp.ileri != null) {
                tmp = tmp.ileri;
            }
            tmp.ileri = d;
        }
    }

    void ara(chainDugum d) {//Arama işlemi
        int hash = Hash(d.anahtar);
        if (dizi[hash] == d) {
            System.out.println(d.deger);
        } else {
            chainDugum tmp = dizi[hash];
            while (tmp != d) {
                System.out.print(tmp.deger + " ");
                tmp = tmp.ileri;
            }
            System.out.println(d.deger);
        }
    }

}

class anagram {

    String s;
    char[] dizi;
    int elemanSayisi = 0;
    int indis;

    void ekle(char c) {
        dizi[elemanSayisi] = c;
        elemanSayisi++;
    }

    boolean ara(char c) { //Arama işlemi
        for (int i = 0; i <= elemanSayisi; i++) {
            if (dizi[i] == c) {
                indis = i;
                return true;
            }
        }
        return false;
    }

    void sil(int i) { //Silme işlemi
        char tmp = dizi[elemanSayisi];
        dizi[elemanSayisi] = dizi[i];
        dizi[i] = tmp;
        elemanSayisi--;
    }

    boolean anagrammi(String s1, String s2) { //2 dizi içindeki elemanların anagram olup olmadığını araştırma işlemi
        s = s1;
        dizi = new char[s.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != ' ') {
                ekle(s1.charAt(i));
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != ' ') {
                if (ara(s2.charAt(i))) {
                    sil(indis);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

class altKume { //Verilen bir dizinin, diğer bir dizinin alt kümesi olup olmadığını bulma işlemi

    int[] ustKume;
    int[] altKume;
    int[] hash;
    int hashUzunlugu, elemanSayisi = 0;

    void hashEkle(int[] dizi) {
        hashUzunlugu = dizi.length;
        hash = new int[hashUzunlugu];

        for (int i = 0; i < hashUzunlugu; i++) {
            hash[i % hashUzunlugu] = dizi[i];
        }
    }

    boolean ara(int x) {
        for (int i = 0; i < ustKume.length; i++) {
            if (x == ustKume[i]) {
                ustKume[i] = 0;
                return true;
            }
        }
        return false;
    }

    boolean altKumemi(int[] d1, int[] d2) {
        if (d1.length >= d2.length) {
            ustKume = d1;
            altKume = d2;
        } else {
            ustKume = d2;
            altKume = d1;
        }
        hashEkle(ustKume);

        for (int i = 0; i < altKume.length; i++) {
            if (!ara(altKume[i])) {
                return false;
            }
        }
        return true;

    }
}

class linearProbing { //Linear Probing işlemleri

    final int diziUzunlugu = 10;

    dugum[] dizi = new dugum[diziUzunlugu];

    int Hash(int anahtar) {
        return anahtar % diziUzunlugu;
    }

    void ekle(dugum d, int anahtar) {
        int hash = Hash(anahtar);
        if (dizi[hash] == null) {
            dizi[hash] = d;
        } else {
            ekle(d, anahtar + 1);
        }
    }

    void ara(int anahtar, int deger) {
        int hash = Hash(anahtar);
        if (dizi[hash].deger != deger) {
            ara(anahtar + 1, deger);
        } else {
            System.out.println(hash + ". elemanının değeri aranan değer: " + deger);
        }
    }

    void yazdir() {
        for (int i = 0; i < diziUzunlugu; i++) {
            if (dizi[i] == null) {
                System.out.print("0 ");
            } else {
                System.out.print(dizi[i].deger + " ");
            }
        }
    }

}

public class Hash {

    public static void main(String[] args) {
        linearProbing l = new linearProbing();
        dugum d1 = new dugum(1, 1231);
        dugum d2 = new dugum(5, 2222);
        dugum d3 = new dugum(3, 3333);
        dugum d4 = new dugum(7, 4444);
        dugum d5 = new dugum(6, 5777);
        dugum d6 = new dugum(6, 4343);
        dugum d7 = new dugum(8, 4545);
        dugum d8 = new dugum(9, 3535);
        l.ekle(d1, d1.anahtar);
        l.ekle(d2, d2.anahtar);
        l.ekle(d3, d3.anahtar);
        l.ekle(d4, d4.anahtar);
        l.ekle(d5, d5.anahtar);
        l.ekle(d6, d6.anahtar);
        l.ekle(d7, d7.anahtar);
        l.ekle(d8, d8.anahtar);
        l.yazdir();
        System.out.println(" ");
        l.ara(d8.anahtar, d8.deger);

        chainDugum cd1 = new chainDugum(6, 5777);
        chainDugum cd2 = new chainDugum(6, 5888);
        chainDugum cd3 = new chainDugum(6, 5999);
        chainHash ch = new chainHash();
        ch.ekle(cd1);
        ch.ekle(cd2);
        ch.ekle(cd3);
        ch.ara(cd2);
        anagram a = new anagram();
        altKume al=new altKume();
        int dizi1[]={1,2,3};
        int dizi2[]={1,2,4,5};
        System.out.println(a.anagrammi("acefdb", "abcdef"));
        System.out.println(al.altKumemi(dizi1,dizi2));
    }

}
