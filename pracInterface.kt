
/* Interface
- Abstract class cannot be initiated and store state
ex)
interface MyInterface {
    val prop: Init      // abstract by default
    val propertyWithGetterOrSetter: String
        get() = "foo"   // abstract too
    fun foo() {         // abstract function
        body
    }
}

classChild : MyInterface {
    override val prop: Int = 29
}

ex2) If inheritance double-inherited, 
interface Named {
    val name: String
}
interface Person : Named {
    val firstName: String
    val lastName: String

    // Required
    override val name: String get() = "$firstName $lastName"
}
data class Employee(
    overide val firstName: String,
    overide val lastName: String,
    val position: String,

    // name is not Required
) : Person

* Sealed Class
- Enum for class.
- Restrict other new implemntation of the Sealed Class(like Derived
   classs or Exsensions) with importing after compilation.
- Specify all the derived class and make a complete implement of 
   polymorphism in static time.
- Therefore, all derived classes should be sepcified in the same 
   package
- 

* Functional Interface (SAM: Single Abstract Method)
- Interface for one abstract method via inheritance mechanism
- This abstract method is the interface of this functional object
- It can be used via inheriting interface to class not function

ex1) Use of functional Interface (Can have multiple non-abstracts)
    fun interface IntPredicate {
        fun accept(i: Int): Boolean
    }
    fun main() {
        val isEven = object : IntPredicate { 
            override fun accept(i: Int): Boolean {
                return i % 2 == 0
            }
        }
        println("Is 7 even? - ${isEven.accept(7)}")
    }

ex2) With SAM, many things can be emitted (Only one abstract)
    fun interface IntPredicate {
        fun accept(i: Int): Boolean
    }
    fun main() {
        val isEven = IntPredicate { it % 2 == 0 } 
        println("Is 7 even? - ${isEven.accept(7)}")
    }
- Functional Interface has a special constructor. (::Interface)
ex) 
    fun interface Printer {
        fun print()
    }
    documentsStorage.addPrinter(::Printer)

*/
