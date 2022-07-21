import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.event.KeyListener;
import java.security.Key;

class Menu extends Frame implements ActionListener, ItemListener
{   private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 550;

    DecimalFormat twoDigits = new DecimalFormat("0.00");

    //Color properties
    Color Orange = new Color(0xEE7600);
    Color Black = new Color(0x000000);
    Color White = new Color(0xF1F1F1);
    Color Green = new Color(0x00765E);

    //Calculate button
    Button btnCalculate = new Button("Calculate");

    //Label for Title and x Multiplier
    Label lblSpace = new Label(" ");
    Label lblTitle = new Label("MENU FOR TODAY");
    Label lblComboMeal = new Label("Combo Meal");
    Label lblDrinks = new Label("Drinks");
    Label lblTotal = new Label("TOTAL");
    Label lblX1 = new Label("x"); //Duplicathing the lblX because it won't reflect to the frame if it is not.
    Label lblX2 = new Label("x");
    Label lblX3 = new Label("x");
    Label lblX4 = new Label("x");
    Label lblX5 = new Label("x");
    Label lblX6 = new Label("x");
    Label lblBlank = new Label(""); //We input this because we can't set the last component at the exact position
    //By adding this component this will became the last component that goes in random position.
    
    //Setting the font properties
    Font fontCBBold = new Font("Font.Serif", Font.BOLD,16);
    Font fontCBPlain = new Font("Font.Serif", Font.PLAIN,14);
    Font fontTitle = new Font("Font.Serif", Font.BOLD,30);
    
    //Textfield in the frame
    TextField txtCM1 = new TextField("", 3);
    TextField txtCM2 = new TextField("", 3);
    TextField txtCM3 = new TextField("", 3);
    TextField txtERice = new TextField("", 3);
    TextField txtCoke = new TextField("", 3);
    TextField txtSprite = new TextField("", 3);
    TextField txtTotal = new TextField("", 12);

    //Checkbox Item
    Checkbox chkCM1 = new Checkbox("Combo Meal 1 Php 100.00");
    Checkbox chkCM2 = new Checkbox("Combo Meal 2 Php 120.00");
    Checkbox chkCM3 = new Checkbox("Combo Meal 3 Php 150.00");
    Checkbox chkCoke = new Checkbox("Coke Php 30.00");
    Checkbox chkSprite = new Checkbox("Sprite Php 25.00");
    Checkbox chkERice = new Checkbox("Extra Rice + 20.00");

    //Panel
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();
    Panel p5 = new Panel();
    Panel p6 = new Panel();
    Panel p7 = new Panel();
    FlowLayout fl = new FlowLayout(FlowLayout.LEFT);

    // constructor
    public Menu(){
        // set frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setTitle("Menu Program");
        setLocation(150, 150);
        setForeground(White);
        setBackground(Green);
        
        //Setting properties of title and adding it into frame
        lblTitle.setForeground(Orange);
        lblTitle.setFont(fontTitle);
        lblTitle.setBounds(130, 45, 270,30);
        lblTitle.setAlignment(1);
        add(lblTitle);

        //Setting properties of title combo meal and adding it into the frame
        lblComboMeal.setFont(fontCBBold);
        lblComboMeal.setBounds(105, 85, 300, 30);
        lblComboMeal.setAlignment(1);
        add(lblComboMeal);

        //Setting textfield foreground because the default is white
        txtCM1.setForeground(Black);
        txtCM2.setForeground(Black);
        txtCM3.setForeground(Black);
        txtERice.setForeground(Black);
        txtCoke.setForeground(Black);
        txtSprite.setForeground(Black);
        txtTotal.setForeground(Black);

        //Multiplier Textfield initialize not Editable
        txtCM1.setEditable(false);
        txtCM2.setEditable(false);
        txtCM3.setEditable(false);
        txtERice.setEditable(false);
        txtCoke.setEditable(false);
        txtSprite.setEditable(false);
        txtTotal.setEditable(false);

        //Adding Item Listener to the checkbox
        chkCM1.addItemListener(this);
        chkCM2.addItemListener(this);
        chkCM3.addItemListener(this);
        chkERice.addItemListener(this);
        chkCoke.addItemListener(this);
        chkSprite.addItemListener(this);
        chkERice.addItemListener(this);

        //Setting properties of panel then adding it into the frame
        p1.setBounds(135, 120, 400, 30);
        p1.setLayout(fl);
        p1.add(chkCM1);
        p1.add(lblX1);
        p1.add(txtCM1);
        add(p1);

        //Setting properties of panel then adding it into the frame
        p2.setBounds(135, 160, 400, 30);
        p2.setLayout(fl);
        p2.add(chkCM2);
        p2.add(lblX2);
        p2.add(txtCM2);
        add(p2);

        //Setting properties of panel then adding it into the frame
        p3.setBounds(135, 200, 400, 30);
        p3.setLayout(fl);
        p3.add(chkCM3);
        p3.add(lblX3);
        p3.add(txtCM3);
        add(p3);

        //Setting properties in component and panel then adding it into the frame
        chkERice.setBounds(140, 240, 120, 30);;
        p4.setBounds(305, 240, 400, 30);
        p4.setLayout(fl);
        p4.add(lblX4);
        p4.add(txtERice);
        add(chkERice);
        add(p4);

        //Setting properties for title and add it into the frame
        lblDrinks.setBounds(105, 290, 300, 30);
        lblDrinks.setFont(fontCBBold);
        lblDrinks.setAlignment(1);
        add(lblDrinks);

        //Setting properties in component and panel then adding it into the frame
        p5.setBounds(305, 330, 400, 30);
        chkCoke.setBounds(140, 330, 120, 30);;
        p5.setLayout(fl);
        p5.add(lblX5);
        p5.add(txtCoke);
        add(chkCoke);
        add(p5);

        //Setting properties in component and panel then adding it into the frame
        p6.setBounds(305, 370, 400, 30);
        chkSprite.setBounds(140, 370, 120, 30);;
        p6.setLayout(fl);
        p6.add(lblX6);
        p6.add(txtSprite);
        add(chkSprite);
        add(p6);

        //Setting properties of button and add it into the frame
        btnCalculate.setBounds(200,420,100,30);
        btnCalculate.setFont(fontCBBold);
        btnCalculate.setBackground(Orange);
        btnCalculate.setForeground(White);
        add(btnCalculate);

        //Setting the properties of panel and component then add it into the frame
        lblTotal.setFont(fontCBBold);
        p7.setLayout(fl);
        p7.add(lblTotal);
        p7.add(txtTotal);
        p7.setBounds(155, 460, 400, 30);
        add(p7);

        //This code is added because the last component in frame can't adjust the position in the frame(BUG)
        add(lblBlank);

        // register the button to add an ActionListener to the component
        btnCalculate.addActionListener(this);

        // register a Program Terminator as this frame's windowlistener*/
        addWindowListener(new ProgramTerminator());
    }
    

