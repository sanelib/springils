package org.sanelib.ils.api.dto.course;


import org.sanelib.ils.api.dto.DtoWithId;
import org.sanelib.ils.api.dto.DtoWithLibraryId;

public class CourseDto implements DtoWithId,DtoWithLibraryId {
    private String id;
    private String libraryId;
    private String name;
    private String hodId;
    private String entryId;
    private String entryDate;
    private String pCourseId;

    public void setId(String id) {  this.id = id;    }

    public String getId() {  return this.id;    }

    public void setLibraryId(String libraryId) {    this.libraryId = libraryId;    }

    public String getLibraryId() {    return this.libraryId;    }

    public String getName() {    return name;    }

    public void setName(String name) {    this.name = name;    }

    public String getHodId() {   return hodId;    }

    public void setHodId(String hodId) {    this.hodId = hodId;    }

    public String getEntryId() {   return entryId;    }

    public void setEntryId(String entryId) {   this.entryId = entryId;    }

    public String getEntryDate() {   return entryDate;    }

    public void setEntryDate(String entryDate) {     this.entryDate = entryDate;    }

    public String getpCourseId() {    return pCourseId;    }

    public void setpCourseId(String pCourseId) {    this.pCourseId = pCourseId;    }

}
