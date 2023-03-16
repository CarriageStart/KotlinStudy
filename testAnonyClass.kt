
class Caller {
    fun addCount(counter: Base) {
        counter.onClick()
        val count = counter.returnCount()
        println("Recieved $count")
    }
}

open class Base {
    open fun onClick() {
        println("Clicked!")
    }
    open fun returnCount() : Int {
        println("Printing Count")
        return 0
    }
}

fun countClicks(window: Caller, loop: Int) {
    var count = 0
    // Anonymous class looks like doing wield modifying not 
    // deserved variable. But, it is basically naming the curly
    // bracet so that we can return to this curly bracket via name
    while (count < loop) {
        window.addCount(object: Base() {
            // Make two kinds of curly brackets
            override fun onClick() {
                super.onClick()
                count++
            }
            override fun returnCount() : Int {
                super.returnCount()
                return count
            }
        })
    }
}

fun main() {
    val window: Caller = Caller();
    countClicks(window, 10)
}
/*
fun main() {
    val name = "Kihoon"
    val helloWorld = object {
        val hello = "hello"
        val world = "world"
        fun print() {
            println("$hello $world")
        }
        fun testprint() {
            println("$hello $name")
        }
        override fun toString() = "$hello $world"
    }
    println(helloWorld.toString())
    helloWorld.print()
    helloWorld.testprint()
}
*/
