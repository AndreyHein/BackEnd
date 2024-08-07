package app.entity;

public class Film {
    private Long id;
    private String title;
    private String director;
    private int year;
    private String genre;

    public Film(Long id, String title, String director, int year, String genre) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
