package com.madislav.store.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Length(min = 3, max = 20, message = "Check if your username has from 5 to 20 characters")
    private String name;

    @NotEmpty
    @Email(message = "It's not like an email")
    @Length(min = 5, max = 20, message = "Email incorrect")
    private String email;

    @NotEmpty
    @Length(min = 2, max = 20, message = "First name must contains from 2 to 20 characters")
    private String firstName;

    @NotEmpty
    @Length(min = 2, max = 20, message = "Last name must contains from 2 to 20 characters")
    private String lastName;

    @NotBlank(message = "")
    @Valid
    @Length(min = 3, message = "Password must contains from 6 to 20 characters")
    private String password;

    @Length(min = 10, max = 10, message = "Format: 0**")
    private String phone;

    private String state = State.ACTIVE.getState();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_userprofile",
            joinColumns = {@JoinColumn(name = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "userprofile_id")})
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    public Customer() {
    }
    //getters and setters

    @Valid
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Valid
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Valid
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Valid
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@JsonIgnore
    @Valid
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Valid
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Valid
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
