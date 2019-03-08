package AdventOfCode2018

import java.io.File
import java.time.LocalDateTime


fun main(args: Array<String>) {

    val file = File("dayFour.txt")
    val values = file.readLines()

    var events = mutableListOf<Event>()

    for (value in values) {
        events.add(Event(value))
    }

    events.sortBy { it.eventTime }

    var timeTable = TimeTable(events)
    timeTable.sleepyGuardPartOne()
    timeTable.sleepyGuardPartTwo()

}

class Event(val inputString: String) {

    var eventTime = LocalDateTime.parse("2019-02-03T15:59")
    var eventNote = ""

    init {
        var newString = inputString.replace(" ", "T")
        eventTime = LocalDateTime.parse(newString.substring(1, newString.indexOf("]")))
        eventNote = inputString.substring(newString.indexOf("]") + 2)
    }

}

class Guard(val events: MutableList<Event>, val id: Int, var indexTime: Int) {

    var workTime = Array(60) { 0 }
    var timeSum = 0
    var mostAsleepMinute = 0
    var mostOverSleptMinute: Int? = 0

    init {
        loopwhile@ while (events[indexTime].eventNote == "falls asleep") {
            for (i in events[indexTime].eventTime.minute until events[indexTime+1].eventTime.minute) {
                workTime[i] = 1
            }
            if (indexTime == events.count() - 2) {
                break@loopwhile
            }
            indexTime += 2

        }
        timeSum = workTime.sum()
        mostAsleepMinute = workTime.indexOf(workTime.max())
        mostOverSleptMinute = workTime.max()
    }

    fun updateTime(indexUpdateTime: Int) {
        indexTime = indexUpdateTime
        loopwhile2@ while (events[indexTime].eventNote == "falls asleep") {
            for (i in events[indexTime].eventTime.minute until events[indexTime+1].eventTime.minute) {
                workTime[i] += 1
            }
            if (indexTime == events.count() - 2) {
                break@loopwhile2
            }
            indexTime += 2
        }
        timeSum = workTime.sum()
        mostAsleepMinute = workTime.indexOf(workTime.max())
        mostOverSleptMinute = workTime.max()
    }
}


class TimeTable(val events: MutableList<Event>) {
    var guards = mutableListOf<Guard>()

    init {
       loop@ for ((i, event) in events.withIndex()) {
            if (event.eventNote.contains("Guard")) {
                for ((j, guard) in guards.withIndex()) {
                    if (guard.id == event.eventNote.substring(event.eventNote.indexOf("#")+1, event.eventNote.indexOf("b")-1).toInt()) {
                        guards[j].updateTime(i+1)
                        continue@loop
                    }
                }
                guards.add(Guard(events, event.eventNote.substring(event.eventNote.indexOf("#")+1, event.eventNote.indexOf("b")-1).toInt(), i+1))
            }
        }
    }

    fun sleepyGuardPartOne() {
        var biggestSum = guards.maxBy { it -> it.timeSum }
        if (biggestSum != null) {
            println(biggestSum.id * biggestSum.mostAsleepMinute)
        }
    }

    fun sleepyGuardPartTwo() {
        var biggestSum = guards.maxBy { it -> it.mostOverSleptMinute!!}
        if (biggestSum != null) {
            println(biggestSum.id * biggestSum.mostAsleepMinute)
        }
    }

}