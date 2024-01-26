package ru.zentsova.yandex.sprint3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
	val reader = BufferedReader(InputStreamReader(System.`in`))
	reader.readInt()
	val moneybox = reader.readInts()
	val bikePrice = reader.readInt()
	val doubleBikePrice = 2 * bikePrice

	val day1 = binarySearch(moneybox, bikePrice)
	val day2 = binarySearch(moneybox, doubleBikePrice)
	println("${if (day1 == -1) -1 else day1 + 1} ${if (day2 == -1) -1 else day2 + 1}")
}

fun binarySearch(arr: List<Int>, x: Int): Int {
	var left = 0
	var right = arr.size - 1
	var mid = -1
	var isEqualFound = false

	// Ищем до тех пор, пока не останется обработать два элемента
	while (right - left != 1) {
		mid = left + (right - left) / 2
		if (arr[mid] > x) {
			right = mid
		} else if (arr[mid] < x) {
			left = mid
		} else {
			// если сразу нашли, то нужно найти самый первый индекс с таким значением, значит двигаемся влево
			isEqualFound = true
			break
		}
	}

	val res = if (isEqualFound) {
		if (arr[0] == x) {
			0
		} else {
			while (mid != 0 && arr[mid - 1] == x) {
				mid--
			}
			mid
		}
	} else {
		// если сразу не нашли, то обрабатываем два элемента
		// now there are only 2 elements
		when {
			arr[left] < x && x < arr[right] -> right
			x == arr[left] -> left
			x == arr[right] -> right
			else -> -1
		}
	}

	return res
}

private fun BufferedReader.readInts() = this.readLine().split(" ").map { it.toInt() }

private fun BufferedReader.readInt() = this.readLine().toInt()