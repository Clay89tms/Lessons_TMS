package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.domain.Phone;
import org.example.domain.Report;
import org.example.domain.Role;
import org.example.domain.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService {

    private final SessionFactory factory;

    public void save(UserEntity user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Phone> phones = user.getPhones();

        phones.forEach(session::save);

//        user.setPhones(phones);

        session.save(user);

        user.setPhones(phones);

//        phones.forEach(phone -> phone.setUser(user));
        phones.forEach(phone -> session.save(phone));


        transaction.commit();
        session.close();
    }

    public UserEntity get(Integer id) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity userEntity = session.find(UserEntity.class, id);
        List<Phone> phones = userEntity.getPhones();
        phones.stream()
                .forEach(System.out::println);
//        System.out.println(userEntity);
        transaction.commit();
        session.close();

        return userEntity;

    }

    public Phone getPhone(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Phone phone = session.find(Phone.class, id);
        transaction.commit();
        session.close();

        return phone;
    }

    public Phone delete(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        session.delete(phone);
        transaction.commit();
        session.close();

        return phone;
    }

    public Set<Report> getByRole(Role role){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

//        Query query = session.createQuery("from UserEntity where role = :role", UserEntity.class);
//        Query query = session.createQuery("from UserEntity as ue left join fetch ue.phones where ue.role = :role", UserEntity.class);
        Query query = session.createQuery("select new org.example.domain.Report(p.login, p.role) from UserEntity as p  where p.role = :role", Report.class);
        query.setParameter("role", role);
        List<Report> list = query.list();

        transaction.commit();
        session.close();

        return new HashSet<>(list);
    }

}
