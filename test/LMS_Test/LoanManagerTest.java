package LMS_Test;


import LMS.MemberManager;
import LMS.LoanManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angshuman
 */
public class LoanManagerTest {
    public static void main(String args[]){
        MemberManager memMan = new MemberManager("dtb-member.json");
        LoanManager lm = new LoanManager(memMan,0);
        System.out.println(lm.getTotalFine());
        memMan.writeJSON();
    }
}
