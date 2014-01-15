/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cowsbulls;

/**
 * @author inSOMniac
 */

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.lang.Math;


public class pcPlays {

    public static void main(String[] args)
    {
        int count=0;
        int cows=0;
        int bulls=0;
        int rand=0;
        
        String verdict;
        try
        {
            FileInputStream dict1 = new FileInputStream("/home/insomniac/Desktop/newdict.txt");
            DataInputStream input1 = new DataInputStream(dict1);
            BufferedReader hr = new BufferedReader(new InputStreamReader(input1));

            //FileWriter fstream = new FileWriter("/home/som/Desktop/newdict.txt", true);
            //BufferedWriter out = new BufferedWriter(fstream);
            //String word="";
            String wr;
            HashSet<String> sets = new HashSet<String>();

            HashSet<String> set1 = new HashSet<String>();
            HashSet<String> set2 = new HashSet<String>();
            HashSet<String> set3 = new HashSet<String>();

            /*
            HashSet<String> s = new HashSet<String>();
            HashSet<String> s1 = new HashSet<String>(s);
            
            s.add("a"); s.add("b"); s.add("c");
            
            for(String z:s)
            {
                s1.remove(z);
            }
            System.out.println(s);
            s.removeAll(s);
            s=s1;
            System.out.println(s);
            s.add("d");
            System.out.println(s1);
            for(String z:s)
            {
                s1.remove(z);
            }
            System.out.println(s);
            */
            int i=0;
            while((wr = hr.readLine())!=null)
            {
                i++;
                sets.add(wr);

            }
            //System.out.println(sets);
            HashSet<String> setc = new HashSet<String>(sets);
            //System.out.println(setc);
            boolean success=true;
            String prev="";
            String prevprev="";
            int ppcow=0;
            int ppbull=0;
            int pcow=0;
            int pbull=0;
            //String word="";
            while(success)
            {
                count++;
                HashSet<String> set = new HashSet<String>(setc);

                String word="";
                double val = Math.random();
                if(set.size()!=0)
                rand = ((int)(val*100000))%(set.size());
                //System.out.println(rand+" "+set.size());
                i=0;
                for(String wq:set)
                {
                    word=wq;
                    if(i==rand)
                    {
                        break;
                    }
                    i++;

                }
                
                /*if(count==10)
                {
                    System.out.println("\n**Why am I even wasting time with a dimwit?");
                    //System.out.println("**The word was "+word);
                    break;
                }*/
                System.out.print("\nMy Guess: "+word);
                
                BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(" -- Your say: ");
                String userVerdict = ip.readLine();
                char cb[]=userVerdict.toCharArray();
                switch(cb[0])
                {
                    case '0': {cows=0;break;}
                    case '1': {cows=1;break;}
                    case '2': {cows=2;break;}
                    case '3': {cows=3;break;}
                    default: {System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                }
                switch(cb[2])
                {   
                    case '0': {bulls=0;break;}
                    case '1': {bulls=1;break;}
                    case '2': {bulls=2;break;}
                    case '3': {bulls=3;break;}
                    default: {System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                }

                //System.out.println("***check***"+prev+" "+pcow+"  "+word+" "+cows);

                if(pcow>=cows && !prev.equals(""))
                {
                    char[] ppr = prevprev.toCharArray();
                    char[] pr = prev.toCharArray();
                    char[] pw = word.toCharArray();
                    /*
                    if(cows==1 && pcow==1 && ppcow==1)
                    {
                        if(pr[0]==pw[0] && ppr[0]==pw[0])
                        {
                            if(bulls==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pw[1]!=pw[0]&&(pw[1]==as[1] || pw[1]==as[0] || pw[1]==as[2]) ||
                                   pw[2]!=pw[0]&&(pw[2]==as[1] || pw[2]==as[0] || pw[2]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                            if(pbull==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pr[1]!=pr[0]&&(pr[1]==as[1] || pr[1]==as[0] || pr[1]==as[2]) ||
                                   pr[2]!=pr[0]&&( pr[2]==as[1] || pr[2]==as[0] || pr[2]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                            if(ppbull==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(ppr[1]!=ppr[0]&&(ppr[1]==as[1] || ppr[1]==as[0] || ppr[1]==as[2]) ||
                                      ppr[2]!=ppr[0]&&(  ppr[2]==as[1] || ppr[2]==as[0] || ppr[2]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                        }
                        else if(pr[2]==pw[2] && ppr[2]==pw[2])
                        {
                            if(bulls==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pw[1]!=pw[2]&&(pw[1]==as[1] || pw[1]==as[0] || pw[1]==as[2]) ||
                                   pw[0]!=pw[2]&&(pw[0]==as[1] || pw[0]==as[0] || pw[0]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                            if(pbull==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pr[1]!=pr[2]&&(pr[1]==as[1] || pr[1]==as[0] || pr[1]==as[2] )||
                                   pr[0]!=pr[2]&&(pr[0]==as[1] || pr[0]==as[0] || pr[0]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                            if(ppbull==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(ppr[1]!=ppr[2]&&(ppr[1]==as[1] || ppr[1]==as[0]) ||
                                        pr[0]!=pr[2]&&(ppr[1]==as[2] || ppr[0]==as[1] || ppr[0]==as[0] || ppr[0]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                        }
                        else if(pr[1]==pw[1] && ppr[1]==pw[1])
                        {
                            if(bulls==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pw[2]!=pw[1]&&(pw[2]==as[1] || pw[2]==as[0] || pw[2]==as[2] )||
                                        pw[0]!=pw[1]&&(pw[0]==as[1] || pw[0]==as[0] || pw[0]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                            if(pbull==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pr[2]!=pr[1]&&(pr[2]==as[1] || pr[2]==as[0] || pr[2]==as[2]) ||
                                        pr[0]!=pr[1]&&(pr[0]==as[1] || pr[0]==as[0] || pr[0]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                            if(ppbull==0)
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(ppr[2]!=ppr[1]&&(ppr[2]==as[1] || ppr[2]==as[0] || ppr[2]==as[2]) ||
                                     ppr[0]!=ppr[1]&&(ppr[0]==as[1] || ppr[0]==as[0] || ppr[0]==as[2]))
                                {
                                    setc.remove(a);
                                }
                            }
                        }
                    }
                     *
                     */

                    if(cows==2 && pcow==cows)
                    {
                        if(pr[0]==pw[0] && pr[1]==pw[1])
                        {
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pr[0]!=as[0] && pr[1]!=as[1])
                                {
                                    if(setc.contains(a))
                                        setc.remove(a);
                                }
                            }
                        }
                        else if(pr[0]==pw[0] && pr[2]==pw[2])
                        {
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pr[0]!=as[0] && pr[2]!=as[2])
                                {
                                    if(setc.contains(a))
                                        setc.remove(a);
                                }
                            }
                        }
                        if(pr[2]==pw[2] && pr[1]==pw[1])
                        {
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pr[2]!=as[2] && pr[1]!=as[1])
                                {
                                    if(setc.contains(a))
                                        setc.remove(a);
                                }
                            }
                        }
                    }
                }

                if(pcow==2 && !prev.equals("") && cows==1)
                {
                    char[] pr = prev.toCharArray();
                    char[] pw = word.toCharArray();
                    if(bulls==0)
                    {
                        if(pr[0]==pw[0] && pw[1]==pr[1])
                        {
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pw[1]==as[1] &&pw[0]==as[0])
                                {
                                    if(setc.contains(a))
                                        setc.remove(a);
                                }                                
                            }
                        }
                        else if(pr[2]==pw[2]  && pw[1]==pr[1])
                        {
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pw[1]==as[1] &&pw[2]==as[2])
                                {
                                    if(setc.contains(a))
                                        setc.remove(a);
                                }
                            }
                        }
                        else if(pr[2]==pw[2] && pw[0]==pr[0])
                        {
                            for(String a:set)
                            {
                                char[] as=a.toCharArray();
                                if(pw[2]==as[2] &&pw[0]==as[0])
                                {
                                    if(setc.contains(a))
                                        setc.remove(a);
                                }
                            }
                        }
                    }
                }
                char[] cw=word.toCharArray();
                switch(cows)
                {
                    case 0:{
                                if(setc.contains(word))
                                        setc.remove(word);
                                //setc.remove(word);
                                switch(bulls)
                                {
                                    case 0:{
                                                for(String ww:set)
                                                {
                                                    for(int j=0;j<3;j++)
                                                    {
                                                        if(ww.charAt(0)==cw[j] || ww.charAt(1)==cw[j] || ww.charAt(2)==cw[j])
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    case 1:{
                                                for(String ww:set)
                                                {
                                                        if(!(ww.charAt(1)==cw[0] || ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[1] || ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[2] || ww.charAt(1)==cw[2]))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                        if((ww.charAt(0)==cw[1] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(1)==cw[2] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(2)==cw[1] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(2)==cw[1] && ww.charAt(1)==cw[2] ||
                                                             ww.charAt(2)==cw[0] && ww.charAt(1)==cw[2] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(2)==cw[0]))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    case 2:{
                                                for(String ww:set)
                                                {
                                                        if(!(ww.charAt(1)==cw[0] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(1)==cw[0] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(1)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(1)==cw[2] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(1)==cw[0] && ww.charAt(0)==cw[1] ||
                                                             ww.charAt(1)==cw[0] && ww.charAt(0)==cw[2] ||
                                                             ww.charAt(1)==cw[2] && ww.charAt(0)==cw[1] ||
                                                             ww.charAt(1)==cw[2] && ww.charAt(0)==cw[2] ))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    case 3:{
                                                for(String ww:set)
                                                {
                                                        if(!(ww.charAt(0)==cw[1] && ww.charAt(1)==cw[2] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(1)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(1)==cw[0] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[1] && ww.charAt(1)==cw[0] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(1)==cw[2] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(1)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(1)==cw[0] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[2] && ww.charAt(1)==cw[0] && ww.charAt(2)==cw[1] ))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    default: {System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                                }
                                break;
                            }
                    case 1:{
                                setc.remove(word);
                                switch(bulls)
                                {
                                    case 0:{
                                                for(String ww:set)
                                                {
                                                        if(!(ww.charAt(0)==cw[0] || ww.charAt(1)==cw[1] || ww.charAt(2)==cw[2]))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    case 1:{
                                                for(String ww:set)
                                                {
                                                        if(!(ww.charAt(0)==cw[0] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(0)==cw[0] && ww.charAt(1)==cw[2] ||
                                                             ww.charAt(0)==cw[0] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[0] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(0)==cw[1] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(0)==cw[2] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(0)==cw[1] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(0)==cw[2] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(1)==cw[2] ))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    case 2:{
                                                for(String ww:set)
                                                {
                                                        if(!(ww.charAt(0)==cw[0] && ww.charAt(1)==cw[0] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[0] && ww.charAt(1)==cw[0] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(0)==cw[0] && ww.charAt(1)==cw[2] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(0)==cw[0] && ww.charAt(1)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(0)==cw[2] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(0)==cw[2] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(0)==cw[1] && ww.charAt(2)==cw[0] ||
                                                             ww.charAt(1)==cw[1] && ww.charAt(0)==cw[1] && ww.charAt(2)==cw[1] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(0)==cw[2] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(0)==cw[2] && ww.charAt(1)==cw[2] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(0)==cw[1] && ww.charAt(1)==cw[0] ||
                                                             ww.charAt(2)==cw[2] && ww.charAt(0)==cw[1] && ww.charAt(1)==cw[2] ))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                set=setc;
                                                break;
                                            }
                                    default:{System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                                }
                                break;
                            }
                    case 2:{
                                setc.remove(word);
                                switch(bulls)
                                {
                                    case 0:{
                                                for(String ww:set)
                                                {
                                                        if(!((ww.charAt(0)==cw[0] && ww.charAt(1)==cw[1]) ||
                                                              (ww.charAt(1)==cw[1] && ww.charAt(2)==cw[2]) ||
                                                                (ww.charAt(0)==cw[0] && ww.charAt(2)==cw[2])
                                                                ))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");                                                               
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                //System.out.println(setc);
                                                set=setc;
                                                //System.out.println(set);
                                                break;
                                            }
                                    case 1:{
                                                for(String ww:set)
                                                {
                                                        if(!((ww.charAt(0)==cw[0] && ww.charAt(1)==cw[1] &&
                                                                (ww.charAt(2) == cw[0] || ww.charAt(2) == cw[1])) ||
                                                              (ww.charAt(1)==cw[1] && ww.charAt(2)==cw[2] &&
                                                                (ww.charAt(0) == cw[1] || ww.charAt(0) == cw[2])) ||
                                                                (ww.charAt(0)==cw[0] && ww.charAt(2)==cw[2] &&
                                                                (ww.charAt(1) == cw[0] || ww.charAt(1) == cw[2]))
                                                                ))
                                                        {
                                                            if(setc.contains(ww))
                                                                setc.remove(ww);
                                                            if(setc.isEmpty())
                                                            {
                                                                System.out.println("You cheat! Thats not a valid word you thought");
                                                                success=false;
                                                                break;
                                                            }
                                                        }
                                                }
                                                //set.removeAll(set);
                                                set=setc;
                                                break;
                                            }
                                    default:{System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                                }
                                break;
                            }
                    case 3:{
                                switch(bulls)
                                {
                                    case 0:{System.out.print("\n Haha! Gotcha Dude!\n");success=false;break;}
                                    default: {System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                                }
                                break;
                            }
                    default: {System.out.println("Enter Valid Values! You're cheating. Game Over");success=false;break;}
                }
                prevprev=prev;
                ppcow=pcow;
                ppbull=pbull;
                prev=word;
                pcow=cows;
                pbull=bulls;
                set=setc;
                System.out.print(set);
            }

        }
         catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
