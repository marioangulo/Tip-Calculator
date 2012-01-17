/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tipcalculator;

import javax.swing.*;
/**
 *
 * @author Mario Angulo
 */
public class TipCalc  {

    public static void main(String[] args)
    {

        TipCalcModel model = new TipCalcModel();
        TipCalcView view = new TipCalcView(model);
        TipCalcController controller = new TipCalcController(model, view);


        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setSize(300,300);
        view.setVisible(true);


    }

}
