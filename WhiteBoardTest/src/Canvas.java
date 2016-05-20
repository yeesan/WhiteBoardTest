import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JPanel;



public class Canvas extends JPanel{
	 
	//how to update the shapes?
	ArrayList<DShape> shapes = new ArrayList<>();
	MovingAdapter ma = new MovingAdapter();
	 // may need to use stack/queue to display last on top 
	//list of shape objects and reflectes each after adding and editing..
	//also defines the ordering of the shape as last shape comming first	
	//** may need to be static **
	
	//paintComponent() should loop through all the shapes and draw them.
	public Canvas()
	{
		setBackground(Color.orange);
		setSize(400,400);	//size 400x400
		
	}
	
	 /*
	  *  @param- selected shape to add
	  *  visibility package
	 */
	 void addShapes(DShape delshape)
	{
		// may need to check instance of delshape
		shapes.add(delshape);
	}
	
	void paintComponent()
	{
		System.out.println("-----------------");
		for (DShape dshape : shapes) {
			if (dshape instanceof DRect) {
				System.out.println("DRect");
				dshape.draw(getGraphics());
				addMouseMotionListener(ma);//the mouse listener
			    addMouseListener(ma);//the mouse listener

			} else if (dshape instanceof DOval) {
				System.out.println("DOval");
				dshape.draw(getGraphics());

			}
			/*else if(dshape instanceof DLine)
			{
				System.out.println("DLine");
//				DLine paintShape = new DLine();
//				paintShape = (DLine)shapes.get(i);
//				paintShape.draw(getGraphics());
			}
			else if(dshape instanceof DText)
			{
				System.out.println("DText");
//				DText paintShape = new DText();
//				paintShape = (DText)shapes.get(i);
////				paintShape.draw(getGraphics());
			}*/
			
			else
			{
				System.out.println("Instance error either adding or retriving from List");
			}
		}
	}
	
//called by buttons' action listener
	/*
	 * @param- selected shape to delete
	 */
	 void remove(DShape delshape) //level package
	{
		Iterator<DShape> itr = shapes.iterator();
		if(shapes.contains(delshape))
		{
			
			while(itr.next() != delshape)
			{
				itr.next();
			}
			itr.remove();  // should remove the next element
		}
	}

	 //sort of working
	  class MovingAdapter extends MouseAdapter {

		    private int x;

		    private int y;

		    public void mousePressed(MouseEvent e) {
		      x = e.getX();
		      y = e.getY();
		    }

		    public void mouseDragged(MouseEvent e) {

		      int dx = e.getX() - x;
		      int dy = e.getY() - y;
		      repaint();
		      x += dx;
		      y += dy;

		     /* if (myRect.getBounds2D().contains(x, y)) {
		        myRect.x += dx;
		        myRect.y += dy;
		        repaint();
		      }
		      x += dx;
		      y += dy;*/
		    }
		  }


}
