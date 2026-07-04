import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class number extends JPanel implements ActionListener {
    private int numBalls = 14;
    private int[] x;          // x positions
    private int[] y;          // y positions
    private int[] dy;         // velocities
    private int diameter = 40;
    private Timer timer;
    private boolean ini=false;
    Random r=new Random();
    private int randomNum[];

    public number()
    {
        x = new int[numBalls];
        y = new int[numBalls];
        dy = new int[numBalls];
        randomNum= new int[numBalls];

        timer = new Timer(1, this); // smoother animation
        timer.start();
    }
    
    private void init()
    {
        if(ini)
        return;

        // Initialize each ball with different positions and velocities
        for (int i = 0; i < numBalls; i++)
        {
            x[i] = 10 + i * diameter;   // spread horizontally
            y[i] = (i*diameter);                // stagger vertically
            dy[i] = 2;                     // different speeds
        }
        ini=true;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        if(!ini)
        init();
        super.paintComponent(g);
        
        Graphics2D g2=(Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        
        GradientPaint bgGradient = new GradientPaint(0, 0, new Color(50, 40, 60),
                                                     0, height, new Color(0, 100, 100));
        g2.setPaint(bgGradient);
        g2.fillRect(0, 0, width, height);
                                                     
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        for(int i=0;i<numBalls;i++)
        g.drawString(""+randomNum[i], x[i], y[i]);  // Just display it
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        for (int i = 0; i < numBalls; i++)
        {
            y[i] += dy[i];

            // Bounce off top or bottom edges
            if (y[i] >= getHeight())
            {
                y[i] = -40;
                x[i]=r.nextInt(600);
                randomNum[i] = r.nextInt(10);
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bounce Balls");
        number animation = new number();
        frame.add(animation);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
