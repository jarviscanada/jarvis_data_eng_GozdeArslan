//Scala practice
println("scala is fun")
var x: Int =99
x
println(x)
var y =33
var cat = "garfield"
//Type casting
//the casting should me the following line

//byte->short->int->long->float->double
             // |
             // char

val x: Long = 802657465
val y: Float=x

//Example of passing function inside the methods
def f1(x: Int, y: Int) = {
  x+y
}

def f2(x: Int, y: Int) = {
  x-y
}

def sum(f: (Int, Int) => Int, z: Int) = {
  f(2,8) + z
}


println(sum(f1, 3))
sum(f2, 3)

//There will be no return statement Because definition of methods followed by the retunr type in methods

 def sums(x:Int,y:Int): Int =x+y
println(sums(1,2))
//methods with no parameter
def name :String =System.getProperty("user.name")
println("hello" +name)

//Defining a class
/* Basic definition of class */
class User
val user1 = new User

class Point(var x: Int =0,var y:Int=0){ //primary construtir is class signature


  def mv(dx:Int,dy:Int): Unit={
    x = x + dx
    y = y + dy

  }

  override def toString: String =
    s"($x, $y)"

}
 val point1 =new Point(3,5)
 println(point1.y)
//assigning default value in the constructor then reassigning the value
class Point(var x: Int = 0, var y: Int = 0)
val point2 = new Point(y = 2)
println(point2.x,point2.y)


//Default parameter values
def log (msg: String, level: String ="INFO")= println(s"$level:$msg")
log ("please set the user")
log("user not found","Error")


//Traits

