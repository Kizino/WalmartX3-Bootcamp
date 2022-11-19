package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static java.lang.Integer.parseInt;

@Controller
public class MovieController {

    @Autowired
    private BestMovieService bestMovieService;

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/")
    public String getIndexPage(){
        return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        Session  session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<MovieEntity> movies = session.createQuery("from MovieEntity").list();
        movies.sort(Comparator.comparing(movieEntity -> movieEntity.getVotes().size()));
        MovieEntity movieWithMostVotes = movies.get(movies.size() - 1);

        System.out.println(movies);
        System.out.println(movieWithMostVotes.getTitle());

        List<String> voterList = new ArrayList<>();
        for(VoteEntity vote: movieWithMostVotes.getVotes()){
            voterList.add(vote.getVoterName());
        }
        session.getTransaction().commit();
        model.addAttribute("BestMovie", movieWithMostVotes.getTitle());
        model.addAttribute("voterList", String.join(",", voterList));

        return "bestMovie";
    }

    @RequestMapping("/voteForBestMovieForm")
    public String showForm(Model model){
        Session session = sessionFactory.getCurrentSession();

//        List<MovieEntity> movieList = (List<MovieEntity>) session.get(MovieEntity.class);

        session.beginTransaction();
        List<MovieEntity> movieList = session.createQuery("from MovieEntity").list();
        session.getTransaction().commit();

        model.addAttribute("movies", movieList);
        return "voteForBestMovieForm";
    }

    @RequestMapping("/voteForBestMovie")
    public String processForm(HttpServletRequest request, Model model){
        String movieTitle = request.getParameter("movieName");
        String voterName = request.getParameter("voterName");
        int movieId = parseInt(request.getParameter("movieId"));

        VoteEntity vote = new VoteEntity();
        vote.setVoterName(voterName);
        System.out.println(vote);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        MovieEntity movie = (MovieEntity) session.get(MovieEntity.class, movieId);
        movie.addVote(vote);

        session.update(movie);
        session.getTransaction().commit();

        model.addAttribute("BestMovieVote", movie.getTitle());
        return "voteForBestMovie";
    }

    @RequestMapping("/addMovieForm")
    public String showMovieForm(){
        return "addMovie";
    }

    @RequestMapping("/addMovie")
    public String processAddMovie(HttpServletRequest request){
        String title = request.getParameter("movieTitle");
        String genre = request.getParameter("genre");
        String maturityRating = request.getParameter("maturityRating");

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(title);
        movieEntity.setGenre(genre);
        movieEntity.setMaturity_rating(maturityRating);
        System.out.println(movieEntity);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movieEntity);
        session.getTransaction().commit();

        System.out.println("Done!");

        return "addMovie";
    }

}
