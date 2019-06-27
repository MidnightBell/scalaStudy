package per.zs.studyScala.service

import per.zs.studyScala.entity.Customer
import per.zs.studyScala.dao.CustomerDao
import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import per.zs.studyScala.Main

class CustomerService {
  val customerDao:CustomerDao = new CustomerDao()

  //获取customer数据
  def getList(): Unit = {
    printCustomer(customerDao.list)
    println("-------------输入任意值继续！退出系统请输入：0！------------------")
    val tab = StdIn.readLine()
    if (tab == "0") Main.ctrl = false
  }

  //新增customer
  def addCustomer() : Unit = {
    println()
    println("---------------------添加客户---------------------")
    println("姓名：")
    val name = StdIn.readLine()
    if(name.length() == 0) {
      println("----------输入为空！3秒后返回首页------------------")
      for (i <- 1 to 3) {
        println(4 - i)
        Thread.sleep(1000)
      }
      return
    }
    
    println("性别（男/女）：")
    var gender = StdIn.readLine()
    if (gender != "男" && gender != "女") {
      println("----------输入错误！3秒后返回首页------------------")
      for (i <- 1 to 3) {
        println(4 - i)
        Thread.sleep(1000)
      }
      return
    }
    val gender_1 = gender.charAt(0)
    
    println("年龄（0-150）：")
    val age = StdIn.readLine()
    if (!age.matches("[1-9]|[1-9]\\d|1[0-4]\\d")) {
      println("----------输入错误！3秒后返回首页------------------")
      for (i <- 1 to 3) {
        println(4 - i)
        Thread.sleep(1000)
      }
      return
    }
    val age_1 = age.toShort
    
    println("电话：")
    val tel = StdIn.readLine()
    
    println("邮箱：")
    val email = StdIn.readLine()
    
    val maxId = getMaxId(customerDao.list) //获取最大的Id
    val customer : Customer = new Customer(maxId+1,name,gender_1,age_1,tel,email)
    customerDao.insert(customer)
    println("---------------------添加成功---------------------")
    println("----------继续添加请输入：1！退出系统请输入：0！------------------")
    val tab = StdIn.readLine()
    if(tab == "1") addCustomer else if(tab == "0") Main.ctrl = false
  }

  //删除customer
  def deleteCustomer(): Unit = {
    println()
    println("---------------------删除客户---------------------")
    println("请输入待删除客户id：")
    val id = StdIn.readInt()
    val flag: Boolean = customerDao.delete(id)
    if (flag == true) {
      println("删除id=" + id + "对应的customer信息成功")
    } else {
      println("删除失败！id=" + id + "对应的customer信息不存在")
    }
    println("----------继续删除请输入：1！退出系统请输入：0！------------------")
    val tab = StdIn.readLine()
    if(tab == "1") deleteCustomer else if(tab == "0") Main.ctrl = false
  }

  //根据id修改customer数据
  def updateById(): Unit = {
    println()
    println("---------------------修改客户---------------------")
    println("请选择待修改客户id：")
    val id = StdIn.readInt()
    var customer: Customer = findById(id)

    if (customer != null) {
      println("------------------输入修改信息------------------")
      println("姓名：")
      var name = StdIn.readLine()
      if (name.length() == 0) name = customer.name

      println("性别（男/女）：")
      var gender_1 = customer.gender
      val gender = StdIn.readLine()
      if (gender.length() != 0) {
        if (gender != "男" && gender != "女") {
          println("----------输入错误！3秒后返回首页------------------")
          for (i <- 1 to 3) {
            println(4 - i)
            Thread.sleep(1000)
          }
          return
        }
        gender_1 = gender.charAt(0)
      }
      
      println("年龄（0-150）：")
      var age_1 = customer.age
      val age = StdIn.readLine()
      if (age.length() != 0) {
        if (!age.matches("[1-9]|[1-9]\\d|1[0-4]\\d")) {
          println("----------输入错误！3秒后返回首页------------------")
          for (i <- 1 to 3) {
            println(4 - i)
            Thread.sleep(1000)
          }
          return
        }
        age_1 = age.toShort
      }
      
      println("电话：")
      var tel = StdIn.readLine()
      if (tel.length() == 0) tel = customer.tel

      println("邮箱：")
      var email = StdIn.readLine()
      if (email.length() == 0) email = customer.email

//      println(id, name, gender, age, tel, email)
      val newCustomer: Customer = new Customer(id, name, gender_1, age_1, tel, email)
      val flag = customerDao.updateById(customerDao.getIndexById, newCustomer, id)
      if (flag == true) {
        println("修改id=" + id + "对应的customer信息成功")
      } else {
        println("修改失败！id=" + id + "对应的customer信息不存在")
      }
    }

    println("----------修改其他信息请输入：1！退出系统请输入：0！------------------")
    val tab = StdIn.readLine()
    if (tab == "1") updateById else if (tab == "0") Main.ctrl = false
  }
  
  
  //根据Id查询customer数据
  def findById(id : Int): Customer = {
    val customerById = customerDao.getById(id)
    if (customerById.id == 0) {
      println("id=" + id + "对应的customer信息不存在")
      null
    } else {
      println("id=" + id + "对应的customer信息--------------------")
      println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
      println(customerById)
      println("------------------------------------------")
      customerById
    }
  }
  
  //获取用户中的最大Id
  def getMaxId(fun1: => ListBuffer[Customer]): Int = {
    fun1.map((customer:Customer) => customer.id).foldLeft(-1)((n1:Int,n2:Int) => if(n1>n2) n1 else n2)
  }
  
  //输出到控制台展示所有customer信息
  def printCustomer(fun: => ListBuffer[Customer]): Unit = {
    println("所有customer信息：-------------------------")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
    for (customer <- fun) {
      println(customer)
    }
    println("------------------------------------------")
  }
}