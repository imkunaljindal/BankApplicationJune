import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{

    private String name;
    private String accountNo; // random and unique --> UUID
    private double balance;
    private String password;

    final double rateOfInterest = 6.1;

    // default/No Argument constructor
    public HDFCAccount() {
    }

    // All argument constructor
    public HDFCAccount(String name, double balance, String password) {
        this.name = name;
        this.accountNo = String.valueOf(UUID.randomUUID());
        this.balance = balance;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String fetchBalance(String password) {

        if(this.password.equals(password)){
            return "Your current balance is: " + this.balance;
        }
        return "Incorrect Password!";
    }

    @Override
    public double addMoney(double amount) {
        this.balance += amount;
        return balance;
    }

    @Override
    public String withdrawMoney(String password, double amount) {

        if(this.password.equals(password)){
            if(amount<=this.balance){
                this.balance -= amount;
                return "Money has been withdrawn. The remaining balance is: "+this.balance;
            }
            else{
                return "Insufficient balance";
            }
        }
        return "Incorrect Password";
    }

    @Override
    public String changePassword(String newPassword, String oldPassword) {

        if(this.password.equals(oldPassword)){
          this.password = newPassword;
          return "Congrats! Your password has been updated!!";
        }
        return "Incorrect password";
    }

    @Override
    public double calculateInterest(int years) {
        return (this.balance*rateOfInterest*years)/100;
    }
}
