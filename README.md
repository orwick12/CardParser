# CardParser

By [Brian Orwick](mailto:orwick12@outlook.com)

[https://github.com/orwick12]

# Instructions

1. Navigate to [repo] https://github.com/orwick12/CardParser
2. Option 1) Clone using https://github.com/orwick12/CardParser.git
3. Option 1) Open clone with IDE
4. Option 1) Assign main class to BusinessCardParser.java
5. Option 1) Assign working directory and class path to CardParser
6. Option 1) Run program 

7. Option 2) Download zipfile from https://github.com/orwick12/CardParser/tree/Working
8. Option 2) Extract files
9. Option 2) Using Cmdline go to src folder and compile the package
             javac ./cardparser/BusinessCardParser.java 
             javac ./cardparser/ContactInfo.java
             javac ./cardparser/NameData.java
10. Option 2) Run BusinessCardParser
             java cardparser.BusinessCardParser
11. Enjoy       

# Discussion

I used Java 9 with no framework and Intellij

# Requirements

We’ve created a new smartphone app that enables users to snap a photo of a business card and have the information from the card automatically extracted and added to their contact list. We need you to write the component that parses the results of the optical character recognition (OCR) component in order to extract the name, phone number, and email address from the processed business card image. We have provided you with a basic specification [1] and a series of example inputs [2] and would like you to provide the implementation.

# Implementation 

In order to simulate the OCR component I used a text file and put in the package so it is automatically read in and parsed.
The determination of names I added a csv to the package from the 2010 census that I put into an arraylist so that I can search through arraylist and determine if the tokens are a first or last name.   If the first name and last name are both found that line on the business card has a very high chance of being the card owners name. This works well because with a business name called Brian Orwick Construction each word will go through the list and when the word construction is not a discovered name, it will go to the next line of the card.
