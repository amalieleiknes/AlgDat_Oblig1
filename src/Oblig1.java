import java.util.Arrays;
import java.util.Objects;
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

    // Oppgave 1


    // Oppgave 2

    //Oppgave 3 - Denne er OK, men må fikse avvik
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


    // Oppgave 8 - Denne er OK, men må fikse avvik
    public static int[] indekssortering(int[] array) {
        int[] indeksTabell = new int[array.length];//ok
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);       //hjelpetabell som er sortert i stigende rekkefølge

        if (array.length < 1) {
            return null;
        } else {                        // hvis arrayet er tomt returneres null
            for(int i = 0; i< array.length; i++) {
                for(int j = 0; j< array.length; j++) {
                    if (sortedArray[i] == array[j]) {
                        indeksTabell[i] = j;
                    }
                }
            }
            return indeksTabell;
        }
    }

    // Oppgave 9 - Finne indeksene til de tre minste verdiene i tabellen
    public static  int[] tredjeMin(int[] a){
        int[] utTabell = new int[3];

        // først må jeg finne de tre minste verdiene

        int m = 0;
        int nm = 1;
        int nnm = 2;

        if(a[2] < a[0]){
            m = 2; nnm = 0;
        }
        if (a[2] < a[1]) {
            nm = 2; nnm = 1;
        }
        if (a[1] < a[0]){
            m = 1; nm = 0;
        }

        int minverdi = a[m];                // minste verdi
        int nestminverdi = a[nm];           // nest minste verdi
        int nestnestminverdi = a[nnm];      // nest nest minste verdi

        System.out.println(minverdi);


        for (int i = 3; i < a.length; i++){
            if (a[i] < nestnestminverdi){
                if (a[i] < nestminverdi) {
                    if (a[i] < minverdi) {
                        nnm = nm;
                        nestnestminverdi = nestminverdi; // ny nest nest størst

                        nm = m;
                        nestminverdi = minverdi;     // ny nest størst

                        m = i;
                        minverdi = a[m];              // ny størst
                        System.out.println(minverdi);
                    }
                }
                else
                {
                    //nnm = ; denne må fikses???
                    nestnestminverdi =a[nnm];     // ny nest nest størst

                    nm = i;
                    nestminverdi = a[nm];         // ny nest størst

                }
            }
        }

        /* Sto at dette måtte brukes, men hvordan??? Blir nesten riktig nå hehe
        int min = Objects.requireNonNull(indekssortering(hei))[0];
        int nmin = Objects.requireNonNull(indekssortering(hei))[1];
        int nnmin = Objects.requireNonNull(indekssortering(hei))[2];
        */

        // n i posisjon 0, nm i posisjon 1, nnm i posisjon 2
        utTabell[0]=m;
        utTabell[1]=nm;
        utTabell[2]=nnm;

        return utTabell;
        // output: {5, 1, 3}
    }



    // main-metode for testing, slettes før innlevering
    public static void main(String[] args) {
        int[] tomtArray = {};
        int[] array1 = randPerm(10);

        int[] array9 = {5, 0, 4, 2, 7, -1};
        System.out.println("Oppgave 9: " + Arrays.toString(tredjeMin(array9)));


        // int[] array8 = {1, 0, 4, 2, 7, -1};
        // System.out.println("Opprinnelig array: " + Arrays.toString(array8));
        // System.out.println("Output oppgave 8: " + Arrays.toString(indekssortering(array8)));

        // int[] array3 = {1, 4, 4, 5, 4, 6, 7};
        // System.out.println("Output oppgave 3: " + antallUlikeUsortert(array3));

    }
}
