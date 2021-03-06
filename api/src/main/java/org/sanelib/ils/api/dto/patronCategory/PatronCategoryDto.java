package org.sanelib.ils.api.dto.patronCategory;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class PatronCategoryDto implements DtoWithId, DtoWithLibraryId {

    private String libraryId;
    private String id;
    private String name;
    private boolean allowILLFromNet;
    private boolean allowRenewalFromNet;
    private String overallLoanLimit;
    private boolean allowMultipleCopies;
    private String acqWorkflow;

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllowILLFromNet() {
        return allowILLFromNet;
    }

    public void setAllowILLFromNet(boolean allowILLFromNet) {
        this.allowILLFromNet = allowILLFromNet;
    }

    public boolean isAllowRenewalFromNet() {
        return allowRenewalFromNet;
    }

    public void setAllowRenewalFromNet(boolean allowRenewalFromNet) {
        this.allowRenewalFromNet = allowRenewalFromNet;
    }

    public String getOverallLoanLimit() {
        return overallLoanLimit;
    }

    public void setOverallLoanLimit(String overallLoanLimit) {
        this.overallLoanLimit = overallLoanLimit;
    }

    public boolean isAllowMultipleCopies() {
        return allowMultipleCopies;
    }

    public void setAllowMultipleCopies(boolean allowMultipleCopies) {
        this.allowMultipleCopies = allowMultipleCopies;
    }

    public String getAcqWorkflow() {
        return acqWorkflow;
    }

    public void setAcqWorkflow(String acqWorkflow) {
        this.acqWorkflow = acqWorkflow;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
