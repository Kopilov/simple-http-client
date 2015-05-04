/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.sasha.simplehttpclient;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 *
 * @author aleksandr
 */
public class MainFrame extends javax.swing.JFrame {

	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() {
		initComponents();
		generateRequestBtn.addActionListener(new GenerateRequestListener(
				urlInputField,
				hostInputField,
				portInputField,
				methodSelect,
				headersTextArea,
				bodyTextArea,
				requestTextArea
		));
		ExecuteQueryListener executeQueryListener = new ExecuteQueryListener(
				hostInputField,
				portInputField,
				requestTextArea,
				new JTextArea[]{responseTextArea1, responseTextArea2},
				new JButton[]{executeQueryBtn1, executeQueryBtn2}
		);
		executeQueryBtn1.addActionListener(executeQueryListener);
		executeQueryBtn2.addActionListener(executeQueryListener);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        responseTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        hostInputField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portInputField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTextArea = new javax.swing.JTextArea();
        executeQueryBtn1 = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        urlInputField = new javax.swing.JTextField();
        methodSelect = new javax.swing.JComboBox<String>();
        generateRequestBtn = new javax.swing.JButton();
        executeQueryBtn2 = new javax.swing.JButton();
        jSplitPane3 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        headersTextArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bodyTextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        responseTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple HTTP client");
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 700));

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(200, 500));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(200, 500));

        responseTextArea1.setColumns(20);
        responseTextArea1.setRows(5);
        jScrollPane1.setViewportView(responseTextArea1);

        jSplitPane1.setBottomComponent(jScrollPane1);

        jPanel4.setMinimumSize(new java.awt.Dimension(164, 100));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(369, 500));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("IP или домен");
        jPanel2.add(jLabel1);

        hostInputField.setMinimumSize(new java.awt.Dimension(140, 19));
        hostInputField.setPreferredSize(new java.awt.Dimension(140, 19));
        jPanel2.add(hostInputField);

        jLabel2.setText("Порт");
        jPanel2.add(jLabel2);

        portInputField.setText("80");
        portInputField.setMinimumSize(new java.awt.Dimension(40, 19));
        portInputField.setPreferredSize(new java.awt.Dimension(40, 19));
        jPanel2.add(portInputField);

        jPanel4.add(jPanel2, java.awt.BorderLayout.NORTH);

        requestTextArea.setColumns(20);
        requestTextArea.setRows(5);
        jScrollPane2.setViewportView(requestTextArea);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        executeQueryBtn1.setText("Выполнить запрос");
        jPanel4.add(executeQueryBtn1, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setLeftComponent(jPanel4);

        jTabbedPane1.addTab("Низкоуровневый", jSplitPane1);

        jSplitPane2.setDividerLocation(400);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setText("URL");

        methodSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GET", "POST", "PUT", "DELETE", " " }));

        generateRequestBtn.setText("Сформировать запрос");

        executeQueryBtn2.setText("Выполнить запрос");

        jSplitPane3.setDividerLocation(300);

        jLabel4.setText("Заголовки");

        headersTextArea.setColumns(20);
        headersTextArea.setRows(5);
        jScrollPane3.setViewportView(headersTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        jSplitPane3.setLeftComponent(jPanel3);

        jLabel5.setText("Тело запроса");

        bodyTextArea.setColumns(20);
        bodyTextArea.setRows(5);
        jScrollPane4.setViewportView(bodyTextArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        jSplitPane3.setRightComponent(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(generateRequestBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(executeQueryBtn2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlInputField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(methodSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSplitPane3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(urlInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(methodSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(generateRequestBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(executeQueryBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jSplitPane2.setTopComponent(jPanel1);

        responseTextArea2.setColumns(20);
        responseTextArea2.setRows(5);
        jScrollPane5.setViewportView(responseTextArea2);

        jSplitPane2.setRightComponent(jScrollPane5);

        jTabbedPane1.addTab("Высокоуровневый", jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("mjj");

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
//		try {
//			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					javax.swing.UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrame().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bodyTextArea;
    private javax.swing.JButton executeQueryBtn1;
    private javax.swing.JButton executeQueryBtn2;
    private javax.swing.JButton generateRequestBtn;
    private javax.swing.JTextArea headersTextArea;
    private javax.swing.JTextField hostInputField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> methodSelect;
    private javax.swing.JTextField portInputField;
    private javax.swing.JTextArea requestTextArea;
    private javax.swing.JTextArea responseTextArea1;
    private javax.swing.JTextArea responseTextArea2;
    private javax.swing.JTextField urlInputField;
    // End of variables declaration//GEN-END:variables
}
