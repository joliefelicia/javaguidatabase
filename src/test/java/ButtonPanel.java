import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ButtonPanel extends JPanel {

    JButton updatebutton= new JButton("update");
    JButton addbutton=new JButton("add");
    JButton deletebutton=new JButton("delete");
    JButton closebutton=new JButton("close");

ButtonPanel(){
    setLayout(new GridLayout(1,4));
    add(updatebutton);
    add(addbutton);
    add(deletebutton);
    add(closebutton);
    addbutton.addActionListener(new EmployeeEditPanel.buttonadd());
    updatebutton.addActionListener(new EmployeeEditPanel.buttonupdate());
    deletebutton.addActionListener(new EmployeeEditPanel.buttondelete());
    closebutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });



}


}


