package com.baarsch_bytes.Library;

import com.baarsch_bytes.Exceptions.EmailFailureException;

public interface EmailProvider {

    // Sends an email to the recipient (Patron or member of the library)
    boolean sendEmail(String recipient, String message) throws EmailFailureException;
}
