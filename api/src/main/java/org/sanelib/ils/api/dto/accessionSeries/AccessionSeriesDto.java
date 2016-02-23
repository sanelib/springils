package org.sanelib.ils.api.dto.accessionSeries;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.sanelib.ils.api.dto.DtoWithCode;
import org.sanelib.ils.api.dto.DtoWithLibraryId;
import org.sanelib.ils.core.enums.AccessionSeriesType;

public class AccessionSeriesDto implements DtoWithCode, DtoWithLibraryId {

    private String libraryId;
    private String code;
    private String maxNumber;
    private String maxZero;
    private String prefix;
    private String typeName;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getLibraryId() {
        return this.libraryId;
    }

    public void setLibraryId(String libraryId){
        this.libraryId = libraryId;
    }

    public String getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getMaxZero() {
        return maxZero;
    }

    public void setMaxZero(String maxZero) {
        this.maxZero = maxZero;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public AccessionSeriesType getTypeName() {
        return typeName;
    }

    public void setTypeName(String  typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

