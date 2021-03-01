package LMS_Test;


import LMS.Loan;
import LMS.Member;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angshuman, aniket
 */
public class LoanTest {

    public static void main(String args[]) {
        Member member = new Member("dtb-member.json").getMemberArray().get(0);
        Loan loan = new Loan(member.getBookIssueDate(0));
        System.out.println(loan.getDateDiff());
    }
}
