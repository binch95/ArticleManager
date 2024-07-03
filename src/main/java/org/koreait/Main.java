package org.koreait;

import org.koreait.Article.Controller.ArticleController;
import org.koreait.Article.Controller.MemberController;
import org.koreait.Article.entity.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        Container.init();
        Login.start();
     //   new App().run();
        Container.close();
    }
}





