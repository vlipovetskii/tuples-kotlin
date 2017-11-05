package vlfsoft.common.tuples

import vlfsoft.paradigms.ProgrammingParadigm
import vlfsoft.paradigms.ProgrammingParadigm.Declarative.Functional
import vlfsoft.patterns.ObjectKindPattern

/**
 * See <a href="https://blog.jetbrains.com/kotlin/migrating-tuples/">Migrating Tuple (Kotlin M3 and Higher)</a>
 * Tuple types and expression are no longer supported in Kotlin starting from M3. Data classes are the preferred way of dealing with tuple-like data.
 * Library classes Pair and Triple are available for respective purposes.
 *
 * See [ObjectKindPattern.Tuple]
 * p1, p2, ... - properties
 */
@ObjectKindPattern.Tuple
@Functional
sealed class Tuple {

    @ObjectKindPattern.VO
    @ObjectKindPattern.Immutable
    data class I1<out T1>(val p1: T1) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Mutable
    data class M1<T1>(var p1: T1) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Immutable
    data class I2<out T1, out T2>(val p1: T1, val p2: T2) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Mutable
    data class M2<T1, T2>(var p1: T1, var p2: T2) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Immutable
    data class I3<out T1, out T2, out T3>(val p1: T1, val p2: T2, val p3: T3) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Mutable
    data class M3<T1, T2, T3>(var p1: T1, var p2: T2, var p3: T3) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Immutable
    data class I4<out T1, out T2, out T3, out T4>(val p1: T1, val p2: T2, val p3: T3, val p4: T4) : Tuple()

    @ObjectKindPattern.VO
    @ObjectKindPattern.Mutable
    data class M4<T1, T2, T3, T4>(var p1: T1, var p2: T2, var p3: T3, var p4: T4) : Tuple()

    /**
     * In java:   Tuple.of("", "");
     * or:        new Tuple.I2<>("", "");
     *
     * In kotlin: Tuple.of("", "")
     * or:        Tuple.I2("", "");
     *
     * In java:   Tuple.ofM("", "");
     * or:        new Tuple.M2<>("", "");
     *
     * In kotlin: Tuple.ofM("", "")
     * or:        Tuple.M2("", "");
     *
     */
    companion object {

        /**
         * It can be used to start [ProgrammingParadigm.Declarative.DataFlow.FlowBased] with 1 item. It's like f.e. Mono in Project Reactor.
         * Stream.of(Tuple.of())
         */
        @JvmStatic
        fun <T1> of() = Tuple.I1(null)

        @JvmStatic
        fun <T1> of(a1 : T1) = Tuple.I1(a1)
        @JvmStatic
        fun <T1, T2> of(a1 : T1, a2: T2) = Tuple.I2(a1, a2)
        @JvmStatic
        fun <T1, T2, T3> of(a1 : T1, a2: T2, a3: T3) = Tuple.I3(a1, a2, a3)
        @JvmStatic
        fun <T1, T2, T3, T4> of(a1 : T1, a2: T2, a3: T3, a4: T3) = Tuple.I4(a1, a2, a3, a4)

        @JvmStatic
        fun <T1> ofM(a1 : T1) = Tuple.M1(a1)
        @JvmStatic
        fun <T1, T2> ofM(a1 : T1, a2: T2) = Tuple.M2(a1, a2)
        @JvmStatic
        fun <T1, T2, T3> ofM(a1 : T1, a2: T2, a3: T3) = Tuple.M3(a1, a2, a3)
        @JvmStatic
        fun <T1, T2, T3, T4> ofM(a1 : T1, a2: T2, a3: T3, a4: T3) = Tuple.M4(a1, a2, a3, a4)
    }

}

fun <T> List<T>.toPair() = Pair(get(0), get(1))

