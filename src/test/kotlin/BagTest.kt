import io.kotest.assertions.exceptionToMessage
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BagTest : BehaviorSpec({
    Given("이러한 조건이 주어졌을때~ "){
        val validMaxWeight = 10
        When("이러한 기능을 실행하면~"){
            val result=Bag(validMaxWeight)
            Then("이러한 결과가 나와야한다~"){
                result.maxWeight shouldBe validMaxWeight

            }
        }
    }

    Given("maxWeight가 0으로 주어졌을때 "){
        val MaxWeight = 0
        When("Bag의 매개변수에 집어넣게 되면 예외처리가 throw되어야 하고"){
            val exception=shouldThrow<Exception> { Bag(MaxWeight) }  //Bag(MaxWeight)가 생성자를 호출하는 코드를 진행하면 반드시 Exception이 발생해야해!
            Then("그 exception의 메시지는 가방의 최대 무게가 잘못 설정되었습니다 라는 메시지가 나와야한다"){
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."

            }
        }
    }

    Given("maxWeight가 음수로 주어졌을때 "){
        val MaxWeight = -425
        When("Bag의 매개변수에 집어넣게 되면 예외처리가 throw되어야 하고"){
            val exception=shouldThrow<Exception> { Bag(MaxWeight) }
            Then("그 exception의 메시지는 가방의 최대 무게가 잘못 설정되었습니다 라는 메시지가 나와야한다"){
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."

            }
        }
    }

})

