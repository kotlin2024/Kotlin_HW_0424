import kotlinx.coroutines.*

fun main() {
    println("메인쓰레드 시작")
    var job = CoroutineScope(Dispatchers.Default).launch {
        delay(3000)
        println("여기는 코루틴...")
    }
    runBlocking {
        job.join()
    }
    println("메인쓰레드 종료")
    job.cancel()
}