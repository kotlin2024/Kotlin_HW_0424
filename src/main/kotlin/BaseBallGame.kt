import kotlin.random.Random

fun main() {
    mainMenu()
}


fun mainMenu() {

    var userTryList = mutableListOf<Int>()
    var userInput = ""
    println("야구게임에 오신것을 환영합니다! 원하시는 번호를 입력해주세요.")
    while (true) {
        println("1. 게임 시작하기    2. 게임 기록 보기   3. 종료하기 ")
        userInput = readLine()!!

        when (userInput) {
            "1" -> userTryList.add(baseBallGame()) //baseball 함수의  userTry 리턴값을 리스트로 저장함
            "2" -> showUserTry(userTryList)
            "3" -> exitGame()
            else -> println("숫자 1,2,3 중에 하나의 값만 입력해주세요.")
        }
    }

}

fun baseBallGame(): Int {
    var userTry = 0
    var computerNumber = generateRandomNumberList()
    println("컴퓨터 숫자:${computerNumber}") //실제 완성본에서는 삭제해야함
    while (true) {

        var userNumber = ""

        while (true) {
            print("정답을 맞추기 위한 서로 다른 3자리 숫자를 입력해보세요!  프로그램 종료는 'end' 를 입력!: ")
            userNumber = readLine()!!
            if (userNumber.equals("end", ignoreCase = true)) exitGame() //대소문자 구분 없이 end 입력하면 종료
            else if (userNumber.length == 3 && userNumber.toIntOrNull() != null) break
            else println("반드시 3개의 숫자를 입력해야하며 숫자만 입력해주세요.")

        }

        var userNumberList = userNumber.map { it.toString().toInt() }

        if (userNumberList[0] == 0 || userNumberList.distinct().size != userNumberList.size) println("앞자리가 0이 되서는 안되며 중복된 값이 있어서는 안됩니다. 다시 입력해주세요.")
        else {
            //비교 시작!
            var countStrike = 0
            var countBall = 0
            for (i in 0..userNumberList.size - 1) {
                if (userNumberList[i] == computerNumber[i]) countStrike++
                else {
                    for (j in 0..userNumberList.size - 1) {
                        if (userNumberList[i] == computerNumber[j]) countBall++
                    }
                }
            }

            println("--------- ${countStrike}S ${countBall}B --------------")
            userTry += 1 //유저가 시도한 횟수
            if (countStrike == 3) break

        }
        println(userNumberList)
        println("-----------------------------------")

    }
    if (userTry == 1) println("---------▶원샷원킬◀---------")
    else if (userTry > 10) println("총 ${userTry}번이나 시도")
    else println("총 ${userTry}번의 시도를 통해 정답을 맞춤!")
    return userTry
}

fun generateRandomNumberList(): MutableList<Int> {
    var first = 0
    var second = 0
    var third = 0

    first=randomExclude(1,9)
    second=randomExclude(0,9,first)
    third=randomExclude(0,9,first,second)

//    while (true) {
//        second = Random.nextInt(0, 9)
//        if (second != first) break
//    }
//    while (true) {
//        third = Random.nextInt(0, 9)
//        if (third != first && third != second) break
//    }
    return mutableListOf(first, second, third)

}
fun randomExclude(min:Int,max:Int, vararg exclude:Int):Int{
    var result:Int
    do{
        result=Random.nextInt(min,max)
    } while(result in exclude)
    return result
}

fun showUserTry(userList: List<Int>) {
    if (userList.isEmpty()) println("아직 단 한번의 시도조차 진행하지 않았어요.")
    else println("내 기록 보기")
    for (i in 0..userList.size - 1) {
        println("${i + 1}번째 시도횟수: ${userList[i]}")
    }
}

fun exitGame() {
    println("프로그램을 종료합니다")
    System.exit(0)
}