package entity;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank implements InputTable  {
    private static int AUTO_ID = 100;
    private int id;
    private String name;
    private float rate;


    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }

    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên ngân hàng: ");
        this.setName(new Scanner(System.in).nextLine());
        do {
            System.out.print("Nhập lãi suất tiền gửi: ");
            String interestRateString = new Scanner(System.in).nextLine();

            String interestRatePattern = "\\d+(\\.\\d+)?"; //
            Pattern pattern = Pattern.compile(interestRatePattern);
            Matcher matcher = pattern.matcher(interestRateString);

            if (matcher.matches()) {
                try {
                    double interestRate = Double.parseDouble(interestRateString);
                    System.out.println("Lãi suất hợp lệ: " + interestRate);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Không thể chuyển đổi lãi suất thành số, vui lòng nhập lại");
                }
            } else {
                System.out.println("Lỗi: Lãi suất không hợp lệ, vui lòng nhập lại");
            }
        }while(true);

    }
}