    public void itemStateChanged(ItemEvent e)
    {
        KeyListener();
        //Getting the state of each checkbox
        //COMBOMEAL 1
        if(chkCM1.getState() == true){
            //If the textfield of that checkbox is empty then it will set the text into 1
            if(txtCM1.getText().isEmpty()){
                txtCM1.setText("1");
            }
        }else{
            //Else it will reset the value and disable the edit in text field.
            txtCM1.setText("");
            txtCM1.setEditable(false);
        }
        
        //COMBOMEAL 2
        if(chkCM2.getState() == true){
            if(txtCM2.getText().isEmpty()){
                txtCM2.setText("1");
            }
        }else{
            txtCM2.setText("");
            txtCM2.setEditable(false);
        }
        
        //COMBOMEAL 3
        if(chkCM3.getState() == true){
            if(txtCM3.getText().isEmpty()){
                txtCM3.setText("1");
            }
        }else{
            txtCM3.setText("");
            txtCM3.setEditable(false);
        }
    
        //EXTRA RICE
        if(chkERice.getState() == true){
            if(txtERice.getText().isEmpty()){
                txtERice.setText("1");
            }
        }else{
            txtERice.setText("");
            txtERice.setEditable(false);
        }
    
        //COKE DRINKS
        if(chkCoke.getState() == true){
            if(txtCoke.getText().isEmpty()){
                txtCoke.setText("1");
            }
        }else{
            txtCoke.setText("");
            txtCoke.setEditable(false);
        }
    
        //COKE SPRITE
        if(chkSprite.getState() == true){
            if(txtSprite.getText().isEmpty()){
                txtSprite.setText("1");
            }
        }else{
            txtSprite.setText("");
            txtSprite.setEditable(false);
        }
    }

    public void KeyListener(){
        //Adding Key Listener to disable unecessary keys such as letter.
        txtCM1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                //Checking for the key event if it is number or backspace the textfield will be editable as long as the state of checkbox is true.
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    txtCM1.setEditable(chkCM1.getState());
                } else {
                    txtCM1.setEditable(false);
                }
            }
         });
        
        txtCM2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    txtCM2.setEditable(chkCM2.getState());
                } else {
                    txtCM2.setEditable(false);
                }
            }
        });

        txtCM3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    txtCM3.setEditable(chkCM3.getState());
                } else {
                    txtCM3.setEditable(false);
                }
            }
        });
        
        txtERice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    txtERice.setEditable(chkERice.getState());
                } else {
                    txtERice.setEditable(false);
                }
            }
        });

        txtCoke.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    txtCoke.setEditable(chkCoke.getState());
                } else {
                    txtCoke.setEditable(false);
                }
            }
        });

        txtSprite.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    txtSprite.setEditable(chkSprite.getState());
                } else {
                    txtSprite.setEditable(false);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e)
    {
        //If Calculate button is click then it will check the state of each checkbox and add those active in total.
        if (e.getSource() == btnCalculate){
            float total = 0, value;
            //Starting here it will check the state of each checkbox. If it is true then it will add the value of that specific product.
            if(chkCM1.getState() == true){
                value =  100 * Float.parseFloat(txtCM1.getText());
                total += value;
            }

            if(chkCM2.getState() == true){
                value =  120 * Float.parseFloat(txtCM2.getText());
                total += value;
            }

            if(chkCM3.getState() == true){
                value =  150 * Float.parseFloat(txtCM3.getText());
                total += value;
            }

            if(chkERice.getState() == true){
                value =  20 * Float.parseFloat(txtERice.getText());
                total += value;
            }

            if(chkCoke.getState() == true){
                value =  30 * Float.parseFloat(txtCoke.getText());
                total += value;
            }

            if(chkSprite.getState() == true){
                value =  25 * Float.parseFloat(txtSprite.getText());
                total += value;
            }
            //Setting the textfield of total value of all inputted products.
            txtTotal.setText("Php " + String.valueOf(twoDigits.format(total)));
        }  
    }
}
