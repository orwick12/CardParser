import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Created by Brian Orwick
Date: 8/10/2018
BusinessCardParser will parse the results of the optical
character recognition (OCR) component in order to extract the name,
phone number, and email address from the processed business card image.
 */

public class BusinessCardParser {

    public static void main(String[] args){

        String fileName;
        BusinessCardParser card = new BusinessCardParser();

        //Determine file of OCR from command line
        try {
            fileName = args[0];
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            System.out.println(card.getContactInfo(sc));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Parse through the OCR make determination on if there is a name, phone, and email found create a contact
     */
    private ContactInfo getContactInfo(Scanner sc){
        ContactInfo contact = new ContactInfo();
        NameData names = new NameData();

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(searchNames(line, names.getAllNames())){
                contact.setName(line);
            }
            if(isPhoneNumber(line)){
                line = line.replaceAll("\\D+","");
                contact.setPhoneNumber(line);
            }
            if(isEmail(line)){
                contact.setEmail(line);
            }
        }
        return contact;
    }

    /*
    Verify if line scanned has a possible email in it and if it does return true
     */
    private boolean isEmail(String line){
        boolean value = false;
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(line);
        value = mat.matches();
        return value;
    }

    /*
    Verify if line scanned has a possible phone number in it if it does return true
     */
    private boolean isPhoneNumber(String line){
        boolean value = false;
        if(line.contains("Fax")){
            return value;
        }
        Pattern pattern = Pattern.compile("\\d{3}-?\\d{4}");
        Matcher mat = pattern.matcher(line);
        if(mat.find()){
            value = true;
        }
        return value;
    }

    /*
    Search through Arraylist of 2010 census results which will check all strings on a
    line of a business card and if they are determined names return true
    */
    public boolean searchNames(String line, ArrayList<String> names){
        String[] splited = line.toUpperCase().split("\\s+");
        for (String str:splited) {
            if (!names.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
