/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biz.no_ip.druidamortis.Labs;

public class PotionTest {
public static void main (String[] args) {
    // Zutaten werden erstellt
    Ingredient ingredient1 = new Ingredient("Toad"); 
    Ingredient ingredient2 = new Ingredient("Lizard"); 
    Ingredient ingredient3 = new Ingredient("Spider");
    // set name of ingredient1 to "Fly"
    ingredient1.setName("Fly");
    // Zaubertrank wird mit 2 Zutaten erstellt
    Potion potion = new Potion(ingredient1, ingredient2, ingredient3);
    // Zaubertrank wird dreimal umgerührt
    potion.stir();
    potion.stir();
    potion.stir();
    // Information ueber den Zaubertrank wird ausgegeben
    System.out.println(potion);
    // wie die Ausgabe aussehen koennte:
    //
    // Ingredients: Fly, Lizard, Spider
    // Power: 15
    // Ready: no
    // Zaubertrank wird noch zwei mal umgerührt
    potion.stir();
    potion.stir();
    // Informationen ueber Zaubertrank wird erneut ausgegeben
    System.out.println(potion);
    // wie die Ausgabe aussehen koennte:
    //
    // Ingredients: Fly, Lizard, Spider
    // Power: 30
    // Ready: yes
} }