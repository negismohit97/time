/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorWorkArea;

import Business.Account.Account;
import Business.EcoSystem;
import Business.Enterprise.CentralLaboratoryEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.LocalLabOrganization;
import Business.Organization.Organization;
import Business.Organization.RadiologyOrganization;
import Business.Organization.ScreeningOrganization;
import Business.Person.Donor;
import Business.Person.Recipient;
import Business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author negis
 */
public class PatientTestRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    JPanel container;
    Enterprise enterprise;
    private Account account;
    EcoSystem business;
    String patient = null;
    public PatientTestRequestJPanel(JPanel container, Enterprise enterprise,Account account, EcoSystem business) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        this.account = account;
        this.business=business;
        populateDropdown();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        PatientName = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        xray = new javax.swing.JCheckBox();
        radio = new javax.swing.JCheckBox();
        gyna = new javax.swing.JCheckBox();
        resultStatus = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        blood = new javax.swing.JCheckBox();
        cancer = new javax.swing.JCheckBox();
        adviceTest = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        jLabel1.setText("Patient");

        jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getStyle() | java.awt.Font.BOLD, jLabel2.getFont().getSize()+4));
        jLabel2.setText("Tests");

        xray.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        xray.setText("Chest X-Ray and Electrocardiogram (EKG)");

        radio.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        radio.setText("Radiologic Testing");

        gyna.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        gyna.setText("Gynecological screening");

        resultStatus.setBackground(new java.awt.Color(204, 255, 255));
        resultStatus.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        resultStatus.setText("Test Result Status");
        resultStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultStatusActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/Images/IMAGES/down-syndrome-lab-blood-test-results-blog.jpg"))); // NOI18N

        blood.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        blood.setText("Blood Test");

        cancer.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        cancer.setText("Cancer Screening");

        adviceTest.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        adviceTest.setText("Advice Test");
        adviceTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adviceTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(blood)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancer)
                        .addGap(475, 475, 475))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                                .addComponent(gyna))
                            .addComponent(xray))
                        .addGap(415, 415, 415))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(614, 614, 614)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(adviceTest)
                .addGap(162, 162, 162)
                .addComponent(resultStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(blood)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(cancer)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(radio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gyna)))
                .addGap(27, 27, 27)
                .addComponent(xray)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adviceTest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultStatus))
                        .addGap(400, 400, 400))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    void populateDropdown(){
        for( Organization o :enterprise.getOrganizationDirectory().getOrganizationList()){
            //get patients from where they are being stored
            for(Donor d : o.getDonorDirectory().getDonorList()){
            PatientName.addItem(d.getEmailAdd().trim());
            patient="donor";
            }
            for(Recipient r : o.getRecipientDirectory().getRecipientList()){
            PatientName.addItem(r.getEmailAdd().trim());
            patient="recipient";
            }
        }
    }
    public void clearAll(){
        xray.setSelected(false);
        radio.setSelected(false);
        blood.setSelected(false);
        cancer.setSelected(false);
        gyna.setSelected(false);
    }
    private void resultStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultStatusActionPerformed
        List<String> tests =  new ArrayList<>();
        if(blood.isSelected())
        tests.add("Yes");
        else 
        tests.add("No");
        if(radio.isSelected())
            tests.add("Yes");
        else
            tests.add("No");
        if(xray.isSelected())
            tests.add("Yes");
        else
            tests.add("No");
        DoctorActivityJPanel patientTestRequestJPanel = new DoctorActivityJPanel(container, enterprise,account,(String)PatientName.getItemAt(PatientName.getSelectedIndex()),tests, patient);
        container.add("DoctorActivityJPanel", patientTestRequestJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_resultStatusActionPerformed

    private void adviceTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adviceTestActionPerformed
        if(blood.isSelected()==false && xray.isSelected()==false && radio.isSelected()==false && gyna.isSelected()==false && cancer.isSelected()==false){
            JOptionPane.showMessageDialog(null,"Please advice some test!");
            return;
        }
        if(blood.isSelected() || xray.isSelected() ||radio.isSelected()){
            LabTestWorkRequest request = new LabTestWorkRequest();
            request.setMessage("Please perform these tests");
            request.setSender(account);
            request.setStatus("Sent");
            request.setPatientName((String)PatientName.getItemAt(PatientName.getSelectedIndex()));
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){

            if (organization instanceof LocalLabOrganization){

                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
        JOptionPane.showMessageDialog(null,"Tests sent to internal lab department for consultation!");
        }
        if(gyna.isSelected()){
            LabTestWorkRequest request = new LabTestWorkRequest();
            request.setMessage("Screening Dept - please look into this issue");
            request.setSender(account);
            request.setStatus("Sent");
            request.setPatientName((String)PatientName.getItemAt(PatientName.getSelectedIndex()));
         Organization o= null;
       for(Network n: business.getNetworkList()){
           
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof CentralLaboratoryEnterprise){
                   for(Organization org:  e.getOrganizationDirectory().getOrganizationList()){
                       if(org instanceof ScreeningOrganization){
                           o=org;
                           
                       }
                   }
                }
            }
        }
       if(o!=null){
            o.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
           JOptionPane.showMessageDialog(null,"Tests sent to external lab, Screening Dept for analysis!");
       }
     }
        if(cancer.isSelected()){
            LabTestWorkRequest request = new LabTestWorkRequest();
            request.setMessage("Radiology Dept - please look into this issue");
            request.setSender(account);
            request.setStatus("Sent");
            request.setPatientName((String)PatientName.getItemAt(PatientName.getSelectedIndex()));
            Organization o= null;
       for(Network n: business.getNetworkList()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                if(e instanceof CentralLaboratoryEnterprise){
                   for(Organization org:  e.getOrganizationDirectory().getOrganizationList()){
                       if(org instanceof RadiologyOrganization){
                           o=org;
                           
                       }
                   }
                }
            }
        }
       if(o!=null){
            o.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
           JOptionPane.showMessageDialog(null,"Tests sent to external lab, Radiology Dept for analysis!");
       }
        }
        clearAll();
    }//GEN-LAST:event_adviceTestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox PatientName;
    private javax.swing.JButton adviceTest;
    private javax.swing.JCheckBox blood;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cancer;
    private javax.swing.JCheckBox gyna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JCheckBox radio;
    private javax.swing.JButton resultStatus;
    private javax.swing.JCheckBox xray;
    // End of variables declaration//GEN-END:variables
}
