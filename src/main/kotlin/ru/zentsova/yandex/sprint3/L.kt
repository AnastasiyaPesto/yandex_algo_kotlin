package ru.zentsova.yandex.sprint3

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
//	val reader = BufferedReader(InputStreamReader(System.`in`))
//	reader.readInt()
//	val moneybox = reader.readInts()
//	val bikePrice = reader.readInt()
//	val doubleBikePrice = 2 * bikePrice

	//	val day2 = binarySearch2(moneybox, doubleBikePrice)
//	println("${if (day1 == -1) -1 else day1 + 1} ${if (day2 == -1) -1 else day2 + 1}")


//	var moneybox = listOf(1, 2, 4, 4, 6, 8)

//	var day1 = binarySearch2(moneybox, 3)
//	println("Should 2 -> " + day1)
//
//	day1 = binarySearch2(moneybox, 4)
//	println("Should 2 -> " + day1)
//
//	day1 = binarySearch2(moneybox, 5)
//	println("Should 4 -> " + day1)
//
//	day1 = binarySearch2(moneybox, 9)
//	println("Should -1 -> " + day1)
//
//	day1 = binarySearch2(moneybox, 2)
//	println("Should 1 -> " + day1)
//
//	day1 = binarySearch2(moneybox, 1)
//	println("Should 0 -> " + day1)
//
	var moneybox = listOf(3, 3, 3, 3, 3, 7, 9)
//
//	day1 = binarySearch2(moneybox, 2)
//	println("Should -1 -> " + day1)

	var day1 = binarySearch2(moneybox, 3)
	println("Should 0 -> " + day1)
}

fun binarySearch2(arr: List<Int>, x: Int): Int {
	if (arr.last() < x) {
		return -1
	}

	var left = 0
	var right = arr.size - 1

	while (right - left > 1) {
		val mid = left + (right - left) / 2
		if (arr[mid] >= x) {
			right = mid
		} else {
			left = mid
		}
	}

	return right
//	return if (arr[left] != x) right else left
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