package repository.interfaces;

import domain.Documents;

public interface IDocumentRepository {
    Documents[] getAll();
    int create(Documents document);
    int update(Documents document);
    int delete(int id);
}
