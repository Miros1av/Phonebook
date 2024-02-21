package phonebook.model;

public class Contact {
    /**
     * ID of contact. This parameter is automatically generated when Contact is created.
     */
    private Long contactId;

    /**
     * Name of contact
     */
    private String contactName;

    /**
     * Surname of contact
     */
    private String contactSurname;

    /**
     * Phone number of contact
     */
    private String contactPhoneNumber;

    /**
     * Constructor without parameters
     */
    public Contact() {
    }

    /**
     * Constructor with parameters, creates new contact with all necessary parameters
     * @param contactId - ID of contact
     * @param contactName - Name of contact
     * @param contactSurname - Surname of Contact
     * @param contactPhoneNumber - Phone number of contact
     */
    public Contact (Long contactId, String contactName, String contactSurname, String contactPhoneNumber) {
        this.contactId = contactId;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    /**
     * Getter, returns ID of contact
     * @return ID
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * Setter, set new ID of contact
     * @param contactId - ID
     */
    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    /**
     * Getter, returns name of contact
     * @return name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Setter, set new name of contact
     * @param contactName - name
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Getter, returns surname of contact
     * @return surname
     */
    public String getContactSurname() {
        return contactSurname;
    }

    /**
     * Setter, set new surname of contact
     * @param contactSurname - surname
     */
    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    /**
     * Getter, returns phone number of contact
     * @return phone number
     */
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    /**
     * Setter, set new phone number of contact
     * @param contactPhoneNumber - phone number
     */
    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }
}