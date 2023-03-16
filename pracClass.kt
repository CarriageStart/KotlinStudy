/* 
* Class
ex)
class Name : Extension(Parameters) {
    => This is primary constructor (Default constructor)
    => If you don't want constructor write
        class Name : Extension private constructor (Parameters) {}
    => If "val" or "var" not explict, parameters
    => If "val" or "var" explict, properties are created
    => Parameters are accessible during innitialization
    (Including constructor, value initilization, and init block)

    => Another constructor can be declared too.
    constructor(name: String, parent: Person) : this(name) {
        => If "val" or "var" not explict, parameters
        => If "val" or "var" explict, properties are created
        parent.children.add(this)
    }
    val publicPropery : Int => "val" always initiated
    private val privatePropery : Int
    
    // Initializer can be located with init block
    init {  // This is called when object is created
        publicPropery = 1
        privatePropery = 1
    }
    // Init block cna be seperable
    init {  // This is called when object is created
        publicPropery = 1
        privatePropery = 1
    }
    => The sequence of the innitialization is the sequence of code
    (Including constructor, value initialization and init block)

    fun memberFunc() : Int {} 
    overide fun overidenFunc(sameParameters) {
        super.overidenFunc(sameParameters) // Call superior func
        body
    }

    * Getter, Setter
    - Kotlin generate the getter and setter by default.
    - Property retrieval(like Person.name) uses getter or setter
     implicitly
    - Implicitly, every member variables(fields) are private and 
     the <Accessability> only works for getter and setter.
    - "Property" is called the member variables with getter setter.

    [<Accessability>] var/val <Name>[: <Type>] [= <Value>]
        [<getter>]
        [<setter>]

    - But, you can customize the getter and setter
    val area: Int           // For val, innitiation can be emit
        get() = this.publicPropery2 * 100 
    var length: Int = 10    // For var, innitiation cannot be emit
        get() = this.area * 100 
        set(value) {
            setDataFromString(value)
        }
    
    - You can modify the accessibility of getter and setter
    - But never can be changed with more accesible right
    val prvArea: Int
        private get() = this.area * 100 // Public to private (fine)
    private var prvLength: Int
        get() = this.area * 100 //(cm)
        public set(value) {
            setDataFromString(value)    // Impossible
        }
    => Getter == visibility of property
    => Setter == visibility of property or less visible

    * Late Initialization
    - For lateinit, custom getter and setter cannot be created.
    - Nor possible for constructor parameters
    lateinit val publicPropery2; // => Not equal to null
    lateinit var publicPropery3; // => Not equal to null

    private lateinit val privatePropery2; // => Not equal to null
    private lateinit var privatePropery3; // => Not equal to null
}

* Open class (Class that is inheritable : "final" as default)
open class Polygon { 
    => Class is not inheritable in default. You need to specify 
      "open" for other classes able to inherit this class

    open fun draw() {}    // Overide if necessary
    fun resize()          // Overiding impossible
}
class Rectangle : Polygon() {
    override fun draw() {} // If Necessary
}

* Abstract Class
abstract class Polygon {  // Note abstract class is constructable
    abstract fun draw()   // Mandatory
    open fun resize()     // Overide if necessary
    fun resize()          // Overiding impossible
}
class Rectangle : Polygon() {
    override fun draw() {} // Mandatory
}

* Enum Class 
ex)
enum class Bit {
    ZERO, ONE
}

* Data Class
data class Person(val parameters) { // All parameter is property
    // toString(), hashCode(), equals(), copy() methods are created      as default for parameters.
    val property = ""
    // This property is not included in any default functions
}
- Destructing Declaration : Parameters in declaration
ex)
    val A = Person(name, gender)
    val (name, gender) = A  
  => By default, component1(), component2() are created and called

* Anonymous expression (Object Expression)
- Only for the sake of the easy management of the code
    => It acts just like a addtional curly bracket.
- The member of anonymous class only accesible via its type
    1. Declared local space : As it is declared (All stuff)
    2. Returned with supertype : Supertype (Only super)
    3. Returned without supertype : Any (object)
    => For multiple inheritance, 
      you need to specify the return type of anonymous class
ex)
val helloWorld = object : Extension() {
    val, var, or methods
    // If no-extension used, then toString need to be overriden.
    override fun toString() = "hello world" 
}
- It can access the variables as if it is just curly bracketed.
ex1) 
fun main() {

    val name = "Kihoon"
    val helloWorld = object : Extension() {
        fun print() {
            println("Hello $name")  // possible
        }
    }
    helloWorld.print()
}

ex2) See testAnonyClass.kt
fun countClick(window: JComponent) {
    var clickCount = 0
    var enterCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun enterClicked(e: MouseEvent) {
            enterCount++
        }
    }
}

* SingleTon Pattern(Object declarations)
ex)
    object DataProviderManager : Extension() {
        fun registerDataProvide(provider: DataProvider) {
        }
        val allDataProviders: Collection<DataProvider>
            get() = // ...
    }
    int main() {
        // It can be used any where without construction
        DataProviderManager.registerDataProvide(...)
    }
ex2)
    data object MyObject
    fun main() {
        println(MyObject)
    }
=> Main difference between two is the toString() value
    For regular object : class name + hashcode
    For data object : class name only


* Convention :
- PascalCase Nameing : ex) class MyClass() {}
- file name == class name, unless there are several classes.
- Data class should have val properties(only value no object)

*/

class Car : Vehicle (val wheels: List<Wheel>) {
    // => Creator is declared, 
    // you don't have to specify wheels as a property


    // member is called property
    // The default is public accessor
    val wheels2 = listOf<Wheel>()
    // wheels2 can be accesible but not modifiable since "val"

    // Private property
    private var doorLock: Boolean = false
    fun unlockDoor (): Boolean {
        doorLock = false
        return doorLock
    }
    
    // More control
    var gallonsOfFuelInTank: Int = 15
        private set // Public retrievable but private modifiable

    var gallonsOfConsumptionPerDay: Int = 15
        private get // Private retrievable but public modifiable
}

fun main() {
    val car = Car()
    //val car: Car = Car()
    val wheels = car.wheels // shallow copy the wheels value
    
    val capacity = car.gallonsOfFuelInTank  // Possible
    // car.gallonsOfFuelInTank = 10         // Impossible
    //val efficiency = car.gallonsOfConsumptionPerDay // Impossible
    car.gallonsOfConsumptionPerDay = 10     // Possible
}
