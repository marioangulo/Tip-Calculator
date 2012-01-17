/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tipcalculator;


import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;


/**
 *
 * @author Mario Angulo
 */
public class TipCalcView extends JFrame {
    private JTextField m_mintip = new JTextField(2);
    private JTextField m_maxtip = new JTextField(2);
    private Checkbox tcb = new Checkbox();
    private Checkbox dcb = new Checkbox();
    private TipCalcModel model;
    private JTextField m_guests = new JTextField(2);
    private JTextField m_billtotal = new JTextField(10);
    private JTextField m_deductions = new JTextField(10);
    private JTextField m_tax = new JTextField(10);
    private JLabel m_tiprate = new JLabel();
    private JLabel m_totaltip = new JLabel();
    private JLabel m_perpersontip = new JLabel();
    private JLabel m_total = new JLabel();
    private JSlider m_qofservice  = new JSlider();
    private JTabbedPane m_tabbedpane = new JTabbedPane();
    private JTextField m_name[] = new JTextField[100];
    private JSlider m_tipslider[] = new JSlider[100];
    private JLabel m_label[] = new JLabel[100];
    private JLabel m_tipamount[] = new JLabel[100];



    TipCalcView(TipCalcModel model)
    {
        createTabbedPane(model);
    }

    JTabbedPane createTabbedPane(TipCalcModel model)
    {
        setTitle("Tip Calculator");
        m_tabbedpane.addTab("Main Menu", createMainPanel());
        m_tabbedpane.setSelectedIndex(0);
        m_tabbedpane.addTab("Config Panel", createConfigPanel());
        m_tabbedpane.addTab("Tip Tailoring", createTipTailoringPanel(model));
        getContentPane().add(m_tabbedpane);
        return m_tabbedpane;
    }

    JPanel createConfigPanel()
    {
        JPanel content = new JPanel();

        content.setLayout(new GridLayout(4,2));
        content.add(new JLabel("Min Tip Percentage"));
        content.add(m_mintip);
        content.add(new JLabel("Max Tip Percentage"));
        content.add(m_maxtip);
        content.add(new JLabel("Include Tax"));
        content.add(tcb);
        content.add(new JLabel("Include Deductions"));
        content.add(dcb);


        return content;
    }


    JPanel createMainPanel()
    {
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(9,2));
        content.add(new JLabel("Num of Guests"));
        content.add(m_guests);
        content.add(new JLabel("Quality of Service"));
        content.add(m_qofservice);
        content.add(new JLabel("Bill Total"));
        content.add(m_billtotal);
        content.add(new JLabel("Bill Deductions"));
        content.add(m_deductions);
        content.add(new JLabel("Tax"));
        content.add(m_tax);
        content.add(new JLabel("Tip Rate"));
        content.add(m_tiprate);
        content.add(new JLabel("Total Tip"));
        content.add(m_totaltip);
        content.add(new JLabel("Per Person Tip"));
        content.add(m_perpersontip);
        content.add(new JLabel("Total(Bill and Tip)"));
        content.add(m_total);
        return content;
    }

    JPanel createTipTailoringPanel(TipCalcModel model)
    {

        JPanel content = new JPanel();
        content.removeAll();
        content.updateUI();
        content.setLayout(new GridLayout(0,4));
        for(int i=1; i<=model.getNumOfPeople(); i++)
        {
            m_name[i] = new JTextField();
            m_tipslider[i] = new JSlider();
            m_label[i] = new JLabel();
            m_tipamount[i] = new JLabel();
            content.add(m_name[i]);
            content.add(m_tipslider[i]);
            content.add(m_label[i]);
            content.add(m_tipamount[i]);
        }

        return content;
    }


    int getGuests()
    {
        String guests = m_guests.getText();
        int value = Integer.valueOf(guests);
        return value;
    }

    double getBillTotal()
    {
        if(m_billtotal.getText().trim().length() == 0)
        {
            double value = 0;
            return value;
        }
        else
        {
            String billtotal = m_billtotal.getText();
            double value = Double.valueOf(billtotal);
            return value;
        }
    }

    double getDeductions()
    {
        if(m_deductions.getText().trim().length() == 0)
        {
            double value = 0;
            return value;
        }
        else
        {
            String deductions = m_deductions.getText();
            double value = Double.valueOf(deductions);
            return value;
        }
    }

    double getTax()
    {
        if(m_tax.getText().trim().length() == 0)
        {
            double value = 0;
            return value;
        }
        else
        {
            String tax = m_tax.getText();
            double value = Double.valueOf(tax);
            return value;
        }
    }

    double getMinTip()
    {
        if(m_mintip.getText().trim().length() == 0)
        {
            double value = 0;
            return value;
        }
        else
        {
            String tip = m_mintip.getText();
            double value = Double.valueOf(tip);
            return value;
        }
    }

    double getMaxTip()
    {
        if(m_maxtip.getText().trim().length() == 0)
        {
            double value = 0;
            return value;
        }
        else
        {
            String tip = m_maxtip.getText();
            double value = Double.valueOf(tip);
            return value;
        }
    }

    double getTotalTip()
    {
        if(m_totaltip.getText().trim().length() == 0)
        {
            double value = 0;
            return value;
        }
        else
        {
            String tip = m_totaltip.getText();
            double value = Double.valueOf(tip);
            return value;
        }

    }

    String getPeopleName()
    {
        String name = "";
        if(m_totaltip.getText().trim().length() == 0)
        {
            return name;
        }
        else
        {
            for(int i=1; i<=model.getNumOfPeople(); i++)
            {
                name = m_name[i].getText();
                return name;
            }
        }

        return name;

    }

    void setPeople(TipCalcModel m_model)
    {
        m_tabbedpane.removeTabAt(2);
        m_tabbedpane.addTab("Tip Tailoring", createTipTailoringPanel(m_model));
        getContentPane().add(m_tabbedpane);
    }

    void setTotal(Double total)
    {
        String output = String.valueOf(total);
        m_total.setText(output);
    }


    void setTotalTip(Double totaltip)
    {
        String output = String.valueOf(totaltip);
        m_totaltip.setText(output);
    }

    void setTipRate(Double tipRate)
    {
        String output = String.valueOf(tipRate);
        m_tiprate.setText(output);
    }

    void setPerPersonTip(Double pptip)
    {
        String output = String.valueOf(pptip);
        m_perpersontip.setText(output);
    }



    void showError(String errMessage)
    {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addPeopleListener(DocumentListener pal)
    {
        for(int i=1; i<=model.getNumOfPeople(); i++)
        {
            m_name[i].getDocument().addDocumentListener(pal);
        }
    }

    void addGuestsListener(DocumentListener gal)
    {
        m_guests.getDocument().addDocumentListener(gal);
    }

    void addBillTotalListener(DocumentListener btal)
    {
        m_billtotal.getDocument().addDocumentListener(btal);
    }

    void addDeductonsListener(DocumentListener dal)
    {
        m_deductions.getDocument().addDocumentListener(dal);
    }

    void addTaxListener(DocumentListener tal)
    {
        m_tax.getDocument().addDocumentListener(tal);
    }

    void addMinTipListener(DocumentListener mtal)
    {
        m_mintip.getDocument().addDocumentListener(mtal);
    }

    void addMaxTipListener(DocumentListener mtal)
    {
        m_maxtip.getDocument().addDocumentListener(mtal);
    }

    void addQualityListener(ChangeListener qcl)
    {
        m_qofservice.addChangeListener(qcl);
    }

    
}
