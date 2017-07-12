import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.toedter.calendar.JCalendar;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Window;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.*;
import java.text.*;
import javax.swing.ListModel;
import javax.swing.JSlider;

import java.lang.reflect.Array;

import java.util.*; 
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

			public class Word extends JDialog
			{
				DefaultListModel model;
				JList list;
				public Word(DefaultListModel model) {
					
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(0, 0, 972, 717);
					 this.setBounds(100, 100, 286, 263);

					  panel_1.setLayout(null);
					
					getContentPane().setLayout(null);
					panel.setBackground(Color.ORANGE);
					panel.setBounds(0, 298, 140, -298);
					getContentPane().add(panel);
					panel.setLayout(null);
					
					setModal(true);
					setTitle("´Ü¾î ÃÑÁ¤¸®");
					setBounds(100, 100, 393, 263);
					getContentPane().setLayout(null);
					
					JLabel lblNewLabel = new JLabel("\uC624\uB298 \uBCF8 \uB2E8\uC5B4");
					lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 12));
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setBounds(102, 10, 132, 17);
					getContentPane().add(lblNewLabel);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(12, 40, 353, 175);
					getContentPane().add(scrollPane);
					
					list = new JList(model);
					
					scrollPane.setViewportView(list);
					list.setVisible(true);
					
					getContentPane().add(panel);
				}	
				int i;
				int r;
				String temp;
				String t;
				
			    
			    private final JPanel panel = new JPanel();
				
			
						
			   
			}
			
			
			    
			  
			  
			

					
			