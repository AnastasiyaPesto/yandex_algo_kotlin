package ru.zentsova.yandex.sprint2

import java.lang.RuntimeException

class QueueFullSizeException : RuntimeException()
class MyQueueSized(private val maxSize: Int) {
	private val queue = arrayOfNulls<Int>(maxSize)
	private var head = 0
	private var tail = 0
	private var size = 0

	fun push(value: Int) {
		if (size == maxSize) throw QueueFullSizeException()

		queue[tail] = value
		tail = (tail + 1) % maxSize
		size++
	}

	fun pop(): Int? {
		if (size == 0) return null

		val first = queue[head]
		queue[head] = null
		head = (head + 1) % maxSize
		size--
		return first
	}

	fun peek(): Int? = if (size != 0) queue[head] else null

	fun size() = size
}

fun main() {
	val commandCount = readInt()
	val queue = MyQueueSized(readInt())
	for (i in 0 until commandCount) {
		val commands = readStrings()
		when (commands[0]) {
			"push" -> try {
				queue.push(commands[1].toInt())
			} catch (e: QueueFullSizeException) {
				println("error")
			}
			"pop" -> println(queue.pop() ?: "None")
			"peek" -> println(queue.peek() ?: "None")
			"size" -> println(queue.size())
		}
	}
}

private fun readStr() = readln()

private fun readInt() = readStr().toInt()

private fun readStrings() = readStr().split(" ")