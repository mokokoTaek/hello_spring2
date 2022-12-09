package hello.hello_spring2.repository;

import hello.hello_spring2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Integer> {
    @Transactional
    Member findBySeq(int seq);

    @Transactional
    int deleteBySeq(int seq);

    @Transactional
    Member findById(String id);

    @Transactional
    Member findByIdAndPw(String id,String pw);
}
