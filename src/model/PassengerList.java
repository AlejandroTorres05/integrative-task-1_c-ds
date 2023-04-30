package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import dataStructures.HashTable;

public class PassengerList {

    public static HashTable<String, Passenger> hashtable = new HashTable<>(36);
    static String folder = "dataBase";
    static String path = "dataBase/passengers.txt";
    ArrayList<Passenger> passengers;

    public PassengerList() {
        passengers = new ArrayList<>();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);

        Gson gson = new Gson();
        String data = gson.toJson(passengers);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }

    public void load() throws IOException {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
            Gson gson = new Gson();
            Passenger[] array = gson.fromJson(content, Passenger[].class);
            passengers.addAll(Arrays.asList(array));

            //Inserta el pasajero a la hash table
            for (Passenger p : passengers){
                hashtable.chainedHashInsert(p.getId(), p);
            }
            fis.close();
        } else {
            File f = new File(folder);
            if (!f.exists()) {
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

    public static HashTable<String, Passenger> getHashtable() {
        return hashtable;
    }

    public static void setHashtable(HashTable<String, Passenger> hashtable) {
        PassengerList.hashtable = hashtable;
    }
}
