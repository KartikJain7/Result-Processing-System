import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {

    static Connection con;

    public static void main(String[] args) {
        // write your code here
        try{
            Class.forName("org.postgresql.Driver");
            String dbType = "jdbc:postgresql:";
            String dbUrl = "//127.0.0.1:5432/";
            String dbName = "postgres";
            //String dbschema = "rps2";
            String dbUser = "postgres";
            String dbPass = "kartik2548";
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/resultpro?currentSchema=rps2",dbUser,dbPass);
            System.out.println("Connected Successfully!");
            if(con.isClosed()){
                System.out.println("Connection is still closed!");
            }else{
                System.out.println("Connected....");
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": "+e.getMessage());
            System.exit(0);
        }

        try
        {
            NextPage frame = new NextPage();
            frame.setBounds(400,150,700,450);
            Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\KARTIK\\Desktop\\Mpuat_udaipur.png");
            frame.setIconImage(icon);
//            frame.add(btnresult);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
//        try
//        {
//            Login frame=new Login();
//            frame.setBounds(500,300,300,100);
//            frame.setVisible(true);
//        }
//        catch(Exception e)
//        {JOptionPane.showMessageDialog(null, e.getMessage());}

//        details sl = new details();
//        sl.setVisible(true);
//        sl.setBounds(500,300,600,600);
//        sl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}