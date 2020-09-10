package tree;

class dugum {

    String ilAdi;
    int plaka, koordinatx, koordinaty;
    dugum sol, sag;

    dugum(String ilAdi, int plaka, int koordinatx, int koordinaty) {
        this.ilAdi = ilAdi;
        this.plaka = plaka;
        this.koordinatx = koordinatx;
        this.koordinaty = koordinaty;
        sol = null;
        sag = null;
    }

    public void preorder() { //Preorder Sıralama
        System.out.print(plaka + " ");
        if (sol != null) {
            sol.preorder();
        }
        if (sag != null) {
            sag.preorder();
        }
    }

    public void inorder() { //Inorder sıralama
        if (sol != null) {
            sol.inorder();
        }
        System.out.print(plaka + " ");
        if (sag != null) {
            sag.inorder();
        }
    }

    public void postorder() { //Postorder sıralama
        if (sol != null) {
            sol.postorder();
        }
        if (sag != null) {
            sag.postorder();
        }
        System.out.print(plaka + " ");
    }

  /* public void levelorder(dugum kok) { //Levelorder sıralama
        int h = yukseklik(kok);
        for (int i = 1; i <= h; i++) {
            seviyeHesapla(kok, i);
        }
    }*/
    
    int toplam=0;
    public void hesapla(dugum kok) {
        int h = yukseklik(kok);
        for (int i = 1; i <= h; i++) {
            System.out.print(i+". seviyede toplam: ");
            System.out.println(seviyeHesapla(kok, i));
            toplam=0;
        }
    }

    public int yukseklik(dugum kok) { //Ağacın yüksekliğinin hesaplanması
        if (kok == null) {
            return 0;
        } else {
            int solYukseklik = yukseklik(kok.sol);
            int sagYukseklik = yukseklik(kok.sag);

            if (solYukseklik > sagYukseklik) {
                return (solYukseklik + 1);
            } else {
                return (sagYukseklik + 1);
            }
        }
    }
    int donen;
    public int seviyeHesapla(dugum kok, int seviye) { //Seviyenin hesaplanması
        donen=0;
        if (kok == null) {
            return -1;
        }
        if (seviye == 1) {
            toplam+=kok.plaka;
            donen+=toplam;
            //System.out.print(toplam+" ");
            return toplam;
            
        } else if (seviye > 1) {
            seviyeHesapla(kok.sol, seviye - 1);
            seviyeHesapla(kok.sag, seviye - 1);
            
        }
        return toplam;
    }

    int kucukAra() {
        if (sol == null) {
            return this.plaka;
        } else {
            return sol.kucukAra();
        }
    }

    int buyukAra() {

        if (sag == null) {
            return this.plaka;
        } else {
            return sag.buyukAra();
        }
    }
    int eb = 0, eb2 = 0, sayac = 1;

    int dengelimi(dugum kok) { //Ağacın dengeli olup olmadığının hesaplanması
        int solYukseklik = yukseklik(kok.sol);
        int sagYukseklik = yukseklik(kok.sag);
        return sagYukseklik - solYukseklik;
    }

    int enkucukn(int n) { //Ağaçtaki en küçük n. elemanın bulunması
        int h = (yukseklik(sol) + 2) - n;
        int sayacc = 1;
        System.out.println(h);
        dugum tmp = this;

        while (tmp != null) {
            if (sayacc == h) {
                return tmp.plaka;
            } else {
                sayacc++;
                tmp = tmp.sol;
            }
        }
        return -1;
    }

}

class binaryTree {

    dugum kok;

    binaryTree() {
        kok = null;
    }

    public void ekle(dugum yeni) { //Ağaca eleman ekleme işlemi
        if (kok == null) {
            kok = yeni;
        } else {
            dugum tmp = kok;
            dugum once = null;
            while (tmp != null) {
                once = tmp;
                if (yeni.plaka <= tmp.plaka) {
                    tmp = tmp.sol;
                } else {
                    tmp = tmp.sag;
                }
            }
            if (yeni.plaka <= once.plaka) {
                once.sol = yeni;
            } else {
                once.sag = yeni;
            }
        }
    }

