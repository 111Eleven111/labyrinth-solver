import java.util.ArrayList;

public abstract class Rute {
    protected int rode;
    protected int rekke;
    protected Rute neste;
    protected Rute forrige;
    protected Rute over;
    protected Rute under;
    protected Labyrint labyrint;
    protected boolean besokt = false;
    protected ArrayList<Rute> besokte = new ArrayList<>();
    
    public Rute(int rode, int rekke) {
        this.rode = rode;
        this.rekke = rekke;
    }
    
    public void finn(Rute fra) {
        besokt = true;
        if (fra == null) {
            neste.finn(this); forrige.finn(this); over.finn(this); under.finn(this);
        }
        
        else {
            int[] kordinater = fra.hentKordinater();
        
        
            if (neste != null && neste.besokt == false) {
                neste.finn(this);
            }
            
            if (forrige != null && forrige.besokt == false) {
                forrige.finn(this);
            }
            
            if (over != null && over.besokt == false) {
                over.finn(this);
            }
            
            if (under != null && under.besokt == false) {
                under.finn(this);
            }
        }
    }
    
    public void settForrige(Rute rute) {
        forrige = rute;
    }
    
    public void settNeste(Rute rute) {
        neste = rute;
    }
    
    public void settOver(Rute rute) {
        over = rute;
    }
    
    public void settUnder(Rute rute) {
        under = rute;
    }
    
    public Rute neste() {
        return neste;
    }
    
    public Rute forrige() {
        return forrige;
    }
    
    public Rute over() {
        return over;
    }
    
    public Rute under() {
        return under;
    }
    
    protected int[] hentKordinater() {
        int[] kordinater = {rode, rekke};
        return kordinater;
    }
    
    public void nullstill() {
        besokt = false;
    }
    
    //protected boolean erNy(Rute nabo, int annenRode, int annenRekke) {
        //if (rode == annenRode && rekke == annenRekke) {
            //for (Rute tidligereRute : besokte) {
                //if (tidligereRute.equals(nabo)) {
                    //return false;
                //}
            //}
            //return false;
        //}
        
        //else {
            //besokte.add(this);
            //return true;
        //}
    //}
    
    @Override
    public boolean equals(Object annen) {
        if (annen instanceof Rute) {
            Rute annenRute = (Rute) annen;
            if (annenRute.rode == rode && annenRute.rekke == rekke) {
                return true;
            }
        }
        
        return false;
    }
}
