package report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;



public class Report extends Frame {

	private String start;
	private JTable j_t;
	private JTable j_t2;
	private List<String> show_list;
	public static String end;
	private Date date;
	private Properties pro_title;
	private int i;
	private static JTextArea jta1;
	private static JTextArea jta2;
	private static JTextArea jta3;
	private static JTextArea jta4;

	public static String getEnd() {
		return end;
	}

	public static void setEnd(String end) {
		Report.end = end;
	}

	public Report(String end) {
		this.end = end;
	}

	public Report() {
		// 标题
		Panel title = new Panel();
		Label l_title = new Label("XXOL服务器技术周报");
		title.add(l_title);
		title.setBounds(230, 30, 150, 25);

		// 周报信息
		Panel table = new Panel();
		String[] t_head = { "", "", "", "" };
		Object[][] t_message = { { "制定者", "制定时间", "当前版本", "版本说明" },
				{ "xxx", "2014-1-13", "Beta(v0.1)", "初稿" } };
		JTable j_message = new JTable(t_message, t_head) {
			public boolean isCellEditable(int row, int column) {

				if (column == 0 || column == 1 || column == 2 || column == 3
						|| column == 4) {
					return false;
				} else if (row == 0 || row == 1) {
					return false;
				} else {
					return true;
				}
			}
		};
		DefaultTableCellRenderer dtr = new DefaultTableCellRenderer(); // 内容居中
		dtr.setHorizontalAlignment(SwingConstants.CENTER);
		j_message.setDefaultRenderer(Object.class, dtr);
		for (int i = 0; i < 2; i++) {
			j_message.setRowHeight(15);
		}
		
		table.add(j_message);
		table.setBounds(160, 50, 300, 35);

		Panel gzzb = new Panel(); // 工作周报
		Label l_g = new Label("工作周报");
		gzzb.add(l_g);
		gzzb.setBounds(250, 100, 120, 25);

		// 表格
		DefaultTableModel dtm = new DefaultTableModel();

		JPanel jtable = new JPanel();

		

		String[] c_n2 = { "" };
		Object[][] data2 = new Object[][] { { "我的本周工作进度" },
				{ "我遇到问题及解决方案"}, { "我的下周工作安排" }, { "我想说的话" } };
		j_t2 = new JTable(data2, c_n2) {
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {
					return false;
				} else {
					return true;
				}

			}
		};

		j_t2.setDefaultRenderer(Object.class, dtr);
		j_t2.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

		// for (int i = 0; i < 3; i++) {
		// TableColumn tc = j_t.getColumnModel().getColumn(i);
		// tc.setPreferredWidth(195);
		// }
		// j_t.setRowHeight(0, 50);

		TableColumn tc2 = j_t2.getColumnModel().getColumn(0);
		tc2.setPreferredWidth(200);

//		TableColumn tc3 = j_t2.getColumnModel().getColumn(1);
//		tc3.setPreferredWidth(462);
		for (int i = 0; i < 4; i++) {
			j_t2.setRowHeight(i, 136);
		}

		

		
//		

		// jtable.add(jdate);
//		jtable.add(jdate2);
		// jtable.add(j_t.getTableHeader());
		// jtable.add(j_t);
		jtable.add(j_t2);

		jtable.setBounds(6, 170, 200, 550);
		
		//日期选择
		JPanel jpanel_date=new JPanel();
		JButton jdate2 = new JButton("结束日期");
		jdate2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
				final DateChooser mp = new DateChooser("yyyy-MM-dd");

				JFrame jf = new JFrame();
				jf.setResizable(false);
				jf.add(mp, BorderLayout.CENTER);
				jf.pack();
				jf.setLocationRelativeTo(null);
				jf.setVisible(true);
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		jpanel_date.add(jdate2);
//		jpanel_date.setBackground(Color.WHITE);
		jpanel_date.setBounds(5, 134, 599, 40);
		
		//文本输入区
		jta1=new JTextArea();
		JScrollPane jsp=new JScrollPane(jta1);
		jsp.setBounds(205, 175, 400, 137);
		
		jta2=new JTextArea();
		JScrollPane jsp2=new JScrollPane(jta2);
		jsp2.setBounds(205, 310, 400, 138);

		jta3=new JTextArea();
		JScrollPane jsp3=new JScrollPane(jta3);
		jsp3.setBounds(205, 446, 400, 138);
		
		jta4=new JTextArea();
		JScrollPane jsp4=new JScrollPane(jta4);
		jsp4.setBounds(205, 582, 400, 138);
		
		
		Panel p_button = new Panel();
		JButton send = new JButton("发送");

		send.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				show_list = new ArrayList<String>();
				Properties pro = new Properties();
				// Properties pro2 = new Properties();
				InputStream is = null;
				try {
					is = new BufferedInputStream(new FileInputStream(
							"D:\\staff.properties"));

					// InputStream isdate = new BufferedInputStream(
					// new FileInputStream("C:\\date.properties"));
					pro.load(is);
					// pro2.load(isdate);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				

				Calendar c = Calendar.getInstance();
				try {
					date=sdf.parse(end);
					c.setTime(date);	
					c.add(Calendar.DAY_OF_MONTH, -1);
					
					
					c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//获取当前星期的周一
					start=sdf.format(c.getTime());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				show_list.add(pro.getProperty("name"));
				show_list.add(start);
				show_list.add(end);
				show_list.add(jta1.getText());
				show_list.add(jta2.getText());
				show_list.add(jta3.getText());
				show_list.add(jta4.getText());

				XmlWord word = new XmlWord();
				word.outword(show_list);
				try {
					new JEmail().send(pro.getProperty("name") + "_XXOL_服务器技术周报");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		// p_button.add(show);
		p_button.add(send);
		p_button.setBounds(70, 745, 460, 55);

		this.add(jsp4);
		this.add(jsp3);
		this.add(jsp2);
		this.add(jsp);
		this.add(jpanel_date);
		this.add(title);
		this.add(table);
		this.add(gzzb);
		this.add(jtable);
		this.add(p_button);

		
		
		
		this.setLayout(null);
		this.setSize(610, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pro_title = new Properties();
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(
					"D:\\staff.properties"));
			pro_title.load(is);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setTitle("XXOL服务器技术周报_欢迎" + pro_title.getProperty("name") + "使用");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		File file = new File("D:\\staff.properties");
		if (!file.exists()) {
			profile pro = new profile();
			pro.out();
		} else {
			new Report();
		}
	}

}
