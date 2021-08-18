package todoapp.model;

import javax.persistence.*;

@Entity
@Table(name = "the_thing")
public class TheThing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_thing_seq")
    @SequenceGenerator(name = "the_thing_seq", allocationSize = 1)
    private Long id;

    @Column(name = "thing")
    private String thing;

    @Column(name = "is_done")
    private boolean checkIfDone = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public boolean isCheckIfDone() {
        return checkIfDone;
    }

    public void setCheckIfDone(boolean checkIfDone) {
        this.checkIfDone = checkIfDone;
    }
}
