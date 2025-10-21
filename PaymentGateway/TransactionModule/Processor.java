package PaymentGateway.TransactionModule;

import PaymentGateway.InstrumentsModule.InstrumentDTO;

public interface Processor {
    TransactionStatus processPayment(InstrumentDTO senderInstrumentDTO, InstrumentDTO receiverInstrumentDTO, int amount);
}
