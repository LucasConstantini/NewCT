package cleartrip.app;

import cleartrip.model.ServiceLocator;
import cleartrip.model.pojo.Viagem;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Integer ano, mes, dia, hora, minuto;
        Viagem v;

        v = ServiceLocator.getViagemService().readById(2L);

        String[] auxDataInicio = v.getDataPartida().split("/");
        String[] auxHoraInicio = v.getHoraPartida().split(":");

        dia = Integer.parseInt(auxDataInicio[0]);
        mes = Integer.parseInt(auxDataInicio[1]);
        ano = Integer.parseInt(auxDataInicio[2]);
        hora = Integer.parseInt(auxHoraInicio[0]);
        minuto = Integer.parseInt(auxHoraInicio[1]);
        
        DateTime dataInicio = new DateTime(ano, mes, dia, hora, minuto);

        String[] auxDataFim = v.getDataVolta().split("/");
        String[] auxHoraFim = v.getHoraVolta().split(":");

        dia = Integer.parseInt(auxDataFim[0]);
        mes = Integer.parseInt(auxDataFim[1]);
        ano = Integer.parseInt(auxDataFim[2]);
        hora = Integer.parseInt(auxHoraFim[0]);
        minuto = Integer.parseInt(auxHoraFim[1]);

        DateTime dataFim = new DateTime(ano, mes, dia, hora, minuto);

        int dias = Days.daysBetween(dataInicio, dataFim).getDays();

        System.out.println(dias);

    }

}
