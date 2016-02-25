package org.sanelib.ils.api.services.fiscalYear;

import org.sanelib.ils.api.dto.fiscalYear.FiscalYearDto;
import org.sanelib.ils.api.services.ApiEndPointConstants;
import org.sanelib.ils.api.services.ApiServiceBase;
import org.sanelib.ils.core.activities.ActivitiProcessConstants;
import org.springframework.stereotype.Component;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path(ApiEndPointConstants.Admin.FISCAL_YEAR_END_POINT)
@Produces(MediaType.APPLICATION_JSON)
public class FiscalYearService extends ApiServiceBase {

    @GET
    public List getAllFiscalYears() throws Throwable {
        return fetchAll(ViewNameConstants.Admin.FISCALYEAR);
    }

    @POST
    public String addFiscalYear(FiscalYearDto fiscalYearDTO) throws Throwable {
        return execute(fiscalYearDTO, ActivitiProcessConstants.Admin.ADD_FISCALYEAR);
    }

    @PUT
    public String updateFiscalYear(FiscalYearDto fiscalYearDTO) throws Throwable {
        return execute(fiscalYearDTO, ActivitiProcessConstants.Admin.UPDATE_FISCALYEAR);
    }

    @DELETE
    @Path("/{libraryId}/{id}")
    public String deleteFiscalYear(@PathParam("libraryId") String libraryId, @PathParam("id") String id) throws Throwable {
        FiscalYearDto fiscalYearDto = new FiscalYearDto();

        fiscalYearDto.setLibraryId(libraryId);
        fiscalYearDto.setId(id);

        return execute(fiscalYearDto, ActivitiProcessConstants.Admin.DELETE_FISCALYEAR);
    }
}
