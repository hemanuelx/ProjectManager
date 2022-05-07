package br.com.projectmanager.ProjectManager.domain.folder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Folder {
    private @Id
    @GeneratedValue Long id;

    private String name;

    @OneToMany(targetEntity = Folder.class, cascade = CascadeType.ALL)
    private final Set<Folder> children = new HashSet<>();
    public Folder() {
    }

    public Folder(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Folder> getChildren() {
        return children;
    }

    public void addKidFolder(Folder folder) {
        children.add(folder);
    }
}
