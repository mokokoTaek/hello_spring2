package hello.hello_spring2.domain;

import lombok.*;

import javax.persistence.*;

//@Builder
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "example")
@SequenceGenerator(
                name = "example_seq_generator"
                , sequenceName = "example_seq"
                , initialValue = 1
                , allocationSize = 1
        )
        public class Member {

            @Id
            @GeneratedValue(
                    strategy = GenerationType.SEQUENCE
                    , generator = "example_seq_generator"
        )
        @Column(name = "seq")
        private int seq;


//    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ex_seq")
//    @SequenceGenerator(sequenceName = "example_seq",allocationSize = 1, name = "ex_seq")



    @Column(name = "id")
    private String id;

    @Column(name = "pw")
    private String pw;

    @Builder
    public Member(int seq, String id, String pw){
        this.seq=seq;
        this.id=id;
        this.pw=pw;
    }

}
