import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class Calculator extends Applet implements ActionListener
{
    //Color properties for foreground and background
    Color Gray = new Color(0xD4D4D2);
    Color Black = new Color(0x1C1C1C);
    Color Blue = new Color(0x50E0FF);
    Color LightBlack = new Color(0x505050);

    //Title Label and Font
    Label lblTitle = new Label("Calculator");
    Font fontTitle = new Font("Font.Serif", Font.BOLD,30);
    Font fontButton = new Font("Font.Serif", Font.BOLD,16);

    //Textfield for the input of a user
    TextField txtFirstNo = new TextField("", 25);
    TextField txtSecondNo = new TextField("", 25);
    TextField txtResults = new TextField("", 25);

    //All button components in a frame
    Button btnAdd = new Button("+");
    Button btnMinus = new Button("-");
    Button btnMultiply = new Button("*");
    Button btnDivision = new Button("/");
    Button btnEqual = new Button("=");
    Button btnOff = new Button("OFF");
    Button btnOn = new Button("ON");
    Button btnClear = new Button("CLEAR");
    
    //Panel for buttons
    Panel p1 = new Panel();
    Panel p2 = new Panel();

    //Layout for the frame and panel
    GridLayout GLBrowser = new GridLayout(8, 1, 10, 10);
    GridLayout GLButton1 = new GridLayout(1, 4, 10, 10);
    GridLayout GLButton2 = new GridLayout(1, 3, 10, 10);
    GridLayout GLButton3 = new GridLayout(1, 1, 10, 10);

    String Operator; //Operator so this can be pass in equal button to check what to perform.
    Boolean v1; //Boolean so we can access the boolean in the key Listener.

    public void ButtonDefault(){
        //Button default setEnabled false (OFF)
        btnAdd.setEnabled(false);
        btnMinus.setEnabled(false);
        btnMultiply.setEnabled(false);
        btnDivision.setEnabled(false);
        btnOff.setEnabled(false);
        btnClear.setEnabled(false);
        btnEqual.setEnabled(false);
        btnOn.setEnabled(true);

        //Button default background color (OFF)
        btnAdd.setBackground(Gray);
        btnMinus.setBackground(Gray);
        btnMultiply.setBackground(Gray);
        btnDivision.setBackground(Gray);
        btnOn.setBackground(LightBlack);
        btnOff.setBackground(Gray);
        btnClear.setBackground(Gray);
        btnEqual.setBackground(Gray);
    }

    public void SettingComponent(){
        //Setting the properties of different components
        lblTitle.setFont(fontTitle);
        lblTitle.setAlignment(1);
        lblTitle.setForeground(Blue);
        txtFirstNo.setBackground(Gray);
        txtFirstNo.setForeground(Black);
        txtFirstNo.setEditable(false);
        txtSecondNo.setBackground(Gray);
        txtSecondNo.setForeground(Black);
        txtSecondNo.setEditable(false);
        txtResults.setBackground(Gray);
        txtResults.setForeground(Black);
        txtResults.setEditable(false);

        //Action Listener for button
        btnAdd.addActionListener(this);
        btnMinus.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivision.addActionListener(this);
        btnOn.addActionListener(this);
        btnOff.addActionListener(this);
        btnClear.addActionListener(this);
        btnEqual.addActionListener(this);
    }

    public void ResetTextfield(){
        //To disable and reset the text in input field
        txtFirstNo.setText("");
        txtSecondNo.setText("");
        txtResults.setText("");
        Operator = "";
    }

    //This KeyListener is to basically limit the key that the user can type in textfield.
    public void KeyListener(Boolean bool1){
        //This is added so we can access the bool value to pass it inside KeyPressed method.
        v1 = bool1;
        txtFirstNo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                //This will check for key event to limit the user to input unecessary character
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_PERIOD) {
                    //Passing the bool value of v1 so if it is false no matter what key the user is press the textfield will not be editable.
                    txtFirstNo.setEditable(v1);
                } else {
                    txtFirstNo.setEditable(false);
                }
            }
        });

        txtSecondNo.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_PERIOD) {
                    txtSecondNo.setEditable(v1);
                } else {
                    txtSecondNo.setEditable(false);
                }
            }
        });
    }

    public void init(){
        //Setting properties of a browser
        setLayout(GLBrowser);
        setBackground(Black);
        setForeground(Gray);
        setSize(300, 300);
        
        //Calling the method for setting the different properties
        SettingComponent();
        ButtonDefault();

        //Setting the panel properties
        p1.setBackground(Black);
        p1.setForeground(Gray);
        p1.setFont(fontButton);
        p1.setLayout(GLButton1);

        //Adding component to panel1
        p1.add(btnAdd);
        p1.add(btnMinus);
        p1.add(btnMultiply);
        p1.add(btnDivision);

        //Setting the panel properties of panel2
        p2.setBackground(Black);
        p2.setForeground(Gray);
        p2.setFont(fontButton);
        p2.setLayout(GLButton2);

        //Adding component to panel2
        p2.add(btnOn);
        p2.add(btnOff);
        p2.add(btnClear);

        //Adding all the components into the browser
        add(lblTitle);
        add(txtFirstNo);
        add(p1);
        add(txtSecondNo);
        add(btnEqual);
        add(txtResults);
        add(p2);
    }
 
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnOn){ 
            //Setting the properties of button when the calculator is On
            btnAdd.setBackground(LightBlack);
            btnMinus.setBackground(LightBlack);
            btnMultiply.setBackground(LightBlack);
            btnDivision.setBackground(LightBlack);
            btnOff.setBackground(LightBlack);
            btnClear.setBackground(LightBlack);
            btnEqual.setBackground(LightBlack);
            btnOn.setBackground(Gray);

            //Enable the button when it is on
            btnAdd.setEnabled(true);
            btnMinus.setEnabled(true);
            btnMultiply.setEnabled(true);
            btnDivision.setEnabled(true);
            btnOff.setEnabled(true);
            btnClear.setEnabled(true);
            btnEqual.setEnabled(true);
            btnOn.setEnabled(false);

            //To check for key keylistener to limit user character input.
            KeyListener(true);
        }else if(e.getSource() == btnOff){
            //Calling ResetTextField method to reset all of the textfield as well as operator value.
            ResetTextfield();
            //Calling Button default to set the properties of the default/off button.
            ButtonDefault();
            //Keylistener with argument false.
            KeyListener(false);
        }else if(e.getSource() == btnClear){
            //Calling function to reset all of the textfield as well as operator value.
            ResetTextfield();
        }else if(e.getSource() == btnAdd){
            Operator = "Addition"; //Addition
        }else if(e.getSource() == btnMinus){
            Operator = "Subtraction"; //Subtraction
        }else if(e.getSource() == btnMultiply){
            Operator = "Multiplication"; //Multiplication
        }else if(e.getSource() == btnDivision){
            Operator = "Division"; //Division
        }else if(e.getSource() == btnEqual){
            //If button equal is click then it will check if the text field is empty
            if(txtFirstNo.getText().isEmpty() & txtSecondNo.getText().isEmpty()){
                txtResults.setForeground(new Color(0xFF0000));
                txtResults.setText("Please Input a value on 1st and 2nd Field!");;
            }else if(txtFirstNo.getText().isEmpty()){
                txtResults.setForeground(new Color(0xFF0000));
                txtResults.setText("Please Input a value on 1st Field!");;
            }else if(txtSecondNo.getText().isEmpty()){
                txtResults.setForeground(new Color(0xFF0000));
                txtResults.setText("Please Input a value on 2nd Field!");;
            }else{
                //Getting the value in the text field
                float lFirstNo = Float.valueOf(txtFirstNo.getText());
                float lSecondNo = Float.valueOf(txtSecondNo.getText());

                //Checking the operator value and perform the function inside it
                txtResults.setForeground(Black);
                if(Operator == "Addition"){
                    txtResults.setText(Float.toString(lFirstNo + lSecondNo));
                }else if(Operator == "Subtraction"){
                    txtResults.setText(Float.toString(lFirstNo - lSecondNo));
                }else if(Operator == "Multiplication"){
                    txtResults.setText(Float.toString(lFirstNo * lSecondNo));
                }else if(Operator == "Division"){
                    txtResults.setText(Float.toString(lFirstNo / lSecondNo));
                }else{
                    //If there are no operator it will ask for the user to  input an operator
                    txtResults.setForeground(new Color(0xFF0000));
                    txtResults.setText("ERROR: Choose an operator first!");;
                }
            }
        }
    }
}
