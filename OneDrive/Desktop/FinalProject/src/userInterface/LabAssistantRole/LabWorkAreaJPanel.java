/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.LabAssistantRole;

import Business.Account.Account;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LocalLabOrganization;
import Business.Organization.Organization;
import Business.Role.LabAssistantRole;
import Business.Role.LabRole;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negis
 */
public class LabWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LabWorkAreaJPanel
     */
    JPanel rightPanel;
    Account account;
    Organization organization;
    EcoSystem business;
    Enterprise enterprise;
    public LabWorkAreaJPanel(JPanel rightPanel, Account account, Organization organization, EcoSystem business) {
        initComponents();
        this.rightPanel = rightPanel;
        this.account = account;
        this.business = business;
        this.organization = (LocalLabOrganization)organization;
        refreshJButton.setVisible(false);
        populateTable();
        workRequestJTable.getTableHeader().setFont(new Font("Times New Roman" , Font.ITALIC,23));

    }
    public LabWorkAreaJPanel(JPanel rightPanel, Account account, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.rightPanel = rightPanel;
        this.account = account;
        this.business = business;
        //organization.getEmplo
        this.enterprise = enterprise;
        populateTableEnterprise();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
        }
    }
    public void populateTableEnterprise(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
            for(WorkRequest request: o.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 720, 96));

        assignJButton.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        refreshJButton.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 23)); // NOI18N
        jButton1.setText("Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if(workRequestJTable.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No rows present to select.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(account);
        request.setStatus("Pending");
        if(account.getRole() instanceof LabAssistantRole){
           populateTableEnterprise(); 
        }
        else if(account.getRole() instanceof LabRole){
            populateTable();
        }
        

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();

        if(workRequestJTable.getRowCount()==0){
            JOptionPane.showMessageDialog(null, "No rows present to select.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        LabTestWorkRequest request = (LabTestWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);

        request.setStatus("Processing");

        HandleTestResultJPanel processWorkRequestJPanel = new HandleTestResultJPanel(rightPanel, request, account);
        rightPanel.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
