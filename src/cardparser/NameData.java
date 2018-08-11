package cardparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



/*
Created by Brian Orwick
Date: 8/10/2018
NameData will parse the results of the 2010 census data in order to create an array
that the BusinessCardParser will use for determining possible names.
 */

public class NameData {

    private String line;
    private ArrayList <String> allNames = new ArrayList<>();
    private File file = new File("./Names_2010Census.csv");

    //create scanner for constructor
    private Scanner sc;
    {
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public NameData() {
        while(sc.hasNextLine()){
            line = sc.nextLine();
            allNames.add(line);
        }
    }

    public ArrayList<String> getAllNames() {
        return allNames;
    }
}
