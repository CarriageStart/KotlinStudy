
/* (2023-03-29)

* Nested Class
- Cannot access the "Outer" class member
ex) class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}

* Inner Class
- Can access the "Outer" class member
class Outer {
    private val bar: Int = 1
    inner class Inner {
        fun foo() = bar // Accessing the member of Outer Class
    }
}

* Annonymous inner class
window.addMouseListener(object : MouseAdapter() {
})
 

 * Enum Class
- Unlike the regular enum, each enum constant is an object of the same class(EnumClass).
- Enum Class declaration is about the class of the enum constants.
  => The declaration of Primary Constructor specifies how each enum constant can be innitialized.
  => The member functions or properties can be accessed from the enum constants.
- Two default member of EnumClass is notable
    EnumClass.valueOf(value: String): EnumClass
    EnumClass.values(): Array<EnumClass>

ex1)
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun demo(dir : Direction) {
    if (dir == Direction.North) {
        println("North is inserted!")
    }
}

ex2) 
enum class Color(val rgb: Int) { 
    // This specifies how each constant innitialized
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF); // When member exists the list of enum constants should end with ";"

    // This function can be accessed from each enum Constants
    fun print() {
        print("Enum Value : ${rgb}");
    }
}
fun demo(col : Color) {
    // The value of enum Constant cna be accessed via
    if (col.value == Color.RED.value) {
        println(dir.value)
    }
}

- Enum constants can be anonymous and members can be overriden.
ex)
enum class  ProtocolState {
    WAITING {
        // Member function can be accessed and also overidable
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

- We can implement only interfaces for enum constants 
    => By default, all enum constants is implemented "Comparable" interface
ex)
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        // Solve the other implementation
        override fun apply(t: Int, u: Int): Int = t * u
    }.
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };
    // Solve one implementation
    override fun applyAsInt(t: Int, u: Int) = apply(t, u)
}


* Inlice Class
- Value-based class that inlined into primitive type)
ex) 
value class Password(private val s: String) {
    init {
         require(s.length > 0) { }
    } // No late Init possible
    val length: Int
        get() = s.length

    fun greet() {
        println("Hello, $s")
    }
}
- It can inherit only interfaces
value class Password(private val s: String) : Printable

   */
