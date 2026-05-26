package Wipro_2026_day1;



import java.io.*;
import java.util.*;

public class AppForBanking {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        // Store transaction
        FileWriter fw = new FileWriter("transactions.txt", true);

        System.out.print("Enter transaction: ");
        String transaction = sc.nextLine();

        fw.write(transaction + "\n");
        fw.close();

        System.out.println("Transaction Saved");

        // Read transactions
        BufferedReader br =
                new BufferedReader(new FileReader("transactions.txt"));

        String line;

        System.out.println("\nTransaction History:");

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}