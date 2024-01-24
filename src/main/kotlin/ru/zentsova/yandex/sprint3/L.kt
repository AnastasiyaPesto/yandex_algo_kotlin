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

private fun BufferedReader.readInts() = this.readLine().split(" ").map { it.toInt() }

private fun BufferedReader.readInt() = this.readLine().toInt()