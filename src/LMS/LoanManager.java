package LMS;


import org.json.simple.JSONArray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author angshuman
 */
public class LoanManager {
    private MemberManager memMan;
    private long loan;
    private int memberNo;
    
    public LoanManager(MemberManager memMan, int index){
        this.memberNo = index;
        this.memMan  = memMan;
        this.loan = this.memMan.getMember(index).getFine();
    }
    
    public long getTotalFine(){
        long totFine = this.loan;
        int i = 0;
        while(i<this.memMan.getMember(this.memberNo).getTotalMemBook()){
            Loan loanClass = new Loan(this.memMan.getMember(this.memberNo).getBookIssueDate(i));
            totFine += (loanClass.getDateDiff()<180)?0:loanClass.getDateDiff()*100;
            i++;
        }
        this.memMan.getMember(this.memberNo).setFine(totFine);
        return totFine;
    }
}
