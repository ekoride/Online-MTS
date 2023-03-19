import React from 'react'
import { useState, useEffect } from 'react';
import {Card, Table, Button, ButtonGroup} from 'react-bootstrap';
import axios from 'axios'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faSave,
  faPlusSquare,
  faUndo,
  faList,
  faEdit,
} from "@fortawesome/free-solid-svg-icons";
export default function Movies() {
    const [movies, setMovies] = useState([]);
    useEffect(() =>{
        getMovies()
    }, [])

    // add the api call here to fetch all the movies
    function getMovies(){
        axios.get("http://localhost:8080/getAllMovies")
            .then((response) => {
                setMovies(response.data)
            })

    }

    // upcoming movies
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
