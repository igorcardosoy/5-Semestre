package extensoes

fun String.lastChar() = this[this.length - 1]

fun String.lastWord() = this.split(" ").last()