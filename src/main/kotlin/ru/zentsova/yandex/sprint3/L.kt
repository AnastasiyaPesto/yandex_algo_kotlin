package ru.zentsova.yandex.sprint3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
	val reader = BufferedReader(InputStreamReader(System.`in`))
	val n = reader.readInt()
	val moneybox = reader.readInts()
	val bikePrice = reader.readInt()
	val doubleBikePrice = 2 * bikePrice

	val days = mutableListOf(-1, -1)
	var i = 0
	while (i < n) {
		if (moneybox[i] >= bikePrice) {
			days[0] = i + 1
			break
		}
		i++
	}
	i++
	while (i < n) {
		if (moneybox[i] >= doubleBikePrice) {
			days[1] = i + 1
			break
		}
		i++
	}
	println(days.joinToString(" "))
}

fun binarySearch(arr: IntArray, x: Int): Int {
	var left = 0
	var right = arr.size - 1
	var closestIdx = -1

	while (left < right) {
		var mid = left + (right - left) / 2
		if (arr[mid] == x) {
			val tmp = arr[mid]
			do {
				mid--
			} while (tmp == arr[mid])
			return mid + 1
		} else if (x < arr[mid]) {
			closestIdx = mid
			right = mid - 1
		} else {
			closestIdx = mid
			left = mid + 1
		}
	}
	return -1
}

private fun BufferedReader.readInts() = this.readLine().split(" ").map { it.toInt() }

private fun BufferedReader.readInt() = this.readLine().toInt()