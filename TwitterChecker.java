/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mos_s
 */
public class TwitterChecker {
    public static void main(String[] mossodmak){
        ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
        int tweetCount = 0;
        String line;
        try{
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                tweetList.add(new Tweet(line));
                tweetCount++;
            }
        }catch (IOException e) {}
        //wordPrint(tweetList);
        wordSearch(tweetList,"must");
        wordCountSearch(tweetList,"must");
    }
    public static void wordSearch(ArrayList<Tweet> list, String word){
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            Tweet ans = (Tweet)iter.next();
            if(ans.checkWord(word)>0){
                System.out.println(ans.getTweet());
            }
        }
    }
    public static void wordCountSearch(ArrayList<Tweet> list, String word){
        int count = 0;
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            Tweet ans = (Tweet)iter.next();
            count+=ans.checkWord(word);
        }
        System.out.println("The word count of " + word + " = " + count);
    }
    public static void wordPrint(ArrayList<Tweet> list){
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            Tweet ans = (Tweet)iter.next();
            System.out.println(ans.getTweet());
        }
    }
}


