/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cowsbulls;

/**
 *
 * @author insomniac
 */

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.lang.Math;


public class cowsNbulls {

    public static void main(String[] args)
    {
        int count=0;
        int count1=0;
        int cows=0;
        int bulls=0;
        int rand=0;
        String word;
        try
        {
            FileInputStream dict = new FileInputStream("/home/insomniac/Desktop/newdict.txt");
            DataInputStream input = new DataInputStream(dict);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            FileInputStream dict1 = new FileInputStream("/home/insomniac/Desktop/newdict.txt");
            DataInputStream input1 = new DataInputStream(dict1);
            BufferedReader hr = new BufferedReader(new InputStreamReader(input1));

            FileWriter fstream = new FileWriter("/home/insomniac/Desktop/newdict.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);

            double val = Math.random();
            //System.out.println("\n"+val+" ");
            rand = ((int)(val*1000000))%1182;
            //System.out.println(" "+rand+"\n");
            String wr;
            HashSet<String> set = new HashSet<String>();
            while((wr = hr.readLine())!=null)
            {
                set.add(wr);
            }
            
            int i=0;
            while((word = br.readLine())!=null)
            {
                i++;
                if(i==rand)
                {
                    break;
                }
            }
            boolean success=true;
            while(success)
            {
                count++; count1++;
                if(count==10)
                {
                    System.out.println("\n**You dimwit! 10 chances!! you sure you don't have alzhiemer's??");
                    System.out.println("**The word was "+word);
                    break;
                }

                if(count1==1)
                {
                    System.out.println("Instructions: I have thought of a 3-letter word, you get 10 chances to");
                    System.out.println("to guess it correctly - for each of your guesses, I will tell #Cows #Bulls");
                    System.out.println("where #Cows means number of letters that are present in MY word and are at");
                    System.out.println("right position, #Bulls tells number of letters in their wrong position ");
                    System.out.println("in MY word. I'm sure you'd lose you Birdbrain! Evil Grin!\n");
                }
                System.out.print("\nEnter a 3-letter word: ");
                BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
                String userWord = ip.readLine().toLowerCase();

                if(set.contains(userWord))
                {
                    char uw[]=userWord.toCharArray();
                    char w[] = word.toCharArray();

                    for(int j=0;j<3;j++)
                    {
                        if(uw[j]==w[j])
                        {
                            cows++;
                        }
                        // EDITTTTT
                        if(j==0)
                        {
                            if(uw[j]==w[1] || uw[j]==w[2])
                            {
                                bulls++;
                                if(cows+bulls>3)
                                    bulls--;
                            }
                        }
                        if(j==1)
                        {
                            if(uw[j]==w[0] || uw[j]==w[2])
                            {
                                bulls++;
                                if(cows+bulls>3)
                                    bulls--;
                            }
                        }
                        if(j==2)
                        {
                            if(uw[j]==w[0] || uw[j]==w[1])
                            {
                                bulls++;
                                if(cows+bulls>3)
                                    bulls--;
                            }
                        }
                    }
                    if(cows==3)
                    {
                        success=false;
                        System.out.println("\n***3C***\nHoly Cows! \"YOU\" won!! Thats cuz I choose easy words for morons! :D");
                    }
                    else
                    {
                        System.out.print(cows+"C"+" "+bulls+"B");
                        cows=0; bulls=0;
                    }
                }
                else
                {
                    System.out.print("WTF! whats "+userWord+"?? you scumbag!");
                    count--;
                }
            }

        }
         catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
