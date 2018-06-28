package pl.coderslab.spotify.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String fullName;

    public void setFullName(String fullName) {
        this.fullName = this.name + this.surname;
    }

    @ManyToMany
    private List<Song> songs;

}
