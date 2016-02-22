package org.sanelib.ils.core.activities.department;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.department.AddDepartment;
import org.sanelib.ils.core.commands.department.UpdateDepartment;
import org.sanelib.ils.core.dao.DepartmentRepository;
import org.sanelib.ils.core.domain.entity.Department;
import org.sanelib.ils.core.exceptions.AppException;
import org.sanelib.ils.core.exceptions.ProcessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CheckDepartmentDuplicationDelegate implements JavaDelegate {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Checking department for duplication");

        Object command = execution.getVariable("command");
        ProcessError processError = (ProcessError) execution.getVariable("errors");

        boolean isUpdate = command instanceof UpdateDepartment;

        Integer departmentId = isUpdate ? ((UpdateDepartment) command).getId() : null;
        Integer libraryId = ((AddDepartment) command).getLibraryId();
        String deptName = ((AddDepartment)command).getDeptName();
        List<Department> departments = departmentRepository.findByColumnAndValue(new String[]{"departmentId.libraryId", "deptName"}, new Object[] {libraryId, deptName});
        Department dbDept = departments.isEmpty() ? null : departments.get(0);

        if(dbDept != null && (!isUpdate || !Objects.equals(departmentId, dbDept.getDepartmentId().getId()))){
            processError.addError("common.field.duplicate", "deptName", Arrays.asList("domain.entity.library", "domain.department.name"), deptName);
        }

        if(!processError.isValid()){
            throw new AppException(processError);
        }
    }
}
