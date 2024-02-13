package ru.zentsova.yandex.sprint3.finalka

import ru.zentsova.yandex.sprint3.finalka.Solution.brokenSearch

object Solution {
  fun brokenSearch(arr: IntArray, k: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
      val mid = left + (right - left) / 2
      when {
        arr[mid] == k -> return mid
        arr[left] <= arr[mid] -> {
          if (arr[left] <= k && k < arr[mid]) {
            right = mid - 1
          } else {
            left = mid + 1
          }
        }
        else -> {
          if (arr[mid] < k && k <= arr[right]) {
            left = mid + 1
          } else {
            right = mid - 1
          }
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

//  val k = 1005
//  val array = intArrayOf(18, 20, 38, 45, 57, 98, 1005, 3, 4, 7, 9)

  val k = 61
  val array = intArrayOf(18, 20, 38, 45, 57, 98, 1005, 3, 4, 7, 9)

  println(brokenSearch(array, k))
}
