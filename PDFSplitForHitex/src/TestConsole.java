//package com.simon.testjdk6.console;
import java.io.Console;

//http://www.duote.com/tech/5/12030.html
public class TestConsole {

    public static void main(String[] args) {

         Console console = System.console(); // ���Consoleʵ������

//        if (console != null) {              // �ж��Ƿ��п���̨��ʹ��Ȩ
         console.writer().write("telnet 9.30.86.19\n");

             String user = new String(console.readLine("Enter username:"));      // ��ȡ�����ַ�
             console.writer().write("dsfdsfdf\n");

         String pwd = new String(console.readPassword("Enter passowrd:"));   // ��ȡ����,����ʱ����ʾ

            console.printf("Username is: " + user + "\n");      // ��ʾ�û���

            console.printf("Password is: " + pwd + "\n");   // ��ʾ����
            

       
//            System.out.println("Console is unavailable."); // ��ʾ�޿���̨ʹ��Ȩ��

//����         }
    }}