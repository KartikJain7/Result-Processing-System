import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class layout extends JFrame {
        JTableHeader header;
        layout(JTable jTable,String title){
            super(title);
            super.setVisible(true);
            super.setSize(400,400);
            super.setLocation(400,400);
            super.setDefaultCloseOperation(HIDE_ON_CLOSE);
            header = jTable.getTableHeader();
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
            jTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            jTable.setGridColor(Color.BLACK);
            c.add("North",header);
            c.add("Center",jTable);
        }
    }

