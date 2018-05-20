package Repository;

import Domain.Users;

public interface RepoUserInterface extends IRepository<Users> {
    boolean checkUser(Users users);
}
