fun main() {
    mainMenu()
}


fun mainMenu() {

    var userInput = ""
    println("야구게임에 오신것을 환영합니다! 원하시는 번호를 입력해주세요")
    println("1. 게임 시작하기    2. 게임 기록 보기   3. 종료하기 ")
    userInput = readLine()!!

    when (userInput) {
        "1" -> baseBallGame()
        "2" -> println("게임 기록 보는 함수로 이동하자")
        "3" -> System.exit(0) //3번누르면 프로그램 종료
        else -> println("숫자 1,2,3 중에 하나의 값만 입력해주세요")
    }

}

fun baseBallGame() {
    while(true){
        var computerNumber= mutableListOf(1,2,3)
        var userNumber=""
        while(true){
            print("정답을 맞추기 위한 서로다른 3자리 숫자를 입력해보세요! : ")
            userNumber = readLine()!!
            if(userNumber.length==3) break
            else println("반드시 3개의 숫자를 입력해야합니다")
        }
        var userNumberList=userNumber.map{it.toString().toInt()}
        if(userNumberList[0]==0 || userNumberList.distinct().size != userNumberList.size) println("앞자리가 0이 되서는 안되며 중복된 값이 있어서는 안됩니다. 다시 입력해주세요.")
        else{
            //비교 시작!
            var countStrike=0
            var countBall=0
            for(i in 0..userNumberList.size-1){
                if(userNumberList[i]==computerNumber[i]) countStrike++
                else{
                    for(j in 0..userNumberList.size-1){
                        if(userNumberList[i]==computerNumber[j]) countBall++
                    }
                }
            }
            println("--------- ${countStrike}S ${countBall}B --------------")
            break
        }
        println(userNumberList)
    }
}
//