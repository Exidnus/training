package dvvar.training

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestTest {

    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 134

    @Test
    fun fibLargeShouldWorkProperly() {
        assertEquals(1, fibLarge(10, 2, 3))
        assertEquals(5, fibLarge(10, 10, 3))
        assertEquals(5, fibLarge(10, 10, 100))
        assertEquals(0, fibLarge(9, 2, 3))
        assertEquals(4, fibLarge(9, 10, 3))
        assertEquals(4, fibLarge(9, 10, 100))
        assertEquals(1, fibLarge(8, 2, 3))
        assertEquals(1, fibLarge(8, 10, 3))
        assertEquals(1, fibLarge(8, 10, 100))
    }
}