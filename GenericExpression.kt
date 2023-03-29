
/* (2023-03-29)
* Generic expression
- With type parameters,
ex)
    class Box<T> (parameter: T) {
        var value = parameter
        var value2 : T = parameter
        
        fun demo(param: T) : T {}
    }

    func void () {
        val box: Box<Int> = Box<Int>(1)
        val number: Int = Box.demo(3)
    }

* Upper Bounds
fun <T : Comparable<T>> sort(list: List<T>) { ... }
- T should be a class that inherits Comparable<T> 

* "out" modifier : Variance Annotation
- Make the class covariant to the parameter T 
 ex) : The Class "Source" is not dependent on T
     interface Source<out T> { // "out" Modifier
        fun nextT(): T
     }
     fun demo(strs: Source<String>) {
        // Conversion Source<String> to Source<Any> is possible
        val objects: Source<Any> = strs
     }

* "in" modifier : 
- Make the class contravariant the parameter T 
ex) : The Class "Comparable" is constraint on T
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}
fun demo(x: Comparable<Number>) {
    x.compareTo(1.0)
    // Conversion from Comparable<Number> to Comparable<Double> is possible
    // (Note Double is a subtype of Number)
    val y: Comparable<Double> = x
}
*/

fun main() {
}
