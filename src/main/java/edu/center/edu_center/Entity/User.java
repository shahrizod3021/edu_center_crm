package edu.center.edu_center.Entity;

import edu.center.edu_center.Entity.AbsEntities.AbsEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "users")
public class User extends AbsEntity implements UserDetails {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String middleName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    private String password;

    @ManyToOne
    private LidStatus lidStatus;

    @ManyToMany
    private List<Yoqlama> yoqlama;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> role;

    @ManyToMany
    private List<Course> courses;

    private boolean enabled = true;

    private boolean credintialNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean accauntNonExpired = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accauntNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credintialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public User(UUID id, String firstName, String lastName, String middleName, String phoneNumber, String password, LidStatus lidStatus, List<Course> courses) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.lidStatus = lidStatus;
        this.courses = courses;
    }

    public User(String firstName, String lastName, String middleName, String phoneNumber, String password, List<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}
