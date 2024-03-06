package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnDate {

    public static String returnDate() {

       /* LocalDate ahora = LocalDate.now();
        int dia = ahora.getDayOfMonth();
        int mes = ahora.getMonthValue();
        int ano = ahora.getYear();
        System.out.println("dia -> " + dia);
        System.out.println("mes -> " + mes);
        System.out.println("año -> " + ano);


        LocalTime horaActual = LocalTime.now();
        int hora = horaActual.getHour();
        int minuto = horaActual.getMinute();
        int segundo = horaActual.getSecond();
        int nano = horaActual.getNano();
        System.out.println("Hora -> " + hora);
        System.out.println("Munutos -> " + minuto);
        System.out.println("Segundos -> " + segundo);
        System.out.println("Nanosegundos -> " + nano);
           StringBuilder fecha=new StringBuilder();
        fecha.append("ano"+ano+"mes"+mes+"dia"+dia+"hora"+hora+"minuto"+minuto+"segundo"+segundo);

*/

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String historial = hourdateFormat.format(date);


         return historial;
    }

}
