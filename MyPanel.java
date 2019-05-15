import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





public class MyPanel extends JPanel implements KeyListener{
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 480;
    private static final int HEIGHT = 480;
    private static final int ROW = 15;
    private static final int COL = 15;
    private static final int CS = 32;
   
    
    private static int map[][][]= {
    		{	{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,5,5,5,5,1,5,5,5,5,1,5,5,5,1},
        		{1,5,5,5,5,1,5,5,5,5,1,5,5,5,1},
        		{1,5,5,5,5,5,5,5,5,5,5,5,5,5,1},
        		{1,5,5,5,5,5,5,5,5,5,5,5,5,5,1},
        		{1,5,5,5,5,5,5,5,5,5,5,5,5,5,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{7,0,0,0,6,0,0,0,0,0,0,0,0,0,0},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,5,5,5,5,5,5,5,5,5,5,5,5,5,1},
        		{1,5,5,5,5,5,5,5,5,5,5,5,5,5,1},
        		{1,5,5,5,5,5,5,5,5,5,5,5,5,5,1},
        		{1,5,5,5,5,1,5,5,5,5,1,5,5,5,1},
        		{1,5,5,5,5,1,5,5,5,5,1,5,5,5,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,0,0,1,1,1,1,1,1,1,0,0,0,1},
        		{1,3,4,2,1,1,1,1,1,1,1,2,4,3,1},
        		{1,3,4,0,1,0,3,14,0,0,1,0,4,3,1},
        		{1,3,0,0,1,0,1,1,1,0,1,0,0,3,1},
        		{1,0,0,0,8,14,1,13,1,0,1,0,0,0,1},
        		{1,0,0,0,1,0,1,0,1,0,1,0,0,0,1},
        		{1,0,0,0,1,0,0,0,0,0,1,0,0,0,1},
        		{1,1,8,1,1,1,1,0,1,1,1,1,8,1,1},
        		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        		{1,1,1,1,0,1,1,10,1,1,0,1,1,1,1},
        		{1,0,0,1,0,1,0,0,0,1,0,1,0,0,1},
        		{1,0,0,9,0,1,0,0,0,1,0,9,0,0,1},
        		{1,7,0,1,0,1,0,0,0,1,0,1,0,11,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,0,0,0,0,0,10,0,0,0,0,0,0,1},
        		{1,0,1,1,1,1,1,1,1,1,1,1,1,0,1},
        		{1,0,1,0,0,0,0,0,0,0,0,0,1,0,1},
        		{1,0,1,0,1,1,1,1,1,1,1,0,1,0,1},
        		{1,0,1,0,1,0,0,8,0,0,1,0,1,0,1},
        		{1,0,1,0,1,0,1,1,1,0,1,0,1,0,1},
        		{1,0,1,8,1,0,1,13,1,0,1,8,1,0,1},
        		{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
        		{1,0,1,0,1,0,0,0,1,0,1,0,1,0,1},
        		{1,0,1,0,1,1,1,1,1,0,1,0,1,0,1},
        		{1,0,1,0,0,0,0,0,0,0,1,0,1,0,1},
        		{1,0,1,1,1,1,1,1,1,1,1,0,1,0,1},
        		{1,0,0,0,0,0,0,10,0,0,0,0,1,9,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,7,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,2,0,1,0,0,0,0,0,0,1,1,13,1},
        		{1,0,2,0,1,0,1,1,1,1,0,1,0,0,1},
        		{1,0,2,0,8,0,0,0,0,1,0,1,0,1,1},
        		{1,0,2,0,1,0,1,1,0,1,0,1,0,1,1},
        		{1,1,1,1,1,0,1,1,0,1,0,1,0,1,1},
        		{1,0,4,0,1,0,1,1,0,1,0,0,0,1,1},
        		{1,0,4,0,8,0,1,1,0,1,1,1,1,1,1},
        		{1,0,4,0,1,0,1,1,0,0,0,0,0,0,1},
        		{1,0,4,0,1,0,1,1,1,1,1,1,1,0,1},
        		{1,1,1,1,1,0,1,1,0,0,0,8,0,0,1},
        		{1,0,0,0,1,0,1,1,0,1,1,1,1,1,1},
        		{1,0,0,0,10,0,1,1,0,0,0,0,14,14,1},
        		{1,0,0,0,1,0,1,1,7,1,1,1,1,1,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,3,3,3,3,1,14,0,0,1,0,0,0,0,1},
        		{1,14,14,14,14,1,0,0,0,8,0,0,0,0,1},
        		{1,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
        		{1,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
        		{1,1,1,10,1,1,1,9,1,1,1,1,1,1,1},
        		{1,0,0,0,14,0,0,0,0,0,0,0,0,13,1},
        		{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,0,0,0,0,0,0,0,0,0,0,0,7,1},
        		{1,1,1,10,1,1,1,9,1,1,1,1,1,1,1},
        		{1,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
        		{1,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
        		{1,0,0,0,0,1,0,0,0,8,0,0,0,0,1},
        		{1,3,2,4,3,1,0,0,0,1,0,0,0,0,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,12,12,12,12,12,12,12,12,12,12,12,12,12,1},
        		{1,12,12,12,12,12,12,12,12,12,12,12,12,12,1},
        		{1,12,12,12,12,12,12,12,12,12,12,12,12,12,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
        		{1,0,0,1,0,0,0,13,0,0,0,0,0,0,1},
        		{1,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
        		{1,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
        		{1,0,0,1,0,0,0,10,0,0,0,0,0,0,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,12,12,12,12,12,12,12,12,12,12,12,12,12,1},
        		{1,12,12,12,12,12,12,12,12,12,12,12,12,12,1},
        		{1,12,12,12,12,12,12,12,12,12,12,12,12,12,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		
        	}
    };
    
    
    private java.awt.Image floorImage;
    private java.awt.Image wallImage;
    private java.awt.Image heroImage;
    private java.awt.Image redkeyImage;
    private java.awt.Image yellowkeyImage;
    private java.awt.Image bluekeyImage;
    private java.awt.Image magmaImage;
    private java.awt.Image angelImage;
    private java.awt.Image upImage;
    private java.awt.Image yellowdoorImage;
    private java.awt.Image bluedoorImage;
    private java.awt.Image reddoorImage;
    private java.awt.Image flyImage;
    private java.awt.Image blackImage;
    private java.awt.Image downImage;
    private java.awt.Image animal1Image;
    
    private int x,y;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
	
    private static int choose = 1;
    public static int count ;
    private Thread threadAnime;
    private int direction;
    
    private int level; /*level of tower*/
    private boolean ischoose = false;
    private boolean showfly=false;
    private boolean canmove = true;
    private boolean fight = true;
    private int pack = 1;
    Hero hero = new Hero();
    ArrayList<Animal> list = new ArrayList<Animal>();
    //Animal animal1 = new Animal("black guard", 1,300,30,20,50,50);
	//Animal animal2 = new Animal("black guard", 2,400,60,50,70,80);	
	
   
    
    
	public MyPanel() {
    	setPreferredSize(new Dimension(WIDTH,HEIGHT));
    	loadImage();
    	x= 7;
    	y= 14;
    	level = 0;
    	direction = DOWN;
    	count = 0;
    	setFocusable(true);
    	addKeyListener(this);
    	Hero hero = new Hero();
    	init();
    	//list.add(animal1);
    	//list.add(animal2);
    	
    	threadAnime = new Thread(new AnimationThread());
    	threadAnime.start();
    	//print();
    	
    	
    	
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	drawMap(g);
    	drawRole(g);
        
    	if(showfly==true&&getMap(level)[x][y]==11) {
         drawFly(g);
         drawChoose(g);
        }
    	if(fight==true&&getMap(level)[x][y]==14) {
            drawFight(g,14);
           }
        if(pack == 2) {
         drawPackage(g);
       	}
    	
    }
	private void drawFight(Graphics g,int num) {
		String string6 = new String("Fight");
		g.setColor(Color.WHITE);
		g.fillRect(3*CS, 2*CS, 5*CS, 5*CS);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString(string6,4*CS, 2*CS);
		g.drawImage(heroImage,3*CS,3*CS,CS,CS,this);
		if(num == 14 ) {
			g.drawImage(animal1Image,7*CS,3*CS,CS,CS,this);
		}
		
	}
	private void drawPackage(Graphics g) {
		String string6 = new String("Your Package");
		g.setColor(Color.BLACK);
		g.fillRect(3*CS, 2*CS, 5*CS, 5*CS);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString(string6,4*CS, 2*CS);
		g.drawImage(yellowkeyImage,3*CS,3*CS,CS,CS,this);
		
	}
	private void drawFly(Graphics g) {
		canmove = false;
		String string1 = new String("");
		String string2 = new String("");
		String string3 = new String("");
		String string4 = new String("");
		String string5 = new String("");
		String string6 = new String("");
		
		g.setColor(Color.BLACK);
		g.fillRect(60, 45, 150, 200);
		g.setColor(Color.RED);
		
		g.drawRoundRect(60, 45, 150, 200, 10, 10);
		g.drawRoundRect(59, 44, 152, 202, 10, 10);
		g.drawRoundRect(58, 43, 154, 204, 10, 10);
		g.drawRoundRect(57, 42, 156, 206, 10, 10);	
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));	
		string4 = "level 0";
		string5 = "level 1";
		string6 = "level 2";
		g.setColor(Color.GREEN);

		g.setColor(Color.WHITE);
		
		g.drawString(string4, 90, 165);
		g.drawString(string5, 90, 205);
		g.drawString(string6, 90, 245);
		if(choose == 4) {
			choose = 1;
		}
		
	}
	private void drawChoose(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(70,110+choose*45,10,5);
	}
	private void drawRole(Graphics g) {
		g.drawImage(heroImage,x*CS,y*CS,x*CS+CS,y*CS+CS,count*CS,0,CS+count*CS,CS,this);
	
	}
	private void drawMap(Graphics g) {
	    int x=0;
	    int y=0;
	    while(x<COL) {

	    	while(y<ROW) {
	    		if(getMap(level)[x][y]==0) {
	    			g.drawImage(floorImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==1) {
	    			g.drawImage(wallImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==2) {
	    			g.drawImage(redkeyImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==3) {
	    			g.drawImage(yellowkeyImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==4) {
	    			g.drawImage(bluekeyImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==5) {
	    			g.drawImage(magmaImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==6) {
	    			g.drawImage(angelImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==7) {
	    			g.drawImage(upImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==8) {
	    			g.drawImage(yellowdoorImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==9) {
	    			g.drawImage(reddoorImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==10) {
	    			g.drawImage(bluedoorImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==11) {
	    			g.drawImage(flyImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==12) {
	    			g.drawImage(blackImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==13) {
	    			g.drawImage(downImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==14) {
	    			g.drawImage(animal1Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		y++;
	        }
	      y=0;
	      x++;
	    }
	}
   
	/*private void print() {
		int x=0;
	    int y=0;
		while(x<COL) {
			while(y<ROW) {
				System.out.print(getMap(level)[x][y]);
				y++;
			}
			System.out.println(" ");
			y=0;
			x++;
		}
	    
	}*/
	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("image/floor.jpg"));
		floorImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/wall.jpg"));
		wallImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/hero1.jpg"));
		heroImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/bluekey.jpg"));
		bluekeyImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/yellowkey.jpg"));
		yellowkeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/redkey.jpg"));
	    redkeyImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/magma.jpg"));
	    magmaImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/angel.jpg"));
	    angelImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/up.jpg"));
	    upImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/yellowdoor.jpg"));
	    yellowdoorImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/reddoor.jpg"));
	    reddoorImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/bluedoor.jpg"));
	    bluedoorImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/fly.jpg"));
	    flyImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/black.jpg"));
	    blackImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/down.jpg"));
	    downImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/animal1.jpg"));
	    animal1Image = icon.getImage();
	}
	public void keyPressed(KeyEvent e) {
	int keyCode = e.getKeyCode();
	
	switch(keyCode) {
	case KeyEvent.VK_LEFT:
		move(LEFT);
		break;
	case KeyEvent.VK_RIGHT:
		move(RIGHT);
		break;
	case KeyEvent.VK_UP:
		move(UP);
		break;
	case KeyEvent.VK_DOWN:
		move(DOWN);
		break;
	case KeyEvent.VK_J:
		if(getMap(level)[x][y]==11) {
			if(choose ==2) {
			     choose(2);
			 }
			if(choose ==3) {
				 choose(3);
				 }
		     
		}		
		break;
	case KeyEvent.VK_3:
		openPackage(pack);		
		break;
		
	/*case hoose==.VK_1:	
		level = changeLevel(1);

		break;
	case KeyEvent.VK_0:	
		level = changeLevel(0);

		break;*/
	}
	repaint();
	if(x==7&&y==0) {
		if(level == 0) {
		level = level+1;
		x=6;
		y=7;
		}
	}
	if(x==13&&y==1) {
		if(level == 1) {
		level = level+1;
		x=8;
		y=7;
		}
		}
	if(x==5&&y==7) {
			if(level == 1) {
			level = level-1;
			x=7;
			y=0;
			}
	}
	if(x==14&&y==13) {
			if(level == 2) {
			level = level + 1;
			x=2;
			y=13;
		    }
			}
	if(x==7&&y==7) {
		if(level == 2) {
		level = level-1;
		x=13;
		y=1;
		}
}
	if(x==13&&y==8) {
		if(level == 3) {
		level = level+1;
		x=6;
		y=12;
		}
	}
	if(x==1&&y==13) {
		if(level == 3) {
		level = level-1;
		x=14;
		y=13;
		}
	}
	if(x==8&&y==13) {
		if(level == 4) {
		level = level+1;
		x=7;
		y=7;
		}
	}
	if(x==6 && y==13) {
		if(level == 4) {
		level = level-1;
		x=13;
		y=8;
		}
	}
		
	}
	private void move(int event) {
		switch(event) {
		case LEFT:
			if(isAllow(x-1,y)&&canmove ==true) {
			x--;
			direction=LEFT;
			}
			break;
		case RIGHT:
			if(isAllow(x+1,y)&&canmove ==true) {
			x++;
			direction=RIGHT;
			}
			break;
		case UP:
			if(isAllow(x,y-1)&&canmove ==true) {
			y--;
			direction=UP;
			
			}
			
			break;
		case DOWN:
			if(isAllow(x,y+1)&&canmove ==true) {
			y++;
			direction=DOWN;		
			
			}
			if(showfly) {
				choose = choose+1;
			}
			break;
			
		default :
			break;
		}
		
		
	}
	private void choose(int event) {
		switch(event) {
		case 2 :
			ischoose = false;
    	    showfly = false;
    	    canmove = true;
    	    level = 0;
    	    x= 7;
        	y= 14;
    	   
		case 3 :
			ischoose = false;
    	    showfly = false;	
			canmove = true;
			break;
		default :
			break;
		}
	}
	private void openPackage(int e) {
		switch(e) {
		case 1:
			pack = 2;
			break;
		case 2:
			pack = 1;
			break;	
		
	default :
		break;
		}
		
	}
	private boolean isAllow(int x,int y) {
		if(getMap(level)[x][y]==1) {
			return false;
		}
		if(getMap(level)[x][y]==6) {
			JOptionPane.showMessageDialog(this,"Please save our Princess, Warroir");
			getMap(level)[x][y]=0;
		}
		if(getMap(level)[x][y]==11) {		
			applyFly();			
		}
		if(getMap(level)[x][y]==2) {
			hero.keychange(2);
			hero.printstate();
			getMap(level)[x][y]=0;
		}
		if(getMap(level)[x][y]==3) {
			hero.keychange(3);
			hero.printstate();
			getMap(level)[x][y]=0;
		}
		if(getMap(level)[x][y]==4){
			hero.keychange(4);
			hero.printstate();
			getMap(level)[x][y]=0;
		}
		if(getMap(level)[x][y]==8){
			if(hero.yellowkey!=0) {
				hero.keychange(8);
				getMap(level)[x][y]=0;
			}else {
				return false;
			}
		}
		if(getMap(level)[x][y]==9){
			if(hero.redkey!=0) {
				hero.keychange(9);
				getMap(level)[x][y]=0;
			}else {
				return false;
			}
		}
		if(getMap(level)[x][y]==10){
			if(hero.bluekey!=0) {
				hero.keychange(10);
				getMap(level)[x][y]=0;
			}else {
				return false;
			}
		}
		
		
		if(getMap(level)[x][y]==14) {		
			fight(14);	
			getMap(level)[x][y]=0;
		}
		
		return true;
	}

	
	private void fight(int x) {
		JOptionPane.showMessageDialog(this,"Fight begin ");	
		fight = true;
		int heroinjure = 0;
		int animalinjure = 0;
		int animalhp = list.get(0).gethp();
		if(x==14) {
		   heroinjure =  list.get(0).getattack()-hero.getdefence();
		   animalinjure =  hero.getattack()-list.get(0).getdefence();
		   hero.hp = hero.gethp()-heroinjure;
		   animalhp = animalhp-animalinjure;
		   hero.money = hero.getmoney()+list.get(0).getmoney();
		   hero.experience = hero.getexperience()+list.get(0).getexperience();
		   hero.printstate();
		}
	
		
	}
	public void keyReleased(KeyEvent e) {
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    static int num = map.length;
	
    public static int[][] getMap(int grade) {
    	int temp[][]=null;
    	temp = map[grade];
		return temp;
    	
    	
    }
    public int changeLevel(int k) {
    	level = k;
		return level;
    	
    	
    }
    public int getLevel(int level) {
    	
		return level;	
    }
   
    public void applyFly() {
    	    JOptionPane.showMessageDialog(this,"You can go everywhere");	   
    	    ischoose = true;
    	    showfly = true;	
    
    }
    public void init(){
    	//Hero hero = new Hero();
    	Animal animal1 = new Animal("black guard", 1,300,40,20,50,50);
    	Animal animal2 = new Animal("black guard", 2,400,60,50,70,80);
    	
    	//ArrayList<Animal> list = new ArrayList<Animal>();
    	list.add(animal1);
    	list.add(animal2);
    	
    	
    }
	
 
    
       
    
    
    
    
}   