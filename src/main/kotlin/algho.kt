fun main() {

}
fun solution(s: String): Boolean {
    var answer = true
    answer=s.all{it.isDigit()} && (s.length==4 || s.length==6 )
    return answer
}