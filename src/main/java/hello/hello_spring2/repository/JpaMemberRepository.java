package hello.hello_spring2.repository;

import hello.hello_spring2.domain.Member;

import javax.persistence.EntityManager;
import java.util.Optional;


public class JpaMemberRepository implements MemberRepository{


    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }


//    @Override
//    public Member save(Member member) {
//        em.persist(member);
//        return member;
//    }

//    @Override
//    public Optional<Member> findById() {
//        return Optional.empty();
//    }
}
