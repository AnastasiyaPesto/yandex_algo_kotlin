package ru.zentsova.yandex.sprint0

private fun twoSum(arr: MutableList<Int>, k: Int): List<Int>? {
	arr.sort()
	var i = 0
	var j = arr.size - 1
	 while (i < j) {
		 val sum = arr[i] + arr[j]
		 if (sum == k) {
			 return listOf(arr[i], arr[j])
		 } else if (sum < k) {
			 i++
		 } else {
			 j--
		 }
	 }
	return null
}

fun main() {
	readInt()
	val arr = readInts()
	val k = readInt()
	val result = twoSum(arr.toMutableList(), k)
	if (result == null) {
		println("None")
	} else {
		println(result.joinToString(" "))
	}
}

private fun readInt() = readStr().toInt()
private fun readStr() = readln()
private fun readStrings() = readStr().split(" ")
private fun readInts() = readStrings().map { it.toInt() }