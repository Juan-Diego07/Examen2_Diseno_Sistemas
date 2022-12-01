import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Aguinaldo {
    public static float findbonus(LocalDateTime startDate, LocalDateTime endDate, float amount ){
        if( amount >= 300000) {
            if(startDate.isAfter(endDate)){
                return -1; // no cumple salario minimo
            } else {
                if(! startDate.getMonth().equals(Month.DECEMBER) && (endDate.getYear() - startDate.getYear()) >=1 ) {
                    return -3; // el aguinaldo se calcula con el mes anterior del anno solamente
                } else {
                      System.out.println(" - " +(endDate.getYear() - startDate.getYear()));
                    if(startDate.getMonth().equals(Month.DECEMBER) && (endDate.getYear() - startDate.getYear()) == 1) {
                           return bonus(ChronoUnit.MONTHS.between(startDate, endDate) + 1, amount);
                    } else {
                       long moth = ChronoUnit.MONTHS.between(startDate, endDate)+ 1;
                        System.out.println(moth);
                        return bonus(moth, amount);
                    }
                }
            }
        }
        return -2;
    }
    
        public static float bonus(long moth, float amount ){
          return  amount/12 * moth;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime startDate = LocalDateTime.parse("2022-01-09 10:30" , formatter);
        LocalDateTime endDate = LocalDateTime.parse("2023-03-09 10:30", formatter);
        
        float amount = 1000000;
        float a = 0;
        as = findbonus(startDate,endDate,amount );
        
         System.out.println(as);
        
    }
    
}
