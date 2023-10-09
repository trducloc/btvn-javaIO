package service;

import entity.Client;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import static service.Menu.fileUtil;

public class ClientService {
    private static List<Client> clients;
    private int totalClient;
    public ClientService() {
        clients = new ArrayList<>();
    }

    public int getTotalClient() {
        return totalClient;
    }

    public static List<Client> getClients() {
        return clients;
    }

    public static final String CLIENT_DATA_FILE = "client.dat";

    public void addNewClient() {
        System.out.print("Nhập số khách hàng muốn thêm mới: ");
        int clientNumber = -1;
        do {
            try {
                clientNumber = new Scanner(System.in).nextInt();
                if (clientNumber > 0) {
                    break;
                }
                System.out.print("Số khách hàng muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException e) {
                System.out.print("Số khách hàng muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < clientNumber; i++) {
            Client client = new Client();
            client.inputInfo();
            saveClient(client);
        }
//        fileUtil.writeDataToFile(clients, CLIENT_DATA_FILE);
    }

    private void saveClient(Client client) {
        clients.add(client);
    }
    public void showClient(){
        System.out.println(clients);
    }

    public Client searchClientById(int clientId) {
        for (Client client : clients) {
            if (client.getId() == clientId) {
                return client;
            }
        }
        return null;
    }

}
