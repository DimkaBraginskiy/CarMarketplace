package org.example.carmarketplace.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String title;

    @Column(length=500, nullable = false)
    private String Description;

    @Column(length=5, nullable = false)
    private Integer Rating;

    @ManyToOne
    @JoinColumn(name = "written_by", referencedColumnName = "id")
    private User writtenBy;

    @ManyToOne
    @JoinColumn(name = "to_whom", referencedColumnName = "id")
    private User toWhom;


    public Feedback(String title, String description, int rating, User writtenBy, User toWhom) {
        this.title = title;
        Description = description;
        Rating = rating;
        this.writtenBy = writtenBy;
        this.toWhom = toWhom;
    }

    public Feedback() {
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return Description;
    }
    public int getRating() {
        return Rating;
    }
    public User getWrittenBy() {
        return writtenBy;
    }
    public User getToWhom() {
        return toWhom;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public void setRating(int rating) {
        Rating = rating;
    }
    public void setWrittenBy(User writtenBy) {
        this.writtenBy = writtenBy;
    }
    public void setToWhom(User toWhom) {
        this.toWhom = toWhom;
    }
}
