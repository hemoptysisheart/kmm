package com.example.kmm

import io.kotest.core.spec.style.BehaviorSpec

/**
 * 1. `beforeSpec`
 * 2. `beforeContainer`
 * 3. `beforeTest`
 * 4. `beforeAny`
 * 5. `beforeInvocation`
 * 6. **`GIVEN`**
 * 7. `beforeContainer`
 * 8. `beforeTest`
 * 9. `beforeAny`
 * 10. `beforeInvocation`
 * 11. **`WHEN``**
 * 12. `beforeEach`
 * 13. `beforeTest`
 * 14. `beforeAny`
 * 15. `beforeInvocation`
 * 16. **`THEN`**
 * 17. `afterAny`
 * 18. `afterTest`
 * 19. `afterContainer`
 * 20. `afterAny`
 * 21. `afterTest`
 * 22. `afterContainer`
 */
class LifecycleSample : BehaviorSpec({
    beforeSpec {
        println("[BEFORESPEC]")
    }

    beforeContainer {
        println("[BEFORECONTAINER]")
    }

    beforeTest {
        println("[BEFORETEST]")
    }

    beforeAny {
        println("[BEFOREANY]")
    }

    beforeInvocation { testCase, i ->
        println("[BEFOREINVOCATION] i=$i, testCase=$testCase")
    }

    beforeEach {
        println("[BEFOREEACH] then 블록 실행 전 호출.")
    }

    afterAny {
        println("[AFTERANY]")
    }

    afterTest {
        println("[AFTERTEST]")
    }

    afterEach {
        println("[AFTEREACH]")
    }

    afterContainer {
        println("[AFTERCONTAINER]")
    }

    afterSpec {
        println("[AFTERSPEC] ???")
    }

    given("given 1") {
        println("[GIVEN] 1")

        `when`("when 1-1") {
            println("[WHEN] 1-1")

            then("then 1-1") {
                println("[THEN] 1-1")
            }
        }

        `when`("when 1-2") {
            println("[WHEN] 1-2")

            then("then 1-2") {
                println("[THEN] 1-2")
            }
        }
    }

    given("given 2") {
        println("[GIVEN] 2")

        `when`("when 2") {
            println("[WHEN] 2")

            then("then 2-1") {
                println("[THEN] 2-1")
            }

            then("then 2-2") {
                println("[THEN] 2-2")
            }
        }
    }
})
