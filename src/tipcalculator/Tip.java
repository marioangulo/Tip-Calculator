/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tipcalculator;

import java.text.DecimalFormat;

/**
 *
 * @author Mario Angulo
 */
public class Tip extends People{

    public double tipRate;
    private double minTipPercentage;
    private double maxTipPercentage;


    public void setMinTip(double minTipPercentage)
    {
        this.minTipPercentage = minTipPercentage;
    }

    public void setMaxTip(double maxTipPercentage)
    {
        this.maxTipPercentage = maxTipPercentage;
    }

    public void setTipRate(double tipRate)
    {
        this.tipRate = tipRate;
    }

    public double getTipRate()
    {
        return tipRate;
    }

    public double getMaxTip()
    {
        return maxTipPercentage;
    }

    public double getMinTip()
    {
        return minTipPercentage;
    }

    private double roundTwoDecimals(double d)
    {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

}
