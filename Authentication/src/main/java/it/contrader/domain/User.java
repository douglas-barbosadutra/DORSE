package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import it.contrader.domain.enumeration.UserType;

/**
 * A User.
 */
@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "jhi_password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "telnumber")
    private String telnumber;

    @Column(name = "address")
    private String address;

    @Column(name = "ccc")
    private String ccc;

    @Column(name = "paymentstatus")
    private Boolean paymentstatus;

    @Column(name = "email")
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "usertype", nullable = false)
    private UserType usertype;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public User surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public User birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public User telnumber(String telnumber) {
        this.telnumber = telnumber;
        return this;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getAddress() {
        return address;
    }

    public User address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCcc() {
        return ccc;
    }

    public User ccc(String ccc) {
        this.ccc = ccc;
        return this;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public Boolean isPaymentstatus() {
        return paymentstatus;
    }

    public User paymentstatus(Boolean paymentstatus) {
        this.paymentstatus = paymentstatus;
        return this;
    }

    public void setPaymentstatus(Boolean paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getEmail() {
        return email;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public User usertype(UserType usertype) {
        this.usertype = usertype;
        return this;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (user.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "User{" +
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
