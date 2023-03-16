
/* Inheritance
- The common superclass of Kotlin is Any.
ex) class Example => class Example : Any
- By default, all class is final. To enable inheritance, use "open"
ex) open class Base(p: Int); class Derived(p: Int) : Base(p)
    => This means Base class innitialized with its primary in the
      primary constructor of Derived class.
    => If you have custom constructors, then
ex) 
    class MyView : View {
        constructor (ctx: Context) : super(ctx)
        constructor (ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
        => Base's custom constructor can be used too.
    }
- Only functions or properties with "open" can be overriden. 
- "final + override" is possible too 
ex)
    open class Rectangle() : Shape() {
        final override fun draw() {}
    }
- For primary constructor...
ex)
    open class Shape{
        open val vertexCount: Int;
    }
class Rectangle(override val vertexCount: Int = 4) : Shape

- The Base class is innitialized first than the Derived class.
- For inner class to use the base class, "@<OuterName>" qualifier
ex)
    class FilledRectangle: Rectangle() {
        override fun draw() {
            val filler = Filler()
            filler.drawAndFill()
        }

        inner class Filler : Canvas() {
            fun fill() { println("Filling") }
            fun drawAndFill() {
                super@FilledRectangle.draw() // method of Rectangle
                super.draw() // method of Canvas
            }
        }
    }

- Multiple Implement is also possible.
ex) 
    open class Rectangle {
        // Due to the future duplication, open is mandatory
        open fun draw() {}  
    }

    interface Polygon {
        fun draw() {}
    }

    class Square() : Rectangle(), Polygon {
        // Since both base classes have the same property or fun,
        // Overriding is mandatory
        override fun draw() { 
            super<Rectangle>.draw() // Super need qualifyer too.
            super<Polygon>.draw()   // Super need qualifyer too.
        }
    }
*/



