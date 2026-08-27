package module3;
import java.util.*; 
//import Contact;
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101")); 
        contacts.put("Max Verstappen", new Contact("Max Verstappen", "+1 617 555 3333")); 
        contacts.put("Charles Leclerc", new Contact("Charles Leclerc", "+1 617 555 1616")); 
        contacts.put("Lewis Hamilton", new Contact("Lewis Hamilton", "+1 617 555 4444")); 
        contacts.put("Oscar Piastri", new Contact("Oscar Piastri", "+1 617 555 8181")); 

        // Step 5: look up a contact 
        if (contacts.containsKey("Ada Lovelace")){
            System.out.println(contacts.get("Ada Lovelace"));
        }
        else {
            System.out.println("Contact not found.");
        }

        if (contacts.containsKey("Lando Norris")){
            System.out.println(contacts.get("Lando Norris"));
        }
        else {
            System.out.println("Contact not found.");
        }
 
        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  

        System.out.println();
        System.out.println("=== All Contacts ===");
        for(int i = 0; i < sorted.size(); i++){
            System.out.println(sorted.get(i));

        }

    } 

}