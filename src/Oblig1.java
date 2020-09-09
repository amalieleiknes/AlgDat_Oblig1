/*Oppgaven er levert av folgende studenter:
* Amalie Christine Leiknes, S340559, s340559@oslomet.no
* Caroline Sofie Jetteberg, S313564, s313564@oslomet.no
* Hannah Marie Maurstad Eriksen, S325340, s325340@oslomet.no
 */

import java.util.*;
import static java.util.Arrays.*;

public class Oblig1 {

    // Oppgave 1 TODO: FERDIG
    //hentet hjelp fra: https://stackoverflow.com/questions/34745203/using-a-for-loop-to-manually-sort-an-array-java
    public static int maks(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Listen er tom!");
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]) {
                int midlertidig = a[i];
                a[i] = a[i + 1];
                a[i + 1] = midlertidig;
            }
        }
        return a[a.length - 1];
    }

    //Oppgave 1 - https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#kode.1.2.4.a - 1.2.6
    /*
    Naar blir det flest ombyttinger?
        Det blir flest ombyttinger de gangene tallet til venstre er storre enn tallet til hoyre.

    Naar blir det ferrest?
        Det blir ferrest ombyttinger de gangene tallet til venstre er mindre enn tallet til hoyre.
        Det blir altsaa ferrest ombyttinger naar listen er sortert i stigende rekkefolge.

    Hvor mange blir det i gjennomsnitt?
    Todo: Her maa det legges inn formel paa hvordan det regnes ut gjennomsnitt.
    https://www.cs.hioa.no/~ulfu/appolonius/kap1/2/kap12.html#1.2.6 - 1.2.7
     */

    //metode som teller hvor mange ganger en ombytting skjer - skal regne ut gjennomsnittet
    public static int ombyttinger(int[] a) {
        if (a.length < 2) {
            throw new NoSuchElementException("Listen maa ha to verdier!");
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

    // Oppgave 2
    public static int antallUlikeSortert(int [] a){
        int antallUlike = 0;
        int lengde = a.length;

        int[] copyOfA = Arrays.copyOf(a, a.length);
        Arrays.sort(copyOfA);

        if(!Arrays.toString(a).equals(Arrays.toString(copyOfA))){
            throw new IllegalStateException("feil array");
        }

        if(lengde>0) {
            antallUlike++;
            for (int i = 1; i < lengde; i++) {
                if (a[i]!=a[i-1]) {
                    antallUlike++;
                }
            }
        }
        return antallUlike;
    }

    //Oppgave 3
    public static int antallUlikeUsortert(int[] a) {
        int antall = 1;
        int nyttTall;
        boolean unik = false;
        if (a.length < 1) {
            return 0;
        }
        for (int i = 1; i < a.length; i++) {        //gaar gjennom arrayet og sjekker om tallet har vert tidl
            nyttTall = a[i];                    //variabelen som sjekkes om har vert tidligere
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

    // Oppgave 4
    //lest fra: https://www.geeksforgeeks.org/sort-even-numbers-ascending-order-sort-odd-numbers-descending-order/
    public static void delsortering(int[] a) {
        int hoyre = a.length - 1;   //grense til hoyre
        int venstre = 0;            //setter en grense fra venstre

        if (hoyre <= 1) {
            // Ingenting skjer om listen er tom
        } else {

            while (venstre < hoyre) {
                while (a[venstre] % 2 != 0 && venstre < hoyre) {  //dersom venstre er mindre enn hoyre og det er et oddetall, flytter vi kun telleren
                    venstre++;
                }
                while (a[hoyre] % 2 == 0 && venstre < hoyre) {  //dersom venstre er mindre enn hoyre og et partall, flytt telleren
                    hoyre--;
                }
                //if (venstre < hoyre) {  //gaar inn i if-statement naar while-lokkene har truffet et partall og oddetall
                    int midlertidig = a[venstre];   //gjore plassen til venstre aapen
                    a[venstre] = a[hoyre];          //setter inn verdi fra hoyre til venstre
                    a[hoyre] = midlertidig;         //setter inn verdien som sto til venstre paa hoyre plass
                    venstre++;
                    hoyre--;
                //}
            }

            //gaar gjennom listen med for-each for aa finne antall oddetall
            int oddetall = 0;
            for (int number : a) {
                if (number % 2 != 0) {
                    oddetall++;
                }
            }

            // velger å bruke Arrays.sort da dobbel for-løkke ikke var effektivt nok
            Arrays.sort(a,0,oddetall);
            Arrays.sort(a,oddetall,a.length);
        }
    }

    // Oppgave 5
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

    // Oppgave 6 TODO: Oppgave 6: i, j, k, l) Metoden er for ineffektiv. Må forbedres!
    public static void rotasjon(char[] a, int k) {
        if (a.length != 0) {
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
    }

    // Oppgave 7a)
    //Hentet hjelp fra --> https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/fasit1311.html
    public static String flett(String s, String t) {
        int kortesteString = Math.min(s.length(), t.length()); //finner ut hvilken String som er den korteste
        StringBuilder fullstendigSetning = new StringBuilder(); //oppretter en StringBuilder som skal returneres

        for(int i = 0; i < kortesteString; i++){
            fullstendigSetning.append(s.charAt(i)).append(t.charAt(i));   //fullstendigSetning "appender" forst fra s i
        }                                                                 //indeks (i), deretter fra String t i indeks(i).

        //etter aa ha lagt til annen hver bokstav i for-lokken, legges det til de siste bokstavene ved hjelp av metoden "substring".
        //den legger til bokstavene *fra* indeks "kortesteString" og ut.
        fullstendigSetning.append(s.substring(kortesteString)).append(t.substring(kortesteString));

        return fullstendigSetning.toString();
    }

    //Oppgave 7b) TODO: Oppgave 7b: f) Svaret skal bli ABCDEFGHIJKLMNOPQRSTUVWXY!
    public static String flett(String... s) {
        if(s == null || s.length == 0){
            return "";
        }
        int lengsteOrd = s[0].length();
        for (int i = 1; i < s.length; i++){
            if(s[i].length() > lengsteOrd){
                lengsteOrd = s[i].length();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = 0; x < lengsteOrd; x++) {                //ytre - x blir en teller for indeksen til bokstavene i hvert ord.
            for (int y = 0; y < s.length; y++) {            //indre - y blir en teller for hvert ord i listen s.
                if (s[y] != null && s[y].length() != 0 || s[x] != null) {  //sjekker at ikke bokstaven i indeks[x]
                    if (s[y].length() > x) {                                //ikke er null, eller lengde lik 0.
                        char bokstaven = s[y].charAt(x);                    //sjekker ogsaa at ordet s[y] ikke er null
                        stringBuilder.append(bokstaven);                    //eller lengde lik 0.

                    }
                }
            }
        }
        return stringBuilder.toString();
    }


    // Oppgave 8
    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = null;

        if(a.length==0){
            indeksTabell = new int[0];
        }
        else {
            indeksTabell = new int[a.length];
            int[] sortedArray = Arrays.copyOf(a, a.length);
            Arrays.sort(sortedArray);       //hjelpetabell som er sortert i stigende rekkefolge
            boolean indeksOpptatt = false;

            if (a.length < 1) {
                return null;     // hvis arrayet er tomt returneres null
            } else {

                // lokke der vi tildeler indeksTabell[i] en verdi
                for (int i = 0; i < a.length; i++) {

                    // lokke der vi sjekker gjennom arrayet om vi finner riktig verdi (sammenligner sortedArray med a, finner lik verdi)
                    for (int j = 0; j < a.length; j++) {

                        // finner neste tall i sorted array i a, som er neste indeks i indeksTabell
                        if (sortedArray[i] == a[j]) {

                            if (j == 0 && i == 0) {
                                indeksTabell[i] = j;
                                break;
                            } else {

                                // hvis j allerede er i indeksTabell maa den lete videre etter en hoyere j
                                for (int k = 0; k < indeksTabell.length; k++) {
                                    if (indeksTabell[k] == j) {
                                        indeksOpptatt = true;
                                        break;
                                    } else {
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

            }

        }return indeksTabell;
    }

    // Oppgave 9
    public static  int[] tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Det er mindre enn tre elementer i a, antall: " + a.length);
        } else {

            int[] sokeTabell = {a[0], a[1], a[2]}; //lager en ny tabell med kun de tre forste tallene fra a

            /* 0, 1, 2 */
            int m = Objects.requireNonNull(indekssortering(sokeTabell))[0]; // minsteverdi sin index
            int nm = Objects.requireNonNull(indekssortering(sokeTabell))[1]; // nest minste verdi sin indeks
            int nnm = Objects.requireNonNull(indekssortering(sokeTabell))[2]; // nest nest minste verdi sin indeks

            if (a[0] < a[1] && a[1] < a[2]) /* 0, 1, 2 */ {
                m = 0;
                nm = 1;
                nnm = 2;
            }

            else if (a[1] < a[0] && a[0] < a[2]) /* 1, 0, 2 */ {
                m = 1;
                nm = 0;
                nnm = 2;
            }

            else if (a[1] < a[2] && a[2] < a[0]) /* 1, 2, 0 */ {
                m = 1;
                nm = 2;
                nnm = 0;
            }

            else if (a[2] < a[0] && a[0] < a[1]) /* 2, 0, 1*/ {
                m = 2;
                nm = 0;
                nnm = 1;
            }

            else if (a[2] < a[1] && a[1] < a[0]) /* 2, 1, 0 */ {
                m = 2;
                nm = 1;
                nnm = 0;
            }

            int minverdi = a[m];                // minste verdi
            int nestminverdi = a[nm];           // nest minste verdi
            int nestnestminverdi = a[nnm];      // nest nest minste verdi

            for (int i = 3; i < a.length; i++) {
                if (a[i] < nestnestminverdi) {
                    if (a[i] < nestminverdi) {
                        if (a[i] < minverdi) {  // hvis neste verdi er mindre enn minste verdi
                            nnm = nm;
                            nestnestminverdi = nestminverdi; // ny nest nest storst

                            nm = m;
                            nestminverdi = minverdi;     // ny nest storst

                            m = i;
                            minverdi = a[m];              // ny storst
                        }
                        else {  // hvis neste tall er < nestminste men ikke mindre enn minste
                            nnm = nm;
                            nestnestminverdi = nestminverdi; // ny nest nest storst

                            nm = i;
                            nestminverdi = a[nm];         // ny nest storst

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


    // Oppgave 10 TODO: Oppgave 10: n) Dette (11477 ms) gikk sakte! Finn en bedre algoritme!
    public static boolean inneholdt(String a, String b){
        if(a.length() == 0 || a.isBlank()){             //for aa unngaa aa gaa inn i metoden
            return true;
        }

        String A = a.toUpperCase();
        String B = b.toUpperCase();

        int[] tallRegisterA = new int[256];             //oppretter to heltallarrays til aa legge til antall
        int[] tallRegisterB = new int[256];             //ASCII-verdier i.

        for(int i = 0; i < a.length(); i++){            //forste for-lokke kjorer gjennom String a, gjor om
            int asciiVerdi = A.charAt(i);               //alle bokstavene til store bokstaver og finner ASCII-verdien
            tallRegisterA[asciiVerdi]++;                //til bokstaven i [i]. Deretter legges det til
        }                                               //+1 paa indeksen til ASCII-verdien i tallRegisterA.

        for(int j = 0; j < b.length(); j++){                //Det samme skjer i for-lokken, lik som for-lokken over.
            int asciiVerdi = B.charAt(j);
            tallRegisterB[asciiVerdi]++;
        }

        for(int i = 0; i < tallRegisterA.length; i++){      //gaar gjennom tallRegisterA
            if((tallRegisterA[i] > tallRegisterB[i]) ){     //dersom antallet er storre i tallRegisterA[i], enn
                return false;                               //i tallRegisterB[i], inngaar ikke alle bokstavene fra tallRegisterA
            }                                               //i tallRegisterB og vi gaar ut av for-lokken
        }
        return true;
    }

}
