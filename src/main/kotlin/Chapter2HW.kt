fun main(){


    startGame()
    var mycharacterlist= mutableListOf<String>()

    while(true){
        println("1 -> 캐릭터생성   2-> 캐릭터 정보 확인    그외숫자 -> 프로그램 종료" )
        try{
            var num: Int = readLine()!!.toInt()

            if(num==1){
                mycharacterlist.addAll(addCharacter())
            }
            else if(num==2){
                println(mycharacterlist)
            }
            else{
                endGame()
                break
            }   
        }
        catch(e: NumberFormatException){
            println("너 지금 문자열 입력한거야 정신차려")
        }
    }


}

fun startGame(){
    println("게임이 시작되었습니다")
}
fun endGame(){
    println("게임이 종료되었습니다")
}
fun addCharacter() : MutableList<String>{
    println("추가하실 캐릭터의 이름을 입력해주세요")
    var charactername=readLine()!!.toString()
    println("추가하실 캐릭터의 직업을 입력해주세요")
    var characterjob=readLine()!!.toString()
    var listcharacter: MutableList<String> = mutableListOf(charactername,characterjob)
    return listcharacter
}
