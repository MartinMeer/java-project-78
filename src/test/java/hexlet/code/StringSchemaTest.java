package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    static Validator v;

    @BeforeAll
    public static void setUp() {
        v = new Validator();
    }

    @Test
    public void testStringsInit() {
        var schema = v.string();
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }
    @Test
    public void testStringsRequired() {
        var schema = v.string();

        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say")); // true
        assertTrue(schema.isValid("hexlet")); // true*/
    }

    @Test
    public void testStringsContains() {
        var schema = v.string();
        assertTrue(schema.contains("wh").isValid("what does the fox say")); // true
        assertTrue(schema.contains("what").isValid("what does the fox say")); // true

        assertFalse(schema.contains("whatthe").isValid("what does the fox say")); // false
        assertFalse(schema.isValid("what does the fox say")); // false Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
    }

    // Если один валидатор вызывался несколько раз
    // то последний имеет приоритет (перетирает предыдущий)
    @Test
    public void testStringsMinLength() {
        var schema1 = v.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("Hexlet"));// true
    }
}
