package per.zs.studyScala.studyFirst

object HelloWorld3 extends App {
  var a = "Hello World".reverse
  println(a) // dlroW olleH
  // a.foreach(println)

  var b: Array[String] = "Hello World".split(" ")
  for (i <- b reverse) {
    print(i + " ")
  }

  // 正解
  val args2 = args.reverse
  println(args2.mkString(" ")) // mkString() 表示以什么隔开
}