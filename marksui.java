/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import net.proteanit.sql.DbUtils;

class marksui extends JFrame implements ActionListener {
    JButton btnentermks;
    JTextField marksenroll, markssem, markssession, marksdept;
    JLabel lblmksenroll, lblmkssem, lblmkssession, lblmksdept;
    Container c;
    JTable jTable;
    JLabel l, l1, l2, l3, l4, l11, l12, l13, l14;
    JButton btnadmin;
    JTextField tf11, tf21, tf31, tf41, tf12, tf22, tf32, tf42, tf13, tf23, tf33, tf43, tf14, tf24, tf34, tf44, tf15, tf25, tf35, tf45;

    marksui() {
        super("Enter Marks");

        c = getContentPane();
        c.setLayout(null);

//        lblenroll = new JLabel
        lblmksenroll = new JLabel("Enrollment No : ");
        lblmksenroll.setBounds(20, 50, 100, 30);
        c.add(lblmksenroll);
        marksenroll = new JTextField();
        marksenroll.setBounds(150, 50, 200, 30);
        c.add(marksenroll);
        lblmkssem = new JLabel("Semester No : ");
        lblmkssem.setBounds(20, 100, 100, 30);
        c.add(lblmkssem);
        markssem = new JTextField();
        markssem.setBounds(150, 100, 200, 30);
        c.add(markssem);

        lblmkssession = new JLabel("Session : ");
        lblmkssession.setBounds(20, 150, 100, 30);
        c.add(lblmkssession);
        markssession = new JTextField();
        markssession.setBounds(150, 150, 200, 30);
        c.add(markssession);

        lblmksdept = new JLabel("Department No : ");
        lblmksdept.setBounds(20, 200, 100, 30);
        c.add(lblmksdept);
        marksdept = new JTextField();
        marksdept.setBounds(150, 200, 200, 30);
        c.add(marksdept);

        btnentermks = new JButton("Enter Marks");
        btnentermks.setBounds(130, 250, 120, 40);
        c.add(btnentermks);
btnadmin = new JButton("Admin");
        btnadmin.setBounds(200,200,80,40);
        c.add(btnadmin);

//        String a;
//        int b;
//        int c;
//        int d;

String  a = marksenroll.getText();
           int b = Integer.parseInt(markssem.getText());
           int c = Integer.parseInt(markssession.getText());
           int d = Integer.parseInt(marksdept.getText());


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

        btnentermks.addActionListener(this);
//        btnadmin.addActionListener(this);

//        String aa;
//        int bb;
//        int cc;
//        int dd;
//    {
//        String aa = marksenroll.getText();
//        int bb = Integer.parseInt(markssem.getText());
//        int cc = Integer.parseInt(markssession.getText());
//        int dd = Integer.parseInt(marksdept.getText());
    }
//    public String getvalues(){
//        String aa = marksenroll.getText();
//        int bb = Integer.parseInt(markssem.getText());
//        int cc = Integer.parseInt(markssession.getText());
//        int dd = Integer.parseInt(marksdept.getText());
//        return aa;
//    }

ArrayList<marksLogic> getsubjects() {
        ArrayList<marksLogic> marksData = new ArrayList<>();
        try {
            String enroll = marksenroll.getText();
            int semester = Integer.parseInt(markssem.getText());
            int session = Integer.parseInt(markssession.getText());
            int dept = Integer.parseInt(marksdept.getText());
            Statement stmt = main.con.createStatement();
            ResultSet rs = stmt.executeQuery("select subcode,marksth,markspr,marksmt,totalmarks from marks where enrnum = '" + enroll + "'AND subcode IN (select subid from subject where semster =" + semester + "AND sessyear =" + session + "AND deptnum =" + dept + ") ");
            marksLogic markslogicob;
            while (rs.next()) {
                String subcode = rs.getString(1);
                int marksth = rs.getInt(2);
                int markspr = rs.getInt(3);
                int marksmt = rs.getInt(4);
                int totalmarks = rs.getInt(5);
                markslogicob = new marksLogic(subcode, marksth, markspr, marksmt, totalmarks);
                marksData.add(markslogicob);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return marksData;
    }

    JTable getTable(){
        Vector<Object> columnData = new Vector<>();
        columnData.add("Subject Code");
        columnData.add("Marks TH");
        columnData.add("Marks PR");
        columnData.add("Marks MT");
        columnData.add("Marks Total");
        Vector<Vector<Object>> data = new Vector<>();
        ArrayList<marksLogic> list = getsubjects();
        for (marksLogic markslogicob : list) {
            Vector<Object> row = new Vector<>();
            row.add(markslogicob.getSubjectcode());
            row.add(markslogicob.getMarksinth());
            row.add(markslogicob.getMarksinpr());
            row.add(markslogicob.getMarksinmt());
            row.add(markslogicob.getTotalofmarks());
            data.add(row);
        }
        jTable = new JTable(data,columnData);
        return jTable;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnentermks) {
//            String aa = marksenroll.getText();
//            int bb = Integer.parseInt(markssem.getText());
//            int cc = Integer.parseInt(markssession.getText());
//            int dd = Integer.parseInt(marksdept.getText());
            entermarks frame = new entermarks();
            frame.setBounds(500, 300, 300, 100);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            String aa = marksenroll.getText();
            int bb = Integer.parseInt(markssem.getText());
            int cc = Integer.parseInt(markssession.getText());
            int dd = Integer.parseInt(marksdept.getText());

//            String aa,int bb,int cc, int dd)
//            {
//            }

ResultSet rs = null;
            int count = 0;
            String enroll = marksenroll.getText();
            int semester = Integer.parseInt(markssem.getText());
            int session = Integer.parseInt(markssession.getText());
            int dept = Integer.parseInt(marksdept.getText());
            try {
                Statement stmt = main.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery("select subcode,marksth,markspr,marksmt,totalmarks from marks where enrnum = '" + enroll + "'AND subcode IN (select subid from subject where semster =" + semester + "AND sessyear =" + session + "AND deptnum =" + dept + ") ");

//                sessyear ="+session+" deptnum="+dept+"
//                JOptionPane.showMessageDialog(null,"Data inserted Successfully");
 rs.last();
                  count = rs.getRow();
                  rs.beforeFirst();


//                System.out.println(count);
//                 outer:
//                while(rs.next()) {
                switch (count){
                    case 3:
                    rs.next();
//                    if (count != 0) {
//                        count--;
                        l1 = new JLabel();
                        l1.setBounds(20, 110, 200, 20);
                        l1.setText("Code: " + rs.getString(1));
                        tf11.setBounds(160, 110, 30, 20);
                        tf21.setBounds(220, 110, 30, 20);
                        tf31.setBounds(280, 110, 30, 20);
                        tf41.setBounds(340, 110, 30, 20);
                        tf11.setText("" + rs.getString(2));
                        tf21.setText("" + rs.getString(3));
                        tf31.setText("" + rs.getString(4));
                        tf41.setText("" + rs.getString(5));
//                    try {
//                        Statement stmt1 = main.con.createStatement();
////                    stmt1.executeUpdate("insert into marks(marksth,markspr,marksmt,totalmarks) values("+tf11.getText()+","+tf21.getText()+","+tf31.getText()+","+tf41.getText()+")" + "where enrnum = '"+enroll+"'AND sem = "+semester+" AND subcode = '"+rs.getString(1)+"' ");
//                        stmt1.executeUpdate("update marks set marksth = " + tf11.getText() + ",markspr = " + tf21.getText() + ", marksmt = " + tf31.getText() + ",totalmarks = " + tf41.getText() + " where enrnum = '" + enroll + "'AND sem = " + semester + " AND subcode = '" + rs.getString(1) + "' ");
//                        JOptionPane.showMessageDialog(null, "Marks inserted Successfully");
//                    } catch (SQLException e1) {
//                        e1.printStackTrace();
//                    }
//                    }

//                    if (count == 1) {
//                        count--;
                        rs.next();
                        l2 = new JLabel();
                        l2.setBounds(20, 140, 200, 20);
                        l2.setText("Code: " + rs.getString(1));
                        tf12.setBounds(160, 140, 30, 20);
                        tf22.setBounds(220, 140, 30, 20);
                        tf32.setBounds(280, 140, 30, 20);
                        tf42.setBounds(340, 140, 30, 20);
                        tf12.setText("" + rs.getString(2));
                        tf22.setText("" + rs.getString(3));
                        tf32.setText("" + rs.getString(4));
                        tf42.setText("" + rs.getString(5));

                    rs.next();
                    l3 = new JLabel();
                    l3.setBounds(20, 170, 200, 20);
                    l3.setText("Code: " + rs.getString(1));
                        tf13.setBounds(160, 170, 30, 20);
                        tf23.setBounds(220, 170, 30, 20);
                        tf33.setBounds(280, 170, 30, 20);
                        tf43.setBounds(340, 170, 30, 20);
                    tf13.setText("" + rs.getString(2));
                    tf23.setText("" + rs.getString(3));
                    tf33.setText("" + rs.getString(4));
                    tf43.setText("" + rs.getString(5));
//                    break;
                        if (e.getSource() == btnadmin) {
                            try {
                                Statement stmt1 = main.con.createStatement();
                                stmt1.executeUpdate("update marks set marksth = " + tf11.getText() + ",markspr = " + tf21.getText() + ", marksmt = " + tf31.getText() + ",totalmarks = " + tf41.getText() + " where enrnum = '" + enroll + "'AND sem = " + semester + " AND subcode = '" + rs.getString(1) + "' ");
                                JOptionPane.showMessageDialog(null, "Marks inserted Successfully");
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
//                        rs.beforeFirst();
//                        break;
//                        continue outer;
//                    }
//                rs.next();
//                    if (count != 0) {
//                       return;
//                        break;
//                        count--;
//                        rs.next();
//                        l3 = new JLabel();
//                        l3.setText("Code");
//                    } else {
//                        break;
//                        l4 = new JLabel();
//                        l4.setText("Code:");
//                    }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + count);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
//                throw;
            }
                JFrame f1 = new JFrame();
                f1.setVisible(true);
                f1.setSize(500, 500);
                f1.setLayout(null);
                f1.setTitle("JDBC DEMO");
            btnadmin = new JButton("Input");
            btnadmin.setBounds(200,300,80,40);
            f1.add(btnadmin);
            btnadmin.addActionListener(this);
                l11 = new JLabel("THEORY");
                l12 = new JLabel("PRAC");
                l13 = new JLabel("MID");
                l14 = new JLabel("TOTAL");

//                l2.setBounds(20, 140, 200, 20);
//                l1.setBounds(20, 110, 200, 20);
//                l3.setBounds(20, 170, 200, 20);
//                l4.setBounds(20, 200, 200, 20);

                l11.setBounds(160, 90, 200, 20);
                l12.setBounds(220, 90, 200, 20);
                l13.setBounds(280, 90, 200, 20);
                l14.setBounds(340, 90, 200, 20);

//                tf11.setBounds(160, 110, 30, 20);
//                tf21.setBounds(220, 110, 30, 20);
//                tf31.setBounds(280, 110, 30, 20);
//                tf41.setBounds(340, 110, 30, 20);

//                tf12.setBounds(160, 140, 30, 20);
//                tf22.setBounds(220, 140, 30, 20);
//                tf32.setBounds(280, 140, 30, 20);
//                tf42.setBounds(340, 140, 30, 20);


 tf13.setBounds(160, 170, 30, 20);
                tf23.setBounds(220, 170, 30, 20);
                tf33.setBounds(280, 170, 30, 20);
                tf43.setBounds(340, 170, 30, 20);

                tf14.setBounds(160, 200, 30, 20);
                tf24.setBounds(220, 200, 30, 20);
                tf34.setBounds(280, 200, 30, 20);
                tf44.setBounds(340, 200, 30, 20);

                tf15.setBounds(160, 230, 30, 20);
                tf25.setBounds(220, 230, 30, 20);
                tf35.setBounds(280, 230, 30, 20);
                tf45.setBounds(340, 230, 30, 20);

                f1.add(l1);
                f1.add(l2);
                f1.add(l3);
//                f1.add(l4);
                f1.add(l11);
                f1.add(l12);
                f1.add(l13);
                f1.add(l14);
                f1.add(tf11);
                f1.add(tf21);
                f1.add(tf31);
                f1.add(tf41);

                f1.add(tf12);
                f1.add(tf22);
                f1.add(tf32);
                f1.add(tf42);

                f1.add(tf13);
                f1.add(tf23);
                f1.add(tf33);
                f1.add(tf43);

                f1.add(tf14);
                f1.add(tf24);
                f1.add(tf34);
                f1.add(tf44);

                f1.add(tf15);
                f1.add(tf25);
                f1.add(tf35);
                f1.add(tf45);
            }
        }

        }
    }
}
//}
*/
