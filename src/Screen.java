import javax.swing.JPanel; // Panel/Frame er et nytt vindu
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/*
 * Let's write english because else the Norsk
 * characters will mess up the text encoding.
 * 
 * Purpose of this class:
 * Provide a screen for our game.
 * We override JPanel functionality.
 */
public class Screen extends JPanel
{
	private Random random = new Random();
	
	public Screen()
	{
		
	}
	
	public void paint(Graphics g)
	{
		System.out.println(random.nextDouble());
		super.paint(g);

	      Graphics2D g2 = (Graphics2D) g;

	      RenderingHints rh =
	            new RenderingHints(RenderingHints.KEY_ANTIALIASING,
	                               RenderingHints.VALUE_ANTIALIAS_ON);

	      rh.put(RenderingHints.KEY_RENDERING,
	             RenderingHints.VALUE_RENDER_QUALITY);

	      g2.setRenderingHints(rh);

	      Dimension size = getSize();
	      double w = size.getWidth();
	      double h = size.getHeight();

	      Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
	      g2.setStroke(new BasicStroke(1));
	      g2.setColor(Color.gray);


	      for (double deg = 0; deg < 360; deg += 5)
	      {
	          AffineTransform at =
	              AffineTransform.getTranslateInstance(w / 2, h / 2);
	          at.rotate(Math.toRadians(deg));
	          g2.draw(at.createTransformedShape(e));
	      }
	}
}
