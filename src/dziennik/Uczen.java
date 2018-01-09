package dziennik;

import java.util.ArrayList;

public class Uczen {

    private String Imie;
    private String Nazwisko;
    private ArrayList<Integer> Oceny;

    public Uczen(String imie, String nazwisko) {
        Imie = imie;
        Nazwisko = nazwisko;
        Oceny = new ArrayList<Integer>();
    }

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public int getNajnizsza() {
        int najnizsza = Integer.MAX_VALUE;
        for( int i = 0; i < Oceny.size(); i++ ) {
            if( Oceny.get(i) < najnizsza ) {
                najnizsza = Oceny.get(i);
            }
        }
        return najnizsza;
    }

    public int getNajwyzsza() {
        int najwyzsza = 0;
        for( int i = 0; i < Oceny.size(); i++ ) {
            if( Oceny.get(i) > najwyzsza ) {
                najwyzsza = Oceny.get(i);
            }
        }
        return najwyzsza;
    }

    public double getSrednia() {
        double sumaOcen = 0;
        for( int i = 0; i < Oceny.size(); i++ ) {
            sumaOcen += Oceny.get(i);
        }
        if( Oceny.size() == 0 ) return 0;
        return (double)sumaOcen / (double)Oceny.size();
    }

    public void dodajOcene(Integer ocena) {
        Oceny.add(ocena);
    }

    public String serialize() {
        String retval = "";
        return retval;
    }


}
