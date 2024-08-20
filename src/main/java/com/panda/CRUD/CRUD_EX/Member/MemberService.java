package com.panda.CRUD.CRUD_EX.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void register(Member member) {
        if(member.getUsername().trim().isEmpty()){
            throw new IllegalArgumentException("아이디를 입력해주세요.");
        }
        else if(member.getPassword().trim().isEmpty()){
            throw new IllegalArgumentException("비밀번호를 입력해주세요.");
        }
        else if(member.getUsername().length()>20){
            throw new IllegalArgumentException("아이디는 20 글자를 초과할 수 없습니다.");
        }
        else if(member.getPassword().length()>20){
            throw new IllegalArgumentException("비밀번호는 20 글자를 초과할 수 없습니다.");
        }
        else if(memberRepository.findById(member.getUsername()).isPresent()){
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }

        memberRepository.save(member);
    }
}
