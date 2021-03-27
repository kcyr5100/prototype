package repository;

import domain.Users;

public interface IUsersRepository {
    Users[] getAll();
    int create(Users user);
    int update(Users user);
    int delete(int id);
}
