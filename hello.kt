
/* Kotlin always need main function
* Type
- Primitive : Int, Double, ...
- Function : (Function Type) -> Retrun Type
- Class : ClassName : ExtensionName

- Type Aliases :
    - The type can dynamically attrieved
ex) 
typealias IntToBoolFunction = (i: Int) -> Boolean
val isEven: IntToBoolFunction = { it % 2 == 0 }

* Function
- Function can be declared with "func" keyword.
    func name (par : type = default) : return type {
        body;
        return ;
    }
- Unit type : If no return type is specified, it is Unit(void)
    func name() {} == func name() : Unit {}
- Note that the parameters are always "val" (Unmodifiable).
- You can always sepcify the parameter name in calling function.
    ex)
    func birthdayGreeting(name: String, age: Int) : String {}
    var greeting = birthdayGreeting(age=10, name="Suzin");
    greeting = birthdayGreeting(name="Suzin", age=10);
- No modification on sequence for default values
- Anonymous function (Function pointor)
    - With function expression
    val greeting = fun(parList) : Return { body }

    - With lambda expression
    val pointorName : (Input Type) -> Return Type = { par List ->
        body
        value-to-return
    }

    => In Kotlin, {} implictly return the last expression
    => The anonymous function can be used like normal function
    => (void) -> void can be written as
    val name: () -> Unit = {
        println("name")
    }
    => With type reference, following possble too
    ex) 
    val square = { number: Int -> number*number }
    val square: (Int) -> Int = { it*it } // "it" keyword
    => Best practice is distinguish the input with new line.
    ex)
    val stringLengthFunc: (String) -> Int = { input -> 
        input.length
    }
    val length: Int = stringLengthFunc("Android")
- function with function pointors as parameter
    ex)
    fun stringMapper(str: String, mapper: (String) -> Int): Int {
        return mapper(str)
    }
    stringMapper("Android", { input -> 
        input.length
    })
    => If the function pointor is the last parameter, you can do
    stringMapper("Android") { input -> 
        input.length
    }
    

* Variable
- Variable is declared with the following format
    val name : data Type = initial Value (Immutable / Constant)
    var name : data Type = initial Value (Mutable)
  => Best Practice : Always start with val and change to var if necessary.
- Null safety :
    val name : type = null (X)  => Impossible
    val name : type? = null (O) => Possible (Lazy Initialization)
    val name? = null (O)        => Possible (Lazy Initialization)
    var name : type? = null (O) => Possible
    var name? = null (O)        => Possible
    => Null Check : (name != null)

* Code Style
- File Sequence : Comment on File, Package, Import, Declaration
- The recomend nomination for functions and variables is the Camel writing
    ex) calculateTips(), displayErrorMessage();
- The name of function always starts with verb.
- Every line contains only one command.
- If the line exceeds 100 characters, please make new line.
- For comments, use the following formats
ex)
// Hello here
ex2)
/*
 * This is a very long comment that can
 * take up multiple lines.
 */

*/


fun main() {
    println("Hello, World!")

    val count: Int = 2; // Unresignable
    var modifiableCount: Int = 2; // Resignable 
    modifiableCount = 10;
    // If the variable is initiated as declared, you can emit type
    // val count = 2;
    val name: String = "Kihoon, Kim"
    val height: Double = 183.1
    val weight: Float = 85.0f
    val graduate: Boolean = true
    
    // String is addable
    val helloTemplate = "Hello! "
    val hello = helloTemplate + name;

    println(count)
    println(name)
    println(height)
    println(weight)
    println(graduate)
    println(hello)

    // How about adding string with number? => Possible!
    println(hello + count)

    println("Hello, $name!")
    println("Hello, $count!")
    println("Hello, $height!")
    println("Hello, $weight!")
    println("Hello, $graduate!")
    println("Hello, ${weight / height}!")
    // println("Hello, ${100.* weight / height}!") => Not working
    
    // string formatting is univeral
    val again = "$helloTemplate Mr $name!"
    println(again);

    modifiableCount = newFunction(3);
    println("I also received $modifiableCount!");
}

fun newFunction(count : Int) : Int {
    println("I recieve $count!");
    return count;
}
