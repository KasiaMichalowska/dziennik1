package dziennik;

import java.util.ArrayList;

public class Dziennik {

    private ArrayList<Uczen> Uczniowie;

    public Dziennik() {
        Uczniowie = new ArrayList<>();
    }

    public void wyswietlUczen(Uczen uczen) {
        System.out.println("Uczen: " + uczen.getImie() + " " + uczen.getNazwisko());
        System.out.println("Najnizsza ocena: " + uczen.getNajnizsza());
        System.out.println("Najwyzsza ocena: " + uczen.getNajwyzsza());
        System.out.printf("Srednia ocen: %.2f\n",uczen.getSrednia());
    }

    public void wyswietl() {
        for(int i = 0; i < Uczniowie.size(); i++) {
            wyswietlUczen(Uczniowie.get(i));
        }
    }

    public void dodajUczen(Uczen uczen) {
        Uczniowie.add(uczen);
    }

    public String[] serialize() {
        return new String[0];
    }

    public static void main(String[] args) {
        // write your code here
        Dziennik dziennik = new Dziennik();
        Uczen uczen = new Uczen("Dariusz", "Darkowski");
        dziennik.dodajUczen(uczen);
        uczen.dodajOcene(2);
        uczen.dodajOcene(4);
        uczen.dodajOcene(5);
        uczen.dodajOcene(1);

        uczen = new Uczen("Ewelina", "Ewowska");
        dziennik.dodajUczen(uczen);
        uczen.dodajOcene(2);
        uczen.dodajOcene(4);
        uczen.dodajOcene(6);
        uczen.dodajOcene(1);
        uczen.dodajOcene(2);
        uczen.dodajOcene(2);
        uczen.dodajOcene(5);
        uczen.dodajOcene(1);

        uczen = new Uczen("Fabian", "Fabianski");
        dziennik.dodajUczen(uczen);
        uczen.dodajOcene(2);
        uczen.dodajOcene(4);
        uczen.dodajOcene(5);

        dziennik.wyswietl();

    }
}
