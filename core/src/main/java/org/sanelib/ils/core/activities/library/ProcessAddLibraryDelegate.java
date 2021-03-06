package org.sanelib.ils.core.activities.library;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.sanelib.ils.core.commands.library.AddLibrary;
import org.sanelib.ils.core.dao.HibernateHelper;
import org.sanelib.ils.core.dao.LibraryRepository;
import org.sanelib.ils.core.domain.entity.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessAddLibraryDelegate implements JavaDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessAddLibraryDelegate.class);

    @Autowired
    HibernateHelper hibernateHelper;

    @Autowired
    LibraryRepository libraryRepository;

    @Override
	public void execute(DelegateExecution execution) throws Exception {
		LOG.info("Process Add Library called");

        AddLibrary command = (AddLibrary) execution.getVariable("command");

        Library entity = new Library();

        entity.setId(hibernateHelper.getNextId(Library.class));
        entity.setName(command.getName());
        entity.setCity(command.getCity());
        entity.setState(command.getState());
        entity.setCountry(command.getCountry());

        libraryRepository.save(entity);

        execution.setVariable("result", entity.getId());
	}
}
