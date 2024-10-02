import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Labyrint {
    private Rute[][] labyrint;
    private File fil;
    private Scanner leser;
    private int roder;
    private int rekker;
    
    public Labyrint (String filnavn) {
        fil = new File(filnavn);
                
        try {
            leser = new Scanner(fil);
        }
        
        catch (FileNotFoundException unntak) {
			System.out.println("Fant ikke filen: "+ unntak);
			return;
		}
        
        String linje = leser.nextLine();
        String[] linjeliste = linje.split(" ");
        roder = Integer.parseInt(linjeliste[0]);
        rekker = Integer.parseInt(linjeliste[1]);
        labyrint = new Rute[roder][rekker];
        
        for (int rode = 0 ; rode < roder ; rode++) {
            linje = leser.nextLine();
            String[] linjeliste2 = linje.split("");
            
            for (int rekke = 0 ; rekke < rekker ; rekke++) {
                if (linjeliste2[rekke].equals("#")) {
                    SortRute ny = new SortRute(rode, rekke);
                    labyrint[rode][rekke] = ny;
                    this.settNaboer(ny, rode, rekke);
                }
                
                if (linjeliste2[rekke].equals(".")) {
                    if (rode == 0 || rode == roder - 1 || rekke == 0 || rekke == rekker - 1) {
                        Aapning ny = new Aapning(rode, rekke);
                        labyrint[rode][rekke] = ny;
                        this.settNaboer(ny, rode, rekke);
                    }
                    
                    else {
                        HvitRute ny = new HvitRute(rode, rekke);
                        labyrint[rode][rekke] = ny;
                        this.settNaboer(ny, rode, rekke);
                    }
                }
            }
        }
    }
    
    protected void settNaboer(Rute ny, int rode, int rekke) {
        if (rekke != 0) {
            ny.settForrige(labyrint[rode][rekke - 1]);
            ny.forrige().settNeste(ny);
        }
            
        if (rode != 0) {
            ny.settOver(labyrint[rode - 1][rekke]);
            ny.over().settUnder(ny);
        }
    }
    
    public void finnUtveiFra(int rad, int kol) throws Exception {
        if (rad < 0 || rad > roder || kol < 0 || kol > roder) {
            throw new Exception("Ugyldige kordinater.");
        }
        
        else {
            System.out.print("Leter etter utvei(er) fra rode: " + rad);
            System.out.println(" rekke: " + kol);
            labyrint[rad][kol].finn(null);
        }
        this.nullstill();
    }
    
    private void nullstill() {
        for (int rode = 0 ; rode < roder ; rode++) {
            for (int rekke = 0 ; rekke < rekker ; rekke++) {
                labyrint[rode][rekke].nullstill();
            }
        }
    }
    
    @Override
    public String toString() {
        String streng = "";
        for (int r = 0 ; r < roder ; r++) {
            for (int re = 0 ; re < rekker ; re++) {
                streng += labyrint[r][re].toString();
            }
            streng += "\n";
        }
        return streng;
    }
}
