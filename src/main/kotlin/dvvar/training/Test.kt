package dvvar.training

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 134

fun main(args: Array<String>) {
    val (num, mod) = readLine()?.split(" ")?.map { it.toLong() } ?: throw Exception()
    val result = fibLarge(num, mod, 100)
    println(result)
}

fun fibLarge(num: Long, mod: Long, arraySize: Int): Long {
    val arraysCount = if ((num + 1) % arraySize == 0L) {
        (num + 1) / arraySize
    } else {
        ((num + 1) / arraySize) + 1
    }
    val arrays = Array(arraysCount.toInt()) { LongArray(arraySize) }
    arrays[0][0] = 0
    arrays[0][1] = 1
    var count = 1L
    for (arrayNum in 0 until arrays.size) {
        val firstNumInInnerLoop = if (arrayNum == 0) 2 else 0
        val currentArray = arrays[arrayNum]
        for (i in firstNumInInnerLoop until currentArray.size) {
            count++
            if (i > 1) {
                currentArray[i] = (currentArray[i - 1] + currentArray[i - 2]).thisOrMod(mod)
            } else {
                val prevArray = arrays[arrayNum - 1]
                if (i == 0) {
                    currentArray[i] = (prevArray.last() + prevArray[arraySize - 1 - 1]).thisOrMod(mod)
                } else {
                    currentArray[i] = (currentArray[0] + prevArray.last()).thisOrMod(mod)
                }
            }
            if (count == num) {
                return currentArray[i]
            }
        }
    }
    throw Exception("Should return num from inner cycle.")
}

private fun Long.thisOrMod(mod: Long) = if (this < mod) this else this % mod

