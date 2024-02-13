package ru.zentsova.yandex.sprint3.finalka

import ru.zentsova.yandex.sprint3.finalka.Solution.brokenSearch

object Solution {
  fun brokenSearch(arr: IntArray, k: Int): Int {
    var left = 0
    var right = arr.size - 1
    var oldLeftValue = arr[left]
    var oldRightValue = arr[right]

    while (arr[left] > k || arr[right] < k) {
      while (arr[left] > k) {
        left += (right - left) / 2
      }

      while (arr[right] < k) {
        right = left + (right - left) / 2
        val newRightValue = arr[right]
        if (newRightValue > oldRightValue) {
          oldLeftValue = newRightValue
          left = right
          break
        }
      }
    }

    return -1;
  }
}

fun main() {

//  val k = 13
//  val array = intArrayOf(3, 4, 7, 9, 13, 18, 20, 38, 45, 57, 99, 1005)

//  val k = 9
//  val array = intArrayOf(18, 20, 38, 45, 57, 99, 1005, 3, 4, 7, 9, 13)

//  val k = 4
//  val array = intArrayOf(18, 20, 38, 45, 57, 99, 1005, 3, 4, 7, 9, 13)

//  val k = 38
//  val array = intArrayOf(18, 20, 38, 45, 57, 99, 1005, 3, 4, 7, 9, 13)

//  val k = 18
//  val array = intArrayOf(18, 20, 38, 45, 57, 99, 1005, 3, 4, 7, 9, 13)

  val k = 100
  val array = intArrayOf(18, 20, 38, 45, 57, 99, 1005, 3, 4, 7, 9, 13)

  brokenSearch(array, k)
}
