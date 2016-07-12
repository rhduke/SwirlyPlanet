package theswirlyplanet.main;

import javax.swing.*;
import java.awt.*;

public class BattleLog extends JFrame {
	
	static final int COLUMNS = 3;
	static final int NAME_COL = 0;
	static final int ATB_COL = 1;
	static final int HP_COL = 2;
	
	private BattleQueue que;
    private Party hero;
    private Party enemy;
    private Party all;
	
	private JPanel panel;
	private JLabel[][] grid;
	
	public BattleLog(BattleQueue que, Party hero, Party enemy) {
		this.que = que;
		this.hero = hero;
		this.enemy = enemy;
		this.all = new Party();
        for (int i = 0; i < hero.size(); i++)
            this.all.add(hero.index(i));
        for (int i = 0; i < enemy.size(); i++)
            this.all.add(enemy.index(i));
		initUI();
	}
	
	public void initUI() {
		getContentPane().setLayout(new GridLayout(gridRows(), COLUMNS));
		//this.panel = new JPanel(new);
		this.grid = new JLabel[gridRows()][COLUMNS];
		this.grid[0][NAME_COL] = new JLabel("Unit");
		this.grid[0][ATB_COL] = new JLabel("ATB");
		this.grid[0][HP_COL] = new JLabel("HP");
		for (int i = 1; i < gridRows(); i++) {
			this.grid[i][NAME_COL] = new JLabel(this.all.index(i-1).name());
			this.grid[i][ATB_COL] = new JLabel(this.all.index(i-1).atb().shortString());
			this.grid[i][HP_COL] = new JLabel(this.all.index(i-1).hp() + "");
		}
		for (int i = 0; i < gridRows(); i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (this.grid[i][j] != null)
					getContentPane().add(this.grid[i][j]);
			}
		}
		
		setTitle("Battle Log");
		setSize(200,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void updateATB(int index) {
		this.grid[index + 1][ATB_COL].setText(this.all.index(index).atb().shortString());
	}
	
	public int gridRows() {
		return this.hero.size() + this.enemy.size() + 1;
	}
	
    public void printScreen() {
        System.out.println(hero.toString() + "\n" + enemy.toString() + "\n" + que.toString());
    }
}
