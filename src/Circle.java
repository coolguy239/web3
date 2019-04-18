/**
 * <pre>
 *  
 *    |_ Circle.java
 * 
 * </pre>
 * 
 * @author : khkim
 * @since : 2019. 2. 28. ���� 11:34:51
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

class CircleFrame extends JFrame{
	
	public static final int panelWidth = 900;
	public static final int panelHeight = 900;
	
	/**
	 * ������ ���̸� �Է� �ȹ޾��� ��� ���Ǵ� �⺻������
	 */
	public CircleFrame(){
        this.setTitle("streami ����1");
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CirclePanel panel = new CirclePanel();
        this.add(panel, BorderLayout.CENTER);
        this.setLocation(0, 0);
        this.setSize(panelWidth, panelHeight);
        this.setVisible(true);
    }
	
	/**
	 * ������ ���̸� �Ķ���ͷ� �Է¹޾��� ��� ���Ǵ� ������ (Frame���� Panel ������ �Ķ���ͷ� radius ����) 
	 */
    public CircleFrame(int radius){
    	this.setTitle("streami ����1");
    	this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CirclePanel panel = new CirclePanel(radius);
        this.add(panel, BorderLayout.CENTER);
        this.setLocation(0, 0);
        this.setSize(panelWidth, panelHeight);
        this.setVisible(true);
    }
    
    class CirclePanel extends JPanel{
    	
    	private int radius;
    	
    	public CirclePanel() {
    		this.radius = 100;		// �⺻�� 100���� ����
    	}
    	public CirclePanel(int radius) {
    		this.radius = radius;
    	}
    	
        public void paintComponent(Graphics g){
        	System.out.println("radius ==> " + radius);
        	int centerX = getWidth()/2;
        	int centerY = getHeight()/2;
        	
            super.paintComponent(g);
            g.setColor(Color.RED);	// ������� ���������� ����
            g.fillArc(centerX - radius/2, centerY - radius/2, radius, radius, 0, 360);	 // ���� ä���� ��
            
            /************************************************** �� ���� ���� �߰� ���� ************************************************/
            int repeats = 360;
            Graphics2D g2d = (Graphics2D)g;
            
            for(int i=0; i<repeats;i ++) {
            	
                g2d.setColor(Color.BLUE);	// ������ ���� �簢���� �Ķ������� ����
            	int angle = 360 / repeats;
            	g2d.setColor(Color.BLUE);
            	Rectangle rect = new Rectangle(centerX - radius/2, centerY - radius/2, radius, radius);
            	g2d.rotate(angle, rect.x + rect.width/2, rect.y + rect.height/2);
            	g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
            	g2d.draw(rect);
            	
            }
            /************************************************** �� ���� ���� �߰� ���� ************************************************/
            
            
        }
    }
}

public class Circle {
	
	public static void draw() {
		 int radius = 0;
         Scanner scan = new Scanner(System.in);      // ���� �Է��� ���ڷ� Scanner ����
         System.out.print("�������� �Է��ϼ���:");
         try {
        	 
        	 radius = Integer.parseInt(scan.nextLine());            // Ű���� ���� �Է�
        	 // ���� ������ �ִ� ũ�⸦ 400���� ����
        	 if(radius > 400) {										// Panel ���� ���� ����� 900���� �ϰ� ���� �߽��� Panel�� 450, 450���� �����ϵ��� ����
        		 System.out.println("Panel�� ũ��� ����,���� ũ��� 900�Դϴ�. ���� �ִ� ������ ũ��� 400�Դϴ�.");
            	 draw();
        	 }else {
        		 new CircleFrame(radius);
        	 }
         }catch(Exception e) {
        	 System.out.println("���ڰ� �ƴϰų� Integer �ִ밪 "+ Integer.MAX_VALUE + "�� �ʰ��߽��ϴ�.");
        	 draw();
        	 
         }
    	
	}
	
    public static void main(String[] args) {
    	draw();
    }
}