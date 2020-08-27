import java.util.Arrays;
import java.util.Random;

public class Oblig1 {

    // Metoder som generer testverdier til int[] a. Kilde: Kompendie til "appolonius", url. "https://www.cs.hioa.no/~ulfu/appolonius/kap1/1/kap11.html#1.1.2", Programkode 1.1.8 d og e.
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n){
        Random r = new Random();

        int[] a = new int[n];
        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);    // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }
        return a;                        // permutasjonen returneres
    }


    //Oppgave 1







    // Oppgave 2







    //Oppgave 3

    public static int antallUlikeUsortert(int[] a){
        int antall = 0;
        if(a.length == 0){
            throw new ArrayIndexOutOfBoundsException("Arrayet er tomt: "+a.length);
        } else{


        }
        
        return antall;
    }







    // Oppgave 4







    // Oppgave 5








    //Oppgave 6






    // Oppgave 7







    // Oppgave 8







    // Oppgave 9







    // Oppgave 10


    public static void main(String[] args) {
        System.out.println("Test, oppgave 1:");

        System.out.println("Test, oppgave 2:");

        System.out.println("Test, oppgave 3:");
    }





}
