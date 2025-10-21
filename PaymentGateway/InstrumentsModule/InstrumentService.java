package PaymentGateway.InstrumentsModule;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class InstrumentService {
    Map<Integer, List<Instrument>> instrumentsMap = new TreeMap<>();

    public abstract void addInstrument(InstrumentDTO instrumentDTO);

    public abstract List<InstrumentDTO> getInstrumentsByUser( int userId);

}
