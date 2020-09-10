package bagliliste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ogrenci {

    int no;
    String ad, soyad, sinif, ayniDers;
    ogrenci ileri;
    ders dersIleri;

    ogrenci(int no, String ad, String soyad, String sinif) {
        this.no = no;
        this.ad = ad;
        this.soyad = soyad;
        this.sinif = sinif;
        ileri = null;
        dersIleri = null;
        ayniDers = null;
    }
}

class ders {

    int dersNo;
    String dersIsim, dersSinif;
    ders dersIleri1;
    ders dersIleri2;
    ders dersIleri3;

    ders(int dersNo, String dersIsim, String dersSinif) {
        this.dersNo = dersNo;
        this.dersIsim = dersIsim;
        this.dersSinif = dersSinif;
        dersIleri1 = null;
        dersIleri2 = null;
        dersIleri3 = null;
    }
}

class odev {

    ders d1, d2, d3, d4, d5;
    ogrenci o1, o2, o3;
    int o1d = 0, o2d = 0, o3d = 0;
    ders o1Ders1;
    ders o1Ders2;
    ders o2Ders1;
    ders o2Ders2;
    ders o3Ders1;
    ders o3Ders2;
    ders o3Ders3;

    void ogrenciAl() throws FileNotFoundException {
        File f = new File("C:\\Users\\msi\\Desktop\\ogrenci.txt");
        Scanner k = new Scanner(f);

        int ogrenciSayac = 0;
        int no;
        String ad, soyad, sinif;
        while (k.hasNextLine()) {
            if (ogrenciSayac == 0) {
                no = Integer.parseInt(k.next());
                ad = k.next();
                soyad = k.next();
                sinif = k.next();
                o1 = new ogrenci(no, ad, soyad, sinif);
                ogrenciSayac++;
            } else if (ogrenciSayac == 1) {
                no = Integer.parseInt(k.next());
                ad = k.next();
                soyad = k.next();
                sinif = k.next();
                o2 = new ogrenci(no, ad, soyad, sinif);
                ogrenciSayac++;
            } else if (ogrenciSayac == 2) {
                no = Integer.parseInt(k.next());
                ad = k.next();
                soyad = k.next();
                sinif = k.next();
                o3 = new ogrenci(no, ad, soyad, sinif);
                ogrenciSayac++;
            }
        }
    }

    void dersAl() throws FileNotFoundException {
        File f = new File("C:\\Users\\msi\\Desktop\\ders.txt");
        Scanner k = new Scanner(f);

        ogrenci o = o1;

        int dersSayac = 0;
        int dersNo = 0;
        String dersIsim = "", dersSinif = "";
        while (k.hasNextLine()) {
            if (dersSayac == 0) {
                dersNo = Integer.parseInt(k.next());
                dersIsim = k.next();
                dersSinif = k.next();
                d1 = new ders(dersNo, dersIsim, dersSinif);

                while (o.ileri != null) {
                    if (o.sinif.equals(dersSinif)) {
                        o.ayniDers = dersIsim;
                    }
                    o = o.ileri;
                }
                o = o1;

                dersSayac++;
            } else if (dersSayac == 1) {
                dersNo = Integer.parseInt(k.next());
                dersIsim = k.next();
                dersSinif = k.next();
                d2 = new ders(dersNo, dersIsim, dersSinif);

                while (o.ileri != null) {
                    if (o.sinif.equals(dersSinif)) {
                        o.ayniDers = dersIsim;
                    }
                    o = o.ileri;
                }
                o = o1;

                dersSayac++;
            } else if (dersSayac == 2) {

                dersNo = Integer.parseInt(k.next());
                dersIsim = k.next();
                dersSinif = k.next();
                d3 = new ders(dersNo, dersIsim, dersSinif);

                while (o.ileri != null) {
                    if (o.sinif.equals(dersSinif)) {
                        o.ayniDers = dersIsim;
                    }
                    o = o.ileri;
                }
                o = o1;
                dersSayac++;
            } else if (dersSayac == 3) {
                dersNo = Integer.parseInt(k.next());
                dersIsim = k.next();
                dersSinif = k.next();
                d4 = new ders(dersNo, dersIsim, dersSinif);

                while (o.ileri != null) {
                    if (o.sinif.equals(dersSinif)) {
                        o.ayniDers = dersIsim;
                    }
                    o = o.ileri;
                }
                o = o1;
                dersSayac++;
            } else if (dersSayac == 4) {
                dersNo = Integer.parseInt(k.next());
                dersIsim = k.next();
                dersSinif = k.next();
                d5 = new ders(dersNo, dersIsim, dersSinif);

                while (o != null) {
                    if (o.sinif.equals(dersSinif)) {
                        o.ayniDers = dersIsim;
                    }
                    o = o.ileri;
                }
                o = o1;
            }
        }
    }

