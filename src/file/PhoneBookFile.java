package file;

import model.Phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookFile {
    public static void writeToFile(String path, List<Phonebook> list) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bf = new BufferedWriter(fw);
        String str = "tên, số điện thoại, giới tính, địa chỉ,email, group, ngày sinh\n";
        for (Phonebook e : list) {
            str += e.toString() +  "\n";
        }
        bf.write(str);
        bf.close();
        fw.close();
    }

    public static List<Phonebook> readFromFile(String path) throws IOException {
        List<Phonebook> phonebookList = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String line = bf.readLine();
        while ((line = bf.readLine()) != null) {
            String[] value = line.split(",");
            phonebookList.add(new Phonebook(value[0],value[1],value[2],value[3],value[4],value[5],value[6]));
        }
        return phonebookList;
    }
}
