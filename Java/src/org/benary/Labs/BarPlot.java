/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.benary.Labs.Lab_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author benaryorg
 */
public class BarPlot
{
    public BarPlot() throws IOException
    {
        String str;
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        while((str=reader.readLine())!=null)
        {
            //TODO: Something
        }
    }
    
    /**
     * Liefert einen
     * @param c
     * @param n
     * @return 
     */
    public static String repeat(char c,int n)
    {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++)
        {
            sb.append(c);
        }

        return sb.toString();
    }
}
