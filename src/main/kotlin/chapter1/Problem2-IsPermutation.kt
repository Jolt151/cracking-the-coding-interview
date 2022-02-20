package main.kotlin.chapter1

fun main() {
    println("abc".isPermutation("cba")) // true
    println("abcda".isPermutation("aabcd")) // true
    println("abcde".isPermutation("fghij")) // false
}

fun String.isPermutation(other: String): Boolean {
    val map = hashMapOf<Char, Int>() // map of each char to number of occurrences
    this.toCharArray().forEach {
        map[it] = map[it]?.inc() ?: 1
    }
    val otherCharArray = other.toCharArray()
    otherCharArray.forEach { char ->
        if (map[char] != otherCharArray.filter { it == char }.size) return false
    }
    return true
}
