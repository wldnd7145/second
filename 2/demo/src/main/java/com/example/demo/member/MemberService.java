package com.example.demo.member;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 비즈니스 로직을 처리(Service)를 처리하기 위한 클래스에 설정합니다.
public class MemberService {

    @Autowired // MemberMapper 인스턴스를 주입받기 위해 사용됩니다.
    private MemberMapper memberMapper;

    /**
     * 주어진 이름으로 회원 정보를 조회합니다.
     * 
     * @param name 회원 이름
     * @return 조회된 회원 정보
     * @throws NoSuchElementException 회원 정보가 없을 경우 예외 발생
     */
    // public Member getMember(String name) throws NoSuchElementException {
    // Member member = memberMapper.getMemberByName(name);

    // if (member == null) {
    // // 조회된 member가 없을 경우 NoSuchElementException 예외를 던집니다.
    // throw new NoSuchElementException("Not Found Member");
    // }
    // return member;
    // }

    // 실습
    public Member getMemberById(String id) throws NoSuchElementException {
        Member member = memberMapper.getMemberById(id);
        if (member == null) {
            throw new NoSuchElementException("Not Found Member");
        }
        return member;
    }

    public Member updatMember(Member member) throws NoSuchElementException {
        Member find = getMemberById(member.getId());
        if (find == null) {
            throw new NoSuchElementException("Not Found Member");
        }
        memberMapper.update(member);
        return member;
    }

    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    public Member signIn(String id, String pw) throws NoSuchElementException {
        Member member = memberMapper.getMemberById(id);
        if (member == null) {
            throw new NoSuchElementException("존재하지 않는 아이디입니다.");
        }

        if (!(pw).equals(member.getPw())) {
            throw new NoSuchElementException("비밀번호를 확인해주세요.");
        }

        return member;
    }
}

// @Service // 비즈니스 로직을 처리(Service)를 처리하기 위한 클래스에 설정합니다.
// public class MemberService {

// @Autowired // MemberMapper 인스턴스를 주입받기 위해 사용됩니다.
// private MemberMapper memberMapper;

// /**
// * 주어진 이름으로 회원 정보를 조회합니다.
// *
// * @param name 회원 이름
// * @return 조회된 회원 정보
// * @throws NoSuchElementException 회원 정보가 없을 경우 예외 발생
// */
// public Member getMember(String name) throws NoSuchElementException {
// Member member = memberMapper.getMemberByName(name);

// if (member == null) {
// // 조회된 member가 없을 경우 NoSuchElementException 예외를 던집니다.
// throw new NoSuchElementException("Not Found Member");
// }
// return member;
// }

// }
