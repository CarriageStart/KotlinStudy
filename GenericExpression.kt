
/*
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

- Note that 

*/
