package it.contrader.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import it.contrader.domain.enumeration.UserType;

/**
 * A DTO for the User entity.
 */
public class UserDTO implements Serializable {

    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String name;

    private String surname;

    private LocalDate birthdate;

    private String telnumber;

    private String address;

    private String ccc;

    private Boolean paymentstatus;

    private String email;

    @NotNull
    private UserType usertype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public Boolean isPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(Boolean paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDTO userDTO = (UserDTO) o;
        if (userDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", birthdate='" + getBirthdate() + "'" +
            ", telnumber='" + getTelnumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", ccc='" + getCcc() + "'" +
            ", paymentstatus='" + isPaymentstatus() + "'" +
            ", email='" + getEmail() + "'" +
            ", usertype='" + getUsertype() + "'" +
            "}";
    }
}
