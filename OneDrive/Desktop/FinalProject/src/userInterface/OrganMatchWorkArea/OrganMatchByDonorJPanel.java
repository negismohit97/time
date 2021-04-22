/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.OrganMatchWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Donor;
import Business.Person.Recipient;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negis
 */
public class OrganMatchByDonorJPanel extends javax.swing.JPanel {

    JPanel rightPanel;
    EcoSystem system;
    List<Donor> donorList;
    Donor donorEmail;
    Recipient recipientEmail;
    /**
     * Creates new form ManageOrganMatch
     */
    public OrganMatchByDonorJPanel(JPanel rightPanel, EcoSystem system, List<Donor> donorList) {
        initComponents();
        this.rightPanel = rightPanel;
        this.system = system;
        this.donorList = donorList;
         populateDonorTable();
         donorInfoJTable.getTableHeader().setFont(new Font("Times New Roman" , Font.ITALIC,23));
         recipientInfoJTable.getTableHeader().setFont(new Font("Times New Roman" , Font.ITALIC,23));

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
        recipientInfoJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        donorInfoJTable = new javax.swing.JTable();
        findMatchBtn = new javax.swing.JButton();
        informMatchBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipientInfoJTable.setBackground(new java.awt.Color(204, 255, 204));
        recipientInfoJTable.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        recipientInfoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Recipient Name", "Network", "Organ", "Severity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recipientInfoJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 980, 100));

        donorInfoJTable.setBackground(new java.awt.Color(204, 255, 204));
        donorInfoJTable.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        donorInfoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Donor Name", "Network", "Organ", "Current Organ Availabilty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(donorInfoJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 970, 100));

        findMatchBtn.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        findMatchBtn.setText("Find Match");
        findMatchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMatchBtnActionPerformed(evt);
            }
        });
        add(findMatchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        informMatchBtn.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        informMatchBtn.setText("Inform About Match");
        informMatchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informMatchBtnActionPerformed(evt);
            }
        });
        add(informMatchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/Images/IMAGES/back.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 120, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void findMatchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMatchBtnActionPerformed
        int selectedRow = donorInfoJTable.getSelectedRow();
        
        if(selectedRow >= 0){
           Donor donor = (Donor) donorInfoJTable.getValueAt(selectedRow, 0);
           String city = (String) donorInfoJTable.getValueAt(selectedRow, 1);
           List<String> organs = donor.getOrgans();
           donorEmail = donor;
           populateRecipientTable(organs, city);    
        }else{

            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_findMatchBtnActionPerformed

    private void informMatchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informMatchBtnActionPerformed
        int selectedRow = recipientInfoJTable.getSelectedRow();

        if (selectedRow >= 0) {
            recipientEmail = (Recipient) recipientInfoJTable.getValueAt(selectedRow, 0);
            sendEmail(donorEmail.getEmailAdd());
            sendEmail(recipientEmail.getEmailAdd());
            JOptionPane.showMessageDialog(null, "Organ match information is sent successfully via email.");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_informMatchBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        rightPanel.remove(this);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.previous(rightPanel);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable donorInfoJTable;
    private javax.swing.JButton findMatchBtn;
    private javax.swing.JButton informMatchBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable recipientInfoJTable;
    // End of variables declaration//GEN-END:variables

    private void populateDonorTable() {
        
        DefaultTableModel model = (DefaultTableModel) donorInfoJTable.getModel();

        model.setRowCount(0);

        for (Donor donor : donorList) {
            Object[] row = new Object[4];
            row[0] = donor;
            row[1] = donor.getNetwork();
            row[2] = donor.getOrgans();
            row[3] = donor.getIsOrganAvaiNow();

            model.addRow(row);
        }
    }

    private void populateRecipientTable(List<String> organs, String city) {
        
         DefaultTableModel model = (DefaultTableModel) recipientInfoJTable.getModel();

        //HashMap<String, Donor> donorList = new HashMap<String, Donor>();
        List<Recipient> recipientList = new ArrayList<Recipient>();

        model.setRowCount(0);
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if(enterprise instanceof HospitalEnterprise){
                    for (Organization or : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (or.getName().equalsIgnoreCase("Visitor Organization")) {
                            for (Recipient recipient : or.getRecipientDirectory().getRecipientList()) {
                                //for(String organ : organs){
                                    //if(organ.equalsIgnoreCase(recipient.getOrgan())){
                                    //add to list  
                                    int p = recipient.getPriority();
                                    if((organs.contains(recipient.getOrgan())) && (p > 0)){
                                          recipient.setNetwork(network.getName());
                                          recipientList.add(recipient);
                                      }  
                                        
                                        
                                    //}
                                //}
                            }
                        }

                   }
                }
            }
        }
        
        //Map<Double, Recipient> cityDistMap = findDistanceBetweenCities(recipientList, city);
        
        //sort recipient list by their sevirity
//        List<Map.Entry<Double, Recipient>> list = new ArrayList<Map.Entry<Double, Recipient>>(cityDistMap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<Double, Recipient>>() {
//             @Override
//             public int compare(Map.Entry<Double, Recipient> o1, Map.Entry<Double, Recipient> o2) {
//                 return o1.getValue().compareTo(o2.getValue());
//             }
//        });
        
        Collections.sort(recipientList, new Comparator<Recipient>() {

             @Override
             public int compare(Recipient o1, Recipient o2) {
                 return o1.compareTo(o2);
             }
        
        });
        
        for(Recipient obj : recipientList){
            Object[] row = new Object[4];
            row[0] = obj;
            row[1] = obj.getNetwork();
            row[2] = obj.getOrgan();
            row[3] = obj.getPriority();
            model.addRow(row);
        }
        
    }

//    private Map<Double, Recipient> findDistanceBetweenCities(List<Recipient> recipientList, String source) {
//        
//        Map<Double, Recipient> cityDistMap = new TreeMap<Double, Recipient>();
//        
//        for(Recipient recipient : recipientList){
//            double distance = getDistance(source, recipient.getNetwork());
//            cityDistMap.put(distance, recipient);
//        }
//        return cityDistMap;
//    }
//    
//        //to find distance between cities
//        public static double getDistance(String fromAddress, String toAddres) {
//            Map from = getGeoCodes(fromAddress);
//            Map to = getGeoCodes(toAddres);
//            return distance((Double) from.get("lat"), (Double) from.get("lng"), (Double) to.get("lat"), (Double) to.get("lng"), "K");
//
//        }
//    
//        public static Map getGeoCodes(String address) {
//           try {
//               String geoCodeUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=";
//               String key = "&key=AIzaSyBiz8PYrcTF4KFwOEpOANYPcgxZUDz3_kU";
//               StringBuilder result = new StringBuilder();
//               URL url = new URL(geoCodeUrl + address + key);
//               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//               conn.setRequestMethod("GET");
//               BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//               String line;
//               while ((line = rd.readLine()) != null) {
//                   result.append(line);
//               }
//               rd.close();
//               Map resultMap = new ObjectMapper().readValue(result.toString(), Map.class);
//               return (Map) ((Map) ((Map) ((List) resultMap.get("results")).get(0)).get("geometry")).get("location");
//           } catch (Throwable throwable) {
//               throwable.printStackTrace();
//           }
//           return null;
//       }
//     
//        public static double distance(double lat1, double lon1, double lat2, double lon2, String sr) {
//           double theta = lon1 - lon2;
//           double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
//           dist = Math.acos(dist);
//           dist = rad2deg(dist);
//           dist = dist * 60 * 1.1515;
//           if (sr.equals("K")) {
//               dist = dist * 1.609344;
//           } else if (sr.equals("N")) {
//               dist = dist * 0.8684;
//           }
//           return (dist);
//       }
//
//       public static double deg2rad(double deg) {
//           return (deg * Math.PI / 180.0);
//       }
//
//       public static double rad2deg(double rad) {
//           return (rad * 180.0 / Math.PI);
//       }
       
       private void sendEmail(String emailAdd) {
            final String to = emailAdd;
            boolean sessionDebug=false;
            String from = "aditijal1992@gmail.com"; 
            String host = "smtp.gmail.com";
            String user="aditijal1992@gmail.com";
            String pass = "@Diti123";
            Properties properties = System.getProperties();  
            properties.setProperty("mail.smtp.host", host); properties.put("mail.smtp.starttls.required", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host",host);  
            properties.put("mail.smtp.port", "587");  
            properties.put("mail.smtp.auth", "true");  
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
            Session session;
            session = Session.getDefaultInstance(properties,  null);
            session.setDebug(sessionDebug);
            try{
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(from));  
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            InternetAddress address;
            address = new InternetAddress(to);
            message.setSubject("Did you know?");  
            message.setText("We have paired "+ donorEmail.getEmailAdd()+ " with " + recipientEmail.getEmailAdd()+ " for organ transplant.");  
            Transport transport = session.getTransport("smtp");
            transport.connect(host,user,pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            //JOptionPane.showMessageDialog(null, "Please check your email for further details!");
            }
            
            catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
}
