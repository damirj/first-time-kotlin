import java.util.*

fun main(args: Array<String>) {

    val N = 20;
    val list = listOf<Int>(2, 3, 5)
    var staircase = StaircaseClimb(N, list)
    staircase.linearCombination(list.count())
    //println(staircase.setOfCombinations)
    for (set in staircase.setOfCombinations){
        staircase.permutation(set, set.count())
    }

    for (set in staircase.setOfPermutations){
        println(set)
    }

}

class StaircaseClimb(val N: Int, val steps: List<Int>) {

    var setOfCombinations = mutableSetOf<MutableList<Int>>()
    private var combination = mutableListOf<Int>()
    private var linearCombList = MutableList(steps.count()){0}
    private var sum = 0
    var setOfPermutations = mutableSetOf<MutableList<Int>>()

    fun linearCombination(counter: Int){
        if (counter < 0) return

        if (counter == 0) {
            for ((index, value) in linearCombList.withIndex()) {
                sum += value * steps[index]
            }
            if (sum == N) {
                for ((index, value) in linearCombList.withIndex()) {
                    for (x in 0 until value){
                        combination.add(steps[index])
                    }
                }
                setOfCombinations.add(combination.toMutableList())
                combination.clear()
            }
            sum = 0
        }else {
            for (i in 0 .. N/steps[counter-1]) {
                linearCombList[counter-1] = i
                linearCombination(counter-1)
            }
        }
    }

    fun permutation(niz: MutableList<Int>, N: Int) {
        if (N == 1) {
            setOfPermutations.add(niz.toMutableList())
            return
        }
        for (i in 0 until N) {
            Collections.swap(niz, i, N - 1)
            permutation(niz, N-1)
            Collections.swap(niz, i, N - 1)
        }
    }

}





