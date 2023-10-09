package entity;

import java.util.List;

public class SavingBookDetail {
    private Client client;
    private List<SavingBook> details;


    public SavingBookDetail(Client client, List<SavingBook> details) {
    }

    public Client getClient() {
        return client;
    }
}
