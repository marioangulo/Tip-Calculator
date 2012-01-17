/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tipcalculator;

import java.text.DecimalFormat;


/**
 *
 * @author mangulo1
 */
public class Bill extends Tip{

    private double billTotal;
    private double billDeductions;
    private double tax;
    private double totalTip;
    private double perPersonTip;


    public void setBillTotal (double billTotal)
    {
        this.billTotal = billTotal;
    }

  
    public void setDeductions(double billDeductions)
    {
        this.billDeductions = billDeductions;
    }

    public void setTax(double tax)
    {
        this.tax = tax;
    }

    public void setTotalTip(double totalTip)
    {
        this.totalTip = totalTip;
    }


    public double getBillTotal()
    {
        this.billTotal = billTotal + totalTip;
        return roundTwoDecimals(billTotal);
    }

    public double getBillDeductions()
    {
        return roundTwoDecimals(this.billDeductions);
    }

    public double getTax()
    {
        return roundTwoDecimals(tax);
    }

    public double getTotalTip()
    {
        this.totalTip = ((billTotal - getBillDeductions()) + getTax()) * tipRate;
        return roundTwoDecimals(totalTip);
    }

    public double getPerPersonTip()
    {
        this.perPersonTip = (this.totalTip/getNumOfPeople());
        return roundTwoDecimals(perPersonTip);
    }

    private double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

}
