package dvvar.training.sorting

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortingTest {

    @ParameterizedTest
    @MethodSource("unsortedArrays")
    fun quickSortShouldWorkRight(source: Array<Int>) {
        val copy = source.copyOf()
        quickSort(source)
        Arrays.sort(copy)

        Assertions.assertArrayEquals(copy, source)
    }

    fun unsortedArrays() = Stream.of(
            Arguments.of(arrayOf<Int>()),
            Arguments.of(arrayOf(1)),
            Arguments.of(arrayOf(3, 2, 1)),
            Arguments.of(arrayOf(74, 12, -12323, 33, 1, -44, 5, 3)),
            Arguments.of(arrayOf(1, 11, -1, 0, -1111, -11111111, 123, 22, -22, 45, 95, 100, -100, 73, 63, -77))
    )

    @Test
    fun debug() {
        quickSort(arrayOf(3, 2, 1))
    }
}