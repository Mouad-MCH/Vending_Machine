import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;



public class VendingMachine {
    static ArrayList<String>produits=new ArrayList<>(Arrays.asList("Eau","Soda","Chips","Chocolat"));
    static ArrayList<Double>prix=new ArrayList<>(Arrays.asList(5.0,8.0,12.0,15.0));
    static ArrayList<Integer>stock=new ArrayList<>(Arrays.asList(10,5,7,3));

    static Scanner input =new Scanner(System.in);

        public static void main(String[]args){

        int choix;
        do{
            try{
            System.out.println("===Distributeur Automatique===\n" +
                              "1-Afficher les produits\n" +
                              "2-Acheter un produits\n" +
                              "3.Mode Admin\n" +
                              "4-Quitter");

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
                    modeAdmin();
                    break;
                case 4:

                    System.out.println("A bientot");
                    break;
                default:
                    System.out.println("choix invalide ");
                    break;
            }
            }catch (java.util.InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide !");
                input.nextLine();
                choix = 0;

            }catch(Exception e) {
                System.out.println("Erreur inattendue : " + e.getMessage());
                input.nextLine();
                choix = 0;
            }
        }while (choix!=4);

    }
        public static void afficherProduits() {
        System.out.println("Produits disponibles : ");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + " . " + produits.get(i) + "(" + prix.get(i) + "MAD)-Stock : " + stock.get(i));
        }
    }
        public static void achete(){
        try {
            afficherProduits();
            System.out.println("entre id de le produit tu veux achete: ");
            int i = input.nextInt();
            i--;
            if (verifie(i) == 1) {
                montant(prix.get(i));
            }
        }catch (java.util.InputMismatchException e) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            input.nextLine();
        }catch(Exception e) {
            System.out.println("Erreur lors de l'achat : " + e.getMessage());
            input.nextLine();
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
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("entre montant necessaire " + n + " : ");
            int m = input.nextInt();
            int l;

            int k = -1;
            for (double elmnt : prix) {
                k++;
                if (elmnt == n)
                    break;
            }
            l = stock.get(k);
            l--;
            if (n == m) {
                System.out.println("achete success!");
                stock.set(k, l);
            } else if (n < m) {
                System.out.println("Monnaie rendue : " + (m - n) + " MAD");
                System.out.println("achete success!");
                stock.set(k, l);
            } else {
                System.out.println("invalid! Monnaie rendue : " + m + " MAD");
            }
        }catch (java.util.InputMismatchException e) {
            System.out.println("Erreur : Montant invalide !");
            input.nextLine();
        } catch (Exception e)  {
            System.out.println("Erreur lors du traitement du paiement : " + e.getMessage());
        }
        }

        // Mode Administrateur
        public static void modeAdmin() {
            int choixAdmin;
            do {
                try {
                    System.out.println("/-----Mode Admin----/");
                    System.out.println("1 - Recharger le stock");
                    System.out.println("2 - Modifier les prix");
                    System.out.println("3 - Retour au menu principal");

                    System.out.println("Entrez votre choix: ");
                    choixAdmin = input.nextInt();

                    switch (choixAdmin) {
                        case 1:
                            rechargerStock();
                            break;
                        case 2:
                            modifierPrix();
                            break;
                        case 3:
                            return;

                        default:
                            System.out.println("choix invalide !");
                            break;
                    }

                }catch(java.util.InputMismatchException e) {
                    System.out.println("Erreur : Veuillez entrer un nombre valide !");
                    input.nextLine();
                    choixAdmin = 0;
                }catch(Exception e) {
                    System.out.println("Erreur dans le mode administrateur : " + e.getMessage());
                    input.nextLine();
                    choixAdmin = 0;
                }


            }while (choixAdmin != 3);
        }

        public static void rechargerStock() {
            try {
                afficherProduits();
                System.out.print(" Entrez le nomber du produit a recharger: ");
                int choixProduit = input.nextInt() - 1;

                if (choixProduit < 0 || choixProduit >= produits.size()) {
                    System.out.println("Produit inexistant");
                    return;
                }

                System.out.print("Entrez la quantite : ");

                int quantite = input.nextInt();

                if (quantite < 0) {
                    System.out.println("Erreur: quantité ne peut pas être négative !");
                    return;
                }

                int newStock = stock.get(choixProduit) + quantite;
                stock.set(choixProduit, newStock);

                System.out.println("Stock mis a jour !");
            }catch(java.util.InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide !");
                input.nextLine();
            }catch(Exception e) {
                System.out.println("Erreur lors du rechargement du stock : " + e.getMessage());
            }

        }
        public static void modifierPrix() {
            try {
                afficherProduits();
                System.out.print(" Entrez le nomber du produit: ");
                int choixProduit = input.nextInt() - 1;

                if (choixProduit < 0 || choixProduit >= produits.size()) {
                    System.out.println("Produit inexistant !");
                    return;
                }

                System.out.print("Nouveau prix (ancien : " + prix.get(choixProduit) + " MAD) : ");
                double newPrix = input.nextDouble();

                if (newPrix <= 0) {
                    System.out.println("Erreur : Le prix doit être positif !");
                    return;
                }

                prix.set(choixProduit, newPrix);
                System.out.println("Prix mis a jour !");

            }
            catch(java.util.InputMismatchException e) {
                  System.out.println("Erreur : Veuillez entrer un nombre valide !");
                  input.nextLine();
              }
            catch(Exception e) {
                System.out.println("Erreur lors de la modification du prix : " + e.getMessage());
               }
        }

    }



