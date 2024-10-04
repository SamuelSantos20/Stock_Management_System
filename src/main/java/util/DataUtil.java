package util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class DataUtil {

	
    public static Date ajustarDataParaBrasil(Date data) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);

        calendario.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));

        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.MILLISECOND, 0);

        return calendario.getTime();
    }

    public static void main(String[] args) {
        Date dataAtual = new Date();
        System.out.println("Data original: " + dataAtual);

        Date dataAjustada = ajustarDataParaBrasil(dataAtual); 
        System.out.println("Data ajustada: " + dataAjustada);
    }
	
	
}
