package ru.zentsova.yandex.sprint2

class Node<V>(var value: V, var next: Node<V>? = null, var prev: Node<V>? = null)

class Stack(var cur: Node<Char>) {

  fun push(char: Char) {
    if (cur == null) {
      cur = Node(value = char)
    } else {
      cur = Node(value = char, prev = cur)
      cur.prev!!.next = cur
    }
  }

  fun pop(): Char? {
    if (cur == null) return null

    val ch = cur.value
    cur = cur.prev!!

    return ch
  }

  fun isEmpty(): Boolean {
    return cur == null
  }
}

val CLOSE_BRACKETS = setOf('}', ')', ']')
val CLOSE_OPEN_BRACKET_PAIRS = mapOf('}' to '{', ')' to '(', ']' to '[')

fun isCorrectBracketSeq(seq: String) {

}