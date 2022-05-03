package br.com.projectmanager.ProjectManager.application.folder;

import br.com.projectmanager.ProjectManager.application.project.ProjectNotFoundException;
import br.com.projectmanager.ProjectManager.domain.folder.Folder;
import br.com.projectmanager.ProjectManager.domain.folder.FolderRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class FolderUseCase {
    private final FolderRepository repository;

    public FolderUseCase(FolderRepository repository) {
        this.repository = repository;
    }

    public List<Folder> findAll() {
        return repository.findAll();
    }

    public Folder findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }
}
