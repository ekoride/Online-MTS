import React,{useState, useEffect} from 'react'
import {Row, Col, Card, InputGroup, FormControl, Alert} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser, faUserPlus, faUndo, faEnvelope, faLock, faPhone, faCalendarDay, faAddressBook} from "@fortawesome/free-solid-svg-icons";
import moment from 'moment';
import { useSelector, useDispatch } from 'react-redux';
import { signupUser, userSelector, clearState, setLoggedIn} from '../features/user/userSlice';
import { useNavigate } from 'react-router-dom';

export default function Register() {
    let navigate = useNavigate();
    const dispatch = useDispatch();
    const inital_state = {
        name: '',
        email: '',
        password: '',
        mobile: '',
        dob: '',
        address: ''
    }
    const [error, setError] = useState('')
    const [user, setUser] = useState(inital_state)
    const { isFetching, isSuccess, isError, errorMessage } = useSelector(
      userSelector
    );
    function userChange(event){
        const name = event.target.name;
        let value = event.target.value;
        if(name === 'dob'){
          value = moment(value).format('yyyy-MM-dd')
        }
        setUser({
            ...user,
            [event.target.name]: event.target.value
        })
    }
    
    function resetRegisterForm(){
        setUser(inital_state)
    }
    
    function submitRegisterForm(){
      dispatch(signupUser(user));
    }

    useEffect(() => {
      return () => {
        dispatch(clearState())
      }
    }, [])
    
    useEffect(() => {
      if(isSuccess){
        dispatch(setLoggedIn())
        dispatch(clearState());
        navigate('/')
      }
      if(isError){
        setError(errorMessage);
        dispatch(clearState());
      }
    }, [isSuccess, isError])
  return (
      <Row className="mt-4 justify-content-md-center">
        <Col xs={7}>
        {error && <Alert variant='danger'>{error}</Alert>}
          <Card>
            <Card.Header>
              <FontAwesomeIcon icon={faUserPlus} /> Register
            </Card.Header>
            <Card.Body>
              
                <Form.Group className='mb-3' as={Col}>
                  <InputGroup>
                    
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faUser} />
                      </InputGroup.Text>
                    
                    <FormControl
                      autoComplete="off"
                      type="text"
                      name="name"
                      value={user.name}
                      onChange={userChange}
                      className={"bg-light text-black"}
                      placeholder="Enter Name"
                    />
                  </InputGroup>
                </Form.Group>
             
              
                <Form.Group className='mb-3' as={Col}>
                  <InputGroup>
                    
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faEnvelope} />
                      </InputGroup.Text>
                    
                    <FormControl
                      required
                      autoComplete="off"
                      type="text"
                      name="email"
                      value={user.email}
                      onChange={userChange}
                      className={"bg-light text-black"}
                      placeholder="Enter Email Address"
                    />
                  </InputGroup>
                </Form.Group>
             
              
                <Form.Group className='mb-3' as={Col}>
                  <InputGroup>
                    
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faLock} />
                      </InputGroup.Text>
                    
                    <FormControl
                      required
                      autoComplete="off"
                      type="password"
                      name="password"
                      value={user.password}
                      onChange={userChange}
                      className={"bg-light text-black"}
                      placeholder="Enter Password"
                    />
                  </InputGroup>
                </Form.Group>
             
              
                <Form.Group className='mb-3' as={Col}>
                  <InputGroup>
                    
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faPhone} />
                      </InputGroup.Text>
                    
                    <FormControl
                      autoComplete="off"
                      type="text"
                      name="mobile"
                      value={user.mobile}
                      onChange={userChange}
                      className={"bg-light text-black"}
                      placeholder="Enter Mobile Number"
                    />
                  </InputGroup>
                </Form.Group>

                <Form.Group className='mb-3' as={Col}>
                  <InputGroup>
                    
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faCalendarDay} />
                      </InputGroup.Text>
                    
                    <FormControl
                      autoComplete="off"
                      type="Date"
                      name="dob"
                      value={user.dob}
                      onChange={userChange}
                      className={"bg-light text-black"}
                      placeholder="Enter Date of Birth"
                    />
                  </InputGroup>
                </Form.Group>

                <Form.Group className='mb-3' as={Col}>
                  <InputGroup>
                    
                      <InputGroup.Text>
                        <FontAwesomeIcon icon={faAddressBook} />
                      </InputGroup.Text>
                    
                    <FormControl
                      required
                      autoComplete="off"
                      type="text"
                      name="address"
                      value={user.address}
                      onChange={userChange}
                      className={"bg-light text-black"}
                      placeholder="Enter Address"
                    />
                  </InputGroup>
                </Form.Group>

            </Card.Body>
            <Card.Footer style={{ textAlign: "right" }}>
              <Button
                size="sm"
                type="button"
                variant="success"
                onClick={submitRegisterForm}
                disabled={user.email.length === 0 || user.password.length === 0}
              >
                <FontAwesomeIcon icon={faUserPlus} /> Register
              </Button>{" "}
              <Button
                size="sm"
                type="button"
                variant="info"
                onClick={resetRegisterForm}
              >
                <FontAwesomeIcon icon={faUndo} /> Reset
              </Button>
            </Card.Footer>
          </Card>
        </Col>
      </Row>
    
  )
}
