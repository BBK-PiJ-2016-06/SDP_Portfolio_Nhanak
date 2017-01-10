public class Driver {

    public static void main(String[] args) {

        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();

        //Class baCls = BankAccount.class;
        Class<BankAccount> baCls = BankAccount.class;

        try {
            //Object myAccount = baCls.newInstance();
            BankAccount myAccount = baCls.newInstance();
            //BankAccount myAccount = (BankAccount) baCls.newInstance(); - need to do if you run 'Class baCls = BankAccount.class;'

            aStorage.setValue(myAccount);
            // Deposit
            myAccount.deposit(15);
        }
        catch ( InstantiationException e ) {
            e.printStackTrace();
        }
        catch ( IllegalAccessException e ) {
            e.printStackTrace();
        }

        System.out.println( aStorage.getValue().showBalance() );
        if( aStorage.getClass() == sStorage.getClass() ) {
            System.out.println( "EQUAL" );
        } else {
            System.out.println( "NOT EQUAL" );
        }

    }
}