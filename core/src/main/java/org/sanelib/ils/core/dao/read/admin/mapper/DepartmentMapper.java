package org.sanelib.ils.core.dao.read.admin.mapper;

import org.sanelib.ils.core.dao.read.DataResultSet;
import org.sanelib.ils.core.dao.read.ViewMapper;
import org.sanelib.ils.core.domain.view.admin.DepartmentView;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class DepartmentMapper implements ViewMapper<DepartmentView> {

    public DepartmentView map(final DataResultSet rs) throws SQLException {

        final String viewName = "department";

        final DepartmentView view = new DepartmentView();

        view.setLibraryId(rs.getInt(viewName, "library_id"));
        view.setId(rs.getInt(viewName, "dept_id"));
        view.setDeptName(rs.getString(viewName, "dept_name"));
        view.setHodId(rs.getString(viewName, "hod_id"));
        view.setEntryId(rs.getString(viewName, "entry_id"));
        view.setEntryDate(rs.getDate(viewName, "entry_date"));

        return view;
    }
}

