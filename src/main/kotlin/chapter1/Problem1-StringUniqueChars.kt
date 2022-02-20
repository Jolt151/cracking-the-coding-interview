package main.kotlin.chapter1

fun main() {
    println(isUnique("aabbcc")) // false
    println(isUnique("abcde")) // true
    println(isUnique("abcda")) // false
    println(isUnique("abcdb")) //false
    println()
    println(isUniqueNoDataStructures("aabbcc")) // false
    println(isUniqueNoDataStructures("abcde")) // true
    println(isUniqueNoDataStructures("abcda")) // false
    println(isUniqueNoDataStructures("abcdb")) //false
}

fun isUnique(string: String): Boolean {
    val set = hashSetOf<Char>()
    string.toCharArray().forEach {
        if (!set.add(it)) return false
    }
    return true
}

fun isUniqueNoDataStructures(string: String): Boolean {
    val charArray = string.toCharArray()
    charArray.forEach { char ->
        if (charArray.filter { it == char }.size >= 2) return false
    }
    return true
}
