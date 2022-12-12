package hello.hello_spring2.controller;

import hello.hello_spring2.domain.Member;
import hello.hello_spring2.repository.JpaMemberRepository;
import hello.hello_spring2.repository.MemberRepository;
import hello.hello_spring2.repository.SpringDataJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private SpringDataJpaMemberRepository sdjr;

    @PostMapping(value = "member/signup")
    public String singup(Member member) {

        Member meberSave = sdjr.save(member);
        return "sigupClear";
    }

//    @PostMapping(value = "member/signup")
//    public String singup(@RequestParam("id") String id, @RequestParam("pw") String pw) {
//
//        Member member = Member.builder().id(id).pw(pw).build();
//        Member meberSave = sdjr.save(member);
//
//        return "sigupClear";
//    }

    @PostMapping(value = "member/selectBySeq")
    public String selectBySeq(@RequestParam("selectSeq") int selectSeq, Model model){

        //Member member= Member.builder().seq(selectSeq).build();

        Member selectMember = sdjr.findBySeq(selectSeq);

        model.addAttribute("seq",selectMember.getSeq());
        model.addAttribute("id",selectMember.getId());
        model.addAttribute("pw",selectMember.getPw());
        return "selectClear";
    }

    @GetMapping(value = "member/selectAll")
    public String selectAll(Model model){

        List<Member>  list = sdjr.findAll();
        model.addAttribute("list",list);

        return "selectAllClear";
    }

    @PostMapping(value="member/deleteBySeq")
    public String deleteBySeq(@RequestParam("deleteSeq") int seq){

    sdjr.deleteBySeq(seq);
        System.out.println("삭제 완료!");
    return "redirect:/member/selectAll";
    }

    @PostMapping(value = "member/selectByID")
    public String selectByID(@RequestParam("selectID") String id, Model model){

        Member selectMember = sdjr.findById(id);

        model.addAttribute("member",selectMember);

        return "selectByIdClear";
    }

    @PostMapping(value = "member/selectByIDAndPw")
    public String selectByIDAndPw(@RequestParam("selectID") String id, @RequestParam("selectPw") String pw,Model model){

        Member selectMember = sdjr.findByIdAndPw(id,pw);

        model.addAttribute("member",selectMember);

        return "selectByIdAndPwClear";
    }
}
