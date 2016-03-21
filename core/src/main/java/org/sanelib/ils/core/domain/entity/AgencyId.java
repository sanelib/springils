package org.sanelib.ils.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AgencyId implements Serializable, LibraryIdAndEntityId {

    public AgencyId(){

    }

    public AgencyId(Integer libraryId, Integer id) {
        this.libraryId = libraryId;
        this.id = id;
    }

    @Column(name = "library_id")
    private int libraryId;

    @Column(name = "agency_id")
    private int id;

    @Override
    public int getLibraryId() {
        return libraryId;
    }

    @Override
    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        if (this.id != 0 && this.id != id) {
            throw new IllegalStateException("The ID must not be changed after it is set.");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgencyId agencyId = (AgencyId) o;

        return libraryId == agencyId.libraryId && id == agencyId.id;
    }

    @Override
    public int hashCode() {
        int result = libraryId;
        result = 31 * result + id;
        return result;
    }
}
