import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.ATM;
import ru.otus.CashType;
import ru.otus.Client;

import java.util.LinkedHashMap;
import java.util.Map;

public class testsATM {
    private ATM atm;

    @BeforeEach
    public void before() {
        atm = new ATM();
        atm.addNewClient(new Client(1L, 543000L));
    }

    @Test
    public void getCashTest() {
        Map<CashType, Long> expect = new LinkedHashMap<>();
        expect.put(CashType.TWO_THOUSAND, 1L);
        expect.put(CashType.TWO_HUNDRED, 1L);
        expect.put(CashType.HUNDRED, 1L);

        Assertions.assertEquals(expect, atm.takeCash(1L, 2300L));
    }

    @Test
    public void getCashATMDoesntFoundCashExceptionTest() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> atm.takeCash(1L, 300000L));

        Assertions.assertEquals("Cash not found!", exception.getMessage());
    }

    @Test
    public void getCashClientDoesntFoundMoneyException() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> atm.takeCash(1L, 3000000L));
        Assertions.assertEquals("Client doesn't have so much money!", exception.getMessage());
    }

    @Test
    public void clientPersistException() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> atm.takeCash(2L, 3000000L));
        Assertions.assertEquals("Client not found", exception.getMessage());
    }

    @Test
    public void clientIsPersistException() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> atm.addNewClient(new Client(1L, 1200L)));
        Assertions.assertEquals("This client is persist!", exception.getMessage());
    }
}
