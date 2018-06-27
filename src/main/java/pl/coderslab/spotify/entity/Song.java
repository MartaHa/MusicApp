package pl.coderslab.spotify.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int rating;

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Author> author;

    @OneToOne
    private Lyrics lyric;
    @ManyToOne
    private Album album;

}
