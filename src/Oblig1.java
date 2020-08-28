public class Oblig1 {


    //Oppgave 1







    // Oppgave 2 - Må se litt på om denne kan bli mer effektiv
    public static int antallUlikeSortert(int [] a){
        boolean sortert = true;
        for(int i = 1; i < a.length; i++){
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

    //Oppgave 3








    // Oppgave 4







    // Oppgave 5








    //Oppgave 6






    // Oppgave 7







    // Oppgave 8







    // Oppgave 9







    // Oppgave 10



















}
