import java.io.*;
import java.util.*;

public class Main {

    public static final String SOUBOR = "vstup.txt";
    public static final String ODDELOVAC = "#";

    public static void main(String[] args) throws ZvysPocetProdeju {

        List<Zakaznik> zakaznik2 = new ArrayList<>();

        zakaznik2.add(new Zakaznik("Karel Novák", 75));
        zakaznik2.add(new Zakaznik("Petr Svoboda", 18));

        //odebrání posledního
        int lastIndex = zakaznik2.size() - 1;
        zakaznik2.remove(lastIndex);

        for (Zakaznik zakaznik : zakaznik2)System.out.println(zakaznik.getJmeno() + ":" + zakaznik.getPocetProdeju());

        List<String> zakaznik3 = new ArrayList<>();

        zakaznik3.add("Petr Pavel");

        // cteni ze souboru
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(SOUBOR)))
        ){
            while (scanner.hasNextLine()){
                String prectenyRadek = scanner.nextLine();
                String[] line = prectenyRadek.split("#");

                zakaznik3.addAll(Arrays.asList(line));

            }
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

        zakaznik3.forEach(System.out::println);


        // zapis do souboru
        List<Zakaznik> zakaznik = new ArrayList<>();

        zakaznik.add(new Zakaznik("Lukáš Šustr", 127));
        zakaznik.add(new Zakaznik("Ilona Nováková", 64));


        writeToFile(zakaznik, "vystup.txt",":");
    }

    private static void writeToFile(List<Zakaznik> zakaznik, String soubor, String oddelovac) {

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(soubor)))
        ){
            for (Zakaznik zakaznik1 : zakaznik) {
                writer.println(zakaznik1.getJmeno() + oddelovac + zakaznik1.getPocetProdeju());
            }
        } catch (IOException e){
            throw new RuntimeException("Chyba při zápisu do souboru " + soubor + ": " + e.getLocalizedMessage());
        }
    }
}