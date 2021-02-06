
import java.time.LocalDate;
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
public class MemberManager {

    private Vector<Member> memberArr;
    private Member obj;

    public MemberManager(String jsonPath) {
        this.obj = new Member(jsonPath);
        this.memberArr = obj.getMemberArray();
    }

    public void writeJSON() {
        obj.saveInfo();
    }

    public int getTotalMembers() {
        return this.memberArr.size();
    }

    public Vector<Member> getMemberArr() {
        return this.memberArr;
    }

    public Member getMember(int index) {
        return this.memberArr.get(index);
    }

    public Vector<String> getMemBookArray(){
        Vector<String> v = new Vector<String>();
        int i = 0;
        while(i<obj.getMemBookArr().size()){
            v.add((String) obj.getMemBookArr().get(i));
            i++;
        }
        return v;
    }
    
    public void registerMember(String inputString) {
        String arr[] = inputString.split(",");
        Member member = new Member();
        member.setName(arr[0]);
        member.setEmail(arr[1]);
        member.setPhNo(arr[2]);
        member.setPassword(arr[3]);
        member.setEnrollNo(arr[4]);
        member.setProfilePicPath(arr[5]);
        member.setFine(0);
        member.setDate(LocalDate.now());
        member.setRole("Student");
        member.setMemBookArr();
        this.memberArr.add(member);
    }

    public void deleteMember(int rownumber) {
        if (rownumber < 0 || rownumber > this.getTotalMembers()) {
            System.out.println("No such instance found\nDeletion Aborted");
        } else {
            this.memberArr.remove(rownumber);
            System.out.println("Deleted Successfully");
        }
    }

    public void updateMember(int index, String key, String value) {
        if (index < 0 || index > this.getTotalMembers()) {
            System.out.println("No such instance found\nUpdate Rejected");
        } else {
            Member member = this.memberArr.get(index);
            switch (key) {
                case "Name":
                    member.setName(value);
                    break;
                case "Email":
                    member.setEmail(value);
                    break;
                case "PhNo":
                    member.setPhNo(value);
                    break;
                case "Password":
                    member.setPassword(value);
                    break;
                case "EnrollNo":
                    member.setEnrollNo(value);
                    break;
                case "ProfilePicPath":
                    member.setProfilePicPath(value);
                    break;
                case "Fine":
                    member.setFine(new Long(value));
                    break;
                case "Role":
                    member.setRole(value);
                    break;
            }
        }
    }

    public Member verifyMember(String input, String key) {
        int i = 0;
        switch (key) {
            case "Name":
                while (i < this.getTotalMembers()) {
                    Member member = this.memberArr.get(i);
                    if (member.getName().equalsIgnoreCase(input)) {
                        break;
                    }
                    i++;
                }
                break;
            case "Email":
                while (i < this.getTotalMembers()) {
                    Member member = this.memberArr.get(i);
                    if (member.getEmail().equals(input)) {
                        break;
                    }
                    i++;
                }
                break;
        }
        if (i >= this.getTotalMembers()) {
            Member retMember = new Member();
            return retMember;
        } else {
            Member member = this.memberArr.get(i);
//            System.out.println("Match Found: ");
//            System.out.println("Book Code: " + book.getCode());
//            System.out.println("Publisher: " + book.getPublisher());
//            System.out.println("Book Name: " + book.getName());
//            System.out.println("Author: " + book.getAuthor());
//            System.out.println("Subject: " + book.getSubject());
//            System.out.println("ISBN: " + book.getISBN());
//            System.out.println("Price: " + book.getPrice());
//            System.out.println("Path of Picture: " + book.getPicPath());
//            System.out.println("Quantity: " + book.getQuantity());
            return member;
        }
    }

    public void renewMembership(int index) {
        this.memberArr.get(index).setDate(this.memberArr.get(index).getDate());
    }
}
