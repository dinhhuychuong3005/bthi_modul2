package service;

import file.PhoneBookFile;
import model.InOutPut;
import model.Phonebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagePhoneBook {
    private List<Phonebook> phonebookList = new ArrayList<>();

    public ManagePhoneBook() {
        try {
            this.phonebookList = PhoneBookFile.readFromFile("PhoneBook.csv");
        } catch (IOException e) {
            this.phonebookList = new ArrayList<>();
        }
    }

    public List<Phonebook> getPhonebookList() {
        return phonebookList;
    }

    public void setPhonebookList(List<Phonebook> phonebookList) {
        this.phonebookList = phonebookList;
    }

    public void add(Phonebook phonebook) {
        phonebookList.add(phonebook);

    }

    public int checkNumberPhone(String number) {
        for (int i = 0; i < phonebookList.size(); i++) {
            if (number.equals(phonebookList.get(i).getNumberPhone())) {
                return i;
            }
        }
        return -1;
    }

    public void edit(String numberPhone, Phonebook phonebook) {
        if (checkNumberPhone(numberPhone) == -1) {
            System.out.println("Số điện thoại không tồn tại");
        } else {
            phonebookList.set(checkNumberPhone(numberPhone), phonebook);
            try {
                PhoneBookFile.writeToFile("PhoneBook.csv", this.phonebookList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Danh bạ sau khi sửa");
            InOutPut.outPut(this.phonebookList);
        }
    }

    public void deleteByNumberPhone(String numberPhone) {
        Scanner scanner = new Scanner(System.in);
        if (checkNumberPhone(numberPhone) == -1) {
            System.out.println("Số điện thoại không tồn tại");
        } else {
            System.out.println("Bạn có chắc muốn xóa không?");
            System.out.println("1.Có \t 2.Không");
            int op = scanner.nextInt();
            if (op == 1) {
                phonebookList.remove(checkNumberPhone(numberPhone));
                try {
                    PhoneBookFile.writeToFile("PhoneBook.csv", this.phonebookList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Danh bạ sau khi xóa:");
                InOutPut.outPut(this.phonebookList);
            } else if (op == 2) {
                System.out.println("Danh bạ vẫn giữ nguyên");
            } else System.out.println();
        }
    }

    public void findByNumber(String numberPhone) {
        if (checkNumberPhone(numberPhone) == -1) {
            System.out.println("Số điện thoại không tồn tại");
        } else {
            System.out.println("Thông tin số điện thoại cần tìm là");
            System.out.println(phonebookList.get(checkNumberPhone(numberPhone)).toString1());
        }
    }

    public void printByNumber(){
        for (int i = 0; i < phonebookList.size(); i++) {
            System.out.println(phonebookList.get(i).getName());
        }
    }

    public List<Phonebook> findByName(String name) {
        List<Phonebook> phonebooks = new ArrayList<>();
        for (int i = 0; i < phonebookList.size(); i++) {
            if (phonebookList.get(i).getName().contains(name)) {
                phonebooks.add(phonebookList.get(i));
            }
        }
        return phonebooks;
    }

}