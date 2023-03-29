
/* (2023-03-30)
 * Delegate Pattern
 - Derived class delegates all of class that implements the same interface.
 - with 'by' clause, compiler generates all member function forwarded to b
 - By specifying overriding function you can select which to use.
 */

// Example
interface Base {
    val message: String
    fun print() 
    fun printMessageLine() 
}

class BaseImpl(val x: Int) : Base {
    override val message = "BaseImpl: x = $x"
    override fun print() { print(message) }
    override fun printMessageLine() { println(x) }
}

// Automated Delegate pattern with "by"
class Derived(b: Base) : Base by b  {
    override val message = "Meassage of Derived"
    override fun printMessageLine() { println("abc") }
}

fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()             // BaseImpl: x = 10
    derived.printMessageLine()  // abc
    println(derived.message)    // Message of Derived
}
