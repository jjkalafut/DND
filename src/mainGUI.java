import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class mainGUI extends JFrame {

	
	JMenuBar 		menuBar;
	JMenu			file_menu;
	JMenuItem		save, load, open, exit;
	JMenu			edit_menu;
	JMenuItem		godMode, color;
	JMenu			help_menu;
	JMenuItem		help, contact;
	static mainGUI 		test;
	
	
	public static void main(String[] args) {
		test = new mainGUI();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public mainGUI(){
		super("Dungeons and Dragones 3.5 Character Sheet");
		
		
		Container c = this.getContentPane();
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[]{ 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
		layout.rowHeights = new int[]{ 25, 25, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
		c.setLayout(layout);
		
		menuBar = new JMenuBar();
		mListener ml = new mListener();
		
		file_menu = new JMenu("File");
		save = new JMenuItem("Save      ");
		save.addActionListener(ml);
		file_menu.add(save);
		load = new JMenuItem("Load");
		load.addActionListener(ml);
		file_menu.add(load);
		open = new JMenuItem("Open");
		open.addActionListener(ml);
		file_menu.add(open);
		file_menu.addSeparator();
		exit = new JMenuItem("Exit");
		exit.addActionListener(ml);
		file_menu.add(exit);
		menuBar.add(file_menu);
		
		edit_menu = new JMenu("Edit");
		godMode = new JCheckBoxMenuItem("God Mode");
		godMode.addActionListener(ml);
		edit_menu.add(godMode);
		color = new JMenuItem("Color");
		color.addActionListener(ml);
		edit_menu.addSeparator();
		edit_menu.add(color);
		menuBar.add(edit_menu);
		
		help_menu = new JMenu("Help");
		help = new JMenuItem("Help Document");
		help.addActionListener(ml);
		help_menu.add(help);
		contact = new JMenuItem("Contact");
		contact.addActionListener(ml);
		help_menu.add(contact);
		menuBar.add(help_menu);
		
		GridBagConstraints mc = new GridBagConstraints();
		mc.gridwidth = layout.columnWidths.length;
		mc.fill = GridBagConstraints.HORIZONTAL;
		c.add(menuBar, mc);
		 
		JTabbedPane jtp = new JTabbedPane();
		GridBagConstraints cst = new GridBagConstraints();
		cst.fill = GridBagConstraints.BOTH;
		cst.gridwidth = layout.columnWidths.length;
		cst.gridheight = layout.rowHeights.length - 1;
		cst.gridy = 1;
		c.add(jtp, cst);
		
		JPanel stats = new JPanel();
		stats.setLayout(layout);
		JPanel items = new JPanel();
		items.setLayout(layout);
		JPanel spells = new JPanel();
		spells.setLayout(layout);
		
		jtp.addTab("Stats", stats);
		jtp.addTab("Items", items);
		jtp.addTab("Spells and Feats", spells);
		
		
		setSize(850, 900);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	
	private void colorGui(){
		//color all elements based off of given colors. 
	}
	private class mListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if( e.getSource() == exit){
				test.dispose();
			}
			
		}
		
	}

}
