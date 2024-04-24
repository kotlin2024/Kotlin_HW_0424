abstract class Calculator {
    abstract  fun operation(num1:Double,num2:Double):Double
}

class AddOperation():Calculator(){
    override fun operation(num1:Double,num2:Double):Double {
        return num1+num2
    }
}
class SubstractOperation():Calculator(){
    override fun operation(num1:Double,num2:Double):Double {
        return num1-num2
    }
}
class MultiplyOperation():Calculator(){
    override fun operation(num1:Double,num2:Double):Double {
        return num1*num2
    }
}
class DivideOperation():Calculator(){
    override fun operation(num1:Double,num2:Double):Double {
        return num1/num2
    }
}
class RemainderOperation():Calculator(){
    override fun operation(num1:Double,num2:Double):Double {
        return num1%num2
    }
}

fun main(){
    var calList:MutableList<Double>
    while(true){
        calList=startmenu()
        when(calList[0].toInt()){
            1->{
                println("더하기 수행! ${calList[1]} + ${calList[2]} = ${calList[1]+calList[2]} ")
                println(AddOperation().operation(calList[1],calList[2]))
            }
            2->{
                println("빼기 수행! ${calList[1]} - ${calList[2]} = ${calList[1]-calList[2]} ")
                println(SubstractOperation().operation(calList[1],calList[2]))
            }
            3->{
                println("곱하기 수행! ${calList[1]} x ${calList[2]} = ${calList[1]*calList[2]} ")
                println(MultiplyOperation().operation(calList[1],calList[2]))
            }
            4->{
                println("나누기 수행! 몫 반환 ${calList[1]} / ${calList[2]} = ${calList[1]/calList[2]} ")
                println(DivideOperation().operation(calList[1],calList[2]))
            }
            5->{
                println("나누기 수행! 나머지 반환 ${calList[1]} % ${calList[2]} = ${calList[1]%calList[2]} ")
                println(RemainderOperation().operation(calList[1],calList[2]))
            }
        }
        println("연산이 끝났습니다 프로그램을 종료하시겠습니까? y/n")
        val endornot= readLine()!!.toString()
        if(endornot=="y"){
            println("계산기 프로그램을 종료합니다")
            break
        }
        else{

        }
    }

}

fun startmenu() : MutableList<Double>{
    var choicemenu=0.0
    var firstnum=0.0
    var secondnum=0.0
    while(true){
        println("원하는 메뉴를 숫자로 입력해보세요")
        println("1->더하기        2->빼기       3-> 곱하기     4-> 나누기(몫)         5->나누기(나머지)")

        try{
            choicemenu= readLine()!!.toDouble()
            println("연산을 적용시킬 첫번째 숫자 입력:")
            firstnum= readLine()!!.toDouble()
            println("연산을 적용시킬 두번째 숫자 입력:")
            secondnum= readLine()!!.toDouble()
            break
        }
        catch (e:NumberFormatException){
            println("문자열이 아닌 숫자(정수)만 입력해주세요")
        }
    }
    var calList= mutableListOf<Double>(choicemenu,firstnum,secondnum)
    return calList // LIST형태로 사용자 입력값 3개 반환
}
