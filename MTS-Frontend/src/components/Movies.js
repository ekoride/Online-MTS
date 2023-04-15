import React from 'react'
import { useState, useEffect } from 'react';
import {Card, Table, Button, ButtonGroup} from 'react-bootstrap';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faList } from "@fortawesome/free-solid-svg-icons";
import { useSelector, useDispatch } from 'react-redux';
import { getMovies, movieSelector, clearState } from '../features/movies/movieSlice';

export default function Movies() {
    const [movies, setMovies] = useState([]);
    const dispatch = useDispatch();
    const [error, setError] = useState('')
    const { isSuccess, isError, errorMessage, movieArray } = useSelector(
        movieSelector
      );
    
    useEffect(() =>{
        dispatch(getMovies())
        setMovies(movieArray) 
    }, [isSuccess])

    useEffect(() => {
        if (isError) {
          setError(errorMessage);
          dispatch(clearState());
        }
      }, [isError, isSuccess]);

  return (
    <Card className='mt-5 border border-light bg-light text-black'>
        <Card.Header><FontAwesomeIcon icon={faList} /> Movies</Card.Header>
        <Card.Body>
            <Table striped>
                <thead>
                    <tr>
                    <th>#</th>
                    <th>Movie Name</th>
                    <th>Genre</th>
                    <th>Language</th>
                    <th>Rating</th>
                    <th>Release Date</th>
                    <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                        {movies.length === 0 ?
                            <tr align="center">
                                <td colSpan='7'>{movies.length} No Movies available</td>
                            </tr> :
                            movies.map((movie, count) => (
                                <tr key={movie.id}>
                                    <td>{count+1}</td>
                                    <td>{movie.movieName}</td>
                                    <td>{movie.movieGenre}</td>
                                    <td>{movie.movieLanguage}</td>
                                    <td>{movie.movieRating}</td>
                                    <td>{movie.movieReleaseDate}</td>
                                    <td> 
                                        <ButtonGroup>
                                            <Button size='sm' variant='outline-primary'>
                                                View
                                            </Button>{' '}
                                        </ButtonGroup>
                                    </td>
                                </tr>
                            ))
                    }
                </tbody>
            </Table>
        </Card.Body>
    </Card>
  )
}
