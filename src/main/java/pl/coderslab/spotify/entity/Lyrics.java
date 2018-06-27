package pl.coderslab.spotify.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Lyrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String songtext;
    @OneToOne
    private Song song;
}
