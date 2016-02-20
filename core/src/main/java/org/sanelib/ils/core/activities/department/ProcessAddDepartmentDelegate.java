package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddDepartmentDelegate implements JavaDelegate {

    @Autowired
    HibernateHelper hibernateHelper;
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Process Add Department called");

        AddDepartment command = (AddDepartment) execution.getVariable("command");

        Department entity = new Department();

        Integer nextId = hibernateHelper.getNextId(Department.class, "departmentId.id");
        entity.setDepartmentId(nextId, command.getLibraryId());
        entity.setDeptName(command.getDeptName());
        entity.setHodId(command.getHodId());
        entity.setEntryId(command.getEntryId());

        departmentRepository.save(entity);

        execution.setVariable("result", entity.getDepartmentId().getId());
    }
}
