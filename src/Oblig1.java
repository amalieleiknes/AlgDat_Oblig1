import java.util.*;

import static java.util.Arrays.*;

public class Oblig1 {

    // Metoder som generer testverdier til int[] a. Kilde: Kompendie til "appolonius", url. "https://www.cs.hioa.no/~ulfu/appolonius/kap1/1/kap11.html#1.1.2", Programkode 1.1.8 d og e.
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n) {
        Random r = new Random();

        int[] a = new int[n];
        setAll(a, i -> i + 1);           // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)         // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);       // en tilfeldig tall fra 0 til k
            bytt(a, k, i);                        // bytter om
        }
        return a;                               // permutasjonen returneres
    }

    // Oppgave 1 TODO: FERDIG
    //hentet hjelp fra: https://stackoverflow.com/questions/34745203/using-a-for-loop-to-manually-sort-an-array-java
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Listen er tom!");
        }

        System.out.println("Liste blandet: " + Arrays.toString(a));
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]) {
                int midlertidig = a[i];
                a[i] = a[i + 1];
                a[i + 1] = midlertidig;
            }
        }
        System.out.println("Liste med største bakerst: " + Arrays.toString(a));
        return a[a.length - 1];
    }

    //Oppgave 1 TODO: Nesten ferdig
    // https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#kode.1.2.4.a - 1.2.6
    //metode som teller hvor mange ganger en ombytting skjer - skal regne ut gjennomsnittet
    public static int ombyttinger(int[] a) {
        if(a.length < 2){
            throw new NoSuchElementException("Listen må ha to verdier!");
        }
        int ombytting = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]) {
                int midlertidig = a[i];
                a[i] = a[i + 1];
                a[i + 1] = midlertidig;
                ombytting++;
            }
        }
        return ombytting;
    }

    // Oppgave 2 - ikke kjørt testene på denne
    public static int antallUlikeSortert(int[] a) {
        boolean sortert = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                sortert = false;
            }
        }
        if (!sortert) {
            throw new IllegalStateException("Tabellen er ikke sortert stigende!");
        }

        int antallUlike = 1;
        if (a.length == 0) {
            antallUlike = 0;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                antallUlike++;
            }
        }
        return antallUlike;
    }

    //Oppgave 3 - Denne er ok nå, hehe
    public static int antallUlikeUsortert(int[] a) {
        int antall = 1;
        int nyttTall;
        boolean unik = false;
        if (a.length < 1) {
            return 0;
        }
        for (int i = 1; i < a.length; i++) {        //går gjennom arrayet og sjekker om tallet har vært tidl
            nyttTall = a[i];                    //variabelen som sjekkes om har vært tidligere
            for (int j = i + 1; j < a.length; j++) {
                int telteTall = a[j];
                if (nyttTall != telteTall && nyttTall != a[0]) {
                    unik = true;
                } else {
                    unik = false;
                    break;
                }
            }
            if (unik) {
                antall++;
            }
        }
        return antall;
    }

    // Oppgave 4 TODO: FERDIG
    //lest fra: https://www.geeksforgeeks.org/sort-even-numbers-ascending-order-sort-odd-numbers-descending-order/
    public static void delsortering(int[] a) {
        if (a == null) {
            throw new NullPointerException("Listen er null."); //kaster exception dersom listen er null.
        }
        if (a.length == 0) {
            throw new NoSuchElementException("Listen er tom!"); //kaster exception dersom listen er tom.
        }

        int venstre = 0;           //setter en grense fra venstre
        int hoyre = a.length - 1;  //grense til høyre

        while (venstre < hoyre) {
            while (a[venstre] % 2 != 0 && venstre < hoyre) {  //dersom venstre er mindre enn hoyre og det er et oddetall, flytter vi kun telleren
                venstre++;
            }
            while (a[hoyre] % 2 == 0 && venstre < hoyre) {  //dersom venstre er mindre enn høyre og et partall, flytt telleren
                hoyre--;
            }
            if (venstre < hoyre) {  //går inn i if-statement når while-løkkene har truffet et partall og oddetall
                int midlertidig = a[venstre];   //gjøre plassen til venstre åpen
                a[venstre] = a[hoyre];          //setter inn verdi fra høyre til venstre
                a[hoyre] = midlertidig;         //setter inn verdien som sto til venstre på høyre plass
                venstre++;
                hoyre--;
            }
        }

        //går gjennom listen med for-each for å finne antall oddetall
        int oddetall = 0;
        for (int number : a) {
            if (number % 2 != 0) {
                oddetall++;
            }
        }

        //sortere oddetall
        int temp;
        for (int i = 0; i < oddetall; i++) {
            for (int k = 0; k < oddetall - 1; k++) {
                if (a[k] > a[k + 1]) {
                    temp = a[k];
                    a[k] = a[k + 1];
                    a[k + 1] = temp;
                }
            }
        }

        int partall = a.length - oddetall;

        //sortere partall
        for (int i = partall; i < a.length; i++) {

            for (int j = partall; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int midlertidig = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = midlertidig;
                }
            }
        }
    }


    // Oppgave 5 - ikke kjørt testene på denne
    public static void rotasjon(char[] a) {
        if (a.length == 0) {
            return;
        } else {
            char temp = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
    }


    // Oppgave 6 - ikke kjørt testene på denne
    public static void rotasjon(char[] a, int k) {
        if (k < 0) {
            k += a.length;
        }
        for (int i = 0; i < k; i++) {
            char temp = a[a.length - 1];
            for (int j = a.length - 1; j > 0; j--) {
                a[j] = a[j - 1];
            }
            a[0] = temp;
        }
    }

    // Oppgave 7a) TODO: FERDIG
    //Hentet hjelp fra --> https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/fasit1311.html
    public static String flett(String s, String t) {
        int kortesteString = Math.min(s.length(), t.length()); //finner ut hvilken String som er den korteste
        StringBuilder fullstendigSetning = new StringBuilder(); //oppretter en StringBuilder som skal returneres

        for(int i = 0; i < kortesteString; i++){
            fullstendigSetning.append(s.charAt(i)).append(t.charAt(i));   //fullstendigSetning "appender" først fra s i
        }                                                                 //indeks (i), deretter fra String t i indeks(i).

        //etter å ha lagt til annen hver bokstav i for-løkken, legges det til de siste bokstavene ved hjelp av metoden "substring".
        //den legger til bokstavene *fra* indeks "kortesteString" og ut.
        fullstendigSetning.append(s.substring(kortesteString)).append(t.substring(kortesteString));

        return fullstendigSetning.toString();
    }

    //Oppgave 7b) TODO: FERDIG
    public static String flett(String... s) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(Arrays.toString(s));
        for (int x = 0; x < s.length; x++) {                //ytre - x blir en teller for indeksen til bokstavene i hvert ord.
            for (int y = 0; y < s.length; y++) {            //indre - y blir en teller for hvert ord i listen s.
                if (s[y] != null && s[y].length() != 0 || s[x] != null) {  //sjekker at ikke bokstaven i indeks[x]
                    if (s[y].length() > x) {                                //ikke er null, eller lengde lik 0.
                        char bokstaven = s[y].charAt(x);                    //sjekker også at ordet s[y] ikke er null
                        stringBuilder.append(bokstaven);                    //eller lengde lik 0.

                    }
                }
            }
        }
        return stringBuilder.toString();
    }


    // Oppgave 8 - TODO: OK
    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = new int[a.length];
        int[] sortedArray = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedArray);       //hjelpetabell som er sortert i stigende rekkefølge
        boolean indeksOpptatt = false;

        if (a.length < 1) {
            return null;     // hvis arrayet er tomt returneres null
        } else {

            // løkke der vi tildeler indeksTabell[i] en verdi
            for (int i = 0; i < a.length; i++) {

                // løkke der vi sjekker gjennom arrayet om vi finner riktig verdi (sammenligner sortedArray med a, finner lik verdi)
                for (int j = 0; j < a.length; j++) {

                    // finner neste tall i sorted array i a, som er neste indeks i indeksTabell
                    if (sortedArray[i] == a[j]) {

                        if(j==0 && i==0){
                            indeksTabell[i] = j;
                            break;
                        }

                        else {

                            // hvis j allerede er i indeksTabell må den lete videre etter en høyere j
                            for(int k = 0; k < indeksTabell.length; k++){
                                if(indeksTabell[k] == j){
                                    indeksOpptatt = true;
                                    break;
                                }
                                else{
                                    indeksOpptatt = false;
                                }
                            }

                            if (!indeksOpptatt) {
                                indeksTabell[i] = j;        // legger til indeksen til tallet
                                break;
                            }
                        }

                    }
                }
            }
            return indeksTabell;
        }
    }

    // Oppgave 9 - TODO: OK
    public static  int[] tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Det er mindre enn tre elementer i a, antall: " + a.length);
        } else {
            int[] sokeTabell = {a[0], a[1], a[2]}; //lager en ny tabell med kun de tre første tallene fra a

            /* 0, 1, 2 */
            int m = Objects.requireNonNull(indekssortering(sokeTabell))[0]; // minsteverdi sin index
            int nm = Objects.requireNonNull(indekssortering(sokeTabell))[1]; // nest minste verdi sin indeks
            int nnm = Objects.requireNonNull(indekssortering(sokeTabell))[2]; // nest nest minste verdi sin indeks

            if (a[0] < a[1] && a[0] < a[2] && a[2]< a[1]) /* 0, 2, 1 */ {
                m = 0;
                nm = 2;
                nnm = 1;
            }

            else if (a[1] < a[0] && a[1] < a[2] && a[0]< a[2]) /* 1, 0, 2 */ {
                m = 1;
                nm = 0;
                nnm = 2;
            }

            else if (a[1] < a[0] && a[1] < a[2] && a[2] < a[0]) /* 1, 2, 0 */ {
                m = 1;
                nm = 2;
                nnm = 0;
            }

            else if (a[2] < a[0] && a[2] < a[1] && a[0] < a[1]) /* 2, 0, 1*/ {
                m = 2;
                nm =
                nnm = 0;
            }

            else if (a[2] < a[1] && a[2] < a[0] && a[1] < a[0]) /* 2, 1, 0 */ {
                m = 2;
                nm = 1;
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
            } //sjekker resten av tallene i a

            // n i posisjon 0, nm i posisjon 1, nnm i posisjon 2
            sokeTabell[0] = m;
            sokeTabell[1] = nm;
            sokeTabell[2] = nnm;

            return sokeTabell;
        }
    }

    // Oppgave 10 TODO: ferdig
    public static boolean inneholdt(String a, String b){
        if(a.length() == 0 || a.isBlank()){             //for å unngå å gå inn i metoden
            return true;
        }

        int[] tallRegisterA = new int[256];             //oppretter to heltallarrays til å legge til antall
        int[] tallRegisterB = new int[256];             //ASCII-verdier i.

        for(int i = 0; i < a.length(); i++){            //første for-løkke kjører gjennom String a, gjør om
            int asciiVerdi = a.toUpperCase().charAt(i); //alle bokstavene til store bokstaver og finner ASCII-verdien
            tallRegisterA[asciiVerdi]++;                //til bokstaven i [i]. Deretter legges det til
        }                                               //+1 på indeksen til ASCII-verdien i tallRegisterA.

        for(int j = 0; j < b.length(); j++){                //Det samme skjer i for-løkken, lik som for-løkken over.
            int asciiVerdi = b.toUpperCase().charAt(j);
            tallRegisterB[asciiVerdi]++;
        }

        for(int i = 0; i < tallRegisterA.length; i++){      //går gjennom tallRegisterA
            if( (tallRegisterA[i] > tallRegisterB[i]) ){    //dersom antallet er større i tallRegisterA[i], enn
                return false;                               //i tallRegisterB[i], inngår ikke alle bokstavene fra tallRegisterA
            }                                               //i tallRegisterB og vi går ut av for-løkken
        }
        return true;
    }


    // main-metode for testing, slettes før innlevering
    public static void main(String[] args) {
        int[] tomtArray = {};
        int[] array1 = randPerm(10);
        int[] array9 = {-1, 5, 0, 4, 2, 7, -1, -8, -2, 4};
        int[] array10 = {2,5,7,8,3,6,8,9,6,8};
        int[] likeTallArray = {5, 5, 5, 5, 5, 5};
        int[] minusTallArray = {-1,-2,-3,-1,-7,-1000};

        //System.out.println("Opgpave 8: " + Arrays.toString(indekssortering(array1)));
        System.out.println("Opprinnelig array: " + Arrays.toString(array9));
        System.out.println("Oppgave 9, output: " + Arrays.toString(tredjeMin(array9)));



        /*
        //Oblig1.maks(tomtArray);
        System.out.println("OPPGAVE 1 MAKS-METODE");
        int[] listeOppgave1 = randPerm(10);
        System.out.println("Det største tallet i listen: "+Oblig1.maks(listeOppgave1));

        System.out.println("OPPGAVE 1 OMBYTTINGER-METODE");
        int[] listeOppgave1_1 = randPerm(10);


        int numberOfnumbers = 100;
        int[] randomNumbers = randPerm(numberOfnumbers);
        System.out.println(Arrays.toString( randomNumbers));
        System.out.println("Det tok " + ombyttinger(randomNumbers) + " ombyttinger når antallet var "+numberOfnumbers);

        int numberOfnumbers2 = 10000;
        int[] randomNumbers2 = randPerm(numberOfnumbers2);
        System.out.println("Det tok " + ombyttinger(randomNumbers2) + " ombyttinger når antallet var "+numberOfnumbers2);

        int numberOfnumbers3 = 100000;
        int[] randomNumbers3 = randPerm(numberOfnumbers3);
        System.out.println("Det tok " + ombyttinger(randomNumbers3) + " ombyttinger når antallet var "+numberOfnumbers3);

        System.out.println(Arrays.toString(listeOppgave1_1));
        System.out.println("Det tok " + ombyttinger(listeOppgave1_1) + " ombyttinger å flytte det største tallet bakerst.");
        System.out.println(Arrays.toString(listeOppgave1_1));
        System.out.println();

        System.out.println("OPPGAVE 4");
        int[] oppg4List = randPerm(10);
        System.out.println("Usortert liste: " + Arrays.toString(oppg4List));
        Oblig1.delsortering(oppg4List);
        System.out.println("Sortert etter oddetall og partall " + Arrays.toString(oppg4List));
        */

        /*//Kjører metoden i oppgave 5:
        System.out.println("OPPGAVE 5");
        char[] c = {'A','B','C','D','E', 'F','G','H','I','J'};
        char[] d = {'A'};
        char[] e = {};
        System.out.println(Arrays.toString(c));
        rotasjon(e);
        rotasjon(c, -4);
        System.out.println(Arrays.toString(c));*/

        /*
        System.out.println("OPPGAVE 7 A");
        System.out.println(flett("HEI", "H"));

        System.out.println("OPPGAVE 7 B");
        System.out.println(flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU"));

        System.out.println("OPPGAVE 10");
        System.out.println(inneholdt("", "test"));
        System.out.println(inneholdt("test", "testeseh"));
        System.out.println(inneholdt("hallo", "hei"));
        System.out.println(inneholdt("hei", ""));
        System.out.println(inneholdt("hei", "hei"));
        */

    }
}
