import java.util.ArrayList;
import java.util.Scanner;

public class Startscherm {
    Scanner scanner = new Scanner(System.in);
    private int keuze;
    private String teamT;
    private String teamU;
    private int no;
    private int no1;
    private String keuzeString;
    private FAQ faq;
    private Ontvanger ontvanger;
    private Wedstrijd game;
    private String datum;
    private ArrayList<String> spelersT = new ArrayList<>();
    private ArrayList<String> spelersU = new ArrayList<>();

    public Startscherm(){
        this.faq = new FAQ();
        this.game = new Wedstrijd();
    }

    public void Menu(){
        System.out.println("1) Team toevoegen");
        System.out.println("2) Teams weergeven");
        System.out.println("3) Scorebord");
        System.out.println("4) Verzenden naar de basketbalbond");
        System.out.println("5) FAQ");
        System.out.print("Welkom in het startscherm, kies uw optie: ");
        keuze = scanner.nextInt();
        switch(keuze) {
            case 1:
                addTeam();
                break;
            case 2:
                printTeam();
                break;
            case 3:
                printScore();
            case 4:
                checkGame();
                break;
            case 5:
                printFAQ();
                break;

            default:
                throw new IllegalStateException("Keuze is niet mogelijk");
        }
    }

    private void checkGame() {
        if(spelersT.isEmpty() && spelersU.isEmpty()){
            System.out.println("Er kan geen gegevens verzonden worden!");
            Menu();
        }
        System.out.print("Wat is de datum vandaag (dd-mm-jjjj): ");
        datum = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Thuis team: " + teamT);
        for (int i = 0; i < spelersT.size(); i++) {
            System.out.println(spelersT.get(i));
        }
        System.out.println();
        System.out.println("Uit team: " + teamU);
        for (int i = 0; i < spelersU.size(); i++) {
            System.out.println(spelersU.get(i));
        }
        System.out.println("Datum: " + datum);
        System.out.println("Gegevens zijn succesvol verstuurd naar: " + ontvanger.getEmail());
        keuzeString = scanner.nextLine();
        System.out.println("Klik op 0 om terug te gaan naar het startscherm: ");
        keuzeString = scanner.nextLine();
        if (keuzeString.equals("0")) {
            Menu();
        } else {
            System.out.println("Gegevens zijn al verstuurd!");
            Menu();
        }
    }

    private void printScore() {
        game.getScore();
        keuzeString = scanner.nextLine();
        System.out.println("Klik op 0 om terug te gaan naar het startscherm: ");
        keuzeString = scanner.nextLine();
        if (keuzeString.equals("0")) {
            Menu();
        } else {
            System.out.println("Wedstrijd is geëindigd!");
            Menu();
        }

    }

    public void addTeam(){
        System.out.print("Voer hier de naam van het thuis team in: ");
        scanner.nextLine();
        teamT = scanner.nextLine();
        System.out.print("Vul hier de aantal spelers in: ");
        no = scanner.nextInt();

        for (int i = 0; i< no; i++){
            System.out.print("Voornaam van speler " + (i+1) + ": ");
            spelersT.add(scanner.next());

        }
        System.out.println("Thuis team succesvol toegevoegd!");
        System.out.println();
        System.out.print("Voer hier de naam van het uit team in: ");
        scanner.nextLine();
        teamU = scanner.nextLine();
        System.out.print("Vul hier de aantal spelers in: ");
        no1 = scanner.nextInt();

        for (int i = 0; i< no1; i++){
            System.out.print("Voornaam van speler " + (i+1) + ": ");
            spelersU.add(scanner.next());
        }
        System.out.println("Uit team succesvol toegevoegd!");
        System.out.println("Klik op 0 om terug te gaan naar het startscherm: ");
        scanner.nextLine();
        keuzeString = scanner.nextLine();
        if(keuzeString.equals("0")){
            Menu();
        }
        else{
            System.out.println("U kunt maximaal 2 teams toevoegen!");
            Menu();
        }
    }


    public void printTeam(){
        if(spelersT.isEmpty() && spelersU.isEmpty()) {
            System.out.println("De thuis- en uitteam zijn leeg!");
            Menu();
        }else {
            System.out.println("Thuis team: " + teamT);
            for (int i = 0; i < spelersT.size(); i++) {
                System.out.println(spelersT.get(i));
            }
            System.out.println();
            System.out.println("Uit team: " + teamU);
            for (int i = 0; i < spelersU.size(); i++) {
                System.out.println(spelersU.get(i));
            }
            keuzeString = scanner.nextLine();
            System.out.println("Klik op 0 om terug te gaan naar het startscherm: ");
            keuzeString = scanner.nextLine();
            if (keuzeString.equals("0")) {
                Menu();
            } else {
                System.out.println("Teams zijn al weergegeven!");
                Menu();
            }
        }
    }

    public void printFAQ() {
        System.out.println("Meest gestelde vragen: ");
        faq.printVraag();
        keuzeString = scanner.nextLine();
        System.out.print("Klik op 0 om terug te gaan naar het startscherm en een ander getal om nog een vraag te beantwoorden: ");
        keuzeString = scanner.nextLine();
        if(keuzeString.equals("0")){
            this.Menu();
        }
        else{
            printFAQ();
        }
    }

}
