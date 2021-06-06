import java.util.Scanner;

public class Wedstrijd {
    private String keuze;
    private int aantal;
    private int scoreT;
    private int scoreU;
    Scanner scanner = new Scanner(System.in);

    /**
     * Normaal gesproken kan de tafelaar op de tablet direct klikken welk team heeft gescoord
     * In intelliJ heb ik zo gedaan dat de gebruiker t (thuisteam) / u (uitteam) invoert
     * en dan de hoeveelheid punten toevoegt aan de team.
     */

    public void getScore() {
        System.out.println("Wedstrijd is begonnen!");
       for(int i = 0 ; i < 10; i++) {
           System.out.println("Welk team heeft er gescoord t/u: ");
           keuze = scanner.nextLine();
            scanner.nextLine();
           if (keuze.equals("t")) {
               System.out.println("Hoeveel punten zijn er gescoord door het thuisteam: ");
               aantal = scanner.nextInt();
               scoreT += aantal;
           } else {
               System.out.println("Hoeveel punten zijn er gescoord door het uitteam: ");
               aantal = scanner.nextInt();
               scoreU += aantal;
           }
       }
        System.out.println("Eindstand: " + scoreT + " - " + scoreU);
       if(scoreT > scoreU){
           System.out.println("Thuisteam heeft gewonnen!");
       }
       else{
           System.out.println("Uitteam heeft gewonnen!");
       }
    }
}








