package com.github.duc010298.cms.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "app_user")
public class AppUserEntity {
    private int id;
    private String userName;
    private String encryptedPassword;
    private String fullName;
    private Collection<AppRoleEntity> appRoleEntities;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "encrypted_password")
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserEntity that = (AppUserEntity) o;
        return id == that.id &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(encryptedPassword, that.encryptedPassword) &&
                Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, encryptedPassword, fullName);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false))
    public Collection<AppRoleEntity> getAppRoleEntities() {
        return appRoleEntities;
    }

    public void setAppRoleEntities(Collection<AppRoleEntity> appRoleEntities) {
        this.appRoleEntities = appRoleEntities;
    }
}
