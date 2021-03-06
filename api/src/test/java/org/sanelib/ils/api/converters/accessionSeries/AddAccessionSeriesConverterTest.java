package org.sanelib.ils.api.converters.accessionSeries;

import org.junit.Test;
import org.sanelib.ils.api.dto.accessionSeries.AccessionSeriesDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.accessioSeries.AddAccessionSeries;
import org.sanelib.ils.core.exceptions.ProcessError;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddAccessionSeriesConverterTest {

    @Test
    public void testValidDataShouldConvertDtoToCommand() throws Exception{

        AccessionSeriesDto dto = new AccessionSeriesDto();

        dto.setLibraryId("1");
        dto.setCode("AC1");
        dto.setAccessionSeriesType("Fixed");
        dto.setPrefix("AS");
        dto.setMaxNumber("100");
        dto.setMaxZero("2");

        ProcessError processError = new ProcessError();

        AddAccessionSeriesConverter addAccessionSeriesConverter = new AddAccessionSeriesConverter();
        ProcessCommand command = addAccessionSeriesConverter.convert(dto, processError);

        assertTrue("Conversion error occurred", processError.isValid());
        assertTrue("Wrong output " + command, command instanceof AddAccessionSeries);

        AddAccessionSeries addAccessionSeries = (AddAccessionSeries) command;

        assertEquals("Library Id is not mapped", dto.getLibraryId(), String.valueOf(addAccessionSeries.getLibraryId()));
        assertEquals("Code is not mapped", dto.getCode(), addAccessionSeries.getCode());
        assertEquals("Prefix of series not mapped",dto.getPrefix(), addAccessionSeries.getPrefix());
        assertEquals("Type of series not mapped", dto.getAccessionSeriesType(), addAccessionSeries.getAccessionSeriesType().getName());
        assertEquals("Max Number of series not mapped", dto.getMaxNumber(), String.valueOf(addAccessionSeries.getMaxNumber()));
        assertEquals("Max Zero of series not mapped", dto.getMaxZero(), String.valueOf(addAccessionSeries.getMaxZero()));
    }
}
