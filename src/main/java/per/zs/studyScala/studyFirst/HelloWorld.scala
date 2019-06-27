package per.zs.studyScala.studyFirst

import scala.io.StdIn
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("HelloWorld") 
    test(4)
     println("请输入一个正整数：")
    val n = StdIn.readInt()
    printf("%d的斐波那契数是：%d", n, fbn(n))
  }
  
  def test(a : Int) {
    if(a>2){
      test(a-1)
    }
    println("a="+a)
  }
  
  def fbn(n: Int): Int = {
    if (n == 1 || n == 2) {
      1
    } else {
      fbn(n - 1) + fbn(n - 2)
    }
  }
}