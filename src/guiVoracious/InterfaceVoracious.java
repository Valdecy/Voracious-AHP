package guiVoracious;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import matrixAHP.Logic_GeometricMean;
import matrixAHP.Logic_MeanNormalization;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class InterfaceVoracious {

	public  static int Adjusted_Matrix = -1;
	public  static int Matrix_Size = 9;
	public  static int Deriving_Weigths = 0;
	public  static int Reduce = 0;
	private static JTable table_Original;
	public static JTable table_Adjusted;
	private static final ButtonGroup buttonGroup_Criteria = new ButtonGroup();
	private static final ButtonGroup buttonGroup_EV = new ButtonGroup();
	public static JTextField textField_0;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_7;
	public static JTextField textField_8;
	public static JTextField textField_9;
	public static JTextField textField_10;
	public static JTextField textField_11;
	public static JTextField textField_12;
	public static JTextField textField_13;
	public static JTextField textField_14;
	public static JTextField textField_15;
	public static JTextField textField_16;
	public static JTextField textField_17;
	public static JTextField textField_18;
	public static JTextField textField_19;
	public static JTextField textField_20;

    public static void main(String[] args) {
    	try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}

		JFrame f = new JFrame("A JFrame");
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setTitle("Voracious-AHP - github.com/Valdecy");
		f.setSize(899, 562);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
		f.setResizable(false);	
		
		JPanel panel_Original = new JPanel();
		panel_Original.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_Original.setForeground(new Color(0, 0, 0));
		panel_Original.setBackground(Color.WHITE);
		panel_Original.setBounds(10, 11, 269, 249);
		f.getContentPane().add(panel_Original);
		panel_Original.setLayout(null);
		
		JLabel lblNumberOfCriteria = new JLabel("Number of Criteria:");
		lblNumberOfCriteria.setVerticalAlignment(SwingConstants.TOP);
		lblNumberOfCriteria.setBounds(10, 11, 166, 23);
		panel_Original.add(lblNumberOfCriteria);
		
		JRadioButton rdbtnMeanNormalization = new JRadioButton("Mean Normalization");
		buttonGroup_EV.add(rdbtnMeanNormalization);
		rdbtnMeanNormalization.setBounds(10, 156, 119, 23);
		panel_Original.add(rdbtnMeanNormalization);
		rdbtnMeanNormalization.setSelected(true);
		rdbtnMeanNormalization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deriving_Weigths = 0;
			}
		});
		JRadioButton rdbtnGeometricMean = new JRadioButton("Geometric Mean");
		buttonGroup_EV.add(rdbtnGeometricMean);
		rdbtnGeometricMean.setBounds(141, 156, 119, 23);
		panel_Original.add(rdbtnGeometricMean);
		rdbtnGeometricMean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deriving_Weigths = 1;
			}
		});
		
		class CellRenderer extends DefaultTableCellRenderer {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public CellRenderer() {
				super();
			}
			public Component getTableCellRendererComponent(JTable table, Object value,
					boolean isSelected, boolean hasFocus, int row, int column) {
				this.setHorizontalAlignment(CENTER);
				return super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
			}
		}
		
		int r = 9;
		int c = 9;
		
		DefaultTableModel model = new DefaultTableModel(r + 1, c + 1);
				
		JScrollPane scrollPane_Original = new JScrollPane();
		scrollPane_Original.setBounds(380, 11, 502, 252);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		DefaultCellEditor judgments = new DefaultCellEditor(comboBox);
		comboBox.addItem("1/9");
		comboBox.addItem("1/8");
		comboBox.addItem("1/7");
		comboBox.addItem("1/6");
		comboBox.addItem("1/5");
		comboBox.addItem("1/4");
		comboBox.addItem("1/3");
		comboBox.addItem("1/2");
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		
		table_Original = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int column)
			{
				Object value = getValueAt(row, column);
				if( (row > 0 && column > 0) && row >= column || "".equals(value)){
					return false;
				}else{
					return true;
				}
			}
			
            public TableCellEditor getCellEditor(int row, int column)
            {
                if (row >= 1 && column >= 1){
                    return (TableCellEditor)judgments;
                }else{
                    return super.getCellEditor(row, column);   
                }
            }

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
			{
				Component c = super.prepareRenderer(renderer, row, column); 
				String type = (String)getModel().getValueAt(row, column);
				Object value = getValueAt(row, column);
				if (type.indexOf("C") >= 0){
					c.setBackground(Color.ORANGE);
					c.setForeground(Color.BLACK);
				}else if ((row > 0 && column > 0) && row >= column){
					c.setBackground(Color.LIGHT_GRAY);
					c.setForeground(Color.BLACK);
				}
				else {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				}
				
				if ( (row > 0 && column > 0) && row == column){
					c.setBackground(Color.BLACK);
					c.setForeground(Color.WHITE);
				}
				if ("".equals(value)){
					c.setBackground(Color.GRAY);
					c.setForeground(Color.WHITE);
				}	
				return c;
			}
		};
		
        table_Original.setModel(model);
		scrollPane_Original.setViewportView(table_Original);
		table_Original.setCellSelectionEnabled(true);
		table_Original.setBackground(Color.WHITE);
		table_Original.setSelectionBackground(Color.BLACK);
		table_Original.setShowVerticalLines(true);
		table_Original.setShowHorizontalLines(true);
		table_Original.setRowHeight(25);	
		table_Original.setDefaultRenderer(Object.class, new CellRenderer());
		table_Original.getTableHeader().setReorderingAllowed(false);
		table_Original.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
		centerRenderer2.setHorizontalAlignment(JLabel.CENTER);
		table_Original.getColumnModel().getColumn(0).setCellRenderer(centerRenderer2);
		table_Original.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		table_Original.setTableHeader(null);
		
		for (int j = 0; j < c + 1; j++){
			table_Original.getColumnModel().getColumn(j).setPreferredWidth(50);
		}
		for (int i = 0; i < table_Original.getRowCount(); i++){		
			for (int j = 0; j < table_Original.getColumnCount(); j++){
				table_Original.getModel().setValueAt("", i, j);
				if (table_Original.getValueAt(i, 0) == ""){
					break;
				}
			}
		}
		table_Original.getModel().setValueAt("Original", 0, 0);	
		for (int i = 1; i < r + 1; i++){
			table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
		}	
		for (int j = 1; j < c + 1; j++){
			table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
		}
		for (int i = 1; i < table_Original.getRowCount(); i++){
			for (int j = 0; j < table_Original.getColumnCount() - 1; j++){
				if (i == j + 1){
					table_Original.getModel().setValueAt("1", i, j + 1);
				}else if(i >= j + 1){
					table_Original.getModel().setValueAt("9", i, j + 1);
				}else{
					table_Original.getModel().setValueAt("1/9", i, j + 1);
				}		
			}
		}	

		String [][] matrix_values = new String [][]{
			{ "1/9", "1/8", "1/7", "1/6", "1/5", "1/4", "1/3", "1/2", "1" },
			{   "9",   "8",   "7",   "6",   "5",   "4",   "3",   "2", "1" }
		};
		
		double [][] matrix_conversion = new double [][]{
			{ 1.0/9.0, 1.0/8.0, 1.0/7.0, 1.0/6.0, 1.0/5.0, 1.0/4.0, 1.0/3.0, 1.0/2.0, 1.0 },
			{     9.0,     8.0,     7.0,     6.0,     5.0,     4.0,     3.0,     2.0, 1.0 }
	    };
	    
		table_Original.getModel().addTableModelListener(new TableModelListener() {
			
	        public void tableChanged(TableModelEvent e) {
	        	model.removeTableModelListener(this);
	        	
	    		for (int i = 1; i < model.getRowCount()-1; i++){
	    			for (int j = i + 1; j < model.getColumnCount(); j++){
	    		        	for (int k = 0; k < matrix_values[0].length; k++){
	    		        		if ((String)model.getValueAt(i, j) == matrix_values[0][k]){
			    					model.setValueAt(matrix_values[1][k], j, i);
	    		        		}
	    		        		if ((String)model.getValueAt(i, j) == matrix_values[1][k]){
			    					model.setValueAt(matrix_values[0][k], j, i);
	    		        		}
	    		        	}		
	    			}
	    		}
        		model.addTableModelListener(this);
	        }

	    });
		
		table_Original.repaint();
		
		DefaultTableModel model2 = new DefaultTableModel(r + 1, c + 1);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		JScrollPane scrollPane_Adjusted = new JScrollPane();
		scrollPane_Adjusted.setBounds(380, 274, 502, 252);
		
		table_Adjusted = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int column)
			{
				Object value = getValueAt(row, column);
				if( (row >= 0 && column >= 0) || "".equals(value)){
					return false;
				}else{
					return true;
				}
			}

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
			{
				Component c = super.prepareRenderer(renderer, row, column); 
				String type = (String)getModel().getValueAt(row, column);
				Object value = getValueAt(row, column);
				if (type.indexOf("C") >= 0){
					c.setBackground(Color.GREEN);
					c.setForeground(Color.BLACK);
				}else if (type.indexOf("*") >= 0){
					c.setBackground(Color.BLUE);
					c.setForeground(Color.WHITE);
				}else if ((row > 0 && column > 0) && row >= column){
					c.setBackground(Color.LIGHT_GRAY);
					c.setForeground(Color.BLACK);
				}
				else {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				}
				
				if ( (row > 0 && column > 0) && row == column){
					c.setBackground(Color.BLACK);
					c.setForeground(Color.WHITE);
				}
				if ("".equals(value)){
					c.setBackground(Color.GRAY);
					c.setForeground(Color.WHITE);
				}	
				return c;
			}
		};
		table_Adjusted.setModel(model2);
		scrollPane_Adjusted.setViewportView(table_Adjusted);
		table_Adjusted.setShowVerticalLines(true);
		table_Adjusted.setShowHorizontalLines(true);
		table_Adjusted.setSelectionBackground(Color.BLACK);
		table_Adjusted.setRowHeight(25);
		table_Adjusted.setCellSelectionEnabled(true);
		table_Adjusted.setBackground(Color.WHITE);
		table_Adjusted.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_Adjusted.setCellSelectionEnabled(true);
		table_Adjusted.setDefaultRenderer(Object.class, new CellRenderer());
		table_Adjusted.getTableHeader().setReorderingAllowed(false);
		DefaultTableCellRenderer centerRenderer3 = new DefaultTableCellRenderer();
		centerRenderer3.setHorizontalAlignment(JLabel.CENTER);
		table_Adjusted.getColumnModel().getColumn(0).setCellRenderer(centerRenderer3);
		table_Adjusted.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		table_Adjusted.setTableHeader(null);
		
	for (int j = 0; j < c + 1; j++){
		table_Adjusted.getColumnModel().getColumn(j).setPreferredWidth(50);
	}	

	for (int i = 0; i < table_Adjusted.getRowCount(); i++){
		for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
			table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
		}
	}	
	
	table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
	table_Adjusted.repaint();
		
	JLabel lblWeightsOriginal = new JLabel("WEIGHTS");
	lblWeightsOriginal.setForeground(Color.YELLOW);
	lblWeightsOriginal.setHorizontalAlignment(SwingConstants.CENTER);
	lblWeightsOriginal.setBackground(Color.WHITE);
	lblWeightsOriginal.setBounds(305, 11, 46, 24);
	
	textField_0 = new JTextField();
	textField_0.setHorizontalAlignment(SwingConstants.CENTER);
	textField_0.setEditable(false);
	textField_0.setBounds(287, 39, 86, 20);
	textField_0.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	textField_1.setEditable(false);
	textField_1.setColumns(10);
	textField_1.setBounds(287, 64, 86, 20);
	
	textField_2 = new JTextField();
	textField_2.setHorizontalAlignment(SwingConstants.CENTER);
	textField_2.setEditable(false);
	textField_2.setColumns(10);
	textField_2.setBounds(287, 89, 86, 20);
	
	textField_3 = new JTextField();
	textField_3.setHorizontalAlignment(SwingConstants.CENTER);
	textField_3.setEditable(false);
	textField_3.setColumns(10);
	textField_3.setBounds(287, 114, 86, 20);
	
	textField_4 = new JTextField();
	textField_4.setHorizontalAlignment(SwingConstants.CENTER);
	textField_4.setEditable(false);
	textField_4.setColumns(10);
	textField_4.setBounds(287, 139, 86, 20);
	
	textField_5 = new JTextField();
	textField_5.setHorizontalAlignment(SwingConstants.CENTER);
	textField_5.setEditable(false);
	textField_5.setColumns(10);
	textField_5.setBounds(287, 164, 86, 20);
	
	textField_6 = new JTextField();
	textField_6.setHorizontalAlignment(SwingConstants.CENTER);
	textField_6.setEditable(false);
	textField_6.setColumns(10);
	textField_6.setBounds(287, 189, 86, 20);
	
	textField_7 = new JTextField();
	textField_7.setHorizontalAlignment(SwingConstants.CENTER);
	textField_7.setEditable(false);
	textField_7.setColumns(10);
	textField_7.setBounds(287, 214, 86, 20);
	
	textField_8 = new JTextField();
	textField_8.setHorizontalAlignment(SwingConstants.CENTER);
	textField_8.setEditable(false);
	textField_8.setColumns(10);
	textField_8.setBounds(287, 239, 86, 20);
	
	JLabel label = new JLabel("WEIGHTS");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setForeground(Color.YELLOW);
	label.setBackground(Color.WHITE);
	label.setBounds(307, 274, 46, 24);
	
	textField_9 = new JTextField();
	textField_9.setHorizontalAlignment(SwingConstants.CENTER);
	textField_9.setEditable(false);
	textField_9.setColumns(10);
	textField_9.setBounds(289, 302, 86, 20);
	
	textField_10 = new JTextField();
	textField_10.setHorizontalAlignment(SwingConstants.CENTER);
	textField_10.setEditable(false);
	textField_10.setColumns(10);
	textField_10.setBounds(289, 327, 86, 20);
	
	textField_11 = new JTextField();
	textField_11.setHorizontalAlignment(SwingConstants.CENTER);
	textField_11.setEditable(false);
	textField_11.setColumns(10);
	textField_11.setBounds(289, 352, 86, 20);
	
	textField_12 = new JTextField();
	textField_12.setHorizontalAlignment(SwingConstants.CENTER);
	textField_12.setEditable(false);
	textField_12.setColumns(10);
	textField_12.setBounds(289, 377, 86, 20);
	
	textField_13 = new JTextField();
	textField_13.setHorizontalAlignment(SwingConstants.CENTER);
	textField_13.setEditable(false);
	textField_13.setColumns(10);
	textField_13.setBounds(289, 402, 86, 20);
	
	textField_14 = new JTextField();
	textField_14.setHorizontalAlignment(SwingConstants.CENTER);
	textField_14.setEditable(false);
	textField_14.setColumns(10);
	textField_14.setBounds(289, 427, 86, 20);
	
	textField_15 = new JTextField();
	textField_15.setHorizontalAlignment(SwingConstants.CENTER);
	textField_15.setEditable(false);
	textField_15.setColumns(10);
	textField_15.setBounds(289, 452, 86, 20);
	
	textField_16 = new JTextField();
	textField_16.setHorizontalAlignment(SwingConstants.CENTER);
	textField_16.setEditable(false);
	textField_16.setColumns(10);
	textField_16.setBounds(289, 477, 86, 20);
	
	textField_17 = new JTextField();
	textField_17.setHorizontalAlignment(SwingConstants.CENTER);
	textField_17.setEditable(false);
	textField_17.setColumns(10);
	textField_17.setBounds(289, 502, 86, 20);
	

	f.getContentPane().setLayout(null);
	f.getContentPane().add(panel_Original);
		
		JRadioButton radioButton_2 = new JRadioButton("2");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 2;
				int c = 2;
				Matrix_Size = 2;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(false);
				textField_3.setVisible(false);
				textField_4.setVisible(false);
				textField_5.setVisible(false);
				textField_6.setVisible(false);
				textField_7.setVisible(false);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(false);
				textField_12.setVisible(false);
				textField_13.setVisible(false);
				textField_14.setVisible(false);
				textField_15.setVisible(false);
				textField_16.setVisible(false);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				
			}
		});
		buttonGroup_Criteria.add(radioButton_2);
		radioButton_2.setBounds(20, 43, 37, 23);
		panel_Original.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 3;
				int c = 3;
				Matrix_Size = 3;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(false);
				textField_4.setVisible(false);
				textField_5.setVisible(false);
				textField_6.setVisible(false);
				textField_7.setVisible(false);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(false);
				textField_13.setVisible(false);
				textField_14.setVisible(false);
				textField_15.setVisible(false);
				textField_16.setVisible(false);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				
			}
		});
		buttonGroup_Criteria.add(radioButton_3);
		radioButton_3.setBounds(81, 43, 37, 23);
		panel_Original.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("4");
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 4;
				int c = 4;
				Matrix_Size = 4;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(false);
				textField_5.setVisible(false);
				textField_6.setVisible(false);
				textField_7.setVisible(false);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(false);
				textField_14.setVisible(false);
				textField_15.setVisible(false);
				textField_16.setVisible(false);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
			}
		});
		buttonGroup_Criteria.add(radioButton_4);
		radioButton_4.setBounds(142, 43, 37, 23);
		panel_Original.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("5");
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 5;
				int c = 5;
				Matrix_Size = 5;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				textField_5.setVisible(false);
				textField_6.setVisible(false);
				textField_7.setVisible(false);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(false);
				textField_15.setVisible(false);
				textField_16.setVisible(false);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
			}
		});
		buttonGroup_Criteria.add(radioButton_5);
		radioButton_5.setBounds(203, 43, 37, 23);
		panel_Original.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("6");
		radioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 6;
				int c = 6;
				Matrix_Size = 6;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(false);
				textField_7.setVisible(false);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(true);
				textField_15.setVisible(false);
				textField_16.setVisible(false);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
			}
		});
		buttonGroup_Criteria.add(radioButton_6);
		radioButton_6.setBounds(20, 86, 37, 23);
		panel_Original.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("7");
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 7;
				int c = 7;
				Matrix_Size = 7;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(true);
				textField_7.setVisible(false);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(true);
				textField_15.setVisible(true);
				textField_16.setVisible(false);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
			}
		});
		buttonGroup_Criteria.add(radioButton_7);
		radioButton_7.setBounds(81, 86, 37, 23);
		panel_Original.add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("8");
		radioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 8;
				int c = 8;
				Matrix_Size = 8;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(true);
				textField_7.setVisible(true);
				textField_8.setVisible(false);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(true);
				textField_15.setVisible(true);
				textField_16.setVisible(true);
				textField_17.setVisible(false);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				
			}
		});
		buttonGroup_Criteria.add(radioButton_8);
		radioButton_8.setBounds(142, 86, 37, 23);
		panel_Original.add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("9");
		radioButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int r = 9;
				int c = 9;
				Matrix_Size = 9;
				
				for (int i = 0; i < table_Original.getRowCount(); i++){
					for (int j = 0; j < table_Original.getColumnCount(); j++){
						table_Original.getModel().setValueAt("", i, j);
						}
					}
				table_Original.getModel().setValueAt("Original", 0, 0);	
				for (int i = 1; i < r + 1; i++){
					table_Original.getModel().setValueAt("C-0" + (i), i, 0);		
				}	
				for (int j = 1; j < c + 1; j++){
					table_Original.getModel().setValueAt("C-0" + (j), 0, j);		
				}
				for (int i = 1; i < r + 1; i++){
					for (int j = 0; j < c; j++){
						if (i == j + 1){
							table_Original.getModel().setValueAt("1", i, j + 1);
						}else if(i >= j + 1){
							table_Original.getModel().setValueAt("9", i, j + 1);
						}else{
							table_Original.getModel().setValueAt("1/9", i, j + 1);
						}		
					}
				}
				
				textField_0.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				textField_3.setVisible(true);
				textField_4.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(true);
				textField_7.setVisible(true);
				textField_8.setVisible(true);
				
				textField_0.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				for (int i = 0; i < table_Adjusted.getRowCount(); i++){
					for (int j = 0; j < table_Adjusted.getColumnCount(); j++){
						table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);		
					}
				}
				table_Adjusted.getModel().setValueAt("Adjusted", 0, 0);
				
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				textField_13.setVisible(true);
				textField_14.setVisible(true);
				textField_15.setVisible(true);
				textField_16.setVisible(true);
				textField_17.setVisible(true);
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				
			}
		});
		buttonGroup_Criteria.add(radioButton_9);
		radioButton_9.setSelected(true);
		radioButton_9.setBounds(203, 86, 37, 23);
		panel_Original.add(radioButton_9);
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setEditable(false);
		textField_18.setBackground(SystemColor.info);
		textField_18.setBounds(154, 210, 86, 20);
		panel_Original.add(textField_18);
		textField_18.setColumns(10);
		
		
		
		JLabel lblDerivingWeigths = new JLabel("Deriving Weigths:");
		lblDerivingWeigths.setVerticalAlignment(SwingConstants.TOP);
		lblDerivingWeigths.setBounds(10, 127, 166, 23);
		panel_Original.add(lblDerivingWeigths);
		f.getContentPane().add(scrollPane_Original);
		f.getContentPane().add(scrollPane_Adjusted);
		f.getContentPane().add(lblWeightsOriginal);
		f.getContentPane().add(textField_0);
		f.getContentPane().add(textField_1);
		f.getContentPane().add(textField_2);
		f.getContentPane().add(textField_3);
		f.getContentPane().add(textField_4);
		f.getContentPane().add(textField_5);
		f.getContentPane().add(textField_6);
		f.getContentPane().add(textField_7);
		f.getContentPane().add(textField_8);
		f.getContentPane().add(label);
		f.getContentPane().add(textField_9);
		f.getContentPane().add(textField_10);
		f.getContentPane().add(textField_11);
		f.getContentPane().add(textField_12);
		f.getContentPane().add(textField_13);
		f.getContentPane().add(textField_14);
		f.getContentPane().add(textField_15);
		f.getContentPane().add(textField_16);
		f.getContentPane().add(textField_17);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 277, 269, 249);
		f.getContentPane().add(panel);
		
		JLabel lblAllowedDeviations = new JLabel("Allowed Adjustment:");
		lblAllowedDeviations.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllowedDeviations.setBounds(10, 33, 119, 36);
		panel.add(lblAllowedDeviations);
		
		JSpinner spinner_AllowedDeviations = new JSpinner();
		spinner_AllowedDeviations.setBounds(154, 41, 86, 20);
		panel.add(spinner_AllowedDeviations);
		spinner_AllowedDeviations.setModel(new SpinnerNumberModel(1, 1, 16, 1));
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setEditable(false);
		textField_19.setBackground(SystemColor.info);
		textField_19.setColumns(10);
		textField_19.setBounds(154, 102, 86, 20);
		panel.add(textField_19);
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setEditable(false);
		textField_20.setBackground(SystemColor.info);
		textField_20.setColumns(10);
		textField_20.setBounds(154, 176, 86, 20);
		panel.add(textField_20);
		
		JButton btnSolve = new JButton("Solve");
		btnSolve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Adjusted_Matrix = 0;
				
				Object[][] getData = new Object[table_Original.getRowCount() - 1][table_Original.getColumnCount() - 1];
				for (int i = 0; i < table_Original.getRowCount() - 1; i++) {
					for (int j = 0; j < table_Original.getColumnCount() - 1; j++){
						getData[i][j] = table_Original.getValueAt(i + 1, j + 1);	
						if (getData[i][j] == null) {
							getData[i][j] = "0";
						} 
					}
				}
				String[][] getString = new String[getData.length][getData[0].length];
				for (int i = 0; i < getData.length; i++) {
					for (int j = 0; j < getData[0].length; j++){
						getString[i][j] = (String)getData[i][j];
						getString[i][j] = getString[i][j].replace(",", ".");	
					}
				}
				double[][] getValue = new double[Matrix_Size][Matrix_Size];
				for (int i = 0; i < Matrix_Size; i++) {
					for (int j = 0; j < Matrix_Size; j++){	
    		        	for (int k = 0; k < matrix_values[0].length; k++){
    		        		if (getString[i][j] == matrix_values[0][k]){
    		        			getValue[i][j] = matrix_conversion[0][k];
    		        			
    		        		}
    		        		if (getString[i][j] == matrix_values[1][k]){
    		        			getValue[i][j] = matrix_conversion[1][k];
    		        		}
    		        	}		
					}
				}
				if (Deriving_Weigths == 0){
					Logic_MeanNormalization.mn_ConsistencyRatio(getValue);
				}else if (Deriving_Weigths == 1){
					Logic_GeometricMean.gm_ConsistencyRatio(getValue);
				}
			}
		});
		
		btnSolve.setBounds(10, 202, 119, 36);
		panel_Original.add(btnSolve);
		
		JButton btnReduce = new JButton("CR < 0.1");
		btnReduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Reduce = 0;
				int deviation = (int) spinner_AllowedDeviations .getValue();
				Adjusted_Matrix = 1;
				
				Object[][] getData = new Object[table_Original.getRowCount() - 1][table_Original.getColumnCount() - 1];
				for (int i = 0; i < table_Original.getRowCount() - 1; i++) {
					for (int j = 0; j < table_Original.getColumnCount() - 1; j++){
						getData[i][j] = table_Original.getValueAt(i + 1, j + 1);	
						if (getData[i][j] == null) {
							getData[i][j] = "0";
						} 
					}
				}
				String[][] getString = new String[getData.length][getData[0].length];
				for (int i = 0; i < getData.length; i++) {
					for (int j = 0; j < getData[0].length; j++){
						getString[i][j] = (String)getData[i][j];
						getString[i][j] = getString[i][j].replace(",", ".");	
					}
				}
				double[][] getValue = new double[Matrix_Size][Matrix_Size];
				for (int i = 0; i < Matrix_Size; i++) {
					for (int j = 0; j < Matrix_Size; j++){	
    		        	for (int k = 0; k < matrix_values[0].length; k++){
    		        		if (getString[i][j] == matrix_values[0][k]){
    		        			getValue[i][j] = matrix_conversion[0][k];
    		        			
    		        		}
    		        		if (getString[i][j] == matrix_values[1][k]){
    		        			getValue[i][j] = matrix_conversion[1][k];
    		        		}
    		        	}		
					}
				}
				Adjusted_Matrix = 2;
				double cr_mn = Logic_MeanNormalization.mn_ConsistencyRatio(getValue);
				double cr_gm = Logic_GeometricMean.gm_ConsistencyRatio(getValue);
				Adjusted_Matrix = 1;
				
				if (Deriving_Weigths == 0 && Matrix_Size == 2){
					Logic_MeanNormalization.mn_ConsistencyRatio(getValue);
					for (int i = 1; i < Matrix_Size + 1; i++){
						for (int j = 1; j < Matrix_Size + 1; j++){
							table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);
						}
					}
				}else if (Deriving_Weigths == 1 && Matrix_Size == 2){
					Logic_GeometricMean.gm_ConsistencyRatio(getValue);
					for (int i = 1; i < Matrix_Size + 1; i++){
						for (int j = 1; j < Matrix_Size + 1; j++){
							table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);
						}
					}
				}
				if (Matrix_Size > 2 && Deriving_Weigths == 0 && cr_mn <= 0.1 ){
					Logic_MeanNormalization.mn_ConsistencyRatio(getValue);
					for (int i = 1; i < Matrix_Size + 1; i++){
						for (int j = 1; j < Matrix_Size + 1; j++){
							table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);
						}
					}
				}else if (Matrix_Size > 2 && Deriving_Weigths == 1 && cr_gm <= 0.1){
					Logic_GeometricMean.gm_ConsistencyRatio(getValue);
					for (int i = 1; i < Matrix_Size + 1; i++){
						for (int j = 1; j < Matrix_Size + 1; j++){
							table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);
						}
					}
				}
				else if (Matrix_Size > 2){
					matrixAHP.Logic_ReduceInconsistency.reduce_inconsistency(getValue, deviation);
				}
			}
		});
		btnReduce.setBounds(10, 94, 119, 36);
		panel.add(btnReduce);
		
		JButton btnReduce_1 = new JButton("CR = 0.0");
		btnReduce_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reduce = 1;
				int deviation = (int) spinner_AllowedDeviations .getValue();
				Adjusted_Matrix = 1;
				
				Object[][] getData = new Object[table_Original.getRowCount() - 1][table_Original.getColumnCount() - 1];
				for (int i = 0; i < table_Original.getRowCount() - 1; i++) {
					for (int j = 0; j < table_Original.getColumnCount() - 1; j++){
						getData[i][j] = table_Original.getValueAt(i + 1, j + 1);	
						if (getData[i][j] == null) {
							getData[i][j] = "0";
						} 
					}
				}
				String[][] getString = new String[getData.length][getData[0].length];
				for (int i = 0; i < getData.length; i++) {
					for (int j = 0; j < getData[0].length; j++){
						getString[i][j] = (String)getData[i][j];
						getString[i][j] = getString[i][j].replace(",", ".");	
					}
				}
				double[][] getValue = new double[Matrix_Size][Matrix_Size];
				for (int i = 0; i < Matrix_Size; i++) {
					for (int j = 0; j < Matrix_Size; j++){	
    		        	for (int k = 0; k < matrix_values[0].length; k++){
    		        		if (getString[i][j] == matrix_values[0][k]){
    		        			getValue[i][j] = matrix_conversion[0][k];
    		        			
    		        		}
    		        		if (getString[i][j] == matrix_values[1][k]){
    		        			getValue[i][j] = matrix_conversion[1][k];
    		        		}
    		        	}		
					}
				}
				
				if (Deriving_Weigths == 0 && Matrix_Size == 2){
					Logic_MeanNormalization.mn_ConsistencyRatio(getValue);
					for (int i = 1; i < Matrix_Size + 1; i++){
						for (int j = 1; j < Matrix_Size + 1; j++){
							table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);
						}
					}
				}else if (Deriving_Weigths == 1 && Matrix_Size == 2){
					Logic_GeometricMean.gm_ConsistencyRatio(getValue);
					for (int i = 1; i < Matrix_Size + 1; i++){
						for (int j = 1; j < Matrix_Size + 1; j++){
							table_Adjusted.getModel().setValueAt(table_Original.getValueAt(i, j), i, j);
						}
					}
				}
				if (Matrix_Size > 2){
					matrixAHP.Logic_ReduceInconsistency.reduce_inconsistency(getValue, deviation);
				}	
			}
		});
		btnReduce_1.setBounds(10, 168, 119, 36);
		panel.add(btnReduce_1);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}