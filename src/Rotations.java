
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;

public class Rotations extends Frame implements ActionListener {

    int[] x = {500,700,700,500};
    int[] y = {300,300,200,200};


    public Rotations() {
        int windowWidth = 800;

        addWindowListener(new MyFinishWindow());  // Add WindowListener to exit the program when window is closed
        setTitle("Rotations");  // Set title

        MenuBar menu_bar = new MenuBar();  // Create menu
        Menu def = new Menu("Menu");
        def.add(new MenuItem("Set Default"));
        def.addActionListener(this);
        menu_bar.add(def);
        setMenuBar(menu_bar);

        Panel panel=new Panel();  // Add control panel
        panel.setBounds(0,50,windowWidth ,50); //Black region with buttons



        // Creating buttons
        Button button_s = new Button();
        button_s.setLabel("Left Bottom-Clockwise"); //First button
        button_s.addActionListener(this);
        Button button_b = new Button();
        button_b.addActionListener(this);
        button_b.setLabel("Origin-Clockwise"); //Second button
        Button button_ = new Button();
        button_.addActionListener(this);
        button_.setLabel("Origin-C.Clockwise"); //Third button
        Button button2 = new Button();
        button2.addActionListener(this);

        //Adding buttons
        panel.add(button_s);
        panel.add(button_b);
        panel.add(button_);


        //color of the panel
        panel.setBackground(Color.black);
        add(panel);
        setLayout(null); //setting layout
        setBackground(Color.getHSBColor(0.8f, 0.2f, 0.9f)); //setting background color

    }
    public class MyFinishWindow extends WindowAdapter //Adapter controls the exit operation
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    //Drawing square
    public void paint(Graphics g) {

        Graphics2D gd = (Graphics2D) g;//g2d object
        gd.setColor(Color.white);//white color for lines
        gd.drawLine(400, 0, 400, 800); //drawing lines
        gd.drawLine(0, 400, 800, 400);
        gd.setColor(Color.yellow);
        gd.fillPolygon(x, y, 4); //fill square
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String but = e.getActionCommand();
        if(but.equals("Set Default")) {  //Setting the initial locations for the square


            x[0]=500;
            x[1]=700;
            x[2]=700;
            x[3]=500;

            y[0]=300;
            y[1]=300;
            y[2]=200;
            y[3]=200;

            repaint();


        }
        else if(but.equals("Left Bottom-Clockwise")) { // First button

            Point2D.Float pointanchor = new Point2D.Float(x[3], y[3]);  // Turn around left buttom in clockwise

            Point2D.Float pointmy = new Point2D.Float(x[0], y[0]); // First coordinates
            Point2D tResult = rotateAroundPoint(pointmy,pointanchor, Math.PI/2); // rotate with coordinate around pointanchor in 90 degrees
            x[0] = (int) tResult.getX(); //assign new x point
            y[0] = (int) tResult.getY();//assign new y point

            pointmy= new Point2D.Float(x[1], y[1]); // third coordinates
            tResult = rotateAroundPoint(pointmy,pointanchor, Math.PI/2); // rotate with coordinate around pointanchor in 90 degrees
            x[1] = (int) tResult.getX();//assign new x point
            y[1] = (int) tResult.getY();//assign new y point

            pointmy= new Point2D.Float(x[2], y[2]); // third coordinates
            tResult = rotateAroundPoint(pointmy,pointanchor, Math.PI/2); // rotate with coordinate around pointanchor in 90 degrees
            x[2] = (int) tResult.getX();//assign new x point
            y[2] = (int) tResult.getY();//assign new y point


            repaint();
        }
        else if(but.equals("Origin-Clockwise")) {  //second button

            Point2D.Float pointanchor = new Point2D.Float(x[3], y[3]);

            Point2D.Float pointmy = new Point2D.Float(x[0], y[0]);
            Point2D tResult = rotateAroundPoint(pointmy,pointanchor, -Math.PI/2);// rotate with coordinate around pointanchor in -90 degrees for clockwise
            x[0] = (int) tResult.getX();
            y[0] = (int) tResult.getY();

            pointmy= new Point2D.Float(x[1], y[1]);
            tResult = rotateAroundPoint(pointmy,pointanchor, -Math.PI/2);// rotate with coordinate around pointanchor in -90 degrees for clockwise
            x[1] = (int) tResult.getX();
            y[1] = (int) tResult.getY();

            pointmy= new Point2D.Float(x[2], y[2]);
            tResult = rotateAroundPoint(pointmy,pointanchor, -Math.PI/2);// rotate with coordinate around pointanchor in -90 degrees for clockwise
            x[2] = (int) tResult.getX();
            y[2] = (int) tResult.getY();


            //reflection for origin
            y[0]=800-y[0];
            y[1]=800-y[1];
            y[2]=800-y[2];
            y[3]=800-y[3];



            repaint();
        }
        else if(but.equals("Origin-C.Clockwise")) { //third button


            Point2D.Float pointanchor = new Point2D.Float(x[3], y[3]);

            Point2D.Float pointmy = new Point2D.Float(x[0], y[0]);
            Point2D tResult = rotateAroundPoint(pointmy,pointanchor, Math.PI/2); // rotate with coordinate around pointanchor in 90 degrees for counter clockwise
            x[0] = (int) tResult.getX();
            y[0] = (int) tResult.getY();

            pointmy= new Point2D.Float(x[1], y[1]);
            tResult = rotateAroundPoint(pointmy,pointanchor, Math.PI/2);// rotate with coordinate around pointanchor in 90 degrees for counter clockwise
            x[1] = (int) tResult.getX();
            y[1] = (int) tResult.getY();

            pointmy= new Point2D.Float(x[2], y[2]);
            tResult = rotateAroundPoint(pointmy,pointanchor, Math.PI/2);// rotate with coordinate around pointanchor in 90 degrees for counter clockwise
            x[2] = (int) tResult.getX();
            y[2] = (int) tResult.getY();

            //reflection for origin
            x[0]=800-x[0];
            x[1]=800-x[1];
            x[2]=800-x[2];
            x[3]=800-x[3];



            repaint();
        }

    }
    protected Point2D rotateAroundPoint(Point2D point, Point2D ref, double angle) {  //rotatearoundpoint takes related point and the reference with the angle
        float x_1 = (float) (point.getX() - ref.getX());
        float y_1 = (float) (point.getY() - ref.getY());
        float x_rot = (float) (Math.cos(angle)*x_1 - Math.sin(angle)*y_1);
        float y_rot = (float) (Math.sin(angle)*x_1 + Math.cos(angle)*y_1);
        Point2D result = new Point2D.Float((float) ref.getX() + x_rot, (float) ref.getY() + y_rot);
        return result;
    }
    public static void main(String[] args) {
        Rotations lab6=new Rotations();  //instance of an object
        lab6.setSize(800, 800); // Set Frame s ize to 800x800)
        lab6.setVisible(true);// Make the vindow visible.

    }

}