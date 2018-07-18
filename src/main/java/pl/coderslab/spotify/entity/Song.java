package pl.coderslab.spotify.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;

    @ManyToOne
    private  Category category;


    @ManyToMany
    private List<Author> author;

    @OneToOne
    private Lyrics lyric;
    @ManyToOne
    private Album album;

}
