package zadatak1


abstract class Person(val name: String = "John Doe", val country: String = "Noland", var emotion: Int = 50) {

    init {
        if (emotion < 0 || emotion > 100) {
            throw Exception("Emotion is out of range! 0 - 100")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Person?
        return name == that!!.name && country == that!!.country
    }
}