import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        Path path = Path.of("data", "vyprava.json");
        String obsah = Files.readString(path);
        JSONObject root = new JSONObject(obsah);

        JSONArray opicky = new JSONArray(root.getJSONArray("opicky"));
        JSONArray koberce = new JSONArray(root.getJSONArray("koberce"));

        int pocetOpicek = 0;
        for (int i = 0; i < opicky.length(); i++) {
            System.out.println((i + 1) + ". " + opicky.getString(i));
            pocetOpicek++;
        }
        System.out.println("Počet opiček je: " + pocetOpicek);

        for (int i = 0; i < koberce.length(); i++) {
            JSONObject koberec = koberce.getJSONObject(i);
            System.out.println("ID: " +koberec.getInt("id") + " Název: " + koberec.getString("nazev")
                    + " Nosnost "+koberec.getInt("nosnost")+" Dostupnost " + koberec.getBoolean("aktivni"));
        }

        /*System.out.println("Názvy a nosnosti všech vhodných koberců.");
        JSONObject koberec = koberce.getJSONObject(i);
        if (koberec.getBoolean("aktivni")==true && koberec.getString("vybava").contains("kompas")) {
            System.out.println("Název: " + koberec.getString("nazev") + " Nosnost "+koberec.getInt("nosnost"));
        }*/


    }
}