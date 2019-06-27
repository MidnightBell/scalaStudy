package per.zs.studyScala.dao

import per.zs.studyScala.entity.Customer
import scala.collection.mutable.ListBuffer
import util.control.Breaks._

class CustomerDao {
  //模拟数据库中的数据
  val customer1 = new Customer(1, "zs", '男', 24, "13548429131", "sheng.zhong@changhong.com")
  val customer2 = new Customer(2, "bell", '男', 24, "18392003880", "sheng.zhong@163.com")
  //
  var customerList: ListBuffer[Customer] = ListBuffer[Customer](customer1, customer2) //初始化赋值，模拟数据库中原本存在的记录

  //获取客户数据
  def list: ListBuffer[Customer] = {
    customerList
  }

  //增加客户数据
  def insert(customer: Customer): Unit = {
    //模拟存入数据库
    customerList.append(customer)
  }

  //删除客户数据
  def delete(id: Int): Boolean = {
    var flag: Boolean = false
    breakable {
      for (i <- 0 until customerList.length) {
        if (customerList(i).id == id) {
          customerList.remove(i)
          flag = true
          break()
        }
      }
    }
    flag
  }

  //根据id修改客户数据
  def updateById(fun: Int => Int, customer: Customer, id: Int): Boolean = {
    if (fun(id) == -1) false else {
      customerList.update(fun(id), customer)
      true
    }
  }
  
  //获取id对应的数据在集合的索引
  def getIndexById(id: Int): Int = {
    var index : Int = -1
    breakable {
      for (i <- 0 until customerList.length) {
        if (customerList(i).id == id) {
          index = i
          break()
        }
      }
    }
    index
  }
  
  //根据id查询客户数据
  def getById(id: Int): Customer = {
    var customer : Customer = new Customer()
    breakable {
      for (i <- 0 until customerList.length) {
        if (customerList(i).id == id) {
          customer = customerList(i)
          break()
        }
      }
    }
    customer
  }

}