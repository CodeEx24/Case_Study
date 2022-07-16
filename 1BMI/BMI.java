//MyFirstApplet.java

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Button;
import javax.swing.JFrame;
import java.text.DecimalFormat;

public class BMI extends Applet{ 
    //Decimal Format Pattern
    DecimalFormat twoDigits = new DecimalFormat("0.00");
    
    //style color
    Color bgColor = new Color(0x121228);
    Color Yellow = new Color(0xFAC106);
    Color White = new Color(0xFFFFFF);
    Color Black = new Color(0x000000);
    
    //style font
    Font fontTitle = new Font("Font.Serif", Font.BOLD,30);
    Font fontLabel = new Font("Helvetica", Font.PLAIN, 14);
    Font fontButton = new Font("Helvetica", Font.BOLD, 12);
    
    //Components
    Label lblTitle = new Label("BMI Calculator");
    Label lblHeight = new Label("Height");
    Label lblMeters = new Label("Meters");
    Label lblWeight = new Label("Weight");
    Label lblKilograms = new Label("Kilograms");
    Button btnCompute = new Button("Compute BMI");
    TextField txtCompoHeight = new TextField("", 25);
    TextField txtCompoWeight = new TextField("", 25);
    
    //Panel
    Panel p1 = new Panel();
    Panel p2 = new Panel();

    //Layout
    GridLayout GLbrowser = new GridLayout(4, 1, 10, 10);
    GridLayout GL = new GridLayout(2,3, 10, 10);

    public void init(){
        //Setting properties
        setLayout(GLbrowser);
        setBackground(bgColor);
        setSize(300,300);
        
        //Setting properties of the component
        txtCompoHeight.setForeground(Black);  
        txtCompoWeight.setForeground(Black);  
        txtCompoHeight.setFont(fontLabel);
        txtCompoWeight.setFont(fontLabel);
        lblTitle.setFont(fontTitle);
        lblTitle.setForeground(Yellow);
        lblTitle.setAlignment(1);
        lblWeight.setAlignment(2); 
        lblHeight.setAlignment(2); 
        btnCompute.setBackground(Yellow);
        btnCompute.setForeground(Black);
        
        //Setting panel properties
        p1.setForeground(White);
        p1.setLayout(GL);
        p1.setFont(fontLabel);
        
        //Adding components in panel
        p1.add(lblHeight);
        p1.add(txtCompoHeight);
        p1.add(lblMeters);
        p1.add(lblWeight);
        p1.add(txtCompoWeight);
        p1.add(lblKilograms);

        //Adding buttons in panel
        //It is place in panel so we can get the desired size  of a button
        btnCompute.setPreferredSize(new Dimension(120, 40));
        p2.setFont(fontButton);
        p2.add(btnCompute); 

        //Adding all components/panel to the browser
        add(lblTitle);
        add(p1);
        add(p2);

        //Button Action Listener
        btnCompute.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f = new JFrame();

                //Setting properties for the frame
                f.setVisible(true);
                f.setTitle("RESULT");
                f.setSize(500, 300);
                f.setResizable(false);
                f.setForeground(White);
                f.setLayout(new GridLayout(3, 1, 10, 10));

                //Components in new frame as well as float data type for computation
                Float dheight = Float.parseFloat(txtCompoHeight.getText());
                Float dweight = Float.parseFloat(txtCompoWeight.getText());
                Float dresult = dweight/(dheight*dheight);
                Label lblResult = new Label("Your BMI is "+ twoDigits.format(dresult));
                Label lblTitle2 = new Label("BMI Result");
                Panel fPanel1 = new Panel();
                Panel fPanel2 = new Panel();

                lblResult.setAlignment(1);
                
                //Setting the properties for frame and its panel
                f.getContentPane().setBackground(bgColor);
                fPanel1.setForeground(Yellow);
                fPanel1.setFont(fontTitle);
                fPanel1.add(lblTitle2); //Adding component to panel
                
                //Setting the properties of the frame panel.
                fPanel2.setFont(fontLabel);
                fPanel2.setForeground(White);
                fPanel2.setLayout(new GridLayout(2, 1, 10, 10));
                fPanel2.setSize(100, 50);
                fPanel2.add(lblResult); //Adding component to panel
                
                //Condition statement for the result
                if(dresult >= 20 & dresult <= 26){
                    Label lblFeedback = new Label("Congratulations! You are a Healthy Human BEING!!");
                    lblFeedback.setAlignment(1);
                    fPanel2.add(lblFeedback);
                }else if(dresult > 26){
                    Label lblFeedback = new Label("Sorry my friend, looks like you need some Exercise and Diet");
                    lblFeedback.setAlignment(1);
                    fPanel2.add(lblFeedback);
                }else{
                    Label lblFeedback = new Label("Ohh my! You need to eat a lot and gain some weight!!!");
                    lblFeedback.setAlignment(1);
                    fPanel2.add(lblFeedback);
                }
                //Adding the panel result in to the frame
                f.add(fPanel1);
                f.add(fPanel2);
            }
        });

    }

}


