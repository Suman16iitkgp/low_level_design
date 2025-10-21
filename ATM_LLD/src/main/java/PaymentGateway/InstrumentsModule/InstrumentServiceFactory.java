package PaymentGateway.InstrumentsModule;

public class InstrumentServiceFactory
{

    public InstrumentService getInstrumentService(InstrumentType instrumentType)
    {
        if(instrumentType == InstrumentType.BANK){
            return new BankService();
        }

        return new BankService();
    }
}
