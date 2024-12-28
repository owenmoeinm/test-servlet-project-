package ir.mrmoein.demo2.repository.impl;

import ir.mrmoein.demo2.model.UserModel;
import ir.mrmoein.demo2.repository.UserRepository;
import ir.mrmoein.demo2.util.EmFactor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserRepoImpl extends BaseRepoImpl<UserModel> implements UserRepository {

    private final EntityManagerFactory emf = EmFactor.getEmf();


    @Override
    public UserModel findByUserPass(String username, String pass) {
        try (EntityManager em = emf.createEntityManager()) {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<UserModel> query = criteriaBuilder.createQuery(UserModel.class);
            Root<UserModel> root = query.from(UserModel.class);

            Predicate username1 = criteriaBuilder.equal(root.get("username"), username);
            Predicate password = criteriaBuilder.equal(root.get("password"), pass);

            query.where(username1 , password);

            TypedQuery<UserModel> query1 = em.createQuery(query);
            return query1.getSingleResult();

        } catch (Exception e) {
            throw new RuntimeException("this exception for find By user pass " + e.getMessage());
        }
    }

    @Override
    public UserModel findByUserEmail(String username , String email) {
        return null;
        // todo this method and jsp must be complete
    }

    @Override
    public void changePass(String pass) {
        // todo this method and jsp must be complete
    }

    @Override
    public Class<UserModel> customize() {
        return UserModel.class;
        // todo this method and jsp must be complete
    }
}
