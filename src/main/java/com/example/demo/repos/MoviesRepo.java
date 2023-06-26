package com.example.demo.repos;

import com.example.demo.models.MoviesEntity;
import com.example.demo.util.MovieGenreSubtotalDto;
import com.example.demo.util.MoviesAndRatingsDto;
import com.example.demo.util.MoviesDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MoviesRepo extends JpaRepository<MoviesEntity, String> {
    @Query (value = "select tconst, primaryTitle, runtimeMinutes, genres from movies " +
            "order by runtimeMinutes desc " +
            "limit 10", nativeQuery = true)
    List<MoviesDto> findLongestRuntimeMovies();

    @Query (value = "select m.tconst, m.primaryTitle, m.runtimeMinutes, m.genres, r.averageRating " +
            "from movies as m inner join ratings as r " +
            "on m.tconst = r.tconst " +
            "where r.averageRating > 6.0 " +
            "order by r.averageRating", nativeQuery = true)
    List<MoviesAndRatingsDto> findMovieWithRatings();

    @Query (value="select m.genres, m.primaryTitle, SUM(r.numVotes) as numVotes\n" +
            "from movies as m \n" +
            "inner join \n" +
            "ratings as r \n" +
            "on m.tconst = r.tconst \n" +
            "group by m.genres, m.primaryTitle with rollup " +
            "having m.genres is not null;", nativeQuery = true)
    List<MovieGenreSubtotalDto> findMovieWithGenres();

    @Modifying
    @Query (value = "update movies \n" +
            "set runtimeMinutes = \n" +
            "case when genres = \"Documentary\" then runtimeMinutes+15\n" +
            "when genres = \"Animation\" then runtimeMinutes+30\n" +
            "else runtimeMinutes+45\n" +
            "end;", nativeQuery = true)
    void incrementMovies();
}
