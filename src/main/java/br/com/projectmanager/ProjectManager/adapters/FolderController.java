package br.com.projectmanager.ProjectManager.adapters;

import br.com.projectmanager.ProjectManager.application.folder.FolderUseCase;
import br.com.projectmanager.ProjectManager.domain.folder.Folder;
import br.com.projectmanager.ProjectManager.domain.folder.FolderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FolderController {
    private final FolderUseCase folderUseCase;

    public FolderController(FolderRepository repository) {
        this.folderUseCase = new FolderUseCase(repository);
    }

    @GetMapping("/folders")
    public List<Folder> findAll() {
        return this.folderUseCase.findAll();
    }

    @GetMapping("/folders/{id}")
    public Folder findById(@PathVariable long id) {
        return this.folderUseCase.findById(id);
    }
}