    void dersListele(ogrenci ogrenci) {
        System.out.print("Öğrenci" + ogrenci.no + " alınan dersleri: ");
        ders dersIleri = ogrenci.dersIleri;
        while (dersIleri != null) {
            if (ogrenci.no == 1) {
                System.out.print(dersIleri.dersIsim + " ");
                dersIleri = dersIleri.dersIleri1;
                o1d++;
            } else if (ogrenci.no == 2) {
                System.out.print(dersIleri.dersIsim + " ");
                dersIleri = dersIleri.dersIleri2;
                o2d++;
            } else if (ogrenci.no == 3) {
                System.out.print(dersIleri.dersIsim + " ");
                dersIleri = dersIleri.dersIleri3;
                o3d++;
            } else {
                System.out.println("Aradığın öğrenci bulunamadı.");
            }
        }
        System.out.println("");
    }

    void hepsiniListele() {
        ogrenci o = o1;
        ders dersNext = null;
        ders dersNext1 = o1Ders1;
        ders dersNext2 = o2Ders1;
        ders dersNext3 = o3Ders1;

        int sayac = 0;

        while (o != null) {
            if (sayac == 0) {
                dersNext = dersNext1;
                System.out.print("Öğrenci1 alınan dersler: ");
                while (dersNext != null) {
                    System.out.print(dersNext.dersIsim + " ");
                    dersNext = dersNext.dersIleri1;
                }
            } else if (sayac == 1) {
                dersNext = dersNext2;
                System.out.print("Öğrenci2 alınan dersler: ");
                while (dersNext != null) {
                    System.out.print(dersNext.dersIsim + " ");
                    dersNext = dersNext.dersIleri2;
                }
            } else if (sayac == 2) {
                dersNext = dersNext3;
                System.out.print("Öğrenci3 alınan dersler: ");
                while (dersNext != null) {
                    System.out.print(dersNext.dersIsim + " ");
                    dersNext = dersNext.dersIleri3;
                }
            }
            sayac++;
            o = o.ileri;
            System.out.println(" ");
        }
    }

    void ogrenciDersSirala() {

        o1Ders1 = (o1.dersIleri = d1);
        o1Ders2 = (o1Ders1.dersIleri1 = d2);

        o2Ders1 = (o2.dersIleri = d1);
        o2Ders2 = (o2Ders1.dersIleri2 = d3);

        o3Ders1 = (o3.dersIleri = d2);
        o3Ders2 = (o3Ders1.dersIleri3 = d4);
        o3Ders3 = (o3Ders2.dersIleri3 = d5);
    }

    void enFazla() {
        int[] dizi = new int[3];
        dizi[0] = o1d;
        dizi[1] = o2d;
        dizi[2] = o3d;

        int temp;
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dizi[j] < dizi[j + 1]) {
                    temp = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = temp;
                }
            }
        }
        int eb = dizi[0];
        int ed = 0;
        for (int i = 1; i < 2; i++) {
            if (eb < dizi[i]) {
                eb = dizi[i];
                ed = i + 1;
            }
        }
        System.out.println("Öğrenci1 İsim: " + o1.ad + " " + o1.soyad + "\t" + ". Sınıf:" + o1.sinif + ". No:" + o1.no + "\t Alınan ders: " + dizi[0]);
        System.out.println("Öğrenci2 İsim: " + o2.ad + " " + o2.soyad + "\t" + ". Sınıf:" + o2.sinif + ". No:" + o2.no + ".\t Alınan ders: " + dizi[1]);
        System.out.println("Öğrenci3 İsim: " + o3.ad + " " + o3.soyad + "\t" + ". Sınıf:" + o3.sinif + ". No:" + o3.no + ".\t Alınan ders: " + dizi[2]);
        System.out.println("En Fazla Ders Alan Öğrenci" + (ed) + ". Ders Sayısı: " + eb);
    }
}

public class BagliListe {

    public static void main(String[] args) throws FileNotFoundException {

        odev a = new odev();
        a.ogrenciAl();
        a.o1.ileri = a.o2;
        a.o2.ileri = a.o3;
        a.dersAl();
        a.ogrenciDersSirala();
        a.dersListele(a.o1);
        a.dersListele(a.o2);
        a.dersListele(a.o3);
        System.out.println("**********************************");
        a.hepsiniListele();
        System.out.println("**********************************");
        System.out.println("Öğrenci1 Ortak Sınıfı: " + a.o1.ayniDers);
        System.out.println("Öğrenci2 Ortak Sınıfı: " + a.o2.ayniDers);
        System.out.println("**********************************");

        a.enFazla();
    }
}
