
/* 
* Extensions
- Add new logics or variables to the existing class.
(Without modifying function or class like inheritance or decorator)

* Extension Functions
- Declare a new function with the similar type name as the existing class method.
    => It looks like we have new public method
- It can access only public properties or methods.
- "this" keyword is used and it refers to the "receiver" object.
    ("receiver" : The one that is passed before the dot ".")

ex1) For existing class MutableList<Int>...
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }
    fun main() {
        val list = mutableListOf(1, 2, 3)
        list.swap(0, 2)
    }

ex2) With generic expression
    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }
- In the case where the same signature member method exists, then
  member method always wins.
- Note receiver can be nullable with "?" keyword.
ex)
    fun Any?.toString(): String {
        if (this == null) return "Null"
        return toString() // Call Any's toString
    }

* Extension Properties
ex)
val <T> List<T>.lastIndex: Int
    get = size - 1

* Dispatch Pattern
ex) 
    // This is "Extension Receiver"
    class Host(val hostname: String) {
        fun printHostName() { print(hostname) }
    }

    // This is "Dispatch Receiver"
    class Connection(val host: Host, val port: Int) {
        fun printPort() { println(port) }
    
        // Extension : Usually better to be set as private
        private fun Host.PrintConnectionString() {
            printHostName()
            print(":")
            printPort()
        }
        => "Dispatch" to Connection, "Extension" to Host

        // In the case where name conflicts : use qualifier "@~"
        fun Host.getConnectionString() {
            toString()                  // Host.toString()
            this@Connection.toString()  // Connection.toString()
        }
        
    
        fun connect() {
            host.printConnectionString()
        }
    }
    fun main() {
        Connvection(Host("kotl.in"), 443).connect()
    }

ex2)
open class Base { }
class Derived : Base() { }
open class BaseCaller {
    open fun Base.printFunctionInfo() {
        println("Base extension in BaseCaller!")
    }
    open fun Derived.printFunctionInfo() {
        println("Derived extension in BaseCaller!")
    }
    fun call(b: Base) {
        b.printFunctionInfo()
    }
}
open class DerivedCaller : BaseCaller() {
    open fun Base.printFunctionInfo() {
        println("Base extension in DerivedCaller!")
    }
    open fun Derived.printFunctionInfo() {
        println("Derived extension in DerivedCaller!")
    }
}
fun main() {
    BaseCaller().call(Base()) // Base Extension in BaseCaller
    DerivedCaller().call(Base()) // Base Extension in DerivedCaller
    DerivedCaller().call(Derived()) 
    // Base Extension in DerivedCaller
}
*/





open class Shape
class Rectangle: Shape()

// Extension
fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle" //Same name but not overriden

fun printClassName(s: Shape) {
    println(s.getName()) 
    // Since name is referenced with type, Shape.getName is called
}

fun main() {
    printClassName(Rectangle()) 
    // out : Shape
}



