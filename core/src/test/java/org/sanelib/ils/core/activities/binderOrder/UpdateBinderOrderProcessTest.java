package org.sanelib.ils.core.activities.binderOrder;

import org.junit.Test;
import org.sanelib.ils.EntityIntegrationTestBase;
import org.sanelib.ils.common.utils.DateHelper;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.sanelib.ils.core.commands.agency.UpdateAgency;
import org.sanelib.ils.core.commands.binderOrder.UpdateBinderOrder;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

public class UpdateBinderOrderProcessTest extends EntityIntegrationTestBase {

    @Autowired
    HibernateHelper hibernateHelper;

    @Test
    public void testUpdateBinderOrderProcess() throws Throwable {

        Library library = new Library();
        library.setId(hibernateHelper.getNextId(Library.class));
        library.setName("library");

        persist(library);

        BinderOrder binderOrder = new BinderOrder();

        binderOrder.setBinderOrderId(hibernateHelper.getNextId(BinderOrder.class, "binderOrderId.id"), library.getId());
        binderOrder.setBinderId(101);
        binderOrder.setOrderDate(DateHelper.constructDate(2015 , 11, 10));
        binderOrder.setDueDate(DateHelper.constructDate(2015 , 11, 25));
        binderOrder.setReturnedDate(DateHelper.constructDate(2015 , 11 , 24));
        binderOrder.setFormLetterNo("FormLetterNumber");
        binderOrder.setSubject("Subject");
        binderOrder.setContent("Content");
        binderOrder.setMailStatus("M");
        binderOrder.setPrintStatus("P");
        binderOrder.setStatus("SetStatus");
        binderOrder.setEntryId("EntryId");
        binderOrder.setEntryDate(DateHelper.constructDate(2015 , 11 ,10));

        persist(binderOrder);

        Date returnedDate = DateHelper.constructDate(2015 , 11 , 14);

        UpdateBinderOrder updateBinderOrder = new UpdateBinderOrder();

        updateBinderOrder.setId(binderOrder.getBinderOrderId().getId());
        updateBinderOrder.setLibraryId(library.getId());
        updateBinderOrder.setBinderId(101);
        updateBinderOrder.setOrderDate(DateHelper.constructDate(2015 , 11, 10));
        updateBinderOrder.setDueDate(DateHelper.constructDate(2015 , 11, 25));
        updateBinderOrder.setReturnedDate(returnedDate);
        updateBinderOrder.setFormLetterNo("Updated FormLetterNumber");
        updateBinderOrder.setSubject("Updated Subject");
        updateBinderOrder.setContent("Updated Content");
        updateBinderOrder.setMailStatus("M");
        updateBinderOrder.setPrintStatus("P");
        updateBinderOrder.setStatus("Updated Status");
        updateBinderOrder.setEntryId("EntryId");
        updateBinderOrder.setEntryDate(DateHelper.constructDate(2015 , 11 ,10));

        String result = execute(updateBinderOrder, ActivitiProcessConstants.Admin.UPDATE_BINDERORDER);

        assertNull(result);

        BinderOrder dbBinderOrder = fetch(BinderOrder.class, new BinderOrderId(library.getId(), binderOrder.getBinderOrderId().getId()));

        assertNotNull(dbBinderOrder);

        assertEquals(updateBinderOrder.getBinderId(), dbBinderOrder.getBinderId());
        assertEquals(updateBinderOrder.getOrderDate(), dbBinderOrder.getOrderDate());
        assertEquals(updateBinderOrder.getDueDate(), dbBinderOrder.getDueDate());
        assertEquals(updateBinderOrder.getReturnedDate(), dbBinderOrder.getReturnedDate());
        assertEquals(updateBinderOrder.getFormLetterNo(), dbBinderOrder.getFormLetterNo());
        assertEquals(updateBinderOrder.getSubject(), dbBinderOrder.getSubject());
        assertEquals(updateBinderOrder.getContent(), dbBinderOrder.getContent());
        assertEquals(updateBinderOrder.getMailStatus(), dbBinderOrder.getMailStatus());
        assertEquals(updateBinderOrder.getPrintStatus(), dbBinderOrder.getPrintStatus());
        assertEquals(updateBinderOrder.getStatus(), dbBinderOrder.getStatus());
        assertEquals(updateBinderOrder.getEntryId(), dbBinderOrder.getEntryId());
        assertEquals(updateBinderOrder.getEntryDate(), dbBinderOrder.getEntryDate());
    }
}
