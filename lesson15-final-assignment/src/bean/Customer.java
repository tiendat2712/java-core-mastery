package bean;

import enums.MemberTier;

import java.time.LocalDate;
import java.time.LocalDateTime;

/** Mutable data bean. Business validation belongs to the assignment implementation. */
public class Customer {
    private String id;
    private String fullName;
    private String email;
    private String city;
    private MemberTier tier;
    private LocalDate joinedAt;
    private LocalDateTime updatedAt;

    public Customer() {
    }

    public Customer(String id, String fullName, String email, String city,
                    MemberTier tier, LocalDate joinedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.city = city;
        this.tier = tier;
        this.joinedAt = joinedAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public MemberTier getTier() {
        return tier;
    }

    public void setTier(MemberTier tier) {
        this.tier = tier;
    }

    public LocalDate getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(LocalDate joinedAt) {
        this.joinedAt = joinedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", fullName=" + fullName + ", email=" + email
                + ", city=" + city + ", tier=" + tier + ", joinedAt=" + joinedAt
                + ", updatedAt=" + updatedAt + "}";
    }
}
