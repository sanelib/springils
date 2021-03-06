package org.sanelib.ils.core.domain.entity;

import org.sanelib.ils.core.enums.PatronType;
import org.sanelib.ils.core.enums.PatronTypeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="patron")
public class Patron implements DomainEntity {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PatronCode patronCode;

    public PatronCode getPatronCode() {
        return patronCode;
    }

    public void setPatronCode(PatronCode patronCode) {
        this.patronCode = patronCode;
    }

    public void setPatronCode(String code, int libraryId){
        if(this.patronCode == null){
            this.patronCode = new PatronCode(libraryId, code);
        } else {
            this.patronCode.setCode(code);
            this.patronCode.setLibraryId(libraryId);
        }
    }

    @Column(name="patron_category_id")
    private Integer patronCategoryId;

    @Column(name = "owns")
    private String owns;

    @Column(name="other_library_patron_id")
    private Integer otherLibraryPatronId;

    @Column(name = "library_patron_id")
    private Integer libraryPatronId;

    //Value of Patron type can be either staff of library or patron
    @Convert( converter = PatronTypeConverter.class )
    @Column(name = "patron_type")
    private PatronType patronType;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "mname")
    private String middleName;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "address1")
    private String addressLine1;

    @Column(name = "address2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pin")
    private String pin;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Column(name = "paddress1")
    private String permanentAddressLine1;

    @Column(name = "paddress2")
    private String permanentAddressLine2;

    @Column(name = "pcity")
    private String permanentCity;

    @Column(name = "pstate")
    private String permanentState;

    @Column(name = "pcountry")
    private String permanentCountry;

    @Column(name = "ppin")
    private String permanentPin;

    @Column(name = "pphone1")
    private String permanentPhone1;

    @Column(name = "pphone2")
    private String permanentPhone2;

    @Column(name = "pfax")
    private String permanentFax;

    @Column(name = "pemail")
    private String permanentEmail;

    @Column(name = "membership_start_date")
    private Date membershipFrom;

    @Column(name = "membership_expiry_date")
    private Date membershipTo;

    @Column(name = "delinquency_reason")
    private String delinquencyReason;

    @Column(name = "common_email")
    private char commonEmail;

    @Column(name = "common_instant_msg")
    private char commonInstantMsg;

    @Column(name = "common_print")
    private char commonPrint;

    @Column(name="user_password")
    private String userPassword;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name="Custom")
    private String custom;

    @Column(name="privilege")
    private String privilege;

    @Column(name = "twitter_id")
    private String twitterId;

    @Column(name = "facebook_id")
    private String facebookId;

    @Column(name = "sub_location_id")
    private Integer subLocationId;

    @Column(name = "login_id")
    private String loginId;

    //TOCheck: content reason
    @Column(name = "authenticate_localdatabase")
    private String authenticateLocalDatabase;

    @Column(name = "status")
    private String isActive;

    @Column(name="send_to_address")
    private String sendToAddress;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name="entry_date")
    private Date entryDate;

    public Integer getPatronCategoryId() {
        return patronCategoryId;
    }

    public void setPatronCategoryId(Integer patronCategoryId) {
        this.patronCategoryId = patronCategoryId;
    }

    public String getOwns() {
        return owns;
    }

    public void setOwns(String owns) {
        this.owns = owns;
    }

    public Integer getOtherLibraryPatronId() {
        return otherLibraryPatronId;
    }

    public void setOtherLibraryPatronId(Integer otherLibraryPatronId) {
        this.otherLibraryPatronId = otherLibraryPatronId;
    }

    public Integer getLibraryPatronId() {
        return libraryPatronId;
    }

    public void setLibraryPatronId(Integer libraryPatronId) {
        this.libraryPatronId = libraryPatronId;
    }

    public PatronType getPatronType() {
        return patronType;
    }

    public void setPatronType(PatronType patronType) {
        this.patronType = patronType;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentAddressLine2() {
        return permanentAddressLine2;
    }

    public void setPermanentAddressLine2(String permanentAddressLine2) {
        this.permanentAddressLine2 = permanentAddressLine2;
    }

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(String permanentState) {
        this.permanentState = permanentState;
    }

    public String getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public String getPermanentPin() {
        return permanentPin;
    }

    public void setPermanentPin(String permanentPin) {
        this.permanentPin = permanentPin;
    }

    public String getPermanentPhone1() {
        return permanentPhone1;
    }

    public void setPermanentPhone1(String permanentPhone1) {
        this.permanentPhone1 = permanentPhone1;
    }

    public String getPermanentPhone2() {
        return permanentPhone2;
    }

    public void setPermanentPhone2(String permanentPhone2) {
        this.permanentPhone2 = permanentPhone2;
    }

    public String getPermanentFax() {
        return permanentFax;
    }

    public void setPermanentFax(String permanentFax) {
        this.permanentFax = permanentFax;
    }

    public String getPermanentEmail() {
        return permanentEmail;
    }

    public void setPermanentEmail(String permanentEmail) {
        this.permanentEmail = permanentEmail;
    }

    public Date getMembershipFrom() { return membershipFrom;  }

    public void setMembershipFrom(Date membershipFrom) { this.membershipFrom = membershipFrom; }

    public Date getMembershipTo() { return membershipTo; }

    public void setMembershipTo(Date membershipTo) { this.membershipTo = membershipTo; }

    public String getDelinquencyReason() {
        return delinquencyReason;
    }

    public void setDelinquencyReason(String delinquencyReason) {
        this.delinquencyReason = delinquencyReason;
    }

    public boolean commonEmail() {

        return commonEmail == 'Y';
    }

    public void setCommonEmail(boolean commonEmail) {

        this.commonEmail = commonEmail ? 'Y' : 'N';
    }

    public boolean commonInstantMsg() {

        return commonInstantMsg == 'Y';
    }

    public void setCommonInstantMsg(boolean commonInstantMsg) {

        this.commonInstantMsg = commonInstantMsg ? 'Y' : 'N';
    }

    public boolean commonPrint() {

        return commonPrint == 'Y';
    }

    public void setCommonPrint(boolean commonPrint) {

        this.commonPrint = commonPrint ? 'Y' : 'N';
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public boolean isActive() {
        return Objects.equals(isActive, "A");
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive ? "A" : "B";
    }

    public boolean isSendToAddress() {
        return Objects.equals(sendToAddress, "A");
    }

    public void setSendToAddress(boolean sendToAddress) {
        this.sendToAddress = sendToAddress ? "A" : "B";
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public Integer getSubLocationId() {
        return subLocationId;
    }

    public void setSubLocationId(Integer subLocationId) {
        this.subLocationId = subLocationId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getAuthenticateLocalDatabase() {
        return authenticateLocalDatabase;
    }

    public void setAuthenticateLocalDatabase(String authenticateLocalDatabase) {
        this.authenticateLocalDatabase = authenticateLocalDatabase;
    }

    @PrePersist
    public void prePersist() {
        if(!commonEmail()){
            setCommonEmail(false);
        }

        if(!commonInstantMsg()){
            setCommonInstantMsg(false);
        }

        if(!commonPrint()){
            setCommonPrint(false);
        }

        entryDate = new Date();

        if(createdOn == null){
            createdOn = entryDate;
        }
    }
}
