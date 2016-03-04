package org.sanelib.ils.api.converters.binder;


import org.junit.Test;
import org.sanelib.ils.api.dto.binder.BinderDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.binder.DeleteBinder;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteBinderConverterTest {

    @Test
    public void testDeleteBinderSuccessExecute() throws Exception{

        BinderDto dto = new BinderDto();

        dto.setId("1");
        dto.setLibraryId("1");

        ProcessError processError= new ProcessError();

        DeleteBinderConverter converter = new DeleteBinderConverter();
        ProcessCommand command = converter.convert(dto , processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof DeleteBinder);

        DeleteBinder deleteBinder = (DeleteBinder) command;

        assertEquals("Id is not mapped", dto.getId(), String.valueOf(deleteBinder.getId()));
        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(deleteBinder.getLibraryId()));
    }

}
