import javax.swing.plaf.metal.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
  
public class Main extends JFrame implements ActionListener {
   JTabbedPane tabbedPane;
   int ntabs = 0;
  
   public Main() {
      getContentPane().setLayout(new BorderLayout());
      tabbedPane = new JTabbedPane();
      tabbedPane.setUI(new CustomTabbedPaneUI());
      createTab();
  
      getContentPane().add(BorderLayout.CENTER, tabbedPane);
      setJMenuBar(createMenuBar());
   
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we) {
            System.exit(0);
         }
      });
    
      setTitle("Main Menu");
      setSize(new Dimension(650, 500));
   }
  
   protected JMenuBar createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
  
      JMenu menu1 = new JMenu("JTabbedPane");
      JMenuItem menuItem1 = new JMenuItem("Create new tab");
      menuItem1.addActionListener(this);
      menu1.add(menuItem1);
  
      return menuBar;
   }
   
   public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equals("Create new tab")) {
         createTab();
      }
      else if (e.getActionCommand().equals("TOP")) {
         tabbedPane.setTabPlacement(JTabbedPane.TOP);
      }
      else if (e.getActionCommand().equals("BOTTOM")) {
         tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
      }
      else if (e.getActionCommand().equals("LEFT")) {
         tabbedPane.setTabPlacement(JTabbedPane.LEFT);
      }
      else if (e.getActionCommand().equals("RIGHT")) {
         tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
      }
   }
  
   protected void createTab() {
      ntabs++;
      tabbedPane.addTab("Tab #" + ntabs + "   ", new JLabel("Tab #" + ntabs));
   }
  
   public static void main(String []args) {
      Main main = new Main();
      main.show();
   }
}
  
class CustomTabbedPaneUI extends MetalTabbedPaneUI
{
   Rectangle xRect;
  
   protected void installListeners() {
      super.installListeners();
      tabPane.addMouseListener(new MyMouseHandler());
   }
  
   protected void paintTab(Graphics g, int tabPlacement,
                           Rectangle[] rects, int tabIndex,
                           Rectangle iconRect, Rectangle textRect) {
      super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
  
      Font f = g.getFont();
      g.setFont(new Font("Courier", Font.BOLD, 10));
      FontMetrics fm = g.getFontMetrics(g.getFont());
      int charWidth = fm.charWidth('x');
      int maxAscent = fm.getMaxAscent();
      g.drawString("x", textRect.x + textRect.width - 3, textRect.y + textRect.height - 3);
      g.drawRect(textRect.x+textRect.width-5,
                 textRect.y+textRect.height-maxAscent, charWidth+2, maxAscent-1);
      xRect = new Rectangle(textRect.x+textRect.width-5,
                 textRect.y+textRect.height-maxAscent, charWidth+2, maxAscent-1);
      g.setFont(f);
    }
  
    public class MyMouseHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            System.out.println(e);
            if (xRect.contains(e.getPoint())) {
               JTabbedPane tabPane = (JTabbedPane)e.getSource();
               int tabIndex = tabForCoordinate(tabPane, e.getX(), e.getY());
               tabPane.remove(tabIndex);
            }
        }
    }
}