import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;




public class VendingMachine {
    static ArrayList<String>produits=new ArrayList<>(Arrays.asList("Eau","Soda","Chips","Chocolat"));
    static ArrayList<Double>prix=new ArrayList<>(Arrays.asList(5.0,8.0,12.0,15.0));
    static ArrayList<Integer>stock=new ArrayList<>(Arrays.asList(10,5,7,3));

    static Scanner input =new Scanner(System.in);

    public static void main(String[]args){

        int choix;
        do{
            System.out.println("===Distributeur Automatique===\n1-Afficher les produits\n2-Acheter un produits\n3-Quitter");
            System.out.println("votre choix : ");
            choix = input.nextInt();
            switch (choix){
                case 1:
                    afficherProduits();
                    break;
                case 2:
                    achete();
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



        public static void achete(){
            afficherProduits();
            System.out.println("entre id de le produit tu veux achete: ");
            int i = input.nextInt();
            i--;
            if(verifie(i) == 1){
                montant(prix.get(i));
            }
        }
        public static int verifie(int n){
            if(stock.get(n) <= 0) {
                System.out.println("ce produit expire!");
                return 0;
            }
            return 1;
        }
        public static void montant(double n){
            Scanner input = new  Scanner(System.in);
            System.out.println("entre montant necessaire "+ n +" : ");
            int m = input.nextInt();
            int l;

            int k = -1;
            for(double elmnt : prix){
                k++;
                if (elmnt == n)
                    break;
            }
            l = stock.get(k);
            l--;
            if(n == m) {
                System.out.println("achete success!");
                stock.set(k, l);
            } else if (n < m) {
                System.out.println("Monnaie rendue : "+(m-n)+" MAD");
                System.out.println("achete success!");
                stock.set(k, l);
            }else{
                System.out.println("invalid! Monnaie rendue : "+ m +" MAD");
            }
        }

    }



