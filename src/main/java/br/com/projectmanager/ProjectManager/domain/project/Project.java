package br.com.projectmanager.ProjectManager.domain.project;

import br.com.projectmanager.ProjectManager.domain.folder.Folder;
import br.com.projectmanager.ProjectManager.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {
    private @Id @GeneratedValue Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    private Folder folder;

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    private List<User> ownerUsers = new ArrayList<>();

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Folder folder) {
        this.name = name;
        this.folder = folder;
    }

    public Project(String name, List<User> ownerUsers) {
        this.name = name;
        this.ownerUsers = ownerUsers;
    }

    public List<User> getOwnerUsers() {
        return ownerUsers;
    }

    public String getName() {
        return name;
    }

    public Folder getFolder() {
        return folder;
    }
}
