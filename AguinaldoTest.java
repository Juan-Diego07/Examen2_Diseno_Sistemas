import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Diego Prendas
 */
public class AguinaldoTest {

    public AguinaldoTest() {
    }

    //(La fecha inicial es posterior a la fecha de fin del cálculo del bono)
      @Test
    public void testFindbonusFechaPosterior() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("fecha posterior");
        LocalDateTime startDate = LocalDateTime.parse("2022-12-02 12:30", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-05-17 08:30", formatter);
        float amount = 300000.0F;
        float expResult = -1.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }

    //(monto superior a 300 000)
      @Test
    public void testFindbonusMontoMayor300000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Monto mayor");
        LocalDateTime startDate = LocalDateTime.parse("2022-02-01 12:00", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-03-01 12:00", formatter);
        float amount = 300001.0F;
        float expResult = 50000.1680F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
    //(monto igual a 300 000)
     @Test
    public void testFindbonusMontoIgual300000() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Monto igual");
        LocalDateTime startDate = LocalDateTime.parse("2022-01-01 12:00", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-02-01 12:00", formatter);
        float amount = 300000.0F;
        float expResult = 50000.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }
    
    

    //(fecha inicial debe ser diferente a diciembre con un año anterior de la fecha final)
    @Test
    public void testFindbonusRangoAdecuado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Rango");
        LocalDateTime startDate = LocalDateTime.parse("2021-11-30 12:00", formatter);
        LocalDateTime endDate = LocalDateTime.parse("2022-12-01 12:00", formatter);
        float amount = 300000.0F;
        float expResult = -3.0F;
        float result = Aguinaldo.findbonus(startDate, endDate, amount);
        assertEquals(expResult, result, 0);
    }


}