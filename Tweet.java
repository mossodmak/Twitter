/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author mos_s
 */
public class Tweet{
    // attributes
    private String twt; 
    private ArrayList<String> wordList = new ArrayList<String>(); 
    private int wordCount = 0;
    final private String delim = " \t\n.,:;?!-/()[]\"\'";
    // constructor
    public Tweet(String line){
        twt = line;
        StringTokenizer st = new StringTokenizer(line, delim);
        while(st.hasMoreTokens()){
            this.addWord(st.nextToken().toLowerCase());
        }
    }
    // methods
    public void addWord(String word){
        wordList.add(word);
        wordCount++;
    }
    public int checkWord(String word){
        int i = 0;
        Iterator iter = wordList.iterator();
        while(iter.hasNext()){
            if(iter.next().equals(word)){
                i++;
            }
        }
        return i;
    }
    public String getTweet(){
        return twt;
    }
    
}
