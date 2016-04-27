/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blto;

import com.csvreader.CsvWriter;
import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;


/**
 *
 * @author JUANCARLOS
 */
public class Blto 
{
    private int pos1=0;
    private int pos2=1;
    private int pos3=2;
    private int pos4=3;
    private int pos5=4;
    private int pos6=5;
    private int stop=99999;
   private ArrayList txt=null;

    private int con;
   private Long cont;
    int nom=1;
     int cod=0; 
     private List lista;
   public Blto()
   {
    txt = new  ArrayList();
   
   }

    public void Conteo()
    {
        ArrayList nums = new ArrayList();
      
         int var=1;
         int cont=0;
       
        for (int i =1 ;i<=45 ; i++) 
        {
            
            for (int j =01 ;j<=45 ; j++) 
            {
                if(j!=i)
                {
                    for (int k =01 ;k<=45 ; k++) 
                    {
                       if(k!=j && k!=i) 
                       {
                           for (int l =01 ;l<=45 ; l++) 
                                     {
                                         if(l!=k && l!=j && l!=i && k!=j && k!=i && j!=i) 
                                             {
                                                  for (int m =01 ;m<=45 ; m++)
                                                  {
                                                    if(m!=l && m!=k && m!=j && m!=i && l!=k && l!=j && l!=i && k!=j && k!=i && j!=i)
                                                    {
                                                        for (int n =01 ;n<=45 ; n++)
                                                        {
                                                           if(n!=m && n!=l && n!=k && n!=j && n!=i && m!=l && m!=k && m!=j && m!=i && l!=k && l!=j && l!=i && k!=j && k!=i && j!=i) 
                                                           {
                                                        nums.add(i);
                                                        nums.add(j);
                                                        nums.add(k);
                                                        nums.add(l);
                                                        nums.add(m);
                                                        nums.add(n);
                                                         nums = ordenar(nums);
                                                
                                                      
                                                      
                                                       String p = nums.get(0)+"/"+ nums.get(1)+ "/"+nums.get(2)+ "/"+nums.get(3)+ "/"+nums.get(4)+ "/"+nums.get(5);
                                                      txt.add(p);
                                                      
                                                         if(cont==stop)
                                                         {
                                                           ordenartxt();                                                          
                                                           cont=0;
                                                           stop=100000;
                                                           if(txt.size()>=999999)
                                                           {
                                                               archivo();
                                                               txt = new ArrayList();
                                                               
                                                           }
                                                         }
                                                            
                                                            nums.remove(pos6);
                                                            nums.remove(pos5);
                                                            nums.remove(pos4);
                                                            nums.remove(pos3);
                                                            nums.remove(pos2);
                                                            nums.remove(pos1); 
                                                            cont++;
                                                           }
                                                        }
                                                        
                                                    }
                                                  }
                                                  
                                               
                                              }
                                         
                                     }
                          
                       }
                    }
                   
                }
                
            }
            
        }
        System.out.println(con + " /" + txt.size());
        archivo();
    }
    
    public ArrayList ordenar(ArrayList nums)
    {
        int temp=0;
       
         for (int i =0 ;i<nums.size() ; i++) 
         {
             
             for (int j =i ;j<nums.size() ; j++) 
             {
                 int a = (int) nums.get(i);
                int b = (int) nums.get(j);
                if(a>b && a!=b)
                {
                    temp=b;
                   nums.set(j, a);                   
                   nums.set(i, temp);
                   temp =0;
                    
                }
             }
              
         }
         ArrayList p = new ArrayList();
         p.add(nums.get(0));
         p.add(nums.get(1));
         p.add(nums.get(2));
         p.add(nums.get(3));
         p.add(nums.get(4));
         p.add(nums.get(5));
        return p;
        
    }
  
    public void ordenartxt()
    {
        System.out.println("Tamaño inicial:  "+txt.size());
        String temp;
        
      for (int i =0 ;i<txt.size() ; i++) 
         {
             
             for (int j =i+1 ;j<txt.size() ; j++) 
             {
                
                String a = (String) txt.get(i);
                 String b = (String) txt.get(j);                
                if(a.compareTo(b)>0)
                {
                    temp=a;
                    txt.set(i,b);
                    txt.set(j,temp);                   
                   
                   temp ="";
                    
                }
                if(a.compareTo(b)==0)
                {
                    txt.remove(j);
                    
                } 
               
             }
             
            
               
         } 
      System.out.println("tamaño final:  "+ txt.size()+"/");
    }
   
public  void archivo()
{
    
   if(nom==3)
   {
       System.out.print(nom + "   /   " + cod); 
   }
    
    int val;
    
     
  String outputFile = "D:\\bltos"+nom+".csv";
  
        boolean alreadyExists = new File(outputFile).exists();
         
        if(alreadyExists==false)
        {
            File ficheroUsuarios = new File(outputFile);
            ficheroUsuarios.delete();
        }        
         
        try 
        {
         
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ';');
             
            csvOutput.write("Cod");
            csvOutput.write("Nums");            
            csvOutput.endRecord();
              
           
             for (int i =0 ;i<txt.size() ; i++) 
             {
               csvOutput.write(String.valueOf(cod)); 
               csvOutput.write(String.valueOf(txt.get(i)));            
               csvOutput.endRecord();
               cod++;
               
             }
             csvOutput.close();
         
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("blto"+nom + "   /   " + cod); 
        nom++;
     
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Blto b = new Blto();
        b.Conteo();
      //  b.ordenartxt();
     //   b.archivo();
        
       // b.listar();
        // TODO code application logic here
    }
    
}
