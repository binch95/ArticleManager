package org.koreait;

import org.koreait.Article.Controller.MemberController;
import org.koreait.Article.entity.Article;
import org.koreait.Article.entity.Member;

import javax.management.ImmutableDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Login {
    public static List<Member> sighUp = new ArrayList<>();
    static String man = "";
    public static byte log = 0;

    public static void start() {
        makeTestMember();
        while (man.equals("")) {
            System.out.print("==ArticleManager==\n1.회원가입\n2.로그인\n3.게스트모드\n명령어) ");
            String start = Container.getScanner().nextLine();
            if (start.equals("exit")) {
                System.out.println("==프로그램 종료==");
                break;
            }
            while (log == 0) {
                if (start.equals("1")) {
                    MemberController.sighup();
                    break;
                } else if (start.equals("2")) {
                    MemberController.join();

                } else if (start.equals("3")) {
                    new App().run("");
                    break;
                }else {
                    System.out.println("잘못된 명령어");
                    break;
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
