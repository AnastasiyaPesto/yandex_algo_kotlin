package ru.zentsova.yandex.sprint3

import kotlin.math.pow

fun main() {
	val n = readInt()
	val array = readInts()
	println(makeBiggestNumber(array))
}

private fun makeBiggestNumber(array: List<Int>): String {
	val counter = MutableList<MutableList<Int>>(10) { mutableListOf() }
	for (num in array) {
		val idx = firstDigit(num)
		counter[idx].add(num)
	}
	val result = mutableListOf<Int>()
	for (i in counter.size - 1 downTo 0) {
		counter[i].sortDescending()
		result.addAll(counter[i])
	}
	return result.joinToString("")
}

private fun firstDigit(number: Int): Int {
	var n = number
	var size = 0
	while (n > 0) {
		n /= 10
		size++
	}
	val scale = 10.0.pow(size - 1).toInt()
	return number / scale
}

private fun readStr() = readln()

private fun readInt() = readln().toInt()

private fun readStrings() = readStr().split(" ")

private fun readInts() = readStrings().map { it.toInt() }