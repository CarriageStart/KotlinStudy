
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
        fun foo() = bar
    }
}

   */
