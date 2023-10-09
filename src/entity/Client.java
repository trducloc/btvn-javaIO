package entity;

import constant.ClientType;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Client extends Person {
    private ClientType clientType;
    private List<SavingBook> savingBooks;

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public void setSavingBooks(List<SavingBook> savingBooks) {
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientType=" + clientType.value +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void inputInfo() {
        super.inputInfo();
        System.out.println("Chọn loại khách hàng, chọn 1 trong các loại dưới đây: ");
        System.out.println("1. Cá nhân");
        System.out.println("2. Tập thể");
        System.out.println("3. Doanh nghiệp");
        int type = 0;
        System.out.print("Lựa chọn của bạn: ");
        do {
            try {
                type = new Scanner(System.in).nextInt();
                if (type >= 1 && type <= 3) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ, chọn lại: ");
            }
        } while (true);
        switch (type) {
            case 1:
                this.setClientType(ClientType.INDIVIDUAL);
                break;
            case 2:
                this.setClientType(ClientType.COLLECTIVE);
                break;
            case 3:
                this.setClientType(ClientType.ENTERPRISE);
                break;
        }
    }

}
