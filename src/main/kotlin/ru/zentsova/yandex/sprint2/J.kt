package ru.zentsova.yandex.sprint2

import java.util.LinkedList

class MyQueueList {

	private val queue = LinkedList<Int>()

	fun put(value: Int) {
		queue.addLast(value)
	}

	fun get(): Int? = try {
			queue.removeFirst()
		} catch (e: NoSuchElementException) {
			null
		}

	fun size() = queue.size
}

fun main() {
	val commandCount = readInt()
	val queue = MyQueueList()
	for (i in 0 until commandCount) {
		val commands = readStrings()
		when (commands[0]) {
			"put" -> queue.put(commands[1].toInt())
			"get" -> println(queue.get() ?: "error")
			"size" -> println(queue.size())
		}
	}
}

private fun readStr() = readln()

private fun readInt() = readStr().toInt()

private fun readStrings() = readStr().split(" ")