package com.baarsch_bytes;
import com.baarsch_bytes.Exceptions.DatabaseFailureException;
import com.baarsch_bytes.Exceptions.EmailFailureException;
import com.baarsch_bytes.Library.EmailProvider;
import com.baarsch_bytes.Library.LibraryService;
import com.baarsch_bytes.Library.ResourceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

    @Mock
    EmailProvider emailProvider;
    @Mock
    ResourceRepository resourceRepository;
    @InjectMocks
    LibraryService libraryService;

    //-----------------------------------------------------------------------------------------------------------------------------------------------
    //MODIFIED CONDITION / DECISION COVERAGE - PRUNED TEST SUITE
    //-----------------------------------------------------------------------------------------------------------------------------------------------

    //TCI 1.1
    @Test
    void successfulCheckoutTest() throws DatabaseFailureException, EmailFailureException
    {
        UUID resourceId= UUID.fromString("4d9a43ff-cc4e-4a19-8f8c-c8aaaa951934");
        String memberEmail = "moshy.marsh@ymail.com";

        when(resourceRepository.isResourceAvailable(resourceId)).thenReturn(true);
        when(resourceRepository.updateStatus(resourceId, false)).thenReturn(true);
        when(emailProvider.sendEmail(memberEmail, "Resource ID: " + resourceId + " checked out.")).thenReturn(true);
        assertTrue(libraryService.checkoutResource(resourceId, memberEmail));
    }

    //TCI 1.2
    @Test
    void invalidEmailTest() throws EmailFailureException, DatabaseFailureException
    {
        UUID resourceId= UUID.fromString("4d9a43ff-cc4e-4a19-8f8c-c8aaaa951934");
        String memberEmail = "fake@email.com";

        when(resourceRepository.isResourceAvailable(resourceId)).thenReturn(true);
        when(resourceRepository.updateStatus(resourceId, false)).thenReturn(true);
        when(emailProvider.sendEmail(memberEmail, "Resource ID: " + resourceId + " checked out.")).thenReturn(false);

        assertThrows(EmailFailureException.class, () -> {libraryService.checkoutResource(resourceId, memberEmail);});
    }

    //TCI 1.3
    @Test
    void databaseFailureTest() throws EmailFailureException, DatabaseFailureException
    {
        UUID resourceId= UUID.fromString("4d9a43ff-cc4e-4a19-8f8c-c8aaaa951934");
        String memberEmail = "moshy.marsh@ymail.com";

        when(resourceRepository.isResourceAvailable(resourceId)).thenReturn(true);
        when(resourceRepository.updateStatus(resourceId, false)).thenReturn(false);

        assertThrows(DatabaseFailureException.class, () -> {libraryService.checkoutResource(resourceId, memberEmail);});
    }

    //TCI 1.4
    @Test
    void unavailableResourceTest() throws EmailFailureException, DatabaseFailureException
    {
        UUID resourceId= UUID.fromString("4d9a43ff-cc4e-4a19-8f8c-c8aaaa951934");
        String memberEmail = "moshy.marsh@ymail.com";

        when(resourceRepository.isResourceAvailable(resourceId)).thenReturn(false);
        assertFalse(libraryService.checkoutResource(resourceId, memberEmail));
    }

    //TCI 1.5
    @Test
    void nullUUIDTest() throws EmailFailureException, DatabaseFailureException
    {
        UUID resourceId = null;
        String memberEmail = "moshy.marsh@ymail.com";

        assertFalse(libraryService.checkoutResource(resourceId, memberEmail));
    }

}