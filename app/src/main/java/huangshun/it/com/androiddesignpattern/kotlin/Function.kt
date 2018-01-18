package huangshun.it.com.androiddesignpattern.kotlin

import com.autonavi.amap.mapcore.Rectangle

/**
 * Created by hs on 2017/12/18.
 */
//定义变量
val Pi = 3.13
var x = 0

var a = 1
val s1 = "a is $a"
fun maxOf2(a: Int, b: Int) = if (a > b) a else b
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun syso() {
    println(s1);
    a = 2
    val s2 = "${s1.replace("is", "was")} ,but not is $a"
    println(s2)
}

fun increment(): Int {
    return x++
}

fun main(args: Array<String>) {
    //一次赋值（只读的局部变量）
    val a: Int = 1
    val b = 2//自动推断类型
    val c: Int
    c = 3
    //可变变量
    var x = 5
    x += 1
//    println("hello")
//    println(sum(2, 3))
//    println("sum of 19 and 23 is ${sum2(19, 23)}")
//    println(sum3(1, 5))
//    println(sum4(1, 5))
//    syso()
//    println(maxOf(1, 3))
//    printProduct("", "2")
//    forTest
    println(whenTest("ceshi"))
    inTest()
    containItem()
    filterTest()
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b
fun sum3(a: Int, b: Int): Unit {
    println("sum of $a and $b  is ${a + b}")
}

fun sum4(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = arg2.toIntOrNull()
    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }

}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

fun getStringLength(obj: Any, a: Int): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}

fun geeStringLength(obj: Any, a: Int, b: Double): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

fun forTest() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whereTest() {
    val items = listOf<String>("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        index++
        println("item at $index is ${items[index]} ")
    }
}

fun whenTest(obj: Any): String =
        when (obj) {
            1 -> "one"
            is Long -> "long类型"
            !is String -> "不是String 类型"
            else -> "other"
        }


fun inTest() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }

    for (x in 1..5) {
        println(x)
    }
    for (x in 1..10 step 2) {
        println(x)
    }

    for (x in 1..10 step 3)
        println(x)

}

fun containItem() {
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine to")
    }
}

fun filterTest() {
    val fruits = listOf<String>("banana", "avocado", "apple")
    fruits
            .filter {
                it.startsWith("a")
//                it.endsWith("o")
            }
//            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    val rectangle = Rectangle(1f, 2f, 3f, 4f)
}

