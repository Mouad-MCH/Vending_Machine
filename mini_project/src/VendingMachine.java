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
