import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.border.LineBorder;

public class GUI {

	
	// set up variables to be used within the class these are controlling GUI objects that need to be accessible
	// across the application 
	private JFrame frame;
	private JTextField itemnum;
	public DefaultTableModel listmodel;
	
	// this list will control the cost of the items that have been selected
		private	List<Double> costings = new ArrayList<Double>();
	
	// this controls the total and will track the cost of the items across the program 
	public double total = 0;
	private JTable ProductList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// this method controls the adding of items to cart, I have followed dry and abstracted 
	// allowing values to be added
	// this works by adding the item to the tables list model with the name and costing
	// then update the onscreen list model to show the item on screen
	private void Add_To_Cart(String Item_Name, String Pricing)
	{
		listmodel.addRow(new Object[]{Item_Name, Pricing});
		ProductList.setModel(listmodel);
		costings.add(Double.parseDouble(Pricing));
	}
	

	private void initialize() {
		
		
		
		// this sets up the numerical format that is outputed as 2DP as it is monetary 
	 DecimalFormat Decimalformat = new DecimalFormat("0.00");

	 
	 // set up the GUI objects  shown on screen and place them on the created panel
	 // this could be improved by using dynamic lists 
		frame = new JFrame();
		frame.setBounds(100, 100, 597, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SKU Code");
		lblNewLabel.setBounds(24, 385, 75, 14);
		panel.add(lblNewLabel);
		
		itemnum = new JTextField();
		itemnum.setBounds(82, 382, 146, 20);
		panel.add(itemnum);
		itemnum.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit SKU");
		
		btnNewButton.setBounds(82, 413, 146, 23);
		panel.add(btnNewButton);
		 listmodel = new DefaultTableModel();
		 listmodel.addColumn("Item"); 
		 listmodel.addColumn("Price"); 
		 
		JButton TotalUp = new JButton("Check Out");
		TotalUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		TotalUp.setBounds(328, 413, 179, 37);
		panel.add(TotalUp);
		
		JLabel lblNewLabel_1 = new JLabel("Sub-Total");
		lblNewLabel_1.setBounds(358, 344, 75, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total");
		lblNewLabel_1_1_1.setBounds(358, 369, 46, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel SubTotal = new JLabel("0");
		SubTotal.setBounds(430, 344, 46, 14);
		panel.add(SubTotal);
		
		JLabel Total = new JLabel("0");
		Total.setBounds(430, 369, 46, 14);
		panel.add(Total);
		
		JPanel ItemAPanel = new JPanel();
		
		ItemAPanel.setBackground(new Color(255, 128, 0));
		ItemAPanel.setBounds(24, 21, 85, 86);
		panel.add(ItemAPanel);
		
		JLabel lblNewLabel_2 = new JLabel("item A");
		ItemAPanel.add(lblNewLabel_2);
		
		JPanel ItemBPanel = new JPanel();
		
		
		
		ItemBPanel.setBackground(new Color(255, 128, 0));
		ItemBPanel.setBounds(143, 21, 85, 86);
		panel.add(ItemBPanel);
		
		JLabel lblNewLabel_2_1 = new JLabel("item B");
		ItemBPanel.add(lblNewLabel_2_1);
		
		ProductList = new JTable();
		ProductList.setFillsViewportHeight(true);
		ProductList.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		ProductList.setCellSelectionEnabled(true);
		ProductList.setBounds(298, 21, 233, 243);
		panel.add(ProductList);
		
		JPanel ItemCPanel = new JPanel();
	
		ItemCPanel.setBackground(new Color(255, 128, 0));
		ItemCPanel.setBounds(24, 118, 85, 86);
		panel.add(ItemCPanel);
		
		JLabel ItemC = new JLabel("item C");
		ItemCPanel.add(ItemC);
		
		JPanel ItemDPanel = new JPanel();
		
		ItemDPanel.setBackground(new Color(255, 128, 0));
		ItemDPanel.setBounds(143, 118, 85, 86);
		panel.add(ItemDPanel);
		
		JLabel lblNewLabel_2_3 = new JLabel("item D");
		ItemDPanel.add(lblNewLabel_2_3);
		
		JPanel ItemEPanel = new JPanel();
		
		ItemEPanel.setBackground(new Color(255, 128, 0));
		ItemEPanel.setBounds(24, 226, 85, 86);
		panel.add(ItemEPanel);
		
		JLabel ItemELabel = new JLabel("item E");
		ItemEPanel.add(ItemELabel);
		
		JPanel ItemAPanel_4 = new JPanel();
		ItemAPanel_4.setBackground(new Color(255, 128, 0));
		ItemAPanel_4.setBounds(143, 226, 85, 86);
		panel.add(ItemAPanel_4);
		
		
		// this controls the onscreen button for Item A in the actual program this would be dynamically created 
					// I would also dynamically create the GUI objects on screen allowing it to scale to the size of the 
					// items in the database 
					// from a data base system allowing it be easily updated and cascaded across the entire 
		
		
		final String[][] arr = {{"A","50"},{"B", "30"},{"C", "20"},{"D", "15"},{"E", "5"}};
		JPanel[] GUIObjects = {ItemAPanel,ItemBPanel,ItemCPanel,ItemDPanel,ItemEPanel};
		
		for(int K = 0; K <= GUIObjects.length - 1; K++) {
			
			final int selitem = K;
			GUIObjects[K].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Add_To_Cart(arr[selitem][0], arr[selitem][1]);
				
				}
			
			
			});
			
		}
		
		
		// this event listener controls the total up of the program and is fired when total is pressed
		
		TotalUp.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				try  // try catch ensures that there are no crashes and will show an error message on screen to the user 
				
				{
					// first it finds the flat sub total of the selected items without any savings 
				total = 0;
				costings.forEach( (value) -> {
				
					total += value;
				});
				SubTotal.setText((Decimalformat.format(total)));
				
				
				
				// then it counts the number of each item within the cart which will be used to find combination
				// discounts this is rigid in this prototype
				int countvalues[] = {0,0,0,0,0};
								  //A,B,C,D,E
				
			
				for(int i = 0; i < (listmodel.getRowCount()); i++)
				{
					
					
					// use a switch statement as the counter
					// count and store the number of each item
					Object selitem = listmodel.getValueAt(i,0);
				switch (selitem.toString())
				{
				case "A":
					countvalues[0] += 1;
					break;
				case "B":
					countvalues[1] += 1;
					break;
				case "C":
					countvalues[2] += 1;
					break;
				case "D":
					countvalues[3] += 1;
					break;
				case "E":
					countvalues[3] += 1;
					break;
				}
				}
				
				// calculate savings  using selection statements this  would be best to be pulled from a database instead of 
				// hard coded 
				
				
					if(countvalues[0] >= 3) // if there are more than 3 of A apply 3 for 130 by applying a 20 saving
					{
						double offer1saving = Math.floor(countvalues[0]/3)*20; 
						total -= offer1saving;
			
						
					}
					if(countvalues[1] <= 2) // if there are more than 2 of B apply 2 for 45 by applying a 15 saving
					{
						double offer2saving = Math.floor(countvalues[1]/2)*15; 
						total -= offer2saving;
						
					}
					if(countvalues[2] >= 2) // if there are more than 3 of A apply 3 for 130 by applying a 20 saving
					{
						double offer3saving = 0;
						if(countvalues[2] >= 3) // first check how many groups of 3
						 offer3saving = Math.floor(countvalues[2]/3)*10; 
						total -= offer3saving;
						
						if(countvalues[2]%3 == 2 ) // then calculate the remainder to give a saving of 2 on the total
						{
							total -= 2;
					}
						
						
				}
					if(countvalues[3] >= 1 & countvalues[0] >= 1) // if there are atleast 1 A and D then apply a saving of 10 for each occurance
					{
						int diff = Integer.valueOf(countvalues[3]).compareTo(Integer.valueOf(countvalues[0])) ;
						
						if(diff == 0) // 1 means the numbers are the same and there are no differences so it is a 1:1 Ratio 
						{
						
						total -= countvalues[3] * 10;
						
						}
						else if(diff <= 0) // 1 means the numbers are the same and there are no differences so it is a 1:1 Ratio 
						{
							
						total -= ((diff * 1) + 1) * 10;
						
						}
						
					}
				Total.setText(Double.toString(total));	
				}
				catch(Exception ERR)
				{
					JOptionPane.showMessageDialog(null, ERR.toString());
				}
			
		}});
		
		
		// this  allows SKU codes to manually entered into the system
btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				boolean success = tryparse(itemnum.getText(),false); // test the value if it is valid as it should onlyinclude numerical values e.g barcodes
				
				// in this version 
				// A = 1 
				// B = 2
				// C= 3 
				// D =4 
				// E = 5
				if(success) // if it is a valid integer then submit the SKU
				{
					// store the SKU code and reduce by 1 to adjust to the array size
				
					int sku = Integer.parseInt(itemnum.getText()) - 1;
					itemnum.setText(""); // reset the box to blank for usability
					try { // try adding to the row from the array however this may not be valid so catch with an error message
						
						
						
						Add_To_Cart(arr[sku][0],arr[sku][1]);
						
					}
					catch (Exception ERR){
						JOptionPane.showMessageDialog(null, "Unknown SKU code, check that your SKU is valid");
					}
					
					
				}
				else // otherwise advise on issues
				{
					JOptionPane.showMessageDialog(null, "You have not entered a valid SKU code ensure that it does not include symbols or letters");
				}
			
				
		
			}

			
			// this method tests if a input is a integer
			private boolean tryparse (String testvalue, boolean defaultvalue )
			{
				try
				{
				 Integer.parseInt(testvalue); // try to convert to float 
				 return true; // if it is possible return true as a valid number
		    } 
			catch (NumberFormatException e) {
		        return false; // otherwise return false 
		    }
			}
		});
	}
}
