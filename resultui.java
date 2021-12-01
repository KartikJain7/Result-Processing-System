import javax.imageio.ImageIO;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class resultui extends JFrame implements ActionListener {
    private JLabel lblenroll;
    private JLabel lblname;
    private JLabel lblfname;
    private JLabel lbldept;
    private JLabel lbladmses;
    private JLabel lblclass;
    private JLabel lblcursem;
    private JLabel lblcursess;
    private JLabel lblsgpa;
    private JLabel lblogpa;
    private JLabel lbltotal;
    private JLabel lblmpuat;
    private JLabel lblctae;
    private JLabel lblreport;
    private JLabel lblfinalcr;
    private JLabel lblfinalcp;
    private JTextField txtfinalcr;
    private JTextField txtfinalcp;
    private JTextField txtenroll;
    private JTextField txtname;
    private JTextField txtfname;
    private JTextField txtdept;
    private JTextField txtadmses;
    private JTextField txtclass;
    private JTextField txtcursem;
    private JTextField txtcursess;
    private JTextField txtsgpa;
    private JTextField txtogpa;
    private JTextField txttotalcr;
    private JTextField txttotalcp;
    private JTextField txtfinalcr1;
    private JTextField txtfinalcp1;
    private JTable jtablesub;
    private JTable jtablelist;
    private JButton sublist;
    private ImageIcon mpuat;
    private JLabel image;

    Container c;

    public resultui(String a, int b, int cc) {
        super("Marksheet");
        c = getContentPane();
        c.setLayout(null);

        jtablesub = new JTable();
        jtablesub.setBounds(40, 350, 700, 152);
        JScrollPane sp = new JScrollPane(jtablesub);
        sp.setOpaque( false );
        jtablesub.setOpaque(false);
        sp.getViewport().setOpaque( false );
        c.add(jtablesub);

        JScrollPane scrollPane = new JScrollPane(jtablesub);
        scrollPane.setBounds(40, 350, 700, 151);
        getContentPane().add(scrollPane);

        mpuat = new ImageIcon("C:\\Users\\KARTIK\\Desktop\\Webp.net-resizeimage.png");
        image = new JLabel(mpuat);
        image.setBounds(10,10,100,100);
        c.add(image);

//        *******************
        lblmpuat = new JLabel("MAHARANA PRATAP UNIVERSITY OF AGRICULTURE AND TECHNOLOGY");
        lblmpuat.setBounds(130, 10, 650, 30);
        c.add(lblmpuat);
        lblmpuat.setFont(new Font("Hersheys", Font.BOLD, 18));
        lblmpuat.setForeground(Color.red);

        lblctae = new JLabel("COLLEGE OF TECHNOLOGY AND ENGINEERING");
        lblctae.setBounds(240, 40, 600, 30);
        c.add(lblctae);
        lblctae.setFont(new Font("Hersheys", Font.CENTER_BASELINE, 16));
        lblctae.setForeground(Color.red);

        lblctae = new JLabel("Studunt Grade Report");
        lblctae.setBounds(350, 70, 600, 30);
        c.add(lblctae);
        lblctae.setFont(new Font("Hersheys", Font.BOLD, 14));
        lblctae.setForeground(Color.red);

        lblenroll = new JLabel("Enrollment No : ");
        lblenroll.setBounds(90, 130, 100, 30);
        c.add(lblenroll);
        txtenroll = new JTextField();
        txtenroll.setBounds(200, 130, 100, 30);
        c.add(txtenroll);
//        txtenroll.setEditable(false);

        lblname = new JLabel("Name : ");
        lblname.setBounds(90, 180, 100, 30);
        c.add(lblname);
        txtname = new JTextField();
        txtname.setBounds(200, 180, 100, 30);
        c.add(txtname);
//        txtname.setEditable(false);

        lblfname = new JLabel("Father's Name : ");
        lblfname.setBounds(90, 230, 100, 30);
        c.add(lblfname);
        txtfname = new JTextField();
        txtfname.setBounds(200, 230, 100, 30);
        c.add(txtfname);
//        txtfname.setEditable(false);

        lbldept = new JLabel("Branch : ");
        lbldept.setBounds(90, 280, 100, 30);
        c.add(lbldept);
        txtdept = new JTextField();
        txtdept.setBounds(200, 280, 100, 30);
        c.add(txtdept);
//        txtdept.setEditable(false);

        lblclass = new JLabel("Class : ");
        lblclass.setBounds(500, 130, 100, 30);
        c.add(lblclass);
        txtclass = new JTextField();
        txtclass.setBounds(610, 130, 100, 30);
        c.add(txtclass);
//        txtclass.setEditable(false);

        lbladmses = new JLabel("Adm Session : ");
        lbladmses.setBounds(500, 180, 100, 30);
        c.add(lbladmses);
        txtadmses = new JTextField();
        txtadmses.setBounds(610, 180, 100, 30);
        c.add(txtadmses);
//        txtadmses.setEditable(false);

        lblcursem = new JLabel("Semester : ");
        lblcursem.setBounds(500, 230, 100, 30);
        c.add(lblcursem);
        txtcursem = new JTextField();
        txtcursem.setBounds(610, 230, 100, 30);
        c.add(txtcursem);
//        txtcursem.setEditable(false);

        lblcursess = new JLabel("Session : ");
        lblcursess.setBounds(500, 280, 100, 30);
        c.add(lblcursess);
        txtcursess = new JTextField();
        txtcursess.setBounds(610, 280, 100, 30);
        c.add(txtcursess);

        lbltotal = new JLabel("Total : ");
        lbltotal.setBounds(40, 510, 50, 30);
        c.add(lbltotal);
        lbltotal.setForeground(Color.red);

        txttotalcr = new JTextField();
        txttotalcr.setBounds(290, 510, 50, 30);
        c.add(txttotalcr);

        txttotalcp = new JTextField();
        txttotalcp.setBounds(675, 510, 50, 30);
        c.add(txttotalcp);

//        lbltotal = new JLabel("");
//        lbltotal.setBounds(150, 530, 50, 30);
//        c.add(lbltotal);
//        lbltotal.setForeground(Color.red);

        lblsgpa = new JLabel("SGPA : ");
        lblsgpa.setBounds(20, 640, 50, 30);
        c.add(lblsgpa);
        lblsgpa.setFont(new Font("Hersheys", Font.BOLD, 12));
        lblsgpa.setForeground(Color.red);
        txtsgpa = new JTextField();
        txtsgpa.setBounds(80, 640, 50, 30);
        c.add(txtsgpa);

        lblogpa = new JLabel("OGPA : ");
        lblogpa.setBounds(140, 640, 50, 30);
        c.add(lblogpa);
        lblogpa.setFont(new Font("Hersheys", Font.BOLD, 12));
        lblogpa.setForeground(Color.red);
        txtogpa = new JTextField();
        txtogpa.setBounds(200, 640, 50, 30);
        c.add(txtogpa);

        lblfinalcr = new JLabel("Total of Previous Semester : ");
        lblfinalcr.setBounds(20, 560, 200, 30);
        c.add(lblfinalcr);
        txtfinalcr = new JTextField();
        txtfinalcr.setBounds(290, 560, 50, 30);
        c.add(txtfinalcr);

        lblfinalcp = new JLabel("Total Including current Semester : ");
        lblfinalcp.setBounds(20, 600, 200, 30);
        c.add(lblfinalcp);
        txtfinalcp = new JTextField();
        txtfinalcp.setBounds(290, 600, 50, 30);
        c.add(txtfinalcp);

        txtfinalcr1 = new JTextField();
        txtfinalcr1.setBounds(675, 560, 50, 30);
        c.add(txtfinalcr1);

        txtfinalcp1 = new JTextField();
        txtfinalcp1.setBounds(675, 600, 50, 30);
        c.add(txtfinalcp1);

        sublist = new JButton("Subject List");
        sublist.setBounds(650, 650, 120, 40);
//        c.add(sublist);

        sublist.addActionListener(this);

        String enr = a;
        int sem = b;
        int sess = cc;

//        System.out.println(a+" "+b+" "+cc);

        txtenroll.setText(a);
        txtenroll.setEditable(false);
        txtcursem.setText(Integer.toString(b));
        txtcursem.setEditable(false);
        txtadmses.setText(Integer.toString(cc));
        txtadmses.setEditable(false);

        ResultSet rs;
        try {
            Statement stmt1 = main.con.createStatement();
            rs = stmt1.executeQuery("select name from student where enroll_no = '" + txtenroll.getText() + "' ");
            rs.next();
            String name = rs.getString(1);
            txtname.setText(name);
            txtname.setEditable(false);

            rs = stmt1.executeQuery("select fname from student where enroll_no = '" + txtenroll.getText() + "' ");
            rs.next();
            String fname = rs.getString(1);
            txtfname.setText(fname);
            txtfname.setEditable(false);

            rs = stmt1.executeQuery("select deptno from student where enroll_no = '" + txtenroll.getText() + "'");
            rs.next();
            int dept = rs.getInt(1);
            rs = stmt1.executeQuery("select dname from department where dno = " + dept + "");
            rs.next();
            String dname = rs.getString(1);
            txtdept.setText(dname);
//            rs.next();
            txtdept.setEditable(false);
            rs = stmt1.executeQuery("select subcode,subname,crtheo,crprac,marksth,markspr,marksmt,totalmarks,gradept,subcr from marks where enrnum = '" + txtenroll.getText() + "' AND sem=" + txtcursem.getText() + " ");
            jtablesub.setModel(DbUtils.resultSetToTableModel(rs));

            rs = stmt1.executeQuery("select sgpa from result where ennum = '" + txtenroll.getText() + "' AND resem = " + txtcursem.getText() + "  ");
            rs.next();
            Float sg = rs.getFloat(1);
            txtsgpa.setText(Float.toString(sg));
            txtsgpa.setEditable(false);

            rs = stmt1.executeQuery("select ogpa from result where ennum = '" + txtenroll.getText() + "' AND resem = " + txtcursem.getText() + "  ");
            rs.next();
            Float og = rs.getFloat(1);
            txtogpa.setText(Float.toString(og));
            txtogpa.setEditable(false);

            if (Integer.parseInt(txtcursem.getText()) == 1 || Integer.parseInt(txtcursem.getText()) == 2) {
                txtclass.setText("FIRST YEAR");
                txtclass.setEditable(false);
            } else if (Integer.parseInt(txtcursem.getText()) == 3 || Integer.parseInt(txtcursem.getText()) == 4) {
                txtclass.setText("SECOND YEAR");
                txtclass.setEditable(false);
            }
            else if (Integer.parseInt(txtcursem.getText()) == 5 || Integer.parseInt(txtcursem.getText()) == 6) {
                txtclass.setText("Third YEAR");
                txtclass.setEditable(false);
            }
            else if (Integer.parseInt(txtcursem.getText()) == 7 || Integer.parseInt(txtcursem.getText()) == 8) {
                txtclass.setText("FINAL YEAR");
                txtclass.setEditable(false);
            }
            if (Integer.parseInt(txtcursem.getText()) == 1 && txtadmses.getText().equals("2018")|| Integer.parseInt(txtcursem.getText()) == 2 && txtadmses.getText().equals("2018")) {
                txtcursess.setText("2018-19");
                txtcursess.setEditable(false);
            } else if (Integer.parseInt(txtcursem.getText()) == 3 && txtadmses.getText().equals("2018") || Integer.parseInt(txtcursem.getText()) == 4 && txtadmses.getText().equals("2018")) {
                txtcursess.setText("2019-20");
                txtcursess.setEditable(false);
            }
            else if (Integer.parseInt(txtcursem.getText()) == 5 && txtadmses.getText().equals("2018") || Integer.parseInt(txtcursem.getText()) == 6 && txtadmses.getText().equals("2018")) {
                txtcursess.setText("2020-21");
                txtcursess.setEditable(false);
            }
            else if (Integer.parseInt(txtcursem.getText()) == 7 && txtadmses.getText().equals("2018") || Integer.parseInt(txtcursem.getText()) == 8 && txtadmses.getText().equals("2018")) {
                txtcursess.setText("2021-22");
                txtcursess.setEditable(false);
            }
            if (Integer.parseInt(txtcursem.getText()) == 1 && txtadmses.getText().equals("2019") || Integer.parseInt(txtcursem.getText()) == 2 && txtadmses.getText().equals("2019")) {
                txtcursess.setText("2019-20");
                txtcursess.setEditable(false);
            } else if (Integer.parseInt(txtcursem.getText()) == 3 && txtadmses.getText().equals("2019") || Integer.parseInt(txtcursem.getText()) == 4 && txtadmses.getText().equals("2019")) {
                txtcursess.setText("2020-21");
                txtcursess.setEditable(false);
            }
            else if (Integer.parseInt(txtcursem.getText()) == 5 &&txtadmses.getText().equals("2019")|| Integer.parseInt(txtcursem.getText()) == 6 && txtadmses.getText().equals("2019")) {
                txtcursess.setText("2021-22");
                txtcursess.setEditable(false);
            }else if (Integer.parseInt(txtcursem.getText()) == 7 &&txtadmses.getText().equals("2019")|| Integer.parseInt(txtcursem.getText()) == 8 && txtadmses.getText().equals("2019")) {
                txtcursess.setText("2022-23");
                txtcursess.setEditable(false);
            }

            //String[] columnName = {"Course No., Credit Hr, Marks Th, Marks Pr, Marks MT, Marks Total,Credit Points"};
            JTableHeader HEADER = jtablesub.getTableHeader();
            TableColumnModel TMC = HEADER.getColumnModel();
            TableColumn TC = TMC.getColumn(0);
            TC.setHeaderValue("Course No");
            TC.setPreferredWidth(90);
            TableColumn TC8 = TMC.getColumn(1);
            TC8.setHeaderValue("Subject Name");
            TC8.setPreferredWidth(170);
            TableColumn TC9 = TMC.getColumn(2);
            TC9.setHeaderValue("Cr TH");
            TC9.setPreferredWidth(50);
            TableColumn TC1 = TMC.getColumn(3);
            TC1.setHeaderValue("Cr PR");
            TC1.setPreferredWidth(50);
            TableColumn TC2 = TMC.getColumn(4);
            TC2.setHeaderValue("Marks Th");
            TC2.setPreferredWidth(65);
            TableColumn TC3 = TMC.getColumn(5);
            TC3.setHeaderValue("Marks Pr");
            TC3.setPreferredWidth(65);
            TableColumn TC4 = TMC.getColumn(6);
            TC4.setHeaderValue("Marks MT");
            TC4.setPreferredWidth(65);
            TableColumn TC5 = TMC.getColumn(7);
            TC5.setHeaderValue("Marks Total ");
            TableColumn TC6 = TMC.getColumn(8);
            TC6.setHeaderValue("Grade Point");
            TableColumn TC7 = TMC.getColumn(9);
            TC7.setHeaderValue("Credit Points");
            HEADER.repaint();
            jtablesub.getTableHeader().repaint();

                    Float total = 0.0f;
                    for (int i = 0; i < jtablesub.getRowCount(); i++){
                        Float amount = Float.parseFloat(jtablesub.getValueAt(i, 2)+"");
                        total += amount;
                    }
            for (int i = 0; i < jtablesub.getRowCount(); i++){
                Float amount = Float.parseFloat(jtablesub.getValueAt(i, 3)+"");
                total += amount;
            }
//                    System.out.println(total);
                    txttotalcr.setText(Float.toString(total));
                    txttotalcr.setEditable(false);

            Float total1 = 0.0f;
            for (int i = 0; i < jtablesub.getRowCount(); i++){
                Float amount = Float.parseFloat(jtablesub.getValueAt(i, 9)+"");
                total1 += amount;
            }
//                    System.out.println(total);
//            String cp = Float.toString(total1);
            String strDouble = String.format("%.1f", total1);
            txttotalcp.setText(strDouble);
            txttotalcp.setEditable(false);

            rs = stmt1.executeQuery("select SUM(totalcredit) , SUM(subcr) from marks where enrnum = '"+txtenroll.getText()+"'AND sem < "+Integer.parseInt(txtcursem.getText())+" ");
            rs.next();
            int crhr = rs.getInt(1);
            txtfinalcr.setText(Integer.toString(crhr));
            txtfinalcr.setEditable(false);
            Float cr1 = rs.getFloat(2);
            txtfinalcr1.setText(Float.toString(cr1));
            txtfinalcr1.setEditable(false);

            rs = stmt1.executeQuery("select SUM(totalcredit),SUM(subcr) from marks where enrnum = '"+txtenroll.getText()+"'AND sem <= "+Integer.parseInt(txtcursem.getText())+" ");
            rs.next();
            Float cp = rs.getFloat(1);
            txtfinalcp.setText(Float.toString(cp));
            txtfinalcp.setEditable(false);
            Float cp1 = rs.getFloat(2);
            txtfinalcp1.setText(Float.toString(cp1));
            txtfinalcp1.setEditable(false);

        } catch (
                SQLException e1) {
            e1.printStackTrace();
        }
        jtablesub.setDefaultEditor(Object.class, null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sublist){
            ResultSet rs2;
            JFrame frame= new JFrame();
            frame.setBounds(50,200,300,250);
//            Dimension preferred = frame.getPreferredSize();
//            frame.setPreferredSize(new Dimension(300, 250));
//            frame.pack();
//            frame.setPreferredSize(preferred);
            frame.setVisible(true);
            JTable jTable = new JTable();
            jTable.setSize(200,150);
//            jTable.setLocation(200,200);
            jTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jTable.setGridColor(Color.BLACK);
            jTable.setVisible(true);
            c.add("Center",jTable);
            frame.add(jTable);
            try{
                Statement stmt1 = main.con.createStatement();
                rs2 = stmt1.executeQuery("select subid,subname from subject where semster = "+txtcursem.getText()+" AND sessyear = "+Integer.parseInt(txtadmses.getText())+"");
                jTable.setModel(DbUtils.resultSetToTableModel(rs2));
            }
            catch(SQLException e1) {
                e1.printStackTrace();
            }

        }
    }
}
