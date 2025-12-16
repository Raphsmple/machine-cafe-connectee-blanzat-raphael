import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineCafe machine = new MachineCafe();
        ArrayList<String> historique = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n====================================");
            System.out.println("      MACHINE À CAFÉ CONNECTÉE ☕");
            System.out.println("====================================");
            System.out.println("1 - Utilisateur");
            System.out.println("2 - Technicien");
            System.out.println("3 - Afficher stocks");
            System.out.println("4 - Historique des cafés");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {

                // MENU UTILISATEUR
                case 1 -> {
                    boolean userMenu = true;
                    while(userMenu) {
                        System.out.println("\n--- MENU UTILISATEUR ---");
                        System.out.println("Crédit disponible : " + String.format("%.2f €", machine.getCredit()));
                        System.out.println("1 - Insérer de la monnaie");
                        System.out.println("2 - Café court (1,50 €)");
                        System.out.println("3 - Café long (2,00 €)");
                        System.out.println("0 - Retour");
                        System.out.print("Votre choix : ");
                        int userChoice = scanner.nextInt();

                        switch(userChoice) {
                            case 1 -> {
                                System.out.print("Montant inséré : ");
                                double montant = scanner.nextDouble();
                                machine.insererMonnaie(montant);
                            }
                            case 2 -> {
                                if(machine.cafeCourt()) historique.add("Café court ☕ servi !");
                            }
                            case 3 -> {
                                if(machine.cafeLong()) historique.add("Café long ☕ servi !");
                            }
                            case 0 -> userMenu = false;
                            default -> System.out.println("Option invalide");
                        }
                    }
                }

                // MENU TECHNICIEN
                case 2 -> {
                    boolean techMenu = true;
                    while(techMenu) {
                        System.out.println("\n--- MENU TECHNICIEN ---");
                        System.out.println("1 - Recharger la machine");
                        System.out.println("2 - Détartrer la machine");
                        System.out.println("3 - Récupérer l'argent");
                        System.out.println("0 - Retour");
                        System.out.print("Votre choix : ");
                        int techChoice = scanner.nextInt();

                        switch(techChoice) {
                            case 1 -> machine.recharger();
                            case 2 -> machine.detartrer();
                            case 3 -> machine.recupererArgent();
                            case 0 -> techMenu = false;
                            default -> System.out.println("Option invalide");
                        }
                    }
                }

                // AFFICHER STOCKS
                case 3 -> machine.afficherEtat();

                // HISTORIQUE
                case 4 -> {
                    System.out.println("\n--- HISTORIQUE DES CAFÉS ---");
                    if(historique.isEmpty()) {
                        System.out.println("Aucun café servi pour l'instant.");
                    } else {
                        for(String h : historique) System.out.println(h);
                    }
                    System.out.println("-----------------------------");
                }

                // QUITTER
                case 0 -> {
                    System.out.println("Merci et à bientôt ! ☕");
                    running = false;
                }

                default -> System.out.println("Option invalide, réessayez.");
            }
        }

        scanner.close();
    }
}
