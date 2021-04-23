/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.FinanceManagerRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Request.MoneyOrder;
import Business.Request.Order;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import UserInterface.DeliveryManRole.OrderDetailsJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZHOU
 */
public class FinanceManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RFinancialWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    float sum;
    
    public FinanceManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem busineSystem) {
        initComponents();
        
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.system = busineSystem;
        this.enterprise = enterprise;
        valueLabel.setText(enterprise.getName());
        populateMoneyOrderJTable();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        moneyOrderJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        valueLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        valueLabel.setText("<value>");

        enterpriseLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Account Balance:");

        txtBalance.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBalance.setEnabled(false);

        moneyOrderJTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        moneyOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Money Request", "Enterprise Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(moneyOrderJTable);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valueLabel)
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addComponent(jButton1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseLabel)
                            .addComponent(valueLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedrow = moneyOrderJTable.getSelectedRow();

        if (selectedrow >= 0) {
            MoneyOrder o = (MoneyOrder) moneyOrderJTable.getValueAt(selectedrow, 0);
            ViewRequestDetailsJPanel jPanel =new ViewRequestDetailsJPanel(userProcessContainer,system,o,enterprise);
                    userProcessContainer.add("ViewRequestDetails", jPanel);
                    CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                    layout.next(userProcessContainer);
        } else
        JOptionPane.showMessageDialog(null, "Please select a request");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable moneyOrderJTable;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

    void populateMoneyOrderJTable() {
        sum=0;
        DefaultTableModel model = (DefaultTableModel) moneyOrderJTable.getModel();
        model.setRowCount(0);
         for(Order order:system.getOrderDirectory().getOrderList()){
            if(order.getStatus().equals("Finished")){
                sum+=order.gettPrice();
            }
        }
        
        for(Network network: system.getNetworkList()){
            for(Enterprise en: network.getEnterpriseDirectory().getEnterpriseList()){
                for(MoneyOrder m :en.getMoneyOrderDirectory().getMoneyOrderList()){
                    
                    Object[] row = new Object[4];
                    row[0] = m;
                    row[1] = m.getMoney();
                    row[2] = m.getName();
                    row[3] = m.getMoneyOrderStatus();
                    
                    model.addRow(row);
                    if(m.getMoneyOrderStatus().equals("Approved")){
                        sum-=m.getMoney();
                        enterprise.setTotalProfit(sum);
                    }
                }
            }
        }
        txtBalance.setText(String.valueOf(enterprise.getTotalProfit()));
        
    }
}
