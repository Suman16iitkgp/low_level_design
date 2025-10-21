package PaymentGateway.TransactionModule;

import java.util.List;

public class TransactionController {
    TransactionService transactionService;

    public TransactionController() {
        this.transactionService = new TransactionService();
    }

    public TransactionDTO makePayment(TransactionDTO transactionDTO) {
        try{
            return transactionService.makePayment(transactionDTO);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<TransactionDTO> getTransactionHistory(int userId){
        return transactionService.getTransactionHistory(userId);
    }
}
