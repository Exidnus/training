package dvvar.training.brackets

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BracketsTest {

    @ParameterizedTest
    @ValueSource(strings = arrayOf("(){}[]", "(({{[[{{(())}}]]}}))", "({})[[{}]](){}[[]]", ""))
    fun validBracesShouldReturnTrue(brackets: String) = assertTrue(validBraces(brackets))

    @ParameterizedTest
    @ValueSource(strings = arrayOf("ad(){}[[]]", "][", "(({{[[]}}))", "(({{][}}))", "()(){}[[]]()){}"))
    fun validBracesShouldReturnFalse(brackets: String) = assertFalse(validBraces(brackets))
}