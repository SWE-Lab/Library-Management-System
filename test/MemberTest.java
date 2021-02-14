
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import org.json.simple.JSONArray;

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
//        assert memberArr.size() == 9 : "Wrong Total number of Books";
        System.out.println("Total number of Books: " + memberArr.size());
//        
//        long a= long(5594536546);
//        Member member1 = memberArr.get(0);
//        assert (member1.getPhNo().equalsIgnoreCase("5594536546")) : "Wrong Phone Number";
//        System.out.println(member1.getPhNo());
//        assert (member1.getEnrollNo() .equalsIgnoreCase("12018002002165")) : "Wrong Phone Number";
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
            System.out.println("Role : " + member.getRole());
//            if(i==2)
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
//            String formattedString = member.getDate().format(formatter);
            member.addMemBook("d");
//            member.remMemBook(1);
            JSONArray ja = member.getMemBookArr();
            obj.saveInfo();
            System.out.println(ja);
            int j = 0;
            while (j < ja.size()) {
                JSONArray j1 = (JSONArray) ja.get(j);
                System.out.println("MemBookArr : [" + j + "] " + j1.get(0) + "," + j1.get(1));
                j++;
            }
//            System.out.println(member.getMemBookArr().size());
            i++;
        }
//        obj.saveInfo();
    }
}
