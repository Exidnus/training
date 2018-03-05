package dvvar.training.sorting

fun quickSort(arr: Array<Int>) {
    quickSortPart(arr, 0, arr.size - 1)
}

private fun quickSortPart(arr: Array<Int>, fromIncl: Int, toIncl: Int) {
    if (fromIncl < toIncl) {
        val separatorIndex = partition(arr, fromIncl, toIncl)
        quickSortPart(arr, fromIncl, separatorIndex - 1)
        quickSortPart(arr, separatorIndex, toIncl)
    }
}

private fun partition(arr: Array<Int>, fromIncl: Int, toIncl: Int): Int {
    val separator = arr[toIncl]
    var i = fromIncl - 1
    for (j in fromIncl until toIncl) {
        if (arr[j] <= separator) {
            i++
            swap(arr, i, j)
        }
    }
    swap(arr, i + 1, toIncl)
    return i + 1
}

private fun swap(arr: Array<Int>, firstIndex: Int, secondIndex: Int) {
    val temp = arr[firstIndex]
    arr[firstIndex] = arr[secondIndex]
    arr[secondIndex] = temp
}