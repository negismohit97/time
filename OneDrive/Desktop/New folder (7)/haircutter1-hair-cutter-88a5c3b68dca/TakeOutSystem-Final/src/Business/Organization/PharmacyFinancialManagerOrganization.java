/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RFinancialRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class PharmacyFinancialManagerOrganization extends Organization{
  public PharmacyFinancialManagerOrganization() {
        super(Organization.Type.PharmacyFinancialManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RFinancialRole());
        return roles;
    }   
}
