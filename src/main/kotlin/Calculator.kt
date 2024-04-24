open class Calculator {

    open fun add(num1:Int,num2:Int):Int{
        return num1+num2
    }
    open fun subtraction(num1:Int,num2:Int):Int{
        return num1-num2
    }
    open fun multiply(num1:Int,num2:Int):Int{
        return num1*num2
    }
    open fun divide(num1:Int,num2:Int):Int{
        return num1/num2
    }

}
class UpgradeCalculator : Calculator(){
    fun remainder(num1:Int,num2: Int):Int{
        return num1%num2
    }
}
class AddOperaton : Calculator(){
    override  fun add(num1:Int,num2:Int):Int{
        return (num1+num2)*100
    }
}


fun main(){
    val cal=UpgradeCalculator()
    var calList:MutableList<Int>
    while(true){
        calList=startmenu()
        when(calList[0]){
            1->{
                println("더하기 수행! ${calList[1]} + ${calList[2]} = ${calList[1]+calList[2]} ")
                println(cal.add(calList[1],calList[2]))
            }
            2->{
                println("빼기 수행! ${calList[1]} - ${calList[2]} = ${calList[1]-calList[2]} ")
                println(cal.subtraction(calList[1],calList[2]))
            }
            3->{
                println("곱하기 수행! ${calList[1]} x ${calList[2]} = ${calList[1]*calList[2]} ")
                println(cal.multiply(calList[1],calList[2]))
            }
            4->{
                println("나누기 수행! 몫 반환 ${calList[1]} / ${calList[2]} = ${calList[1]/calList[2]} ")
                println(cal.divide(calList[1],calList[2]))
            }
            5->{
                println("나누기 수행! 나머지 반환 ${calList[1]} % ${calList[2]} = ${calList[1]%calList[2]} ")
                println(cal.remainder(calList[1],calList[2]))
            }
        }
        println("연산이 끝났습니다 프로그램을 종료하시겠습니까? y/n")
        var endornot= readLine()!!.toString()
        if(endornot=="y"){
            println("계산기 프로그램을 종료합니다")
            break
        }
        else{

        }
    }

}

fun startmenu() : MutableList<Int>{
    var choicemenu=0
    var firstnum=0
    var secondnum=0
    println("원하는 메뉴를 숫자로 입력해보세요")
    println("1->더하기        2->빼기       3-> 곱하기     4-> 나누기(몫)         5->나누기(나머지)")

    try{
        choicemenu= readLine()!!.toInt()
        println("연산을 적용시킬 첫번째 숫자 입력:")
        firstnum= readLine()!!.toInt()
        println("연산을 적용시킬 두번째 숫자 입력:")
        secondnum= readLine()!!.toInt()
    }
    catch (e:NumberFormatException){
        println("문자열이 아닌 숫자(정수)만 입력해주세요")
    }
    var calList= mutableListOf<Int>(choicemenu,firstnum,secondnum)
    return calList
}
