import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    long amount;
    boolean isRegistered;
    long expected;
    long actual;

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 1000;
        isRegistered = true;
        expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 1_000_000;
        isRegistered = true;
        expected = 500;

        // вызываем целевой метод:
        actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndAmountEqualZero() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 0;
        isRegistered = true;
        expected = 0;

        // вызываем целевой метод:
        actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 10_000;
        isRegistered = false;
        expected = 100;

        // вызываем целевой метод:
        actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 7_000_001;
        isRegistered = false;
        expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndEqualLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 50_000;
        isRegistered = false;
        expected = 500;

        // вызываем целевой метод:
        actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndAmountEqualZero() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        amount = 0;
        isRegistered = false;
        expected = 0;

        // вызываем целевой метод:
        actual = service.calculate(amount, isRegistered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}