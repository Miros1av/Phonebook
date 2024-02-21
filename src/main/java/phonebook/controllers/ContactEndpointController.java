package phonebook.controllers;


import phonebook.model.Contact;
import phonebook.utils.EntryDataValidator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactEndpointController {

    //Initialize of instances
    private List<Contact> phonebook = new ArrayList<>();
    private final EntryDataValidator validator = new EntryDataValidator();

    /**
     * Writes out all the contacts in phonebook
     * @return list of all contacts
     */
    @GetMapping
    public List<Contact> getAllContacts() {
        return phonebook;
    }

    /**
     * Writes out one contact from phonebook according selected contactID
     * @param contactId ID of contact
     * @return one particular contact
     */
    @GetMapping("/{contactId}")
    public ResponseEntity<?> getContactById(@PathVariable Long contactId) {
        for (Contact contact : phonebook) {
            if (contact.getContactId().equals(contactId)) {
                return ResponseEntity.ok(contact);
            }
        }
        // If contact is not found, return a message
        return ResponseEntity.ok("Contact with ID: " + contactId + " not found." );
    }

    /**
     * Create new contact in phonebook with all parameters
     * @param contact
     * @return Confirmation about successful creation.
     */
    @PostMapping
    public String createContact(@RequestBody Contact contact) {
        // Check if any required parameter is null or empty
        if (validator.isAnyParameterNullOrEmpty(contact.getContactName(),
                                                contact.getContactSurname(),
                                                contact.getContactPhoneNumber())) {
            return "All parameters are required for creating a contact.";
        }

        Long maxId = 0L; // Initialize maxId with 0
        // Loop through each contact in the list to find the maximum ID
        for (Contact c : phonebook) {
            if (c.getContactId() > maxId) {
                maxId = c.getContactId(); // Update maxId if a larger ID is found
            }
        }

        // Increase maximum ID by 1 to generate a new ID for the new contact
        Long newId = maxId + 1;
        // Set the new ID for the contact and add it to the list
        contact.setContactId(newId);
        phonebook.add(contact);

        // Return a message indicating that the contact was successfully created with information about assigned ID.
        return "Contact was successfully added. Contact ID: " + newId;
    }

    /**
     * Update contact in phonebook according selected contactID, any parameter can be changed except ID
     * @param contactId ID of contact
     * @param updatedContact contact with updated parameters
     * @return Confirmation about successful update.
     */
    @PutMapping("/{contactId}")
    public String updateContactDetails(@PathVariable Long contactId, @RequestBody Contact updatedContact) {
        // Check if any required parameter is null or empty
        if (validator.isAnyParameterNullOrEmpty(updatedContact.getContactName(),
                                                updatedContact.getContactSurname(),
                                                updatedContact.getContactPhoneNumber())) {
            return "All parameters are required for updating a contact.";
        }

        for (Contact contact : phonebook) {
            if (contact.getContactId().equals(contactId)) {
                // Update the contact details
                contact.setContactName(updatedContact.getContactName());
                contact.setContactSurname(updatedContact.getContactSurname());
                contact.setContactPhoneNumber(updatedContact.getContactPhoneNumber());
                // Return a message indicating that the contact was successfully updated
                return "Contact with ID " + contactId + " was updated.";
            }
        }
        return "Contact with ID " + contactId + " not found.";
    }

    /**
     * Remove contact from phonebook according selected contactID
     * @param contactId ID of contact
     * @return Confirmation about successful erasing.
     */
    @DeleteMapping("/{contactId}")
    public String deleteContact(@PathVariable Long contactId) {
        for (Contact contact : phonebook) {
            if (contact.getContactId().equals(contactId)) {
                phonebook.remove(contact);
                return "Contact with ID " + contactId + " was removed.";
            }
        }
        return "Contact with ID " + contactId + " not found.";
    }
}