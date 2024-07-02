package org.koreait.Article.Controller;

import org.koreait.Article.entity.Article;
import org.koreait.Container;
import org.koreait.Util;

import static org.koreait.App.articles;

public class ArticleController {
    static Article foundArticle = null;

    public static void write() {
        System.out.println("==게시글 작성==");
        int id = articles.size() + 1;
        String regDate = Util.getNow();
        String updateDate = regDate;
        System.out.print("제목 : ");
        String title = Container.getScanner().nextLine();
        System.out.print("내용 : ");
        String body = Container.getScanner().nextLine();

        Article article = new Article(id, regDate, updateDate, title, body);
        articles.add(article);
        System.out.println(id + "번 글이 생성되었습니다");
    }


    public static void list(String cmd) {
        System.out.println("==게시글 목록==");
        int s= 3;
        if (articles.size() == 0) {
            System.out.println("아무것도 없어");
        } else {

            if (cmd.split(" ").length == 3) {System.out.println("검색어 : " + cmd.split(" ")[2]);s = 0;}
            System.out.println("  번호   /    날짜   /   제목   /   내용   ");


            for (int i = articles.size() - 1; i >= 0; i--) {
                int a = 0;
                if (cmd.split(" ").length == 3 && articles.get(i).getTitle().contains(cmd.split(" ")[2])) {
                    a = 1;
                    s = 1;
                }
                if (a == 0 && cmd.split(" ").length == 3) {
                    continue;
                }

                Article article = articles.get(i);
                if (Util.getNow().split(" ")[0].equals(article.getRegDate().split(" ")[0])) {
                    System.out.printf("  %d   /   %s      /   %s   /   %s  \n", article.getId(), article.getRegDate().split(" ")[1], article.getTitle(), article.getBody());
                } else {
                    System.out.printf("  %d   /   %s      /   %s   /   %s  \n", article.getId(), article.getRegDate().split(" ")[0], article.getTitle(), article.getBody());
                }
            }
            if (s == 0){
                System.out.println("검색결과가 없습니다.");
            }
        }
    }

    public static void detail(String cmd) {
        System.out.println("==게시글 상세보기==");

        int id = Integer.parseInt(cmd.split(" ")[2]);
        foundArticle = number(id);

        if (foundArticle == null) {
            System.out.println("해당 게시글은 없습니다");
            return;
        }
        System.out.println("번호 : " + foundArticle.getId());
        System.out.println("작성날짜 : " + foundArticle.getRegDate());
        System.out.println("수정날짜 : " + foundArticle.getUpdateDate());
        System.out.println("제목 : " + foundArticle.getTitle());
        System.out.println("내용 : " + foundArticle.getBody());
    }


    public static void delete(String cmd) {
        System.out.println("==게시글 삭제==");

        int id = Integer.parseInt(cmd.split(" ")[2]);
        foundArticle = number(id);

        if (foundArticle == null) {
            System.out.println("해당 게시글은 없습니다");
            return;
        }
        articles.remove(foundArticle);
        System.out.println(id + "번 게시글이 삭제되었습니다");
    }

    public static void modify(String cmd) {
        System.out.println("==게시글 수정==");

        int id = Integer.parseInt(cmd.split(" ")[2]);
        foundArticle = number(id);

        if (foundArticle == null) {
            System.out.println("해당 게시글은 없습니다");
            return;
        }
        System.out.println("기존 제목 : " + foundArticle.getTitle());
        System.out.println("기존 내용 : " + foundArticle.getBody());
        System.out.print("새 제목 : ");
        String newTitle = Container.getScanner().nextLine();
        System.out.print("새 내용 : ");
        String newBody = Container.getScanner().nextLine();

        foundArticle.setTitle(newTitle);
        foundArticle.setBody(newBody);
        foundArticle.setUpdateDate(Util.getNow());

        System.out.println(id + "번 게시글이 수정되었습니다");
    }

    static Article number(int id){
        Article foundArticle = null;
        for (Article article : articles) {
            if (article.getId() == id) {
                foundArticle = article;
                return foundArticle;
            }
        }

        return null;
    }
}


