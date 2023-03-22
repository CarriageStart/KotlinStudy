
/* 
* Memory Management in Kotlin

- Objects are always stored in a shared heap and can be accessed 
 from any threads within the process.

- There is always an seperate thread that G.C. is excuted. And the 
 thread is kicked off based on the timer, memory pressure, or 
 manually.

ex) Manual call

func main () {
    kotlin.native.internal.GC.collect()
}

- Tracing G.C. is executed periodically to collect objects that are not reachable from the "roots", like local and gloabl variables.
 (In Kotlin, every thing is just pointor or reference.)
    : Note, the stack frame information is redundant.
    : Any thing on stack will be removed, therefore, unless it is 
     inserted or created within a class, G.C. doesn't connect the
     created objects. Therefore, they are unmarkable.
    (Periodic checking cycle is not synchronized to stack-manage
    in the tracing garbage collection.)

* Tracing Garbage Collection
    : Save all the pointors for all allocated momories
    : In every cycle, it test whether allocated memories accesible.
    : Tree-search algorithm starting from the root memory.

    ** The MEMORY MODEL(HIARARCHY OR ELSE...) is the STRUCTURE of 
    the MEMORY POINTORS collected in G.C.
    ** Accesible   : root -> firstObject -> secondObject
    ** UnAccesible : root -> firstObject(pointor refeence removed) 
                    -> secondObject (Unaccesible):

    - root : Memory always accessible. 
    (Internal of language or Permanent for whole application life)

- Mark-Sweep Algorithm (Mark and Sweep)
    : As it sweep the memory tree, it mark the accesibles.
    : After sweep, it wipes out the unmarked memories.
    : Then, it un-marks all the momories.
    : Compact the memory allocation, if necessary.

- Incremental Tracing
    : 
*/
