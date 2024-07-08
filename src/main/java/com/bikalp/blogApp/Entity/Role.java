package com.bikalp.blogApp.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_tb")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_seq_gen")
    @SequenceGenerator(name = "role_seq_gen",sequenceName = "seq_gen",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
