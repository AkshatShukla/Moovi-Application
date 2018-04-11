package com.dbms.project.moovi.data.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Critic extends User{

    private String criticDescription;

    private String websiteUrl;
    
    @ManyToMany
    @JoinTable(name="Recommend",
    joinColumns= @JoinColumn(name="critic_id", referencedColumnName="userId"),
    inverseJoinColumns= @JoinColumn(name= "movie_id", referencedColumnName="movieId"))
    @JsonIgnore
    private List<Movie> recommendedMovies;
    
    @ManyToMany(mappedBy="criticsFollowed")
    @JsonIgnore
    private List<Fan> criticsFollowedByFans;

    @OneToMany(mappedBy = "critic")
    @JsonIgnore
    private List<Review> reviewedMovie;

    public Critic() {
        super();
    }

    public List<Fan> getCriticsFollowedByFans() {
        return criticsFollowedByFans;
    }

    public void setCriticsFollowedByFans(List<Fan> followedByFans) {
        this.criticsFollowedByFans = followedByFans;
    }

    public List<Movie> getRecommendedMovies() {
        return recommendedMovies;
    }

    public void setRecommendedMovies(List<Movie> recommendedMovies) {
        this.recommendedMovies = recommendedMovies;
    }

    public String getCriticDescription() {
        return criticDescription;
    }

    public void setCriticDescription(String criticDescription) {
        this.criticDescription = criticDescription;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<Review> getReviewedMovie() {
        return reviewedMovie;
    }

    public void setReviewedMovie(List<Review> reviewedMovie) {
        this.reviewedMovie = reviewedMovie;
    }

    public void recommends(Movie movie) {
		this.recommendedMovies.add(movie);
		if(!movie.getRecommendedBy().contains(this)) {
			movie.getRecommendedBy().add(this);
		}
	}

	public void reviews(Review review){
        this.getReviewedMovie().add(review);
        if(review.getCritic()!= this) {
            review.setCritic(this);
        }
    }
}
