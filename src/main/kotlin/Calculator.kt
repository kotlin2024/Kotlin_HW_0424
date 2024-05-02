
enum class Operation {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION,
    REMAINDER
}

abstract class Calculator {
    abstract fun operation(num1: Double, num2: Double): Double
}

class AddOperation : Calculator() {
    override fun operation(num1: Double, num2: Double): Double {
        return num1 + num2
    }
}

class SubstractOperation : Calculator() {
    override fun operation(num1: Double, num2: Double): Double {
        return num1 - num2
    }
}

class MultiplyOperation : Calculator() {
    override fun operation(num1: Double, num2: Double): Double {
        return num1 * num2
    }
}

class DivideOperation : Calculator() {
    override fun operation(num1: Double, num2: Double): Double {
        return num1 / num2
    }
}

class RemainderOperation : Calculator() {
    override fun operation(num1: Double, num2: Double): Double {
        return num1 % num2
    }
}


fun main() {
    while (true) {
        val calList = startmenu()
        val choice = calList[0].toInt()
        val num1 = calList[1]
        val num2 = calList[2]
        val result = when (Operation.values()[choice - 1]) {
            Operation.ADDITION -> num1 + num2
            Operation.SUBTRACTION -> num1 - num2
            Operation.MULTIPLICATION -> num1 * num2
            Operation.DIVISION -> num1 / num2
            Operation.REMAINDER -> num1 % num2
        }
        println("연산 결과: $result")
        println("연산이 끝났습니다. 프로그램을 종료하시겠습니까? (y/n)")
        val endornot = readLine()?.toLowerCase()
        if (endornot == "y") {
            println("계산기 프로그램을 종료합니다")
            break
        }
    }
}

fun startmenu(): List<Double> {
    var choicemenu = 0.0
    var firstnum = 0.0
    var secondnum = 0.0
    while (true) {
        println("원하는 메뉴를 숫자로 입력해보세요")
        println("1->더하기        2->빼기       3-> 곱하기     4-> 나누기(몫)         5->나누기(나머지)")

        try {
            choicemenu = readLine()!!.toDouble()
            println("연산을 적용시킬 첫번째 숫자 입력:")
            firstnum = readLine()!!.toDouble()
            println("연산을 적용시킬 두번째 숫자 입력:")
            secondnum = readLine()!!.toDouble()
            break
        } catch (e: NumberFormatException) {
            println("숫자(정수 또는 소수)만 입력해주세요")
        }
    }
    return listOf(choicemenu, firstnum, secondnum)
}
