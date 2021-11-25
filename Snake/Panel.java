import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    int AppleX;
    int AppleY;
    int goldenAppleX=700;
    int goldenAppleY=700;
    int[] bodyX=new int[50];
    int[] bodyY=new int[50];
    Timer timer;
    char Dir='D';
    int mod=200;
    int bodyparts=1;
    boolean on=false;
    int Score=0;
    int gameOverX;
    int gameOverY;
    Panel(){
        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.CYAN);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        gameStart();

    }
    public void menuStart(){
        JPanel menu=new JPanel();

    }
    public void gameStart(){
        newApple();
        on=true;
        timer = new Timer(mod,this);//Wprawia Snake w ruch;
        timer.start();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
        drawSnake(g);
    }
    public void newApple(){
        Random r = new Random();
        this.AppleX=r.nextInt(12)*50;
        this.AppleY=r.nextInt(12)*50;
    }
    public void goldApple(){
        Random r = new Random();
        this.goldenAppleX=r.nextInt(12)*50;
        this.goldenAppleY=r.nextInt(12)*50;

    }
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(AppleX,AppleY,25,25);

        g.setColor(Color.yellow);
        g.fillOval(goldenAppleX,goldenAppleY,25,25);

        g.setColor(Color.BLACK);
        g.setFont((new Font("Monaco", Font.PLAIN, 20)));
        FontMetrics metrics=getFontMetrics(g.getFont());
        g.drawString("Score :"+Score,(600-metrics.stringWidth("Score : "+Score))/2,g.getFont().getSize());
        g.setColor(Color.red);
        g.drawString("Game over",gameOverX,gameOverY);

    }
    public void drawSnake(Graphics g){

         for(int i = 0;i<bodyparts;i++){
            if(i==0){
                g.setColor(Color.GREEN);
                g.fillOval(bodyX[i],bodyY[i],25,25);
            }
            else{
                g.setColor(Color.gray);
                g.fillOval(bodyX[i],bodyY[i],25,25);

            }
        }
    }
    public void gameOver(){
        this.gameOverX=250;
        this.gameOverY=300;

    }
    public void move(){
        for (int i = bodyparts;i>0;i--){
            bodyX[i]=bodyX[i-1];
            bodyY[i]=bodyY[i-1];
        }

        switch (Dir){
            case 'U':
                bodyY[0]= bodyY[0]-25;
                break;
            case 'D':
                bodyY[0]= bodyY[0]+25;
                break;
            case 'R':
                bodyX[0]= bodyX[0]+25;
                break;
            case 'L':
                bodyX[0]= bodyX[0]-25;
                break;
        }

    }

    public void collision(){
        for(int i = bodyparts;i>0;i--){
            if(bodyX[0]==bodyX[i]&& bodyY[0]==bodyY[i]){//kolizja głowy z ciałem
                on=false;
            }
            if(bodyX[0] <-1){on=false;}//lewa krawedz
            if(bodyX[0] >601){on=false;}//prawa krawedz
            if(bodyY[0] >601){on=false;}//dół
            if(bodyY[0] <-1){on=false;}//gora
            if(!on){
                timer.stop();
                gameOver();

            }

        }
    }
    public void appleAte(){
        if(bodyX[0]==AppleX && bodyY[0]==AppleY){
            newApple();
            Random goldChance=new Random();
            if(goldChance.nextBoolean()){
                goldApple();
            }
            timer.setDelay(mod-100);
            Score+= 100;
            bodyparts++;
        }
        if(bodyX[0]==goldenAppleX && bodyY[0]==goldenAppleY){
            goldenAppleX=700;
            goldenAppleY=700;
            mod-=50;
            Score+= 300;
            bodyparts++;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(on){
            move();
            collision();
            appleAte();
        }
        repaint();

    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public  void keyPressed(KeyEvent e){
                switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(Dir !='R')
                    {
                        Dir='L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(Dir !='L'){
                        Dir='R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(Dir !='D'){
                        Dir='U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(Dir !='U'){
                        Dir='D';
                    }
                    break;
            }

        }
    }
}
