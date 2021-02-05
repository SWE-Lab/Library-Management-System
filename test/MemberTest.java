
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hackme
 */
public class MemberTest {
    public static void main(String args[]) {
        Member obj = new Member("dtb-member.json");
        Vector<Member> memberArr = obj.getMemberArray();
        
        // Get total number of books
        assert memberArr.size() == 8 : "Wrong Total number of Books";
        System.out.println("Total number of Books: " + memberArr.size());
//        
//        long a= long(5594536546);
        Member member1 = memberArr.get(0);
        assert (member1.getPhNo().equalsIgnoreCase("5594536546")) : "Wrong Phone Number";
        System.out.println(member1.getPhNo());
//        
        int i = 0;
        while (i < memberArr.size()) {
            Member member = memberArr.get(i);
            System.out.println("Name : " + member.getName());
            System.out.println("Email : " + member.getEmail());
            System.out.println("PhNo : " + member.getPhNo());
            System.out.println("Password : " + member.getPassword());
            System.out.println("EnrollNo : " + member.getEnrollNo());
            System.out.println("ProfilePicPath : " + member.getPicPath());
            System.out.println("Fine : " + member.getFine());
            System.out.println("EnrollDate : " + member.getDate());
            i++;
        } 
    }
}
