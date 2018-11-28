package StackƯ�����ڰ˻�;


import java.util.Scanner;
import java.util.Stack;

public class PostFixStack {

   public static void main(String[] args) {

      System.out.println("hw7_4 : ������");
      Stack<Double> s = new Stack<Double>();
      Scanner sc = new Scanner(System.in);
      System.out.print("����ǥ����� �Է� :");
      String ss = sc.nextLine();
      String [] a =ss.split(" ");


      for (int i = 0; i < a.length; i++) {
         if(a[i].equals("+") ||a[i].equals("-") ||a[i].equals("*")||a[i].equals("/")){
            if(s.size() < 2) {
               s.clear();
               break;
            }

            switch (a[i]) {
            case "+":
               s.push(s.pop() + s.pop());
               break;
            case "-":
               s.push(s.pop() - s.pop());
               break;
            case "*":
               s.push(s.pop() * s.pop());
               break;
            case "/":
               s.push(s.pop() / s.pop());
               break;
            }
         }

         else {
            try {
            double value = Double.parseDouble(a[i]);
            s.push(value);
            }catch(NumberFormatException e) {
            }
         }
      }

      if(s.size() != 1)
         System.out.println("�߸��� �����Դϴ�.");

      else
         System.out.println("����� =" + s.pop());

   }

}