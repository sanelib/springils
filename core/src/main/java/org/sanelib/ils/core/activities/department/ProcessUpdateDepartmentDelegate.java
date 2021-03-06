package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.UpdateDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.domain.entity.DepartmentId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessUpdateDepartmentDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessUpdateDepartmentDelegate.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOG.info("Process Update Department called");

        UpdateDepartment command = (UpdateDepartment) execution.getVariable("command");

        Department entity = departmentRepository.get(new DepartmentId(command.getLibraryId(), command.getId()));

        entity.setName(command.getName());
        entity.setHodId(command.getHodId());

        departmentRepository.save(entity);
    }
}
