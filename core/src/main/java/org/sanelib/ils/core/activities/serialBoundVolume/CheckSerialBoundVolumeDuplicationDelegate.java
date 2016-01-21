package org.sanelib.ils.core.activities.serialBoundVolume;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.serialBoundVolume.AddSerialBoundVolume;
import org.sanelib.ils.core.commands.serialBoundVolume.UpdateSerialBoundVolume;
import org.sanelib.ils.core.dao.SerialBoundVolumeRepository;
import org.sanelib.ils.core.domain.entity.SerialBoundVolume;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckSerialBoundVolumeDuplicationDelegate implements JavaDelegate {

    @Autowired
    SerialBoundVolumeRepository serialBoundVolumeRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Checking serialBoundVolume for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateSerialBoundVolume;

        Integer serialBoundVolumeId = isUpdate ? ((UpdateSerialBoundVolume) command).getId() : null;
        Integer libraryId = ((AddSerialBoundVolume) command).getLibraryId();
        String serialBoundVolumeName = ((AddSerialBoundVolume) command).getName();

        List<SerialBoundVolume> agencies = serialBoundVolumeRepository.findByColumnAndValue(new String[]{"serialBoundVolumeId.libraryId", "name"}, new Object[] {libraryId, serialBoundVolumeName});

        SerialBoundVolume dbSerialBoundVolume = agencies.isEmpty() ? null : agencies.get(0);

        if(dbSerialBoundVolume != null && (!isUpdate || !Objects.equals(serialBoundVolumeId, dbSerialBoundVolume.getSerialBoundVolumeId().getId()))){
            processError.addError("common.field.duplicate", "name", Arrays.asList("domain.entity.library", "domain.serialBoundVolume.name"), serialBoundVolumeName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
