package com.cruds.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.cruds.services.DaoServices;

public class JTableDemo extends JFrame  {
	
	JPanel panel;
	JTable table;
	JScrollPane scrollpane;
	JButton btnDel;
	 
	public JTableDemo() {
		setSize(600,600);
		setTitle("JTable Demo");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		DaoServices sdao = new DaoServices();

		panel=new JPanel();
		
		table=new JTable(sdao.getTableData());
		
		scrollpane=new JScrollPane(table);
		
		btnDel=new JButton("delete");
		
		btnDel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				String val=(String)table.getModel().getValueAt(row, 0);
				sdao.delete(Integer.parseInt(val));
				table.setModel(sdao.getTableData());         //(sdao.getAll());
				
			}
			
		});
			
		panel.add(scrollpane);
		panel.add(btnDel);
		add(panel);
		setVisible(true);
		
		
	}

	public void initDemo(){
		// TODO Auto-generated method stub
		Vector<String> row1=new Vector<>();
		row1.add("101");
		row1.add("salim");
		
		Vector<String> row2=new Vector<>();
		row2.add("102");
		row2.add("Rishit");
		
		Vector<String> row3=new Vector<>();
		row3.add("103");
		row3.add("praveen");
	}
		public static void main(String[] args) {
			new JTableDemo();
	}

}



