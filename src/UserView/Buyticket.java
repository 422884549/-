/*
 * Buyticket.java
 *
 * Created on __DATE__, __TIME__
 */

package UserView;

import javax.swing.JOptionPane;

import model.Admin;
import AdminView.AddFilm;
import AdminView.AdminMain;

/**
 *
 * @author  __USER__
 */
public class Buyticket extends javax.swing.JFrame {

	/** Creates new form Buyticket */
	public Buyticket() {
		initComponents();
		this.setLocationRelativeTo(null);
		obj = new Admin().showFilm();
		title();
	}

	private Object[][] obj = new Admin().showFilm();

	public void title() {
		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(obj,
						new String[] { "排名", "电影名", "导演", "主演", "时长", "价格",
								"语言", "热度" }));
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jButton4 = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();

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
										null } }, new String[] { "排行", "电影名",
								"导演", "主演", "时长", "价格", "语言", "热度" }));
		jScrollPane1.setViewportView(jTable1);

		jButton2.setText("\u8fd4\u56de\u4e3b\u754c\u9762");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u9000\u51fa");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("\u641c\u7d22\u7535\u5f71");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("\u67e5\u770b");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("\u8d2d\u7968");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

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
										.addGap(62, 62, 62)
										.addComponent(
												jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												349,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(48, 48, 48)
										.addComponent(
												jButton4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												125,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												55, Short.MAX_VALUE)
										.addComponent(
												jButton5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												125,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(57, 57, 57)
										.addComponent(
												jButton6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												125,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(35, 35, 35))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap(706, Short.MAX_VALUE)
										.addComponent(jButton2)
										.addGap(40, 40, 40)
										.addComponent(
												jButton3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												104,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(24, 24, 24))
						.addComponent(jSeparator1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 981,
								Short.MAX_VALUE)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												951, Short.MAX_VALUE)
										.addContainerGap()));
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
																jButton3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																59,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																59,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												13,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(32, 32, 32)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																56,
																Short.MAX_VALUE)
														.addComponent(
																jButton4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																56,
																Short.MAX_VALUE)
														.addComponent(
																jButton5,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																56,
																Short.MAX_VALUE)
														.addComponent(
																jButton6,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																56,
																Short.MAX_VALUE))
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												446,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		new Buyt().setVisible(true);
		setVisible(false);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTable1.getSelectedRow() != -1) {
			Movie add = new Movie();
			add.setVisible(true);
			add.changeFilm(obj[jTable1.getSelectedRow()][1].toString(),
					obj[jTable1.getSelectedRow()][2].toString(), obj[jTable1
							.getSelectedRow()][3].toString(), obj[jTable1
							.getSelectedRow()][4].toString(), obj[jTable1
							.getSelectedRow()][5].toString(), obj[jTable1
							.getSelectedRow()][6].toString(), obj[jTable1
							.getSelectedRow()][7].toString());
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "请选中其中一行");
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		String msg = this.jTextField1.getText();
		obj = new Admin().FilmSearch(msg);
		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(obj,
						new String[] { "排名", "电影名", "导演", "主演", "时长", "价格",
								"语言", "热度" }));
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new UserMain().setVisible(true);
		setVisible(false);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Buyticket().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}