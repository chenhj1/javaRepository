/**
  * Created by chenhaojie on 2018/02/08. 
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("hello world")
    var total = 10;
    var i = 0;
    for(i <- 1 to total){
      print(i)
    }
    var Array(a,b,c) = Array("1","2","3")
    print(a)
  }
}
