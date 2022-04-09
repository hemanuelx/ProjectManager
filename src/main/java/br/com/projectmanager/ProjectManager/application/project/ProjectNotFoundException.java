package br.com.projectmanager.ProjectManager.application.project;

public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(Long id) {
        super("Could not found project " + id);
    }
}
