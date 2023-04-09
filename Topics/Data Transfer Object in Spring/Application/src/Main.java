import java.util.List;

class User {
    private long id;
    private String name;
    private String password;
    private List<Blog> blogs;

    public User() {
    }

    public User(long id, String name, String password, List<Blog> blogs) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.blogs = blogs;
    }

    //constructors, getters, and setters
}

class Blog {
    private long id;
    private String name;
    private User author;
    private String content;

    public Blog() {
    }

    public Blog(long id, String name, User author, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    //constructors, getters, and setters
}

//implement the record below

record BlogDTO (long id, String name, String authorName, String content) {

}