package org.sanelib.ils.api.converters.patronCategory;

import com.google.common.base.Strings;
import org.sanelib.ils.api.converters.ConverterHelper;
import org.sanelib.ils.api.converters.DtoToCommandConverter;
import org.sanelib.ils.api.dto.patronCategory.PatronCategoryDto;
import org.sanelib.ils.core.commands.ProcessCommand;
import org.sanelib.ils.core.commands.patronCategory.AddPatronCategory;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.stereotype.Component;

@Component
public class AddPatronCategoryConverter implements DtoToCommandConverter<PatronCategoryDto> {

    @Override
    public ProcessCommand convert(PatronCategoryDto dto, ProcessError processError) throws NoSuchFieldException, IllegalAccessException {
        AddPatronCategory command = new AddPatronCategory();

        ConverterHelper.checkLibraryIdRequired(dto, command, processError);

        //Check name and convert
        if(Strings.isNullOrEmpty(dto.getName())){
            processError.addError("common.field.required", "name", "domain.common.name");
        } else{
            command.setName(dto.getName());
        }

        command.setAllowILLFromNet(dto.isAllowILLFromNet());
        command.setAllowRenewalFromNet(dto.isAllowRenewalFromNet());

        command.setOverallLoanLimit(ConverterHelper.checkOptionalPositiveInteger("overallLoanLimit", dto.getOverallLoanLimit(), "domain.patronCategory.overallLoanLimit", 0, processError));

        command.setAllowMultipleCopies(dto.isAllowMultipleCopies());
        command.setAcqWorkflow(dto.getAcqWorkflow());

        return command;
    }
}
