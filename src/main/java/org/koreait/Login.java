package org.koreait;

import org.koreait.Article.Controller.MemberController;
import org.koreait.Article.entity.Article;
import org.koreait.Article.entity.Member;

import javax.management.ImmutableDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.koreait.App.sighUp;

public class Login {
    public static List<Member> sighUp = new ArrayList<>();
    static byte man = 1;

    public static void start() {
        makeTestMember();
        while (man == 1) {
            System.out.print("1.회원가입\n2.로그인\n명령어) ");
            String start = Container.getScanner().nextLine();
            while (true) {
                if (start.equals("1")) {
                    MemberController.sighup();
                    break;
                } else if (start.equals("2")) {
                    System.out.println("== Login ==");
                    System.out.print("아이디 : ");
                    String loGinid = Container.getScanner().nextLine();
                    System.out.print("패스워드 : ");
                    String loGinpw = Container.getScanner().nextLine();
                    if(sighUp.stream().filter(e->e.getLoginId().equals(loGinid)).count() == 0){
                        System.out.println("입력하신 아이디는 없습니다. 다시 확인해주세요");
                        continue;
                    }
                    Member loginIm = sighUp.stream().filter(e -> e.getLoginId().equals(loGinid)).toList().get(0);
                    if (loginIm.getLoginId().equals(loGinid) && loginIm.getLoginpw().equals(loGinpw)) {
                        System.out.println(loginIm.getName() + "님 로그인 되었습니다.");
                        new App().run();
                        break;
                    } else {
                        System.out.println("아이디 또는 패스워드를 확인해주세요");
                    }
                }
            }

        }
    }

    static void makeTestMember() {
        Member member = new Member(1, "2024-06-01 17:11:35", "qlscm", "123", "Hong");
        sighUp.add(member);
        member = new Member(2, "2024-06-30 14:11:35", "ghdqls", "1234", "bin");
        sighUp.add(member);
        member = new Member(3, "2024-07-02 10:11:35", "admin", "1235", "Jang");
        sighUp.add(member);
    }
}
