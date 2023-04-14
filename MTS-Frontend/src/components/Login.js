import React, { useState,  useEffect } from 'react'
import {Row, Col, Card, FormControl, Alert} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faSignInAlt,
  faUndo,
} from "@fortawesome/free-solid-svg-icons";
import { useSelector, useDispatch } from 'react-redux';
import { loginUser, userSelector, clearState, setLoggedIn } from '../features/user/userSlice';
import { useNavigate } from 'react-router-dom';

function Login() {
    let navigate = useNavigate();
    const dispatch = useDispatch();
    const { isFetching, isSuccess, isError, errorMessage } = useSelector(
        userSelector
      );

    const initialState = {
        email: "",
        password: "",
      };

    const [user, setUser] = useState(initialState)
    const [error, setError] = useState('')

    function resertLoginForm() {
        setUser(initialState)
    }

    function handleCredential(event){
        // object destructuring.
        // this shows, name for example if email field --> email
        const { name, value } = event.target;
        setUser({ ...user, [name]: value });
    }
    
    function validateUser(){
        dispatch(loginUser(user)); 
    }
    
    useEffect(() => {
        return () => {
          dispatch(clearState());
        };
      }, []);
      useEffect(() => {
        if (isError) {
          setError(errorMessage);
          dispatch(clearState());
        }
        if (isSuccess) {  
          dispatch(setLoggedIn())
          dispatch(clearState());
          navigate('/');
        }
      }, [isError, isSuccess]);
  return (
    <Row className="mt-5 justify-content-md-center">
        <Col xs={8}>
            {error && <Alert variant='danger'>{error}</Alert>}
            <Card >
                <Card.Header>
                    <FontAwesomeIcon icon={faSignInAlt} />Login
                </Card.Header>
                <Card.Body>
                
                    <Form.Group className='mb-3' >
                        <FormControl required autoComplete='off'
                            type="email" 
                            name='email'
                            value={user.email}
                            onChange = {handleCredential} 
                            placeholder="Enter Email Address" />
                    </Form.Group>
                    <Form.Group className='mb-3' >
                        <FormControl  required autoComplete='off'
                            type="password" 
                            name='password'
                            value={user.password}
                            onChange = {handleCredential} 
                            placeholder="Enter password" />
                    </Form.Group>
                </Card.Body>
                <Card.Footer style={{"text-align":"right"}}>
                    <Button size='sm' type='button' variant='success' onClick={validateUser} disabled={user.email.length === 0 || user.password.length === 0}>
                        <FontAwesomeIcon icon={faSignInAlt} />Login
                    </Button>{' '}
                    <Button size='sm' type='button' variant='info' disabled={user.email.length === 0 && user.password.length === 0} onClick={resertLoginForm}>
                    <FontAwesomeIcon icon={faUndo} />Reset
                    </Button>
                </Card.Footer>
            </Card>
        </Col>
    </Row>
  )
}



export default Login;