//package com.simon.testjdk6.console;
import java.io.Console;

//http://www.duote.com/tech/5/12030.html
public class TestConsole {

    public static void main(String[] args) {

         Console console = System.console(); // 获得Console实例对象

//        if (console != null) {              // 判断是否有控制台的使用权
         console.writer().write("telnet 9.30.86.19\n");

             String user = new String(console.readLine("Enter username:"));      // 读取整行字符
             console.writer().write("dsfdsfdf\n");

         String pwd = new String(console.readPassword("Enter passowrd:"));   // 读取密码,输入时不显示

            console.printf("Username is: " + user + "\n");      // 显示用户名

            console.printf("Password is: " + pwd + "\n");   // 显示密码
            

       
//            System.out.println("Console is unavailable."); // 提示无控制台使用权限

//　　         }
    }}