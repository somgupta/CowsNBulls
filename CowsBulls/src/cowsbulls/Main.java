/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cowsbulls;

/**
 *
 * @author som
 */

import java.util.*;
import java.io.*;
import java.lang.*;


public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        String word;
        try
        {
            FileInputStream dict = new FileInputStream("/home/som/Desktop/fulldictionary00.txt");
            DataInputStream input = new DataInputStream(dict);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            FileWriter fstream = new FileWriter("/home/som/Desktop/newdict.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);

            while((word = br.readLine())!=null)
            {
                char c[]=word.toCharArray();
                int len=c.length;
                if(len==3)
                {
                    out.write(word+"\n");
                    //out.write("\n");
                    System.out.println(word.trim());
                    HashMap<String, String> map;
                    String t="kfhnkudg";
                    StringTokenizer t= new StringTokenizer(t," ");





                }
            }
        }
         catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
