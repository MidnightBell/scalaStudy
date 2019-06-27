package per.zs.studyScala.studyFirst

import scala.collection.mutable
object HelloWorld2 {
  def main(args: Array[String]): Unit = {
    def countWord(map:mutable.Map[String,Int],str:String) : mutable.Map[String,Int] = {
      for(item <- str.split(" ").iterator){
        map += (item -> (map.getOrElse(item, 0)+1))
      }
      return map
    }
    
    val lines = List("atguigu han hello", "atguigu han aaa aaa aaa ccc ddd uuu")
    val map = mutable.Map[String,Int]()
    val count = lines.foldLeft(map)(countWord)
    println(count)
    
    val girlFriend : GirlFriends = new GirlFriends("鞠婧祎", 25, 46.0, 159.0, "78-54.5-80", "可爱的小鞠")
    
    println(girlFriend.toString())
  }

}