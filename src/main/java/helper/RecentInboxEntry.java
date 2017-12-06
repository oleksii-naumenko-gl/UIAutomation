package helper;

/**
 * Recent or Inbox entry that contains date, contact name/phone number and extension.
 */
public class RecentInboxEntry {

    public String contact;

    public String timestamp;

    public String extension;

    public RecentInboxEntry(String contact, String timestamp, String extension) {
        this.contact = contact;
        this.timestamp = timestamp;
        this.extension = extension;
    }

}
