package controller;


import file.PhoneBookFile;
import model.InOutPut;
import model.Phonebook;
import service.ManagePhoneBook;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagePhoneBook managePhoneBook = new ManagePhoneBook();
        while (true) {
            System.out.println("======Chương trình quản lý danh bạ===");
            System.out.println("Chọn chức năng theo số");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi vào file");
            System.out.println("8.Thoát");
            System.out.print("  Chọn chức năng:  ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    InOutPut.outPut(managePhoneBook.getPhonebookList());
                    break;
                }
                case 2: {
                    Phonebook phonebook = new Phonebook();

                    phonebook = InOutPut.input();
                    String number = InOutPut.inputNumberPhone();
                    phonebook.setNumberPhone(number);
                    managePhoneBook.add(phonebook);
                    break;
                }
                case 3: {


                    String number = InOutPut.inputNumberPhone();
                    Phonebook phonebook = InOutPut.input();
                    phonebook.setNumberPhone(number);
                    managePhoneBook.edit(number, phonebook);
                    break;
                }
                case 4: {
                    String number = InOutPut.inputNumberPhone();
                    managePhoneBook.deleteByNumberPhone(number);
                    break;
                }
                case 5: {
                    boolean check = true;
                    while (check) {
                        System.out.println("1.Tìm kiếm theo tên");
                        System.out.println("2.Tìm kiếm theo số điện thoại");
                        System.out.println("0.quay lại menu");
                        int i = scanner.nextInt();
                        scanner.nextLine();
                        switch (i) {
                            case 1: {
                                System.out.println("Nhập vào tên muốn tìm");
                                String name = scanner.nextLine();
                                List<Phonebook> list = managePhoneBook.findByName(name);
                                InOutPut.outPut(list);
                                break;
                            }
                            case 2: {
                                String number = InOutPut.inputNumberPhone();
                                managePhoneBook.findByNumber(number);
                                break;
                            }
                            case 0: {
                                check = false;
                                break;
                            }
                            default:
                                System.out.println("Không có chức năng cần tìm");
                                break;
                        }
                    }
                    break;
                }
                case 6:{
                    try {
                        List<Phonebook> list = PhoneBookFile.readFromFile("PhoneBook.csv");
                        InOutPut.outPut(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7:{
                    try {
                        PhoneBookFile.writeToFile("PhoneBook.csv",managePhoneBook.getPhonebookList());
                        System.out.println("Done");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 8:{
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Không có chức năng cần tìm");
                    break;
            }
        }

    }
}
