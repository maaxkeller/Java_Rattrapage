package view;
/**
 * <h1>The Display class</h1>
 * 
 * @author Max Keller
 * @version 1.0
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.IElements;
import model.ITronModel;



@SuppressWarnings("deprecation")

public class Panel extends JPanel implements Observer {
	
	/** The serial version. */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	private ITronModel model;
	
	
	public Panel(ITronModel model) {
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		System.out.println("Affichage");
		this.model = model;
		
		model.getGrille().getRider1().addObserver(this);
		model.getGrille().getRider2().addObserver(this);
		
		
		
		
	}
	
	public void drawGrid(Graphics g)throws IOException, InterruptedException {
		
		
		//Rider1
		g.setColor(model.getGrille().getRider1().getColor());
		g.fillRect(
				model.getGrille().getRider1().getX()*model.getGrille().getWidth()/model.getGrille().getNbCellulsWidth(),
				model.getGrille().getRider1().getY()*model.getGrille().getHeight()/model.getGrille().getNbCellulsHeight(),
				model.getGrille().getWidth()/model.getGrille().getNbCellulsWidth(),
				model.getGrille().getHeight()/model.getGrille().getNbCellulsHeight()
				
				);
		//Rider2
		g.setColor(model.getGrille().getRider2().getColor());
		g.fillRect(
				model.getGrille().getRider2().getX()*model.getGrille().getWidth()/model.getGrille().getNbCellulsWidth(),
				model.getGrille().getRider2().getY()*model.getGrille().getHeight()/model.getGrille().getNbCellulsHeight(),
				model.getGrille().getWidth()/model.getGrille().getNbCellulsWidth(),
				model.getGrille().getHeight()/model.getGrille().getNbCellulsHeight()
				
				);
		
		
		
		//Rider1 particles
		for (IElements element : model.getGrille().getRider1().getParticles()) {
			g.setColor(model.getGrille().getRider1().getColor());
			g.fillRect(element.getX()*10, element.getY()*10, 10, 10);
		}
		// rider 2 particles
		for (IElements element : model.getGrille().getRider2().getParticles()) {
			g.setColor(model.getGrille().getRider2().getColor());
			g.fillRect(element.getX()*10, element.getY()*10, 10, 10);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			 try {
				drawGrid(g);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
		//System.out.println("Update");
		
	}

}
