public class Aapning extends HvitRute {
    public Aapning(int rode, int rekke) {
        super(rode, rekke);
    }
    
    @Override
    public void finn(Rute fra) {
        System.out.print("Funnet aapning i rode: " + rode);
        System.out.println(" rekke: " + rekke);
    }
}
