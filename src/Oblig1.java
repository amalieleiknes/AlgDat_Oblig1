import java.util.Arrays;
import java.util.NoSuchElementException;
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


    // Oppgave 2 - ikke kjørt testene på denne
    public static int antallUlikeSortert(int[] a){
        boolean sortert = true;
        for(int i = 0; i < a.length; i++){
            if(a[i] < a[i-1]){
                sortert = false;
            }
        }
        if(!sortert){
            throw new IllegalStateException("Tabellen er ikke sortert stigende!");
        }

        int antallUlike = 1;
        if(a.length == 0){
            antallUlike = 0;
        }
        for(int i = 1; i < a.length; i++){
            if(a[i] != a[i-1]){
                antallUlike++;
            }
        }
        return antallUlike;
    }

    //Oppgave 3 - Denne er ok med testene til foreleser, men blir feil hvis man prøver med minusTallArray??????
    public static int antallUlikeUsortert(int[] a){
        int antall = 1;
        boolean unik = false;

        if(a.length<1){
            return 0;
        }

        for(int i = 1; i<a.length; i++){        //går gjennom arrayet og sjekker om tallet har vært tidl

            int nyttTall = a[i];        //variabelen som sjekkes om har vært tidligere

            for(int j = i+1; j<a.length; j++) {

                int telteTall = a[j];

                if(nyttTall != telteTall && telteTall!= a[0]){
                    unik=true;
                } else {
                    unik=false;
                    break;
                }
            }

            if(unik){
                antall++;
            }
        }

        return antall;
    }

    // Oppgave 4


    // Oppgave 5 - ikke kjørt testene på denne
    public static void rotasjon(char[] a){
        if(a.length == 0){
        }
        else{
            char temp = a[a.length-1];
            for(int i  = a.length-1; i > 0; i--){
                a[i] = a[i-1];
            }
            a[0] = temp;
        }

    }


    // Oppgave 6


    // Oppgave 7


    // Oppgave 8 - Denne fungerer ikke om det er like tall i tabellen, men skjønner ikke hvorfor???
    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = new int[a.length];
        int[] sortedArray = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedArray);       //hjelpetabell som er sortert i stigende rekkefølge

        if (a.length < 1) {
            return null;
        } else {                        // hvis arrayet er tomt returneres null
            for (int i = 0; i < a.length; i++) {           // løkke der vi tildeler indeksTabell[i] en verdi
                for (int j = 0; j < a.length; j++) {       // løkke der vi sjekker gjennom arrayet om vi finner riktig verdi (sammenligner sortedArray med a, finner lik verdi)
                    if (sortedArray[i] == a[j]) {        // finner neste tall i sorted array i a, som er neste indeks i indeksTabell

                        // når den har funnet en lik må vi sjekke om denne indeksen allerede ligger i indeksTabell.
                        // hvis den allerede ligger der må metoden lete etter neste forekomst istedenfor å legge til indeksen i tabellen.
                        // men dette får ikke jeg til


                        // denne if-setningen får array med opptil 2 like tall til å bli riktig, me må finne en permanent løsning
                        if (i > 0 && sortedArray[i] == sortedArray[i - 1]) {
                            break;
                        }

                        indeksTabell[i] = j;        // legger til indeksen til tallet som er funnet i indeksTabell.

                    }
                }
            }
            return indeksTabell;
        }
    }

    // Oppgave 9 - OK
    public static  int[] tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Det er mindre enn tre elementer i a, antall: " + a.length);
        } else {
            int[] sokeTabell = {a[0], a[1], a[2]}; //lager en ny tabell med kun de tre første tallene fra a

            int m = Objects.requireNonNull(indekssortering(sokeTabell))[0]; // minsteverdi sin index
            int nm = Objects.requireNonNull(indekssortering(sokeTabell))[1]; // nest minste verdi sin indeks
            int nnm = Objects.requireNonNull(indekssortering(sokeTabell))[2];// nest nest minste verdi sin indeks

            if (a[2] < a[0]) {
                m = 2;
                nnm = 0;
            }
            if (a[2] < a[1]) {
                nm = 2;
                nnm = 1;
            }
            if (a[1] < a[0]) {
                m = 1;
                nm = 0;
            }

            int minverdi = a[m];                // minste verdi
            int nestminverdi = a[nm];           // nest minste verdi
            int nestnestminverdi = a[nnm];      // nest nest minste verdi


            for (int i = 3; i < a.length; i++) {
                if (a[i] < nestnestminverdi) {
                    if (a[i] < nestminverdi) {
                        if (a[i] < minverdi) {  // hvis neste verdi er mindre enn minste verdi
                            nnm = nm;
                            nestnestminverdi = nestminverdi; // ny nest nest størst

                            nm = m;
                            nestminverdi = minverdi;     // ny nest størst

                            m = i;
                            minverdi = a[m];              // ny størst
                        }
                        else {  // hvis neste tall er < nestminste men ikke mindre enn minste
                            nnm = nm;
                            nestnestminverdi = nestminverdi; // ny nest nest størst

                            nm = i;
                            nestminverdi = a[nm];         // ny nest størst

                        }
                    } else {
                        nnm = i;
                        nestnestminverdi = a[nnm];
                    }
                }
            }

            // n i posisjon 0, nm i posisjon 1, nnm i posisjon 2
            sokeTabell[0] = m;
            sokeTabell[1] = nm;
            sokeTabell[2] = nnm;

            return sokeTabell;
        }
    }

    // Oppgave 10
    public static boolean inneholdt(String a, String b){
        boolean inneholder = false;

        if(b.contentEquals(a) || a.isEmpty()){
            inneholder = true;
        }
        else {


            //hvis bokstavene i A er i B returneres true. ellers false.


            // gjøre om bokstavene til et heltall

            int A = 1; // er det dette han mener?
        }

        return inneholder;
    }



    // main-metode for testing, slettes før innlevering
    public static void main(String[] args) {
        int[] tomtArray = {};
        int[] likeTallArray = {5, 5, 5, 5, 5, 5};
        int[] minusTallArray = {-1,-2,-3,-1,-7,-1000};
        int[] randomArray = randPerm(10);
        String a = "ABCA";
        String b = "ALBLCLAJA";

        /*System.out.println("Opgpave 8: " + antallUlikeUsortert(minusTallArray));*/

        //Kjører metoden i oppgave 5:
        char[] c = {'A','B','C','D','E','G','H','I','J'};
        char[] d = {'A'};
        char[] e = {};
        System.out.println(Arrays.toString(c));
        rotasjon(c);
        System.out.println(Arrays.toString(c));

    }
}
