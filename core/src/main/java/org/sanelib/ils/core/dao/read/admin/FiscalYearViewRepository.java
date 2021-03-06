package org.sanelib.ils.core.dao.read.admin;

import org.sanelib.ils.core.dao.read.ViewService;
import org.sanelib.ils.core.dao.read.ViewServiceHelper;
import org.sanelib.ils.core.dao.read.admin.mapper.FiscalYearMapper;
import org.sanelib.ils.core.domain.view.admin.FiscalYearView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class FiscalYearViewRepository implements ViewService {

    @Autowired
    FiscalYearMapper mapper;

    @Autowired
    ViewServiceHelper viewServiceHelper;

    protected String getStatement() {
        return "select * from acc_fiscal_year";
    }

    public List<FiscalYearView> getAll() throws Throwable {

        return viewServiceHelper.loadQuery(getStatement(), mapper);
    }
}
