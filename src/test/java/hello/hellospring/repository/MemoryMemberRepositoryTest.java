package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

     MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("TEST");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("3");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("4");
        repository.save(member4);

        Member member5 = new Member();
        member5.setName("5");
        repository.save(member5);

        Member member6 = new Member();
        member6.setName("6");
        repository.save(member6);

        Member member7 = new Member();
        member7.setName("7");
        repository.save(member7);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(7);

    }


}
