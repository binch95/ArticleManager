package org.koreait.Article.Controller;

import org.koreait.Container;
import org.koreait.Article.entity.Member;
import org.koreait.Util;

import java.util.Objects;

import static org.koreait.App.sighUp;

public class MemberController {

    public static void sighup() {
        int pw = 1;
        String loginPw = "admin";
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
}
