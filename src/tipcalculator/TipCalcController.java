/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tipcalculator;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author Mario Angulo
 */
public class TipCalcController {

    private TipCalcModel m_model;
    private TipCalcView m_view;

    TipCalcController(TipCalcModel model, TipCalcView view)
    {
        m_model = model;
        m_view = view;


        view.addGuestsListener(new GuestsListener());
        view.addBillTotalListener(new BillTotalListener());
        view.addDeductonsListener(new DeductionsListener());
        view.addTaxListener(new TaxListener());
        view.addMinTipListener(new MinTipListener());
        view.addMaxTipListener(new MaxTipListener());
        view.addQualityListener(new QualityListener());


    }

    class GuestsListener implements DocumentListener
    {
        public void insertUpdate(DocumentEvent e) {
            int userInput = 0;
            try{
                userInput = m_view.getGuests();
                m_model.setNumOfPeople(userInput);
                m_view.setPeople(m_model);

            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }

        public void removeUpdate(DocumentEvent e) {
             int userInput = 0;
            try{
                m_model.setNumOfPeople(userInput);
                m_view.setPeople(m_model);

            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }

        public void changedUpdate(DocumentEvent e) {
            int userInput = 0;
            try{
                userInput = m_view.getGuests();
                m_model.setNumOfPeople(userInput);
                m_view.setPeople(m_model);

            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }
    }

    class BillTotalListener implements DocumentListener
    {

        public void insertUpdate(DocumentEvent e) {
            try{
                m_model.setBillTotal(m_view.getBillTotal());
                m_model.setDeductions(m_view.getDeductions());
                m_model.setTax(m_view.getTax());
                m_model.setTotalTip(m_view.getTotalTip());
                m_view.setTotalTip(m_model.getTotalTip());
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());


            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }

        public void removeUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                m_model.setBillTotal(userInput);
                m_model.setTotalTip(0);
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }

        public void changedUpdate(DocumentEvent e) {
            try{
                m_model.setBillTotal(m_view.getBillTotal());
                m_model.setDeductions(m_view.getDeductions());
                m_model.setTax(m_view.getTax());
                m_model.setTotalTip(m_view.getTotalTip());
                m_view.setTotalTip(m_model.getTotalTip());
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());

            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }
    }

    class DeductionsListener implements DocumentListener
    {
        public void insertUpdate(DocumentEvent e) {
            try{
                m_model.setBillTotal(m_view.getBillTotal());
                m_model.setDeductions(m_view.getDeductions());
                m_model.setTax(m_view.getTax());
                m_model.setTotalTip(m_view.getTotalTip());
                m_view.setTotalTip(m_model.getTotalTip());
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }

        public void removeUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                m_model.setDeductions(userInput);
                m_model.setTotalTip(0);
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
            }
            catch(NumberFormatException nfex)
            {
               m_view.showError("Bad input");
            }
        }

        public void changedUpdate(DocumentEvent e) {
            try{
                m_model.setBillTotal(m_view.getBillTotal());
                m_model.setDeductions(m_view.getDeductions());
                m_model.setTax(m_view.getTax());
                m_model.setTotalTip(m_view.getTotalTip());
                m_view.setTotalTip(m_model.getTotalTip());
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }
    }

    class TaxListener implements DocumentListener
    {

        public void insertUpdate(DocumentEvent e) {
            try{
                m_model.setBillTotal(m_view.getBillTotal());
                m_model.setDeductions(m_view.getDeductions());
                m_model.setTax(m_view.getTax());
                m_model.setTotalTip(m_view.getTotalTip());
                m_view.setTotalTip(m_model.getTotalTip());
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }

        public void removeUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                m_model.setTax(userInput);
                m_model.setTotalTip(0);
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
               
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }

        public void changedUpdate(DocumentEvent e) {
            try{
                m_model.setBillTotal(m_view.getBillTotal());
                m_model.setDeductions(m_view.getDeductions());
                m_model.setTax(m_view.getTax());
                m_model.setTotalTip(m_view.getTotalTip());
                m_view.setTotalTip(m_model.getTotalTip());
                m_view.setPerPersonTip(m_model.getPerPersonTip());
                m_view.setTotal(m_model.getBillTotal());
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input");
            }
        }
    }

    class MinTipListener implements DocumentListener
    {

        public void insertUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                userInput = m_view.getMinTip();
                m_model.setMinTip(userInput);
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }

        public void removeUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                m_model.setMinTip(userInput);
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }

        public void changedUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                userInput = m_view.getMinTip();
                m_model.setMinTip(userInput);
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class MaxTipListener implements DocumentListener
    {

        public void insertUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                userInput = m_view.getMaxTip();
                m_model.setMaxTip(userInput);
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }

        public void removeUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                m_model.setMaxTip(userInput);
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }

        public void changedUpdate(DocumentEvent e) {
            double userInput = 0;
            try{
                userInput = m_view.getMaxTip();
                m_model.setMaxTip(userInput);
            }
            catch(NumberFormatException nfex)
            {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    class QualityListener implements ChangeListener
    {
        private JSlider qualitySlider = new JSlider();
        public void stateChanged(ChangeEvent e)
        {
           if(m_model.getMinTip()<0 && m_model.getMaxTip()>100 && m_model.getMinTip()>m_model.getMaxTip() && m_model.getMaxTip()<m_model.getMinTip())
           {
               m_view.showError("Values are not in range");
           }
           else
           {
               qualitySlider.setMinimum((int)m_model.getMinTip());
               qualitySlider.setMaximum((int)m_model.getMaxTip());

               qualitySlider = (JSlider) e.getSource();

               if(!qualitySlider.getValueIsAdjusting())
               {
                   double value = qualitySlider.getValue();

                   double percentageFactor = (value/100);
                   m_model.setTipRate(percentageFactor);
                   m_view.setTipRate(percentageFactor*100);
                   m_model.setBillTotal(m_view.getBillTotal());
                   m_model.setDeductions(m_view.getDeductions());
                   m_model.setTax(m_view.getTax());
                   m_model.setTotalTip(m_view.getTotalTip());
                   m_view.setTotalTip(m_model.getTotalTip());
                   m_view.setPerPersonTip(m_model.getPerPersonTip());
                   m_view.setTotal(m_model.getBillTotal());

               }
            }

        
        }
    }

    class PeopleListener implements DocumentListener
    {

        public void insertUpdate(DocumentEvent e) {
            m_view.getPeopleName();
        }

        public void removeUpdate(DocumentEvent e) {
                        
            m_view.getPeopleName();

        }

        public void changedUpdate(DocumentEvent e) {
            m_view.getPeopleName();

        }

    }
}
