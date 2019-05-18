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
    static final int WIDTH = 480;
    static final int HEIGHT = 480;
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
        		{1,3,4,0,1,0,3,17,0,0,1,0,4,3,1},
        		{1,3,0,0,1,14,1,1,1,14,1,0,0,3,1},
        		{1,17,18,17,8,17,1,13,1,17,1,17,18,17,1},
        		{1,14,17,14,1,14,1,0,1,14,1,14,17,14,1},
        		{1,0,14,0,1,0,0,0,0,0,1,0,14,0,1},
        		{1,1,8,1,1,1,1,0,1,1,1,1,8,1,1},
        		{1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        		{1,1,1,1,0,1,1,10,1,1,0,1,1,1,1},
        		{1,0,15,1,0,1,0,17,0,1,0,1,15,14,1},
        		{1,14,0,9,0,1,0,0,0,1,0,9,14,18,1},
        		{1,7,14,1,0,1,0,16,0,1,0,1,18,11,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,0,0,0,0,0,10,0,0,14,17,18,19,1},
        		{1,0,1,1,1,1,1,1,1,1,1,1,1,18,1},
        		{1,17,1,0,17,18,17,0,3,4,2,0,1,17,1},
        		{1,18,1,0,1,1,1,1,1,1,1,0,1,14,1},
        		{1,19,1,0,1,0,0,8,0,0,1,0,1,0,1},
        		{1,18,1,0,1,14,1,1,1,0,1,0,1,0,1},
        		{1,17,1,8,1,17,1,13,1,14,1,8,1,0,1},
        		{1,0,1,0,1,14,1,0,1,17,1,0,1,15,1},
        		{1,0,1,0,1,0,0,0,1,14,1,0,1,16,1},
        		{1,15,1,0,1,1,1,1,1,0,1,0,1,15,1},
        		{1,16,1,0,17,18,17,0,0,0,1,17,1,0,1},
        		{1,15,1,1,1,1,1,1,1,1,1,18,1,0,1},
        		{1,0,0,0,0,0,0,10,0,0,0,0,1,9,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,7,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,23,3,14,1,0,0,17,17,0,0,1,1,13,1},
        		{1,14,3,18,1,0,1,1,1,1,0,1,0,0,1},
        		{1,14,3,17,8,0,14,14,0,1,0,1,0,1,1},
        		{1,24,3,18,1,14,1,1,0,1,0,1,0,1,1},
        		{1,1,1,1,1,17,1,1,0,1,0,1,0,1,1},
        		{1,24,4,18,1,14,1,1,0,1,14,17,14,1,1},
        		{1,14,4,17,8,0,1,1,0,1,1,1,1,1,1},
        		{1,14,4,18,1,0,1,1,0,0,14,17,14,0,1},
        		{1,23,4,14,1,0,1,1,1,1,1,1,1,0,1},
        		{1,1,1,1,1,0,1,1,17,0,0,8,0,0,1},
        		{1,28,0,0,1,17,1,1,18,1,1,1,1,1,1},
        		{1,29,0,0,10,18,1,1,17,0,0,0,14,14,1},
        		{1,30,0,0,1,17,1,1,7,1,1,1,1,1,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,3,3,3,3,1,17,18,18,1,0,15,16,25,1},
        		{1,17,17,17,17,1,14,17,18,8,19,15,16,0,1},
        		{1,0,18,18,18,1,0,14,17,1,0,15,16,0,1},
        		{1,0,0,19,0,1,0,0,14,1,0,15,16,0,1},
        		{1,1,1,10,1,1,1,9,1,1,1,1,1,1,1},
        		{1,0,17,17,17,0,0,0,17,18,17,0,0,13,1},
        		{1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,17,17,17,0,0,0,17,18,17,0,0,7,1},
        		{1,1,1,10,1,1,1,9,1,1,1,1,1,1,1},
        		{1,0,0,19,0,1,0,0,14,1,0,15,16,0,1},
        		{1,0,18,18,18,1,0,14,17,1,0,15,16,0,1},
        		{1,17,17,17,17,1,14,17,18,8,19,15,16,0,1},
        		{1,3,3,3,3,1,17,18,18,1,0,15,16,26,1},
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        	},
        	{
        		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        		{1,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
        		{1,25,0,0,8,19,0,0,18,18,18,0,0,0,1},
        		{1,0,0,0,1,27,27,27,27,7,27,27,27,18,1},
        		{1,1,1,1,1,27,27,27,27,27,27,27,27,17,1},
        		{1,27,27,27,27,27,27,27,27,27,27,27,27,18,1},
        		{1,27,27,27,27,4,27,15,27,23,27,0,27,0,1},
        		{1,13,0,0,18,0,18,0,18,0,18,0,0,0,1},
        		{1,27,27,27,3,27,2,27,16,27,24,27,27,0,1},
        		{1,27,27,27,27,27,27,27,27,27,27,27,27,18,1},
        		{1,1,1,1,1,27,27,27,27,27,27,27,27,17,1},
        		{1,0,0,0,1,27,27,27,27,7,27,27,27,18,1},
        		{1,26,0,0,8,19,0,0,18,18,18,0,0,0,1},
        		{1,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
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
   
    private java.awt.Image swordImage;
    private java.awt.Image shieldImage;
    private java.awt.Image chutouImage;
    private java.awt.Image ykeyImage;
    private java.awt.Image rkeyImage;
    private java.awt.Image bkeyImage;
    private java.awt.Image bbottleImage;
    private java.awt.Image rbottleImage;
    private java.awt.Image bbottle2Image;
    private java.awt.Image rbottle2Image;

    private java.awt.Image M1Image;
    private java.awt.Image M2Image;
    private java.awt.Image M3Image;
    private java.awt.Image M4Image;
    private java.awt.Image M5Image;
    private java.awt.Image M6Image;
    private java.awt.Image M7Image;
    
    private java.awt.Image greengemImage;
    private java.awt.Image yellowgemImage;
    
    private java.awt.Image forestImage;
    private java.awt.Image leftImage;
    private java.awt.Image middleImage;
    private java.awt.Image rightImage;
    private int x,y;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
	
    private static int choose = 1;
    private static int choose2 = 1;
    private static int choose3 = 1;
    public static int count ;
    private Thread threadAnime;
    private int direction;
    
    private int level; /*level of tower*/
    private boolean ischoose = false;
    private boolean showfly=false;
    private boolean canmove = true;
    private boolean fight = true;
    private boolean usingpackage = false;
    private boolean shopping = false;
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
    	if(shopping==true&&getMap(level)[x][y]==29) {
            drawShop(g);
            drawChooseshop(g,choose3);
           }
    	if(fight==true&&getMap(level)[x][y]==14) {
            drawFight(g,14);
            getMap(level)[x][y]=0;
           }
        if(pack == 2 && usingpackage==true) {
         drawPackage(g);
         if(usingpackage==true){
         drawChoosebottle(g,choose2);
         }
       	}
    	
    }
	private void drawChooseshop(Graphics g, int choose3) {
		g.setColor(Color.WHITE);
		g.fillRect(70,choose3*40+58,10,5);
		
	}

	private void drawShop(Graphics g) {
		canmove = false;
		String string4 = new String("");
		String string5 = new String("");
		String string6 = new String("");
		
		g.setColor(Color.BLACK);
		g.fillRect(60, 45, 250, 200);
		g.setColor(Color.RED);
		
		g.drawRoundRect(60, 45, 250, 200, 10, 10);
		g.drawRoundRect(59, 44, 252, 202, 10, 10);
		g.drawRoundRect(58, 43, 254, 204, 10, 10);
		g.drawRoundRect(57, 42, 256, 206, 10, 10);	
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));	
		string4 = "Using 100 upgrade level";
		string5 = "Using 80 increase attack";
		string6 = "Using 80 increase defence";
		g.setColor(Color.GREEN);

		g.setColor(Color.WHITE);
		
		g.drawString(string4, 90, 105);
		g.drawString(string5, 90, 145);
		g.drawString(string6, 90, 185);
		if(choose3 == 4) {
			choose3 = 1;
		}
		
	}

	private void drawChoosebottle(Graphics g,int chooses2) {
		if(choose2 ==1) {
		g.setColor(Color.RED);
		g.fillRect(5*CS+20+30,2*CS-30+choose2*45,10,5);
		}
		if(choose2 ==2) {
			g.setColor(Color.RED);
			g.fillRect(5*CS+20+30,2*CS-45+choose2*45,10,5);
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
			g.drawImage(M1Image,7*CS,3*CS,CS,CS,this);
		}
		
	}
	private void drawPackage(Graphics g) {
		
		String string6 = new String("Your Package");
		g.setColor(Color.BLUE);
	
		g.drawRoundRect(3*CS, 2*CS, 5*CS, 5*CS, 10,10);
		g.drawRoundRect(3*CS-2, 2*CS-2, 5*CS+2, 5*CS+2, 15,15);
		g.drawRoundRect(3*CS-3, 2*CS-3, 5*CS+4, 5*CS+4, 15,15);
		g.drawRoundRect(3*CS-4, 2*CS-4, 5*CS+6, 5*CS+6, 15,15);	
		g.setColor(Color.WHITE);
		g.fillRect(3*CS, 2*CS, 5*CS, 5*CS);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString(string6,4*CS, 2*CS);
		g.drawImage(ykeyImage,3*CS,2*CS,CS,CS,this);
		g.drawImage(bkeyImage,3*CS,3*CS,CS,CS,this);
		g.drawImage(rkeyImage,3*CS,4*CS,CS,CS,this);
		g.drawImage(bbottle2Image,4*CS+20,2*CS,CS,CS,this);
		g.drawImage(rbottle2Image,4*CS+20,3*CS,CS,CS,this);
		
		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String h  =  " "+hero.yellowkey;
		g.drawString(h,4*CS,3*CS-10);
		
		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String o  =  " "+hero.bluekey;		
		g.drawString(o,4*CS,4*CS-10); 
		
		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String p  =  " "+hero.redkey;
		g.drawString(p,4*CS,5*CS-10);
		
		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String h1  =  " "+hero.redbottle;
		g.drawString(h1,5*CS+20,3*CS-10); 
		
		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String h2  =  " "+hero.bluebottle;
		g.drawString(h2,5*CS+20,4*CS-10); 
	
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
		string1 = " exit";
		string2 = "level 0";
		string3 = "level 1";
		string4 = "level 2";
		string5 = "level 3";
		
		g.setColor(Color.GREEN);

		g.setColor(Color.WHITE);
		
		g.drawString(string1, 90, 65);
		g.drawString(string2, 90, 105);
		g.drawString(string3, 90, 145);
		g.drawString(string4, 90, 185);
		g.drawString(string5, 90, 225);
		g.drawString(string6, 90, 265);
		if(choose == 6) {
			choose = 1;
		}
		
	}
	private void drawChoose(Graphics g) {
	g.setColor(Color.WHITE);
	g.fillRect(70,choose*40+15,10,5);
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
	    			g.drawImage(M1Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==15) {
	    			g.drawImage(rbottleImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==16) {
	    			g.drawImage(bbottleImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==17) {
	    			g.drawImage(M2Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==18) {
	    			g.drawImage(M3Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==19) {
	    			g.drawImage(M4Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==20) {
	    			g.drawImage(M5Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==21) {
	    			g.drawImage(M6Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==22) {
	    			g.drawImage(M7Image,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==23) {
	    			g.drawImage(greengemImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==24) {
	    			g.drawImage(yellowgemImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==25) {
	    			g.drawImage(swordImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==26) {
	    			g.drawImage(shieldImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==27) {
	    			g.drawImage(forestImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==28) {
	    			g.drawImage(leftImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==29) {
	    			g.drawImage(middleImage,x*CS,y*CS,CS,CS,this);
	    		}
	    		if(getMap(level)[x][y]==30) {
	    			g.drawImage(rightImage,x*CS,y*CS,CS,CS,this);
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
	    icon = new ImageIcon(getClass().getResource("image/p.jpg"));
	    swordImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/s.jpg"));
	    shieldImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/q.jpg"));
	    chutouImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/101-01.png"));
	    ykeyImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/101-02.png"));
	    bkeyImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/101-03.png"));
	    rkeyImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/bt.jpg"));
	    bbottleImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/rt.jpg"));
	    rbottleImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/103-10.png"));
	    bbottle2Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/103-11.png"));
	    rbottle2Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_1.png"));
	    M1Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_2.png"));
	    M2Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_3.png"));
	    M3Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_4.png"));
	    M4Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_5.png"));
	    M5Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_6.png"));
	    M6Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/M_7.png"));
	    M7Image = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/103-03.png"));
	    greengemImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/103-04.png"));
	    yellowgemImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/Foerst.png"));
	    forestImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/left.jpg"));
	    leftImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/midle.jpg"));
	    middleImage = icon.getImage();
	    icon = new ImageIcon(getClass().getResource("image/right.jpg"));
	    rightImage = icon.getImage();
	    
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
			if(choose ==1) {
			     choose(1);
			 }
			if(choose ==2) {
			     choose(2);
			 }
			if(choose ==3) {
				 choose(3);
				 }
			if(choose ==4) {
				 choose(4);
				 }
			if(choose ==5) {
				 choose(5);
				 }
		     
		}
		if(pack ==2 && usingpackage==true) {
			if(choose2 ==1) {
			     usebottle(1);
			 }
			if(choose2 == 2) {
				 usebottle(2);
		    }
		     
		}
		if(getMap(level)[x][y]==29) {
			if(choose3 ==1) {
			     choose3(1);
			 }
			if(choose3 ==2) {
			     choose3(2);
			 }
			if(choose3 ==3) {
			     choose3(3);
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
	private void choose3(int i) {
		switch(i) {
		case 1 :
			if(hero.money>=100) {
			ischoose = false;
    	    shopping = false;
    	    canmove = true;
    	    hero.upgrade();
    	    }else {
    	    	System.out.println("No money!!!");
    	    }
    	    break;
		case 2 :
			if(hero.money>=100) {
			ischoose = false;
    	    shopping = false;
    	    canmove = true;
			hero.attack = (int) (hero.attack*2.1);
			}else {
				System.out.println("No money!!!");
			}
			break;
		case 3 :
			if(hero.money>=80) {
			ischoose = false;
    	    shopping = false;
    	    canmove = true;
			hero.defence = (int) (hero.defence*2);
			}else {
				System.out.println("No money!!!");
			}
			break;
			
		default :
			break;
		}  
		
	}

	private void usebottle(int i) {
		if(i==1) {
			if(hero.redbottle==0) {
			    System.out.println("no redbotttle");
			    hero.printstate();
			}else {
			hero.hp = hero.hp+300;
			hero.redbottle = hero.redbottle-1;
			hero.printstate();
			}
		}
		if(i==2) {
			if(hero.bluebottle==0) {
			    System.out.println("no bluebotttle");
			    hero.printstate();
			}else {
			hero.hp = hero.hp+500;
			hero.bluebottle = hero.bluebottle-1;
			hero.printstate();
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
			if(usingpackage) {
				choose2 = choose2+1;
				if(choose2 == 3 ) {
					choose2 = 1;
				}
			}
			if(shopping) {
				choose3 = choose3+1;
			}
			break;
			
		default :
			break;
		}
		
		
	}
	private void choose(int event) {
		switch(event) {
		case 1 :
			ischoose = false;
    	    showfly = false;
    	    canmove = true;
    	    level = 1;
    	    x= 13;
        	y= 13;
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
			level = 1;
    	    x= 6;
        	y= 7;
		case 4 :
			ischoose = false;
    	    showfly = false;	
			canmove = true;
			level = 2;
    	    x= 8;
        	y= 7;
		case 5 :
			ischoose = false;
    	    showfly = false;	
			canmove = true;
			level = 3;
    	    x= 2;
        	y= 13;
			break;
		default :
			break;
		}
	}
	private void openPackage(int e) {
		switch(e) {
		case 1:
			pack = 2;
			usingpackage = true;
			canmove = false;
			break;
		case 2:
			pack = 1;
			usingpackage = false;
			canmove = true;
			break;	
		
	default :
		break;
		}
		
	}
	private boolean isAllow(int x,int y) {
		if(getMap(level)[x][y]==1||getMap(level)[x][y]==27) {
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
		
		}
		if(getMap(level)[x][y]==15) {		
			hero.changebottle(15);	
			getMap(level)[x][y]=0;
		}
		if(getMap(level)[x][y]==16) {		
			hero.changebottle(16);	
			getMap(level)[x][y]=0;
		}
		if(getMap(level)[x][y]==29) {		
			shop();
		
		}
		
		return true;
	}

	
	private void shop() {
		JOptionPane.showMessageDialog(this,"You can buy something");	   
	    ischoose = true;
	    shopping = true;	
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