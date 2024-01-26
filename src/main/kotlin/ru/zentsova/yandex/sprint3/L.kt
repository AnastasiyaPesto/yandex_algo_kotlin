package ru.zentsova.yandex.sprint3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
	val reader = BufferedReader(InputStreamReader(System.`in`))
	reader.readInt()
	val moneybox = reader.readInts()
	val bikePrice = reader.readInt()
	val doubleBikePrice = 2 * bikePrice

	val day1 = binarySearch(moneybox.toIntArray(), bikePrice)
	val day2 = binarySearch(moneybox.toIntArray(), doubleBikePrice)
	println("${if (day1 == -1) -1 else day1 + 1} ${if (day2 == -1) -1 else day2 + 1}")
}

fun binarySearch(arr: IntArray, x: Int): Int {
	var left = 0
	var right = arr.size - 1
	var res = -1

	while (left < right) {
		var mid = left + (right - left) / 2
		if (arr[mid] == x) {
			res = mid
			break
		} else if (right - left == 1) {
			res = if (arr[left] == x) left else right
			break
		} else if (arr[mid] > x) {
			right = mid
		} else {
			left = mid
		}
	}

	res = if (arr[left] == x) left else right

	if (arr[res] < x)
		return -1

	if (res > 0) {
		val num = arr[res]

		while (arr[res - 1] == num) {
			 res--
		}
	}

	return res
}

private fun BufferedReader.readInts() = this.readLine().split(" ").map { it.toInt() }

private fun BufferedReader.readInt() = this.readLine().toInt()