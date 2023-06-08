import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create first HDFC account
        HDFCAccount hdfcAccount1 = new HDFCAccount("Sachin",1000,"abc123");
        System.out.println("Congrats! "+hdfcAccount1.getName()+
                " Your account has been created with account number: "+
                hdfcAccount1.getAccountNo());

        // create second hdfc account
        HDFCAccount hdfcAccount2 = new HDFCAccount("Mahesh",2000,"123");
        System.out.println("Congrats! "+hdfcAccount2.getName()+
                " Your account has been created with account number: "+
                hdfcAccount2.getAccountNo());

        // add money to account 1
        System.out.println("Money has been added. New balance is: "+hdfcAccount1.addMoney(100000));

        // withdraw - both cases
        System.out.println(hdfcAccount1.withdrawMoney("xyqa",500000));
        System.out.println(hdfcAccount1.withdrawMoney("abc123",50000));

        // fetch balance for account 1
        System.out.println(hdfcAccount1.fetchBalance("abc123"));

        // change password for account 1
        System.out.println(hdfcAccount1.changePassword("password","abc123"));

        // calculate interest
        System.out.println("Enter the number of years to calculate interest");
        int years = sc.nextInt();
        System.out.println("Interest for "+years+" years is: "+hdfcAccount1.calculateInterest(years));
    }
}