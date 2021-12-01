//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Vector;
//public class entermarks extends JFrame implements ActionListener {
//    JLabel l, l1, l2, l3, l4, l11, l12, l13, l14;
//    JButton btnadmin;
//    JTextField tf11, tf21, tf31, tf41, tf12, tf22, tf32, tf42, tf13, tf23, tf33, tf43, tf14, tf24, tf34, tf44, tf15, tf25, tf35, tf45;
//    JTable jtable;
//
//    entermarks() {
////        setVisible(true);
////        setSize(700, 700);
////        setLayout(null);
////        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        setTitle("Student Marks");
//        btnadmin = new JButton("Submit");
//        btnadmin.setBounds(50, 500, 150, 30);
//        add(btnadmin);
//        tf11 = new JTextField();
//        tf21 = new JTextField();
//        tf31 = new JTextField();
//        tf41 = new JTextField();
//
//        tf12 = new JTextField();
//        tf22 = new JTextField();
//        tf32 = new JTextField();
//        tf42 = new JTextField();
//        tf13 = new JTextField();
//        tf23 = new JTextField();
//        tf33 = new JTextField();
//        tf43 = new JTextField();
//
//        tf14 = new JTextField();
//        tf24 = new JTextField();
//        tf34 = new JTextField();
//        tf44 = new JTextField();
//
//        tf15 = new JTextField();
//        tf25 = new JTextField();
//        tf35 = new JTextField();
//        tf45 = new JTextField();
//
//
//        tf11.setEditable(true);
//        tf21.setEditable(true);
//        tf31.setEditable(true);
//        tf41.setEditable(true);
//        tf12.setEditable(true);
//        tf22.setEditable(true);
//        tf32.setEditable(true);
//        tf42.setEditable(true);
//
//        tf13.setEditable(true);
//        tf23.setEditable(true);
//        tf33.setEditable(true);
//        tf43.setEditable(true);
//
//        tf14.setEditable(true);
//        tf24.setEditable(true);
//        tf34.setEditable(true);
//        tf44.setEditable(true);
//
//        tf15.setEditable(true);
//        tf25.setEditable(true);
//        tf35.setEditable(true);
//        tf45.setEditable(true);
//
//        btnadmin.addActionListener(this);
//        marksui obj = new marksui();
////        String enr= null;
////        int seme = 0;
////        int sess = 0;
////        int depart = 0;
////        int to;
////        obj.getvalues(enr,seme,sess,depart);
//        System.out.println(obj.actionPerformed);
//    }
////    marksui scode = new marksui();
////    ArrayList<marksLogic> scodelist= scode.getsubjects();
//
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource()==btnadmin)
//        {
//            /*marksui scode = new marksui();
//            ArrayList<marksLogic> scodelist= scode.getsubjects();*/
//        }
//
//    }
//}
//
////    public void showData() {
////
////        JFrame f1 = new JFrame();
////        f1.setVisible(true);
////        f1.setSize(500, 500);
////        f1.setLayout(null);
////        f1.setTitle("JDBC DEMO");
////
////
////        l5 = new JLabel("Displaying Emp Data:");
////        l5.setForeground(Color.red);
////        l5.setFont(new Font("Serif", Font.BOLD, 20));
////
////        l1 = new JLabel();
////        l1.setText("Code "+ rs.get);
////        l2 = new JLabel("Emp Email:");
////        l3 = new JLabel("Emp pass:");
////        l4 = new JLabel("Emp Country:");
////
////        l5.setBounds(100, 50, 300, 30);
////        l1.setBounds(20, 110, 200, 20);
////        l2.setBounds(20, 140, 200, 20);
////        l3.setBounds(20, 170, 200, 20);
////        l4.setBounds(20, 200, 200, 20);
////        tf1.setBounds(240, 110, 200, 20);
////        tf2.setBounds(240, 140, 200, 20);
////        tf3.setBounds(240, 170, 200, 20);
////        tf4.setBounds(240, 200, 200, 20);
////
////        f1.add(l5);
////        f1.add(l1);
////        f1.add(tf1);
////        f1.add(l2);
////        f1.add(tf2);
////        f1.add(l3);
////        f1.add(tf3);
////        f1.add(l4);
////        f1.add(tf4);
////
////    }
////    }
