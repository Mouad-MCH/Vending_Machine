import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
    public static void achete(){
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < produit.size(); i++){
            affiche(i);
        }
        System.out.println("entre le produit tu veux achete: ");
        String nom = input.nextLine();
        int i = -1;
        for(String elmnt : Produit){
           i++;
           if (elmnt == nom)
               break;
        }
        if(verifie(i) == 1){
            montant(prix.get(i));
        }
    }
    public static int verifie(int n){
        if(stock.get(n) =< 0) {
            System.out.println("ce produit expire!");
            return 0;
        }
        return 1;
    }

}
import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {
    static ArrayList<String>produits=new ArrayList<>(Arrays.asList("Eau","Soda","Chips","Chocolat"));

    static ArrayList<Double>prix=new ArrayList<>(Arrays.asList(5.0,8.0,12.0,15.0));
    static ArrayList<Integer>stock=new ArrayList<>(Arrays.asList(10,5,7,3));

    static Scanner sc=new Scanner(System.in);

    public static void main(String[]args){

        int choix;
        do{
            System.out.println("===Distributeur Automatique===");
            System.out.println("1-Afficher les produits");
            System.out.println("2-Acheter un produits");
            System.out.println("3-Quitter");
            System.out.println("votre choix : ");
            choix = sc.nextInt();
            switch (choix){
                case 1:
                    afficherProduits();
                    break;
                case 2:
                    //acheter produit();
                    break;
                case 3:

                    System.out.println("A bientot");
                    break;
                default:
                    System.out.println("choix invalide ");
                    break;
            }
        }while (choix!=3);

    }
    public static void afficherProduits() {
        System.out.println("Produits disponibles : ");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + " . " + produits.get(i) + "(" + prix.get(i) + "MAD)-Stock : " + stock.get(i));
        }
    }
    }



