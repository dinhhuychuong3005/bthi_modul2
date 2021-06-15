package model;

import validate.Validate;

import java.util.List;
import java.util.Scanner;

public class InOutPut {
    public static final Scanner sc = new Scanner(System.in);

    public static Phonebook input() {
        Phonebook phonebook = new Phonebook();
        System.out.println("Nhập vào họ tên:");
        String name = sc.nextLine();
        phonebook.setName(name);
        System.out.println("Nhập vào giới tình");
        System.out.println("1.Male \t 2.Female");
        String gender = null;
        int line = sc.nextInt();
        while (true) {
            switch (line) {
                case 1:
                    gender = "Male";
                    break;
                case 2:
                    gender = "Female";
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
            break;
        }
        phonebook.setGender(gender);
        sc.nextLine();
        System.out.println("Mời nhập vào địa chỉ:");
        String address = sc.nextLine();
        phonebook.setAddress(address);
        System.out.println("Nhập vào email:");
        String email;
        do {
            email = sc.nextLine();
            if (!Validate.valid(email, Validate.EMAIL_REGEX)) {
                System.out.println("Sai định dạng mời nhập lại");
            }
        } while (!Validate.valid(email, Validate.EMAIL_REGEX));
        phonebook.setEmail(email);
        System.out.println("Mời nhập vào nhóm người dùng");
        System.out.println("1.Nhóm người nhà \t 2.Nhóm công ti \t 3.Nhóm bạn bè");
        String group = null;
        int choice;
        choice = sc.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    group = "Nhóm người nhà";
                    break;
                case 2:
                    group = "Nhóm công ti";
                    break;
                case 3:
                    group = "Nhóm bạn bè";
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
            break;
        }
        phonebook.setGroup(group);
        sc.nextLine();
        return phonebook;
    }

    public static String inputNumberPhone() {
        System.out.println("Số điện thoại: ");
        String numberPhone;
        do {
            numberPhone = sc.nextLine();
            if (!Validate.valid(numberPhone, Validate.PHONE_REGEX)) {
                System.out.println("Mời nhập lại số điện thoại đúng định dạng");
            }
        }while (!Validate.valid(numberPhone, Validate.PHONE_REGEX));
        return numberPhone;
    }

    public static void outPut(List<Phonebook> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString1());
        }
    }
}
