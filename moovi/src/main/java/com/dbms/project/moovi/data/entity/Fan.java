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
	private List<Fan> followedByFans;

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

	public List<Fan> getFollowedByFans() {
		return followedByFans;
	}

	public void setFollowedByFans(List<Fan> followedByFans) {
		this.followedByFans = followedByFans;
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

	public void set(Fan newFan) {
		this.firstName = newFan.firstName != null? 
				newFan.firstName : this.firstName;
		this.lastName = newFan.lastName != null? 
				newFan.lastName : this.lastName;
		this.username = newFan.username != null? 
				newFan.username : this.username;
		this.password = newFan.password != null? 
				newFan.password : this.password;
		this.email = newFan.email != null? 
				newFan.email : this.email;
		this.dob = newFan.dob != null? 
				newFan.dob : this.dob;
		this.userAddresses = newFan.userAddresses != null? 
				newFan.userAddresses : this.userAddresses;
		this.userPhoneNumbers = newFan.userPhoneNumbers != null? 
				newFan.userPhoneNumbers : this.userPhoneNumbers;	
		this.fanDescription = newFan.fanDescription != null? 
				newFan.fanDescription : this.fanDescription;
		this.actorsFollowed = newFan.actorsFollowed != null? 
				newFan.actorsFollowed : this.actorsFollowed;
		this.criticsFollowed = newFan.criticsFollowed != null? 
				newFan.criticsFollowed : this.criticsFollowed;
		this.likesMovies = newFan.likesMovies != null? 
				newFan.likesMovies : this.likesMovies;
		this.dislikesMovies = newFan.dislikesMovies != null? 
				newFan.dislikesMovies : this.dislikesMovies;
		this.followingFans = newFan.followingFans != null? 
				newFan.followingFans : this.followingFans;
		this.followedByFans = newFan.followedByFans != null? 
				newFan.followedByFans : this.followedByFans;
	}
}
