/*
 * Filmmanage.java
 *
 * Created on __DATE__, __TIME__
 */

package AdminView;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Admin;

/**
 * 
 * @author __USER__
 */
public class Filmmanage extends javax.swing.JFrame {

	/** Creates new form Filmmanage */
	public Filmmanage() {
		initComponents();
		this.setLocationRelativeTo(null);
		obj = new Admin().showFilm();
		title();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton7 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {
								{ null, null, null, null, null, null, null,
										null },
								{ null, null, null, null, null, null, null,
										null },
								{ null, null, null, null, null, null, null,
										null },
								{ null, null, null, null, null, null, null,
										null } }, new String[] { "排名", "电影名",
								"导演", "主演", "时长", "价格", "语言", "热度" }));
		jScrollPane1.setViewportView(jTable1);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton1.setText("\u8fd4\u56de\u767b\u5f55");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton2.setText("\u8fd4\u56de\u4e3b\u754c\u9762");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton3.setText("\u9000\u51fa");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton4.setText("\u6dfb\u52a0\u7535\u5f71");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton5.setText("\u5220\u9664\u7535\u5f71");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton6.setText("\u4fee\u6539\u7535\u5f71");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel1.setText("\u7535\u5f71\u540d\uff1a");

		jButton7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton7.setText("\u641c\u7d22");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				893,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				45,
																				45,
																				45)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButton5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								103,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jButton6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								103,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jButton4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								103,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				118,
																				118,
																				118)
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				103,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				154,
																				154,
																				154)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				108,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				183,
																				183,
																				183)
																		.addComponent(
																				jButton2))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				131,
																				131,
																				131)
																		.addComponent(
																				jLabel1)
																		.addGap(
																				45,
																				45,
																				45)
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				372,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				30,
																				30,
																				30)
																		.addComponent(
																				jButton7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				105,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(31, 31, 31)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																44,
																Short.MAX_VALUE)
														.addComponent(
																jButton7,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																44,
																Short.MAX_VALUE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																44,
																Short.MAX_VALUE))
										.addGap(18, 18, 18)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jButton4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				62,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				122,
																				122,
																				122)
																		.addComponent(
																				jButton5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				62,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				62,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				10,
																				Short.MAX_VALUE)
																		.addGroup(
																				layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jButton2,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								64,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton1,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								64,
																								Short.MAX_VALUE)))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				65,
																				Short.MAX_VALUE)))
										.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		String msg = this.jTextField1.getText();
		obj = new Admin().FilmSearch(msg);
		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(obj,
						new String[] { "排名", "电影名", "导演", "主演", "时长", "价格",
								"语言", "热度" }));

	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		int i = jTable1.getSelectedRow();
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "选中一行后才可删除");
		} else {
			new Admin().Deleteflim(obj[i][1].toString());
			obj = new Admin().showFilm();
			jTable1.setModel(new javax.swing.table.DefaultTableModel(obj,
					new String[] { "排名", "电影名", "导演", "主演", "时长", "价格", "语言",
							"热度" }));
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTable1.getSelectedRow() != -1) {
			AddFilm add = new AddFilm();
			add.setVisible(true);
			add.changeFilm(obj[jTable1.getSelectedRow()][1].toString(),
					obj[jTable1.getSelectedRow()][2].toString(), obj[jTable1
							.getSelectedRow()][3].toString(), obj[jTable1
							.getSelectedRow()][4].toString(), obj[jTable1
							.getSelectedRow()][5].toString(), obj[jTable1
							.getSelectedRow()][6].toString());
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "请选中其中一行");
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		new AddFilm().setVisible(true);
		setVisible(false);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new AdminMain().setVisible(true);
		setVisible(false);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new AdminLogin().setVisible(true);
		setVisible(false);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Filmmanage().setVisible(true);
			}
		});
	}

	public void title() {
		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(obj,
						new String[] { "排名", "电影名", "导演", "主演", "时长", "价格",
								"语言", "热度" }));

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
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables
	private Object[][] obj = new Admin().showFilm();

}