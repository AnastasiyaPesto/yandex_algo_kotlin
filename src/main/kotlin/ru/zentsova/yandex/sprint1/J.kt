package ru.zentsova.yandex.sprint1

fun main() {
  val n = readInt()
	val primeNumbers = primeNumbersByEratosthenes(n)
	val simpleMultipliers = simpleMultipliers(n, primeNumbers)
	println(simpleMultipliers.joinToString(" "))
}

fun simpleMultipliers(n: Int, primeNumbers: List<Int>): List<Int> {
	return buildList {
		var num = n
		val iterator = primeNumbers.listIterator()
		var curPrime = iterator.next()
		while (iterator.hasNext()) {
			if (num % curPrime == 0) {
				num /= curPrime
				add(curPrime)
				if (primeNumbers.contains(num)) {
					add(num)
					return@buildList
				}
			} else {
				curPrime = iterator.next()
			}
		}
		add(curPrime)
	}
}

fun primeNumbersByEratosthenes(n: Int): List<Int> {
	val numbers = BooleanArray(n + 1) { true }
	numbers[0] = false
	numbers[1] = false
	for (num in 2..n) {
		if (numbers[num]) {
			for (j in (num * num)..n step num) {
				numbers[j] = false
			}
		}
	}

	val res = mutableListOf<Int>()
	for (i in numbers.indices) {
		if (numbers[i]) {
			res.add(i)
		}
	}

	return res
}


private fun readStr() = readln()

private fun readInt() = readStr().toInt()