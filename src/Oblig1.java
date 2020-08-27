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
        Arrays.setAll(a, i -> i + 1);           // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)         // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);       // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                        // bytter om
        }
        return a;                               // permutasjonen returneres
    }


    //Oppgave 1







    // Oppgave 2







    //Oppgave 3 - Denne er OK
    public static int antallUlikeUsortert(int[] a){
        int antall = 0;
        boolean unik = false;

        for(int i = 1; i<a.length; i++){
            for(int j = 0; j<i; j++){
                if(a[j]!=a[i]){
                    unik = true;
                } else{
                    unik = false;
                }

            } if(unik){
                antall++;
            }
        }
        return antall;
    }

    // Oppgave 4







    // Oppgave 5


    // Oppgave 6



    // Oppgave 7



    // Oppgave 8 - den minste verdien sin index skal først i nytt array, og så i stigende rekkefølge
    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = new int[a.length];//ok

        int minsteverdiIndex = a.length-1;

        if (a.length < 1) {
            return null;
        } else {

            for(int i = 0; i<a.length; i++) {

                for (int m = 0; m < a.length; m++) {//ok

                    if (a[m] < a[minsteverdiIndex]) {
                        minsteverdiIndex = m;
                    }

                    indeksTabell[i] = minsteverdiIndex;

                }



            }
            return indeksTabell;//ok
        }
    }



    // Oppgave 9



    // Oppgave 10




    // main-metode for testing
    // kan lage et array for hver oppgave? alt under her slettes før levering av oppgave
    public static void main(String[] args) {
        int[] tomtArray = {};
        int[] array1 = randPerm(10);
        int[] array2 = randPerm(2);
        int[] array3 = {1, 4, 4, 5, 4, 6, 7};
        int[] array8 = {1, 0, 4, 2, 7, -1};

        // System.out.println("Test, oppgave 1:");
        // System.out.println("Test, oppgave 2:");
        //System.out.println("Test. Oppgave 8: " + Arrays.toString(indekssortering(array8)));


// 3 - Denne er OK  System.out.println("Test, oppgave 3: " + antallUlikeUsortert(array3));

    }
}
