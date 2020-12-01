import javax.swing.*;

public class Exercise extends  JFrame{

    public Exercise(){
        setTitle("Exercise");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        add(new DataPanel());
        add(new EmployeeEditPanel());
        add(new ButtonPanel());

        setVisible(true);

    }






}
