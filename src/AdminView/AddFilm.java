/*
 * AddFilm.java
 *
 * Created on __DATE__, __TIME__
 */

package AdminView;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Admin;
import model.Film;
import model.User;

/**
 * 
 * @author __USER__
 */
public class AddFilm extends javax.swing.JFrame {

	/** Creates new form AddFilm */
	public AddFilm() {
		initComponents();
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jSeparator1 = new javax.swing.JSeparator();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jTextField6 = new javax.swing.JTextField();
		jButton4 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel1.setText("\u7535\u5f71\u540d\uff1a");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel2.setText("\u5bfc\u6f14\uff1a");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel3.setText("\u4e3b\u6f14\uff1a");

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel4.setText("\u4ef7\u683c\uff1a");

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel5.setText("\u65f6\u957f\uff1a");

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jLabel6.setText("\u8bed\u8a00\uff1a");

		jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton1.setText("\u9009\u62e9\u56fe\u7247");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton2.setText("\u8fd4\u56de");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton3.setText("\u786e\u5b9a\u6dfb\u52a0");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15));
		jButton4.setText("\u9000\u51fa");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
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
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				89,
																				89,
																				89)
																		.addComponent(
																				jLabel7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				164,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				78,
																				78,
																				78)
																		.addComponent(
																				jButton1))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				59,
																				59,
																				59)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												76,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												102,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel3,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																76,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel5))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jTextField5,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																102,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jTextField3,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																102,
																																javax.swing.GroupLayout.PREFERRED_SIZE))))
																		.addGap(
																				85,
																				85,
																				85)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												jLabel2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												76,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												jLabel4,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												76,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jLabel6))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField6)
																						.addComponent(
																								jTextField4)
																						.addComponent(
																								jTextField2,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								102,
																								Short.MAX_VALUE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				70,
																				70,
																				70)
																		.addComponent(
																				jButton2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				117,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				152,
																				152,
																				152)
																		.addComponent(
																				jButton3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				114,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(68, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup()
										.addContainerGap(517, Short.MAX_VALUE)
										.addComponent(jButton4)).addGroup(
								jPanel1Layout.createSequentialGroup().addGap(
										32, 32, 32).addComponent(jSeparator1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										503,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(45, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
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
																										.addGap(
																												167,
																												167,
																												167)
																										.addComponent(
																												jButton1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												43,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jButton4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								39,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				36,
																				36,
																				36))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				194,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)))
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												17,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																34,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																34,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																34,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																34,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(43, 43, 43)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(70, 70, 70)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																49,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																49,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(33, Short.MAX_VALUE)));

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
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jButton3.getText().equals("确定添加")) {
			if (!f.equals(null)) {
				new Admin().setNewFilm(jTextField1.getText(), jTextField2
						.getText(), jTextField3.getText(), Float
						.parseFloat(jTextField4.getText()),
						f.getAbsolutePath(), jTextField6.getText(), jTextField5
								.getText());
				this.dispose();
				new Filmmanage().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "您还没有上传电影海报");
			}
		} else if (jButton3.getText().equals("确定修改")) {
			if (f != null) {
				new Admin().setLastFilm(jTextField1.getText(), jTextField2
						.getText(), jTextField3.getText(), Float
						.parseFloat(jTextField4.getText()),
						f.getAbsolutePath(), jTextField6.getText(), jTextField5
								.getText());

			} else {
				JOptionPane.showMessageDialog(null, "您选择不修改电影海报");
				new Admin().setLastFilm(jTextField1.getText(), jTextField2
						.getText(), jTextField3.getText(), Float
						.parseFloat(jTextField4.getText()), null, jTextField6
						.getText(), jTextField5.getText());
			}
			this.dispose();
			new Filmmanage().setVisible(true);
		}
	}

	public void changeFilm(String fname, String dir, String star, String time,
			String price, String lang) {
		jTextField1.setEnabled(false);
		jTextField1.setText(fname);
		jTextField2.setText(dir);
		jTextField3.setText(star);
		jTextField4.setText(time);
		jTextField5.setText(price);
		jTextField6.setText(lang);
		String path = null;
		try {
			path = new User().getFilmcover(fname);
			Image img = new ImageIcon(path).getImage()
					.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(),
							Image.SCALE_SMOOTH);
			jLabel7.setIcon(new ImageIcon(img));
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		jButton3.setText("确定修改");
	}

	private File f = null;

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		jfc.showOpenDialog(null);
		f = jfc.getSelectedFile();
		if (!f.exists()) {
			JOptionPane.showMessageDialog(this, "图片不存在");
		} else if (!f.getAbsolutePath().endsWith(".jpg")) {
			JOptionPane.showMessageDialog(this, "格式不对");
		} else {
			String path = f.getAbsolutePath();
			Image img = new ImageIcon(path).getImage()
					.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(),
							Image.SCALE_SMOOTH);
			this.jLabel7.setIcon(new ImageIcon(img));
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new Filmmanage().setVisible(true);
		setVisible(false);
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AddFilm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	// End of variables declaration//GEN-END:variables

}