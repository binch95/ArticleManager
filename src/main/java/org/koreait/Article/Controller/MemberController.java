package org.koreait.Article.Controller;

import org.koreait.App;
import org.koreait.Container;
import org.koreait.Article.entity.Member;
import org.koreait.Login;
import org.koreait.Util;

import java.util.Objects;

import static org.koreait.Login.sighUp;

public class MemberController {

    public static void sighup() {
        int pw = 1;
        String loginPw = "";
        System.out.println("== 회원가입 ==");
        int id = sighUp.size() + 1;
        String regDate = Util.getNow();
        System.out.print("Login ID : ");
        String loginId = Container.getScanner().nextLine();
        if ((int) sighUp.stream().filter(e -> e.getLoginId().equals(loginId)).count() == 1) {
            System.out.println("사용중인 ID입니다.");
            sighup();
            return;
        }
        while (pw == 1) {
            System.out.print("Login PW : ");
            loginPw = Container.getScanner().nextLine();
            System.out.print("verify PW : ");
            String pwCheck = Container.getScanner().nextLine();
            if (!loginPw.equals(pwCheck)) {
                System.out.println("비밀번호가 다릅니다 다시 입력해 주세요");
            } else {
                pw = 0;
            }
        }
        System.out.print("Your name : ");
        String name = Container.getScanner().nextLine();

        Member member = new Member(id, regDate, loginId, loginPw, name);
        sighUp.add(member);
        System.out.println(name + "님 회원 가입이 완료되었습니다.");

    }

    public static void join() {
        System.out.println("== Login ==");
        System.out.print("아이디 : ");
        String loGinid = Container.getScanner().nextLine();
        System.out.print("패스워드 : ");
        String loGinpw = Container.getScanner().nextLine();
        if(sighUp.stream().filter(e->e.getLoginId().equals(loGinid)).count() == 0){
            System.out.println("입력하신 아이디는 없습니다. 다시 확인해주세요");
            return;
        }
        Member loginIm = sighUp.stream().filter(e -> e.getLoginId().equals(loGinid)).toList().get(0);
        if (loginIm.getLoginId().equals(loGinid) && loginIm.getLoginpw().equals(loGinpw)) {
            System.out.println(loginIm.getName() + "님 로그인 되었습니다.");
            new App().run(loginIm.getName());
            Login.log = 1;
        } else {
            System.out.println("아이디 또는 패스워드를 확인해주세요");
        }

    }
}
