import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;




public class MainFrame extends JFrame implements ActionListener {

    int[][] maze={ {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1} };
        List<Integer> path=new ArrayList<>();
        JButton start;
        //BoardPanel panel;
        JPanel gridFrame;
       MainFrame()
       {


           setTitle("Maze_Solver");
           setLayout(null);
           setVisible(true);
           //JLabel background;

           //gridFrame=new JPanel();
          // gridFrame.setBounds(70,70,500,500);
           //gridFrame.setBackground(Color.WHITE);
           //add(gridFrame);
          // background=new JLabel("",new ImageIcon("C:\\Users\\family\\Downloads\\peakpx.jpg"),JLabel.CENTER);
         // background.setBounds(0,0,640,720);
          // setBackground(Color.BLUE);
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           setSize(640,800);
           setLocationRelativeTo(null);
          // panel=new BoardPanel(10,13);

           //add(panel);
           start=new JButton("START");
           start.setBackground(Color.BLACK);
           start.setForeground(Color.WHITE);
           start.setBounds(260,600,100,40);
           start.setFont(new Font("Dialog", Font.PLAIN,20));
           add(start);
          start.addActionListener(this);

           //DepthFirstSearch.searchPath(maze, 1, 1, path);


       }
     @Override
    public void paint(Graphics g)
       {

          g.translate(110,70);
           for(int i=0;i<maze.length;i++)
           {
               for(int j=0;j<maze[0].length;j++)
               {
                  Color color;
                  switch(maze[i][j])
                  {

                      case 1: color=Color.BLACK;break;
                      case 9: color=Color.RED;break;
                      default:color=Color.WHITE;break;
                  }
                  g.setColor(color);
                  g.fillRect(30*j,30*i,30,30);
                  g.setColor(Color.BLUE);
                  g.drawRect(30*j,30*i,30,30);
               }
           }
           for(int p=0;p<path.size();p+=2)
           {
               int pathX=path.get(p);
               int pathY=path.get(p+1);
               g.setColor(Color.YELLOW);
               g.fillRect(30*pathX,30*pathY,20,20);
           }


       }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start) {
            DepthFirstSearch.searchPath(maze, 1, 1, path);
           // System.out.print(path);
            //repaint();
            }
        }




       public static void main(String[] args)
       {
           MainFrame view=new MainFrame();
           view.setVisible(true);

       }
}
