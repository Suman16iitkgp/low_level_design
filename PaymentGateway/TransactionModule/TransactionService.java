package PaymentGateway.TransactionModule;

import PaymentGateway.InstrumentsModule.InstrumentController;
import PaymentGateway.InstrumentsModule.InstrumentDTO;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionService {
    Processor processor;
    InstrumentController instrumentController;
    Map<Integer, List<Transaction>> transactionMap;

    public TransactionService() {
        this.processor = new Processor() {
            @Override
            public TransactionStatus processPayment(InstrumentDTO senderInstrumentDTO, InstrumentDTO receiverInstrumentDTO, int amount) {
                // Mocked method for payment processing
                return TransactionStatus.SUCCESS;
            }
        };
        transactionMap = new TreeMap<>();
    }

    public TransactionDTO makePayment(TransactionDTO transaction) {
        try{
            InstrumentDTO senderInstrumentDTO = instrumentController.getInstrumentById(transaction.getSenderUserId(), transaction.getDebitInstrumentId());
            InstrumentDTO receiverInstrumentDTO = instrumentController.getInstrumentById(transaction.getReceiverUserId(), transaction.getDebitInstrumentId());
            int amount = transaction.getAmount();

            TransactionStatus paymentStatus = processor.processPayment(senderInstrumentDTO, receiverInstrumentDTO, amount);
            Transaction txn = new Transaction();
            txn.setAmount(amount);
            txn.setTransactionId(new Random().nextInt(1000));
            txn.setSenderUserId(txn.getSenderUserId());
            txn.setReceiverUserId(txn.getReceiverUserId());
            txn.setDebitInstrumentId(txn.getDebitInstrumentId());
            txn.setCreditInstrumentId(txn.getCreditInstrumentId());
            txn.setTransactionStatus(paymentStatus);

            if(!transactionMap.containsKey(txn.getSenderUserId())){
                transactionMap.put(txn.getSenderUserId(),new ArrayList<>());
            }

            if(!transactionMap.containsKey(txn.getReceiverUserId())){
                transactionMap.put(txn.getReceiverUserId(),new ArrayList<>());
            }
            transactionMap.get(txn.getSenderUserId()).add(txn);
            transactionMap.get(txn.getReceiverUserId()).add(txn);

            transaction.setTransactionId(txn.getTransactionId());
            transaction.setTransactionStatus(paymentStatus);
            return transaction;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<TransactionDTO> getTransactionHistory(int userId){
        if(!transactionMap.containsKey(userId)) return new ArrayList<>();
        return transactionMap.get(userId).stream().map(this::convertTransaction).collect(Collectors.toList());
    }

    private TransactionDTO convertTransaction(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionId(transaction.getTransactionId());
        transactionDTO.setSenderUserId(transaction.getSenderUserId());
        transactionDTO.setReceiverUserId(transaction.getReceiverUserId());
        transactionDTO.setDebitInstrumentId(transaction.getDebitInstrumentId());
        transactionDTO.setCreditInstrumentId(transaction.getCreditInstrumentId());
        transactionDTO.setAmount(transaction.getAmount());
        return transactionDTO;
    }
}
