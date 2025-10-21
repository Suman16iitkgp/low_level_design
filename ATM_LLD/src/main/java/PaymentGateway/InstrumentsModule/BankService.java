package PaymentGateway.InstrumentsModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BankService extends InstrumentService {

    @Override
    public void addInstrument(InstrumentDTO instrumentDTO) {
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentId = new Random().nextInt(10000);
        bankInstrument.accountNumber = instrumentDTO.accountNumber;
        bankInstrument.iban = instrumentDTO.iban;
        bankInstrument.type = InstrumentType.BANK;
        bankInstrument.userId = instrumentDTO.userId;

        if(!instrumentsMap.containsKey(bankInstrument.userId)){
            instrumentsMap.put(bankInstrument.userId, new ArrayList<>());
        }
        instrumentsMap.get(bankInstrument.userId).add(bankInstrument);

    }

    @Override
    public List<InstrumentDTO> getInstrumentsByUser(int userId) {
        if(!instrumentsMap.containsKey(userId)) return new ArrayList<>();

        return instrumentsMap.get(userId).stream().map(this::convertInstrument).collect(Collectors.toList());

    }

    public InstrumentDTO convertInstrument(Instrument instrument){
        InstrumentDTO instrumentDTO = new InstrumentDTO();
        instrumentDTO.userId = instrument.userId;
        return instrumentDTO;
    }
}
