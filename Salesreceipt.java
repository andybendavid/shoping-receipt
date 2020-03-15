package salesreceipt;
import java.util.Scanner;
import java.text.DecimalFormat;  

public class Salesreceipt {
    static double tax;
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Input first item's name");
        String item1 = input.nextLine();
        System.out.println("Number of "+item1);
        int numberitem1 = input.nextInt();
        System.out.println("Price of "+item1);
        double priceitem1 = input.nextDouble();
        
        input = new Scanner(System.in);
        System.out.println("Input second item's name");
        String item2 = input.nextLine();
        System.out.println("Number of "+item2);
        int numberitem2 = input.nextInt();
        System.out.println("Price of "+item2);
        double priceitem2 = input.nextDouble();
        String CA="CA\n";
        input = new Scanner(System.in);
        System.out.println("Location?(CA=1/NY=2)");
        int location = input.nextInt();
        System.out.println("------");
      

       double item1Total = priceitem1 * numberitem1;
       double item2Total = priceitem2 * numberitem2;
       double subTotal = item1Total  + item2Total;
       if(location==1)
       {
       tax = subTotal * 0.0975;
       }
       if(location==2)
       {
       tax = subTotal * 0.08875;
       }
       tax = Math.round(tax * 20.0) / 20.0;
       double total= subTotal+tax;  
       DecimalFormat    df   = new DecimalFormat("#.00"); 
       System.out.println("item\t\t\tprice\t\t\tqty");
       System.out.println(item1+"\t\t\t"+df.format(priceitem1)+"\t\t\t"+numberitem1);
       System.out.println(item2+"\t\t\t"+df.format(priceitem2)+"\t\t\t"+numberitem2);

       

       System.out.println("subtotal:\t\t\t\t" + df.format(subTotal));
       System.out.println("tax:\t\t\t\t\t" + df.format(tax));
       System.out.println("total\t\t\t\t\t" + df.format(total));
       
       
    }
}
