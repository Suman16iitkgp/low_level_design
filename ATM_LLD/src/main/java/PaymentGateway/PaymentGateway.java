package PaymentGateway;

import PaymentGateway.InstrumentsModule.InstrumentController;
import PaymentGateway.TransactionModule.TransactionController;
import PaymentGateway.User.UserController;

public class PaymentGateway {

    InstrumentController instrumentController;
    UserController userController;
    TransactionController transactionController;

    public static PaymentGateway instance;

    private PaymentGateway(InstrumentController  instrumentController, UserController userController, TransactionController transactionController) {
        this.instrumentController = instrumentController;
        this.userController = userController;
        this.transactionController = transactionController;
    }

    public static PaymentGateway getInstance(){
        if(instance == null){
            instance = new PaymentGateway(new InstrumentController(), new UserController(), new TransactionController());
        }
        return instance;
    }




}
