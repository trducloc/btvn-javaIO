package service;

import entity.Bank;
import entity.Client;
import entity.SavingBook;
import service.BankService;
import service.ClientService;
import service.SavingBookService;
import util.DataUtil;
import util.FileUtil;


import java.util.*;

public class Menu {

    private static ClientService clientService;
    private static BankService bankService;
    private static SavingBookService savingBookService;

//    public static FileUtil fileUtil = new FileUtil();
    public static void main(String[] args) {
//        initializeData();
        show();
    }

//    private void initializeData() {
//        Object clientFromFile = fileUtil.readDataFromFile(ClientService.CLIENT_DATA_FILE);
//        List<Client> clients = DataUtil.isNullOrEmpty(clientFromFile) ? new ArrayList<Client>() : (List<Client>) clientFromFile;
//
//
//        Object bankFromFile = fileUtil.readDataFromFile(BankService.BANK_DATA_FILE);
//        List<Bank> banks = DataUtil.isNullOrEmpty(bankFromFile) ? new ArrayList<Bank>() : (List<Bank>) bankFromFile;
//
//        Object savingBookFromFile = fileUtil.readDataFromFile(SavingBookService.SAVINGBOOK_DATA_FILE);
//        List<SavingBook> savingBooks = DataUtil.isNullOrEmpty(savingBookFromFile) ? new ArrayList<SavingBook>() : (List<SavingBook>) savingBookFromFile;
//    }


    public static void show() {
        while (true) {
            showMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    clientService.addNewClient();
                    break;
                case 2:
                    clientService.showClient();
                    break;
                case 3:
                    bankService.addNewBank();
                    break;
                case 4:
                    bankService.showBank();
                    break;
                case 5:
                    savingBookService.inputList();
                    break;
                case 6:
                    savingBookService.showList();
                    break;
                case 7:
                    menuSort();
                    break;
                case 8:
                    //
                    break;
                case 9:
                    return;

            }
        }
    }


    private static void menuSort() {
        System.out.println("_______________Các lựa chọn sắp xếp_______________");
        System.out.println("1. Theo Tên khách hàng.");
        System.out.println("2. Theo Số tiền gửi");
        System.out.println("3. Trở lại menu chính.");
        int x = 0;
        System.out.print("Bạn chọn: ");
        do {
            try {
                x = new Scanner(System.in).nextInt();
                if (x == 1 || x == 2) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            }
        } while(true);
        switch (x) {
            case 1:
                savingBookService.sortByClientName();
                break;
            case 2:
                savingBookService.sortByDepositAmount();
                break;
        }
    }
    private static int chooseFunction() {
        System.out.print("Xin mời nhập lựa chọn: ");
        int functionChoice = 0;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                if (functionChoice >= 1 && functionChoice <= 9) {
                    break;
                }
                System.out.print("Chức năng không hợp lệ, vui lòng lựa chọn (từ 1-8): ");
            } catch (InputMismatchException e) {
                System.out.print("Chức năng không hợp lệ, vui lòng lựa chọn (từ 1-8): ");
            }
        } while(true);
        return functionChoice;
    }
    public static void showMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Nhập danh sách khách hàng mới.");
        System.out.println("2. In ra danh sách khách hàng.");
        System.out.println("3. Nhập danh sách ngân hàng.");
        System.out.println("4. In ra danh sách ngân hàng.");
        System.out.println("5. Lập bảng danh sách hóa đơn cho mỗi khách hàng.");
        System.out.println("6. In bảng danh sách hóa đơn.");
        System.out.println("7. Sắp xếp danh sách Sổ tiết kiệm.");
        System.out.println("8. Lập bảng kê số tiền phải trả cho mỗi khách hàng.");
        System.out.println("9. Thoát");
    }

}
