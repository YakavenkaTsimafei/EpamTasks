package by.epam.lab;

public class BusinessTrip {
    private String employeeAccount;
    private int transportCost;
    private int days;
    private static final int DAILY_RATE = 95;

    public BusinessTrip() {
    }

    public BusinessTrip(String employeeAccount, int transportCost, int days) {
        this.employeeAccount = employeeAccount;
        this.transportCost = transportCost;
        this.days = days;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public int getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotalCoast() {
        return transportCost + DAILY_RATE * days;
    }

    @Override
    public String toString() {
        return employeeAccount + ";" + toByn(transportCost) + ";" + days + ";" + toByn(getTotalCoast());
    }

    public void show() {
        System.out.println("Account = " + employeeAccount +
                "\nDaily rate = " + toByn(DAILY_RATE) +
                "\nTransport = " + toByn(transportCost) +
                "\nDays = " + days +
                "\nGeneral expenses = " + toByn(getTotalCoast()) + "\n");
    }

    public String toByn(int coins) {
        return String.format("%d.%d%d", coins / 100, (coins % 100) / 10, coins % 10);
    }
}
