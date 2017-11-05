package vlfsoft.common.tuples

import org.junit.jupiter.api.Test

class TuplesTest {

    @Test
    fun test() {
        val a : Pair<String, String> = "" to ""
        println(a)
        println(a.first)

        val a1: Tuple.I1<String> = Tuple.I1("")
        val b = Tuple.of("")
    }
}
