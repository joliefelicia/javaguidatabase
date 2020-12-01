import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;



class EmployeeEditPanel extends JPanel {

    static JTextField id = new JTextField();
    static JTextField fullname = new JTextField();
   static  JTextField salary = new JTextField();
    static String[] g = {"male", "female"};
    static JComboBox gender = new JComboBox(g);
    static String[] p = {
            "Director",
            "Operation Manager",
            "Finance Manager",
            "Staff"
    };
    static JComboBox position = new JComboBox(p);




    EmployeeEditPanel() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID: "));
        add(id);


        add(new JLabel("fullname: "));
        add(fullname);


        add(new JLabel("gender: "));
        add(gender);

        add(new JLabel("Position: "));
        add(position);

        add(new JLabel("salary: "));
        add(salary);

        //border
        Border etc = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder title = BorderFactory.createTitledBorder(etc, "employee record editor ");
        title.setTitleFont(title.getTitleFont().deriveFont(Font.BOLD));


        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), title));
    }
    static class buttonadd implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "insert into employees(id,fullname,gender,position,salary) values(?,?,?,?,?)";
                Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "javagui", "javagui");
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,id.getText());
                ps.setString(2,fullname.getText());
                ps.setString(3, String.valueOf(gender.getSelectedItem()));
                ps.setString(4, String.valueOf(position.getSelectedItem()));
                ps.setInt(5, Integer.parseInt(salary.getText()));
                ps.executeUpdate();
                DataPanel.melihatdata();




                JOptionPane.showMessageDialog(null,"Data berhasil ditambah");



            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Data gagal ditambah");
            }
            formdikosongin();

        }

        private void formdikosongin(){
            id.setText("");
            fullname.setText("");
            salary.setText("");

        }

    }

    static class buttonupdate implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "update employees set fullname=?,gender=?,position=?,salary=? where id=? ";
                Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "javagui", "javagui");
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,fullname.getText());
                ps.setString(2, String.valueOf(gender.getSelectedItem()));
                ps.setString(3, String.valueOf(position.getSelectedItem()));
                ps.setInt(4, Integer.parseInt(salary.getText()));
                ps.setString(5,id.getText());
                ps.executeUpdate();
                DataPanel.melihatdata();
                JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
                formdikosongin();



            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Data gagal diupdate");
            }




        }
        private void formdikosongin(){
            id.setText("");
            fullname.setText("");
            salary.setText("");
        }

    }

    static class buttondelete implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "delete from employees where id=?";
                Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "javagui", "javagui");
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,id.getText());
                ps.executeUpdate();
                DataPanel.melihatdata();
                JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
                formdikosongin();



            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Data gagal dihapus");
            }
        }
        private void formdikosongin(){
            id.setText("");

        }

    }




}










