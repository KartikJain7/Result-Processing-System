import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NextPage extends JFrame implements ActionListener
{
    JButton btnresult,btnadmin;
    JTextField txtenroll1,txtresem,txtresession;
    JLabel lblenroll1,lblresem,lblresession;
    private ImageIcon mpuat;
    private JLabel image;
    private JLabel lblmpuat;
    private JLabel lblctae;
    private JLabel lblrps;
    Container c;
    /*private JFrame frame1;
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
    private JTextField txttotal;
    private JTable jtablesub;*/
    NextPage()
    {
        super("Result");

        c=getContentPane();
        c.setLayout(null);


        mpuat = new ImageIcon("C:\\Users\\KARTIK\\Desktop\\Webp.net-resizeimage.png");
        image = new JLabel(mpuat);
        image.setBounds(10,10,100,100);
        c.add(image);

//        *******************
        lblmpuat = new JLabel("MAHARANA PRATAP UNIVERSITY OF AGRICULTURE AND TECHNOLOGY");
        lblmpuat.setBounds(115, 10, 650, 30);
        c.add(lblmpuat);
        lblmpuat.setFont(new Font("Hersheys", Font.BOLD, 16));
        lblmpuat.setForeground(Color.darkGray);

        lblctae = new JLabel("MPUAT, UDAIPUR");
        lblctae.setBounds(300, 40, 600, 30);
        c.add(lblctae);
        lblctae.setFont(new Font("Hersheys", Font.CENTER_BASELINE, 15));
        lblctae.setForeground(Color.DARK_GRAY);

        lblctae = new JLabel("RESULT PROCESSING SYSTEM");
        lblctae.setBounds(250, 80, 600, 30);
        c.add(lblctae);
        lblctae.setFont(new Font("Hersheys", Font.BOLD, 15));
        lblctae.setForeground(Color.BLUE);
//        lblenroll = new JLabel
        lblenroll1 = new JLabel("Enrollment No : ");
        lblenroll1.setBounds(170,150,100,30);
        c.add(lblenroll1);
        txtenroll1 =  new JTextField();
        txtenroll1.setBounds(300,150,200,30);
        c.add(txtenroll1);
        lblresem = new JLabel("Semester No : ");
        lblresem.setBounds(170,200,100,30);
        c.add(lblresem);
        txtresem =  new JTextField();
        txtresem.setBounds(300,200,200,30);
        c.add(txtresem);

        lblresession = new JLabel("Admission Year : ");
        lblresession.setBounds(170,250,100,30);
        c.add(lblresession);
        txtresession =  new JTextField();
        txtresession.setBounds(300,250,200,30);
        c.add(txtresession);

        btnresult = new JButton("Result");
        btnresult.setBounds(250,300,80,40);
        c.add(btnresult);
        btnadmin = new JButton("Admin");
        btnadmin.setBounds(350,300,80,40);
        c.add(btnadmin);

        btnresult.addActionListener(this);
        btnadmin.addActionListener(this);

/*
        String enr = txtenroll1.getText();
        int sem = Integer.parseInt(txtresem.getText());
        int sess = Integer.parseInt(txtresession.getText());
*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnadmin){
            Login frame=new Login();
            frame.setBounds(500,300,300,100);
            Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KARTIK\\Desktop\\Mpuat_udaipur.png");
            frame.setIconImage(icon);
//            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if(e.getSource()==btnresult)
        {
            resultui frame = new resultui(txtenroll1.getText(),Integer.parseInt(txtresem.getText()),Integer.parseInt(txtresession.getText()));
            frame.setBounds(290,00,800,750);
            Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KARTIK\\Desktop\\Mpuat_udaipur.png");
            frame.setIconImage(icon);
            frame.setLayout(null);
            frame.setVisible(true);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
