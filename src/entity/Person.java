package entity;

import constant.ClientType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person implements InputTable {
    protected static int AUTO_ID = 10000;
    protected int id;
    protected String name;
    protected String address;
    protected String phone;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập họ tên khách hàng: ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.setAddress(new Scanner(System.in).nextLine());
        boolean validInput = false;
        do {
            try {
                System.out.print("Nhập số điện thoại: ");
                phone = new Scanner(System.in).nextLine();
                if (phone.matches("0[0-9\\s.-]{9}")) {
                    validInput = true;
                } else {
                    System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi khi nhập số điện thoại. Vui lòng nhập lại.");
                phone = new Scanner(System.in).nextLine();
            }
        } while (!validInput);
    }
}
