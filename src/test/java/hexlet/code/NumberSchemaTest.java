package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    static Validator v;

    @BeforeAll
    public static void setUp() {
        v = new Validator();
    }


    @Test
    public void testNumberInit() {
        var schema = v.number();
        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(null)); // true
        assertTrue(schema.positive().isValid(null)); // true
    }

    @Test
    public void testNumberRequired() {
        var schema = v.number();
        schema.required();
        assertFalse(schema.isValid(null)); // false
    }
    @Test
    public void testNumberPositive() {
        var schema = v.number();
        schema.positive();
        assertTrue(schema.isValid(10)); // true Потому что ранее мы вызвали метод positive()
        assertFalse(schema.isValid(-10)); // false
        assertFalse(schema.isValid(0)); // false
    }

    @Test
    public void testNumberRange() {
        var schema = v.number();
        schema.range(5, 10);
        assertTrue(schema.isValid(5)); // true
        assertTrue(schema.isValid(10)); // true
        assertFalse(schema.isValid(4)); // false
        assertFalse(schema.isValid(11)); // false
    }
}
