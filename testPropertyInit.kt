
/*
class Rectangle(val width: Int, val height: Int) {
    var area: Int  // This cause error
        get() = this.width * this.height
}
*/
class Rectangle(val width: Int, val height: Int) {
    var area: Int = 10
        get() = this.width * this.height    
    // this disguise the property
}

fun main() {
    val obj = Rectangle(10, 20)
    println("Area is ${obj.area}") // == 200
    obj.area = 20
    println("Area is ${obj.area}") // == 200
}
