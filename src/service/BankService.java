package service;

import entity.Bank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static service.Menu.fileUtil;

public class BankService {
    public static List<Bank> banks;

    public BankService() {
        banks = new ArrayList<>();
    }

    public static List<Bank> getBanks() {
        return banks;
    }

    public static final String BANK_DATA_FILE = "bank.dat";

    public void addNewBank() {
        System.out.print("Có bao nhiêu ngân hàng muốn thêm mới: ");
        int serviceNumber;
        do {
            try{
                serviceNumber = new Scanner(System.in).nextInt();
                if (serviceNumber > 0) {
                    break;
                }
                System.out.println("Số lượng ngân hàng phải là một số nguyên dương, vui lòng nhập lại: ");
            }catch(InputMismatchException e){
                System.out.println("Số lượng ngân hàng phải là một số nguyên dương, vui lòng nhập lại: ");
            }
        } while(true);
        for (int i = 0; i < serviceNumber; i++) {
            System.out.println("Nhập thông tin cho ngân hàng thứ : " + (i + 1));
            Bank bank = new Bank();
            bank.inputInfo();
            saveBank(bank);
        }
//        Menu.fileUtil.writeDataToFile(banks, BANK_DATA_FILE);
    }

    private void saveBank(Bank bank) {
        banks.add(bank);
    }
    void showBank(){
        for (Bank bank : banks) {
            System.out.println(bank);
        }
    }
//    public Bank findBankById(int bankId) {
//        Bank result = null;
//        for (int i = 0; i < banks.size(); i++) {
//            if(banks.get(i) != null && banks.get(i).getId() == bankId){
//                result = banks.get(i);
//                break;
//            }
//        }
//        return result;
//    }

}
