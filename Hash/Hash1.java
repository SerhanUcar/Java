package Hash1;

class dugum {

    int no;
    dugum ileri;

    dugum(int no) {
        this.no = no;
        ileri = null;
    }
}

class ChainHash { //Chain Hash1 türünde işlemler

    dugum[] hash;

    ChainHash() {
        hash = new dugum[10];
    }

    int sifrele(int n) {
        int sifre = n % hash.length;
        return sifre;
    }

    void ekle(dugum d) {
        int sifre = sifrele(d.no);
        if (hash[sifre] == null) {
            hash[sifre] = d;
        } else {
            dugum tmp = hash[sifre];
            while (tmp.ileri != null) {
                tmp = tmp.ileri;
            }
            tmp.ileri = d;

        }
    }

}

class LinearProbing { //Linear Probing türünde işlemler

    int[] linear;

    LinearProbing() {
        linear = new int[10];
    }

    int sifrele(int n) {
        int sifre = n % linear.length;
        return sifre;
    }

    void ekle(dugum d) {
        int sifre = sifrele(d.no);
        if (linear[sifre] == 0) {
            linear[sifre] = d.no;
        } else {
            for (int i = 1; i < linear.length; i++) {
                if (linear[sifre + i % linear.length] == 0) {
                    linear[sifre + (i % linear.length)] = d.no;
                    break;
                }

            }
        }
    }
}
class AgacDugum{
    char c;
    int no;
    AgacDugum sol,sag;
    
    AgacDugum(char c,int no){
        this.c=c;
        this.no=no;
        sol=null;
        sag=null;
    }
}
class Agac {
    AgacDugum kok;
    Agac(){
        kok=null;
    }
    void ekle(AgacDugum d){ 
        if (kok==null) {
            kok=d;
        }
        else{
            AgacDugum tmp=kok;
            AgacDugum once=null;
            while(tmp!=null){
                once=tmp;
                if (d.no<=tmp.no) {
                    tmp=tmp.sol;
                }
                else{
                    tmp=tmp.sag;
                }
            }
            if (d.no<once.no) {
                once.sol=d;
            }
            else{
                once.sag=d;
            }
        }
    }
    
    void sil(char k){ 
        AgacDugum tmp=kok;
        AgacDugum once=null;
        while(tmp.c!=k){
            once=tmp;
            if (k<tmp.c) {
                tmp=tmp.sol;
            }
            else tmp=tmp.sag;
        }
        
        if (tmp.sol==null && tmp.sag==null) {
            if (tmp.c<once.c) {
                once.sol=null;
            }
            else once.sag=null;
        }
    }
}

public class Hash1 {

    public static void main(String[] args) {
        dugum d1 = new dugum(76);
        dugum d2 = new dugum(93);
        dugum d3 = new dugum(40);
        dugum d4 = new dugum(47);
        dugum d5 = new dugum(10);
        dugum d6 = new dugum(3);
        dugum d7 = new dugum(17);
        dugum d8 = new dugum(66);
        dugum d9 = new dugum(5);

        ChainHash c = new ChainHash();
        c.ekle(d1);
        c.ekle(d2);
        c.ekle(d3);
        c.ekle(d4);
        c.ekle(d5);
        c.ekle(d6);
        c.ekle(d7);
        c.ekle(d8);
        c.ekle(d9);

        LinearProbing l = new LinearProbing();
        l.ekle(d1);
        l.ekle(d2);
        l.ekle(d3);
        l.ekle(d4);
        l.ekle(d5);
        l.ekle(d6);
        l.ekle(d7);
        l.ekle(d8);
        l.ekle(d9);
        
        for (int i = 0; i < 10; i++) {
            if (c.hash[i] != null) {
                if (c.hash[i].ileri == null) {
                    System.out.println(c.hash[i].no + " ");
                } else {
                    dugum tmp = c.hash[i];
                    while (tmp != null) {
                        System.out.print(tmp.no + " ");
                        tmp = tmp.ileri;
                    }
                    System.out.println("");
                }
            }
        }
        System.out.println("*****************");
        for (int i = 0; i < 10; i++) {
            System.out.print(l.linear[i] + " ");
        }
    }
}
