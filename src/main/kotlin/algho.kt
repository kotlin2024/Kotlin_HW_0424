fun main() {

}
fun solution(price: Int, money: Int, count: Int): Long {
    var answer: Long = -1
    var totalPrice:Long=0
    var result:Long =0
    for(i in 1..count) totalPrice+=price*i
    result= money-totalPrice
    if(result<0) answer=result
    else answer=0
    return answer
}