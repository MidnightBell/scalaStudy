package per.zs.studyScala.studyFirst

object CompareWhileRecursion {
  def main(args: Array[String]): Unit = {
    //使用while
//    val now1: Date = new Date()
//    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    val date1 = dateFormat.format(now1)
//    println("date1=" + date1) // 输出时间
//    var res = BigInt(0) // 存放计算的结果
//    var num = BigInt(1) // 变化的数
//    val maxVal = BigInt(99999999l) // 测试效率使用大数
//    while (num <= maxVal) {
//      res += num // 累加
//      num += 1 // 变量的叠加
//    }
//    println("res=" + res)
//
//    val now2: Date = new Date()
//    val date2 = dateFormat.format(now2)
//    println("date2=" + date2) // 输出时间

  //使用递归
//  val now3: Date = new Date()
//  val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//  val date3 = dateFormat.format(now3)
//  println("date1=" + date3) // 输出时间
//
//  // 测试
//  var num = BigInt(1)
//  var sum = BigInt(0)
//  var res = mx(num, sum)
//  println("res=" + res)
//
//  val now4: Date = new Date()
//  val date4 = dateFormat.format(now4)
//  println("date2=" + date4) // 输出时间
//
//  // 使用递归的方式来解决
//  def mx(num: BigInt, sum: BigInt): BigInt = {
//    if (num <= 99999999l) return mx(num + 1, sum + num)
//    else return sum
//  }
    
    //递归求集合最大值
  def mymax(xs: List[Int]): Int = {
      if (xs.isEmpty)
        throw new java.util.NoSuchElementException
      if (xs.size == 1)
        xs.head
      else if (xs.head > mymax(xs.tail)) xs.head else mymax(xs.tail)
    }
    println(mymax(List(6, 2, 14, 4, 5)))
    println(List(6, 2, 14, 4, 5).head)
    println(List(6, 2, 14, 4, 5).tail)
  }
}