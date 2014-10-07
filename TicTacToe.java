import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
	private static final long serialVersionUID = 4986974156311649169L;
	private static final String FRAME_TITLE = "Tic Tac Toe Game"; // title of the app
	private JPanel pane = new JPanel(new GridBagLayout());
	private GridBagConstraints gbc = new GridBagConstraints();
	private static int dim = 3; // dimension
	private JButton[][] tiles = new JButton[dim][dim];
	private static final int TILE_SIZE = 50; // size of the tile
	private static final int FRAME_WIDTH = TILE_SIZE*dim+8; // width of the app
	private static final int FRAME_HEIGHT = TILE_SIZE*dim+27; // height of the app
	private int turn = 0; // players turn default is 0
	private String[] symbol = {"O", "X"};
	private final int TILE_WIN = 3; // needs 3 tile to win
	private String win_msg = "Player %d wins!"; // message after winning the game
	
	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		
		action:
		for (int y = 0; y < dim; y++)
		{
			for (int x = 0; x < dim; x++)
			{
				if (src == tiles[y][x])
				{
					if (isTileEmpty(x, y))
					{
						setTile(x, y);
						
						if (check(x, y))
						{
							JOptionPane.showMessageDialog(null, String.format(win_msg, (player()+1)));
							tryAgain();
						}
							
						next();
						gameOver();
					}
					else
						JOptionPane.showMessageDialog(null,  "The tile is not empty.");
					
					break action;
				}
			}
		}
	}
	
	private boolean check(int fX, int fY)
	{
		int tile_counter = 0;
		
		// horizontal
		for (int x = fX+1; x < dim; x++)
		{
			if (tiles[fY][x].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		for (int x = fX-1; x >= 0; x--)
		{
			if (tiles[fY][x].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		if (tile_counter >= TILE_WIN-1)
			return true;
		
		tile_counter = 0;
		
		// vertical
		for (int y = fY+1; y < dim; y++)
		{
			if (tiles[y][fX].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		for (int y = fY-1; y >= 0; y--)
		{
			if (tiles[y][fX].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}


		if (tile_counter >= TILE_WIN-1)
			return true;
		
		tile_counter = 0;
		
		// diagonal
		// back
		for (int y = fY+1, x = fX+1; y < dim && x < dim; y++, x++)
		{
			if (tiles[y][x].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		for (int y = fY-1, x = fX-1; y >= 0 && x >= 0; y--, x--)
		{
			if (tiles[y][x].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		tile_counter = 0;
		
		// forward
		for (int y = fY+1, x = fX-1; y < dim && x >= 0; y++, x--)
		{
			if (tiles[y][x].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		for (int y = fY-1, x = fX+1; y >= 0 && x < dim; y--, x++)
		{
			if (tiles[y][x].getText().equals(symbol[player()]))
				tile_counter++;
			else
				break;
		}
		
		if (tile_counter >= TILE_WIN-1)
			return true;
		
		return false;
	}
	
	private int player()
	{
		return turn % 2;
	}
	
	private void reset()
	{
		turn = 0;
		
		for (int y = 0; y < dim; y++)
			for (int x = 0; x < dim; x++)
				tiles[y][x].setText(" ");
	}
	
	private void tryAgain()
	{
		int ta = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Confirmation", JOptionPane.YES_NO_OPTION);
		
		if (ta == JOptionPane.YES_OPTION)
			reset();
		else
			stop();
	}
	
	private void gameOver()
	{
		if (turn == dim*dim)
		{
			JOptionPane.showMessageDialog(null, "Game Over!");
			tryAgain();
		}
	}
	
	private void stop()
	{
		System.exit(0);
	}
	
	private void next()
	{
		turn++;
	}
	
	private void setTile(int x, int y)
	{
		tiles[y][x].setText(symbol[player()]);
	}
	
	private boolean isTileEmpty(int x, int y)
	{
		return tiles[y][x].getText().equals(" ") ? true : false;
	}
	
	public TicTacToe()
	{
		super(FRAME_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pane);
		
		for (int y = 0; y < dim; y++)
		{
			for (int x = 0; x < dim; x++)
			{
				tiles[y][x] = new JButton(" ");
				gbc.gridx = x;
				gbc.gridy = y;
				tiles[y][x].setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
				tiles[y][x].addActionListener(this);
				pane.add(tiles[y][x], gbc);
			}
		}
	}
	
	public static void main(String[] args)
	{
		TicTacToe frame = new TicTacToe();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
	}
}