    public void arama(int arananPlaka) { //Ağaçta eleman arama işlemi
        dugum tmp = kok;
        while (tmp != null) {
            if (tmp.plaka == arananPlaka) {
                System.out.println("Aranan İl Ağaçta Vardır");
            } else if (arananPlaka <= tmp.plaka) {
                tmp = tmp.sol;
            } else {
                tmp = tmp.sag;
            }
        }
    }

    public void sil(int plaka) { //Ağaçtan eleman silme işlemi
        kok = sil(kok, plaka);
    }

    public dugum sil(dugum kok, int plaka) {

        if (kok == null) {
            return kok;
        }
        if (plaka < kok.plaka) {
            kok.sol = sil(kok.sol, plaka);
        } else if (plaka > kok.plaka) {
            kok.sag = sil(kok.sag, plaka);
        } else {
            if (kok.sol == null) {
                return kok.sag;
            } else if (kok.sag == null) {
                return kok.sol;
            } else {
                kok.plaka = kok.sag.kucukAra();
                kok.sag = sil(kok.sag, kok.plaka);
            }
            return kok;
        }
        return kok;
    }

    public boolean bstmi() { //ağacın Binary Seach Tree olup olmadığına bakma işlemi
        dugum tmp = kok;
        return bstmi(tmp);
    }

    public boolean bstmi(dugum kok) {
        if (kok.sol != null && kok.sag != null) {
            if (kok.sol.plaka > kok.sag.plaka) {
                return false;
            }
            bstmi(kok.sol);
            bstmi(kok.sag);
        }
        return true;
    }

}

public class Tree {

    public static void main(String[] args) {
        dugum d1 = new dugum("a", 21, 1, 1);
        dugum d2 = new dugum("b", 18, 2, 2);
        dugum d3 = new dugum("c", 44, 3, 3);
        dugum d4 = new dugum("d", 17, 4, 4);
        dugum d5 = new dugum("e", 20, 5, 5);
        dugum d6 = new dugum("f", 43, 6, 6);
        dugum d7 = new dugum("g", 15, 7, 7);
        dugum d8 = new dugum("h", 19, 8, 8);
        dugum d9 = new dugum("j", 40, 9, 9);
        dugum d10 = new dugum("k", 9, 9, 9);
        dugum d11 = new dugum("l", 3, 9, 9);
        dugum d12 = new dugum("m", 10, 9, 9);
        dugum d13 = new dugum("n", 1, 9, 9);
        dugum d14 = new dugum("o", 12, 9, 9);
        binaryTree b = new binaryTree();
        b.ekle(d1);
        b.ekle(d2);
        b.ekle(d3);
        b.ekle(d4);
        b.ekle(d5);
        b.ekle(d6);
        b.ekle(d7);
        b.ekle(d8);
        b.ekle(d9);
        b.ekle(d10);
        b.ekle(d11);
        b.ekle(d12);
        b.ekle(d13);
        b.ekle(d14);
        
        System.out.print("Preorder Sıralama: ");
        d1.preorder();
        System.out.println("");
        System.out.print("Inorder Sıralama: ");
        d1.inorder();
        System.out.println("");
        System.out.print("Postorder Sıralama: ");
        d1.postorder();
        System.out.println("");
        System.out.print("Levelorder Sıralama: ");
        //d1.levelorder(d1);
        System.out.println("");
        System.out.print("Ağaç İkili Arama Ağacı Mı: ");
        System.out.println(b.bstmi());
        System.out.println("Ağacın Yaprakları Arasındaki Fark: " + d1.dengelimi(d1));
        if (d1.dengelimi(d1) == 1 || d1.dengelimi(d1) == 0 || d1.dengelimi(d1) == -1) {
            System.out.println("Ağaç Dengeli");
        } else {
            System.out.println("Ağaç Dengeli Değil");
        }System.out.println("************");
        System.out.println(d1.enkucukn(5));
        d1.hesapla(d1);
    }

}
