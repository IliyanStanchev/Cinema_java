package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "age_restriction")
public class AgeRestriction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String restrictionName;

    private int minAge;

    public AgeRestriction() {
    }

    public AgeRestriction(String restrictionName, int minAge) {
        this.restrictionName = restrictionName;
        this.minAge = minAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestrictionName() {
        return restrictionName;
    }

    public void setRestrictionName(String restrictionName) {
        this.restrictionName = restrictionName;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgeRestriction)) return false;
        AgeRestriction that = (AgeRestriction) o;
        return getId() == that.getId() && getMinAge() == that.getMinAge() && Objects.equals(getRestrictionName(), that.getRestrictionName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRestrictionName(), getMinAge());
    }
}
