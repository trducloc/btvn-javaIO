package service;

import entity.Client;
import entity.SavingBook;

import java.util.*;


public class SavingBookService {
    private ClientService clientService;

    private BankService bankService;
    private static List<SavingBook> savingBooks;
    private static List<Client> clients;


    public static final String SAVINGBOOK_DATA_FILE = "savingBook.dat";

    public SavingBookService(ClientService clientService, BankService bankService) {
        this.clientService = clientService;
        this.bankService = bankService;
        this.savingBooks = new ArrayList<>();

    }


    public void inputList() {
        if (!isEmpty()) {
            System.out.println("Chưa có thông tin khách hàng, vui lòng nhập trước.");
            return;
        }
        System.out.println("Nhập số lượng khách hàng muốn lập danh sách:");
        int clientNumber;
        do {
            try {
                clientNumber = new Scanner(System.in).nextInt();
                if (clientNumber > 0 && clientNumber <= clientService.getTotalClient()) {
                    break;
                }
                System.out.println("Số lượng khách hàng cần lập danh sách phải là một số nguyên dương và nhỏ hơn tổng số lượng khách hàng của ngân hàng.");
            }catch(InputMismatchException e){
                System.out.println("Số lượng khách hàng cần lập danh sách phải là một số nguyên dương");
            }
        } while (true);
        for (int i = 0; i < clientNumber; i++) {
            System.out.println("Nhập thông tin cho khách hàng thứ: " + (i + 1));
            Client client = inputClientForList();
            System.out.print("Số lượng sổ tiết kiệm: ");
            int numSavingBooks = new Scanner(System.in).nextInt();

            if (numSavingBooks > 5) {
                System.out.println("Số lượng sổ tiết kiệm không được vượt quá 5. Vui lòng nhập lại.");
            }
            List<SavingBook> savingBooks = new ArrayList<>();
            for (int j = 0; j < numSavingBooks; j++) {
                System.out.println("Nhập thông tin sổ tiết kiệm " + (j + 1));
                SavingBook savingBook = new SavingBook();

                System.out.print("Số tiền gửi: ");
                double depositAmount = new Scanner(System.in).nextDouble();
                savingBook.setDepositAmount(depositAmount);
                savingBooks.add(savingBook);
            }
            client.setSavingBooks(savingBooks);
            clients.add(client);

        }
        showList();
    }



    void showList() {
        System.out.println(savingBooks);
    }

    private void saveList(SavingBook savingBook) {
        savingBooks.add(savingBook);
    }
    private Client inputClientForList() {
        System.out.println("Nhập mã khách hàng : ");
        int clientId;
        Client client;
        do{
            clientId = new Scanner(System.in).nextInt();
            client = clientService.searchClientById(clientId);
            if(client != null){
                break;
            }
            System.out.print("Không tồn tại khách hàng mang mã " + clientId + ", vui lòng nhập lại: ");
        }while (true);
        return client;
    }

    public void sortByDepositAmount(){
        if (savingBooks.isEmpty()) {
            System.out.println("Chưa có thông tin danh sách, vui lòng nhập trước khi thực hiện.");
            return;
        }
        Collections.sort(savingBooks, new Comparator<SavingBook>() {
            @Override
            public int compare(SavingBook st1, SavingBook st2) {
                return Double.compare(st1.getDepositAmount(), st2.getDepositAmount());
            }
        });
        showSavingBook();
    }
    public void sortByClientName() {
        if (savingBooks.isEmpty()) {
            System.out.println("Chưa có thông tin danh sách, vui lòng nhập trước khi thực hiện.");
            return;
        }
        Collections.sort(savingBooks, new Comparator<SavingBook>() {
            @Override
            public int compare(SavingBook o1, SavingBook o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                String name1 = o1.getClient().getName().trim().toLowerCase();
                String name2 = o2.getClient().getName().trim().toLowerCase();
                return name1.compareTo(name2);
            }
        });
        showSavingBook();
    }
    private void showSavingBook() {
        System.out.println(savingBooks);
    }
    public boolean isEmpty() {
        if (ClientService.getClients().isEmpty() || bankService.getBanks().isEmpty()) {
            return false;
        }
        return true;
    }


}
