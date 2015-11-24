/**
 * @(#)Q1.java
 *
 *
 * @CHUA YING WEI
 * @version 1.00 2015/11/10
 */
import java.io.*;
import java.util.*;
public class Q1 {

public static void main(String[] args)throws IOException{


StringBuffer str = new StringBuffer();

    FileWriter output = new FileWriter("number.txt");

    Random r = new Random();
    for (int i = 1; i < 101; i++) {

        str.append(r.nextInt(100)).append('\n');

    }
    output.write(str.toString());

    output.close();

    FileReader reader = new FileReader("number.txt");
    BufferedReader input = new BufferedReader(reader);

    String line;
    int total = 0;

    while ((line = input.readLine())!=null) {

        System.out.print(line+" ");

        total += Integer.parseInt(line);
    }
    System.out.println();
    System.out.println("Total is:"+total);
}}