/*
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


* Function Pointor 
- Function in Kotlin is first-class function(Treated as primitive type).
    => Can be denoted with a function pointor.

- Anonymous function expression
  ex)  
    val greeting: (parList) -> ReturnType = fun(parList) : ReturnType { body }
    val greeting: () -> ReturnType = fun(parList) : ReturnType { body }
    val greeting = fun(parList) : ReturnType { body }

- Lambda expression
    - Different expression of function only with fold "{}"
  ex)
    val pointorName : (Input Type) -> Return Type = { par List ->
        body
        value-to-return
    }
        => In Kotlin, {} implictly return the last expression
        => The anonymous function can be used like normal function
        => (void) -> void can be written as
  ex)
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

- There is "receiver" type, too. : Specify the parameter in detail.
  ex)
    val name: A.(B) -> C = function; (One parameter function)
      => Function type of which the parameter is B type of A class and return C type.
    => The following conversion is possible
      (A, B) -> C   <=> A.(B) -> C

- Higher-order function is a function that takes or return function pointor.
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

- "varargs" as args

* InLine Function

*/

fun main() {
    val len1 = stringMapper("Android", {input -> 
        input.length
    })
    val len2 = stringMapper("Android") {input -> 
        input.length
    }

    val anomFunc : (String) -> Int = { parName ->
        parName.length
    }
    val len3 = stringMapper("Android", anomFunc)
    println("len1 : $len1, len2 : $len2, len3 : $len3")
}

fun stringMapper(str: String, mapper: (String) -> Int): Int {
    return mapper(str)
}
