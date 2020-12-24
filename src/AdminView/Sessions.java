/*
 * Sessions.java
 *
 * Created on __DATE__, __TIME__
 */

package AdminView;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

import model.Admin;

/**
 *
 * @author  __USER__
 */
public class Sessions extends javax.swing.JFrame {
	private Object[][] obj = new Admin().showsessions();

	/** Creates new form Sessions */
	public Sessions() {
		initComponents();
		this.setLocationRelativeTo(null);
		obj = new Admin().showsessions();
		title();
	}

	public void title() {
		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(obj,
						new String[] { "播放编号", "影厅名", "放映电影", "放映时间", "大厅容量",
								"播放时长" }));
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jButton7 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null } }, new String[] {
						"播放编号", "影厅名", "放映电影", "放映时间", "大厅容量", "播放时长" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton1.setText("\u4e0a\u6620\u7535\u5f71");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton2.setText("\u5220\u9664\u4e0a\u6620");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton3.setText("\u4fee\u6539\u4e0a\u6620");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton4.setText("\u8fd4\u56de\u767b\u5f55");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton5.setText("\u9000\u51fa");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton6.setText("\u8fd4\u56de\u4e3b\u754c\u9762");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton7.setText("\u641c\u7d22");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel1
				.setText("\u8bf7\u8f93\u5165\u7535\u5f71\u540d\u6216\u5927\u5385\u540d\uff1a");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				851,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				30,
																				30,
																				30)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jButton3)
																						.addComponent(
																								jButton1)
																						.addComponent(
																								jButton2)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				101,
																				101,
																				101)
																		.addComponent(
																				jButton4)
																		.addGap(
																				140,
																				140,
																				140)
																		.addComponent(
																				jButton5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				98,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				179,
																				179,
																				179)
																		.addComponent(
																				jButton6))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				62,
																				62,
																				62)
																		.addComponent(
																				jLabel1)
																		.addGap(
																				42,
																				42,
																				42)
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				347,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				54,
																				54,
																				54)
																		.addComponent(
																				jButton7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				96,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(32, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																41,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																45,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																36,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				75,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				92,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				75,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				81,
																				81,
																				81)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				75,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																394,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																60,
																Short.MAX_VALUE)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																60,
																Short.MAX_VALUE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																60,
																Short.MAX_VALUE))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		String msg = this.jTextField1.getText();
		obj = new Admin().SessionsSearch(msg);
		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(obj,
						new String[] { "播放编号", "影厅名", "放映电影", "放映时间", "大厅容量",
								"播放时长" }));
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTable1.getSelectedRow() != -1) {
			AddSessions add = new AddSessions();
			add.setVisible(true);
			add.changeFilm(obj[jTable1.getSelectedRow()][0].toString(),obj[jTable1.getSelectedRow()][1].toString(),
					obj[jTable1.getSelectedRow()][2].toString(), obj[jTable1
							.getSelectedRow()][3].toString(), obj[jTable1
							.getSelectedRow()][5].toString());
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "请选中其中一行");
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new AddSessions().setVisible(true);
		this.dispose();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int i = jTable1.getSelectedRow();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "请选择一行信息在进行操作");
		} else {
			new Admin().deletesessions(obj[i][0].toString());
			obj = new Admin().showsessions();
			jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
					new String[] { "播放编号", "影厅名", "放映电影", "放映时间", "大厅容量",
							"播放时长" }));

		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		new AdminMain().setVisible(true);
		setVisible(false);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		new AdminLogin().setVisible(true);
		setVisible(false);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Sessions().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}