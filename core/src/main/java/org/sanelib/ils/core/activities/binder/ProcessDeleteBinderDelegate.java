package org.sanelib.ils.core.activities.binder;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.binder.DeleteBinder;
import org.sanelib.ils.core.dao.BinderRepository;
import org.sanelib.ils.core.domain.entity.Binder;
import org.sanelib.ils.core.domain.entity.BinderId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeleteBinderDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDeleteBinderDelegate.class);

    @Autowired
    BinderRepository binderRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Delete Binder called");

        DeleteBinder command = (DeleteBinder) execution.getVariable("command");
        Binder Binder = this.binderRepository.load(new BinderId(command.getLibraryId(), command.getId()));

        binderRepository.remove(Binder);
	}
}
