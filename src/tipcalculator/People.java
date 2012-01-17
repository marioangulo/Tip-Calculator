/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tipcalculator;



/**
 *
 * @author mangulo1
 */
public class People {

    private int numPeople;
    private String personName;
    private String[] names = new String[100];

    public People()
    {
        int numPeople = 0;
    }

    public void setNumOfPeople(int numPeople)
    {
        this.numPeople = numPeople;
    }

    public int getNumOfPeople()
    {
        return numPeople;
    }

    public void setNamesOfPeople(int number, String name)
    {
       this.personName = name;
       this.numPeople = number;
       names[numPeople] = personName;
      
    }
}
