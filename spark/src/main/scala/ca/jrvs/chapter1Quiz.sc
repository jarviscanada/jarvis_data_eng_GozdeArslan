/*Use the REPL to print the string "greetings".*/

println("greetings")

/*What does the following code print?*/

var x: Int = 22
println(x)

/* the output of the following x: Int = 22, value of x assigned the integer after variable created println statement printed the value.*/


/*What does the following code print? What is the type of variable y? */
var y = 99
println(y)
// the output will be 99 is printed.


//What does the following code print?
//var aa: String = "hello"
//aa = "pretty"
//println(aa)
//"pretty" is printed. The variable aa is typed as a string  and reassigned as pretty will be printed.

//What does the following code print?
var bb: Int = 10
bb = "funny"
println(bb)
// There will be an error, integer value cannot be assigned as string

//What does the following code print?
val cc: Double = 3.14
println(cc)
//3.14 is printed.

//What does the following code print?
//val dd: Double = 9.99
//dd = 10.01
//println(dd)
//This code throws an error. Variables assigned with the val keyword cannot be reassigned to another value after they've been assigned.

//What is the type of the variable gg?
//var gg = 8.88

// scala will recognize it as double.

//single line definition
println()

//multiline definition
println{


  var first = "lionel"
  s"$first messi"  //this is string interpretation


}



//Function definitions


class User(n: String) {
  val name: String = n
}

var u =new User(n="Frank")