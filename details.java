import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class details extends JFrame implements ActionListener {

        JButton btnAdd,btnUpdate,btnDelete,btnShow,btnmarks,btnsearch,btnreset;
        JTextField txtRoll,txtName,txtfname,txtdob,txtsem,txtdept,txtsession;
        JLabel lblRoll,lblName,lblfname,lbldob,lblsem,lbldept,lblsession;
        JTable jTable;
        Container c;

        details(){
            //set Title of JFrame
            super("Student Form");

            // adding container to JFrame
            c = getContentPane();

            // setting Layout of JFrame to NUll
            c.setLayout(null);

            //Creating Label Text for each TextField and adding to container
            lblRoll = new JLabel("Enrollment No : ");
            lblRoll.setBounds(20,50,100,30);
            c.add(lblRoll);
            txtRoll =  new JTextField();
            txtRoll.setBounds(150,50,200,30);
            c.add(txtRoll);
            lblName = new JLabel("Name : ");
            lblName.setBounds(20,100,100,30);
            c.add(lblName);
            txtName =  new JTextField();
            txtName.setBounds(150,100,200,30);
            c.add(txtName);

            lblfname = new JLabel("Father's Name : ");
            lblfname.setBounds(20,150,100,30);
            c.add(lblfname);
            txtfname =  new JTextField();
            txtfname.setBounds(150,150,200,30);
            c.add(txtfname);

            lbldob = new JLabel("DOB : ");
            lbldob.setBounds(20,200,150,30);
            c.add(lbldob);
            txtdob =  new JTextField();
            txtdob.setBounds(150,200,200,30);
            c.add(txtdob);

            lblsem = new JLabel("Semester No : ");
            lblsem.setBounds(20,250,150,30);
            c.add(lblsem);
            txtsem =  new JTextField();
            txtsem.setBounds(150,250,200,30);
            c.add(txtsem);

            lbldept = new JLabel("Dept No : ");
            lbldept.setBounds(20,300,150,30);
            c.add(lbldept);
            txtdept =  new JTextField();
            txtdept.setBounds(150,300,200,30);
            c.add(txtdept);

            lblsession = new JLabel("Session : ");
            lblsession.setBounds(20,350,150,30);
            c.add(lblsession);
            txtsession =  new JTextField();
            txtsession.setBounds(150,350,200,30);
            c.add(txtsession);


            //creating button and adding to container
            btnAdd = new JButton("Add");
            btnAdd.setBounds(10,400,80,40);
            c.add(btnAdd);
            btnShow = new JButton("Show");
            btnShow.setBounds(120,400,80,40);
            c.add(btnShow);
            btnUpdate = new JButton("Update");
            btnUpdate.setBounds(230,400,80,40);
            c.add(btnUpdate);
            btnDelete = new JButton("Delete");
            btnDelete.setBounds(340,400,80,40);
            c.add(btnDelete);
            btnmarks = new JButton("Edit Marks");
            btnmarks.setBounds(10,450,115,40);
            c.add(btnmarks);
            btnsearch = new JButton("Search Records");
            btnsearch.setBounds(145,450,140,40);
            c.add(btnsearch);
            btnreset = new JButton("Reset");
            btnreset.setBounds(305,450,115,40);
            c.add(btnreset);

            //adding action Listener to each Button
            btnAdd.addActionListener(this);
            btnShow.addActionListener(this);
            btnUpdate.addActionListener(this);
            btnDelete.addActionListener(this);
            btnmarks.addActionListener(this);
            btnsearch.addActionListener(this);
            btnreset.addActionListener(this);
        }

        ArrayList<resultLogic> getStudents(){
            ArrayList<resultLogic> studentData = new ArrayList<>();
            try{
                Statement stmt = main.con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from student");
                resultLogic resultlogicob;
                while(rs.next()){
                    String enroll = rs.getString(1);
                    String stname = rs.getString(2);
                    String fname = rs.getString(3);
                    String dob = rs.getString(4);
                    int cusem = rs.getInt(5);
                    int dept = rs.getInt(6);
                    int sess = rs.getInt(7);
                    resultlogicob = new resultLogic(enroll,stname,fname,dob,cusem,dept,sess);
                    studentData.add(resultlogicob);
                }
            }catch(SQLException e1){
                e1.printStackTrace();
            }
            return studentData;
        }

        JTable getTable(){
            Vector<Object> columnData = new Vector<>();
            columnData.add("Enroll No.");
            columnData.add("Name");
            columnData.add("Father Name");
            columnData.add("DOB");
            columnData.add("Semester");
            columnData.add("Department No");
            columnData.add("Session");
            Vector<Vector<Object>> data = new Vector<>();
            ArrayList<resultLogic> list = getStudents();
            for (resultLogic resultlogicob : list) {
                Vector<Object> row = new Vector<>();
                row.add(resultlogicob.getenrollNumber());
                row.add(resultlogicob.getStudentName());
                row.add(resultlogicob.getfatherName());
                row.add(resultlogicob.getdob());
                row.add(resultlogicob.getcurrsem());
                row.add(resultlogicob.getdeptno());
                row.add(resultlogicob.getsession());
                data.add(row);
            }
            jTable = new JTable(data,columnData);
            return jTable;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnAdd){
                String name = txtName.getText();
                String fname = txtfname.getText();
                String enroll = txtRoll.getText();
                String dob = txtdob.getText();
                int sem = Integer.parseInt(txtsem.getText());
                int session = Integer.parseInt(txtsession.getText());
                int depart = Integer.parseInt(txtdept.getText());
                //int roll = Integer.parseInt(txtRoll.getText());
                try{
                    Statement stmt = main.con.createStatement();
                    stmt.executeUpdate("insert into student(enroll_no,name,fname,dob,curr_sem,deptno,sessiony) values('"+enroll+"','"+name+"','"+fname+"','"+dob+"',"+sem+","+depart+","+session+")");
                    JOptionPane.showMessageDialog(null,"Data inserted Successfully");
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
                txtRoll.setText(null);
                txtName.setText(null);
                txtfname.setText(null);
                txtdob.setText(null);
                txtsem.setText(null);
                txtdept.setText(null);
                txtsession.setText(null);
            }else if(e.getSource()==btnShow){
                jTable = getTable();
                new layout(jTable,"Student Table");
                jTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int row_index = jTable.getSelectedRow();
                        txtName.setText(jTable.getValueAt(row_index,1).toString());
                        txtfname.setText(jTable.getValueAt(row_index,2).toString());
                        txtRoll.setText(jTable.getValueAt(row_index,0).toString());
                        txtdob.setText(jTable.getValueAt(row_index,3).toString());
                        txtsem.setText(jTable.getValueAt(row_index,4).toString());
                        txtdept.setText(jTable.getValueAt(row_index,5).toString());
                        txtsession.setText(jTable.getValueAt(row_index,6).toString());
                    }
                });
            }else if(e.getSource()==btnUpdate){
                try{
//                    PreparedStatement stmt = main.con.prepareStatement();
                    String query = "update student set name='"+txtName.getText()+"',fname='"+txtfname.getText()+"' ,dob='"+txtdob.getText()+"' ,curr_sem="+Integer.parseInt(txtsem.getText())+" ,deptno="+Integer.parseInt(txtdept.getText())+",sessiony="+Integer.parseInt(txtsession.getText())+" where enroll_no='"+txtRoll.getText()+"' ";
                    PreparedStatement stmt = main.con.prepareStatement(query);
                    stmt.executeUpdate();
                }catch (NumberFormatException ne){
                    JOptionPane.showMessageDialog(null,"To update the data first open the Table!");
                    return;
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                jTable = getTable();
                new layout(jTable,"Updated Table");
                txtRoll.setText(null);
                txtName.setText(null);
                txtfname.setText(null);
                txtdob.setText(null);
                txtsem.setText(null);
                txtdept.setText(null);
                txtsession.setText(null);
            }else if(e.getSource()==btnDelete){
                jTable = getTable();
                new layout(jTable,"Student Table");
                jTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int row_index = jTable.getSelectedRow();
                        txtRoll.setText(jTable.getValueAt(row_index,0).toString());
                        int response = JOptionPane.showConfirmDialog(null,"Do you want to delete ? ","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                        if(response==JOptionPane.YES_OPTION){
                            try{
                                Statement stmt = main.con.createStatement();
                                stmt.executeUpdate("delete from student where enroll_no='"+txtRoll.getText()+"' ");
                            }catch (SQLException e1){
                                e1.printStackTrace();
                            }
                            jTable = getTable();
                            new layout(jTable,"Updated Table");
                        }else{
                            txtRoll.setText(null);
                        }
                    }
                });
                txtRoll.setText(null);
                txtName.setText(null);
                txtfname.setText(null);
                txtdob.setText(null);
                txtsem.setText(null);
                txtdept.setText(null);
                txtsession.setText(null);
            }else if(e.getSource()==btnmarks){
                MarksCRUDform frame1 = new MarksCRUDform();
                frame1.setBounds(100,100,900,600);
                Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KARTIK\\Desktop\\Mpuat_udaipur.png");
                frame1.setIconImage(icon);
                frame1.setLayout(null);
                frame1.setVisible(true);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(e.getSource()==btnsearch){
                if(txtRoll.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "To Search enter Enrollment No!");
                }
                else {
                    try {
                        Statement stmt1 = main.con.createStatement();
                        ResultSet rs = stmt1.executeQuery("select * from student where enroll_no = '" + txtRoll.getText() + "'");
                        rs.next();
                        String name = rs.getString(2);
                        txtName.setText(name);
                        txtfname.setText(rs.getString(3));
                        txtdob.setText(rs.getString(4));
                        txtsem.setText(Integer.toString(rs.getInt(5)));
                        txtdept.setText(Integer.toString(rs.getInt(6)));
                        txtsession.setText(Integer.toString(rs.getInt(7)));
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else if(e.getSource()==btnreset){
                txtRoll.setText(null);
                txtName.setText(null);
                txtfname.setText(null);
                txtdob.setText(null);
                txtsem.setText(null);
                txtdept.setText(null);
                txtsession.setText(null);
            }
        }

    }

