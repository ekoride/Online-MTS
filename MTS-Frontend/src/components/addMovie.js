import React from 'react'
import { useState } from 'react';
import {Card, Spinner} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import axios from 'axios'
import moment from 'moment';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faSave,
  faPlusSquare,
  faUndo,
  faList,
  faEdit,
} from "@fortawesome/free-solid-svg-icons";
export default function AddMovie() {
    const inital_state = {
        movie_name:'',
        movie_cast: '',
        movie_rating: '',
        movie_genre: '',
        movie_language: '',
        description: '',
        release_date: '',
        duration: '',
        movie_end_date: ''
    }
    const [formData, setFormData] = useState(inital_state)

   /* Add this spinner logic to the code, to make the entire site neater.
   function submitMovie(event) {
  event.preventDefault();

  const movie = {
    movieName: formData.movie_name,
    movieCast: formData.movie_cast,
    movieRating: formData.movie_rating,
    movieGenre: formData.movie_genre,
    movieLanguage: formData.movie_language,
    movieDescription: formData.description,
    movieReleaseDate: formData.release_date,
    movieDurationMin: formData.duration,
    movieEndDate: formData.movie_end_date,
  };

  setFormData((prevState) => ({ ...prevState, loading: true }));

  axios
    .post("http://localhost:8080/addNewMovie", movie)
    .then((response) => {
      if (response.data != null) {
        console.log(response);
        setFormData(inital_state);
        alert("Movie saved successfully");
      }
    })
    .catch((error) => {
      console.log(error);
      alert("An error occurred while saving the movie.");
    })
    .finally(() => {
      setFormData((prevState) => ({ ...prevState, loading: false }));
    });
}
{formData.loading && (
  <div className="text-center my-3">
    <Spinner animation="border" role="status">
      <span className="visually-hidden">Loading...</span>
    </Spinner>
  </div>
)}

   */ 

    function submitMovie(event) {
        event.preventDefault();

        const movie = {
            movieName:formData.movie_name,
            movieCast: formData.movie_cast,
            movieRating: formData.movie_rating,
            movieGenre: formData.movie_genre,
            movieLanguage: formData.movie_language,
            movieDescription: formData.description,
            movieReleaseDate: formData.release_date,
            movieDurationMin: formData.duration,
            movieEndDate: formData.movie_end_date
        }
        console.log(movie)
        axios.post("http://localhost:8080/addNewMovie", movie)
            .then(response => {
                if(response.data != null){
                    console.log(response)
                    setFormData(inital_state)
                    alert("Movie saved successfully")
                }
            })
    }

    function movieChange(event){
        const name = event.target.name;
        let value = event.target.value;
        if(name === 'release_date' || name === 'movie_end_date'){
            value = moment(value).format('yyyy-MM-dd')
        }
        setFormData({
            ...formData,
            [event.target.name]: event.target.value
        })
    }
    function resetMovie(){
        setFormData(inital_state)
    }
  return (
    <Card className='mt-5 border border-light bg-light text-black'>
        <Card.Header><FontAwesomeIcon icon={faPlusSquare} /> Add Movie</Card.Header>
        <Form onReset={resetMovie} onSubmit={ submitMovie} id="movieForm">
        <Card.Body>
                
                    <Form.Group className="mb-3" controlId='formMovieName'>
                        <Form.Label>Movie Name</Form.Label>
                        <Form.Control required autoComplete='off'
                            type="text" 
                            name='movie_name'
                            value={formData.movie_name}
                            onChange = {movieChange} 
                            placeholder="movie name" />
                        
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieCast'>
                        <Form.Label>Movie Cast</Form.Label>
                        <Form.Control  autoComplete='off'
                            type="text" 
                            name='movie_cast' 
                            value={formData.movie_cast}
                            onChange = {movieChange} 
                            placeholder="Cast" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieRating'>
                        <Form.Label>Movie Rating</Form.Label>
                        <Form.Control autoComplete='off'
                            type="text" 
                            name='movie_rating'
                            value={formData.movie_rating}
                            onChange = {movieChange}  
                            placeholder="Rating" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieGenre'>
                        <Form.Label>Movie Genre</Form.Label>
                        <Form.Control required autoComplete='off'
                            type="text" 
                            name='movie_genre'
                            value={formData.movie_genre}
                            onChange = {movieChange}  
                            placeholder="Genre" />
                    </Form.Group>
                
                    <Form.Group className="mb-3" controlId='formMovieLanguage'>
                        <Form.Label>Movie Language</Form.Label>
                        <Form.Control required autoComplete='off'
                            type="text" 
                            name='movie_language'
                            value={formData.movie_language}
                            onChange = {movieChange}  
                            placeholder="Language" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieDescription'>
                        <Form.Label>Movie Description</Form.Label>
                        <Form.Control autoComplete='off'
                            type="text" 
                            name='description'
                            value={formData.description}
                            onChange = {movieChange}  
                            placeholder="description" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieReleaseDate'>
                        <Form.Label>Movie Release Date</Form.Label>
                        <Form.Control required autoComplete='off'
                            type="date" 
                            name='release_date'
                            value={formData.release_date}
                            onChange = {movieChange}   
                            placeholder="Release Date" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieDuration'>
                        <Form.Label>Movie Duration</Form.Label>
                        <Form.Control required autoComplete='off'
                            type="text" 
                            name='duration' 
                            value={formData.duration}
                            onChange = {movieChange} 
                            placeholder="Duration" />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId='formMovieEndDate'>
                        <Form.Label>Movie End Date</Form.Label>
                        <Form.Control required autoComplete='off'
                            type="date" 
                            name='movie_end_date' 
                            value={formData.movie_end_date}
                            onChange = {movieChange}  
                            placeholder="End Date" />
                    </Form.Group>
                

                {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
                    <Form.Check type="checkbox" label="Check me out" />
                </Form.Group> */}
                
            </Card.Body>
            <Card.Footer>
                <Button size="sm" variant="success" type="submit">
                    <FontAwesomeIcon icon={faSave} /> Save
                </Button>{' '}
                <Button size="sm" variant="info" type="reset">
                    <FontAwesomeIcon icon={faUndo} /> Reset
                </Button>
            </Card.Footer>
        </Form>
    </Card>
  )
}
