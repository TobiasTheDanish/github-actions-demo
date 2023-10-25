package dat.sem3.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Hotel {
    @Id
    private Long id;

    @OneToMany(mappedBy = "hotel")
    private Set<Room> rooms = new HashSet<>();
}
