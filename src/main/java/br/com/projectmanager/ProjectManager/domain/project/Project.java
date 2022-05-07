package br.com.projectmanager.ProjectManager.domain.project;

import br.com.projectmanager.ProjectManager.domain.folder.Folder;

import javax.persistence.*;

@Entity
public class Project {
    private @Id @GeneratedValue Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    private Folder folder;



    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Folder folder) {
        this.name = name;
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public Folder getFolder() {
        return folder;
    }
}
