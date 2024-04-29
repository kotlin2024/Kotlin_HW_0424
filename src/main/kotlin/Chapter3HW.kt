fun main(){
    var arr:List<Int> = listOf(32004112)
    var answer=arr[0].toString().split("")
    var sum:Int=0
    for(i in 0..answer.size-1){
        try{
            sum+=answer[i].toInt()
        }
        catch (e:NumberFormatException){
            sum+=0
        }
    }
    println(sum)
}