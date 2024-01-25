package ru.zentsova.yandex.sprint3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
	val reader = BufferedReader(InputStreamReader(System.`in`))
	val n = reader.readInt()
	val moneybox = reader.readInts()
	val bikePrice = reader.readInt()
	val doubleBikePrice = 2 * bikePrice

	val day = binarySearch2(moneybox.toIntArray(), bikePrice)
//	println(days.joinToString(" "))
	println(day)
}

fun binarySearch2(arr: IntArray, x: Int): Int {
	var left = 0
	var right = arr.size - 1
	var res = -1

	while (left < right) {
		var mid = left + (right - left) / 2
		if (arr[mid] == x) {
			res = mid
			break
		} else if (right - left != 1) {
			if (arr[mid] > x) {
				right = mid
			} else {
				left = mid
			}
		} else {
			res = if (arr[left] == x) left else right
			break
		}
	}

	val num = arr[res]
	while (arr[res] == num) {
		//todo
	}

	return res + 1
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