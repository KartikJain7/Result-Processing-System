import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MarksCRUDform extends JFrame implements ActionListener {
//    private JPanel Main;
    private JButton btnsearch;
    private JLabel lblenroll;
    private JLabel lblsession;
    private JLabel lblsemester;
    private JLabel lbldept;
    private JTextField txtenroll;
    private JTextField txtsession;
    private JTextField txtsemester;
    private JTextField txtdept;
    private JTable jtablesub;
    private JTextField txtscode;
    private JTextField txtth;
    private JTextField txtprac;
    private JTextField txtmt;
    private JTextField txttotal;
    private JLabel finalmsg;
    private JButton insertMarks;
    private JLabel lblscode;
    private JLabel lblth;
    private JLabel lblprac;
    private JLabel lblmt;
    private JLabel lbltotal;
    private JButton btnreset;
    private JButton btnresultcal;
    private JButton btnogpa;
    private JButton btnsub;

    Container c;

    public MarksCRUDform() {
//        tableload();
//        btnsearch.addActionListener(new ActionListener() {
        super("Enter Marks");
        c = getContentPane();
        c.setLayout(null);

        jtablesub = new JTable();
        jtablesub.setBounds(350, 40, 500, 300);
        JScrollPane sp = new JScrollPane(jtablesub);
        c.add(jtablesub);

//        add(new JScrollPane(jtablesub));

        JScrollPane scrollPane = new JScrollPane(jtablesub);
        scrollPane.setBounds(350, 40, 500, 300);
        getContentPane().add(scrollPane);


        lblenroll = new JLabel("Enrollment No : ");
        lblenroll.setBounds(20, 50, 100, 30);
        c.add(lblenroll);
        txtenroll = new JTextField();
        txtenroll.setBounds(150, 50, 150, 30);
        c.add(txtenroll);
        lblsession = new JLabel("Adm Year : ");
        lblsession.setBounds(20, 100, 70, 30);
        c.add(lblsession);
        txtsession = new JTextField();
        txtsession.setBounds(150, 100, 150, 30);
        c.add(txtsession);

        lblsemester = new JLabel("Semester : ");
        lblsemester.setBounds(20, 150, 70, 30);
        c.add(lblsemester);
        txtsemester = new JTextField();
        txtsemester.setBounds(150, 150, 150, 30);
        c.add(txtsemester);

        lbldept = new JLabel("Department : ");
        lbldept.setBounds(20, 200, 100, 30);
        c.add(lbldept);
        txtdept = new JTextField();
        txtdept.setBounds(150, 200, 150, 30);
        c.add(txtdept);

        btnsearch = new JButton("Enter Marks");
        btnsearch.setBounds(100, 250, 150, 40);
        c.add(btnsearch);

        btnsub = new JButton("Fetch Subjects");
        btnsub.setBounds(100, 300, 150, 40);
        c.add(btnsub);

        lblscode = new JLabel("Subject Code ");
        lblscode.setBounds(20, 400, 70, 30);
        c.add(lblscode);
        txtscode = new JTextField();
        txtscode.setBounds(100, 400, 70, 30);
        c.add(txtscode);
        lblth = new JLabel("Theory ");
        lblth.setBounds(180, 400, 70, 30);
        c.add(lblth);
        txtth = new JTextField();
        txtth.setBounds(260, 400, 70, 30);
        c.add(txtth);

        lblprac = new JLabel("Practical ");
        lblprac.setBounds(340, 400, 70, 30);
        c.add(lblprac);
        txtprac = new JTextField();
        txtprac.setBounds(420, 400, 70, 30);
        c.add(txtprac);

        lblmt = new JLabel("Mid-Term ");
        lblmt.setBounds(500, 400, 70, 30);
        c.add(lblmt);
        txtmt = new JTextField();
        txtmt.setBounds(580, 400, 70, 30);
        c.add(txtmt);

        lbltotal = new JLabel("Total ");
        lbltotal.setBounds(660, 400, 70, 30);
        c.add(lbltotal);
        txttotal = new JTextField();
        txttotal.setBounds(740, 400, 70, 30);
        c.add(txttotal);

        insertMarks = new JButton("Upload Marks");
        insertMarks.setBounds(150, 450, 120, 40);
        c.add(insertMarks);

        btnreset = new JButton("Reset");
        btnreset.setBounds(300, 450, 120, 40);
        c.add(btnreset);

        btnresultcal = new JButton("SGPA");
        btnresultcal.setBounds(450, 450, 120, 40);
        c.add(btnresultcal);

        btnogpa = new JButton("OGPA");
        btnogpa.setBounds(600, 450, 120, 40);
        c.add(btnogpa);

        btnsearch.addActionListener(this);
        insertMarks.addActionListener(this);
        btnreset.addActionListener(this);
        btnresultcal.addActionListener(this);
        btnogpa.addActionListener(this);
        btnsub.addActionListener(this);
    }

//void tableload() {
//    try {
//        Statement stmt = main.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//        ResultSet rs = stmt.executeQuery("select subcode,marksth,markspr,marksmt,totalmarks from marks where enrnum = '" + txtenroll.getText() + "'AND subcode IN (select subid from subject where semster =" + Integer.parseInt(txtsemester.getText()) + "AND sessyear =" + Integer.parseInt(txtsession.getText()) + "AND deptnum =" + Integer.parseInt(txtdept.getText()) + ") ");
//    jtablesub.setModel(DbUtils.resultSetToTableModel(rs));
//    } catch (SQLException e){
//e.printStackTrace();
//    }

    //}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsearch) {
            String enroll = txtenroll.getText();
            int semester = Integer.parseInt(txtsemester.getText());
            int session = Integer.parseInt(txtsession.getText());
            int dept = Integer.parseInt(txtdept.getText());
            ResultSet rs = null;
            try {
                Statement stmt = main.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery("select subcode,crtheo,crprac,marksth,markspr,marksmt,totalmarks,gradept,subcr from marks where enrnum = '" + enroll + "'AND subcode IN (select subid from subject where semster =" + semester + "AND sessyear =" + session + "AND deptnum =" + dept + ") ");
                jtablesub.setModel(DbUtils.resultSetToTableModel(rs));
                txtenroll.requestFocus();
                jtablesub.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int row_index = jtablesub.getSelectedRow();
                        txtscode.setText(jtablesub.getValueAt(row_index, 0).toString());
                        txtth.setText(jtablesub.getValueAt(row_index, 3) + " ");
                        txtprac.setText(jtablesub.getValueAt(row_index, 4).toString());
                        txtmt.setText(jtablesub.getValueAt(row_index, 5).toString());
                        txttotal.setText(jtablesub.getValueAt(row_index, 6).toString());
//                                txtdept.setText(jTable.getValueAt(row_index,5).toString());
//                                txtsession.setText(jTable.getValueAt(row_index,6).toString());
                    }
                });
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } else if (e.getSource() == insertMarks) {
            ResultSet rs = null;
            String enroll = txtenroll.getText();
            int semester = Integer.parseInt(txtsemester.getText());
            int session = Integer.parseInt(txtsession.getText());
            int dept = Integer.parseInt(txtdept.getText());
            try {
                Statement stmt1 = main.con.createStatement();
//                    stmt1.executeUpdate("insert into marks(marksth,markspr,marksmt,totalmarks) values("+tf11.getText()+","+tf21.getText()+","+tf31.getText()+","+tf41.getText()+")" + "where enrnum = '"+enroll+"'AND sem = "+semester+" AND subcode = '"+rs.getString(1)+"' ");
                stmt1.executeUpdate("update marks set marksth = " + txtth.getText() + ",markspr = " + txtprac.getText() + ", marksmt = " + txtmt.getText() + ",totalmarks = " + txttotal.getText() + " where enrnum = '" + txtenroll.getText() + "'AND sem = " + Integer.parseInt(txtsemester.getText()) + " AND subcode = '" + txtscode.getText() + "' ");
//                        JOptionPane.showMessageDialog(null, "Marks inserted Successfully");
                stmt1.executeUpdate("update marks set subcr= ((" + Float.parseFloat(txttotal.getText()) + ")/10 * totalcredit) where  enrnum = '" + txtenroll.getText() + "'AND sem = " + Integer.parseInt(txtsemester.getText()) + " AND subcode = '" + txtscode.getText() + "'   ");
                stmt1.executeUpdate("update marks set gradept= (" + Float.parseFloat(txttotal.getText()) + ")/10 where  enrnum = '" + txtenroll.getText() + "'AND sem = " + Integer.parseInt(txtsemester.getText()) + " AND subcode = '" + txtscode.getText() + "'   ");
                rs = stmt1.executeQuery("select subcode,crtheo,crprac,marksth,markspr,marksmt,totalmarks,gradept,subcr from marks where enrnum = '" + enroll + "'AND subcode IN (select subid from subject where semster =" + semester + "AND sessyear =" + session + "AND deptnum =" + dept + ") ");
                jtablesub.setModel(DbUtils.resultSetToTableModel(rs));
/*                        finalmsg = new JLabel();
                        finalmsg.setSize(finalmsg.getPreferredSize());
                        finalmsg.setLocation(400,350);
                        finalmsg.setText("Marks Inserted Succesfully For " + txtscode.getText() );
                        c.add(finalmsg);
                        validate();
                        c.repaint();*/
                txtenroll.requestFocus();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnreset) {
            txtscode.setText(null);
            txtth.setText(null);
            txtprac.setText(null);
            txtmt.setText(null);
            txttotal.setText(null);
            txtenroll.setText(null);
            txtsession.setText(null);
            txtsemester.setText(null);
            txtdept.setText(null);
            DefaultTableModel model = (DefaultTableModel) jtablesub.getModel();
            model.setRowCount(0);
        } else if (e.getSource() == btnresultcal) {
            ResultSet rs, rs1;
            try {
                Statement stmt = main.con.createStatement();
                Statement stmt1 = main.con.createStatement();

                ResultSet creditsum = stmt1.executeQuery("SELECT SUM(totalcredit) from marks where enrnum = '" + txtenroll.getText() + "'AND subcode IN (select subid from subject where semster =" + txtsemester.getText() + "AND sessyear =" + txtsession.getText() + "AND deptnum =" + txtdept.getText() + ") ");
                creditsum.next();
                int credit = creditsum.getInt(1);

                ResultSet deptname = stmt1.executeQuery("Select dname from department where dno=" + txtdept.getText() + "");
                deptname.next();
                String name = deptname.getString(1);

                ResultSet obtainedcredit = stmt1.executeQuery("Select SUM(subcr) from marks where enrnum = '" + txtenroll.getText() + "'AND subcode IN (select subid from subject where semster =" + txtsemester.getText() + "AND sessyear =" + txtsession.getText() + "AND deptnum =" + txtdept.getText() + ") ");
                obtainedcredit.next();
                Float obcre = obtainedcredit.getFloat(1);
                Float sgpaa = obcre / credit;

//                        jtablesub.setModel(DbUtils.resultSetToTableModel(obtainedcredit));
                stmt1.executeUpdate("insert into result (ennum,resem,depnum,depname,crsum,obtainedcr,sgpa) values('" + txtenroll.getText() + "'," + txtsemester.getText() + "," + txtdept.getText() + ",'" + name + "'," + credit + "," + obcre + ","+sgpaa+")");

                JOptionPane.showMessageDialog(null,"SGPA calculated succesfully");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == btnogpa) {
            ResultSet rs;
            try {
                Statement stmt1 = main.con.createStatement();
                rs = stmt1.executeQuery("select SUM(totalcredit),SUM(subcr) from marks where enrnum = '"+txtenroll.getText()+"'AND sem <= "+Integer.parseInt(txtsemester.getText())+" ");
                rs.next();
                Float cp = rs.getFloat(1);
                Float cp1 = rs.getFloat(2);
                Float gpsum = cp1/cp;
                stmt1.executeUpdate("update result set ogpa = " + gpsum + " where ennum ='" + txtenroll.getText() + "' AND resem = " + txtsemester.getText());
                rs = stmt1.executeQuery("select * from result where ennum = '" + txtenroll.getText() + "' AND resem = " + txtsemester.getText() + " ");
                JOptionPane.showMessageDialog(null,"OGPA calculated succesfully");
                jtablesub.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==btnsub)
        {
            ResultSet rs2;
            try{
                Statement stmt1 = main.con.createStatement();
                Statement stmt2 = main.con.createStatement();
                rs2 = stmt1.executeQuery("select subid,crth,crpr,subname from subject where sessyear = "+Integer.parseInt(txtsession.getText())+" AND deptnum = "+Integer.parseInt(txtdept.getText())+" AND semster = "+Integer.parseInt(txtsemester.getText())+" ");
                while(rs2.next())
                {
                    String subcode = rs2.getString(1);
                    Float crthe = rs2.getFloat(2);
                    Float crprac = rs2.getFloat(3);
                    Float credits = crthe+crprac;
                    String name = rs2.getString(4);
                    stmt2.executeUpdate("insert into marks (enrnum,subcode,sem,sesion,marksth,markspr,marksmt,totalmarks,totalcredit,subname,crtheo,crprac) values ('"+txtenroll.getText()+"','"+subcode+"',"+Integer.parseInt(txtsemester.getText())+","+txtsession.getText()+","+0+","+0+","+0+","+0+","+credits+",'"+name+"',"+crthe+","+crprac+")");
                }
                JOptionPane.showMessageDialog(null,"Subjects Fetched Succesfully - Now you can enter marks");
//                jtablesub.setModel(DbUtils.resultSetToTableModel(rs2));
            }
            catch(SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

