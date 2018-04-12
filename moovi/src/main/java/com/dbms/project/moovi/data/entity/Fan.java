package com.dbms.project.moovi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Fan extends User {

	private String fanDescription;

	@ManyToMany
	@JoinTable(name="ActorsFollowed",
			joinColumns= @JoinColumn(name="fan_id", referencedColumnName="userId"),
			inverseJoinColumns= @JoinColumn(name= "actor_id", referencedColumnName="actorId"))
	@JsonIgnore
	private List<Actor> actorsFollowed;

	@ManyToMany
	@JoinTable(name="CriticsFollowed",
			joinColumns= @JoinColumn(name="fan_id", referencedColumnName="userId"),
			inverseJoinColumns= @JoinColumn(name= "critic_id", referencedColumnName="userId"))
	@JsonIgnore
	private List<Critic> criticsFollowed;

	@ManyToMany
	@JoinTable(name="Likes",
			joinColumns= @JoinColumn(name="fan_id", referencedColumnName="userId"),
			inverseJoinColumns= @JoinColumn(name= "movie_id", referencedColumnName="movieId"))
	@JsonIgnore
	private List<Movie> likesMovies;

	@ManyToMany
	@JoinTable(name = "Dislikes",
			joinColumns = @JoinColumn(name = "fan_id", referencedColumnName = "userId"),
			inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "movieId"))
	@JsonIgnore
	private List<Movie> dislikesMovies;

	@ManyToMany
	@JoinTable(name = "FansFollowed",
			joinColumns = @JoinColumn(name = "userId1", referencedColumnName = "userId"))
	private List<Fan> followingFans;

	@ManyToMany(mappedBy = "followingFans")
	@JsonIgnore
	private List<Fan> follwedByFans;

	public Fan() {
		super();
	}

	public String getFanDescription() {
		return fanDescription;
	}

	public void setFanDescription(String fanDescription) {
		this.fanDescription = fanDescription;
	}

	public List<Actor> getActorsFollowed() {
		return actorsFollowed;
	}

	public void setActorsFollowed(List<Actor> actorsFollowed) {
		this.actorsFollowed = actorsFollowed;
	}

	public List<Critic> getCriticsFollowed() {
		return criticsFollowed;
	}

	public void setCriticsFollowed(List<Critic> criticsFollowed) {
		this.criticsFollowed = criticsFollowed;
	}

	public List<Movie> getLikesMovies() {
		return likesMovies;
	}

	public void setLikesMovies(List<Movie> likesMovies) {
		this.likesMovies = likesMovies;
	}

	public List<Movie> getDislikesMovies() {
		return dislikesMovies;
	}

	public void setDislikesMovies(List<Movie> dislikesMovies) {
		this.dislikesMovies = dislikesMovies;
	}

	public List<Fan> getFollowingFans() {
		return followingFans;
	}

	public void setFollowingFans(List<Fan> followingFans) {
		this.followingFans = followingFans;
	}

	public List<Fan> getFollwedByFans() {
		return follwedByFans;
	}

	public void setFollwedByFans(List<Fan> follwedByFans) {
		this.follwedByFans = follwedByFans;
	}

	public void likesMovie(Movie movie) {
		this.likesMovies.add(movie);
		if(!movie.getLikedByFans().contains(this)) {
			movie.getLikedByFans().add(this);
		}
	}

	public void dislikesMovie(Movie movie) {
		this.dislikesMovies.add(movie);
		if(!movie.getDislikedByFans().contains(this)) {
			movie.getDislikedByFans().add(this);
		}
	}

	public void followsActor(Actor actor) {
		this.actorsFollowed.add(actor);
		if(!actor.getFansFollowingActor().contains(this)) {
			actor.getFansFollowingActor().add(this);
		}
	}

	public void followsCritic(Critic critic) {
		this.criticsFollowed.add(critic);
		if(!critic.getFansFollowingCritics().contains(this)) {
			critic.getFansFollowingCritics().add(this);
		}
	}

	public void followsFan(Fan fan){
		this.getFollowingFans().add(fan);
	}
}
