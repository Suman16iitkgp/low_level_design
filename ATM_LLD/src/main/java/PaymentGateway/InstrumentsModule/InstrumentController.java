package PaymentGateway.InstrumentsModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstrumentController {
    InstrumentServiceFactory instrumentServiceFactory;

    public InstrumentController() {
        this.instrumentServiceFactory = new InstrumentServiceFactory();
    }

    public void addInstrument(InstrumentDTO instrumentDTO){
        InstrumentService instrumentService = instrumentServiceFactory.getInstrumentService(instrumentDTO.instrumentType);
        instrumentService.addInstrument(instrumentDTO);
    }

    public List<InstrumentDTO> getAllInstruments(int userId){
        InstrumentService bankInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.BANK);
        InstrumentService cardInstrumentService = instrumentServiceFactory.getInstrumentService(InstrumentType.CARD);

        List<InstrumentDTO> instrumentDTOList = bankInstrumentService.getInstrumentsByUser(userId);
        instrumentDTOList.addAll(cardInstrumentService.getInstrumentsByUser(userId));

        return instrumentDTOList;
    }

    public InstrumentDTO getInstrumentById(int userId, int instrumentId){
        List<InstrumentDTO> instrumentDTOList = getAllInstruments(userId);

        return instrumentDTOList.stream().filter(instrumentDTO -> instrumentId == instrumentDTO.instrumentId).findFirst().orElse(null);
    }

 }

