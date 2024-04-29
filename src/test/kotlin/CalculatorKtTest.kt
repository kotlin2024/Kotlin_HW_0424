import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class AddOperationTest : BehaviorSpec({
    Given("더하기 class의 인스턴스를 생성한 상황에서") {
        val addOperation = AddOperation()

        When("인스턴스에 접근해서 operation함수 매개변수에 3이랑 5를 집어넣었을때") {
            val result = addOperation.operation(3.0, 5.0)

            Then("결과값으로 8이 되어야만 한다") {
                result  shouldBe 8.0
            }
        }
    }
})


class SubtractOperationTest : BehaviorSpec({
    Given("빼기 class의 인스턴스를 생성한 상황에서") {
        val subtractOperation = SubstractOperation()

        When("빼기 class안에 있는 operation함수 안에 매개변수 8,3을 넣었을때") {
            val result = subtractOperation.operation(8.0, 3.0)

            Then("5.0이 나와야만 한다") {
                result shouldBe 5.0
            }
        }
    }
})

class MultiplyOperationTest :BehaviorSpec({
    Given("곱하기 class의 인스턴스를 생성한 상황에서"){
        val multiply = MultiplyOperation()
        When("곱하기 함수에 3,10을 넣었을때"){
            val result=multiply.operation(3.0,10.0)
            Then("30.0이 나와야한다"){
                result shouldBe 30.0
            }
        }
    }
})
class StartMenuTest : BehaviorSpec({
    Given("스타트메뉴가 호출된 상황에서") {
        startmenu()
        When("사용자가 입력한 값이 1,20,30이라면") {
            val choicemenu = 1.0
            val firstnum = 20.0
            val secondnum = 30.0
            val result = mutableListOf<Double>()

            Then("1.0,20.0,30.0이 담겨져있는 리스트를 반환해야만 한다") {
                result shouldBe mutableListOf<Double>(choicemenu, firstnum, secondnum)
            }
        }
    }
})
