package dvvar.training.sorting

fun quickSort(arr: Array<Int>) {
    quickSortPart(arr, 0, arr.size - 1)
}

private fun quickSortPart(arr: Array<Int>, fromIncl: Int, toIncl: Int) {
    if (arr.alreadySorted() || toIncl - fromIncl < 2) return

    var indexSupportingElem = toIncl
    var current = fromIncl
    while (current < indexSupportingElem) {
        if (arr[current] < arr[indexSupportingElem]) {
            swap(arr, indexSupportingElem, indexSupportingElem - 1)
            swap(arr, indexSupportingElem, current)
            indexSupportingElem--
        } else {
            current++
        }
    }

    quickSortPart(arr, fromIncl, current - 1)
    quickSortPart(arr, current + 1, toIncl)
}

private fun Array<Int>.alreadySorted() = this.isEmpty() || this.size == 1

private fun swap(arr: Array<Int>, firstIndex: Int, secondIndex: Int) {
    val temp = arr[firstIndex]
    arr[firstIndex] = arr[secondIndex]
    arr[secondIndex] = temp
}