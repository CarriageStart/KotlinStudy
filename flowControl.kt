/*
* If statement

ex1)
if (condition1) {
    body1
} else if (condition2) {
    body2
} else {
    body3
}

ex2) Copy value like return for variable initiation or insertion
val answerString: String = if (condition1) {
    "I have the answer." => No return specified
} else if (condition2) {
    "The answer is close"
} else {
    "The answer eludes me"
}
    => Type can be emitted but the best practice is specifying it.
    => Implicitly, if body return the last expression(can be any rvalue)

ex3) With function, if statement can be "=" operated

* When statement
ex1)
when {
    condition1 -> Body1
    condition2 -> Body2
    in 1..10 -> Body3
    !in 1..10 -> Body4
    is String -> Body5
    !is String -> Body6
    else -> Body7 => "else" madatory when algorithm no greedy.
}
ex2)
val answerString = when {
    condition1 -> value1
    condition2 -> value2
    else -> value3
}
    => Type is often emitted.

* While statement
ex1)
while (condition()) {
    Body()
}
ex2) Check the condition after excution
do {
    Body()
} while (condition())

* For Statement
ex1)
for (i: Int in 1..10) {
    doSomething();
}
ex2)
for (i in Iterable) {
    doSomething(); // i : item
}
for (i in Iterable.indices) {
    doSomething(); // i : index
}
for ((index, value) in Iterable.withIndex()) {
    doSomething(); 
}
ex3)
for (i in 10 downTo 1 step 2) {
    doSomething();
}

* Try statement
try {
    doSomething()
} catch (e: Exception) {
    doException()
}
*/

fun main() {
    // If statement
    val count = 42
    val answerString: String = if (count == 42) {
        "I have the answer."
    } else if (count > 35) {
        "The answer is close"
    } else {
        "The answer eludes me"
    }

    val answerString2: String = when {
        count == 42 -> "I have the answer."
        count > 35 -> "The answer is close"
        else -> "The answer eludes me"
    }
}

fun functionWithIf(count: Int): String {
    return if (count > 10) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }
}
    //=> Prefer {} to = 

fun functionWithIf2(count: Int): String = if (count > 10) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }

