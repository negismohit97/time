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
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setForeground(new java.awt.Color(204, 255, 204));
        setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        networkJTable.setBackground(new java.awt.Color(204, 255, 204));
        networkJTable.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 50, 506, 148));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 255, 110, 30));

        backJButton.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/Images/IMAGES/arrow-sign-icon-back-button-navigation-symbol_gg69834698 (1).jpg"))); // NOI18N
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 190, 50));

        cityName.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        cityName.setText("City Name");
        add(cityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 258, -1, -1));

        submitJButton.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/Images/IMAGES/submitbutton_succeed.gif"))); // NOI18N
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 200, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/Images/IMAGES/healing.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 900, -1));
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
