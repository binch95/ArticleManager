package org.koreait;


import org.koreait.Article.Controller.ArticleController;
import org.koreait.Article.Controller.MemberController;
import org.koreait.Article.entity.Article;
import org.koreait.Article.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class App {

        public static List<Article> articles = new ArrayList<>();
        public static List<Member> sighUp = new ArrayList<>();

        public static void run() {
            System.out.println("==프로그램 시작==");

            makeTestData();
            while (true) {
                System.out.print("명령어) ");
                String cmd = Container.getScanner().nextLine().trim();
                if (cmd.equals("")) {System.out.println("명령어를 입력해");}

                if (cmd.length() == 0) {
                    System.out.println("명령어를 입력하세요");
                    continue;
                }
                if (cmd.equals("exit")) {
                    Login.man = 0;
                    break;
                } else if (cmd.equals("logout")) {
                    break;
                }

                if (cmd.equals("article write")) {
                    ArticleController.write();


                } else if (cmd.startsWith("article list")) {
                    ArticleController.list(cmd);

                } else if (cmd.startsWith("article detail")) {
                    ArticleController.detail(cmd);

                } else if (cmd.startsWith("article delete")) {
                    ArticleController.delete(cmd);

                } else if (cmd.startsWith("article modify")) {
                    ArticleController.modify(cmd);

                } else if (cmd.equals("sighup")) {
                    MemberController.sighup();

                } else {
                    System.out.println("사용할 수 없는 명령어입니다");
                }

            }
            System.out.println("==프로그램 종료==");
            if(Login.man == 0){ Container.close();}

        }

        static void makeTestData() {
            Article article = new Article(1, "2024-06-01 17:11:35", "2024-07-02 20:14:35", "제목", "def");
            articles.add(article);
            article = new Article(2, "2024-06-30 14:11:35", "2024-07-01 17:14:35", "fff", "eee");
            articles.add(article);
            article = new Article(3, "2024-07-02 10:11:35", "2024-07-02 11:40:35", "제육볶음", "556");
            articles.add(article);
        }




}
