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

    private String restrictionText;

    private String restrictionImageUrl;

    private int minAge;

    public AgeRestriction() {
    }

    public AgeRestriction(String restrictionText, String restrictionImageUrl, int minAge) {
        this.restrictionText = restrictionText;
        this.restrictionImageUrl = restrictionImageUrl;
        this.minAge = minAge;
    }

    public String getRestrictionText() {
        return restrictionText;
    }

    public void setRestrictionText(String restrictionText) {
        this.restrictionText = restrictionText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestrictionImageUrl() {
        return restrictionImageUrl;
    }

    public void setRestrictionImageUrl(String restrictionImageUrl) {
        this.restrictionImageUrl = restrictionImageUrl;
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
        return getId() == that.getId() && getMinAge() == that.getMinAge() && Objects.equals(getRestrictionImageUrl(), that.getRestrictionImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRestrictionImageUrl(), getMinAge());
    }
}
