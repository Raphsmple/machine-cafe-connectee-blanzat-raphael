public class MachineCafe {

    private static final int MAX_EAU = 100;
    private static final int MAX_GRAINS = 50;
    private static final int MAX_GOBELETS = 10;
    private static final int LIMITE_USURE = 5;

    private static final double PRIX_CAFE_COURT = 1.50;
    private static final double PRIX_CAFE_LONG = 2.00;

    private int eau;
    private int grains;
    private int gobelets;

    private int nbCafesServis;
    private boolean horsService;

    private double monnayeur;
    private double caisse;

    public MachineCafe() {
        this.eau = MAX_EAU;
        this.grains = MAX_GRAINS;
        this.gobelets = MAX_GOBELETS;

        this.nbCafesServis = 0;
        this.horsService = false;

        this.monnayeur = 0.0;
        this.caisse = 0.0;
    }

    // Ajouter de la monnaie
    public void insererMonnaie(double montant) {
        monnayeur += montant;
        System.out.printf("Crédit actuel : %.2f €\n", monnayeur);
    }

    // Getter pour le crédit
    public double getCredit() {
        return monnayeur;
    }

    // Afficher l'état de la machine
    public void afficherEtat() {
        System.out.println("\n--- ÉTAT DE LA MACHINE ---");
        System.out.println("Eau : " + eau + " cl");
        System.out.println("Grains : " + grains + " g");
        System.out.println("Gobelets : " + gobelets);
        System.out.println("Cafés servis : " + nbCafesServis);
        System.out.printf("Crédit : %.2f €\n", monnayeur);
        System.out.println("--------------------------\n");
    }

    // Servir café court
    public boolean cafeCourt() {
        if(horsService || nbCafesServis >= LIMITE_USURE) {
            horsService = true;
            System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
            return false;
        }

        if(monnayeur < PRIX_CAFE_COURT) {
            System.out.println("Crédit insuffisant, ajoutez de la monnaie");
            return false;
        }

        if(eau < 10) {
            System.out.println("Erreur : Plus assez d'eau !");
            return false;
        }
        if(grains < 10) {
            System.out.println("Erreur : Plus assez de grains !");
            return false;
        }
        if(gobelets < 1) {
            System.out.println("Erreur : Plus de gobelets !");
            return false;
        }

        eau -= 10;
        grains -= 10;
        gobelets -= 1;

        monnayeur -= PRIX_CAFE_COURT;
        caisse += PRIX_CAFE_COURT;
        nbCafesServis++;

        System.out.println("Votre café court est prêt !");
        return true;
    }

    // Servir café long
    public boolean cafeLong() {
        if(horsService || nbCafesServis >= LIMITE_USURE) {
            horsService = true;
            System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
            return false;
        }

        if(monnayeur < PRIX_CAFE_LONG) {
            System.out.println("Crédit insuffisant, ajoutez de la monnaie");
            return false;
        }

        if(eau < 20) {
            System.out.println("Erreur : Plus assez d'eau !");
            return false;
        }
        if(grains < 10) {
            System.out.println("Erreur : Plus assez de grains !");
            return false;
        }
        if(gobelets < 1) {
            System.out.println("Erreur : Plus de gobelets !");
            return false;
        }

        eau -= 20;
        grains -= 10;
        gobelets -= 1;

        monnayeur -= PRIX_CAFE_LONG;
        caisse += PRIX_CAFE_LONG;
        nbCafesServis++;

        System.out.println("Votre café long est prêt !");
        return true;
    }

    // Recharger la machine
    public void recharger() {
        eau = MAX_EAU;
        grains = MAX_GRAINS;
        gobelets = MAX_GOBELETS;
        System.out.println("Stocks rechargés.");
    }

    // Détartrer la machine
    public void detartrer() {
        nbCafesServis = 0;
        horsService = false;
        System.out.println("Machine détartrée et opérationnelle.");
    }

    // Récupérer l'argent de la caisse
    public void recupererArgent() {
        System.out.printf("Montant récupéré : %.2f €\n", caisse);
        caisse = 0.0;
    }
}
