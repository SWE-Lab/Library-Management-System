/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hackme
 */
public class MemberManagerTest {

    public static void main(String[] args) {

        // Unit test to create a book manager object and check its functions.
        MemberManager obj = new MemberManager("dtb-member.json");

        // Get total number of Members
        System.out.println(obj.getTotalMembers());
//        assert obj.getTotalMembers() == 9 : "Wrong Total number of Member";
//        System.out.println("Total number of Member: " + obj.getTotalMembers());
//
////        // Add new Member
        int oldNo = obj.getTotalMembers();
        String arr[] = {"Alpa","alpa@gm.com","6547892310","12345678","15963247854125","/home/angshuman/Pictures/Screenshot_20210104_110819.png","500"};
        obj.registerMember(arr);
        // To add new book to the newly added member's book array
//        obj.getMember(oldNo).addMemBook("angshuman");
        assert obj.getTotalMembers() == oldNo + 1 : "Member not Added";
        assert obj.getMember(oldNo).getName().equals("Alpa") : "Wrong Member added";
        System.out.println(obj.getMemberArr().get(oldNo).getName());
//

        obj.delMemBook(0, 1);
////        // Delete Member
//        String oldPub = obj.getMember(5).getName();
//        obj.deleteMember(5);
//        String newPub = obj.getMember(5).getName();
//        assert obj.getTotalMembers() == oldNo : "Wrong Index";
//        assert !(oldPub.equals(newPub)) : "Not Deleted Proper Member";
//
//        // Update Member
//        int index = 0;
//        obj.updateMember(index, "Name", "AAAA");
//        String newName = obj.getMember(index).getName();
//        assert newName.equals("AAAA") : "Wrong Instance Updated";

        //Search Member
//        Member member = obj.verifyMember("m@gmail.com", "Email");
//        assert member.getRole().equals("Student") : "Wrong Search Result";
//        System.out.println("Date of registration : " + member.getDate());
//        System.out.println("Name : " + member.getName());
//        System.out.println("Email : " + member.getEmail());
//        System.out.println("Phone Number: " + member.getPhNo());
//        System.out.println("Enroll No: " + member.getEnrollNo());
//        System.out.println("Profile Pic: " + member.getPicPath());
//        System.out.println("Fine: " + member.getFine());

        // Write back to json file
        obj.writeJSON();
//        System.out.println("Update Book details & Search book");
    }
}
