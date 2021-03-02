package LMS;


import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author debanjan
 */
public class Loan {

    private LocalDate date;

    public Loan(LocalDate date) {
        this.date = date;
    }

    public int getDateDiff() {
        int diffDays = -1;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
            String formattedString1 = LocalDate.now().format(formatter);
            String formattedString2 = this.date.format(formatter);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-LL-dd");
            Date obj1 = sdf.parse(formattedString1);
            Date obj2 = sdf.parse(formattedString2);
            long diff = obj1.getTime() - obj2.getTime();
            diffDays = (int) (diff / (24 * 60 * 60 * 1000));
        } catch (Exception e) {
            System.out.println(e);
        }
        return diffDays;
    }
}
