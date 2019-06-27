package per.zs.studyScala

import per.zs.studyScala.service.CustomerService
import scala.collection.mutable.ListBuffer
import per.zs.studyScala.entity.Customer
import scala.io.StdIn

object Main {
  val customerService: CustomerService = new CustomerService()
  var ctrl = true
  def main(args: Array[String]): Unit = {
      firstPage
  }

  def firstPage(): Unit = {
    while (ctrl) {
      println("-----------------客户信息管理界面-----------------")
      println("                  1 添 加 客 户                  ")
      println("                  2 修 改 客 户                  ")
      println("                  3 删 除 客 户                  ")
      println("                  4 客 户 列 表                  ")
      println("                  5 退          出                  ")
      println("                  请选择(1-5):                   ")
      var key = StdIn.readLine()
      key match {
        case "1" =>{
          println("添 加 客 户")
          customerService.addCustomer()
        }
        case "2" => {
          println("修 改 客 户")
          customerService.updateById()
        }
        case "3" => {
          println("删 除 客 户")
          customerService.deleteCustomer()
        }
        case "4" => {
          println("客 户 列 表")
          customerService.getList()
        }
        case "5" => this.ctrl = false
        case _ => println("请输入1-5")
      }

    }
    println("成功退出系统~~~")
  }

}
