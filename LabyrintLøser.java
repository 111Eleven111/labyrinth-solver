import java.util.Scanner;

public class LabyrintLøser {
    private static Scanner leser;
    private static String input = "";
    
    public static void main(String[] args) {
        Labyrint labyrint = new Labyrint(args[0]);
        System.out.println("Slik ser labyrinten ut: ");
        System.out.println(labyrint);
        leser = new Scanner(System.in);
        String[] kordinater;
        
        while (!input.equals("q")) {
            System.out.println("Skriv inn koordinater <rode> <rekke> ('q' for aa avslutte)");
            System.out.print(">");
            input = leser.nextLine();
            
            if (!input.equals("q")) {
                kordinater = input.split(" ");
                
                try {
                    labyrint.finnUtveiFra(Integer.parseInt(kordinater[0]), Integer.parseInt(kordinater[1]));
                    kordinater = null;
                    }
        
                catch (Exception e) {
                    System.out.println(e);
                }
            }
            System.out.println("...");
            System.out.println();
        }
    }
}
    
