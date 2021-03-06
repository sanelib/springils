package org.sanelib.ils.core.activities.bindingType;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.bindingType.AddBindingType;
import org.sanelib.ils.core.dao.BindingTypeRepository;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.domain.entity.BindingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddBindingTypeDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddBindingTypeDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    BindingTypeRepository bindingTypeRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        LOG.info("Process Add Binding Type called");

        AddBindingType command = (AddBindingType) execution.getVariable("command");

        BindingType entity = new BindingType();
        Integer nextId = hibernateHelper.getNextId(BindingType.class, "bindingTypeId.id");

        entity.setBindingTypeId(nextId, command.getLibraryId());
        entity.setBindType(command.getBindType());
        entity.setPrice(command.getPrice());
        entity.setUserCode(command.getUserCode());

        bindingTypeRepository.save(entity);

        execution.setVariable("result", entity.getBindingTypeId().getId());
    }
}
