package Stack특수문자검사;


import java.util.Scanner;
import java.util.Stack;

public class PostFixStack {

   public static void main(String[] args) {

      System.out.println("hw7_4 : 정기혁");
      Stack<Double> s = new Stack<Double>();
      Scanner sc = new Scanner(System.in);
      System.out.print("후위표기수식 입력 :");
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
         System.out.println("잘못된 수식입니다.");

      else
         System.out.println("결과는 =" + s.pop());

   }

}