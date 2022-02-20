package main.kotlin.chapter1

fun main() {
    println("Mr. John Smith    ".toCharArray().urlify().joinToString(separator = ""))
}

fun CharArray.urlify(): CharArray {
    val charArray = this

    // find last non-space character
    var lastNonSpaceCharIndex = 0
    for (i in charArray.lastIndex downTo 0) {
        if (charArray[i] != ' ') {
            lastNonSpaceCharIndex = i
            break
        }
    }

    for (i in 0..lastNonSpaceCharIndex) {
        val char = charArray[i]
        if (char == ' ') {
            // shift the substring after the current index down two spaces to make room for %20
            repeat(2) { // shift all characters twice
                for (j in charArray.lastIndex downTo i) {
                    charArray[j] = charArray[j - 1]
                }
            }
            // there is now a space at charArray[i], [i+1], [i+2]
            charArray[i] = '%'
            charArray[i+1] = '2'
            charArray[i+2] = '0'
        }
    }
    return charArray
}
