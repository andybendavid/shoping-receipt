import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Salesreceipt {
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        System.out.println("Input:");
        String userInput = input.nextLine();
        System.out.printf("%-15s %-15s %-15s", "item", "price", "qty");
        System.out.println();
        String location = userInput.substring(userInput.indexOf("Location:") + 10);
        double taxRate = 0;
        location = location.substring(0, location.indexOf(","));
        if (location.equals("CA")) {
            taxRate = 0.0975;
        } else if (location.equals("NY")) {
            taxRate = 0.08875;
        }
        double tax = 0;
        var food = new ArrayList<String>();
        food.add("potato chips");
        food.add("apple");
        food.add("orange");
        var clothing = new ArrayList<String>();
        clothing.add("shirt");
        clothing.add("shirts");
        clothing.add("top");
        clothing.add("tops");
        clothing.add("dress");
        clothing.add("dresses");

        char cut = ',';
        int count = 0;

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == cut) {
                count++;
            }
        }
        String[] sen = new String[count + 1];
        String[] beforeAt = new String[count];
        String[] afterAt = new String[count];
        double[] price = new double[count];
        String[] numItemS = new String[count];
        int[] numItem = new int[count];
        String[] item = new String[count];
        sen[0] = userInput;
        double subTotal = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        boolean exempt[] = new boolean[count];

        for (int i = 0; i < count; i++) {
            sen[i] = sen[i].substring(sen[i].indexOf(", ") + 2);
            sen[i + 1] = sen[i];
            beforeAt[i] = sen[i].substring(0, sen[i].indexOf(" at "));
            numItemS[i] = beforeAt[i].substring(0, beforeAt[i].indexOf(" "));
            numItem[i] = Integer.parseInt(numItemS[i]);
            item[i] = beforeAt[i].substring(beforeAt[i].indexOf(" ") + 1);
            afterAt[i] = sen[i].substring(sen[i].indexOf("at ") + 3);
            
            if (i + 1 < count) {
                afterAt[i] = afterAt[i].substring(0, afterAt[i].indexOf(","));
            }
            price[i] = Double.parseDouble(afterAt[i]);
            exempt[i] = false;
            
            if (location.equals("CA") || location.equals("NY")) {
                for (int j = 0; j < food.size(); j++) {
                    if (item[i].equals(food.get(j))) {
                        exempt[i] = true;
                    }
                }
            }
            
            if (location.equals("NY")) {
                for (int j = 0; j < clothing.size(); j++) {
                    if (item[i].equals(clothing.get(j))) {
                        exempt[i] = true;
                    }
                }
            }
            
            subTotal = numItem[i] * price[i] + subTotal;
            
            if (!exempt[i]) {
                tax = tax + (numItem[i] * price[i] * taxRate);
                tax = Math.round(tax * 10.0) / 10.0;
            }
            System.out.printf("%-15s %-15s %-15s", item[i], df.format(price[i]), numItem[i]);
            System.out.println();
        }
        double total = subTotal + tax;
        System.out.printf("%-30s %-15s", "subtotal:", df.format(subTotal));
        System.out.println();
        System.out.printf("%-30s %-15s", "tax:", df.format(tax));
        System.out.println();
        System.out.printf("%-30s %-15s", "total:", df.format(total));
        System.out.println();
    }
}
