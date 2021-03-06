/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.AdminWorkSpace;

import Business.EcoSystem;
import Business.Network.Network;
import Business.RegularExpressionCheck;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negis
 */
public class ManageCitiesJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
 
    /**
     * Creates new form ManageCitiesJPanel
     */
    public ManageCitiesJPanel(JPanel rightPanel, EcoSystem system ) {
        initComponents();
        this.userProcessContainer=rightPanel;
        this.system = system;
        populateNetworkTable();
        networkJTable.getTableHeader().setFont(new Font("Times New Roman" , Font.ITALIC,23));
        
    }

   
    
    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
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
        networkJTable = new javax.swing.JTable();
        nameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        cityName = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setForeground(new java.awt.Color(204, 255, 204));
        setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        networkJTable.setBackground(new java.awt.Color(255, 204, 204));
        networkJTable.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "City Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 118, 506, 200));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 110, 30));

        backJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        backJButton.setText("BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 110, 30));

        cityName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cityName.setText("City Name:");
        add(cityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, -1, -1));

        submitJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        submitJButton.setText("SUBMIT");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 180, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Add City");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
       // ImageIcon i1 = new ImageIcon (getClass().getResource(""))
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        OTAWorkArea sysAdminwjp = (OTAWorkArea) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        String name = nameJTextField.getText();
       
         if(name.equals("")){
            JOptionPane.showMessageDialog(null, "City name can not by empty.");
            return;
         }else {
             if(!RegularExpressionCheck.findRE(name)){
                 JOptionPane.showMessageDialog(null, "Enter valid city name.");
                 return;
             }
         }
        
        int flag=1;
        for(int i=0;i<system.getNetworkList().size();i++){
            if(system.getNetworkList().get(i).getName().equalsIgnoreCase(name)){
                flag=0;
            }
        }
        if(flag==1){
            Network network = system.createAndAddNetwork();
            network.setName(name);
            nameJTextField.setText("");
            populateNetworkTable();
        }
        else {
            JOptionPane.showMessageDialog(null, "City already exists");
            nameJTextField.setText("");
        }
        
    }//GEN-LAST:event_submitJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel cityName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
