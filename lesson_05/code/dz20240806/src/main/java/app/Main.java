package app;

import app.controller.FilmController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".app");
        FilmController controller = context.getBean(FilmController.class);
        System.out.println(controller.getAllFilms());

        System.out.println("------- Get film by ID ------------");
        System.out.println(controller.getFilmById(2L));
    }
}