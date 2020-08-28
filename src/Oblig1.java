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
    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = new int[a.length];//ok
        int[] sortedArray = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedArray);       //hjelpetabell som er sortert i stigende rekkefølge

        if (a.length < 1) {
            return null;
        } else {                        // hvis arrayet er tomt returneres null
            for(int i = 0; i< a.length; i++) {
                for(int j = 0; j< a.length; j++) {
                    if (sortedArray[i] == a[j]) {
                        indeksTabell[i] = j;
                    }
                }
            }
            return indeksTabell;
        }
    }

    // Oppgave 9 - Nesten ferdig, mangler å bruke metode fra nr 8 men funker
    public static  int[] tredjeMin(int[] a){

        int[] søkeTabell = {a[0], a[1], a[2]};

        // først må jeg finne de tre minste verdiene
        int m = 0;
        int nm = 1;
        int nnm = 2;

        // Objects.requireNonNull(indekssortering(søkeTabell));

        if (a[2] < a[0]){
            m = 2; nnm = 0;
        }
        if (a[2] < a[1]){
            nm = 2; nnm = 1;
        }
        if (a[1] < a[0]){
            m = 1; nm = 0;
        }

        int minverdi = a[m];                // minste verdi
        int nestminverdi = a[nm];           // nest minste verdi
        int nestnestminverdi = a[nnm];      // nest nest minste verdi

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
                    }
                    else{
                        nnm = nm;
                        nestnestminverdi = nestminverdi; // ny nest nest størst

                        nm = i;
                        nestminverdi = a[nm];         // ny nest størst

                    }
                }
                else {
                    nnm = i;
                    nestnestminverdi =a[nnm];
                }
            }
        }

        // n i posisjon 0, nm i posisjon 1, nnm i posisjon 2
        søkeTabell[0]=m;
        søkeTabell[1]=nm;
        søkeTabell[2]=nnm;

        return søkeTabell;
    }



    // main-metode for testing, slettes før innlevering
    public static void main(String[] args) {
        int[] tomtArray = {};
        int[] array1 = randPerm(10);

        int[] array9 = {-1, 5, 0, 4, 2, 7, -1, -8, -2, 4};
        System.out.println("Opprinnelig array: " + Arrays.toString(array9));
        System.out.println("Oppgave 9, output: " + Arrays.toString(tredjeMin(array9)));


        // int[] array8 = {1, 0, 4, 2, 7, -1};
        // System.out.println("Opprinnelig array: " + Arrays.toString(array8));
        // System.out.println("Output oppgave 8: " + Arrays.toString(indekssortering(array8)));

        // int[] array3 = {1, 4, 4, 5, 4, 6, 7};
        // System.out.println("Output oppgave 3: " + antallUlikeUsortert(array3));

    }
}
