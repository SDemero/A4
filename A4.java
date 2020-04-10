/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author samueldemero
 */
public class A4 {

   
    public static void main(String[] args)throws Exception{
        HashMap<Integer, ArrayList<Movie>> genre =
                new HashMap<Integer, ArrayList<Movie>>();
        HashMap<String,Integer> genrecount = new HashMap<String,Integer>();
        ArrayList<Movie> G = new ArrayList<Movie>();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> ane = new ArrayList<Integer>();
        PrintStream ps = new PrintStream(new File("Output.txt"));
        library(G,list,ane);
        
        Collections.sort(list);
        Collections.sort(ane);
        
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(list);
        ArrayList<String> list2 = new ArrayList<>(hashSet);
        
        LinkedHashSet<Integer> hashSet2 = new LinkedHashSet<>(ane);
        ArrayList<Integer> ane2 = new ArrayList<>(hashSet2);
       
        countGenre(genrecount,list,list2);
        Set set2 = genrecount.entrySet();
      Iterator iterator2 = set2.iterator();
      while(iterator2.hasNext()) {
          Map.Entry mentry2 = (Map.Entry)iterator2.next();
          ps.println("There are "+mentry2.getValue() + " "+mentry2.getKey()+" movies");
          
          byYear(list,list2,ane2,G);
         
       }

        
        
        
    }
    public static void library(ArrayList<Movie> G,ArrayList<String> list
            ,ArrayList<Integer> ane)
            throws Exception{
        Scanner sc = new Scanner(new File(""
            + "/Users/samueldemero/Desktop/NetBeansProjects/A3/movies.csv"));
         int i = 0;
         
        while (sc.hasNext()){
           String line = sc.nextLine();
                String[] tokens = line.split(",");
                
                if (tokens.length>3){
                    String[] smoke = line.split("\"");
                    int end = smoke[1].length();
                   
                    String title = smoke[1].substring(0, end-6);
                    i++;
               String[] p2 = line.split("\\(");
               if (p2.length > 1){
                  StringBuffer year = new StringBuffer(p2[p2.length-1]);
                     year.replace( 4 ,year.length()+1 ,"");
                     String genre = tokens[tokens.length - 1];
                     ArrayList<String> MLBOA = new ArrayList<>();
                 
                    String[] hot = genre.split("\\|");
                   
                    for (String strTemp : hot) {
                        list.add(strTemp);
                        MLBOA.add(strTemp);
                        
                    }

                    ane.add(Integer.parseInt(year.toString()));
            Movie mov1 = new Movie (title,Integer.parseInt(year.toString()),MLBOA);
                   G.add(mov1);
                }

            } else {
                String pop = tokens[1];
                String[] p2 = pop.split("\\(");
                String title = tokens[1].substring(0, tokens[1].length() - 6);
                if (p2.length > 1) {
                    StringBuilder year = new StringBuilder(p2[p2.length - 1]);
                    year.replace(4, year.length() + 1, "");
                    //System.out.println(title);
                    i++;
                    // System.out.println(year);
                    int Year = Integer.parseInt(year.toString());
                    String genre = tokens[tokens.length - 1];
                     ArrayList<String> MLBOA = new ArrayList<>();
                    // System.out.println(genre);
                    String[] hot = genre.split("\\|");
                    //System.out.println(hot[0]);
                    for (String strTemp : hot) {
                        list.add(strTemp);
                        MLBOA.add(strTemp);
                        
                    }

                    ane.add(Year);
                    Movie mov1 = new Movie(title, Year,MLBOA);
                    G.add(mov1);
                }

            }

        }
    }

   public static void countGenre(HashMap<String,Integer> genrecount,
           ArrayList<String> list,ArrayList<String> list2) {
       int counter;
       for (int i = 0; i<list2.size();i++){
        counter = 0;
           for (int j = 0; j<list.size();j++){
               if (list2.get(i).equals(list.get(j))){
                counter++; 
                
                   
               }
           } genrecount.put(list2.get(i), counter);
       }
       
   }
    public static void byYear(ArrayList<String> list,ArrayList<String> list2,
            ArrayList<Integer> year,ArrayList<Movie> g){
        int counter;
        for (int a=0;a< year.size();a++){
            System.out.println("In "+ year.get(a));
            for (int b=0;b<g.size();b++){
                if (year.get(a)==g.get(b).getReleaseYear()){
                    for (int i = 0; i<list2.size();i++){
        counter = 0;
           for (int j = 0; j<list.size();j++){
               if (list2.get(i).equals(list.get(j))){
                counter++; 
                
                   
               }
           } 
           System.out.println("In "+year.get(a)+" there were "+ counter+" "+list2.get(i)+ " movies");
       }
                }
            }
        }
        
    }
}

