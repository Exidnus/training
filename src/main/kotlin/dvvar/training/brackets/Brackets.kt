package dvvar.training.brackets

import java.util.*

/**
 * "Баланс скобок".
 * Написать функцию validBraces, которая принимает строку и возвращает boolean.
 * Возвращает true, если строка пустая (для простоты) или содержит только скобки в правильной последовательности,
 * например, (([[]])){} и т.д. Неправильно: ][], [[{]] и т.д.
 */

private val OPEN_BRACKETS = setOf('(', '[', '{')
private val CLOSE_BRACKETS = setOf(')', ']', '}')
private val VALID_CHARS = OPEN_BRACKETS + CLOSE_BRACKETS

fun validBraces(brackets: String): Boolean {
    if (brackets.isEmpty()) return true
    if (brackets.any { !VALID_CHARS.contains(it) }) return false
    if (brackets.length % 2 != 0) return false

    val stack = Stack<Char>()
    for (c in brackets) {
        if (OPEN_BRACKETS.contains(c)) {
            stack.push(c)
        } else {
            if (stack.empty()) return false
            if (!isRightPair(stack.pop(), c)) return false
        }
    }
    return true
}

private fun isRightPair(first: Char, second: Char): Boolean = when (first) {
    '(' -> second == ')'
    '[' -> second == ']'
    '{' -> second == '}'
    else -> false
}