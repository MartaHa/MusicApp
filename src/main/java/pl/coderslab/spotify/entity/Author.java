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
    @Transient
    private String fullName;

    public String getFullName() {
        return name + " " + surname;
    }


    @ManyToMany
    private List<Song> songs;

    //SelectCorrection
    public boolean isSelected(Integer authorId){
        if (authorId != null) {
            return authorId.equals(id);
        }
        return false;
    }



}
