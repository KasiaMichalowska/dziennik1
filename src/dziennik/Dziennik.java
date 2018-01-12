package dziennik;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dziennik {

    private ArrayList<Uczen> Uczniowie;

    public Dziennik() {
        Uczniowie = new ArrayList<>();
    }

    public Dziennik (String[] serializationStrings) {
        Uczniowie = new ArrayList<>();
        deserialize(serializationStrings);

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
        String[] retval = new String[Uczniowie.size()];
        for(int i = 0; i < Uczniowie.size(); i++) {
            retval[i] = Uczniowie.get(i).serialize();
        }
        return retval;
    }

    private void deserialize(String[] serializationLines) {
        for (String line : serializationLines) {
            dodajUczen(new Uczen(line));
        }
    }

    public void zapiszDoPliku (String nazwaPliku){
        try {
            PrintWriter printWriter = new PrintWriter(nazwaPliku, "UTF-8");
            String[] listaUczniow = serialize();
            for(int i = 0; i < listaUczniow.length; i++) {
                printWriter.println(listaUczniow[i]);
            }
            printWriter.close();
        }
        catch (Exception e) {
        }
    }

    public static Dziennik odczytZPliku (String nazwaPliku){
        Path path = Paths.get(nazwaPliku);
        Charset charset = Charset.forName("UTF-8");
        try {
            List<String> lines = Files.readAllLines(path, charset);
            return new Dziennik(lines.toArray(new String[lines.size()]));
        }
        catch (Exception e)
        {
            return null;

        }
    }

    public static void main(String[] args) {
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

        System.out.println(uczen.serialize());

        dziennik.wyswietl();

        dziennik.zapiszDoPliku("c:\\temp\\Kasia.txt");

        Dziennik dziennik1 = Dziennik.odczytZPliku("c:\\temp\\Kasia.txt");
        dziennik1.wyswietl();
    }
}
