/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author HYY
 */
public class FinanceEnterprise extends Enterprise{
    public FinanceEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Finance);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
