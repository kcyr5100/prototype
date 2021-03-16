package repository.interfaces;

import domain.DocumentType;

public interface IDocumentTypeRepository {
    DocumentType[] getAll();
}
