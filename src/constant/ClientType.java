package constant;

public enum ClientType {
    INDIVIDUAL("Cá nhân"),
    COLLECTIVE("Tập thể"),
    ENTERPRISE("Doanh nghiệp");

    public String value;

    ClientType(String value) {
        this.value = value;
    }

}
