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
    
  /*  @ManyToMany
    @JoinTable(name="FansFollowed",
    joinColumns= @JoinColumn(name="fan_id", referencedColumnName="userId"),
    inverseJoinColumns= @JoinColumn(name= "fan_id", referencedColumnName="userId"))
    @JsonIgnore
    private List<Fan> fansFollowed;
    
    @ManyToMany(mappedBy="fansFollowed")
    @JsonIgnore
    private List<Fan> fansFollowedByOtherFans;*/
    
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
	
	/*public List<Fan> getFansFollowed() {
		return fansFollowed;
	}

	public void setFansFollowed(List<Fan> fansFollowed) {
		this.fansFollowed = fansFollowed;
	}

	public List<Fan> getFansFollowedByOtherFans() {
		return fansFollowedByOtherFans;
	}

	public void setFansFollowedByOtherFans(List<Fan> fansFollowedByOtherFans) {
		this.fansFollowedByOtherFans = fansFollowedByOtherFans;
	}*/
	
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
		if(!actor.getActorFollowedByFans().contains(this)) {
			actor.getActorFollowedByFans().add(this);
		}	
	}

	public void followsCritic(Critic critic) {
		this.criticsFollowed.add(critic);
		if(!critic.getCriticsFollowedByFans().contains(this)) {
			critic.getCriticsFollowedByFans().add(this);
		}
		
	}

	/*public void followsFan(Fan fan) {
		this.fansFollowed.add(fan);
		if(!fan.getFansFollowedByOtherFans().contains(this)) {
			fan.getFansFollowedByOtherFans().add(this);
		}
		
	}*/
	
}
